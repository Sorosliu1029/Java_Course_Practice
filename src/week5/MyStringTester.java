package week5;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by liuyang on 16/3/30.
 * ID: 13307130167
 * name: 刘阳
 */

public class MyStringTester {
    String strOrig = "abcdababcdef";
    char[] strOrigArray = strOrig.toCharArray();
    String strTest1 = "ab";
    char[] strTest1Array = strTest1.toCharArray();
    String strTest2 = "g";
    char[] strTest2Array = strTest2.toCharArray();
    String strTest3 = "da";
    char[] strTest3Array = strTest3.toCharArray();
    String strTest4 = "de";
    char[] strTest4Array = strTest4.toCharArray();
    String strTest5 = "ef";
    char[] strTest5Array = strTest5.toCharArray();
    String strTest6 = "fg";
    char[] strTest6Array = strTest6.toCharArray();
    String strTest7 = "hij";
    char[] strTest7Array = strTest7.toCharArray();

    String strEmpty = "";
    char[] strEmptyArray = strEmpty.toCharArray();

    @Test
    public void testConstructor() {
        MyString ms = new MyString(strOrigArray);
        assertEquals(strOrig, ms.toString());
    }

    @Test
    public void testIndexOf() {
        MyString a = new MyString(strOrigArray);
        assertEquals(0, a.indexOf(strTest1Array));
        assertEquals(3, a.indexOf(strTest3Array));
        assertEquals(-1, a.indexOf(strTest2Array));
        assertEquals(9, a.indexOf(strTest4Array));
        assertEquals(10, a.indexOf(strTest5Array));
        assertEquals(-1, a.indexOf(strTest6Array));
        // test with itself
        assertEquals(0, a.indexOf(strOrigArray));
        // test with empty substring
        assertEquals(0, a.indexOf(strEmptyArray));
    }

    @Test
    public void testConcat() {
        MyString a = new MyString(strTest1Array);
        assertEquals("abab", a.concat(strTest1Array).toString());
        a = new MyString(strTest5Array);
        assertEquals("effg", a.concat(strTest6Array).toString());
        // test with empty string
        assertEquals("ef", a.concat(strEmptyArray).toString());
    }

    @Test
    public void testReplace() {
        MyString orig = new MyString(strOrigArray);
        assertEquals("gcdggcdef", orig.replace(strTest1Array, strTest2Array).toString());
        assertEquals("hijcdhijhijcdef", orig.replace(strTest1Array, strTest7Array).toString());
        assertEquals("abcdababcdfg", orig.replace(strTest5Array, strTest6Array).toString());
        // no substring replacement
        assertEquals(strOrig, orig.replace(strTest2Array, strTest7Array).toString());
        // replace itself with v2
        assertEquals("g", orig.replace(strOrigArray, strTest2Array).toString());
    }
}
