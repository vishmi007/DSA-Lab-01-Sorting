
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date: 3 rd August 2021                                    
 * Purpose: The Class of the random names and Ids of the students.                    
 *********************************************************/
import java.util.*;

public class RandomData {
    private int IDNumber;
    private String studentName;

    // Constructor with parameters.
    public RandomData(int pIDNumber, String pStudentName) {
        IDNumber = pIDNumber;
        studentName = pStudentName;
    }

    // getters
    public int getIDNumber() {
        return IDNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    // setters
    public void setIDNumer(int pIDNumber) {
        IDNumber = pIDNumber;
    }

    public void setStudentName(String pStudentName) {
        studentName = pStudentName;
    }

    /*********************************************************************
     * Name- outputFile Date 3/08/2021 import - None export - RandomDataString
     * (String) Purpose- To print the data of the objects as a string.
     ******************************************************************/
    public String toString() {
        String RandomDataString;
        RandomDataString = "\nThe ID Number " + IDNumber + "\nThe name of the Student " + studentName;
        return RandomDataString;

    }

}
