
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date: 3 rd August 2021                                    
 * Purpose: To read a CSV file sort it using Bubble , Selection or Insertion sort and wtite the output to a file.                    
 *********************************************************/
import java.util.*;
import java.io.*;

class ReadFile {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = 0;

        System.out.println("Hello /n > In what sort type would you like to sort the Id numbers ?"); // Asking the user
                                                                                                    // with prompt
        System.out.println(" > 1.Bubble Sort \n > 2.Selection sort \n > 3.Insertion sort");
        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Something is wrong please try again later");
        }
        int[] passIDnumbers = readIDNumbers("RandomNames.csv"); // Calling the method that reads the data file.
        switch (input) {
            case 1: {
                int[] paassToOutput = bubbleSort(passIDnumbers); // If the user inputs number 1.
                outputFile(paassToOutput, "sortedOutput.csv");
                break;
            }
            case 2: {
                int[] paassToOutput = selectionSort(passIDnumbers); // If the user inputs number 2
                outputFile(paassToOutput, "sortedOutput.csv");
                break;
            }
            case 3: {
                int[] paassToOutput = insertionSort(passIDnumbers); // If the user inputs number 3
                outputFile(paassToOutput, "sortedOutput.csv");
                break;
            }
            default:

                System.out.println("Wrong input \n Please try again later"); // If the user inputs something else.
                input = sc.nextInt();
                break;

        }

    }

    /*********************************************************************
     * Name- readIDNumbers Date 3/08/2021 import - String pFilename export -
     * numbers(integer array) Purpose- To read the id numbers into an array.
     ******************************************************************/

    public static int[] readIDNumbers(String pFileName) // Read The file
    {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        // RandomData[] randomDataArray = {};
        int[] numbers = {};

        try {
            fileStream = new FileInputStream(pFileName); // Counting the total number of lines to set the array size.
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;
            int i = 0;

            int totLines = 0;
            String countLine;

            // counting the total number of lines in the file
            countLine = bufRdr.readLine();
            while (countLine != null) {
                totLines++;
                countLine = bufRdr.readLine();
            }
            fileStream.close();

            fileStream = new FileInputStream(pFileName); // Reading the csv file and storing the Id numbers in an array.
            rdr = new InputStreamReader(fileStream);
            bufRdr = new BufferedReader(rdr);
            lineNum = 0;

            // bufRdr.readLine();
            line = bufRdr.readLine();

            numbers = new int[totLines];
            // System.out.println(totLines);

            while (line != null) {
                lineNum++;
                String[] splitLine;
                splitLine = line.split(",");

                {

                    numbers[i] = Integer.parseInt(splitLine[0]); // storing the Id numbers into an array
                    i++;

                }

                line = bufRdr.readLine();
            }
            fileStream.close();

        } catch (IOException errorDetails) {
            if (fileStream != null) {
                try {
                    fileStream.close();
                } catch (IOException ex2) {
                }
            }
            System.out.println("Error in fileProcessing: " + errorDetails.getMessage());
            System.out.println("Sorry we could not find the file you are reffering to");
        }
        return numbers;

    }

    /*********************************************************************
     * Name- bubbleSort Date 3/08/2021 import - int[] A export - int[] A Purpose- To
     * sort the Id numbers passed through the array.
     ******************************************************************/
    public static int[] bubbleSort(int[] A) {
        int temp = 0;
        int pass = 0;
        boolean sorted;
        int arrayLength = A.length;
        do {
            sorted = true;

            for (int i = 0; i <= (arrayLength - 1 - pass) - 1; i++) {
                if (A[i] > A[i + 1]) {
                    temp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = temp;
                    sorted = false;
                }
            }
            pass = pass + 1;
        } while (!sorted);
        System.out.println(Arrays.toString(A));
        return A;

    }// bubbleSort()

    /*********************************************************************
     * Name- selectionSort Date 3/08/2021 import - int[] A export - int[] A Purpose-
     * To sort the Id numbers passed through the array.
     ******************************************************************/
    public static int[] selectionSort(int[] A) {
        int arrayLength = A.length;
        int minIdx = 0;
        int temp = 0;

        for (int n = 0; n < arrayLength; n++) {
            minIdx = n;
            for (int j = n + 1; j < arrayLength; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            temp = A[minIdx];
            A[minIdx] = A[n];
            A[n] = temp;

        }
        System.out.println(Arrays.toString(A));
        return A;
    }// selectionSort()

    /*********************************************************************
     * Name- insertionSort Date 3/08/2021 import - int[] A export - int[] A Purpose-
     * To sort the Id numbers passed through the array.
     ******************************************************************/

    public static int[] insertionSort(int[] A) {
        int arrayLength = A.length;
        int temp = 0;
        int i = 0;

        for (int n = 1; n < arrayLength; n++) {
            i = n;
            temp = A[i];
            while ((i > 0) && (A[i - 1] > temp)) {
                A[i] = A[i - 1];
                i = i - 1;
            }
            A[i] = temp;

        }
        System.out.println(Arrays.toString(A));
        return A;
    }// insertionSort()

    /*********************************************************************
     * Name- outputFile Date 3/08/2021 import - int[] A , pFileName(String) export -
     * int[] A Purpose- To write the sorted Id numbers into a file.
     ******************************************************************/
    public static void outputFile(int[] poutputArray, String pFilename) {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try {
            fileStrm = new FileOutputStream(pFilename);
            pw = new PrintWriter(fileStrm);
            for (int i = 0; i < poutputArray.length; i++) // printing the sorted Id numbers in a new line.(in one
                                                          // coloumn)
            {
                pw.println(poutputArray[i]);

            }
            pw.close();

        } catch (IOException e) {
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }

}
