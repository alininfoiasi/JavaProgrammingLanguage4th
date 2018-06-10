package ch20;

import java.io.*;
import java.util.*;

class UppercaseConvertor extends FilterReader {

    public UppercaseConvertor(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toUpperCase((char) c));
    }

    @Override
    public int read(char[] buf, int offset, int count)
            throws IOException {
        int nread = super.read(buf, offset, count);
        int last = offset + nread;
        for (int i = offset; i < last; i++) {
            buf[i] = Character.toUpperCase(buf[i]);
        }
        return nread;
    }
}

class DirFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return new File(dir, name).isDirectory();
    }
}

public class InputOutputData {

    public static double sumStream(Readable source) throws IOException {
        Scanner in = new Scanner(source);
        double result = 0.0;
        while (in.hasNext()) {
            if (in.hasNextDouble()) {
                result += in.nextDouble();
            } else {
                in.next();
            }
        }
        IOException ex = in.ioException();
        if (ex != null) {
            throw ex;
        }
        return result;
    }

    public static void countSpacesAndChars(String file)
            throws IOException {
        Reader in;
        if (file == null || file.length() == 0) {
            in = new InputStreamReader(System.in);
        } else {
            in = new FileReader(file);
        }
        int ch;
        int total;
        int spaces = 0;
        for (total = 0; (ch = in.read()) != -1; total++) {
            if (Character.isWhitespace((char) ch)) {
                spaces++;
            }
        }
        System.out.println(total + " chars, "
                + spaces + " spaces");
    }

    public static void runFilter(String file)
            throws IOException {
        StringReader src = new StringReader(file);
        FilterReader f = new UppercaseConvertor(src);
        int c;
        while ((c = f.read()) != -1) {
            System.out.print((char) c);
        }
        System.out.println();
    }

    public static void listDirs(String path) {
        File dir = new File(path);
        String[] files = dir.list(new DirFilter());
        System.out.println(files.length + " dir(s):");
        for (String file : files) {
            System.out.println("\t" + file);
        }
    }

    public static void main(String args[]) throws Exception {
        //InputOutputData.countSpacesAndChars("D:\\workspace_nb\\Java4th\\inout\\pgadmin.txt");
        //InputOutputData.runFilter("D:\\workspace_nb\\Java4th\\inout\\pgadmin.txt");
        //InputOutputData.listDirs("D:\\workspace_nb\\Java4th");
        double result = InputOutputData.sumStream(new BufferedReader(new FileReader("D:\\workspace_nb\\Java4th\\inout\\pgadmin.txt")));
        System.out.println(result);
    }
}
