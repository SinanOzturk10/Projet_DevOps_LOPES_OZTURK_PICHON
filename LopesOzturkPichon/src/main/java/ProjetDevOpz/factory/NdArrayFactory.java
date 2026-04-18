package ProjetDevOpz.factory;

import ProjetDevOpz.core.NdArray;
import ProjetDevOpz.core.Vector1D;
import ProjetDevOpz.core.Matrix2D;

public class NdArrayFactory {

    // public api (5.1 subject)
    public static Vector1D array(float[] data) {
        return new Vector1D(data);
    }


    public static Matrix2D array(float[][] data) {
        int lines = data.length;
        int cols = data[0].length;
        float[] res = new float[lines * cols];

        for (int i = 0; i < lines; i++) {
            if (data[i].length != cols) {
                throw new IllegalArgumentException("All lines must have the same length");
            }

            for (int j = 0; j < cols; j++) {
                res[i * cols + j] = data[i][j];
            }
        }

        return new Matrix2D(res, lines, cols);
    }


    public static NdArray zeros(int... shape) {
        if (shape.length != 1) {
            throw new IllegalArgumentException("Only 1D zeros is supported for now");
        }

        return new Vector1D(new float[shape[0]]);
    }

    //For the moment arrange work only vector 1D true arrange will have more parameter
    public static NdArray arange(float start, float stop) {
        int length = (int) (stop - start);
        if (length < 0) {
            throw new IllegalArgumentException("stop must be greater than or equal to start");
        }

        float[] res = new float[length];
        for (int i = 0; i < length; i++) {
            res[i] = start + i;
        }

        return new Vector1D(res);
    }


    // for the reshape() method
    public static NdArray fromRaw(float[] data, int[] shape) {
        if (shape.length == 1) {
            return new Vector1D(data);
        }

        throw new IllegalArgumentException("Only 1D zeros is supported for now");
    }
}
