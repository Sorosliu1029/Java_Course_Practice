package week8;

/**
 * Created by liuyang on 16/4/20.
 */
public class Stack<E> {
    private LinkedList<E> st;

    Stack() {
        st = new LinkedList<E>();
    }

    public E pop() {
        return st.removeLast();
    }

    public void push(E e) {
        st.addLast(e);
    }

    public E peek() {
        return st.getLast().getValue();
    }

    public boolean empty() {
        return st.size() == 0;
    }

    public String toString() {
        return "From button to top: " + st;
    }

    public LinkedList<E> getSt() {
        return st;
    }
}
