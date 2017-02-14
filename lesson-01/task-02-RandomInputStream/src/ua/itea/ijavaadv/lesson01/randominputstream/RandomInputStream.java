package ua.itea.ijavaadv.lesson01.randominputstream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class RandomInputStream extends InputStream {

    private static final int MIN_LENGTH = 128;
    private static final int MAX_LENGTH = 1048;
    private byte[] b = null;
    private int pos = 0;
    private int marklimit;
    private int markpos = -1;
    private int counter = 0;

    public byte[] createRandomArray() {
        b = new byte[(int)(MIN_LENGTH + Math.round(Math.random() * (MAX_LENGTH - MIN_LENGTH)))];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte)Math.round(Math.random()*Byte.MAX_VALUE);
        }
        pos = 0;
        markpos = -1;
        counter = 0;
        System.out.println("\tRandom input byte array;");
        System.out.println("\tbyte b [" + b.length + "]:");
        System.out.println(Arrays.toString(b));
        return b;
    }

    public int read() {
        if(b == null){
            return 0;
        }

        counter++;
        if(marklimit == counter){
            markpos = -1;
        }

        return ((pos < b.length) ? b[pos++] : -1);
    }

    @Override
    public int available(){
        if(b == null){
            return 0;
        }
        return b.length;
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int readlimit) {
        marklimit = readlimit;
        markpos = pos;
        counter = 0;
    }

    public int getMarkpos(){
        return markpos;
    }

    public void reset() throws IOException {
        if (markpos < 0)
            throw new IOException("Resetting to invalid mark");
        pos = markpos;
        counter = 0;
    }
}
