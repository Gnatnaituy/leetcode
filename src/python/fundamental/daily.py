from typing import List


class JuneFifth:
    """
    2020/06/12 15. 三数之和
    给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
    请你找出所有满足条件且不重复的三元组。

    示例：
    给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [[-1, 0, 1],[-1, -1, 2]]

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/3sum
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    """

    @staticmethod
    def threeSum(nums: List[int]) -> List[List[int]]:
        """
        1116ms/40.99%/16.4MB/9.64%
        :param nums:
        :return:
        """
        res = []
        if not nums or len(nums) < 3:  # 如果数组为null或者长度小于3 返回[]
            return res

        nums.sort()  # 对数组排序
        for i in range(len(nums)):
            if nums[i] > 0:  # 因为已经排好序，如果nums[i] > 0，则后面不可能有三数之和等于零
                return res
            if i > 0 and nums[i] == nums[i - 1]:  # 重复元素跳过，避免出现重复解
                continue

            left, right = i + 1, len(nums) - 1  # nums[i]为小数 nums[left]为中数 nums[right]为大数
            while left < right:
                if nums[i] + nums[left] + nums[right] == 0:  # 如果三个数相加等于零
                    res.append([nums[i], nums[left], nums[right]])
                    while left < right and nums[left] == nums[left + 1]:  # 跳过左边的重复元素
                        left += 1
                    while left < right and nums[right] == nums[right - 1]:  # 跳过右边的重复元素
                        right -= 1
                    left += 1
                    right -= 1
                elif nums[i] + nums[left] + nums[right] > 0:  # 如果结果和大于零 减小大数
                    right -= 1
                else:  # 如果结果和小于零 增大中数
                    left += 1

        return res


class JuneNinth:
    """
    2020/06/19 125. 验证回文串
    给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    说明：本题中，我们将空字符串定义为有效的回文串。

    示例 1:
    输入: "A man, a plan, a canal: Panama"
    输出: true
    示例 2:
    输入: "race a car"
    输出: false

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-palindrome
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    """

    @staticmethod
    def isPalindrome(s: str) -> bool:
        """
        51ms/81.52%/13.7MB/55.56%
        双指针法，不是字母或数字就跳过
        :param s:
        :return:
        """
        s, left, right = s.lower(), 0, len(s) - 1
        while left < right:
            while left < right and not s[left].isalnum():
                left += 1
            while right > left and not s[right].isalnum():
                right -= 1
            if s[left] != s[right]:
                return False
            left, right = left + 1, right - 1

        return True

    @staticmethod
    def isPalindrome(s: str) -> bool:
        """
        52ms/81.52%/14.4MB/37.04%
        去除所有字母和数字以外的的字符
        判断原字符串是否和翻转后的字符串相同
        :param s:
        :return:
        """
        s = ''.join(filter(str.isalnum, s.lower()))
        return s == s[::-1]


if __name__ == '__main__':
    print(JuneNinth.isPalindrome("OP"))
