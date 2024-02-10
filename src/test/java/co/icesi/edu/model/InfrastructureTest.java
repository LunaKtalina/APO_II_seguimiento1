package co.icesi.edu.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InfrastructureTest {

    @Test
    public void testAddBillboard() throws Exception {
        // Crear una instancia de la clase InfrastructureDepartament
        InfrastructureDepartament department = new InfrastructureDepartament();

        // Agregar un cartel al departamento de infraestructura
        department.addBillboard(10.0, 5.0, true, "Coca-Cola");
    }

    @Test
    public void testLoadBillboard()throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        // Verificar que no se lance ninguna excepción al llamar al método loadBillboard
        try {
            infrastructureDepartament.loadBillboard();
            // Si la carga se realiza correctamente, entonces el test pasa
        } catch (Exception e) {
            // Si se produce una excepción durante la carga, el test falla y muestra el mensaje de error
            fail("Se lanzó una excepción durante la carga de carteles: " + e.getMessage());
        }
    }

    @Test
    public void testAverageW() throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        Assert.assertEquals(678.2, infrastructureDepartament.averageW(), 0);
    }

    @Test
    public void testAverageH() throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        Assert.assertEquals(266.0, infrastructureDepartament.averageH(), 0);
    }

    @Test
    public void testAverageA() throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        Assert.assertEquals(181666.0, infrastructureDepartament.averageA(), 0);
    }

    @Test
    public void testQuantityActives() throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        Assert.assertEquals(3, infrastructureDepartament.quantityActives());
    }

    @Test
    public void testCounterBillXBrand() throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        String result = " * Auctor Quis Tristique Corp.: 1\n" +
                " * Hendrerit Institute: 2\n" +
                " * Risus Morbi LLC: 2\n";
        Assert.assertEquals(result, infrastructureDepartament.counterBillXBrand());
    }

    @Test
    public void testImportData(String fn) throws Exception{
        InfrastructureDepartament infrastructureDepartament = new InfrastructureDepartament();

        // Línea de datos simulada en formato CSV
        String line = "955|300|true|Auctor Quis Tristique Corp.";

        // Llamar al método importData con la línea simulada
        infrastructureDepartament.importData(line);

        // Verificar que se haya agregado correctamente un cartel a la lista
        assertEquals(1, infrastructureDepartament.billboards.size());

        // Verificar que los datos del cartel importado sean correctos
        Billboard billboard = infrastructureDepartament.billboards.get(0);
        assertEquals(10.5, billboard.getWidth());
        assertEquals(5.0, billboard.getHeight());
        assertTrue(billboard.isInUse());
        assertEquals("Brand1", billboard.getBrand());
    }
}