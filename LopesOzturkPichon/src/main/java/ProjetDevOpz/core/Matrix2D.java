package ProjetDevOpz.core;

public class Matrix2D extends NdArray {

    public Matrix2D(float[] data, int rows, int cols) {
        super(data, new int[]{rows, cols});
    }

    public float  get(int i, int j)                    { throw new UnsupportedOperationException(); }
    public void   set(int i, int j, float value)       { throw new UnsupportedOperationException(); }
    public Matrix2D matmul(Matrix2D other)             { throw new UnsupportedOperationException(); }
    public Matrix2D transpose()                        { throw new UnsupportedOperationException(); }

    @Override
    public NdArray add(NdArray other)                  { throw new UnsupportedOperationException(); }

    @Override
    public void iadd(NdArray other)                    { throw new UnsupportedOperationException(); }
}