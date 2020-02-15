package native2acii;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Converter {

    String inputFileName = null;
    String outputFileName = null;
    File tempFile = null;
    static String encodingString = null;
    static String defaultEncoding = null;
    static CharsetEncoder encoder = null;

    public synchronized boolean convert(String argv[]) {
        List<String> v = new ArrayList<>(2);
        File outputFile = null;
        boolean createOutputFile = false;

        for (int i = 0; i < argv.length; i++) {
            if (v.size() > 1) {
                usage();
                return false;
            }
            v.add(argv[i]);
        }

        if (encodingString == null) {
            defaultEncoding = Charset.defaultCharset().name();
        }
        char[] lineBreak = System.getProperty("line.separator").toCharArray();

        try {
            initializeConverter();

            if (v.size() == 1) {
                inputFileName = v.get(0);
            }

            if (v.size() == 2) {
                inputFileName = v.get(0);
                outputFileName = v.get(1);
                createOutputFile = true;
            }

            if (createOutputFile) {
                outputFile = new File(outputFileName);
                if (outputFile.exists() && !outputFile.canWrite()) {
                    throw new Exception(formatMsg("err.cannot.write", outputFileName));
                }
            }

            try (BufferedReader in = getN2AInput(inputFileName);
                 BufferedWriter out = getN2AOutput(outputFileName);) {
                String inLine;
                while ((inLine = in.readLine()) != null) {
                    out.write(inLine.toCharArray());
                    out.write(lineBreak);
                    if (outputFileName == null) {
                        out.flush();
                    }
                }
            }

            if (createOutputFile) {
                if (outputFile.exists()) {
                    outputFile.delete();
                }
                tempFile.renameTo(outputFile);
            }
        } catch (Exception e) {
            error(e.toString());
            return false;
        }
        return true;
    }

    private void error(String msg) {
        System.out.println(msg);
    }

    private void usage() {
        System.out.println(getMsg("usage"));
    }


    private BufferedReader getN2AInput(String inFile) throws Exception {
        InputStream forwardIn;

        if (inFile == null)
            forwardIn = System.in;
        else {
            File f = new File(inFile);
            if (!f.canRead()) {
                throw new Exception(formatMsg("err.cannot.read", f.getName()));
            }

            try {
                forwardIn = new FileInputStream(inFile);
            } catch (IOException e) {
                throw new Exception(formatMsg("err.cannot.read", f.getName()));
            }
        }

        BufferedReader r = (encodingString != null) ?
                new BufferedReader(new InputStreamReader(forwardIn, encodingString)) :
                new BufferedReader(new InputStreamReader(forwardIn));
        return r;
    }


    private BufferedWriter getN2AOutput(String outFile) throws Exception {
        Writer output;
        BufferedWriter n2aOut;

        if (outFile == null)
            output = new OutputStreamWriter(System.out, "US-ASCII");

        else {
            File f = new File(outFile);

            File tempDir = f.getParentFile();

            if (tempDir == null)
                tempDir = new File(System.getProperty("user.dir"));

            tempFile = File.createTempFile("_N2A",
                    ".TMP",
                    tempDir);
            tempFile.deleteOnExit();

            try {
                output = new FileWriter(tempFile);
            } catch (IOException e) {
                throw new Exception(formatMsg("err.cannot.write", tempFile.getName()));
            }
        }

        n2aOut = new BufferedWriter(new N2AFilter(output));
        return n2aOut;
    }

    private static Charset lookupCharset(String csName) {
        if (Charset.isSupported(csName)) {
            try {
                return Charset.forName(csName);
            } catch (UnsupportedCharsetException x) {
                throw new Error(x);
            }
        }
        return null;
    }

    public static boolean canConvert(char ch) {
        return (encoder != null && encoder.canEncode(ch));
    }

    private static void initializeConverter() {
        Charset cs;

        try {
            cs = (encodingString == null) ?
                    lookupCharset(defaultEncoding) :
                    lookupCharset(encodingString);

            encoder = (cs != null) ?
                    cs.newEncoder() :
                    null;
        } catch (IllegalCharsetNameException e) {
            throw new Error(e);
        }
    }

    private static ResourceBundle rsrc;

    static {
        try {
            rsrc = ResourceBundle.getBundle(
                    "strings.regex.three.MsgNative2ascii");
        } catch (MissingResourceException e) {
            throw new Error("Missing message file.");
        }
    }

    private String getMsg(String key) {
        try {
            return (rsrc.getString(key));
        } catch (MissingResourceException e) {
            throw new Error("Error in  message file format.");
        }
    }

    private String formatMsg(String key, String arg) {
        String msg = getMsg(key);
        return MessageFormat.format(msg, arg);
    }
}
