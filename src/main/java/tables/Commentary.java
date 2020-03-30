package tables;

public class Commentary {

    private String content;
    private int thread_id;
    private int employee_id;

    public Commentary() {
    }

    public Commentary(String content, int thread_id, int employee_id) {
        this.content = content;
        this.thread_id = thread_id;
        this.employee_id = employee_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }
}
