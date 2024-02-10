package co.icesi.edu.model;

import org.junit.Assert;
import org.junit.Test;
import co.icesi.edu.model.Billboard;

public class BillboardTest {

    @Test
    public void testArea(){
        Billboard obj = new Billboard(100.0,40.0, true, "asd");
        double area = obj.calculateArea();
        Assert.assertEquals(4000.0, area, 0);
    }
}
