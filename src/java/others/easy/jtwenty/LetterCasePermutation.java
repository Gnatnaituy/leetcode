package java.others.easy.jtwenty;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/**
 * 784 Letter Case Permutation
 */

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        char[] sArray = s.toLowerCase().toCharArray();
        for (char c : sArray) {
            int queueSize = queue.size();
            if (queueSize == 0) {
                queue.add(c + "");
                if (c >= 'a' && c <= 'z') {
                    queue.add(Character.toUpperCase(c) + "");
                }
            } else {
                while (queueSize > 0) {
                    String temp = queue.poll();
                    queue.add(temp + c);
                    if (c >= 'a' && c <= 'z') {
                        queue.add(temp + Character.toUpperCase(c));
                    }
                    queueSize--;
                }
            }
        }
        if (queue.size() == 0) {
            res.add("");
        } else {
            while (!queue.isEmpty()) {
                res.add(queue.poll());
            }
        }

        return res;
    }
}