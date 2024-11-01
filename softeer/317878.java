import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    public static final BigInteger DIVIDER = new BigInteger("1000000007");

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] KPN = br.readLine().split(" ");
        String k = KPN[0]; // 바이러스
        String p = KPN[1]; // 증가율
        int n = Integer.parseInt(KPN[2]); // 총 시간

        BigInteger result = new BigInteger(k);
        BigInteger bigP = new BigInteger(p);
        
        for (int i=1; i<=n; i++) {
            result = result.multiply(bigP).mod(DIVIDER);
            	
        }

        System.out.println(result.mod(DIVIDER)); //  % DIVIDER
    }
}

