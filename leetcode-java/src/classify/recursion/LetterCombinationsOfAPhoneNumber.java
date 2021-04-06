package classify.recursion;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yutiantang
 * @create 2021/4/5 12:46
 */
public class LetterCombinationsOfAPhoneNumber {

    /**
     * 7ms      9.84%
     * 38.9MB   5.19%
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> digitLetters = new HashMap<>();
        digitLetters.put((int) '2', Arrays.asList("a", "b", "c"));
        digitLetters.put((int) '3', Arrays.asList("d", "e", "f"));
        digitLetters.put((int) '4', Arrays.asList("g", "h", "i"));
        digitLetters.put((int) '5', Arrays.asList("j", "k", "l"));
        digitLetters.put((int) '6', Arrays.asList("m", "n", "o"));
        digitLetters.put((int) '7', Arrays.asList("p", "q", "r", "s"));
        digitLetters.put((int) '8', Arrays.asList("t", "u", "v"));
        digitLetters.put((int) '9', Arrays.asList("w", "x", "y", "z"));

        if (digits.equals("")) {
            return new ArrayList<>();
        }

        return digits.chars().map(o -> (char) o)
                .mapToObj(digitLetters::get)
                .reduce((ans, letters) ->
                        ans.stream().map(an ->
                                letters.stream()
                                        .map(letter -> an + letter)
                                        .collect(Collectors.toList()))
                                .reduce((o1, o2) -> {
                                    o1.addAll(o2);
                                    return o1;
                                }).get())
                .get();
    }


    /**
     * 0ms      100.00%
     * 37.3MB   43.68%
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
     * @param digits
     * @return
     */
    String[] letterMap = {"", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    //最终输出结果的list
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations2(String digits) {
        // 边界条件
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }

        iterStr(digits, new StringBuilder(), 0);

        return res;
    }

    void iterStr(String str, StringBuilder letter, int index) {
        //递归的终止条件，注意这里的终止条件看上去跟动态演示图有些不同，主要是做了点优化
        //动态图中是每次截取字符串的一部分，"234"，变成"23"，再变成"3"，最后变成""，这样性能不佳
        //而用index记录每次遍历到字符串的位置，这样性能更好
        if(index == str.length()) {
            res.add(letter.toString());
            return;
        }
        //获取index位置的字符，假设输入的字符是"234"
        //第一次递归时index为0所以c=2，第二次index为1所以c=3，第三次c=4
        //subString每次都会生成新的字符串，而index则是取当前的一个字符，所以效率更高一点
        char c = str.charAt(index);
        //map_string的下表是从0开始一直到9， c-'0'就可以取到相对的数组下标位置
        //比如c=2时候，2-'0'，获取下标为2,letterMap[2]就是"abc"
        int pos = c - '0';
        String mapString = letterMap[pos];
        //遍历字符串，比如第一次得到的是2，页就是遍历"abc"
        for (int i = 0; i < mapString.length(); i++) {
            //调用下一层递归，用文字很难描述，请配合动态图理解
            letter.append(mapString.charAt(i));
            //如果是String类型做拼接效率会比较低
            //iterStr(str, letter+mapString.charAt(i), index+1);
            iterStr(str, letter, index + 1);
            letter.deleteCharAt(letter.length() - 1);
        }
    }


    /**
     * 6ms      24.98%
     * 38.5MB   29.22%
     * 利用队列求解
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/tong-su-yi-dong-dong-hua-yan-shi-17-dian-hua-hao-m/
     * @param digits
     * @return
     */
    public List<String> letterCombinations3(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letterMap = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letterMap[digits.charAt(i) - '0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for(int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }

        return res;
    }
}
