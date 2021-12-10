
/**
 ** Software Technology 152 Class to hold various static sort methods.
 */

class Sorts {

  // bubble sort
  public static void bubbleSort(int[] A) {
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

  }// bubbleSort()

  // selection sort
  public static void selectionSort(int[] A) {
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
  }// selectionSort()

  // insertion sort
  public static void insertionSort(int[] A) {
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

  }// insertionSort()

  // mergeSort - front-end for kick-starting the recursive algorithm
  public static void mergeSort(int[] A) {
  }// mergeSort()

  private static void mergeSortRecurse(int[] A, int leftIdx, int rightIdx) {
  }// mergeSortRecurse()

  private static void merge(int[] A, int leftIdx, int midIdx, int rightIdx) {
  }// merge()

  // quickSort - front-end for kick-starting the recursive algorithm
  public static void quickSort(int[] A) {
  }// quickSort()

  private static void quickSortRecurse(int[] A, int leftIdx, int rightIdx) {
  }// quickSortRecurse()

  private static int doPartitioning(int[] A, int leftIdx, int rightIdx, int pivotIdx) {
    return 0; // TEMP - Replace this when you implement QuickSort
  }// doPartitioning

}// end Sorts calss
