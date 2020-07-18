package ninke;

/**
 * @Author: tingyin
 * @Version: 1.0.0
 * @Date: Created in 2020/7/18 10:22.
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = "I am a student";
        char[] c = s.toCharArray();
        for (int i =c.length -1 ; i >= 0; i--) {
            System.out.print(c[i]);
        }
    }
}
