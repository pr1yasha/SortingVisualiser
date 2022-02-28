# SortingVisualiser

A java program that visualises different sorting methods with a Java Swing GUI.

## Bubble Sort
In bubble sort, the cursor (pink) loops through the unsorted array, obtains the largest number and places it at the end of the unsorted array.

![image](https://user-images.githubusercontent.com/99101410/155901294-7ade247c-5a11-4799-a687-4c795b1a0842.png)


## Selection Sort

In selection sort, the cursor (yellow) loops through the array, while a second cursor (blue) loops through the unsorted portion of the array and finds the smallest number (pink) before returning it to the end of the sorted part of the array.

![image](https://user-images.githubusercontent.com/99101410/155906027-317cf14b-f6d3-4ea9-93b8-61b8a9b6a367.png)

## Pancake Sort

In pancake sort, the biggest element of the unsorted portion of the array is found (say at index N), and then all of the elements up to N are flipped using the flipfront function. After that the array is flipped once more, this time until the end of the unsorted array, as the largest element is now at the beginning. Thus, the largest element is at the end of the array. The unsorted array decreases in size (as we have already sorted the largest element and placed it at the end) and the function is called recursively until the array has been sorted.

Below, the maximum element can be seen in pink, and the first element in yellow.

![image](https://user-images.githubusercontent.com/99101410/155628254-6844f683-521b-4773-bbdc-122f29f3704e.png)

Next, all elements between the initial yellow and pink elements reverse, as seen below. After this, all elements within the unsorted array are flipped and the largest element (seen below in pink) is placed at the end of the unsorted array, joining the green sorted portion.

![image](https://user-images.githubusercontent.com/99101410/155628269-9a2e386a-87cc-4cf0-b064-4e2d8ddd4082.png)

## Cocktail Sort

Cocktail sort works like bubble sort, except in alternating directions. In the image below, array can be seen to be sorted at the front as well as the back.

![image](https://user-images.githubusercontent.com/99101410/155902781-d91bc476-38a0-4e37-b1ef-e0373494e4fd.png)

## Gnome Sort

In gnome sort, adjacent elements are swapped if they are not sorted. If elements are swapped, the cursor (pink) moves one step backwards and repeats the process, moving forward when there is nothing to be swapped.

![image](https://user-images.githubusercontent.com/99101410/155902847-18ef1882-bd70-431d-9013-400eb1183a20.png)

## Counting Sort

In Counting Sort, a second array made of the cumulative frequencies of different elements is created and used to sort the array. This is the only sorting algorithm in this program that is not in-place.
