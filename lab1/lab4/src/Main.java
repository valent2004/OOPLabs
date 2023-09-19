// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Main
{
    public double[] readOneDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int n = in.nextInt();
            double[] arr = new double[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = in.nextDouble();
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    public double[][] readTwoDimensionalArray(String fileName) {
        try (Scanner in = new Scanner(new File(fileName))) {
            int n = in.nextInt();
            double[][] arr = new double[n][n];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = in.nextDouble();
                }
            }
            return arr;
        }
        catch (IOException ex) {
            System.err.println("Error reading file");
            return null;
        }
    }

    public void processArray(double[] arr)
    {
        System.out.println("One dimensional array Massive");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public void processArray(double[][] arr)
    {
        System.out.println("Two dimensional array massive");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public double calculate(double[] arr)
    {
        double sumNonZero = 0.0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){sumNonZero += arr[i]*arr[i];}
        }
        return sumNonZero/2;
    }

    public double calculate(double[][] arr)
    {
        double sumNonZero = 0.0;
        for (int i = 0; i <= arr.length/2; i++) {
            for (int j = i; j < arr[i].length - i; j++) {
                sumNonZero += arr[i][j];
            }
        }
        return sumNonZero;
    }

    public static void main(String[] args)
    {
        Main main = new Main();
        double[] arr = main.readOneDimensionalArray("C:/Users/Admin/OOPLabs/lab1/lab4/src/lab51.txt");
        main.processArray(arr);
        System.out.println(main.calculate(arr));
        double[][] arr2 = main.readTwoDimensionalArray("C:/Users/Admin/OOPLabs/lab1/lab4/src/lab52.txt");
        main.processArray(arr2);
        System.out.println(main.calculate(arr2));
    }
}