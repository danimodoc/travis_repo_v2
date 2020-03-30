package tables;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    public void testFindById(){
         Product newP = new Product();
         assertEquals("Archiver Soft",newP.findById(2).getName(),"At id 2 there is archiver soft");
         assertEquals("Speed Soft",newP.findById(1).getName(),"At id 2 there is speed soft");
         assertEquals("Rocket Launcher",newP.findById(3).getName(),"At id 2 there is rocket launcher");
    }

    @Test
    public void testInsert(){
        Product newP = new Product("Test Product");
        int inserted_id=newP.insert();
        assertEquals(inserted_id,newP.findById(inserted_id).getProduct_id(),"There should be a new Id");

    }
}