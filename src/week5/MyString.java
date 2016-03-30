package week5;
/**
 * Created by liuyang on 16/3/30.
 * ID: 13307130167
 * name: 刘阳
 */

public class MyString {
    private final char[] value;
    // class construction counter
    public static int counter = 0;

    MyString(char[] v) {
        value = new char[v.length];
        System.arraycopy(v, 0, value, 0, v.length);

        counter ++;
    }

    // brute force algorithm
    public int indexOf(char[] v) {
        int i;  // the first index of the found substring
        int j;  // the index of the substring which is compared now

        // check if the v is empty string
        for (i = 0; i <= value.length - v.length; i++) {
            for (j = 0; j < v.length; j++) {
                // one character is different, so go to next iteration
                if (value[i+j] != v[j]) {
                    break;
                }
            }
            if (j == v.length) {
                return i;
            }
        }

        return -1;
    }

    public MyString concat(char[] v) {
        // concatenate the value and v array into temp array
        char[] temp = new char[value.length+v.length];
        System.arraycopy(value, 0, temp, 0, value.length);
        System.arraycopy(v, 0, temp, value.length, v.length);

        return new MyString(temp);
    }

    // recursion algorithm
    public MyString replace(char[] v1, char[] v2) {
        // find the first index where v1 occurs in value
        int index = indexOf(v1);

        // base case: no v1 found in value
        if (index == -1) {
            return this;
        }
        //recursive case:
        // e.g. value: {1, 2, 3, 4, 5, 6, 7, 8}
        //      v1:             {4}
        //      v2:             {9}
        //    split:   |<-left->|  |<-right->|
        else {
            // get the left part as left_string
            char[] left = new char[index];
            System.arraycopy(value, 0, left, 0, index);
            MyString left_string = new MyString(left);

            // left_string concatenate with v2 as replacement
            left_string = left_string.concat(v2);

            // get the right part as right_string
            int right_length = value.length-(index+v1.length);
            int right_start = index + v1.length;
            char[] right = new char[right_length];
            System.arraycopy(value, right_start, right, 0, right_length);
            MyString right_string = new MyString(right);

            // recursively replace v1 in the right_string with v2
            right_string = right_string.replace(v1, v2);

            // merge: concatenate left_string with right_string
            return left_string.concat(right_string.getValue());
        }
    }

    public int length() {
        return value.length;
    }

    public char[] getValue() {
        return value;
    }

    public String toString() {
        String result = "";
        for (char v: value) {
            result += v;
        }
        return result;
    }

    public static void main(String[] args) {
        char[] v = {'1', '2', '3'};
        MyString a = new MyString(v);
        char[] v1 = {'2', '3'};
        char[] v2 = {'1'};
        char[] v3 = {'4'};
        System.out.println(a.indexOf(v1));
        System.out.println(a.indexOf(v2));
        System.out.println(a.indexOf(v3));

        char[] v4 = {'4', '5', '6'};
        MyString concat_result = a.concat(v4);
        System.out.println(concat_result.getValue());

        System.out.println(a.replace(v3, v1).getValue());
        System.out.println(a.replace(v1, v2).getValue());
        System.out.println(a.replace(v2, v1).getValue());

        char[] ca1 = {'1', '2', '2'};
        MyString a1 = new MyString(ca1);
        char[] va1 = {'1', '2'};
        char[] va2 = {'1'};
        System.out.println(a1.replace(va1, va2).getValue());

        char[] ca2 = {'1', '2', '1', '2'};
        MyString a2 = new MyString(ca2);
        System.out.println(a2.replace(va1, va2).getValue());
    }
}
