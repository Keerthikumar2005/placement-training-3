import java.io.FileReader;

class FileRead {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("data.txt");
        int ch;
        while ((ch = fr.read()) != -1)
            System.out.print((char) ch);
        fr.close();
    }
}
