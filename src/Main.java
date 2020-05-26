import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;
public class Main {

    static int i = 1000;
    static String[] vector = new String[i];
    public static void main(String[] args) {
        escribirAle("aleatorio.txt");
        escribirOrd("ordenado.txt");
    }
    public static void escribirAle(String nombre) {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter pr;
        Random r1;
        r1 = new Random(340);
        Random r2;
        r2 = new Random(340);
        Random r3;
        r3 = new Random(340);
        final int Mx1 = (2000 - 1950);
        final int Mx2 = (12 - 1);
        final int Mx3 = (30 - 1);
        try {
            f = new File(nombre);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pr = new PrintWriter(bw);
            for (int j = 0; j < i; j++) {
                int a = r1.nextInt(Mx1) + 1950;
                int b = r2.nextInt(Mx2) + 1;
                int c = r3.nextInt(Mx3) + 1;
                String x1 = Integer.toString(a);
                String x2 = Integer.toString(b);
                String x3 = Integer.toString(c);
                String x4 = (x1 + "/" + x2 + "/" + x3);
                vector[j] = x4;
                pr.write(vector[j] + " " + "\n");
            }
            pr.close();
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "se produjo un error" + e);
        }
    }
    public static void escribirOrd(String nombre) {
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter pr;
        Random r1;
        r1 = new Random(190);
        Random r2;
        r2 = new Random(190);
        Random r3;
        r3 = new Random(190);
        final int Mx1 = (2000 - 1950);
        final int Mx2 = (12 - 1);
        final int Mx3 = (30 - 1);
        int[] vector2 = new int[1000];
        try {
            f = new File(nombre);
            w = new FileWriter(f);
            bw = new BufferedWriter(w);
            pr = new PrintWriter(bw);
            for (int j = 0; j < i; j++) {
                int a = Integer.parseInt(String.valueOf(r1.nextInt(Mx1) + 1950));
                int b = Integer.parseInt(String.valueOf(r2.nextInt(Mx2) + 1));
                int c = Integer.parseInt(String.valueOf(r3.nextInt(Mx3) + 1));
                String x1 = Integer.toString(a);
                String x2 = Integer.toString(b);
                String x3 = Integer.toString(c);
                int x4 = Integer.parseInt(( x1 + "" + x2 + "" + x3));
                Integer x5 = Integer.parseInt(String.valueOf(x4));
                vector2[j] = x5;
            }
            ordenarQuicksort(vector2);
            for (int j = 0; j < i; j++) {
                pr.write(vector2[j]  + "\n");
            }
            pr.close();
            bw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "se produjo un error" + e);
        }
    }
    public static void ordenarQuicksort(int[] array) {
        array = quicksort1(array);
    }
    public static int[] quicksort1(int[] numeros) {
        return quicksort2(numeros, 0, numeros.length - 1);
    }
    public static int[] quicksort2(int[] numeros, int izquierda, int derecha) {
        if (izquierda >= derecha)
            return numeros;
        int i = izquierda, d = derecha;
        if (izquierda != derecha) {
            int pivote;
            int zam;
            pivote = izquierda;
            while (izquierda != derecha) {
                while (numeros[derecha] >= numeros[pivote] && izquierda < derecha)
                    derecha--;
                while (numeros[izquierda] < numeros[pivote] && izquierda < derecha)
                    izquierda++;
                if (derecha != izquierda) {
                    zam = numeros[derecha];
                    numeros[derecha] = numeros[izquierda];
                    numeros[izquierda] = zam;
                }
                if (izquierda == derecha) {
                    zam = numeros[derecha];
                    numeros[derecha] = numeros[izquierda];
                    numeros[izquierda] = zam;
                }
                if (izquierda == derecha) {
                    quicksort2(numeros, i, izquierda - 1);
                    quicksort2(numeros, izquierda + 1, d);
                }
            }
        } else
            return numeros;
        return numeros;
    }
}