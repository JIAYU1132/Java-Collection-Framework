import java.util.*;

// 比较字符串最小字母出现频次
public class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len1 = queries.length;
        int len2 = words.length;
        int[] queryRes = new int[len1];
        int[] wordRes = new int[len2];
        for (int i = 0; i < len1; i++) {
            queryRes[i] = numSmallerCount(queries[i]);
        }
        for (int i = 0; i < len2; i++) {
            wordRes[i] = numSmallerCount(words[i]);
        }
        for (int i = 0; i < len1; i++) {
            int count = 0;
            for (int j = 0; j < len2; j++) {
                if (queryRes[i] < wordRes[j]) {
                    count++;
                }
            }
            queryRes[i] = count;
        }
        return queryRes;
    }

    public int numSmallerCount(String str) {
        if (str == null || str.length()== 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char small = chars[0];
        int res = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == small) {
                res++;
            }
        }
        return res;
    }
}
