// NdArrayPrinterTest.java
package ProjetDevOpz.utils;

import org.junit.Test;
import static org.junit.Assert.*;
import ProjetDevOpz.core.Vector1D;

public class NdArrayPrinterTest {
    @Test
    public void toStringNonNullTest() {
        Vector1D v = new Vector1D(new float[]{1.0f, 2.0f, 3.0f});
        String res = NdArrayPrinter.toString(v);
        assertNotNull("toString() ne doit pas retourner null", res);
    }

    @Test
    public void toStringBonnesValeursTest() {
        Vector1D v = new Vector1D(new float[]{1.0f, 2.0f, 3.0f});
        String res = NdArrayPrinter.toString(v);
        
        assertTrue("toString() doit contenir 1", res.contains("1"));
        assertTrue("toString() doit contenir 2", res.contains("2"));
        assertTrue("toString() doit contenir 3", res.contains("3"));
    }

    @Test
    public void toStringOrderTest() {
        Vector1D v = new Vector1D(new float[]{1.0f, 2.0f, 3.0f});
        String result = NdArrayPrinter.toString(v);
        
        int un = result.indexOf("1");
        int deux = result.indexOf("2");
        int trois = result.indexOf("3");
        
        assertTrue("1 doit apparaître avant 2", un < deux);
        assertTrue("2 doit apparaître avant 3", deux < trois);
    }
}