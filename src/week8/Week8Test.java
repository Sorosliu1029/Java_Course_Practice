package week8;

import junit.framework.Test;

/**
 * Created by liuyang on 16/4/20.
 */
class MyClass {
    int i;
    String s;

    MyClass(int a, String b) {
        i = a;
        s = b;
    }

    public String toString() {
        return i + " " + s;
    }
}

public class Week8Test {
    static class Test<T> {
        Stack<T> s;
        Test() {
            s = new Stack<T>();
        }
        public void test(T[] testcase) {
            for (T ele :
                    testcase) {
                s.push(ele);
            }
            System.out.println(s);
            System.out.println(s.peek());
            for (int i = 0; i < 3; i++) {
                s.pop();
            }
            System.out.println(s);
            System.out.println(s.empty());
        }
    }
    public static void main(String argv[]) {
        Test<Integer> test1 = new Test<Integer>();
        Integer[] testcase1 = {1, 2, 3};
        test1.test(testcase1);

        Test<String> test2 = new Test<String>();
        String[] testcase2 = {"Hello", "World", "Java"};
        test2.test(testcase2);

        Test<MyClass> test3 = new Test<MyClass>();
        MyClass[] testcase3 = {new MyClass(1,"a"), new MyClass(2, "b"), new MyClass(3, "c")};
        test3.test(testcase3);
    }
}
