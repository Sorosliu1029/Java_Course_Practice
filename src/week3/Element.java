package week3;
/**
 * Created by liuyang on 16/3/22.
 */
/** Node in the one-way linked list (only contain integer) */
public class Element {
    int n;
    Element succ;

    Element(int e, Element s) {
        n = e;
        succ = s;
    }
}
