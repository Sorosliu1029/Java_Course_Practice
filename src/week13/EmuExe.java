package week13;

/**
 * Created by liuyang on 16/5/24.
 */
public class EmuExe {
    public static void execute() {
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (Exception e) {
        }
    }
}
