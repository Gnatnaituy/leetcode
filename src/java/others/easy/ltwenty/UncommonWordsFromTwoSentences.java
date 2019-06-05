package java.others.easy.ltwenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884 Uncommon Words from Two Sentences
 */

public class UncommonWordsFromTwoSentences {

    private String[] uncommonFromSentences(String A, String B) {
        List<String> list = new ArrayList<>();
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        for (String word : a)
            mapA.put(word, mapA.get(word) == null ? 1 : mapA.get(word) + 1);
        for (String word : b)
            mapB.put(word, mapB.get(word) == null ? 1 : mapB.get(word) + 1);
        
        for (Map.Entry<String, Integer> entry : mapA.entrySet())
            if (entry.getValue() == 1 && mapB.get(entry.getKey()) == null)
                list.add(entry.getKey());
            
        for (Map.Entry<String, Integer> entry : mapB.entrySet())
            if (entry.getValue() == 1 && mapA.get(entry.getKey()) == null)
                list.add(entry.getKey());
            
        return list.toArray(new String[0]);
    }
    
    public static void main(String[] args) {
        UncommonWordsFromTwoSentences demo = new UncommonWordsFromTwoSentences();
        String A = "good sun fat son last will";
        String B = "fire fox jump the tree last will";
        String[] a = A.split(" ");
        String[] res = demo.uncommonFromSentences(A, B);
        for (String word : res)
            System.out.println(word);
    }
}
