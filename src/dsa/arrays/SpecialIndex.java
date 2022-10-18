package dsa.arrays;

public class SpecialIndex {
    /**
     * Problem Description
    Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



    Problem Constraints
1 <= n <= 105
            -105 <= A[i] <= 105


    Input Format
    First argument contains an array A of integers of size N


    Output Format
    Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



    Example Input
    Input 1:
    A=[2, 1, 6, 4]
    Input 2:

    A=[1, 1, 1]


    Example Output
    Output 1:
            1
    Output 2:

            3


    Example Explanation
    Explanation 1:
    Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1].
    Therefore, the required output is 1.
    Explanation 2:

    Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
    Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
    Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1]
    Therefore, the required output is 3.

     */
    public int solve(int[] A) {
        int len = A.length;
        int ans = 0;
        int [] preven = new int[len];
        int [] prodd = new int[len];

        preven[0] = A[0];
        for(int i = 1; i < len; i++)
        {
            if(i % 2 == 0)
                preven[i] = preven[i-1] + A[i];
            else
                preven[i] = preven[i-1];
        }

        prodd[0] = 0;
        for(int i = 1; i < len; i++)
        {
            if(i % 2 == 0)
                prodd[i] = prodd[i-1];
            else
                prodd[i] = prodd[i-1] + A[i];
        }

        for(int i = 0; i < len; i++)
        {
            int evensum = 0;
            int oddsum = 0;
            if(i == 0)
            {
                evensum = prodd[len-1] - prodd[i];
                oddsum = preven[len-1] - preven[i];
            }
            else{
                evensum = preven[i - 1] + prodd[len-1] - prodd[i];
                oddsum = prodd[i-1] + preven[len-1] - preven[i];
            }
            if(evensum == oddsum)
            {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] a)
    {
        int [] A = new int[] {2, 1, 6, 4};
        SpecialIndex si = new SpecialIndex();
        System.out.println(si.solve(A));
    }
}
