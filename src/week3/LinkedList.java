package week3;
/**
 * Created by liuyang on 16/3/22.
 */
/** One-way linked list can only contain integer element */
public class LinkedList {
    private int size;       // Number of nodes in the linked list
    private Element head;   // First node of the linked list (null if none)

    /** Constructor: an empty linked list */
    public LinkedList() {
        size = 0;
        head = new Element(-1, null);       // "-1" is just an arbitrary number
    }

    /** Return the head node of this linked list */
    public Element getHead() {
        return head;
    }

    /** Return the number of elements in the linked list */
    public int getSize() {
        return size;
    }

    /** Return the linked list represented in string, elements separated by ", " */
    public String toString() {
        String result = "[";
        Element e = head.succ;
        while (e != null) {
            if (result.length() > 1) {
                result = result + ", ";
            }
            result = result + e.n;
            e = e.succ;
        }
        return result + "]";
    }

    /** Delete all elements whose n == e.n */
    public boolean delete(Element e) {
        assert e != null;
        if (size == 0) {
            return false;
        }
        boolean deleted = false;
        Element ele = head;
        while(ele.succ != null) {
            if (ele.succ.n == e.n) {
                ele.succ = ele.succ.succ;
                deleted = true;
                size --;
            } else {
                ele = ele.succ;
            }
        }
        return deleted;
    }

    /** Search the linked list to see whether exists an element whose n == e.n */
    public boolean isExist(Element e) {
        assert e != null;
        Element cur = head;
        while(cur != null) {
            if (cur.n == e.n) {
                return true;
            }
            cur = cur.succ;
        }
        return false;
    }

    /** Add element e to linked list in the head position */
    public void addToHead(Element e) {
        assert e != null;
        e.succ = head.succ;
        head.succ = e;
        size ++;
    }
    /** Add element e to linked list in the tail position */
    public void addToTail(Element e) {
        assert e != null;
        Element cur = head.succ;
        while(cur != null && cur.succ != null) {
            cur = cur.succ;
        }
        if (head.succ == null) {
            head.succ = e;
        } else {
            cur.succ = e;
        }
        e.succ = null;
        size ++;
    }

    /** Clear all elements in the linked list */
    public void clear() {
        head.succ = null;
        size = 0;
    }
}
