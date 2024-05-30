package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> animals = new ArrayList<>();

        try {
            File myObj = new File("src/main/java/org/example/input.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                int animal = 0;
                try {
                    animal = myReader.nextInt();
                } catch (Exception e) {
                    System.out.println("The file contains non integer data. Please check the file and try again.");
                    return;
                }

                if (animal < 1 || animal > 4) {
                    System.out.println("The file contains invalid data. Please check the file and try again.");
                    return;
                }

                animals.add(animal);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(BeFriends(animals));
    }

    private static boolean FindPair(List<Integer> animals, int crtAnimalPos) {
        if (!animals.isEmpty() && crtAnimalPos < animals.size() - 1) {
            Integer firstAnimal = animals.get(crtAnimalPos);
            Integer secondAnimal = animals.get(crtAnimalPos + 1);
            if (firstAnimal == 2 && secondAnimal == 1 ||
                    firstAnimal == 1 && secondAnimal == 2 ||
                    firstAnimal == 3 && secondAnimal == 2 ||
                    firstAnimal == 2 && secondAnimal == 3) {

                return true;
            }
        }

        return false;
    }

    private static void InsertCow(List<Integer> animals) {
        animals.add(4);
    }

    private static List<Integer> BeFriends(List<Integer> animals) {
        List<Integer> friends = new ArrayList<>();

        for (int i = 0; i < animals.size() - 1; i++) {
            friends.add(animals.get(i));
            if (FindPair(animals, i)) {
                InsertCow(friends);
            }
        }

        friends.add(animals.getLast());

        return friends;
    }
}