package completefifties.b;


import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；
 * 也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 */
public class TextJustification {

    /**
     * 0ms 100%
     * 37.3% 0.00%
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int curLen = 0;

        for (String word : words) {
            //当前字符串长度+cur字符串长度+最少空格数加一(算上当前word)大于 maxWidth 的情况下.将cur中的单词进行分布
            if (word.length() + curLen + cur.size() > maxWidth) {

                //设置默认resStr为cur的第一个单词
                StringBuilder resStr = new StringBuilder(cur.get(0));
                //设置空格总个数
                int scopeNum = maxWidth - curLen;
                //空格的区间数(为所有单词数-1)
                int block = cur.size() - 1;

                //处理cur中只有一个单词的情况.就是直接在单词后面填充空格就完事了
                if (cur.size() == 1) {
                    for (int i = 0; i < scopeNum; i++) {
                        resStr.append(" ");
                    }
                    //把生成好的字符放入res
                    res.add(resStr.toString());
                    //由于cur只有一个元素.直接删除就完事了
                    cur.remove(0);
                    //最后别忘记把当前word放入cur
                    cur.add(word);
                    //重新设置cur字符长度
                    curLen = word.length();
                    continue;
                }


                //说明要尽量均匀分配.如果在无法完全均匀分配的情况下.我们将余出来的一些空格均匀分布到前几个区间上
                // distribution 表示需要将空格分布多少个区间  如:8%3.则将空格均匀分布前两个区间
                int distribution = scopeNum % block;
                //每个空格区间的长度
                int scope = scopeNum / block;
                //从第二个元素开始添加
                for (int i = 1; i < cur.size(); i++) {
                    //将空格区间添加进去
                    for (int j = 0; j < scope; j++) {
                        resStr.append(" ");
                    }
                    //将空格均匀分布到前面的区间.直到 distribution 小于等于0.分布结束
                    resStr.append(distribution-- <= 0 ? "" : " ");
                    //将word添加到空格后面
                    resStr.append(cur.get(i));
                }
                //把生成好的字符放入res
                res.add(resStr.toString());
                //重置cur
                cur = new ArrayList<>();
                //放入当前word
                cur.add(word);
                //重新设置cur字符长度
                curLen = word.length();
            } else {
                cur.add(word);
                curLen += word.length();
            }
        }

        //处理最后cur中剩下的单词
        if (!cur.isEmpty()) {
            //获取第一个单词
            StringBuilder resStr = new StringBuilder(cur.get(0));

            //直接把所有单词拼接.并只用一个空格隔开
            for (int i = 1; i < cur.size(); i++) {
                resStr.append(" ").append(cur.get(i));
            }
            //把剩余的空格填充满
            int resStrLen = maxWidth - resStr.length();
            for (int i = 0; i < resStrLen; i++) {
                resStr.append(" ");
            }
            //将生成的字符放入res
            res.add(resStr.toString());
        }

        return res;
    }
}
