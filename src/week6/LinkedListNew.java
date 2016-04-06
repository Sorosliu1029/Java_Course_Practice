package week6;


class Element {
    private int n;
    private Element next;

    public void setNext(Element nextElement) {
        next = nextElement;
    }

    public void setNum(int num) {
        n = num;
    }

    public int getNum() {
        return n;
    }

    public Element getNext() {
        return next;
    }
}

class LinkList {
    Element first = null;
    Element last = null;

    public boolean removeFirst() {
        if (first == null) {
            return false;
        }
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        return true;
    }

    public int getFirst() {
        if (first == null) {
            return Integer.MIN_VALUE;
        }
        return first.getNum();
    }

    public int getSize() {
        int ret = 0;
        Element curElement = first;
        if (curElement == null) {
            return 0;
        }
        while (true) {
            ret++;
            curElement = curElement.getNext();
            if (curElement == null) {
                return ret;
            }
        }
    }

    public void add(int i) {
        if (last == null) {
            first = new Element();
            first.setNum(i);
            last = first;
        } else {
            Element newLast = new Element();
            newLast.setNum(i);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public boolean delete(int i) {
        boolean flag = false;
        Element virtualElement = new Element();
        virtualElement.setNext(first);

        Element curElement = virtualElement;
        Element nextElement;
        while (true) {
            nextElement = curElement.getNext();
            if (nextElement == null) {
                break;
            }
            if (nextElement.getNum() == i) {// remove nextElement
                flag = true;
                if (nextElement == last) {
                    last = curElement;
                }
                curElement.setNext(nextElement.getNext());
                continue;
            }
            curElement = curElement.getNext();
            if (curElement == null) {
                break;
            }
        }

        first = virtualElement.getNext();
        if (last == virtualElement) {
            last = first;
        }
        return flag;
    }

    public boolean isExist(int i) {
        Element curElement = first;
        if (curElement == null) {
            return false;
        }
        while (true) {
            if (curElement.getNum() == i) {
                return true;
            }
            curElement = curElement.getNext();
            if (curElement == null) {
                return false;
            }
        }
    }

    public void print() {
        Element curElement = first;
        while (curElement != null) {
            System.out.print(curElement.getNum() + " ");
            curElement = curElement.getNext();
        }
        System.out.println();
        System.out.println("---------------");
        return;
    }
}

class Student {
    public char name[] = new char[10];
    public double gpa;
    public int studentID;


    void setName(char[] studentName) {
        for (int j = 0; j < name.length && j < studentName.length; j++) {
            // only get the first 10
            name[j] = studentName[j];
        }
    }

    boolean compareSID(Student s2) {
        return studentID > s2.studentID;
    }

    boolean compareGPA(Student s2) {
        return gpa > s2.gpa;
    }
};


/* Task 1
 *
 *  StudentNew extends Student
 *   (1) add a 'String' member variable 'name'
 *   (2) override the setName method
 *   	signature:  setName(String studentName)
 *   	It sets the 'name' of the StudentNew class and that of the Student class
 */
class StudentNew extends Student {
    //todo
    public String name;

    void setName(String studentName) {
        name = studentName;
        super.setName(studentName.toCharArray());
    }
}


/* Task 2
 *
 *  ElementNew extends Element
 *    Please complete the following todo
 */
class ElementNew extends Element {
    private StudentNew record;
    ElementNew(StudentNew rec) {
        record = rec;
    }
    public void setRecord(ElementNew rec) {
        //todo
        record = rec.record;
    }

    public StudentNew getRecord() {
        return record;
    }
}

/* Task 3
 *
 *  Complete the LinkedListNew class. The correct result
 *  of the main method is to print
 *  1 2 3 4 5 1 2 3
 *  ---------------
 *  1 2 3 4 5 1 2 3 1
 *  ---------------
 *  2 3 4 5 2 3
 *  ---------------
 *  3 4 5 3
 *  ---------------
 *  4 5
 *  ---------------
 *  5
 *  ---------------
 *
 *  ---------------
 *  1
 *  ---------------
 *
 */

public class LinkedListNew extends LinkList {


    public void add(StudentNew s) {
        //please invoke setRecord in ElementNew to add s into the list
        if (last == null) {
            first = new ElementNew(s);
            first.setNum(s.studentID);
            last = first;
        } else {
            ElementNew newLast = new ElementNew(s);
            newLast.setNum(s.studentID);
            last.setNext(newLast);
            last = newLast;
        }
    }

    public static void main(String argv[]) {
        int[] numbers = {1, 2, 3, 4, 5, 1, 2, 3};
        LinkedListNew list = new LinkedListNew();
        StudentNew s;
        for (int i : numbers) {
            s = new StudentNew();
            s.studentID = i;
            list.add(s);
        }
        list.print();
        s = new StudentNew();
        s.studentID = 1;
        list.add(s);
        list.print();
        list.delete(1);
        list.print();
        list.delete(2);
        list.print();
        list.delete(3);
        list.print();
        list.delete(4);
        list.print();
        if (list.delete(5)) {
            list.print();
        } else {
            System.out.println("Delete Nothing");
        }
        s = new StudentNew();
        s.studentID = 1;
        list.add(s);
        list.print();
        return;
    }
}
