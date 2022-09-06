✔ Attach a README documenting the necessary steps to build and run your program.


1. Open this folder in a code editor that support Java.
2. Write in input.txt file per lines some words that you want to test if they are anagrams.
3. Run the program and see the result.

-----------------------------------------------------------------------------------------------

✔ Attach a document explaining any design decisions you have made. Consider aspects such as
Maintainability, Scalability, Performance, etc. If you decide to use external libraries, make sure to
justify why you picked them.


I did not make a design decision.
As for Maintainability, Scalability and Performance, i can say that i have tried to write code that is easy to read. For this are used the CamelCase style.
For some code sequences i have written some comments, so that in case of checking or editing it, the user can enter the logic of the program as quickly as possible.
Code sequences coinciding with the DRY principle were used, i.e, if a variable is changed, then its content is changed throughout the program.
Regarding performance, the time complexity of the above solutions is O(N × M × log(M)), where N is the total number of words, and M length of longest word.


-----------------------------------------------------------------------------------------------

✔ How will your application cope with larger datasets, say 10 Million Words, and 100 Billion
Words? If you wanted to cover these cases, how would you scale your application?


To begin with i created a simple algorithm, which had Time Complexity O(n^2), which is a solution, but not a very good one,
because for 100k words it compiles in 10-15 seconds (very slow, for million words -> time will be increases), then it was decided to change way
of solving the problem and ended up with O(N x M x log(M)),which is much better because it compiles instantly.

For very large data sets, i think the data should be split, not compiled all together. We could use microservices,
but i'm not sure if that's possible, because i haven't had the experience of working with microservices.










