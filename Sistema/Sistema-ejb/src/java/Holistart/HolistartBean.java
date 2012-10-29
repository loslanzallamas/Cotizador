/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Holistart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Administrador
 */
@Stateless
public class HolistartBean implements HolistartRemote, HolistartLocal {

    public List<CpraFacturas> listarCompCpra(String strConn, String strSQL, String strTipo) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(strConn);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(strSQL);

            List<CpraFacturas> cpraFacturas = new LinkedList<CpraFacturas>();

            if (rs.next()) {

                do {
                    CpraFacturas cpraFactura = new CpraFacturas();
                    cpraFactura.setTcp_codigo(rs.getInt("Tcp_codigo"));
                    cpraFactura.setFp_succod(rs.getInt("Fp_succod"));
                    cpraFactura.setFp_codigo(rs.getInt("Fp_codigo"));
                    cpraFactura.setFp_fecha(rs.getDate("Fp_fecha"));
                    cpraFactura.setPr_codigo(rs.getInt("Pr_codigo"));
                    cpraFactura.setFp_nombre(rs.getString("Fp_nombre"));
                    cpraFactura.setFp_saldada(rs.getString("Fp_saldada"));
                    cpraFactura.setComp_Tipo(strTipo);
                    cpraFactura.getCpraFacturasDet().setAr_codigo(rs.getString("Ar_codigo"));
                    cpraFactura.getCpraFacturasDet().setIfps_descr(rs.getString("Ifps_descr"));
                    cpraFactura.getCpraFacturasDet().setIfps_canti(rs.getDouble("Ifps_canti"));
                    cpraFactura.getCpraFacturasDet().setIfps_unine(rs.getDouble("Ifps_unine"));
                    cpraFactura.getCpraFacturasDet().setIfps_bonif(rs.getDouble("Ifps_bonif"));
                    cpraFactura.getCpraFacturasDet().setIfps_conco(rs.getInt("Ifps_conco"));

                    cpraFacturas.add(cpraFactura);

                } while (rs.next());

                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }

