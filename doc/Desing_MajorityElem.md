## Majority Element Algorithm Explanation

**Base Case:** The list just have one element

**Recursive Case:** The list have more than one element.

**Inductive Hypothesis**: For a list size  n  we assume the algorithm works correctly.

**Recursive Step:** We want to check that the algorithm works correctly also for a list of size n+1, for this the algorithm takes half "k" of the list, then splits the list on the right side making a recursive call and repeats the process on the left side in order to find the majority elements on both sides, then it compares and if they are equal it means that that value is the largest in the list, so it returns it, otherwise it calls a helper method that helps it count the frequency in which the elements appear. Finally it compares if this frequency is greater than half "k" on the left and if it is true, returns the element otherwise, repeat the process for the element on the right side and if neither of the two clauses is met, it returns -1, which means that the element was not found.


## Majority Element Comlexity Analysis Problem 2

The recurrence of this prolem is given by:

$T(n) = 2T(n/2) + O(n)$

We note that the recurrence has the form  $T(n) = aT(n/b) + f(n)$ where $a = 2$ and $b = 2$. So we can apply the Master Method.

And it looks like this:

$Log_{2}$ $2 = 1$

We check which of the cases of the master method is fulfilled and we find that case 2 is fulfilled:

$n = n$, therefore the complexity of this algorithm is: $T(n) = θ(n$ $log$ $n)$

## Tests Desing

| Test Case Description                               | Input                         | Expected Output |
|----------------------------------------------------|-------------------------------|-----------------|
| Test 1: Empty List                                  | List()                        | 0               |
| Test 2: Single Element                              | List(4)                       | 1               |
| Test 3: No Majority Element (Strictly Greater)     | List(1, 2, 3, 4, 5, 6, 7, 8, 9) | 0               |
| Test 4: No Majority Element (Strictly Greater)     | List(3, 1, 2, 3, 3, 4, 2)     | 0               |
| Test 5: Majority Element Exists                    | List(4, 2, 4, 3, 4, 4, 2, 4) | 1               |
| Test 6: Majority Element Exists                    | List(7, 7, 7, 5, 1)           | 1               |

