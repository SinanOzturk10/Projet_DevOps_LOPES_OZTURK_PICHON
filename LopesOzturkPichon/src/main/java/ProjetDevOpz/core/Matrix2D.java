package ProjetDevOpz.core;

public class Matrix2D extends NdArray {

    public Matrix2D(float[] data, int rows, int cols) {
        super(data, new int[]{rows, cols});
    }


    public float get(int i, int j) {
        if (i < 0 || i >= shape[0] || j < 0 || j >= shape[1]) {
            throw new IndexOutOfBoundsException(
                "Index (" + i + ", " + j + ") out of bounds for shape (" + shape[0] + ", " + shape[1] + ")"
            );
        }

        return data[i * shape[1] + j];
    }


    public void set(int i, int j, float value) {
        if (i < 0 || i >= shape[0] || j < 0 || j >= shape[1]) {
            throw new IndexOutOfBoundsException(
                "Index (" + i + ", " + j + ") out of bounds for shape (" + shape[0] + ", " + shape[1] + ")"
            );
        }

        data[i * shape[1] + j] = value;
    }


    public Matrix2D matmul(Matrix2D other)             { throw new UnsupportedOperationException(); }
    public Matrix2D transpose()                        { throw new UnsupportedOperationException(); }


    @Override
    public NdArray add(NdArray other) {
        if (!(other instanceof Matrix2D)) {
            throw new IllegalArgumentException("Cannot add a non-2D array to a Matrix2D");
        }

        Matrix2D m = (Matrix2D) other;

        if (this.shape[0] != m.shape[0] || this.shape[1] != m.shape[1]) {
            throw new IllegalArgumentException("Matrices must have the same shape");
        }

        float[] res = new float[size];
        for (int i = 0; i < size; i++) {
            res[i] = this.data[i] + m.data[i];
        }

        return new Matrix2D(res, shape[0], shape[1]);
    }


    @Override
    public void iadd(NdArray other) {
        if (!(other instanceof Matrix2D)) {
            throw new IllegalArgumentException("Cannot add a non-2D array to a Matrix2D");
        }

        Matrix2D m = (Matrix2D) other;

        if (this.shape[0] != m.shape[0] || this.shape[1] != m.shape[1]) {
            throw new IllegalArgumentException("Matrices must have the same shape");
        }

        for (int i = 0; i < size; i++) {
            this.data[i] += m.data[i];
        }
    }
}
