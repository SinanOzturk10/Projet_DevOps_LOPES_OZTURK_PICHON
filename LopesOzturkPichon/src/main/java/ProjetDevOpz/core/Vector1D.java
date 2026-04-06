package ProjetDevOpz.core;

public class Vector1D extends NdArray {

    public Vector1D(float[] data) {
        super(data, new int[]{data.length});
    }


    public float get(int i) {
        return data[i];
    }


    public void set(int i, float value) {
        data[i] = value;
    }


    public float dot(Vector1D other) {
        if (this.size != other.size) {
            throw new IllegalArgumentException("Vectors must have the same size"); //POUR LINSTANT ON VEUT MEME DIM  (broadcast optionnel)
        }

        float sum = 0f;
        for (int i = 0; i < size; i++) {
            sum += this.data[i] * other.data[i];
        }
        return sum;
    }


    @Override
    public NdArray add(NdArray other) {
        if (!(other instanceof Vector1D)) {
            throw new IllegalArgumentException("Cannot add a non-1D array to a Vector1D");  //POUR LINSTANT ON VEUT MEME DIM (broadcast optionnel)
        }

        Vector1D v = (Vector1D) other;

        if (this.size != v.size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }

        float[] res = new float[size];
        for (int i = 0; i < size; i++) {
            res[i] = this.data[i] + v.data[i];
        }

        return new Vector1D(res);
    }


    @Override
    public void iadd(NdArray other) {
        if (!(other instanceof Vector1D)) {
            throw new IllegalArgumentException("Cannot add a non-1D array to a Vector1D");
        }

        Vector1D v = (Vector1D) other;

        if (this.size != v.size) {
            throw new IllegalArgumentException("Vectors must have the same size");
        }

        for (int i = 0; i < size; i++) {
            this.data[i] += v.data[i];
        }
    }
}
