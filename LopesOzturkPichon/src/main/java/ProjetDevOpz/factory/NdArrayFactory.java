package ProjetDevOpz.factory;

import ProjetDevOpz.core.NdArray;
import ProjetDevOpz.core.Vector1D;
import ProjetDevOpz.core.Matrix2D;

public class NdArrayFactory {

    // public api (5.1 subject)
    public static Vector1D array(float[] data)              { throw new UnsupportedOperationException(); }
    public static Matrix2D  array(float[][] data)           { throw new UnsupportedOperationException(); }
    public static NdArray   zeros(int... shape)             { throw new UnsupportedOperationException(); }
    public static NdArray   arange(float start, float stop) { throw new UnsupportedOperationException(); }

    // for the reshape() method
    public static NdArray fromRaw(float[] data, int[] shape)       { throw new UnsupportedOperationException(); }
}