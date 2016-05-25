package week13;

import static week13.TwoThreads.*;

/**
 * Created by liuyang on 16/5/24.
 */
public class TwoThreads {
    public static volatile Object lock = new Object();
}

class ThreadA extends Thread {
    public static volatile int A = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "th the value of A is " + A);

//            if (ThreadA.A + ThreadB.B != 100) {
//                System.out.println("Error! NOT SYNCHRONIZED");
//                System.out.println("A=" + ThreadA.A);
//                System.out.println("B=" + ThreadB.B);
//                System.exit(1);
//            }

            synchronized (lock) {
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
                incA();
            }
        }
    }

    private void incA() {
        A++;
    }
}

class ThreadB extends Thread {
    public static volatile int B = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + "th the value of B is " + B);

            synchronized (lock) {
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                }
                decB();
            }
        }

    }

    private void decB() {
        B--;
        EmuExe.execute();
    }
}

