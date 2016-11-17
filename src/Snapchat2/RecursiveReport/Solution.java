package Snapchat2.RecursiveReport;

import java.util.*;

public class Solution {
    static class Record {
        String employeeName;
        String managerName;
        int itemsSold;

        public Record(String employeeName, String managerName, int itemsSold) {
            this.employeeName = employeeName;
            this.managerName = managerName;
            this.itemsSold = itemsSold;
        }
    }

    static class Employee {
        String name;
        List<Employee> reports;
        int selfItemCount;
        int reportItemCount;

        public Employee(String name) {
            this.name = name;
            reports = new LinkedList<>();
            selfItemCount = 0;
            reportItemCount = 0;
        }


        /*
            Alice 16
            |-Bob 8
            | |-Carol 2
            | \_David 3
            \_Eve 3
              \_Ferris 1
        * */
        @Override
        public String toString() {
            return internalToString("");
        }

        private String internalToString(String prefix) {
            StringBuffer sb = new StringBuffer(prefix);
            if (prefix.length() != 0) {
                sb.append('-');
                if (prefix.charAt(prefix.length()-1) == '\\') {
                    prefix = prefix.substring(0, prefix.length()-1) + " ";
                }
            }
            sb.append(name + " " + (selfItemCount + reportItemCount));

            if (!reports.isEmpty()) {
                for (int i = 0; i < reports.size(); i++) {
                    sb.append("\n");
                    if (i == reports.size()-1) {
                        sb.append(reports.get(i).internalToString(prefix + " \\"));
                    } else {
                        sb.append(reports.get(i).internalToString(prefix + " |"));
                    }
                }
            }
            return sb.toString();
        }
    }

    public Employee process(List<Record> records) {
        Map<String, Employee> map = new HashMap<>(records.size());
        Employee ceo = null;
        for (Record record : records) {
            if (!map.containsKey(record.employeeName)) {
                map.put(record.employeeName, new Employee(record.employeeName));
            }
            if (record.managerName == null) {
                ceo = map.get(record.employeeName);
            } else {
                if (!map.containsKey(record.managerName)) {
                    map.put(record.managerName, new Employee(record.managerName));
                }
                Employee report = map.get(record.employeeName);
                if (!map.get(record.managerName).reports.contains(report)) {
                    map.get(record.managerName).reports.add(report);
                }
            }
            map.get(record.employeeName).selfItemCount += record.itemsSold;
        }

        if (ceo != null) {
            aggregate(ceo);
        }
        return ceo;
    }

    private void aggregate(Employee employee) {
        for (Employee report : employee.reports) {
            aggregate(report);
            employee.reportItemCount += report.selfItemCount + report.reportItemCount;
        }
    }

    public static void main(String[] args) {
        List<Record> records = Arrays.asList(
          new Record("Alice",null,5),
          new Record("Bob","Alice",3),
          new Record("Carol","Bob",2),
          new Record("David","Bob",3),
          new Record("Ann","David",3),
          new Record("Eve","Alice",2),
          new Record("Ferris","Eve",1)
        );
        System.out.println(new Solution().process(records));
    }
}
