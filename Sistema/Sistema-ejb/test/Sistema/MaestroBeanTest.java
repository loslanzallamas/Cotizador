/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Sistema;

import DBSistema.ProveeLis;
import DBSistema.Proveedor;
import DBSistema.Vlismaestro;
import Soporte.precioVta;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrador
 */
public class MaestroBeanTest {

    public MaestroBeanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of traerMaestro method, of class MaestroBean.
     */
    @Test
    public void testTraerMaestro() throws Exception {
        System.out.println("traerMaestro");
        String codigo = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        Vlismaestro[] expResult = null;
        Vlismaestro[] result = instance.traerMaestro(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizaMargen method, of class MaestroBean.
     */
    @Test
    public void testActualizaMargen() throws Exception {
        System.out.println("actualizaMargen");
        Integer provlisid = null;
        Double margen = null;
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.actualizaMargen(provlisid, margen);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizaFecha method, of class MaestroBean.
     */
    @Test
    public void testActualizaFecha() throws Exception {
        System.out.println("actualizaFecha");
        Date fecha = null;
        String codartic = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.actualizaFecha(fecha, codartic);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traerProveedoresMaestro method, of class MaestroBean.
     */
    @Test
    public void testTraerProveedoresMaestro() throws Exception {
        System.out.println("traerProveedoresMaestro");
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        Proveedor[] expResult = null;
        Proveedor[] result = instance.traerProveedoresMaestro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarPreliminarListaPrecios method, of class MaestroBean.
     */
    @Test
    public void testGenerarPreliminarListaPrecios() throws Exception {
        System.out.println("generarPreliminarListaPrecios");
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        ProveeLis[] expResult = null;
        ProveeLis[] result = instance.generarPreliminarListaPrecios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aplicarReglasxArtic method, of class MaestroBean.
     */
    @Test
    public void testAplicarReglasxArtic() throws Exception {
        System.out.println("aplicarReglasxArtic");
        Integer provlisId = null;
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        precioVta expResult = null;
        precioVta result = instance.aplicarReglasxArtic(provlisId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aplicarReglas method, of class MaestroBean.
     */
    @Test
    public void testAplicarReglas() throws Exception {
        System.out.println("aplicarReglas");
        String[] artcods = null;
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.aplicarReglas(artcods);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cliTraerMaestro method, of class MaestroBean.
     */
    @Test
    public void testCliTraerMaestro() throws Exception {
        System.out.println("cliTraerMaestro");
        Integer proveeId = null;
        String codMarca = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        String[][] expResult = null;
        String[][] result = instance.cliTraerMaestro(proveeId, codMarca);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cliMaestroProveedores method, of class MaestroBean.
     */
    @Test
    public void testCliMaestroProveedores() throws Exception {
        System.out.println("cliMaestroProveedores");
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        String[][] expResult = null;
        String[][] result = instance.cliMaestroProveedores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of matrizProvComp method, of class MaestroBean.
     */
    @Test
    public void testMatrizProvComp() throws Exception {
        System.out.println("matrizProvComp");
        String articCod = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        ProveeLis[][] expResult = null;
        ProveeLis[][] result = instance.matrizProvComp(articCod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarCompetencia method, of class MaestroBean.
     */
    @Test
    public void testBuscarCompetencia() throws Exception {
        System.out.println("buscarCompetencia");
        String articCod = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        ProveeLis[] expResult = null;
        ProveeLis[] result = instance.buscarCompetencia(articCod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarProvLis method, of class MaestroBean.
     */
    @Test
    public void testBuscarProvLis() throws Exception {
        System.out.println("buscarProvLis");
        String articCod = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        ProveeLis[] expResult = null;
        ProveeLis[] result = instance.buscarProvLis(articCod);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of agregaraLista method, of class MaestroBean.
     */
    @Test
    public void testAgregaraLista() throws Exception {
        System.out.println("agregaraLista");
        Integer proveelisid = null;
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.agregaraLista(proveelisid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of establecerCompetencia method, of class MaestroBean.
     */
    @Test
    public void testEstablecerCompetencia() throws Exception {
        System.out.println("establecerCompetencia");
        Integer compID = null;
        Integer proveeLisID = null;
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.establecerCompetencia(compID, proveeLisID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of establecerArtLista method, of class MaestroBean.
     */
    @Test
    public void testEstablecerArtLista() throws Exception {
        System.out.println("establecerArtLista");
        String codArtic = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        boolean expResult = false;
        boolean result = instance.establecerArtLista(codArtic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of completarMaestroLista method, of class MaestroBean.
     */
    @Test
    public void testCompletarMaestroLista() throws Exception {
        System.out.println("completarMaestroLista");
        String strSQl = "";
        MaestroBean instance = (MaestroBean)javax.ejb.embeddable.EJBContainer.createEJBContainer().getContext().lookup("java:global/classes/MaestroBean");
        instance.completarMaestroLista(strSQl);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}