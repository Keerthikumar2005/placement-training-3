import java.io.FileWriter;

class FileAppend {
    public static void main(String args[]) throws Exception {
        FileWriter fw = new FileWriter("data.txt", true);
        fw.write("\nJava Programming");
        fw.close();
    }
}
