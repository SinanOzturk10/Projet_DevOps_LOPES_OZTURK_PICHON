// NdArrayFactoryTest.java
package ProjetDevOpz.factory;

import ProjetDevOpz.core.NdArray;
import ProjetDevOpz.core.Vector1D;
import org.junit.Test;
import static org.junit.Assert.*;

public class NdArrayFactoryTest {

    @Test
    public void arrayVectorTest() {
        float[] tab = {1.1f, 2.2f, 3.3f};

        Vector1D v = NdArrayFactory.array(tab);

        assertEquals("Dimension lors de la création factory", 1, v.ndim);
        assertEquals("Taille lors de la création factory", 3, v.size);
        assertArrayEquals("Shape lors de la création factory", new int[]{3}, v.getShape());
        assertArrayEquals("Données lors de la création factory", tab, v.getData(), 0.0000001f);
        assertEquals("Premier élément créé par factory", 1.1f, v.get(0), 0.0000001f);
    }


    @Test
    public void arrayVecteurVideTest() {
        Vector1D v = NdArrayFactory.array(new float[]{});

        assertEquals("Dimension vecteur vide", 1, v.ndim);
        assertEquals("Taille vecteur vide", 0, v.size);
        assertArrayEquals("Shape vecteur vide", new int[]{0}, v.getShape());
        assertArrayEquals("Données vecteur vide", new float[]{}, v.getData(), 0.0000001f);
    }


    @Test
    public void zerosVectorTest() {
        NdArray zeros = NdArrayFactory.zeros(4);

        assertTrue("Zeros retourne un Vector1D", zeros instanceof Vector1D);
        assertEquals("Dimension zeros", 1, zeros.ndim);
        assertEquals("Taille zeros", 4, zeros.size);
        assertArrayEquals("Shape zeros", new int[]{4}, zeros.getShape());
        assertArrayEquals("Données zeros", new float[]{0.0f, 0.0f, 0.0f, 0.0f}, zeros.getData(), 0.0000001f);
    }


    @Test
    public void zerosTailleZeroTest() {
        NdArray zeros = NdArrayFactory.zeros(0);

        assertEquals("Taille zeros vide", 0, zeros.size);
        assertArrayEquals("Shape zeros vide", new int[]{0}, zeros.getShape());
        assertArrayEquals("Données zeros vide", new float[]{}, zeros.getData(), 0.0000001f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void zerosSansShapeTest() {
        NdArrayFactory.zeros();
    }


    @Test(expected = NegativeArraySizeException.class)
    public void zerosTailleNegativeTest() {
        NdArrayFactory.zeros(-1);
    }


    @Test
    public void arangeTest() {
        NdArray res = NdArrayFactory.arange(2.0f, 6.0f);

        assertTrue("Arange retourne un Vector1D", res instanceof Vector1D);
        assertEquals("Dimension arange", 1, res.ndim);
        assertEquals("Taille arange", 4, res.size);
        assertArrayEquals("Shape arange", new int[]{4}, res.getShape());
        assertArrayEquals("Données arange", new float[]{2.0f, 3.0f, 4.0f, 5.0f}, res.getData(), 0.0000001f);
    }


    @Test
    public void arangeStartEgalStopTest() {
        NdArray res = NdArrayFactory.arange(3.0f, 3.0f);

        assertEquals("Taille arange vide", 0, res.size);
        assertArrayEquals("Shape arange vide", new int[]{0}, res.getShape());
        assertArrayEquals("Données arange vide", new float[]{}, res.getData(), 0.0000001f);
    }


    @Test
    public void arangeAvecFloatTest() {
        NdArray res = NdArrayFactory.arange(1.5f, 4.5f);

        assertArrayEquals("Données arange float", new float[]{1.5f, 2.5f, 3.5f}, res.getData(), 0.0000001f);
    }


    @Test(expected = IllegalArgumentException.class)
    public void arangeStopInferieurStartTest() {
        NdArrayFactory.arange(5.0f, 2.0f);
    }


    @Test
    public void fromRawVectorTest() {
        float[] data = {7.0f, 8.0f, 9.0f};
        int[] shape = {3};

        NdArray res = NdArrayFactory.fromRaw(data, shape);

        assertTrue("FromRaw retourne un Vector1D", res instanceof Vector1D);
        assertEquals("Dimension fromRaw", 1, res.ndim);
        assertEquals("Taille fromRaw", 3, res.size);
        assertArrayEquals("Shape fromRaw", shape, res.getShape());
        assertArrayEquals("Données fromRaw", data, res.getData(), 0.0000001f);
    }


    @Test(expected = NullPointerException.class)
    public void fromRawShapeNullTest() {
        NdArrayFactory.fromRaw(new float[]{1.0f}, null);
    }


    @Test(expected = NullPointerException.class)
    public void fromRawDataNullTest() {
        NdArrayFactory.fromRaw(null, new int[]{1});
    }
}
