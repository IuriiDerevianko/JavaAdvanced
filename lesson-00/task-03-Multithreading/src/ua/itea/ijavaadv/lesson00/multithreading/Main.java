//D
package ua.itea.ijavaadv.lesson00.multithreading;

public class Main {

    /**Создать две двухмерные рандомные числовые матрицы 10х10
     *и перемножить элементы этих матриц используя многопоточность.
     *Сравнить скорости выполнения программы в многопоточном и однопоточном режимах.
     */

    public static final int SIZE = 10;

    public static void main(String[] args) {

        int[][] firstArray = new int [SIZE][SIZE];
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                firstArray[i][j] = (int)(Math.round(Math.random() * Integer.MAX_VALUE));
            }
        }
        System.out.println("firstArray is:");
        for (int i = 0; i < firstArray.length; i++) {
            for (int j = 0; j < firstArray.length; j++) {
                System.out.print(firstArray[i][j] + " ");
            }
            System.out.println();
        }

        int[][] secondArray = new int [SIZE][SIZE];
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                secondArray[i][j] = (int)(Math.round(Math.random() * Integer.MAX_VALUE));
            }
        }
        System.out.println("\nsecondArray is:");
        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < secondArray.length; j++) {
                System.out.print(secondArray[i][j] + " ");
            }
            System.out.println();
        }


        long[][] singleThreadResultArray = new long[SIZE][SIZE];
        long startTimeSingle = System.nanoTime();
        for (int i = 0; i < singleThreadResultArray.length; i++) {
            for (int j = 0; j < singleThreadResultArray.length; j++) {
                singleThreadResultArray[i][j] = ((long)(firstArray[i][j]) * (long)(secondArray[i][j]));
            }
        }
        long estimatedTimeSingle = System.nanoTime() - startTimeSingle;
        System.out.println("\nsingleThreadResultArray is:");
        for (int i = 0; i < singleThreadResultArray.length; i++) {
            for (int j = 0; j < singleThreadResultArray.length; j++) {
                System.out.print(singleThreadResultArray[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nRuntime in single thread mode is: " + estimatedTimeSingle + " ns;");


        long[][] multiThreadResultArray = new long[SIZE][SIZE];
        long startTimeMulti = System.nanoTime();
        for (int i = 0; i < multiThreadResultArray.length; i++) {
            for (int j = 0; j < multiThreadResultArray.length; j++) {
                Runnable multiplication = new Multiplication(firstArray[i][j], secondArray[i][j]);
                multiplication.run();
                multiThreadResultArray[i][j] = Multiplication.getValue();
            }
        }

        long estimatedTimeMulti = System.nanoTime() - startTimeMulti;

        System.out.println("\nmultiThreadResultArray is:");
        for (int i = 0; i < multiThreadResultArray.length; i++) {
            for (int j = 0; j < multiThreadResultArray.length; j++) {
                System.out.print(multiThreadResultArray[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nRuntime in multi thread mode is: " + estimatedTimeMulti + " ns;");
        System.out.println("\nMulti threading/Single threading = " +
                + estimatedTimeMulti/estimatedTimeSingle + ";");
    }
}
