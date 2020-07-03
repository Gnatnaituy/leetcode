package others.easy.itwenty;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 690 Employee Importance
 */

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < employees.size(); i++) {
            map.put(employees.get(i).id, employees.get(i));
        }

        int[] flag = new int[2000];

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));

        int sum = 0;
        while(!queue.isEmpty()) {
            Employee e = queue.poll();
            flag[e.id] = 1;
            sum += e.importance;
            
            for (int i : e.subordinates) {
                if (flag[i] != 1) {
                    queue.offer(map.get(i));
                }
            }
        }

        return sum;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};