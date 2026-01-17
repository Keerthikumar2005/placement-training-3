import java.io.*;

class FileDemo {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("test.txt");
        fw.write("Java File Handling");
        fw.close();

        FileReader fr = new FileReader("test.txt");
        int ch;
        while ((ch = fr.read()) != -1)
            System.out.print((char) ch);
        fr.close();
    }
}
