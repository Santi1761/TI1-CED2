**CONTEXT OF THE PROBLEM:**

A online lottery is being organized.

- You bet on a single integer #.
- Then several ranges of # integers are drawn to the random
- Is paid proportional to the number of ranks that the bettor's # has minus the # of ranks that do not contain it.

A algorithm is needed to calculate payments for all participants.

- They give a set of points on a line and a set of segments on a line. The # of segments that are at that point must be calculated for this point.

INPUT:

- The line 1 has 2 # non-negative integers (s and p), these define the # of segments and points in a line.
- The next straight lines have 2 # integers a_i and b_i. These define the ith segment [a_i, b_i]
- The following line has p integers that define the points x_1, x_2, … x_p

OUTPUTS:

- p non-negative integers k_0, k_1, …, k_p-1; k_i is the number of segments that xi has

More formal:k_i |j:a_j≤ x_i ≤ b_j|

Should consider:

1) 1 ≤ s, p ≤ 50000
1) -10_8 ≤ a_i ≤ b_i ≤ 10_8 for all 0 ≤ i < s
1) -10_8 ≤ x_j ≤ 10_8 for all 0 ≤ j < p






**Structural induction:**

- **Base case:**

Empty list of segments or points, then either the list does not exist or the point is not contained in any segment and the function returns 0.


- **Inductive Hypothesis:**

It is assumed that a solution is found that satisfies lists of various segments with less than x number of segments and p number of points.

- **Inductive step:**

We have a list of segments S with s segments and a point p. The list of segments S is divided into two halves, one to the left of the middle index and one to the right. Let us denote these halves as leftSegments and rightSegments, respectively.

The solution works for these 2 lists according to what was defined in the hypothesis. Therefore, we can recursively apply the solution to both leftSegments and rightSegments to find the number of segments containing point p in each half.

If point p is contained in one of the segments in list S, then it must be contained in one of the leftSegments or rightSegments segments. Therefore, the number of segments containing point p in list S is equal to the sum of the number of segments containing point p in each of the 2 halves.

If the point p is not contained in any of the segments of the list S, then the number of segments that contain the point p in the list S is equal to 0. Thanks to this it can be concluded that the solution to the problem works correctly for all segment lists.




**Complexity:**

- **Recurrence ratio:**

T(n) = 2T(n/2) + O(n)

This is because the MergeSort function splits a list of length 'n' into two halves of length n/2, sorts each half recursively, and then merges the two sorted halves into a single sorted list. That is, 2T(n/2) refers to the time to arrange the 2 halves and O(n) is the time required to combine them

**Master Method:**


a = 2

b = 2

f(n) = O(n)

` `a and b are equal, so is the second case of the master method O(n log n).The execution time increases logarithmically as a function of the input size.



**Test:**

  


| Test Case Description                                | Input Segments and Points              | Expected Output   |
|-----------------------------------------------------|----------------------------------------|-------------------|
| Test 1: Should return [1, 1, 0] for segments and points | Segments: `[(0, 7), (5, 10)]`<br> Points: `[1, 6, 11]` | `[1, 1, 0]`       |
| Test 2: Should return [1] for a single segment and point | Segments: `[(1, 5)]`<br> Points: `[3]` | `[1]`             |
| Test 3: Should return [0, 0, 0] for segments and points | Segments: `[(1, 5)]`<br> Points: `[0, 6, 7]` | `[0, 0, 0]`       |
| Test 4: Should return [1, 0, 0] for segments and points | Segments: `[(0, 5), (7, 10)]`<br> Points: `[1, 6, 11]` | `[1, 0, 0]`       |
| Test 5: Should return [0, 0, 1] for segments and negative points | Segments: `[(-10, 10)]`<br> Points: `[-100, 0, 100]` | `[0, 0, 1]`       |
| Test 6: Should return [2, 0] for overlapping segments and points | Segments: `[(0, 5), (-3, 2), (7, 10)]`<br> Points: `[1, 6]` | `[2, 0]`  
