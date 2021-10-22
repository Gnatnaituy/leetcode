package others.completefifties.l0000;

public class UniqueBSTs {

    /**
     * 0ms 100%
     * 结题思路：
     * 假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
     * 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，
     * 所以可得G(n) = G(0) * G(n-1) + G(1) * (n-2) + ... + G(n-1) * G(0)
     */
    public int numTrees(int n) {
        int[] res = new int[n + 1];

        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                res[i] += res[j - 1] * res[i - j];
            }
        }

        return res[n];
    }
}
