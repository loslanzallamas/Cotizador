/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holistart;

import DBSistema.Movstk;
import DBSistema.MovstkPK;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import javax.ejb.Timer;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrador
 */
@Stateless
public class timerControlBean implements timerControlRemote, timerControlLocal {

    @PersistenceContext
    private EntityManager em;
    @Resource
    javax.ejb.TimerService temporizador;

    public void startTemporizador() {
        temporizador.createTimer(5000, 10000000, "temporizador");
    }

    @Timeout
    public void timeOutControl(Timer temporizador) {

        Date fecha = new Date();
        System.out.println("Nuevo " + fecha);

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ResultSet rs3 = null;


        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            conn = DriverManager.getConnection("jdbc:odbc:Tractoagro");
            stat = conn.createStatement();

            Integer registros;
            Integer cant = 10;
            do {
                registros = 0;

                /*
                 * Retorna los últimos "cant" registros de la tabla itfact del sistema.
                 * Si la cantidad de registros devueltos es igual a los pedidos vuelve a solicitar
                 * "cant" + 10 hasta que la cantidad de registros devueltos sea menor a los pedidos.
                 */
                rs = stat.executeQuery("SELECT TOP " + cant + " itfact.TC_CODIGO, itfact.SU_CODIGO, itfact.FA_CODIGO, itfact.IFA_CODIGO, itfact.AR_CODIGO,itfact.IFA_CLAVEA, itfact.FA_FECHA, itfact.AR_CODIGO, itfact.IFA_CANTID,itfact.Depcod " +
                        "FROM itfact " +
                        "WHERE ((itfact.TC_CODIGO)=1 Or (itfact.TC_CODIGO)=3 Or (itfact.TC_CODIGO)=33) " +
                        "ORDER BY itfact.FA_FECHA DESC , itfact.IFA_CLAVEA DESC");

                while (rs.next()) {

                    Movstk movstk = em.find(Movstk.class ,new MovstkPK(rs.getInt("TC_CODIGO"), rs.getInt("SU_CODIGO"), rs.getInt("FA_CODIGO"), rs.getInt("IFA_CODIGO")));

                    if(movstk != null){
                    if (rs.getString("IFA_CLAVEA").equals(movstk.getIfaClavea()) && rs.getInt("IFA_CODIGO") == movstk.getMovstkPK().getIfaCodigo()) {
                    } else {
                        /*
                         * Crea un nuevo objeto para el registro, usando como clave los campos
                         *  tc_codigo = código del tipo de comprobante (1:factura, 3y33: N. de Crédito)
                         *  su_codigo = código de la sucursal
                         *  fa_codigo = nro de comprobante
                         *  ifa_codigo = identificador del ítem en el detalle del comprobante
                         */
                        Movstk movStk = new Movstk(rs.getInt("tc_codigo"), rs.getInt("su_codigo"), rs.getInt("fa_codigo"), rs.getInt("ifa_codigo"));
                        movStk.setFaFecha(rs.getDate("fa_fecha"));
                        movStk.setIfaClavea(rs.getString("ifa_clavea"));

                        /*
                         * Verifica la existencia del depósito
                         */
                        rs2 = stat.executeQuery("SELECT * FROM deposito WHERE depcod=" + rs.getInt("depcod"));

                        if (rs2.next()) {

                            Double adevta;
                            /*
                             * Si es venta o devolución
                             */
                            if (rs.getInt("tc_codigo") == 1) {
                                adevta = rs.getDouble("ifa_cantid") * -1;
                            } else {
                                adevta = rs.getDouble("ifa_cantid");
                            }

                            /*
                             * Comprueba si el artículo está relacionado con el depòsito
                             */
                            rs3 = stat.executeQuery("SELECT * FROM artdep WHERE depcod = " + rs.getInt("depcod") + " AND ar_codigo=" + rs.getString("ar_codigo"));
                            if (rs3.next()) {
                                /*
                                 * Si está relacionado actualiza el depòsito
                                 */
                                stat.executeUpdate("UPDATE SET adevta = adevta+" + adevta + " FROM artdep WHERE depcod = " + rs.getInt("depcod") + " AND ar_codigo=" + rs.getString("ar_codigo"));
                            } else {
                                /*
                                 * Si no está relacionado agrega la relación
                                 */
                                stat.executeUpdate("INSERT INTO artdep VALUES('" + rs.getString("ar_codigo") + "'," + rs.getInt("depcod") + ",0," + adevta + ",0," + new Date() + ")");
                            }

                        }

                        em.persist(movStk);
                    }
                    }
                    registros = registros + 1;
                }

                cant = cant + 10;

            } while (registros == cant - 10);
            System.out.println("Paso");

        /*
         * Recorre los registros devueltos.
         *   1- verifica si existe el depósito
         *   2- verifica si el articulo está relacionado con el depósito
         *      2a- Si está relacionado lo actualiza
         *      2b- Si no está relacionado: agrega el registro
         */

        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException ex) {
                ex.getMessage();
            }

            try {
                if (stat != null) {
                    stat.close();
                }

            } catch (SQLException ex) {
                ex.getMessage();
            }

            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                ex.getMessage();
            }
        }
    }

    public void persist(Object object) {
        em.persist(object);
    }
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method" or "Web Service > Add Operation")
}
