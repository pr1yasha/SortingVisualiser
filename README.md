# SortingVisualiser

A java program that visualises different sorting methods with a Java Swing GUI.

# Bubble Sort
In bubble sort, the cursor (pink) loops through the unsorted array, obtains the largest number and places it at the end of the unsorted array.

![image](https://user-images.githubusercontent.com/99101410/155618955-786c7ed0-9668-43ae-b976-89f6d1d5e9b7.png)


# Selection Sort

In selection sort, the cursor (yellow) loops through the array, while a second cursor (blue) loops through the unsorted portion of the array and finds the smallest number (pink) before returning it to the end of the sorted part of the array.

![image](https://user-images.githubusercontent.com/99101410/155619167-8e6a6257-d4d1-4714-ab84-7dff0ca8db15.png)

# Pancake Sort

In pancake sort, the biggest element of the unsorted portion of the array is found (say at index N), and then all of the elements up to N are flipped using the flipfront function. After that the array is flipped once more, this time until the end of the unsorted array, as the largest element is now at the beginning. Thus, the largest element is at the end of the array. The unsorted array decreases in size (as we have already sorted the largest element and placed it at the end) and the function is called recursively until the array has been sorted.

Below, the maximum element can be seen in pink, and the first element in yellow.

![image](https://user-images.githubusercontent.com/99101410/155628254-6844f683-521b-4773-bbdc-122f29f3704e.png)

Next, all elements between the initial yellow and pink elements reverse, as seen below. After this, all elements within the unsorted array are flipped and the largest element (seen below in pink) is placed at the end of the unsorted array, joining the green sorted portion.

![image](https://user-images.githubusercontent.com/99101410/155628269-9a2e386a-87cc-4cf0-b064-4e2d8ddd4082.png)
