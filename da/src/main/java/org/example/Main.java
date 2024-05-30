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
                    System.out.println("The file contains invalid data. Please check the file and try again.");
                    return;
                }

                if (animal < 1 || animal > 3) {
                    System.out.println("The file contains invalid data. Please check the file and try again.");
                    return;
                }

                if (!animals.isEmpty()) {
                    Integer lastAnimal = animals.getLast();
                    if (lastAnimal == 2 && animal == 1 ||
                            lastAnimal == 1 && animal == 2 ||
                            lastAnimal == 3 && animal == 2 ||
                            lastAnimal == 2 && animal == 3) {

                        animals.add(4);
                    }
                }

                animals.add(animal);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.println(animals);
    }
}