package start;
import tables.Bug;
import tables.Bug_crud;
import tables.Product;

public class MainClass {
    public static void main(String[] args){

        Product newP = new Product("Machine Learner");
        //newP.insert();
        Product p2=newP.findById(2);

        //Product p3= new Product("Robot Cop");

        //newP.deleteById(4);

        System.out.println(p2.getProduct_id()+" and "+p2.getName());

        //Bug_crud  methods= new Bug_crud();
        //Bug newBug = new Bug("Problems Engine",2,true,80);

        //methods.insert(newBug);

    }
}
