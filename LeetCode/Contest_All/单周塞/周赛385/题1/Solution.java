package leetcode.Contest_All.单周塞.周赛385.题1;

/**
 * @author Wu
 * @date 2023年12月12日 13:44
 */
public class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPreSuf(words[i], words[j])) ans++;
            }
        }
        return ans;
    }

    public boolean isPreSuf(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        int idx1 = s1.length() - 1, idx2 = s2.length() - 1;
        while (idx1 >= 0) {
            if (s1.charAt(idx1) != s2.charAt(idx2)) {
                return false;
            }
            idx1--;
            idx2--;
        }
        return true;
    }
}