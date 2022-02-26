public class SelectionSort {
    int[] array;
    static int current_index = 0;
    static int portion_sorted = 0;
    static int min_num = 0;

    public SelectionSort(int[] array){
        this.array = array;
    }
    
    // method that swaps two elements at a time (if required) according to selection sort algorithm
    public void SelectionSort(int[] array){
        if (current_index >= array.length - 1){
            swap(array, portion_sorted, min_num);
            portion_sorted++;
            current_index = portion_sorted;
            min_num = portion_sorted;
        }
        else {
            current_index++;
        }

        if (array[current_index] < array[min_num]){
            min_num = current_index;
        }
    }

    // method that swaps two elements in array
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // method that resets all default parameters in algorithm
    public void reset(){
        this.current_index = 0;
        this.portion_sorted = 0;
        this.min_num = 0;
    }
}
