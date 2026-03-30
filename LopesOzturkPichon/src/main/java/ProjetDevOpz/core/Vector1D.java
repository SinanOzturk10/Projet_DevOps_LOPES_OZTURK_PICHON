package ProjetDevOpz.core;

public class Vector1D extends NdArray {

    public Vector1D(float[] data) {
        super(data, new int[]{data.length});
    }

    public float get(int i)                  { throw new UnsupportedOperationException(); }
    public void  set(int i, float value)     { throw new UnsupportedOperationException(); }
    public float dot(Vector1D other)         { throw new UnsupportedOperationException(); }

    @Override
    public NdArray add(NdArray other)        { throw new UnsupportedOperationException(); }

    @Override
    public void iadd(NdArray other)          { throw new UnsupportedOperationException(); }
}