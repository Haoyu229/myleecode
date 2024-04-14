import java.util.*;

public class ProductFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> factors = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int factor = scanner.nextInt();
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                factors.add(factor);
            }
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long product = getProduct(l, r, factors);
            long factorCount = countFactors(product);
            System.out.println(factorCount);
        }
    }

    public static long getProduct(int l, int r, List<Integer> factors) {
        long product = 1;
        for (int j = l - 1; j < r; j++) {
            product = (product * factors.get(j)) % 1000000007;
        }
        return product;
    }

    public static long countFactors(long num) {
        long count = 0;
        for (long i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                if (num / i == i) {
                    count = (count + 1) % 1000000007;
                } else {
                    count = (count + 2) % 1000000007;
                }
            }
        }
        return count;
    }
}