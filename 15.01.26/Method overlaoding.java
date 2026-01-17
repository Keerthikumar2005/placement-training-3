class Overload {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    public static void main(String args[]) {
        Overload o = new Overload();
        System.out.println(o.add(10, 20));
        System.out.println(o.add(2.5, 3.5));
    }
}
