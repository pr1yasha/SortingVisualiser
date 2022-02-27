public class GnomeSort {
    int[] array;
    static int currIndex = 0;
    static int swaps = 0;

    public GnomeSort(int[] array){
        this.array = array;
    }


    public void GnomeSort(int[] array){
        System.out.println(currIndex);
        if (array[currIndex+ 1] < array[currIndex]){
            swap(array, currIndex, currIndex+1);
            currIndex = 0;
        }
        else {
            currIndex++;
        }
    }

    // method that swaps two elements in array
    public void swap(int[] array, int x, int y){
        swaps++;
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void reset(){
        currIndex = 0;
        swaps = 0;
    }
}
