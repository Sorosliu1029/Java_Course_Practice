package week3;
/**
 * Created by liuyang on 16/3/22.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTester {
    @Test
    public void testConstructor() {
        LinkedList ll = new LinkedList();
        assertEquals("[]", ll.toString());
        assertEquals(0, ll.getSize());
    }

    @Test
    public void testAddToHead() {
        LinkedList ll = new LinkedList();
        Element ele;
        for (int i = 0; i < 10; i++) {
            ele = new Element(i, null);
            ll.addToHead(ele);
        }
        assertEquals("[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]", ll.toString());
        assertEquals(10, ll.getSize());
    }

    @Test
    public void testAddToTail() {
        LinkedList ll = new LinkedList();
        Element ele;
        for (int i = 0; i < 10; i++) {
            ele = new Element(i, null);
            ll.addToTail(ele);
        }
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", ll.toString());
        assertEquals(10, ll.getSize());
    }

    @Test
    public void testClear() {
        LinkedList ll = new LinkedList();
        Element ele;
        for (int i = 0; i < 10; i++) {
            ele = new Element(i, null);
            ll.addToHead(ele);
        }
        ll.clear();
        assertEquals("[]", ll.toString());
        assertEquals(0, ll.getSize());
    }

    @Test
    public void testDelete() {
        LinkedList ll = new LinkedList();
        Element ele;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ele = new Element(j, null);
                ll.addToTail(ele);
            }
        }
        ele = new Element(0, null);
        boolean deleted = ll.delete(ele);
        assertEquals(true, deleted);
        assertEquals("[1, 2, 1, 2, 1, 2]", ll.toString());
        assertEquals(6, ll.getSize());
        ele = new Element(2, null);
        deleted = ll.delete(ele);
        assertEquals(true, deleted);
        assertEquals("[1, 1, 1]", ll.toString());
        assertEquals(3, ll.getSize());
        ele = new Element(3, null);
        deleted = ll.delete(ele);
        assertEquals(false, deleted);
        assertEquals("[1, 1, 1]", ll.toString());
        assertEquals(3, ll.getSize());
    }

    @Test
    public void testIsExist() {
        LinkedList ll = new LinkedList();
        Element ele;
        for (int i = 0; i < 5; i++) {
            ele = new Element(i, null);
            ll.addToTail(ele);
        }
        ele = new Element(0, null);
        assertEquals(true, ll.isExist(ele));
        ele = new Element(4, null);
        assertEquals(true, ll.isExist(ele));
        ele = new Element(5, null);
        assertEquals(false, ll.isExist(ele));
    }

}
