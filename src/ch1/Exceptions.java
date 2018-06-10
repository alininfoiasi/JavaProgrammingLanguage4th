package ch1;

import java.io.*;

class BadDataSetException extends Exception {

    private static final long serialVersionUID = -8975017743921143490L;
    private String mistake;

    public BadDataSetException() {
        // call superclass constructor
        super();
        mistake = "unknown";
    }

    public BadDataSetException(String err) {
        // call super class constructor
        super(err);
        // save message
        mistake = err;
    }

    public String getError() {
        return mistake;
    }
}

public class Exceptions {

    private String readDataSet(FileInputStream in) {
        return "";
    }

    public String getDataSet(String setName) throws BadDataSetException {
        String file = setName + ".dset";
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            return readDataSet(in);
        } catch (IOException e) {
            throw new BadDataSetException("Cannot read from the input file \"" + file + "\"");
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {;
            }
        }
    }

    public static void main(String args[]) {
        Exceptions myu = new Exceptions();
        try {
            myu.getDataSet("file");
        } catch (BadDataSetException bdse) {
            bdse.printStackTrace();
        }
    }
}
