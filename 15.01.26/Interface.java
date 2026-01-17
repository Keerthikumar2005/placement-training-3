interface Shape {
    void area();
}

class Rectangle implements Shape {
    int l = 10, b = 5;

    public void area() {
        System.out.println("Area = " + (l * b));
    }

    public static void main(String args[]) {
        Rectangle r = new Rectangle();
        r.area();
    }
}
