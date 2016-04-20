package week8;
/**
 * Created by liuyang on 16/4/20.
 */
class Node<E> {
    private E id;
    private LinkedList<Node<E>> neighbours;

    Node(E i) {
        id = i;
        neighbours = new LinkedList<Node<E>>();
    }

    public void setNeighbours(Node<E> neigh) {
        neighbours.addLast(neigh);
    }

    public E getId() {
        return id;
    }

    public LinkedList<Node<E>> getNeighbours() {
        return neighbours;
    }

    public String toString() {
        String result = id + ": ";
        for (int i = 0; i < neighbours.size(); i++) {
            result += neighbours.get(i).getId() + ", ";
        }
        return result;
    }
}
public class Dynamic_Graph<T> {
    private LinkedList<Node<T>> graph;

    Dynamic_Graph() {
        graph = new LinkedList<Node<T>>();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < graph.size(); i++) {
            result += graph.get(i) + "\n";
        }
        return result;
    }

    public void addNode(Node<T> node) {
        graph.addLast(node);
    }

    public boolean hasPath(Node<T> a, Node<T> b) {
        Stack<Node<T>> s = new Stack<Node<T>>();
        LinkedList<Node<T>> nei = a.getNeighbours();
        for (int i = 0; i < nei.size(); i++) {
            s.push(nei.get(i));
        }
        while(! s.empty()) {
            Node<T> top = s.pop();
            if (top == a) {
                return false;
            } else if (top != b) {
                for (int i = 0; i < top.getNeighbours().size(); i++) {
                    Node<T> tmp = top.getNeighbours().get(i);
                    if (!s.getSt().contains(tmp)) {
                        s.push(tmp);
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String argv[]) {
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);
        Node<Integer> node3 = new Node<Integer>(3);
        Node<Integer> node4 = new Node<Integer>(4);
        node1.setNeighbours(node2);
        node1.setNeighbours(node3);
        node2.setNeighbours(node1);
        node3.setNeighbours(node1);
        Dynamic_Graph<Integer> g = new Dynamic_Graph<Integer>();
        g.addNode(node1);
        g.addNode(node2);
        g.addNode(node3);
        g.addNode(node4);
        System.out.println(g);
        System.out.println(g.hasPath(node1, node2));
        System.out.println(g.hasPath(node1, node3));
        System.out.println(g.hasPath(node1, node4));
    }
}