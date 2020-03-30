package tables;

public class comment_thread {

    private String thread_name;
    private int bug_id;

    public comment_thread() {
    }

    public comment_thread(String thread_name, int bug_id) {
        this.thread_name = thread_name;
        this.bug_id = bug_id;
    }

    public String getThread_name() {
        return thread_name;
    }

    public void setThread_name(String thread_name) {
        this.thread_name = thread_name;
    }

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }
}
