package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/25 22:39
 * @Description CourseScheduleII
 */
object CourseScheduleII {

    /**
     * 684ms    100.00%
     * 55.6MB   100.00%
     * @param numCourses
     * @param prerequisites
     * @return
     */
    def findOrderBFS(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
        if (numCourses <= 0) return Array()

        val adjacency = Array.fill[mutable.HashSet[Int]](numCourses)(new mutable.HashSet[Int]())
        val indegrees = Array.fill[Int](numCourses)(0)
        prerequisites.foreach(pre => {
            adjacency(pre(1)).add(pre(0))
            indegrees(pre(0)) += 1
        })

        val queue = mutable.Queue[Int]()
        queue.enqueueAll(Array.range(0, numCourses).filter(indegrees(_) == 0))

        val res = Array.fill(numCourses)(0)
        var count = 0

        while (queue.nonEmpty) {
            val head = queue.dequeue()
            res(count) = head
            count += 1
            val successors = adjacency(head)
            successors.foreach(indegrees(_) -= 1)
            queue.enqueueAll(successors.filter(indegrees(_) == 0))
        }

        if (count == numCourses) res else Array()
    }

    def main(args: Array[String]): Unit = {
        val pres = Array(Array(1, 0), Array(0, 1))
        findOrderBFS(2, pres)
    }
}
