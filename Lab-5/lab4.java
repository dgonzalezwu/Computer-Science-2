package com.company;

import java.util.ArrayList;
import java.util.Random;

public class lab4
{
    long bubblesorttotalduration;
    long insertionsorttotalduration;
    long selectionsorttotalduration;
    long mergesorttotalduration;
    long quicksorttotalduration;


    private ArrayList<Double> randarray1 = new ArrayList<>(1024); //2^10
    private ArrayList<Double> randarray2 = new ArrayList <>(4096); //2^12
    private ArrayList<Double> randarray3 = new ArrayList <>(16384); //2^14
    private ArrayList<Double> randarray4 = new ArrayList <>(65536); //2^12
    private ArrayList<Double> randarray5 = new ArrayList <>(262144); //2^18

    private ArrayList<Double> monoincarray1 = new ArrayList<>(1024); //2^10
    private ArrayList<Double> monoincarray2 = new ArrayList <>(4096); //2^12
    private ArrayList<Double> monoincarray3 = new ArrayList <>(16384); //2^14
    private ArrayList<Double> monoincarray4 = new ArrayList <>(65536); //2^12
    private ArrayList<Double> monoincarray5 = new ArrayList <>(262144); //2^18

    private ArrayList<Double> monodecarray1 = new ArrayList<>(1024); //2^10
    private ArrayList<Double> monodecarray2 = new ArrayList <>(4096); //2^12
    private ArrayList<Double> monodecarray3 = new ArrayList <>(16384); //2^14
    private ArrayList<Double> monodecarray4 = new ArrayList <>(65536); //2^12
    private ArrayList<Double> monodecarray5 = new ArrayList <>(262144); //2^18

    public void generaterandarrays()
    {
        Random random = new Random();

        for (int a = 0; a < 1024 ; a++)
        {
            int f = random.nextInt();
            double f1 = f;
            randarray1.add(f1);
        }

        for (int b = 0; b < 4096; b++)
        {
            int g = random.nextInt();
            double g1 = g;
            randarray2.add(g1);
        }

        for (int c = 0; c < 16384; c++)
        {
            int h = random.nextInt();
            double h1 = h;
            randarray3.add(h1);
        }

        for (int d = 0; d < 65536; d++)
        {
            int i = random.nextInt();
            double i1 = i;
            randarray4.add(i1);
        }

        for (int e = 0; e < 262144; e++)
        {
            int j = random.nextInt();
            double j1 = j;
            randarray5.add(j1);
        }
    }

    public void generatemonoincarrays() //going to use an exponential function to demonstrate this
    {
        for (int a = 0; a < 1024 ; a++)
        {
            double f = Math.pow(2, a);
            monoincarray1.add(f);
        }

        for (int b = 0; b < 4096; b++)
        {
            double g = Math.pow(2, b);
            monoincarray2.add(g);
        }

        for (int c = 0; c < 16384; c++)
        {
            double h = Math.pow(2, c);
            monoincarray3.add(h);
        }

        for (int d = 0; d < 65536; d++)
        {
            double i = Math.pow(2, d);
            monoincarray4.add(i);
        }

        for (int e = 0; e < 262144; e++)
        {
            double j = Math.pow(2, e);
            monoincarray5.add(j);
        }
    }

    public void generatemonodecarrays() //going to use an exponential function to demonstrate this
    {
        for (int a = 0; a < 1024 ; a++)
        {
            double f = Math.pow(2, a);
            f *= -1;
            monodecarray1.add(f);
        }

        for (int b = 0; b < 4096; b++)
        {
            double g = Math.pow(2, b);
            g *= -1;
            monodecarray2.add(g);
        }

        for (int c = 0; c < 16384; c++)
        {
            double h = Math.pow(2, c);
            h *= -1;
            monodecarray3.add(h);
        }

        for (int d = 0; d < 65536; d++)
        {
            double i = Math.pow(2, d);
            i *= -1;
            monodecarray4.add(i);
        }

        for (int e = 0; e < 262144; e++)
        {
            double j = Math.pow(2, e);
            j *= -1;
            monodecarray5.add(j);
        }
    }

