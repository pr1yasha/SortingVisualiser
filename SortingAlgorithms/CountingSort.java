public class CountingSort {
    int[] array;
    int[] count_array; //array with frequencies of each int
    int[] copyArray; //copy of array being sorted
    static int currIndex = 0;
    int max = 0;

    public CountingSort(int[] array){
        this.array = array;
        this.copyArray = new int[80];
    }

    // resets default parameters
    public void reset(){
        this.currIndex = 0;
        this.max = 0;
    }

    // copies array to copy_array
    public int[] copyArray(int[] copyArray, int[] array){
        for (int i=0; i<array.length; i++){
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    // checks frequency of an element 'num' in array
    public int checkFrequency(int[] array, int num){
        int frequency = 0;
        for (int i=0; i<array.length; i++){
            if (array[i] == num){
                frequency++;
            }
        }
        return frequency;
    }

    // fills frequency array with frequencies
    public void fillCountArray(int[] count_array, int[] array){
        int sum = 0;
        for (int i=0; i<count_array.length; i++){
            count_array[i] = checkFrequency(array, i);
        }

        for (int i=1; i<count_array.length; i++){
            sum = count_array[i] + count_array[i-1];
            count_array[i] = sum;
        }
    }

    // returns maximum element in array
    public int getMax(int[] array){
        int max = 0;
        for (int i=0; i<array.length; i++){
            if (array[i]>max){
                max = array[i];
            }
        }
        return max;
    }

    
    public void CountingSort(int[] array){
        System.out.println(copyArray[currIndex] + " " + currIndex);
        // initialises frequency array and the copy of the array if it's the first pass
        if (currIndex == 0){
            this.max = getMax(array);
            int[] intArray = new int[max+1];
            this.count_array = intArray;
            fillCountArray(count_array, array);
            this.copyArray = copyArray(copyArray, array);
        }

         // adjusts elements if required according to Counting Sort algorithm
         if (currIndex < 80){
             int index = count_array[copyArray[currIndex]] - 1;
             count_array[copyArray[currIndex]] = index;
             array[index] = copyArray[currIndex];
             currIndex++;
         }

    }
}
