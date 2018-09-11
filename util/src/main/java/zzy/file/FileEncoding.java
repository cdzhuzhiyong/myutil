package zzy.file;

import java.io.IOException;
import java.io.InputStream;

public class FileEncoding {
    public static boolean isUTF8(InputStream inputStream) throws IOException {
        byte[] b = new byte[3];
        inputStream.read(b);
        return b[0] == -17 && b[1] == -69 && b[2] == -65;
    }
}
