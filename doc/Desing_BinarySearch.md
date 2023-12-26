## Binary Search Algorithm Explanation

**Base Case:** The target is equal to the mid-value of the list. In this scenario, the algorithm correctly returns the position of the mid-value, indicating that the target has been found in the list.

**Recursive Case:** The target has not been found yet.

**Inductive Hypothesis:** For a list of size "n," let's assume that the algorithm works correctly, where "n" is the size of the current list.

**Recursive Step:** We will consider two cases to prove that the algorithm works for a list of size "n."

The recursive step works for a list of "n" elements or a list of "n+1" elements as follows:

The algorithm is subdivided into two problems:
- If the mid-value is less than the target, binary search is performed in the right half of the list.
- If the mid-value is greater than the target, binary search is performed in the left half of the list.

According to the inductive hypothesis, the algorithm works correctly for a list of size "n." Therefore, if the list contains the target, the algorithm will find it in one of the halves. If it's not in the list, it returns -1, providing evidence of its correctness.

## Binary Search Complexity Analysis Problem 1

The binary search algorithm splits the list into two parts in half. Let's assume that the lists are of size $2^i$ for i ∈ ℤ. The complexity applies for similar lists of various sizes. For the sizes, the value of l_XM is evaluated in O(1), including the case in which the list is size 1. When the element l_XM is different from the target value, it splits into one subproblem $n/2$ size, where n is the original length of the list. The recurrence formula is:

$T(n) = T(n/2) + c$

The recurrence tree consists of the division of the problem of size n into n/2 until the middle matches the element or the size of the subproblem is 1. So the worst-case scenario is accordingly $n/2^i = 1$ to calculate the levels of the tree. Let's solve for i:

Let's solve for i:

$\[ \frac{n}{2^i} = 1 \]$

$\[ 2^i = n \]$

$\[ i = \log_2{n} \]$

On every level, the mid-element is evaluated in constant time. So the total complexity is c * log₂(n). Big O notation ignores the constants; thus, the total complexity is:

$O(\log{n})$

It's important to mention that every time the list is split, there is an extra cost of n, which results in the estimated complexity of the problem as:

$O(n \log{n})$


## BinarySearch Tests:

| **Test Case Description** | **Steps and Test Data** | **Expected Output** |
|--------------------------|-------------------------|---------------------|
| BinarySearch should return the correct list of indices | Create a sorted list: `[1, 5, 8, 12, 13]`<br> Create a target list: `[8, 1, 23, 1, 11]` | `[2, 0, -1, 0, -1]` |
| BinarySearch should return the correct list of indices | Create a sorted list: `[1, 5, 8, 12, 13]`<br> Create a target list: `[8, 1, 23, 1, 11]` | `[2, 0, -1, 0, -1]` |
| BinarySearch should return a list of indices not found (-1) | Create a sorted list: `[1, 5, 8, 12, 13]`<br> Create a target list: `[12, 13, 8, 1, 5]` | `[3, 4, 2, 0, 1]` |

| **Class** | **Method** | **Scenery** | **Input** | **Output** |
|-----------|------------|-------------|-----------|------------|
| BinarySearch | searchEachIndex | A BinarySearch | Sorted List: `[1, 5, 8, 12, 13]`<br> Target List: `[8, 1, 23, 1, 11]` | `[2, 0, -1, 0, -1]` |
| BinarySearch | searchEachIndex | A BinarySearch | Sorted List: `[1, 5, 8, 12, 13]`<br> Target List: `[8, 1, 23, 1, 11]` | `[2, 0, -1, 0, -1]` |
| BinarySearch | searchEachIndex | A BinarySearch | Sorted List: `[1, 5, 8, 12, 13]`<br> Target List: `[12, 13, 8, 1, 5]` | `[3, 4, 2, 0, 1]` |
