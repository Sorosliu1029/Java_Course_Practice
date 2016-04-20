package week8;

/**
 * Created by liuyang on 16/4/20.
 */

class Element<T> {
    private T v;
    private Element<T> next;
    private Element<T> pre;
    public void setNext(Element<T> nextElement) {
        next = nextElement;
    }
    public Element<T> getNext() {
        return next;
    }
    public void setPre(Element<T> preElement) {
        pre = preElement;
    }
    public Element<T> getPre() {
        return pre;
    }
    public void setValue(T value) {
        v = value;
    }
    public T getValue() {
        return v;
    }
}
public class LinkedList<E> {
    private Element<E> first = null;
    private Element<E> last = null;

    public Element<E> getFirst() {
        return first;
    }

    public Element<E> getLast() {
        return last;
    }

    public void addLast(E e) {
        if (last == null) {
            first = new Element<E>();
            first.setValue(e);
            first.setNext(null);
            first.setPre(null);
            last = first;
        } else {
            Element<E> newLast = new Element<E>();
            newLast.setValue(e);
            newLast.setPre(last);
            newLast.setNext(null);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public E removeLast() {
        if (last == null) {
            return null;
        } else if (last == first) {
            Element<E> rtLast = last;
            last = null;
            first = null;
            return rtLast.getValue();
        } else {
            Element<E> rtLast = last;
            last = last.getPre();
            last.setNext(null);
            return rtLast.getValue();
        }
    }

    public boolean contains(E e) {
        Element<E> curElement = first;
        if (curElement == null) {
            return false;
        }
        while (true) {
            if (curElement.getValue() == e) {
                return true;
            }
            curElement = curElement.getNext();
            if(curElement == null) {
                return false;
            }
        }
    }

    public E get(int index) {
        if (index >= this.size()) {
            return null;
        }
        int curIdx = 0;
        Element<E> curElement = first;
        for (;curIdx < index; curIdx ++) {
            curElement = curElement.getNext();
        }
        return curElement.getValue();
    }

    public int size() {
        int i = 0;
        Element<E> curElement = first;
        while (curElement != null) {
            i++;
            curElement = curElement.getNext();
        }
        return i;
    }

    public String toString() {
        String result = "";
        Element<E> curElement = first;
        while(curElement != null) {
            result += (curElement.getValue() + ", ");
            curElement = curElement.getNext();
        }
        return result;
    }

    public static void main(String argv[]) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.removeLast();
        System.out.println(ll);
        ll.addLast(4);
        ll.addLast(10);
        System.out.println(ll.contains(10));
        System.out.println(ll.contains(1));
        System.out.println(ll.contains(2));
        System.out.println(ll);
        System.out.println(ll.get(0));
        System.out.println(ll.get(2));
        System.out.println(ll.size());
    }
}
