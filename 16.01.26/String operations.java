import java.util.Scanner;

class StringMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int ch;

        do {
            System.out.println("1.Length 2.Uppercase 3.Reverse 4.Exit");
            ch = sc.nextInt();

            if (ch == 1)
                System.out.println(s.length());
            else if (ch == 2)
                System.out.println(s.toUpperCase());
            else if (ch == 3) {
                String rev = "";
                for (int i = s.length() - 1; i >= 0; i--)
                    rev += s.charAt(i);
                System.out.println(rev);
            }

        } while (ch != 4);
    }
}
