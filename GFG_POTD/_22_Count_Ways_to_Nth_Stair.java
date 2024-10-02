
class _22_Count_Ways_to_Nth_Stair {
    public int nthStair(int n) {
        // Code here
        return n/2 + 1;
    }
    
    
}


/*
 * | C++ Solution | Time Complexity = O(1) and Space Complexity = O(1) | Explanation with Code | Best Solution |
First, I've tried this problem through Recursion + Hashmap that gives TLE that is obvious reason but if you look into the problem very carefully you will find the pattern and get O(1) solution. 

Let's understand it via taking an example n = 6: 

Intuition:
First assume you've chosen to achive goal by climbing 1 stair each time so, you will get below path1 then, try to club two 1s successively from above path to get new path

n = 6

  path1: 1 1 1 1 1 1 
  path2:   2  1 1 1 1
  path3:   2    2  1 1
  path4:   2    2    2
In above n = 6, you will get total 4 ways to do because according to the problem path shouldn't be repetitive so, there is no repetition (i.e.  (2, 2, 1, 1) = (2, 1, 2, 1) = (1, 2, 2, 1) ....). Similarly, you can try for odd number of stairs and you will get the same as below:

n = 7

  path1: 1 1 1 1 1 1 1 
  path2:   2  1 1 1 1 1
  path3:   2    2  1 1 1 
  path4:   2    2    2  1
Conclusion:
Answer = N/2 + 1

This is what you have to return as your answer that's a smart solution.
 */
