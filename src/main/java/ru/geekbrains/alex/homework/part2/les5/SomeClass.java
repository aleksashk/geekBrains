package ru.geekbrains.alex.homework.part2.les5;

public class SomeClass {
    static final int SIZE = 50_000_000;
    static final int HALF = SIZE / 2;
    float[] arr = new float[SIZE];

    public void fillArrayFirstMeth() {
        for (float f : arr) {
            f = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2 + i / 5.) * Math.cos(0.2 + i / 5.) * Math.cos(0.4 + i / 2.));
        }
        System.out.println("time for working of the fillArrayFirstMeth: " + (System.currentTimeMillis() - a));
    }

    public void fillArraySecondMeth() throws InterruptedException {
        for (float f : arr) {
            f = 1;
        }

        float[] arrFirstPart = new float[HALF];
        float[] arrSecondPart = new float[HALF];
        System.arraycopy(arr, 0, arrFirstPart, 0, HALF);
        System.arraycopy(arr, HALF, arrSecondPart, 0, HALF);

        long b = System.currentTimeMillis();

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                arrFirstPart[i] = (float) (arrFirstPart[i] * Math.sin(0.2 + i / 5.) * Math.cos(0.2 + i / 5.) * Math.cos(0.4 + i / 2.));
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = 0, j = HALF; i < HALF; i++, j++) {
                arrSecondPart[i] = (float) (arrSecondPart[i] * Math.sin(0.2 + j / 5.) * Math.cos(0.2 + j / 5.) * Math.cos(0.4 + j / 2.));
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.arraycopy(arrFirstPart, 0, arr, 0, HALF);
        System.arraycopy(arrSecondPart, 0, arr, HALF, HALF);
        System.out.println("time for working of the fillArraySecondMeth: " + (System.currentTimeMillis() - b));

    }
}
