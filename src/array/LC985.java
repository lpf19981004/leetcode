package array;

/**
 * @author liangpf
 * @Date 2019/10/8
 */
public class LC985 {
    public static void main(String[] args) {
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int index;
        int sum = 0;
        int val;
        int[] ans = new int[queries.length];
        for (int i = 0; i < A.length; i++)
            if (A[i]%2 == 0)
                sum+=A[i];

        for (int i = 0; i < queries.length; i++){
            val = queries[i][0];
            index = queries[i][1];
            //A[index]+=val;
            if (A[index] % 2 == 0)
                sum -= A[index];
            A[index]+=val;
            if (A[index]%2 == 0)
                sum += A[index];
            ans[i] = sum;

        }
        return ans;
    }
}
