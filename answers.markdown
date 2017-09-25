<h2> What is the complexity of each of the four search methods in terms of array or list size n? </h2>
The complexity of the "Looks for the position of the named team in an array" method is at least 2, one 
for i=0, and one for each instance for the array at index i.getname = key. The complexity of the "Looks 
for the position of the named team in a list" method, even though it is a list, also has a minimum of 2 
complexities for the same reasons. The complexity of the "Looks for the position of the poorest team that
has at least the specified funding level" has at least three - one for the assignment of int i=0, one 
for each assignment of poorest team = i, and one for the assignment of leastfunding = arr[i].funding().
The complexity of the final binary search has 2 for the addition of low and high and the division by 2, 
int high  = size -1, one for each reassignment of mid and max or min, and one for the assignment of midFunding.


<h2> What happens in the case of binary search if the array is not sorted? </h2>
If the array is not sorted, the binary search has a higher chance of not finding the 
desired number. For instance if the array is [1, 18, 7, 2765498, 23, 38, 4444] , if 
someone is looking for 23, the max will be set to 2765498 since it is greater than 23,
but in fact 23 is on the other side so it will not find 23.



<h2> What is the purpose of constructor argument validity checking? </h2>
The goal of the constructor argument validity checking is that if the program were to fail, 
it would fail as quickly as possible as opposed to lingering for a while, having people 
waiting unnecessarily only for the program to fail or find the desired result. One of the 
objects of having programs





<h2> What is the purpose of using the keyword final with variables and arguments? </h2>
Final is used to guarantee "final correctness", by not allowing a variable/arg to be modfied.
If anything is attempting to add to a variable/arg with the keyword, an error will appear. 


<h2> What are alternatives to using Optional and how do they compare? </h2>
Instead of "optional" one can use null. The pitfall of this is that throughout the code
there would be null values. If ever these variables(that are null) were referenced, a 
"NullPointerException" would arise. 






