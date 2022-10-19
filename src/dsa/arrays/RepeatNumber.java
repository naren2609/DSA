package dsa.arrays;

/**
 * Problem Description
 * You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
 * If so, return the integer. If not, return -1.
 *
 * If there are multiple solutions, return any one.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 7*105
 * 1 <= A[i] <= 109
 *
 *
 * Input Format
 * The only argument is an integer array A.
 *
 *
 * Output Format
 * Return an integer.
 *
 *
 * Example Input
 * [1 2 3 1 1]
 *
 *
 * Example Output
 * 1
 *
 *
 * Example Explanation
 * 1 occurs 3 times which is more than 5/3 times.
 *
 * */

public class RepeatNumber {
    public int repeatedNumber(int[] A) {
        int len = A.length;
        int ele1 = -1;
        int ele1count = 0;
        int ele2 = -1;
        int ele2count = 0;
        for(int i = 0; i < len; i++)
        {
            if(A[i] == ele1)
            {
                ele1count++;
                continue;
            }
            if(A[i] == ele2)
            {
                ele2count++;
                continue;
            }
            if(ele1count == 0)
            {
                ele1 = A[i];
                ele1count = 1;
                continue;
            }
            if(ele2count == 0)
            {
                ele2 = A[i];
                ele2count = 1;
                continue;
            }
            if(A[i] != ele1 && A[i] != ele2)
            {
                ele1count--;
                ele2count--;
                continue;
            }
        }
        ele1count = 0;
        ele2count = 0;
        for(int i = 0; i < len; i++)
        {
            if(ele1 == A[i])
            {
                ele1count++;
            }
            if(ele2 == A[i])
            {
                ele2count++;
            }
        }
        if(ele1count > len/3)
        {
            return ele1;
        }
        if(ele2count > len/3)
        {
            return ele2;
        }
        return -1;

    }
    public static void main(String[] a)
    {
        int [] A = new int[] {2, 2, 3, 4,2,5};
        RepeatNumber me = new RepeatNumber();
        System.out.println(me.repeatedNumber(A));
    }
}
