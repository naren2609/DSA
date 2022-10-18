package dsa.arrays;
/**
Majority Element
Solved
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.



Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109


Input Format
Only argument is an integer array.


Output Format
Return an integer.


Example Input
[2, 1, 2]


Example Output
2


Example Explanation
2 occurs 2 times which is greater than 3/2.
 */
public class MajorityElement {
    public int majorityElement(final int[] A) {
        //Moore's Algorithm

        int element = A[0];
        int count = 1;
        for(int i = 1; i < A.length; i++)
        {
            if(count == 0)
            {
                element = A[i];
                count++;
                continue;
            }
            if(A[i] == element)
            {
                count++;
            }
            else
            {
                count--;
                continue;
            }
        }
        int counter = 0;
        for(int i = 0; i < A.length; i++)
        {
            if(A[i]==element)
            {
                counter++;
            }
        }
        if(counter > A.length / 2)
        {
            return element;
        }
        return 0;
    }
    public static void main(String[] a)
    {
        int [] A = new int[] {2, 2, 3, 4,2};
        MajorityElement me = new MajorityElement();
        System.out.println(me.majorityElement(A));
    }
}