                return cpraFacturas;
            }
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return null;
    }

    public List<CpraFacturas> listarCompCpraporArticulo(String codArticulo) {
        try {

            String strTipo;
            String strSQL;
            String strConn;
            List<CpraFacturas> cpraFacturas = new LinkedList<CpraFacturas>();

            /*
             * Traer comp. vta SIS
             */
            try {
                strTipo = "SIS";
                strSQL = "SELECT * FROM facpro LEFT JOIN factupro ON facpro.tcp_codigo=factupro.tcp_codigo AND facpro.fp_succod=factupro.fp_succod AND facpro.fp_codigo=factupro.fp_codigo WHERE (facpro.tcp_codigo=1 OR facpro.tcp_codigo=33 OR facpro.tcp_codigo=3) AND fp_impresa='I' AND ar_codigo='" + codArticulo + "' ORDER BY facpro.fp_fecha DESC";
                strConn = "jdbc:odbc:Tractoagro";
                cpraFacturas.addAll(listarCompCpra(strConn, strSQL, strTipo));
            } catch (Exception e) {
                e.getMessage();
            }

            /*
             * Traer comp. vta ALT
             */
            try {
                strTipo = "ALT";
                strSQL = "SELECT * FROM facpro LEFT JOIN factupro ON facpro.tcp_codigo=factupro.tcp_codigo AND facpro.fp_succod=factupro.fp_succod AND facpro.fp_codigo=factupro.fp_codigo WHERE (facpro.tcp_codigo=1 OR facpro.tcp_codigo=33 OR facpro.tcp_codigo=3) AND fp_impresa='I' AND ar_codigo='" + codArticulo + "' ORDER BY facpro.fp_fecha DESC";
                strConn = "jdbc:odbc:Alt";
                cpraFacturas.addAll(listarCompCpra(strConn, strSQL, strTipo));
            } catch (Exception e) {
                e.getMessage();
            }

            return cpraFacturas;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return null;

    }

    public List<VtaFacturas> listarCompVta(String strConn, String strSQL, String strTipo) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(strConn);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(strSQL);

            List<VtaFacturas> vtaFacturas = new LinkedList<VtaFacturas>();

            if (rs.next()) {

                do {
                    VtaFacturas vtaFactura = new VtaFacturas();
                    vtaFactura.setComp_tipo(rs.getInt("Tc_codigo"));
                    vtaFactura.setComp_suc(rs.getInt("Su_codigo"));
                    vtaFactura.setComp_Nro(rs.getInt("Fa_codigo"));
                    vtaFactura.setComp_Fecha(rs.getDate("Fa_fecha"));
                    vtaFactura.setComp_Clcod(rs.getInt("Cl_codigo"));
                    vtaFactura.setComp_Clnom(rs.getString("Fa_cliente"));
                    vtaFactura.setComp_Saldada(rs.getString("Fa_saldada"));
                    vtaFactura.setComp_ImpCanc(rs.getDouble("Fa_imp_can"));
                    vtaFactura.setComp_Imp(rs.getString("Fa_impresa"));
                    vtaFactura.setComp_Total(rs.getDouble("Fa_total"));
                    vtaFactura.setComp_Subtotal(rs.getDouble("Fa_subtota"));
                    vtaFactura.setComp_IVA(rs.getDouble("Fa_iva"));
                    vtaFactura.setComp_Dcto(rs.getDouble("Fa_dto"));
                    vtaFactura.setComp_Vdcod(rs.getInt("Fa_vendcod"));
                    vtaFactura.setComp_Otros1(rs.getString("Fa_otros1"));
                    vtaFactura.setComp_ZonaCod(rs.getString("Fa_zo_codi"));
                    vtaFactura.setComp_PorDcto(rs.getDouble("Fa_p_dto"));
                    vtaFactura.setComp_Operador(rs.getInt("Fa_opecod"));
                    vtaFactura.setComp_Tipo(strTipo);
                    vtaFactura.getVtaFacturasDet().setArCodigo(rs.getString("ar_codigo"));
                    vtaFactura.getVtaFacturasDet().setIfaDescri(rs.getString("ifa_descri"));
                    vtaFactura.getVtaFacturasDet().setIfaCantid(rs.getDouble("ifa_cantid"));
                    vtaFactura.getVtaFacturasDet().setIfaUnipre(rs.getDouble("ifa_unipre"));

                    vtaFacturas.add(vtaFactura);

                } while (rs.next());

                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }

                return vtaFacturas;
            }
        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return null;
    }

    public List<VtaFacturas> listarFacturasporArticulo(String codArticulo) {
        try {

            String strTipo;
            String strSQL;
            String strConn;
            List<VtaFacturas> vtaFacturas = new LinkedList<VtaFacturas>();

            /*
             * Traer comp. vta SIS
             */
            try {
                strTipo = "SIS";
                strSQL = "SELECT * FROM facturas LEFT JOIN itfact ON facturas.tc_codigo=itfact.tc_codigo AND facturas.su_codigo=itfact.su_codigo AND facturas.fa_codigo=itfact.fa_codigo WHERE (facturas.tc_codigo=1 OR facturas.tc_codigo=33 OR facturas.tc_codigo=3) AND fa_impresa='I' AND ar_codigo='" + codArticulo + "' ORDER BY facturas.Fa_fecha DESC";
                strConn = "jdbc:odbc:Tractoagro";
                vtaFacturas.addAll(listarCompVta(strConn, strSQL, strTipo));
            } catch (Exception e) {
                e.getMessage();
                e.getStackTrace();
            }

            /*
             * Traer comp. vta ALT
             */
            try {
                strTipo = "ALT";
                strSQL = "SELECT * FROM facturas LEFT JOIN itfact ON facturas.tc_codigo=itfact.tc_codigo AND facturas.su_codigo=itfact.su_codigo AND facturas.fa_codigo=itfact.fa_codigo WHERE (facturas.tc_codigo=1 OR facturas.tc_codigo=33 OR facturas.tc_codigo=3) AND fa_impresa='I' AND ar_codigo='" + codArticulo + "' ORDER BY facturas.Fa_fecha DESC";
                strConn = "jdbc:odbc:Alt";
                vtaFacturas.addAll(listarCompVta(strConn, strSQL, strTipo));
            } catch (Exception e) {
                e.getMessage();
                e.getStackTrace();
            }

            return vtaFacturas;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return null;

    }

    public List<VtaFacturas> listarFacturasporCliente(Integer codCliente) {
        try {

            String strTipo;
            String strSQL;
            String strConn;
            List<VtaFacturas> vtaFacturas = new LinkedList<VtaFacturas>();

            /*
             * Traer comp. vta SIS
             */
            strTipo = "SIS";
            strSQL = "SELECT * FROM facturas WHERE cl_codigo=" + codCliente;
            strConn = "jdbc:odbc:Tractoagro";
            vtaFacturas.addAll(listarCompVta(strConn, strSQL, strTipo));

            /*
             * Traer comp. vta ALT
             */
            strTipo = "ALT";
            strSQL = "SELECT * FROM facturas WHERE cl_codigo=" + codCliente;
            strConn = "jdbc:odbc:Alt";
            vtaFacturas.addAll(listarCompVta(strConn, strSQL, strTipo));

            return vtaFacturas;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }
        return null;
    }

    public List<EntComerciales> listarClientes(String nom) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:Tractoagro");
            Statement stat = conn.createStatement();
            String sql = "SELECT TOP 10 * FROM clientes WHERE Cl_nombre LIKE '%" + nom + "%' ORDER BY Cl_nombre";
            ResultSet rs = stat.executeQuery(
                    sql);

            List<EntComerciales> entComercialeses = new LinkedList<EntComerciales>();

            if (rs.next()) {

                do {
                    EntComerciales entComerciales = new EntComerciales();
                    entComerciales.setCl_Activo(rs.getString("Cl_activo"));
                    entComerciales.setCl_Cod(rs.getInt("Cl_codigo"));
                    entComerciales.setCl_Domicilio(rs.getString("Cl_domici"));
                    entComerciales.setCl_LocCod(rs.getInt("Loccod"));
                    entComerciales.setCl_Nombre(rs.getString("Cl_nombre"));
                    entComerciales.setCl_Telefono(rs.getString("Cl_telefon"));
                    entComerciales.setCl_VendCodigo(rs.getInt("ve_codigo"));
                    entComerciales.setCl_ZoCodigo(rs.getInt("Zo_codigo"));

                    entComercialeses.add(
                            entComerciales);

                } while (rs.next());

            }
            if (rs != null) {
                rs.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();

            }

            return entComercialeses;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
        }

        return null;

    }

    public List<VtaFacturas> compVencidos(String aDias) {
        try {

            String sql = "";

            Calendar menos30d = new GregorianCalendar();
            Calendar menos60d = new GregorianCalendar();

            menos30d.add(Calendar.DATE, -30);
            menos60d.add(Calendar.DATE, -60);

            java.sql.Date menos30dias = new java.sql.Date(menos30d.getTime().getTime());
            java.sql.Date menos60dias = new java.sql.Date(menos60d.getTime().getTime());



            /*
             * Consulta a Sistema
             */

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:Tractoagro", "", "");
            Statement stat = conn.createStatement();

            if (aDias.equals("30")) {
                sql = "SELECT FACTURAS.*,VENDEDOR.* FROM FACTURAS LEFT JOIN VENDEDOR ON FACTURAS.fa_vendcod = VENDEDOR.ve_codigo WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos30dias + "}";
            } else if (aDias.equals("3060")) {
                sql = "SELECT FACTURAS.*,VENDEDOR.* FROM FACTURAS LEFT JOIN VENDEDOR ON FACTURAS.fa_vendcod = VENDEDOR.ve_codigo WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos60dias + "} AND fa_fecha < {^" + menos30dias + "}";
            } else if (aDias.equals("60")) {
                sql = "SELECT FACTURAS.*,VENDEDOR.* FROM FACTURAS LEFT JOIN VENDEDOR ON FACTURAS.fa_vendcod = VENDEDOR.ve_codigo WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha < {^" + menos60dias + "}";




            }

            ResultSet rs = stat.executeQuery(sql);
            List<VtaFacturas> vtaFacturas = new LinkedList<VtaFacturas>();

            if (rs.next()) {
                do {
                    VtaFacturas vtaFactura = new VtaFacturas();
                    vtaFactura.setComp_tipo(rs.getInt("Tc_codigo"));
                    vtaFactura.setComp_suc(rs.getInt("Su_codigo"));
                    vtaFactura.setComp_Nro(rs.getInt("Fa_codigo"));
                    vtaFactura.setComp_Fecha(rs.getDate("Fa_fecha"));
                    vtaFactura.setComp_Clcod(rs.getInt("Cl_codigo"));
                    vtaFactura.setComp_Clnom(rs.getString("Fa_cliente"));
                    vtaFactura.setComp_Saldada(rs.getString("Fa_saldada"));
                    vtaFactura.setComp_ImpCanc(rs.getDouble("Fa_imp_can"));
                    vtaFactura.setComp_Imp(rs.getString("Fa_impresa"));
                    vtaFactura.setComp_Total(rs.getDouble("Fa_total"));
                    vtaFactura.setComp_Subtotal(rs.getDouble("Fa_subtota"));
                    vtaFactura.setComp_IVA(rs.getDouble("Fa_iva"));
                    vtaFactura.setComp_Dcto(rs.getDouble("Fa_dto"));
                    vtaFactura.setComp_Vdcod(rs.getInt("Fa_vendcod"));
                    vtaFactura.setComp_Vendedor(rs.getString("Ve_nombre"));
                    vtaFactura.setComp_Otros1(rs.getString("Fa_otros1"));
                    vtaFactura.setComp_ZonaCod(rs.getString("Fa_zo_codi"));
                    vtaFactura.setComp_PorDcto(rs.getDouble("Fa_p_dto"));
                    vtaFactura.setComp_Operador(rs.getInt("Fa_opecod"));
                    vtaFactura.setComp_Tipo("S");

                    vtaFacturas.add(
                            vtaFactura);

                } while (rs.next());
            }



            /*
             * Consulta a Alt
             */

            Connection conn2 = DriverManager.getConnection("jdbc:odbc:Alt");
            Statement stat2 = conn2.createStatement();


            ResultSet rs2 = stat2.executeQuery(sql);

            if (rs2.next()) {
                do {
                    VtaFacturas vtaFactura = new VtaFacturas();
                    vtaFactura.setComp_tipo(rs2.getInt("Tc_codigo"));
                    vtaFactura.setComp_suc(rs2.getInt("Su_codigo"));
                    vtaFactura.setComp_Nro(rs2.getInt("Fa_codigo"));
                    vtaFactura.setComp_Fecha(rs2.getDate("Fa_fecha"));
                    vtaFactura.setComp_Clcod(rs2.getInt("Cl_codigo"));
                    vtaFactura.setComp_Clnom(rs2.getString("Fa_cliente"));
                    vtaFactura.setComp_Saldada(rs2.getString("Fa_saldada"));
                    vtaFactura.setComp_ImpCanc(rs2.getDouble("Fa_imp_can"));
                    vtaFactura.setComp_Imp(rs2.getString("Fa_impresa"));
                    vtaFactura.setComp_Total(rs2.getDouble("Fa_total"));
                    vtaFactura.setComp_Subtotal(rs2.getDouble("Fa_subtota"));
                    vtaFactura.setComp_IVA(rs2.getDouble("Fa_iva"));
                    vtaFactura.setComp_Dcto(rs2.getDouble("Fa_dto"));
                    vtaFactura.setComp_Vdcod(rs2.getInt("Fa_vendcod"));
                    vtaFactura.setComp_Vendedor(rs2.getString("Ve_nombre"));
                    vtaFactura.setComp_Otros1(rs2.getString("Fa_otros1"));
                    vtaFactura.setComp_ZonaCod(rs2.getString("Fa_zo_codi"));
                    vtaFactura.setComp_PorDcto(rs2.getDouble("Fa_p_dto"));
                    vtaFactura.setComp_Operador(rs2.getInt("Fa_opecod"));
                    vtaFactura.setComp_Tipo("A");

                    vtaFacturas.add(
                            vtaFactura);

                } while (rs2.next());
            }


            if (conn != null) {
                conn.close();
            }
            if (stat != null) {
                stat.close();
            }


            if (rs2 != null) {
                rs2.close();
            }
            if (stat2 != null) {
                stat2.close();
            }
            if (conn2 != null) {
                conn2.close();




            }

            return vtaFacturas;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println(e.getCause().toString());
        }
        return null;

    }

    public Double[] compVencidosMonto(String aDias) {
        try {

            String sqlC = "";

            Double[] compMonto = {0.0, 0.0, 0.0, 0.0};


            Calendar menos30d = new GregorianCalendar();
            Calendar menos60d = new GregorianCalendar();

            menos30d.add(Calendar.DATE, -30);
            menos60d.add(Calendar.DATE, -60);

            java.sql.Date menos30dias = new java.sql.Date(menos30d.getTime().getTime());
            java.sql.Date menos60dias = new java.sql.Date(menos60d.getTime().getTime());

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:Tractoagro");
            Statement stat = conn.createStatement();

            if (aDias.equals("30")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos30dias + "}";
            } else if (aDias.equals("3060")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos60dias + "} AND fa_fecha < {^" + menos30dias + "}";
            } else if (aDias.equals("60")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha < {^" + menos60dias + "}";

            }

            ResultSet rsC = stat.executeQuery(sqlC);

            if (rsC.next()) {
                compMonto[  0] = rsC.getDouble(
                        1);
                compMonto[  1] = rsC.getDouble(
                        2);
            }


            Connection conn2 = DriverManager.getConnection("jdbc:odbc:Alt");
            Statement stat2 = conn2.createStatement();

            if (aDias.equals("30")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos30dias + "}";
            } else if (aDias.equals("3060")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha >= {^" + menos60dias + "} AND fa_fecha < {^" + menos30dias + "}";
            } else if (aDias.equals("60")) {
                sqlC = "SELECT SUM(fa_imp_can),SUM(fa_total) FROM facturas WHERE fa_recibi1<>'CONTADO' AND fa_impresa='I' AND tc_codigo=1 AND fa_saldada='N' AND fa_fecha < {^" + menos60dias + "}";

            }

            ResultSet rsC2 = stat2.executeQuery(sqlC);

            if (rsC2.next()) {
                compMonto[  2] = rsC2.getDouble(
                        1);
                compMonto[  3] = rsC2.getDouble(
                        2);
            }




            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }

            if (stat2 != null) {
                stat2.close();
            }
            if (conn2 != null) {
                conn2.close();


            }

            return compMonto;

        } catch (Exception e) {
            e.getMessage();
            e.getStackTrace();
            System.out.println(e.getMessage());

        }
        return null;

    }

    public VtaFacturas[] articuloVentas(String articCodigo) {
        try {
            VtaFacturas[] vtaFacturas = (VtaFacturas[]) listarFacturasporArticulo(articCodigo).toArray(new VtaFacturas[0]);
            return vtaFacturas;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }    // Add business logic below. (Right-click in editor and choose

    public List<VtaFacturas> listarCompVta() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Double consultarStock(String codArtic) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:odbc:Tractoagro");
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from artdep where ar_cod = '" + codArtic);
        } catch (Exception e) {
        }
        return 0.0;
    }

    public Proveedores consultaProveedor(Integer provCodigo) {
        Proveedores proveedor = new Proveedores();
        String strSQL;
        String strConn;
        try {
             strSQL = "SELECT * FROM proveedo WHERE pr_codigo=" + provCodigo;
             strConn = "jdbc:odbc:Tractoagro";

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection conn = DriverManager.getConnection(strConn);
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(strSQL);

            if (rs.next()) {

                    proveedor.setProvCod(rs.getInt("pr_codigo"));
                    proveedor.setProvNombre(rs.getString("pr_nombre"));
                    proveedor.setProvTel(rs.getString("pr_telefon"));

                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
                if (stat != null) {
                    stat.close();
                }
            return proveedor;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
