public class BubbleSort {
    int[] array;
    static int current_index = 0; //cursor
    static int portion_sorted = 0; //number of items already sorted

    public BubbleSort(int[] array){
        this.array = array;
    }

    // makes one swap at a time (if required) using bubble sort algorithm
    public void BubbleSort(int[] array) {
        if (current_index >= array.length - 1 - portion_sorted) {
            current_index = 0;
            portion_sorted++;
        }

        if (array[current_index] > array[current_index + 1]) {
            swap(array, current_index, current_index + 1);
            current_index++;
        } else {
            current_index++;
        }
    }
    // swaps two elements in an array
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}
