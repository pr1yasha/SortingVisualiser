public class GnomeSort {
    int[] array;
    static int current_index = 0;

    public GnomeSort(int[] array){
        this.array = array;
    }

    public void GnomeSort(int[] array){
        if (array[current_index+ 1] < array[current_index]){
            swap(array, current_index, current_index+1);
            current_index = 0;


        }
        else {
            current_index++;
        }
    }

    // method that swaps two elements in array
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // resets all default parameters
    public void reset(){
        this.current_index = 0;
    }
}
