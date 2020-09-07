//package array
//
///**
// * @Project leetcode
// * @Author Ravooo
// * @Since 2020/9/1 22:43
// * @Description ThreeSum
// */
//object ThreeSum {
//
//    def threeSum(nums: Array[Int]): List[List[Int]] = {
//        var res = List[List[Int]]
//        val sortedNums = nums.sortWith(_ < _)
//        nums.length
//        Array.range(0, nums.length).foreach(index => {
//            if (index == 0 || (index > 0 && nums(index) > nums(index - 1))) {
//                val sum = nums(index)
//                var left = index + 1
//                var right = nums.length - 1
//                while (left < right) {
//                    if (nums(left) + nums(right) + sum == 0) {
////                        res = List(sum, nums(left), nums(right))
//                    }
//                }
//            }
//        })
//    }
//}