    public void bubblesort(ArrayList<Double> list)
    {
        int elements = list.size();
        long bubblestartTime = System.nanoTime();
        for (int a = 0; a < (elements - 1); a++)
        {
            for (int b = 0; b < (elements - a - 1); b++)
            {
                if (list.get(b) > list.get(b+1))
                {
                    //swapping if they are bigger here
                    Double temp = list.get(b);
                    list.set(b, list.get(b+1));
                    list.set(b+1, temp);
                }
            }
        }
        long bubblestopTime = System.nanoTime();
        bubblesorttotalduration = bubblestopTime - bubblestartTime;
    }

    public void insertionsort(ArrayList<Double> list)
    {
        int elements = list.size();
        long insertionstartTime = System.nanoTime();
        for (int a = 1; a < elements; a++)
        {
            Double key = list.get(a);

            int b = (a - 1);
            while (b >= 0 && list.get(b) > key)
            {
                //inserting it into the right place through a swap this way it supports negative number
                list.set(b + 1, list.get(b));
                b = b-1;
            }
            list.set(b+1, key);
        }
        long insertionstopTime = System.nanoTime();
        insertionsorttotalduration = insertionstopTime - insertionstartTime;
    }

    public void selectionsort(ArrayList<Double> list)
    {
        int elements = list.size();
        long selectionstartTime = System.nanoTime();
        for (int a = 0; a < (elements - 1); a++)
        {
            int minimum_index = a;
            for (int b = a + 1; b < elements; b++) {
                if (list.get(b) < list.get(minimum_index)) {
                    minimum_index = b;
                }
            }
            //swapping elements to get the sorted list
            Double temp = list.get(minimum_index);
            list.set(minimum_index, list.get(a));
            list.set(a, temp);
        }
        long selectionstopTime = System.nanoTime();
        selectionsorttotalduration = selectionstopTime - selectionstartTime;
    }

    public static void merge(ArrayList <Double> list, int low, int middle, int high)
    {
        //Find size of the two subarrays to be merged
        int lower_half = middle - low + 1;
        int upper_half = high - middle;

        //Create temporary array lists
        ArrayList<Double> LEFT = new ArrayList<>(lower_half);
        ArrayList<Double> RIGHT = new ArrayList<>(upper_half);

        //Copy data to temporary arrays lists
        for (int a = 0; a < lower_half; a++)
        {
            LEFT.add(list.get(low + a));
        }
        for (int b =0; b < upper_half; b++)
        {
            RIGHT.add(list.get(middle + 1 + b));
        }

        //Merge the temp arrays
        // Initial indexes of first and second sub array lists
        int a = 0, b = 0;

        //Initial index of merged subarray array
        int k = low;
        while (a < lower_half && b < upper_half)
        {
            if (LEFT.get(a) <= RIGHT.get(b))
            {
                list.set(k, LEFT.get(a));
                a++;
            }
            else
            {
                list.set(k, RIGHT.get(b));
                b++;
            }
            k++;
        }

        //Copy remaining elements of LEFT Array List if any are left
        while (a < lower_half)
        {
            list.set(k, LEFT.get(a));
            a++;
            k++;
        }

        //Copy remaining elements of RIGHT Array List if any are left
        while (b < upper_half)
        {
            list.set(k, RIGHT.get(b));
            b++;
            k++;
        }
    }

    public void mergesort(ArrayList<Double> list, int low, int high)
    {
        long mergestartTime = System.nanoTime();
        if (low < high)
        {
            //Finding the middle point
            int middle = (low + high)/2;

            //Sorting the first and second halves
            mergesort(list, low, middle);
            mergesort(list, middle + 1,high);

            //Merge the sorted halves

            merge(list, low, middle, high);
        }
        long mergestopTime = System.nanoTime();
        mergesorttotalduration = mergestopTime - mergestartTime;
    }

