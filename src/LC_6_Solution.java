/**
 * Created by arthurcen on 7/20/17.
 * Solution for LeetCode 6 ZigZag Coversion
 */
import java.util.HashMap;
import java.lang.StringBuilder;

public class LC_6_Solution {
    static String ZigZagCoversion(String str, int n) {
      if (n < 2) {
        return str;
      }
      int m = (n - 1) * 2;
      HashMap<Integer, StringBuilder> map = new HashMap<>();
      StringBuilder sb;
      int box;
      for (int i = 0; i < str.length(); i++) {
        box = i % m;
        if (box > n - 1) {
          box = m - box;
        }
        if (map.containsKey(box)) {
          sb = map.get(box);
          sb.append(str.charAt(i));
        } else {
          sb = new StringBuilder("");
          sb.append(str.charAt(i));
          map.put(box, sb);
        }
      }
      StringBuilder result = new StringBuilder("");
      for (int j = 0; j < n; j++) {
        if (map.containsKey(j)) {
          result.append(map.get(j).toString());
        }
      }
      return result.toString();
    }
    public static void main(String[] args) {
      String input_1 = "A";
      String input_2 = "PAYPALISHIRING";
      String input_3 = "ABCDEF";

      int n1 = 1;
      int n2 = 2;
      int n3 = 3;

      System.out.println(ZigZagCoversion(input_1, n1));
      System.out.println(ZigZagCoversion(input_2, n2));
      System.out.println(ZigZagCoversion(input_2, n3));
      System.out.println(ZigZagCoversion(input_3, n3));

    }
}
