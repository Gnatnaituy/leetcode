#
# @lc app=leetcode.cn id=766 lang=python3
#
# [766] 托普利茨矩阵
#

# @lc code=start
class Solution:

    # 遍历行 判断每个元素是否和它右下角的元素相等
    # 40ms      81.86%      O(mn)
    # 16.1MB    41.35%      O(1)
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        for i in range(len(matrix) - 1):
            if matrix[i][:-1] != matrix[i + 1][1:]:
                return False
        return True

    # 遍历对角线 先遍历第一列对角线 再遍历第一行对角线
    # 40ms      81.86%      O(mn)
    # 16.1MB    31.22%      O(1)
    def isToeplitzMatrix2(self, matrix: List[List[int]]) -> bool:
        row = len(matrix)
        col = len(matrix[0])
        
        for i in range(row):
            cur_value = matrix[i][0]
            row_index = i + 1
            col_index = 1
            while col_index < col and row_index < row:
                if matrix[row_index][col_index] != cur_value:
                    return False
                col_index += 1
                row_index += 1

        for i in range(col):
            cur_value = matrix[0][i]
            col_index = i + 1
            row_index = 1
            while col_index < col and row_index < row:
                if matrix[row_index][col_index] != cur_value:
                    return False
                col_index += 1
                row_index += 1
        
        return True

# @lc code=end

