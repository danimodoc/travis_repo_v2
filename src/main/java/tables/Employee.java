package tables;

public class Employee {
    private String emp_name;
    private String emp_position;

    public Employee(String emp_name, String emp_position) {
        this.emp_name = emp_name;
        this.emp_position = emp_position;
    }

    public Employee() {
    }

    public String getEmp_name() {
        return emp_name;
    }

    public String getEmp_position() {
        return emp_position;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public void setEmp_position(String emp_position) {
        this.emp_position = emp_position;
    }
}
