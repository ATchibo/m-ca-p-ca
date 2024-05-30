import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Main.*;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class BottomUpIntegrationTesting {
    List<Integer> animals = List.of(1, 2, 3, 4, 3, 2, 1, 1, 2, 3, 1);
    List<Integer> animalsAfter1Insert = List.of(1, 4, 2, 3, 4, 3, 2, 1, 1, 2, 3, 1);
    List<Integer> animalsAfterBeFriends = List.of(1, 4, 2, 4, 3, 4, 3, 4, 2, 4, 1, 1, 4, 2, 4, 3, 1);

    @Test
    public void findPairAnimalsArrayValidAndAPairExists(){
        assertTrue(FindPair(animals, 0));
    }

    @Test
    public void addCow(){
        List<Integer> afterInsert = new ArrayList<>();
        try {
            afterInsert.add(animals.get(0));
            InsertCow(afterInsert);
            afterInsert.addAll(animals.subList(1, animals.size()));
            boolean areEqual = afterInsert.equals(animalsAfter1Insert);
            assertTrue(areEqual);
        }
        catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void findPairAndAddCow(){
        boolean found = false;
        int index = -1;
        while(!found){
            index++;
            found = FindPair(animals, index);
        }
        List<Integer> afterInsert = new ArrayList<>();
        for(int i = 0; i <= index; i++){
            afterInsert.add(animals.get(i));
        }
        try {
            InsertCow(afterInsert);
        }
        catch (Exception e) {
            assert false;
        }
        afterInsert.addAll(animals.subList(index+1, animals.size()));
        boolean areEqual = afterInsert.equals(animalsAfter1Insert);
        assertTrue(areEqual);
    }

    @Test
    public void findPairAddCowAndBeFriends(){
        boolean found = false;
        int index = -1;
        while(!found){
            index++;
            found = FindPair(animals, index);
        }
        List<Integer> afterInsert = new ArrayList<>();
        for(int i = 0; i <= index; i++){
            afterInsert.add(animals.get(i));
        }
        try {
            InsertCow(afterInsert);
        }
        catch (Exception e) {
            assert false;
        }
        afterInsert.addAll(animals.subList(index+1, animals.size()));
        afterInsert = BeFriends(afterInsert);
        boolean areEqual = afterInsert.equals(animalsAfterBeFriends);
        assertTrue(areEqual);
    }
}
