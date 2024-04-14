import java.util.*;
public class yinzi {

        static final long MOD = (long) 1e9 + 7;

        // 预处理素数因子数量的最大数
        static int MAX_N = 100000;

        // 存储每个数字的素数因子数量
        static int[] primeFactorCount;

        static {
            // 预处理每个数字的素数因子数量
            primeFactorCount = new int[MAX_N + 1];
            for (int i = 2; i <= MAX_N; i++) {
                if (primeFactorCount[i] == 0) {
                    // i 是质数
                    for (int j = i; j <= MAX_N; j += i) {
                        primeFactorCount[j]++;
                    }
                }
            }
        }

        // 查询区间乘积的因子数量
        public static long queryProductFactors(int[] array, int l, int r) {
            // 计算区间乘积的素数因子数量
            long factorCount = 0;
            for (int i = l; i<=r; i++) {
//                factorCount += primeFactorCount[array[i]];
//                factor_num*=
                factorCount %= MOD;
            }
            return factorCount;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // 读取 n 和 m
            int n = scanner.nextInt();
            int m = scanner.nextInt();
//            System.out.print(m);
//            System.out.print(n);
            // 初始化数组
            int[] array = new int[n];
            int arr_num=0;
            // 处理连续段
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                for(int j=0;j<v;j++){
                    array[arr_num++]=u;
                }
            }
            // 读取 q
            int q = scanner.nextInt();

            // 处理每次查询
            for (int i = 0; i < q; i++) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();

                // 查询区间乘积的因子数量
                long result = queryProductFactors(array, l, r);
                System.out.println(result);
            }

            scanner.close();
        }


}
