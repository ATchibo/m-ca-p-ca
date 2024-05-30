import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.Main.FindPair;
import static org.example.Main.InsertCow;
import static org.junit.Assert.*;

public class WhiteBoxTesting {
    @Test
    public void testInsertCow(){
        List<Integer> animals = new ArrayList<>();
        int sizeBeforeInsert = animals.size();
        try {
            InsertCow(animals);
            assertTrue(sizeBeforeInsert + 1 == animals.size());
            InsertCow(animals);
            assertTrue(sizeBeforeInsert + 2 == animals.size());
        }
        catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void testInsertCowNull() {
        try {
            InsertCow(null);
            assert false;
        }
        catch (Exception e) {
            assert true;
        }
    }

}
