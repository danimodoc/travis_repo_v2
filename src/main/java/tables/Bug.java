package tables;

public class Bug {

    private String bug_name;
    private boolean status_bug;
    private int priority;
    private int emp_id;

    public Bug(String bug_name,int emp_id ,boolean status_bug, int priority) {
        this.bug_name = bug_name;
        this.emp_id=emp_id;
        this.status_bug = status_bug;
        this.priority = priority;
    }

    public Bug() {
    }

    public String getBug_name() {
        return bug_name;
    }

    public void setBug_name(String bug_name) {
        this.bug_name = bug_name;
    }

    public boolean isStatus_bug() {
        return status_bug;
    }

    public void setStatus_bug(boolean status_bug) {
        this.status_bug = status_bug;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
}
