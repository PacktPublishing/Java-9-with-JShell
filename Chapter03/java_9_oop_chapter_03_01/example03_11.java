class Rectangle {
    double width;
    double height;

     Rectangle(double width, double height) {
        System.out.printf("Initializing a new Rectangle instance\n");
        System.out.printf("Width: %.2f, Height: %.2f\n", width, height);
        this.width = width;
        this.height = height;
    }
}

Rectangle rectangle1 = new Rectangle(31.0, 21.0);
Rectangle rectangle2 = new Rectangle(182.0, 32.0);
Rectangle rectangle3 = new Rectangle(203.0, 23.0);
Rectangle rectangle4 = new Rectangle(404.0, 14.0);

rectangle1.width
rectangle1.height
rectangle2.width
rectangle2.height
rectangle3.width
rectangle3.height
rectangle4.width
rectangle4.height

rectangle1 instanceof Rectangle
rectangle1 instanceof Object

rectangle1.getClass()

class Rectangle {
    double width;
    double height;

     Rectangle(double width, double height) {
        System.out.printf("Initializing a new Rectangle instance\n");
        System.out.printf("Width: %.2f, Height: %.2f\n", width, height);
        this.width = width;
        this.height = height;
    }

    // The following code doesn't represent a best practice
    // It is included just for educational purposes
    // and to make it easy to understand how the
    // garbage collection process works
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.printf("Finalizing Rectangle\n");
            System.out.printf("Width: %.2f, Height: %.2f\n", width, height);
        } catch(Throwable t){
            throw t;
        } finally{
            super.finalize();
        }
    }
}

Rectangle rectangleToCollect1 = new Rectangle(51, 121);
Rectangle rectangleToCollect2 = new Rectangle(72, 282);
rectangleToCollect1 = null;
rectangleToCollect2 = null;
