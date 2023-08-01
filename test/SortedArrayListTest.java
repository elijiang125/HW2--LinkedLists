import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SortedArrayListTest {
    /*
    TODO: write test cases testing the accuracy of the methods marked with TODO. Write an efficiency test which asserts that the
    SortedArrayTest is faster than the ArrayList. Be sure to test for edge cases.
     */

    SortedArrayList arrayList1 = new SortedArrayList(); //test first constructor
    SortedArrayList arrayList2 = new SortedArrayList(5); //test second constructor

    SortedArrayList arrayList3 = new SortedArrayList(); //test first constructor

    SortedArrayList arrayList4 = new SortedArrayList(20); //test second constructor


    @Test
    public void testMethodOne() { //get method

        assertEquals(0, arrayList1.size());
        assertEquals(0, arrayList2.size());
    }

    @Test
    public void testMethodTwo() { //add method
        arrayList1.add("f");
        arrayList2.add("e");
        arrayList1.add("a");
        arrayList2.add("l");
        arrayList1.add("r");
        arrayList2.add("i");
        arrayList1.add("t");
        arrayList2.add("z");
        arrayList2.add("a");

        assertEquals("f", arrayList1.get(0));
        assertEquals("a", arrayList1.get(1));
        assertEquals("r", arrayList1.get(2));
        assertEquals("t", arrayList1.get(3));

        assertEquals("a", arrayList2.get(0));
        assertEquals("e", arrayList2.get(1));
        assertEquals("i", arrayList2.get(2));
        assertEquals("l", arrayList2.get(3));
        assertEquals("z", arrayList2.get(4));
    }

    @Test
    public void testMethodThree() { //delete method

        arrayList1.add("f");
        arrayList2.add("e");
        arrayList1.add("a");
        arrayList2.add("l");
        arrayList1.add("r");
        arrayList2.add("i");
        arrayList1.add("t");
        arrayList2.add("z");
        arrayList2.add("a");

        arrayList1.delete(1);
        arrayList2.delete(2);

        assertEquals("r", arrayList1.get(1));
        assertEquals("z", arrayList2.get(2));

    }

    @Test
    public void testMethodFour() { //search method

        arrayList1.add("f");
        arrayList2.add("e");
        arrayList1.add("a");
        arrayList2.add("l");
        arrayList1.add("r");
        arrayList2.add("i");
        arrayList1.add("t");
        arrayList2.add("z");
        arrayList2.add("a");

        arrayList3.add("f");
        arrayList4.add("f");
        arrayList3.add("a");
        arrayList4.add("a");
        arrayList3.add("r");
        arrayList4.add("r");
        arrayList3.add("t");
        arrayList4.add("t");


        assertEquals(true, arrayList1.equals(arrayList2));
        assertEquals(false, arrayList3.equals(arrayList4));

    }

    @Test
    public void testMethodFive() { //equals method, does not work

        arrayList1.add("f");
        arrayList2.add("e");
        arrayList1.add("a");
        arrayList2.add("l");
        arrayList1.add("r");
        arrayList2.add("i");
        arrayList1.add("t");
        arrayList2.add("z");
        arrayList2.add("a");

        arrayList1.delete(1);
        arrayList2.delete(2);

        assertEquals("r", arrayList1.get(1));
        assertEquals("z", arrayList2.get(2));

    }
}
