import java.util.HashSet;
import java.util.Set;

public class meituan {

    public int findDistinctSubsequences(String x) {
        // 用集合存储满足条件的子序列
        Set<String> S = new HashSet<>();

        // 获取数字串的长度
        int n = x.length();

        // 生成所有非空子序列
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subseq = x.substring(i, j);
                // 检查相邻数字是否两两不同
                boolean valid = true;
                for (int k = 1; k < subseq.length(); k++) {
                    if (subseq.charAt(k) == subseq.charAt(k - 1)) {
                        valid = false;
                        break;
                    }
                }
                // 如果满足条件，将其加入集合
                if (valid) {
                    S.add(subseq);
                }
            }
        }

        // 返回集合的大小
        return S.size();
    }



}
