// Vector1DTest.java
package ProjetDevOpz.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class Vector1DTest {

    @Test
    public void creationVectorTest(){
        float tab [] = {1.1f, 2.2f, 3.3f};
        Vector1D v = new Vector1D(tab);
        assertEquals("Dimension lors de la création",1, v.ndim);
        assertEquals("Taile lors de la création", 3, v.size);
        int[] shape = {3};
        assertArrayEquals("Shape lors de la création", shape, v.getShape());

        float[] copy = {1.1f, 2.2f, 3.3f};
        assertArrayEquals("Comparaison deux NDarray lors de la création", copy, v.getData(), 0.001f);
    }

    @Test
    public void getTest() {
    float tab [] = {1.1f, 2.2f, 3.3f};
    Vector1D v = new Vector1D(tab);
    assertEquals("Premier get",1.1f, v.get(0), 0.001f);
    assertEquals("Deuxieme get",2.2f, v.get(1), 0.001f);
    assertEquals("Troisieme get",3.3f, v.get(2), 0.001f);

    }

    @Test
    public void setTest() {
    float tab [] = {1.1f, 2.2f, 3.3f};
    Vector1D v = new Vector1D(tab);
    v.set(0, 10.10f);
    v.set(2, 30.30f);
    assertEquals("Premier set",10.10f, v.get(0), 0.001f);
    assertEquals("Deuxieme set",30.30f, v.get(2), 0.001f);
    }

    @Test
    public void additionTest() {
    Vector1D v1 = new Vector1D(new float[]{1.0f, 2.0f, 3.0f});
    Vector1D v2 = new Vector1D(new float[]{4.0f, 5.0f, 6.0f});
    
    NdArray add = v1.add(v2);
    Vector1D addVector = (Vector1D) add;
    assertEquals("Vérification premiere valeur après add",5.0f, addVector.get(0), 0.001f);
    assertEquals("Vérification deuxieme valeur après add",7.0f, addVector.get(1), 0.001f);
    assertEquals("Vérification troisieme valeur après add",9.0f, addVector.get(2), 0.001f);
    }

    @Test
    public void iadditionTest() {
    Vector1D v1 = new Vector1D(new float[]{1.0f, 2.0f, 3.0f});
    Vector1D v2 = new Vector1D(new float[]{4.0f, 5.0f, 6.0f});
    
    v1.iadd(v2);
    
    assertEquals("Vérification premiere valeur après iadd", 5.0f, v1.get(0), 0.001f);
    assertEquals("Vérification premiere valeur après iadd", 7.0f, v1.get(1), 0.001f);
    assertEquals("Vérification premiere valeur après iadd", 9.0f, v1.get(2), 0.001f);
    }

    @Test
    public void reshapeTest() {
    Vector1D v = new Vector1D(new float[]{1, 2, 3, 4, 5, 6});
    
    NdArray reshaped = v.reshape(2, 3);
    
    assertEquals("Dimension après reshape",2, reshaped.ndim);
    assertArrayEquals("Reshape resultat", new int[]{2, 3}, reshaped.getShape());
    }

    @Test(expected = IllegalArgumentException.class)
    public void reshapeExceptionTest() {
    Vector1D v = new Vector1D(new float[]{1, 2, 3});
    v.reshape(2, 2);

    }

    
}