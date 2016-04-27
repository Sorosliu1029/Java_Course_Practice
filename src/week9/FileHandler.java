package week9;
import java.io.*;

/**
 * Created by liuyang on 16/4/27.
 */
public class FileHandler {

    String filePath;

    FileHandler(String path) {
        filePath = path;
    }

    //fileName : .java
    void processFilebyName (File filePath, String fileName) throws Exception {
        for (File fileDir : filePath.listFiles()) {
            if (fileDir.isDirectory()) {
                System.out.println(fileDir.getName());
                processFilebyName (fileDir, fileName);
            }
            else if (fileDir.isFile()) {
                if (fileDir.getName().contains(fileName)) {
                    //todo: process file
                    try{
                        processJavaFile(fileDir);
                    }
                    catch (FileNotFoundException e) {
                        System.out.println("No file found");
                    }
                    catch (IOException e) {
                        System.out.println("IO Error");
                    }
                    catch (MyException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    void processJavaFile(File file) throws IOException, MyException{
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String input = null;
        boolean todoFound = false;
        while((input = bufReader.readLine()) != null) {
            if (input.contains("//todo:") || input.contains("//todo") || input.contains("todo")) {
                todoFound = true;
                System.out.println(file.getPath());
                break;
            }
        }
        if (! todoFound) {
            MyException e = new MyException("todo not found");
            throw e;
        }
    }

    public static void main(String[] argv) {
        FileHandler fh = new FileHandler("./src/");
        try {
            fh.processFilebyName(new File(fh.filePath), ".java");
        }
        catch (Exception e) {
            System.out.println("Error occurs");
        }
    }
}

class MyException extends Exception {
    String message;
    MyException(String exceptionMessage) {
        message = exceptionMessage;
    }
    public String getMessage() {
        return message;
    }
}
