package ProjetDevOpz;

import ProjetDevOpz.core.Matrix2D;
import ProjetDevOpz.core.NdArray;
import ProjetDevOpz.core.Vector1D;
import ProjetDevOpz.factory.NdArrayFactory;
import ProjetDevOpz.utils.NdArrayPrinter;

public class App {
    public static void main(String[] args) {
        System.out.println("Demonstration de la bibliotheque de calcul scientifique");
        System.out.println();

        System.out.println("Creation de deux vecteurs, v avec comme argument new float[]{1f, 2f, 3f) et w avec new float[]{4f, 5f, 6f}}");
        Vector1D v = NdArrayFactory.array(new float[]{1f, 2f, 3f});
        Vector1D w = NdArrayFactory.array(new float[]{4f, 5f, 6f});
        System.out.println("Affichage de v et w");
        System.out.print("v = ");
        NdArrayPrinter.print(v);
        System.out.print("w = ");
        NdArrayPrinter.print(w);
        System.out.println();
        System.out.println("Addition et multiplication de v et w:");
        System.out.print("v + w = ");
        NdArrayPrinter.print(v.add(w));
        System.out.println("v dot w = " + v.dot(w));
        System.out.println();

        System.out.println("Creation d'un NdArray a avec arange(0, 6):");
        NdArray a = NdArrayFactory.arange(0f, 6f);
        NdArrayPrinter.print(a);
        System.out.println("Reshape de a sous forme 2x3:");
        NdArrayPrinter.print(a.reshape(2, 3));
        System.out.println();


        System.out.println("Creation d'une matrice m sous forme (1, 2, 3)");
        System.out.println("                                    (3, 4, 5)");
        Matrix2D m = NdArrayFactory.array(new float[][]{
            {1f, 2f, 3f},
            {4f, 5f, 6f}
        });
        System.out.println();
        Matrix2D madd = NdArrayFactory.array(new float[][]{
            {10f, 20f, 30f},
            {40f, 50f, 60f}
        });
        NdArrayPrinter.print(m);
        System.out.println();
        System.out.println("m + (10, 20, 30):");
        System.out.println("    (40, 50, 60)");
        NdArrayPrinter.print(m.add(madd));
        System.out.println();
        System.out.println("Transposition de m:");
        NdArrayPrinter.print(m.transpose());
        System.out.println();

        Matrix2D mult = NdArrayFactory.array(new float[][]{
            {1f, 2f},
            {3f, 4f},
            {5f, 6f}
        });
        System.out.println("Multiplication de m avec (1, 2)");
        System.out.println("                         (3, 4)");
        System.out.println("                         (5, 6)");
        NdArrayPrinter.print(m.matmul(mult));
        System.out.println();

        System.out.println("Creation de matrice avec zeros(2,3):");
        NdArrayPrinter.print(NdArrayFactory.zeros(2, 3));
    }
}
