package week13;

/**
 * Created by liuyang on 16/5/24.
 */
public class ThreadSync {
    public static void main(String[] args) {
        ThreadA t1 = new ThreadA();
        ThreadB t2 = new ThreadB();
        t1.start();
        t2.start();
    }
}
