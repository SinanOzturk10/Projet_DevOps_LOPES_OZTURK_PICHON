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


    public Matrix2D matmul(Matrix2D other) {
        if (this.shape[1] != other.shape[0]) {
            throw new IllegalArgumentException("Matrices have incompatible shapes for matmul");
        }

        int lines = this.shape[0];
        int col = other.shape[1];
        int common = this.shape[1];
        float[] res = new float[lines * col];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < col; j++) {
                float sum = 0f;
                for (int k = 0; k < common; k++) {
                    sum += this.get(i, k) * other.get(k, j);
                }
                res[i * col + j] = sum;
            }
        }

        return new Matrix2D(res, lines, col);
    }


    public Matrix2D transpose() {
        int lines = this.shape[1];
        int col = this.shape[0];
        float[] res = new float[size];

        for (int i = 0; i < this.shape[0]; i++) {
            for (int j = 0; j < this.shape[1]; j++) {
                res[j * col + i] = this.get(i, j);
            }
        }

        return new Matrix2D(res, lines, col);
    }


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
