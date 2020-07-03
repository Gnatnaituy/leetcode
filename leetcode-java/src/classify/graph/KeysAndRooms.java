package classify.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    /**
     * 2ms 83.46%
     * 42.4MB 20.00%
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> dfs = new Stack<>(); 
        dfs.add(0);
        HashSet<Integer> visited = new HashSet<>(); 
        visited.add(0);

        while (!dfs.isEmpty()) {
            int i = dfs.pop();
            for (int j : rooms.get(i))
                if (!visited.contains(j)) {
                    dfs.add(j);
                    visited.add(j);
                    if (rooms.size() == visited.size()) return true;
                }
        }

        return rooms.size() == visited.size();
    }
}
