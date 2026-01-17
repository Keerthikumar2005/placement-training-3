abstract class Shape {
    abstract void area();
}

class Square extends Shape {
    void area() {
        System.out.println("Area = 25");
    }

    public static void main(String args[]) {
        Square s = new Square();
        s.area();
    }
}
