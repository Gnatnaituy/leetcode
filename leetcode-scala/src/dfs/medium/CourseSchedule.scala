package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/23 10:49
 * @Description CourseSchedule
 */
object CourseSchedule {

    /**
     * 636ms    100.00%
     * 56.2MB   100.00%
     * BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    def canFinishBFS(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        val indegrees = Array.fill(numCourses)(0)
        val adjacency = Array.fill(numCourses)(mutable.Set[Int]())
        val queue = mutable.Queue[Int]()

        // Get the indegree and adjacency for every course
        prerequisites.foreach(pair => {
            indegrees(pair(0)) += 1
            adjacency(pair(1)) += pair(0)
        })
        // Get all the course with the indegree of 0
        queue.enqueueAll(Array.range(0, indegrees.length).filter(indegrees(_) == 0))
        var nums = numCourses
        while (queue.nonEmpty) {
            nums -= 1
            adjacency(queue.dequeue()).foreach(a => {
                indegrees(a) -= 1
                if (indegrees(a) == 0) {
                    queue.enqueue(a)
                }
            })
        }

        nums == 0
    }

    /**
     * 744ms    100.00%
     * 53.8MB   100.00%
     * DFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    def canFinishDFS(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

        def dfs(cur: Int, adjacency: Array[mutable.ListBuffer[Int]], flags: Array[Int]): Boolean = {
            if (flags(cur) == 1) return false
            if (flags(cur) == -1) return true

            flags(cur) = 1
            adjacency(cur).forall(dfs(_, adjacency, flags))
            flags(cur) = -1

            true
        }

        val flags = Array.fill(numCourses)(0)
        val adjacency = Array.fill(numCourses)(mutable.ListBuffer[Int]())
        prerequisites.foreach(pre => adjacency(pre(0)) += pre(1))
        Array.range(0, numCourses).forall(dfs(_, adjacency, flags))
    }


    def main(args: Array[String]): Unit = {
        val prerequisites = Array(Array(1, 0), Array(1, 2), Array(1, 3), Array(2, 3), Array(3, 4))
        val numCourses = 5
        print(canFinishDFS(numCourses, prerequisites))
    }
}
