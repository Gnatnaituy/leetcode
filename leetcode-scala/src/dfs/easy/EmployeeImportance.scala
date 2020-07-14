package dfs.easy

import tools.Employee

import scala.collection.mutable

/**
 * @package dfs
 * @author 余天堂
 * @create 2020/7/12 16:35
 * @description EmployeeImportance
 */
object EmployeeImportance {

    /**
     * 660 ms   50.00%
     * 50.6 MB  100.00%
     * @param employees
     * @param id
     * @return
     */
    def getImportance(employees: List[Employee], id: Int): Int = {
        var employeeImportance = new mutable.HashMap[Int, Employee]()
        employees.foreach(emp => employeeImportance += (emp.id -> emp))

        def dfs(id: Int): Int = {
            val employee = employeeImportance(id)
            employee.subordinates.foreach(o => employee.importance += dfs(o))
            employee.importance
        }

        dfs(id)
    }
}
