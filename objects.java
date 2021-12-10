
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date: 3 rd August 2021                                    
 * Purpose: To read a the Id names and the student names into objects.                    
 *********************************************************/
import java.util.*;
import java.io.*;

public class objects {
    public static void main(String args[]) {
        RandomData[] passToTheSort = readIDNumbers("RandomNames.csv");
        RandomData[] passToFile = bubbleSort(passToTheSort);
        outputFile(passToFile, "objectsFile.csv");

    }

    public static RandomData[] readIDNumbers(String pFileName) {
        FileInputStream fileStream = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;
        RandomData[] randomDataArray = {};

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

            randomDataArray = new RandomData[totLines];
            // System.out.println(totLines);

            while (line != null) {
                lineNum++;
                String[] splitLine;
                splitLine = line.split(",");

                {
                    randomDataArray[i] = new RandomData(Integer.parseInt(splitLine[0]), splitLine[1]);
                    i++;

                }

                line = bufRdr.readLine();
            }
            fileStream.close();
            // System.out.println(Arrays.toString(randomDataArray));

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
        return randomDataArray;

    }

    /*********************************************************************
     * Name- bubbleSort Date 3/08/2021 import - int[] A export - int[] A Purpose- To
     * sort the Id numbers passed through the array.
     ******************************************************************/

    public static RandomData[] bubbleSort(RandomData[] pRandomDataArray) {
        RandomData temp;

        int arrayLength = pRandomDataArray.length;
        for (int j = 0; j < arrayLength - 1; j++) {
            for (int i = 0; i < arrayLength - 1; i++) {
                if (pRandomDataArray[i].getIDNumber() > pRandomDataArray[i + 1].getIDNumber()) {
                    temp = pRandomDataArray[i];
                    pRandomDataArray[i] = pRandomDataArray[i + 1];
                    pRandomDataArray[i + 1] = temp;

                }

            }
        }
        System.out.println(Arrays.toString(pRandomDataArray));
        return pRandomDataArray;
    }

    public static void outputFile(RandomData[] poutputArray, String pFilename) {
        FileOutputStream fileStrm = null;
        PrintWriter pw;
        try {
            fileStrm = new FileOutputStream(pFilename);
            pw = new PrintWriter(fileStrm);
            for (int i = 0; i < poutputArray.length; i++) // printing the sorted Id numbers in a new line.(in one
                                                          // coloumn)
            {
                pw.println(Arrays.toString(poutputArray));

            }
            pw.close();

        } catch (IOException e) {
            System.out.println("Error in writing to file: " + e.getMessage());
        }
    }

}
