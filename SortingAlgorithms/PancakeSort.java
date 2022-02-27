public class PancakeSort {
    int[] array;
    int portionSorted = 0; // elements sorted
    int currMax = 0; // index of maximum element in unsorted portion of array
    boolean flip = false; // boolean that indicates if ready for flip (true when largest element at start of array)
    static int swaps = 0;

    public PancakeSort(int[] array){
        this.array = array;
    }

    // method that swaps two elements at a time (if required) according to pancake sort algorithm
    public void PancakeSort(int[] array){
        if (portionSorted < array.length) {
            if (!flip) {
                currMax = getMax(array, array.length - portionSorted);
                flipfront(array, currMax + 1);
                flip = true;
            } else {
                flipfront(array, array.length - portionSorted);
                portionSorted++;
                flip = false;
            }
        }
    }

    //  reverses elements in an element up to 'num'
    public void flipfront(int[] array, int num){
        for (int i=0; i<num/2; i++){
            swap(array, i, num - i -1);
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
        this.currMax = 0;
        this.portionSorted = 0;
        this.flip = false;
        swaps = 0;
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
