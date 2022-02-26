public class PancakeSort {
    int[] array;
    int portion_sorted = 0;
    int current_max = 0;
    boolean flip = false;
    
    public PancakeSort(int[] array){
        this.array = array;
    }
    
    // method that swaps two elements at a time (if required) according to pancake sort algorithm
    public void PancakeSort(int[] array){
        if (portion_sorted < array.length) {
            if (flip == false) {
                current_max = getMax(array, array.length - portion_sorted);
                flipfront(array, current_max + 1);
                flip = true;
            } else {
                flipfront(array, array.length - portion_sorted);
                portion_sorted++;
                flip = false;
            }
        }
    }

    
    public void flipfront(int[] array, int num){
        for (int i=0; i<num/2; i++){
            swap(array, i, num - i -1);
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
        this.current_max = 0;
        this.portion_sorted = 0;
        this.flip = false;
    }

    // returns index of maximum element in an array
    public int getMax(int[] array, int n){
        int index = 0;
        int max = array[0];
        for (int i=0; i < n; i++){
            if (array[i] > max){
                max = array[i];
                index = i;
            }
        }
        return index;
    }
}
