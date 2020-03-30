package tables;

public class Bug_details {

    private String screenshot;
    private String tag;
    private String bug_id;

    public Bug_details(String screenshot, String tag, String bug_id) {
        this.screenshot = screenshot;
        this.tag = tag;
        this.bug_id = bug_id;
    }

    public Bug_details() {
    }

    public String getScreenshot() {
        return screenshot;
    }

    public void setScreenshot(String screenshot) {
        this.screenshot = screenshot;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getBug_id() {
        return bug_id;
    }

    public void setBug_id(String bug_id) {
        this.bug_id = bug_id;
    }
}
