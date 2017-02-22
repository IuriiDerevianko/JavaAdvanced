//D
package ua.itea.ijavaadv.lesson01.randominputstream;
import java.io.IOException;

/**
 *
 * 1. RandomInputStream extends InputStream. Реализовать класс по генерации случайных байт в виде байтового потока
 * длиною не меньше MIN_LENGTH, но не более MAX_LENGTH (это такие константы, значения придумайте сами, размер потока
 * возвращаемый available(), лежит в этих промежутках).
 *
 * 2.* Добавить поддержку markSupported().
 *
 */

public class Main {
    public static void main(String[] args) throws IOException {
        RandomInputStream randomInputStream = null;
        try {
            randomInputStream = new RandomInputStream();
            System.out.println("\tResult is available(): " + randomInputStream.available() + ";\n");
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";\n");

            randomInputStream.createRandomArray();
            for (int i = 0; i <= randomInputStream.available(); i++) {
                System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            }
            System.out.println();

            System.out.println(randomInputStream.read(randomInputStream.createRandomArray()));
            System.out.println();

            System.out.println("\tResult is available(): " + randomInputStream.available() + ";\n");

            //2*. markSupported();
            System.out.println("\tResult is markSupported(): " + randomInputStream.markSupported() + ";");
            randomInputStream.createRandomArray();
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
            System.out.println("\tResult is mark(4):");
            randomInputStream.mark(4);
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
            System.out.println("\tResult is reset();");
            randomInputStream.reset();
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
            System.out.println("\tResult is read(): " + randomInputStream.read() + ";");
            System.out.println("\tResult is getMarkpos(): " + randomInputStream.getMarkpos() + ";");
        } catch(IOException e){
            System.err.println(e.toString());
        } finally {
            randomInputStream.close();
        }
    }
}
