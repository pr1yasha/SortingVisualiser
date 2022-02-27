public class InsertionSort {
    int[] array;
    static int currIndex = 0; // cursor
    static boolean insertionReset = true; 
    static int portionSorted = 0; // elements in array that have been sorted
    static int compareElement = 0; // element being compared to

    public InsertionSort(int[] array){
        this.array = array;
    }

    // method that swaps two elements at a time (if required) according to insertion sort algorithm
    public void InsertionSort(int[] array) {
        if (!insertionReset){
            compareElement = array[currIndex];
            portionSorted = currIndex - 1;
            insertionReset = true;
        }

        if (portionSorted >= 0 && array[portionSorted] > compareElement){
            array[portionSorted + 1] = array[portionSorted];
            portionSorted--;
            return;
        }

        else {
            array[portionSorted + 1] = compareElement;
            currIndex++;
        }

        insertionReset = false;
    }

    // method that resets all default parameters in algorithm
    public void reset(){
        currIndex = 0;
        portionSorted = 0;
        compareElement = 0;
        insertionReset = true;
    }


}
