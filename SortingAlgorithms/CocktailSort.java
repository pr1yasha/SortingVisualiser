public class CocktailSort {
    int[] array;
    boolean cocktailForward = true;
    static int current_index = 0; // cursor
    static int portion_sorted = 0; // number of elements sorted at the end
    static int forwardPortionSorted = 0; // number of elements sorted at the start

    public CocktailSort(int[] array){
    this.array = array;
    }

    // makes one swap at a time (if required) using the cocktail shaker algorithm
    public void cocktailSort(int[] array){
        System.out.println(current_index);
        if (cocktailForward == true){
            if (current_index >= array.length - 1 - portion_sorted){
                portion_sorted++;
                cocktailForward = false;
                current_index = array.length - 1 - portion_sorted;
            }
            if (array[current_index] > array[current_index+1]){
                swap(array, current_index, current_index+1);
                current_index++;
            }
            else {
                current_index++;
            }
        }
        if (cocktailForward == false){
            if (current_index <= portion_sorted) {
                forwardPortionSorted++;
                cocktailForward = true;
                current_index = forwardPortionSorted;
            }
            if (array[current_index] < array[current_index-1]){
                swap(array, current_index, current_index-1);
                current_index--;
            }
            else {
                current_index--;
            }
        }
    }

    // method that swaps two elements in an array
    public void swap(int[] array, int x, int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    // method that resets al default parameters
    public void reset(){
        this.current_index = 0;
        this.portion_sorted = 0;
        this.forwardPortionSorted = 0;
        this.cocktailForward = true;
    }

}
