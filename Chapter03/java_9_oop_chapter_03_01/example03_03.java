class Rectangle {
    double width;
    double height;

     Rectangle(double width, double height) {
        System.out.printf("I'm initializing a new Rectangle instance\n");
        System.out.printf("Width: %.2f, Height: %.2f", width, height);
        this.width = width;
        this.height = height;
    }
}