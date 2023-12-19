package leetcode.Contest_All.单周塞.周赛355.题1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wu
 * @date 2023年07月23日 15:33
 */
public class Solution {

    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int idx = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (!word.substring(idx, i).equals(""))
                        ans.add(word.substring(idx, i));
                    idx = i + 1;
                }
            }
            if (idx < word.length()) ans.add(word.substring(idx));
        }
        return ans;
    }
}