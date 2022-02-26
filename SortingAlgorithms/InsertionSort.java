public class InsertionSort {
    int[] array;
    static int current_index = 0;
    static boolean insertion_reset = true;
    static int portion_sorted = 0;
    static int compare_element = 0;

    public InsertionSort(int[] array){
        this.array = array;
    }

    // method that swaps two elements at a time (if required) according to insertion sort algorithm
    public int[] InsertionSort(int[] array) {
        if (insertion_reset == false){
            compare_element = array[current_index];
            portion_sorted = current_index - 1;
            insertion_reset = true;
        }

        if (portion_sorted >= 0 && array[portion_sorted] > compare_element){
            array[portion_sorted + 1] = array[portion_sorted];
            portion_sorted--;
            return array;
        }
        else {
            array[portion_sorted + 1] = compare_element;
            current_index++;
        }
        insertion_reset = false;
        return array;
    }

    // method that resets all default parameters in algorithm
    public void reset(){
        this.current_index = 0;
        this.portion_sorted = 0;
        this.compare_element = 0;
        this.insertion_reset = true;
    }


}
