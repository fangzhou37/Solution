package SnapchatPhoneAndOnsite.LeastCommonManager;

import java.util.*;

public class Solution {
    static class Employee {
        int id;
        List<Employee> reports;

        public Employee(int id) {
            this.id = id;
            reports = new LinkedList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Employee employee = (Employee) o;

            return id == employee.id;

        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public String toString() {
            return "{" +
                    "id=" + id +
                    '}';
        }
    }

    Employee ceo;

    public Solution(Employee ceo) {
        this.ceo = ceo;
    }

    public Employee findLeastCommonManager(List<Employee> targets) {
        Set<Employee> targetSet = new HashSet<>();
        targetSet.addAll(targets);
        return findHelper(ceo, targetSet);
    }

    private Employee findHelper(Employee cur, Set<Employee> targetSet) {
        if (cur == null) {
            return null;
        }
        if (targetSet.contains(cur)) {
            return cur;
        }

        Employee found = null;
        for (Employee report : cur.reports) {
            Employee manager = findHelper(report, targetSet);
            if (manager == null) {
                continue;
            }
            if (found == null) {
                found = manager;
            } else {
                return cur;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Employee ceo = new Employee(0);
        Employee emp1 = new Employee(1);
        Employee emp2 = new Employee(2);
        Employee emp3 = new Employee(3);
        Employee emp4 = new Employee(4);
        Employee emp5 = new Employee(5);
        Employee emp6 = new Employee(6);
        Employee emp7 = new Employee(7);
        Employee emp8 = new Employee(8);
        ceo.reports.add(emp1);
        ceo.reports.add(emp4);
        ceo.reports.add(emp8);
        emp1.reports.add(emp2);
        emp1.reports.add(emp3);
        emp4.reports.add(emp5);
        emp4.reports.add(emp7);
        emp5.reports.add(emp6);

        Employee not_exist = new Employee(9);

        Solution s = new Solution(ceo);
        System.out.println(s.findLeastCommonManager(Arrays.asList(emp3, emp5, emp6)));
        System.out.println(s.findLeastCommonManager(Arrays.asList(emp7, emp5, emp6)));
        System.out.println(s.findLeastCommonManager(Arrays.asList(emp6)));
        System.out.println(s.findLeastCommonManager(new LinkedList<Employee>()));
        System.out.println(s.findLeastCommonManager(Arrays.asList(not_exist)));
        System.out.println(s.findLeastCommonManager(Arrays.asList(emp3, not_exist)));
    }
}
