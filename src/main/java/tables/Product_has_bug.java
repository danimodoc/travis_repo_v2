package tables;

public class Product_has_bug {

    private int bug_id;
    private int product_id;

    public Product_has_bug(int bug_id, int product_id) {
        this.bug_id = bug_id;
        this.product_id = product_id;
    }

    public Product_has_bug() {
    }

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int bug_id) {
        this.bug_id = bug_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
