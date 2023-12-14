package StreamCollect;

public class Employee {
  private int empId;
  private String name;
  private int deptId;
  private String department;
  private boolean active;
  private int salary;

  public Employee(int empId, String name, int deptId, boolean active, int salary) {
    this.empId = empId;
    this.name = name;
    this.deptId = deptId;
    this.department = "Department" + deptId;
    this.active = active;
    this.salary = salary;
  }
  public int getDeptId(){
    return this.deptId;
  }
  public String getName() {
    return name;
  }
  public String getDepartment(){
    return this.department;
  }
  public boolean isActive(){
    return this.active;
  }
  public int getSalary() {
    return salary;
  }

  // override toString() method for this class
  @Override
    public String toString() {
        return "Person{empId:'" + empId +
          "', name:" + name +
          ", department:'" + department +
          "', salary:" + salary + "'}";
    }
}
