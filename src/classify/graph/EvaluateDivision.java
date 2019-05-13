package classify.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<>();
        HashMap<String, ArrayList<Double>> valuePairs = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            if (!pairs.containsKey(equation.get(0))) {
                pairs.put(equation.get(0), new ArrayList<>());
                valuePairs.put(equation.get(0), new ArrayList<>());
            }
            if (!pairs.containsKey(equation.get(1))) {
                pairs.put(equation.get(1), new ArrayList<>());
                valuePairs.put(equation.get(1), new ArrayList<>());
            }
            pairs.get(equation.get(0)).add(equation.get(1));
            pairs.get(equation.get(1)).add(equation.get(0));
            valuePairs.get(equation.get(0)).add(values[i]);
            valuePairs.get(equation.get(1)).add(1 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            res[i] = dfs(query.get(0), query.get(1), pairs, valuePairs, new HashSet<>(), 1.0);
            res[i] = res[i] == 0.0 ? -1.0 : res[i];
        }

        return res;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs,
                       HashMap<String, ArrayList<Double>> valuePairs, HashSet<String> set,  double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;

        set.add(start);

        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valList = valuePairs.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, valuePairs, set, value * valList.get(i));
            if (tmp == 0.0) break;
        }
        set.remove(start);

        return tmp;
    }
}
