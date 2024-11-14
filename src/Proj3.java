import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Proj3 {
    // Sorting Method declarations
    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if (left < right) {
            int mid = (right+left)/2;

            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);

            merge(a, left, mid , right);
        }

    }

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> void merge(ArrayList<T> a, int left, int mid, int right) {
        // Finish Me

        int l1 = mid - left + 1;
        int l2 = right - mid;


        ArrayList<T> lside = new ArrayList<>(1000);
        ArrayList<T> rside = new ArrayList<>(1000);

        for (int i = 0; i < l1; i++) {
            lside.add(i, a.get(left+i));
        }
        for (int j = 0; j<l2; j++) {
            rside.add(j, a.get(mid+j+1));
        }

        int n = 0;
        int m = 0;
        int k = left;
        while (n < l1 && m < l2) {
            if (lside.get(n).compareTo(rside.get(m)) == -1) {
                a.set(k, lside.get(n));
                n++;
            }
            else {
                a.set(k, rside.get(m));
                m++;
            }
            k++;
        }

        while (n < l1) {
            a.set(k, lside.get(n));
            n++;
            k++;
        }
        while (m < l2) {
            a.set(k, rside.get(m));
            m++;
            k++;
        }

    }

    // Quick Sort
    public static <T extends Comparable> void quickSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        if (left < right) {
            int p_index = partition(a, left, right);

            quickSort(a, left, p_index-1);
            quickSort(a, p_index+1, right);
        }


    }

    public static <T extends Comparable> int partition (ArrayList<T> a, int left, int right) {
        // Finish Me

        T piv = a.get(right);
        int k = left-1;

        for (int i = left; i<right; i++) {
            if (a.get(i).compareTo(piv) == -1) {
                k++;
                swap(a,k, i);
            }
        }
        swap(a, k+1, right);
        return k+1;

    }

    static <T> void swap(ArrayList<T> a, int i, int j) {
        T temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }

    // Heap Sort
    public static <T extends Comparable> void heapSort(ArrayList<T> a, int left, int right) {
        // Finish Me
        int length = right - left + 1;

        for (int i = length/2 -1; i>=0; i--) {
            heapify(a, length, i);
        }

        for (int m = length-1; m > 0; m--) {
            T temp = a.get(0);
            a.set(0, a.get(m));
            a.set(m, temp);

            heapify(a, m , 0);
        }
    }

    public static <T extends Comparable> void heapify (ArrayList<T> a, int left, int right) {
        // Finish Me
        int max = right;

        int li = 2*right + 1;
        int ri = 2*right + 2;

        if (li < left && a.get(li).compareTo(a.get(max)) == 1) {
            max = li;
        }

        if (ri < right && a.get(ri).compareTo(a.get(max)) == 1) {
            max = ri;
        }

        if (max != right) {
            T temp = a.get(right);
            a.set(right, a.get(max));
            a.set(max, temp);

            heapify(a, right, max);
        }

    }

    // Bubble Sort
    @SuppressWarnings("unchecked")
    public static <T extends Comparable> void bubbleSort(ArrayList<T> a, int size) throws IOException {
        // Finish Me

        FileWriter writer = new FileWriter("analysis.csv", true);
        int count = 0;

        for (int i = 0; i<size; i++) {
            int index = i;
            for (int j = i; j < size; j++) {
                count++;
                if (a.get(index).compareTo(a.get(j)) == 1) {
                    index = j;
                }
            }
            swap(a, i, index);
        }
        writer.write(size+","+count+"\n");
        writer.close();
    }

    // Odd-Even Transposition Sort
    @SuppressWarnings("unchecked")
    public static <T extends Comparable> void transpositionSort(ArrayList<T> a, int size) throws IOException {
        // Finish Me
        boolean isSorted = false;
        FileWriter writer = new FileWriter("analysis.csv", true);
        int count = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size-1; i+=2) {
                count++;
                if (a.get(i).compareTo(a.get(i+1)) == 1) {
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }

            for (int i = 1; i < size-1; i+=2) {
                count++;
                if (a.get(i).compareTo(a.get(i+1)) == 1) {
                    swap(a, i, i+1);
                    isSorted = false;
                }
            }
        }

        writer.write(size+","+count+"\n");
        writer.close();
    }



    public static void main(String [] args)  throws IOException {
        //...
        // Finish Me
        //...

        String inputFileName = args[0];
        String sort = args[1];

        // For file input
        FileInputStream inputFileNameStream = null;
        Scanner inputFileNameScanner = null;

        // Open the input file
        inputFileNameStream = new FileInputStream(inputFileName);
        inputFileNameScanner = new Scanner(inputFileNameStream);

        // ignore first line
        inputFileNameScanner.nextLine();

        // FINISH ME
        //Read file

        ArrayList<Patient> patients = new ArrayList<>();

        int pcount = 0;

        while (inputFileNameScanner.hasNextLine()){
            String[] line = inputFileNameScanner.nextLine().split(",");
            Patient temp = new Patient();
            temp.setGender(line[0]);
            temp.setAge(Double.parseDouble(line[1]));
            temp.setHeight(Double.parseDouble(line[2]));
            temp.setWeight(Double.parseDouble(line[3]));
            temp.setNCP(Double.parseDouble(line[7]));
            temp.setCAEC(line[8]);
            temp.setCH2O(Double.parseDouble(line[10]));
            temp.setFAF(Double.parseDouble(line[12]));
            temp.setTUE(Double.parseDouble(line[13]));
            temp.setCALC(line[14]);
            temp.setMTrans(line[15]);
            temp.setNObeyesdad(line[16]);

            patients.add(temp);
            pcount++;

        }

        double time;
        double start;
        double end;

        //patients.sort(null);
        //Collections.sort(patients, Collections.reverseOrder());

        Collections.shuffle(patients);

        int n = 50;

        switch(sort) {
            case "quicksort":
                System.out.println("Quicksort");
                start = System.nanoTime();
                quickSort(patients, 0, n-1);
                end = System.nanoTime();
                time = ((end-start)/1000000);
                break;

            case "mergesort":
                System.out.println("Mergesort");
                start = System.nanoTime();
                mergeSort(patients, 0, n-1);
                end = System.nanoTime();
                time = ((end-start)/1000000);
                break;
            case "heapsort":
                System.out.println("Heapsort");
                start = System.nanoTime();
                heapSort(patients, 0, n-1);
                end = System.nanoTime();
                time = ((end-start)/1000000);
                break;

            case "transpositionsort":
                System.out.println("Transposition sort");
                start = System.nanoTime();
                transpositionSort(patients, n);
                end = System.nanoTime();
                time = ((end-start)/1000000);
                break;

            default:
                System.out.println("Bubblesort");
                start = System.nanoTime();
                bubbleSort(patients, n);
                end = System.nanoTime();
                time = ((end-start)/1000000);
                break;
        }

        FileWriter writeToFile = new FileWriter("analysis.csv", true);
        FileWriter sorted = new FileWriter("sorted.txt");
        //writeToFile.write(String.valueOf(n)+","+String.valueOf(time)+"\n");
        writeToFile.close();

        for (int h = 0; h < n; h++) {
            sorted.write(patients.get(h).toString());
            //System.out.println(patients.get(h).getWeight());
        }
    }
}
