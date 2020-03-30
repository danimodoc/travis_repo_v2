package tables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BugCrudTester {
    @Test
    public void insertTest(){
        Bug newBug = new Bug("Memory leak",2,true,87);
        Bug newBug2 = new Bug("Memory leak 2",3,true,54);
        Bug newBug3 = new Bug("Memory leak 3",1,true,45);
        int inserted_id = Bug_crud.insert(newBug);
        assertEquals("Memory leak",Bug_crud.read(inserted_id).getBug_name(),"At id 2 there is memory leak");

        int inserted_id2 = Bug_crud.insert(newBug);
        assertEquals("Memory leak 2",Bug_crud.read(inserted_id2).getBug_name(),"At id 2 there is memory leak 2");

        int inserted_id3 = Bug_crud.insert(newBug);
        assertEquals("Memory leak 3",Bug_crud.read(inserted_id3).getBug_name(),"At id 2 there is memory leak 3");
    }
}