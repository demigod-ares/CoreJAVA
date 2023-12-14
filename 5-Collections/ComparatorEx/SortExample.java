package ComparatorEx;

import java.util.ArrayList;
import java.util.Comparator;

public class SortExample {
    public static void main(String[] args){
        // Only one property can be changed at a time AND existing code will be changed while implementing comparable
        ArrayList<Employee> empList = new ArrayList<>();
        SortExample myExample = new SortExample();
        empList.add(myExample.new Employee("Siddharth", "9997447076", 7));
        empList.add(myExample.new Employee("Bhogendra", "7777447076", 2));
        empList.add(myExample.new Employee("Shashank", "8887447076", 11));
        empList.add(myExample.new Employee("Vishaal", "8887447076", 6));
        System.out.println(empList);
        // Collections.sort(empList); // Will not work until it implements comparator interface
        IdComparator idComparator = myExample.new IdComparator();
        empList.sort(idComparator);
        System.out.println(empList);
        PhoneComparator phoneComparator = myExample.new PhoneComparator();
        empList.sort(phoneComparator);
        System.out.println(empList);
        NameComparator nameComparator = myExample.new NameComparator();
        empList.sort(nameComparator);
        System.out.println(empList);
    }

    public class Employee {
        private String name;
        private String phone;
        private int empId;

        public Employee(String name, String phone, int empId) {
            this.name = name;
            this.phone = phone;
            this.empId = empId;
        }
        @Override
        public String toString() {
            return "Employee {" + name + " " + phone + " " + empId + "}";
        }
        public String getName() {
            return name;
        }
        public String getPhone() {
            return phone;
        }
        public int getEmpId() {
            return empId;
        }
    }
    public class NameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) { 
            return o1.getName().compareTo(o2.getName());
        }
    }
    public class PhoneComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) { 
            return o1.getPhone().compareTo(o2.getPhone());
        }
    }
    public class IdComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) { 
            return o1.getEmpId() - o2.getEmpId();
        }
    }
}