package ProjetDevOpz.utils;

import ProjetDevOpz.core.NdArray;

public class NdArrayPrinter {

    public static String toString(NdArray a) {
        if (a.ndim == 1) {
            return vectorToString(a.getData());
        }

        if (a.ndim == 2) {
            return matrixToString(a.getData(), a.getShape());
        }

        throw new UnsupportedOperationException("Only 1D and 2D arrays are supported");
    }
    
    //afficher dans la console
    public static void print(NdArray a) { System.out.println(toString(a)); }


    //Afficher entièrement un vecteur 
    private static String vectorToString(float[] data) {
        return vectorToString(data, 0, data.length);
    }


    //affiche une partie du vecteur, utile pour matrice car les valeurs sont stocké dans un seul tableaux
    private static String vectorToString(float[] data, int start, int length) {
        StringBuilder res = new StringBuilder("[");

        for (int i = 0; i < length; i++) {
            if (i > 0) {
                res.append(", ");
            }
            res.append(data[start + i]);
        }
        
        return res.append("]").toString();
    }


    //affiche une matrice mais dans notre implémentation actuelle, se limite a deux dimensions dans toString
    private static String matrixToString(float[] data, int[] shape) {
        int lines = shape[0];
        int cols = shape[1];

        StringBuilder res = new StringBuilder("[");

        for (int i = 0; i < lines; i++) {
            if (i > 0) {
                res.append(",\n ");
            }

            res.append(vectorToString(data, i * cols, cols));
        }

        return res.append("]").toString();
    }
}
