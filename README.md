# Coding Problem
Finding the first smallest positive integer (greater than 0) that does not occur in an array.
Write a function that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A. For example: 
- Given A = [1, 3, 6, 4, 1, 2], the function should return 5.
- Given A = [1, 2, 3], the function should return 4.
- Given A = [−1, −3], the function should return 1.
# Task
Write an efficient algorithm for the following assumptions:
- N is an integer within the range [1..100,000]
- Each element of array A is an integer within the range [−1,000,000..1,000,000]
# Solution
Big-O analysis: O(n) time complexity and O(1) space complexity)
  - The first smallest missing positive integer will be always in the range from 1 to (array.length + 1)
  - If the array is empty, return 1
  - Ignore negative values or too high index values (> array.length)
  - Loop over the array with above conditions and arrange the array to get a sequence of positive integers 1, 2, 3, 4, 5, 6 ... by swapping elements into the correct positions.
  - Next loop, it would find the first value not in the correct position and then return i+1 that is the smallest positive integer
  - If the end of loop is reached without returning value , then (array.length +1) is the smallest positive integer