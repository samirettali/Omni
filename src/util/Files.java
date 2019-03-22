package util;

import java.io.*;

public class Files {
    public static String readFile(String fileName) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fis.read(data);
        fis.close();

        String str = new String(data, "UTF-8");
        return str;
    }
}
