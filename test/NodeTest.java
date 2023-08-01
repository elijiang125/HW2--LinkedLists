import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
        /*
    TODO: write test cases testing the accuracy of the methods marked with TODO.s.
     */

    Node node1 = new Node("storage", 1);

    Node node2 = new Node("food", 2);

    @Test
    public void testMethodOne() { //get keyword getReferences, and insertReferences

        node1.insertReference("Hi");
        assertEquals("storage", node1.getKeyword());

    }
}
