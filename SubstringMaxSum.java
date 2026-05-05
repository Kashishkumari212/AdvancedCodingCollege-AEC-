import java.util.*;

public class SubstringMaxSum {

    public static int maxSubStringSum(String s) {
        int n = s.length();
        String s2 = s + s;   

        Set<Character> set = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < s2.length(); right++) {
            char ch = s2.charAt(right);

            while (set.contains(ch)) {
                char leftChar = s2.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            set.add(ch);
            currentSum += (ch - 'a' + 1);
            if (right - left + 1 > n) {
                char leftChar = s2.charAt(left);
                set.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(maxSubStringSum(s)); 
    }
}
