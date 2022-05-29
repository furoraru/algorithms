package com.konstantinova.algorithms.basicstructures;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicStructuresTest {
    IArray<Integer> single = new SingleArray<>();
    IArray<Integer> vector = new VectorArray<>();
    IArray<Integer> factor = new FactorArray<>();
    IArray<Integer> matrix = new MatrixArray<>();
    List<Integer> arrayList = new ArrayList<>();

    @Test
    public void RunTests() {
        fillArrays();
        //deleteFromTheBeginning();
        //deleteFromTheRand();
       deleteFromTheEnding();
    }

    public void addToTheBeginning() {
        System.out.println("=================== addToTheBeginning ===================");

        Instant startTime = Instant.now();
        fillForAddToTheBeginning(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheBeginning(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheBeginning(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheBeginning(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheBeginning(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    public void addToTheEnding() {
        System.out.println("=================== addToTheEnding ===================");

        Instant startTime = Instant.now();
        fillForAddToTheEnding(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheEnding(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheEnding(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheEnding(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheEnding(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    public void addToTheRand() {
        System.out.println("=================== addToTheRand ===================");

        Instant startTime = Instant.now();
        fillForAddToTheRand(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheRand(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheRand(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheRand(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        fillForAddToTheRand(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    public void getFromTheBeginning() {
        System.out.println("=================== getFromTheBeginning ===================");

        Instant startTime = Instant.now();
        getForGetFromTheBeginning(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheBeginning(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheBeginning(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheBeginning(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheBeginning(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    public void getFromTheEnding() {
        System.out.println("=================== getFromTheEnding ===================");

        Instant startTime = Instant.now();
        getForGetFromTheEnding(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheEnding(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheEnding(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheEnding(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheEnding(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    public void getFromTheRand() {
        System.out.println("=================== getFromTheRand ===================");

        Instant startTime = Instant.now();
        getForGetFromTheRand(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheRand(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheRand(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheRand(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        getForGetFromTheRand(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    private void deleteFromTheBeginning() {
        System.out.println("=================== deleteFromTheBeginning ===================");

        Instant startTime = Instant.now();
        deleteForDeleteFromTheBeginning(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheBeginning(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheBeginning(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheBeginning(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheBeginning(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    private void deleteFromTheEnding() {
        System.out.println("=================== deleteFromTheEnding ===================");

        Instant startTime = Instant.now();
        deleteForDeleteFromTheEnding(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheEnding(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheEnding(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheEnding(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheEnding(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    private void deleteFromTheRand() {
        System.out.println("=================== deleteFromTheRand ===================");

        Instant startTime = Instant.now();
        deleteForDeleteFromTheRand(single);
        System.out.println("\nTime single: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheRand(vector);
        System.out.println("\nTime vector: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheRand(factor);
        System.out.println("\nTime factor: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheRand(matrix);
        System.out.println("\nTime matrix: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        startTime = Instant.now();
        deleteForDeleteFromTheRand(arrayList);
        System.out.println("\nTime arrayList: " + Duration.between(startTime, Instant.now()).toMillis() + "ms");

        System.out.println("=================== ******** ===================");
    }

    private void deleteForDeleteFromTheBeginning(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.remove(0);
        }
    }

    private void deleteForDeleteFromTheBeginning(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.remove(0);
        }
    }

    private void deleteForDeleteFromTheEnding(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.remove(array.size() - 1);
        }
    }

    private void deleteForDeleteFromTheEnding(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.remove(array.size() - 1);
        }
    }

    private void deleteForDeleteFromTheRand(IArray<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.remove(rand.nextInt(array.size()));
        }
    }

    private void deleteForDeleteFromTheRand(List<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.remove(rand.nextInt(array.size()));
        }
    }

    private void getForGetFromTheBeginning(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.get(0);
        }
    }

    private void getForGetFromTheBeginning(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.get(0);
        }
    }

    private void getForGetFromTheEnding(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.get(array.size() - 1);
        }
    }

    private void getForGetFromTheEnding(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.get(array.size() - 1);
        }
    }

    private void getForGetFromTheRand(IArray<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.get(rand.nextInt(array.size()));
        }
    }

    private void getForGetFromTheRand(List<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.get(rand.nextInt(array.size()));
        }
    }

    private void fillForAddToTheBeginning(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.add(i, 0);
        }
    }

    private void fillForAddToTheBeginning(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.add(0, i);
        }
    }

    private void fillForAddToTheEnding(IArray<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.add(i);
        }
    }

    private void fillForAddToTheEnding(List<Integer> array) {
        for (int i = 0; i < 100_000; i++) {
            array.add(i);
        }
    }

    private void fillForAddToTheRand(IArray<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.add(i, rand.nextInt(array.size() + 1));
        }
    }

    private void fillForAddToTheRand(List<Integer> array) {
        Random rand = new Random();
        for (int i = 0; i < 100_000; i++) {
            array.add(rand.nextInt(array.size() + 1), i);
        }
    }

    private void fillArrays() {
        for (int i = 0; i < 100_000; i++) {
            single.add(i);
            vector.add(i);
            factor.add(i);
            matrix.add(i);
            arrayList.add(i);
        }
    }
}
