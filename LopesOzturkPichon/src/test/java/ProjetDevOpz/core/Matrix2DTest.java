package ProjetDevOpz.core;

import org.junit.Test;
import static org.junit.Assert.*;

public class Matrix2DTest {

    @Test
    public void creationMatrixTest() {
        float[] data = {1f, 2f, 3f, 4f, 5f, 6f};
        Matrix2D m =new Matrix2D(data, 2, 3);
        assertEquals("ndim lors de la création", 2, m.ndim);
        assertEquals("size lors de la création", 6, m.size);
        assertArrayEquals("shape lors de la création", new int[]{2, 3},m.getShape());
        assertArrayEquals("data lors de la création", data, m.getData(),1e-7f);
    }

    @Test
    public void getTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        assertEquals("get(0,0)", 1f, m.get(0, 0), 1e-7f);
        assertEquals("get(0,1)", 2f, m.get(0, 1), 1e-7f);
        assertEquals("get(0,2)", 3f, m.get(0, 2), 1e-7f);
        assertEquals("get(1,0)", 4f, m.get(1, 0), 1e-7f);
        assertEquals("get(1,1)", 5f, m.get(1, 1), 1e-7f);
        assertEquals("get(1,2)", 6f, m.get(1, 2), 1e-7f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeRowTest() {
        Matrix2D m=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.get(-1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsRowTest() {
        Matrix2D m=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.get(10, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegativeColTest() {
        Matrix2D m=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.get(0, -1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBoundsColTest() {
        Matrix2D m=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.get(0, 10);
    }

    @Test
    public void setTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.set(0,0,10f);
        m.set(1,2,99f);
        assertEquals("set(0,0)", 10f, m.get(0, 0), 1e-7f);
        assertEquals("set(1,2)", 99f, m.get(1, 2), 1e-7f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setNegativeRowTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.set(-1, 0, 5f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOutOfBoundsColTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.set(0, 10, 5f);
    }

    @Test
    public void additionTest() {
        Matrix2D m1= new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D m2= new Matrix2D(new float[]{6f, 5f, 4f, 3f, 2f, 1f}, 2, 3);
        NdArray result= m1.add(m2);
        Matrix2D r= (Matrix2D) result;
        assertEquals("add(0,0)", 7f, r.get(0, 0), 1e-7f);
        assertEquals("add(0,1)", 7f, r.get(0, 1), 1e-7f);
        assertEquals("add(1,2)", 7f, r.get(1, 2), 1e-7f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addDifferentShapeTest() {
        Matrix2D m1 = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D m2 = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 3, 2);
        m1.add(m2);
    }

    @Test
    public void iadditionTest() {
        Matrix2D m1=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D m2=new Matrix2D(new float[]{6f, 5f, 4f, 3f, 2f, 1f}, 2, 3);
        m1.iadd(m2);
        assertEquals("iadd(0,0)", 7f, m1.get(0, 0), 1e-7f);
        assertEquals("iadd(0,1)", 7f, m1.get(0, 1), 1e-7f);
        assertEquals("iadd(1,2)", 7f, m1.get(1, 2), 1e-7f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void iaddDifferentShapeTest() {
        Matrix2D m1=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D m2=new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 3, 2);
        m1.iadd(m2);
    }

    @Test
    public void matmulTest() {
        Matrix2D a = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D b = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 3, 2);
        Matrix2D c = a.matmul(b);

        assertArrayEquals("shape après matmul", new int[]{2, 2}, c.getShape());
        assertEquals("matmul(0,0)", 22f, c.get(0, 0), 1e-6f);
        assertEquals("matmul(0,1)", 28f, c.get(0, 1), 1e-6f);
        assertEquals("matmul(1,0)", 49f, c.get(1, 0), 1e-6f);
        assertEquals("matmul(1,1)", 64f, c.get(1, 1), 1e-6f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void matmulIncompatibleShapeTest() {
        Matrix2D a = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D b = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        a.matmul(b);
    }

    @Test
    public void transposeTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        Matrix2D t = m.transpose();
        assertArrayEquals("shape après transpose", new int[]{3, 2}, t.getShape());
        assertEquals("transpose(0,0)", 1f, t.get(0, 0), 1e-7f);
        assertEquals("transpose(0,1)", 4f, t.get(0, 1), 1e-7f);
        assertEquals("transpose(1,0)", 2f, t.get(1, 0), 1e-7f);
        assertEquals("transpose(2,1)", 6f, t.get(2, 1), 1e-7f);
    }

    @Test
    public void reshapeTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        NdArray reshaped = m.reshape(3, 2);
        assertEquals("ndim après reshape", 2, reshaped.ndim);
        assertArrayEquals("shape après reshape", new int[]{3, 2}, reshaped.getShape());
    }

    @Test(expected = IllegalArgumentException.class)
    public void reshapeExceptionTest() {
        Matrix2D m = new Matrix2D(new float[]{1f, 2f, 3f, 4f, 5f, 6f}, 2, 3);
        m.reshape(4, 4); 
    }
}
