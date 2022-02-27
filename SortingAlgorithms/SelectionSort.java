public class SelectionSort {
    int[] array;
    static int current_index = 0; // cursor
    static int portion_sorted = 0; // number of elements that have been sorted at the start
    static int minNum = 0; // smallest number out of the unsorted elements
    static int swaps = 0;

    public SelectionSort(int[] array){
        this.array = array;
    }

    // method that swaps two elements at a time (if required) according to selection sort algorithm
    public void SelectionSort(int[] array){

        if (current_index >= array.length - 1){
            swap(array, portion_sorted, minNum);
            portion_sorted++;
            current_index = portion_sorted;
            minNum = portion_sorted;
        }
        else {
            current_index++;
        }

        if (array[current_index] < array[minNum]){
            minNum = current_index;
        }
    }

    // method that swaps two elements in array
    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // method that resets all default parameters in algorithm
    public void reset(){
        current_index = 0;
        portion_sorted = 0;
        minNum = 0;
        swaps = 0;
    }
}
