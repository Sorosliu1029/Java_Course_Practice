package week7;

/**
 * Created by liuyang on 16/4/13.
 */
public class Week7Test {
    public static void main(String[] argv) {
        CommonShape[] shapes = new CommonShape[8];
        Circle a = new Circle(1.0);
        Circle b = new Circle(2.0);
        Rectangle c = new Rectangle(1.0, 2.0);
        Rectangle d = new Rectangle(0.5, 2.5);
        Square e = new Square(1.5);
        Square f = new Square(2.0);
        Fan g = new Fan(1.5, 270);
        Fan h = new Fan(2.0, 180);
        shapes[0] = a;
        shapes[1] = b;
        shapes[2] = c;
        shapes[3] = d;
        shapes[4] = e;
        shapes[5] = f;
        shapes[6] = g;
        shapes[7] = h;
        sort(shapes);
        for(int i =0; i < shapes.length; i++ ) {
            System.out.println(shapes[i].print());
        }
    }

    static void sort(CommonShape[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            for (int j = i; j < unsorted.length; j++) {
                if (unsorted[i].compare(unsorted[j]) == 1) {
                    CommonShape temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;
                }
            }
        }
    }
}
