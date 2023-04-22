#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        carry = 1
        length = len(digits)
        for i in range(length):
            sum = digits[length - i - 1] + carry
            carry = sum // 10
            digits[length - i - 1] = sum % 10
        if carry == 1:
            digits = [1] + digits
        return digits
# @lc code=end

