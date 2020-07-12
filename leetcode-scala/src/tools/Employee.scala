package tools

/**
 * @package tools
 * @author 余天堂
 * @create 2020/7/12 16:42
 * @description Employee
 */
class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List[Int] = List()

    def this(id: Int) {
        this
        this.id = id
    }

    def this(id: Int, importance: Int) {
        this(id)
        this.importance = importance
    }

    def this(id: Int, importance: Int, subordinates: List[Int]) {
        this(id, importance)
        this.subordinates = subordinates
    }
}
