import org.junit.Test;

import java.util.List;

import static org.example.Main.FindPair;
import static org.junit.Assert.*;

public class BlackBoxTesting {
    List<Integer> animals = List.of(1, 2, 3, 4, 3, 2, 1, 1, 2, 3, 1);
    List<Integer> invalidAnimals = List.of(100, 101, 300);
    List<Integer> singleElementAnimals = List.of(4);

    @Test
    public void findPairAnimalsArrayValidAndAPairExists(){
        assertTrue(FindPair(animals, 0));
    }
    @Test
    public void findPairAnimalsArrayInvalid(){
        assertFalse(FindPair(invalidAnimals, 0));
    }
    @Test
    public void findPairAnimalsArrayValidAndAPairDoesntExist(){
        assertFalse(FindPair(singleElementAnimals, 0));
    }
}
