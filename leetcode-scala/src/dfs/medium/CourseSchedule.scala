package dfs.medium

import scala.collection.mutable

/**
 * @Project leetcode
 * @Author Ravooo
 * @Since 2020/7/23 10:49
 * @Description CourseSchedule
 */
object CourseSchedule {

    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {

        val preMap: mutable.Map[Int, Int] = mutable.Map()
        prerequisites.foreach(pre => preMap(pre(0)) = pre(1))

        val lenMap: mutable.Map[Int, Set[Int]] = mutable.Map()
        preMap.foreach(entry => lenMap(entry._1) = lenMap.getOrElse(entry._1, Set()) ++ Set(entry._2))

        lenMap.foreach(entry => {
            val validated
        })
    }

    def main(args: Array[String]): Unit = {
        val prerequisites = Array(Array(1, 0), Array(0, 1))
        val numCourses = 2
        print(canFinish(numCourses, prerequisites))
    }
}
