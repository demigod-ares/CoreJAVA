public class Employee {
    private int id;
    private String name;
    private int salary;
    private Address address;

    public Employee(int id, String name, int salary, Address address) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
