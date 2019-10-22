package dfs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liangpf
 * @date 2019/10/17
 */
public class LC690 {

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for (Employee e: employees) map.put(e.id, e);
        return dfs(id);
    }
    public int dfs(int eid) {
        Employee employee = map.get(eid);
        int ans = employee.importance;
        for (Integer id: employee.subordinates)
            ans += dfs(id);
        return ans;
    }


}
