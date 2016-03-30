package week5;

public class MyStringEfficiencyComparison {
    static final double TIMES1 = 1e6;
    static final double TIMES2 = 1e6;
    public static void main(String[] args) {
        String stringOrig = "1234567812345678123456781234567812345678123456781234567812345679";
        char[] chars = stringOrig.toCharArray();
        String stringToBeFound = "123456789";
        char[] dest = stringToBeFound.toCharArray();

        String stringToBeReplaced = "1234567";
        char[] toBeReplaced = stringToBeReplaced.toCharArray();


        long startTime;
        long endTime;

        MyString a;
        startTime = System.currentTimeMillis(); //Get current time
        for (int i = 0; i < TIMES1; i++) {
            a = new MyString(chars);
            a.indexOf(dest);
            //System.out.println("ret = " + a.indexOf(dest));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms" + MyString.counter);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES1; i++) {
            stringOrig.indexOf(stringToBeFound);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES2; i++) {
            a = new MyString(chars);
            a.replace(toBeReplaced, dest);
            //System.out.println("ret = " + a.indexOf(dest));
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms" + MyString.counter);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < TIMES2; i++) {
            stringOrig.replace(stringToBeReplaced, stringToBeFound);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");

    }
}