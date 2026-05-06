import java.util.*;

public class ArrayTransform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long[] A = new long[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }
        long K = sc.nextLong();
        
        long minOps = solve(N, A, K);
        System.out.println(minOps);
    }
    
    private static long solve(int N, long[] A, long K) {
        if (K == 0) {
            for (int i = 1; i < N; i++) {
                if (A[i] != A[0]) {
                    return -1;
                }
            }
            return 0;
        }
        
        long remainder = ((A[0] % K) + K) % K;
        for (int i = 1; i < N; i++) {
            if (((A[i] % K) + K) % K != remainder) {
                return -1;
            }
        }
        
        long[] B = new long[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i] / K;
        }
        
        Arrays.sort(B);
        
        long target = B[N / 2];
        
        long operations = 0;
        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - target);
        }
        
        return operations;
    }
}