    public static int partition(ArrayList<Double> list, int low, int high)
    {
        //Double pivot = list.get(high);
        Double pivot = list.get(high);
        int a =(low-1); //index of smaller element

        for (int b = low; b < high; b++)
        {
            //For current element is smaller than or equal to pivot
            if (list.get(b) <= pivot)
            {
                a++;

                //swapping value of array list at a and value of array list at b
                Double temp = list.get(a);
                list.set(a, list.get(b));
                list.set(b, temp);
            }
        }
        //swap array value at a + 1 and array value a highest point (or pivot)
        Double temp = list.get(a + 1);
        list.set((a+1), list.get(high));
        list.set(high, temp);

        return a+1;
    }


    public void quicksort(ArrayList<Double> list, int low, int high)
    {
        long quickstartTime = System.nanoTime();
        if (low < high)
        {
            //pi = partitioning index
            int pi = partition(list, low, high);

            //Recursively sort elements before partition and after partition by calling function

            quicksort(list, low, (pi-1));
            quicksort(list, (pi+1), high);
        }
        long quickstopTime = System.nanoTime();
        quicksorttotalduration = quickstopTime - quickstartTime;
    }

    public static void main(String[] args)
    {
        lab4 test = new lab4();
        test.generaterandarrays();
        test.generatemonoincarrays();
        test.generatemonodecarrays();
        //Bubble Sort Random Array of Varying Sizes
        System.out.println("BUBBLE SORT:");
        System.out.println("");
        test.bubblesort(test.randarray1);
        System.out.println("Duration for 2^10 Random Number Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.randarray2);
        System.out.println("Duration for 2^12 Random Number Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.randarray3);
        System.out.println("Duration for 2^14 Random Number Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.randarray4);
        System.out.println("Duration for 2^16 Random Number Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.randarray5);
        System.out.println("Duration for 2^18 Random Number Array: " + test.bubblesorttotalduration + " nanoseconds");

        //Bubble Sort Monotonically Increasing Array of Varying Sizes
        test.bubblesort(test.monoincarray1);
        System.out.println("Duration for 2^10 Monotonically Increasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monoincarray2);
        System.out.println("Duration for 2^12 Monotonically Increasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monoincarray3);
        System.out.println("Duration for 2^14 Monotonically Increasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monoincarray4);
        System.out.println("Duration for 2^16 Monotonically Increasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monoincarray5);
        System.out.println("Duration for 2^18 Monotonically Increasing Array: " + test.bubblesorttotalduration + " nanoseconds");

        //Bubble Sort Monotonically Decreasing Array of Varying Sizes
        test.bubblesort(test.monodecarray1);
        System.out.println("Duration for 2^10 Monotonically Decreasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monodecarray2);
        System.out.println("Duration for 2^12 Monotonically Decreasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monodecarray3);
        System.out.println("Duration for 2^14 Monotonically Decreasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monodecarray4);
        System.out.println("Duration for 2^16 Monotonically Decreasing Array: " + test.bubblesorttotalduration + " nanoseconds");
        test.bubblesort(test.monodecarray5);
        System.out.println("Duration for 2^18 Monotonically Decreasing Array: " + test.bubblesorttotalduration + " nanoseconds");



        //Insertion Sort Random Array of Varying Sizes
        System.out.println("");
        System.out.println("INSERTION SORT:");
        System.out.println("");
        test.insertionsort(test.randarray1);
        System.out.println("Duration for 2^10 Random Number Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.randarray2);
        System.out.println("Duration for 2^12 Random Number Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.randarray3);
        System.out.println("Duration for 2^14 Random Number Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.randarray4);
        System.out.println("Duration for 2^16 Random Number Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.randarray5);
        System.out.println("Duration for 2^18 Random Number Array: " + test.insertionsorttotalduration + " nanoseconds");

        //Insertion Sort Monotonically Increasing Array of Varying Sizes
        test.insertionsort(test.monoincarray1);
        System.out.println("Duration for 2^10 Monotonically Increasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monoincarray2);
        System.out.println("Duration for 2^12 Monotonically Increasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monoincarray3);
        System.out.println("Duration for 2^14 Monotonically Increasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monoincarray4);
        System.out.println("Duration for 2^16 Monotonically Increasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monoincarray5);
        System.out.println("Duration for 2^18 Monotonically Increasing Array: " + test.insertionsorttotalduration + " nanoseconds");

        //Insertion Sort Monotonically Decreasing Array of Varying Sizes
        test.insertionsort(test.monodecarray1);
        System.out.println("Duration for 2^10 Monotonically Decreasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monodecarray2);
        System.out.println("Duration for 2^12 Monotonically Decreasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monodecarray3);
        System.out.println("Duration for 2^14 Monotonically Decreasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monodecarray4);
        System.out.println("Duration for 2^16 Monotonically Decreasing Array: " + test.insertionsorttotalduration + " nanoseconds");
        test.insertionsort(test.monodecarray5);
        System.out.println("Duration for 2^18 Monotonically Decreasing Array: " + test.insertionsorttotalduration + " nanoseconds");




        //Selection Sort Random Array of Varying Sizes
        System.out.println("");
        System.out.println("SELECTION SORT: ");
        System.out.println("");
        test.selectionsort(test.randarray1);
        System.out.println("Duration for 2^10 Random Number Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.randarray2);
        System.out.println("Duration for 2^12 Random Number Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.randarray3);
        System.out.println("Duration for 2^14 Random Number Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.randarray4);
        System.out.println("Duration for 2^16 Random Number Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.randarray5);
        System.out.println("Duration for 2^18 Random Number Array: " + test.selectionsorttotalduration + " nanoseconds");

        //Selection Sort Monotonically Increasing Array of Varying Sizes
        test.selectionsort(test.monoincarray1);
        System.out.println("Duration for 2^10 Monotonically Increasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monoincarray2);
        System.out.println("Duration for 2^12 Monotonically Increasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monoincarray3);
        System.out.println("Duration for 2^14 Monotonically Increasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monoincarray4);
        System.out.println("Duration for 2^16 Monotonically Increasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monoincarray5);
        System.out.println("Duration for 2^18 Monotonically Increasing Array: " + test.selectionsorttotalduration + " nanoseconds");

        //Selection Sort Monotonically Decreasing Array of Varying Sizes
        test.selectionsort(test.monodecarray1);
        System.out.println("Duration for 2^10 Monotonically Decreasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monodecarray2);
        System.out.println("Duration for 2^12 Monotonically Decreasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monodecarray3);
        System.out.println("Duration for 2^14 Monotonically Decreasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monodecarray4);
        System.out.println("Duration for 2^16 Monotonically Decreasing Array: " + test.selectionsorttotalduration + " nanoseconds");
        test.selectionsort(test.monodecarray5);
        System.out.println("Duration for 2^18 Monotonically Decreasing Array: " + test.selectionsorttotalduration + " nanoseconds");



        //Merge Sort Random Array of Varying Sizes
        System.out.println("");
        System.out.println("MERGE SORT:");
        System.out.println("");
        test.mergesort(test.randarray1, 0, test.randarray1.size() - 1);
        System.out.println("Duration for 2^10 Random Number Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.randarray2, 0, test.randarray2.size() - 1);
        System.out.println("Duration for 2^12 Random Number Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.randarray3, 0, test.randarray3.size() - 1);
        System.out.println("Duration for 2^14 Random Number Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.randarray4, 0, test.randarray4.size() - 1);
        System.out.println("Duration for 2^16 Random Number Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.randarray5, 0, test.randarray5.size() - 1);
        System.out.println("Duration for 2^18 Random Number Array: " + test.mergesorttotalduration + " nanoseconds");

        //Merge Sort Monotonically Increasing Array of Varying Sizes
        test.mergesort(test.monoincarray1, 0, test.monoincarray1.size() - 1);
        System.out.println("Duration for 2^10 Monotonically Increasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monoincarray2, 0, test.monoincarray2.size() - 1);
        System.out.println("Duration for 2^12 Monotonically Increasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monoincarray3, 0, test.monoincarray3.size() - 1);
        System.out.println("Duration for 2^14 Monotonically Increasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monoincarray4, 0, test.monoincarray4.size() - 1);
        System.out.println("Duration for 2^16 Monotonically Increasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monoincarray5, 0, test.monoincarray5.size() - 1);
        System.out.println("Duration for 2^18 Monotonically Increasing Array: " + test.mergesorttotalduration + " nanoseconds");

        //Merge Sort Monotonically Decreasing Array of Varying Sizes
        test.mergesort(test.monodecarray1, 0, test.monodecarray1.size() - 1);
        System.out.println("Duration for 2^10 Monotonically Decreasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monodecarray2, 0, test.monodecarray2.size() - 1);
        System.out.println("Duration for 2^12 Monotonically Decreasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monodecarray3, 0 , test.monodecarray3.size() - 1);
        System.out.println("Duration for 2^14 Monotonically Decreasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monodecarray4, 0, test.monodecarray4.size() - 1);
        System.out.println("Duration for 2^16 Monotonically Decreasing Array: " + test.mergesorttotalduration + " nanoseconds");
        test.mergesort(test.monodecarray5, 0, test.monodecarray5.size() - 1);
        System.out.println("Duration for 2^18 Monotonically Decreasing Array: " + test.mergesorttotalduration + " nanoseconds");



        //Quick Sort Random Array of Varying Sizes
        System.out.println("");
        System.out.println("QUICK SORT:");
        System.out.println("");
        test.quicksort(test.randarray1, 0, test.randarray1.size() - 1);
        System.out.println("Duration for 2^10 Random Number Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.randarray2, 0, test.randarray2.size() - 1);
        System.out.println("Duration for 2^12 Random Number Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.randarray3, 0, test.randarray3.size() - 1);
        System.out.println("Duration for 2^14 Random Number Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.randarray4, 0, test.randarray4.size() - 1);
        System.out.println("Duration for 2^16 Random Number Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.randarray5, 0, test.randarray5.size() - 1);
        System.out.println("Duration for 2^18 Random Number Array: " + test.quicksorttotalduration + " nanoseconds");

        //Quick Sort Monotonically Increasing Array of Varying Sizes
        test.quicksort(test.monoincarray1, 0, test.monoincarray1.size() - 1);
        System.out.println("Duration for 2^10 Monotonically Increasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monoincarray2, 0, test.monoincarray2.size() - 1);
        System.out.println("Duration for 2^12 Monotonically Increasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monoincarray3, 0, test.monoincarray3.size() - 1);
        System.out.println("Duration for 2^14 Monotonically Increasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monoincarray4, 0, test.monoincarray4.size() - 1);
        System.out.println("Duration for 2^16 Monotonically Increasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monoincarray5, 0, test.monoincarray5.size() - 1);
        System.out.println("Duration for 2^18 Monotonically Increasing Array: " + test.quicksorttotalduration + " nanoseconds");

        //Quick Sort Monotonically Decreasing Array of Varying Sizes
        test.quicksort(test.monodecarray1, 0, test.monodecarray1.size() - 1);
        System.out.println("Duration for 2^10 Monotonically Decreasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monodecarray2, 0, test.monodecarray2.size() - 1);
        System.out.println("Duration for 2^12 Monotonically Decreasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monodecarray3, 0, test.monodecarray3.size() - 1);
        System.out.println("Duration for 2^14 Monotonically Decreasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monodecarray4, 0, test.monodecarray4.size() - 1);
        System.out.println("Duration for 2^16 Monotonically Decreasing Array: " + test.quicksorttotalduration + " nanoseconds");
        test.quicksort(test.monodecarray5, 0, test.monodecarray5.size() - 1);
        System.out.println("Duration for 2^18 Monotonically Decreasing Array: " + test.quicksorttotalduration + " nanoseconds");
    }
}
