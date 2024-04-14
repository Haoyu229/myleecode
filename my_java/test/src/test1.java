import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://github.com/doocs/leetcode
public class test1 {
    public int divide(int a, int b) {
        if (b == 1) {
            return a;
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (a > 0 && b > 0) || (a < 0 && b < 0);
        a = a > 0 ? -a : a;
        b = b > 0 ? -b : b;
        int ans = 0;
        while (a <= b) {
            int x = b;
            int cnt = 1;
            while (x >= (Integer.MIN_VALUE >> 1) && a <= (x << 1)) {
                x <<= 1;
                cnt <<= 1;
            }
            ans += cnt;
            a -= x;
        }
        return sign ? ans : -ans;
    }

//    二进制加法
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
//       carry 记录当前的进位
        for (int carry = 0; i >= 0 || j >= 0 || carry > 0; --i, --j) {
            carry += (i >= 0 ? a.charAt(i) - '0' : 0) + (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

//  3、  前 n 个数字二进制中 1 的个数
//    动态规划：i & (i - 1)二进制表示中的最低位的1变成0之后的数
    public int[] countBits(int n) {
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
//            int x=i & (i - 1);
            f[i] = f[i & (i - 1)] + 1;//状态转化方程
        }
        return f;
    }

//    4\只出现一次的数字
//    统计所有数字中每个位上出现的1的个数，然后对3取模

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int x : nums) {
                int a=x >> i;
                int b=a&1;
//                cnt += x >> i & 1;
                cnt +=b;
            }
            cnt %= 3;
            ans |= cnt << i;
        }
        return ans;
    }

    //5\单词长度的最大乘积
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                //            定义一个独热编码
                mask[i] |= 1 << (c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((mask[i] & mask[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
}
//6、排序数组中两个数字之和
//    （一）二分查找：对于每个num，可以通过二分查找的方式找到target-num
    public int[] twoSum(int[] numbers,int target){
        for(int i=0,n=numbers.length;;++i){
            int x=target-numbers[i];
//            二分查找,只需要找i之后的
            int l=i+1,r=n-1;
            while(l<r){
                int mid=(l+r)/2;
                if(numbers[mid]==x){
                    return new int[]{i,mid};
                }
                else if(numbers[mid]>=x){
                    r=mid;
                }else{
                    l=mid+1;
                }


            }
//            if(numbers[l]==x){
//                return new int[]{i,l};
//            }
        }
    }
//    (二)双指针：指针指首尾加和移动
    public int[] twoSum2(int[] numbers,int target){
        for (int i=0,j=numbers.length-1;;){
            int x=numbers[i]+numbers[j];
            if(x== target){
                return new int[]{i,j};
            }
            else if(x>target){
                --j;
            }else{++i;}
        }
    }

//7 数组中和为 0 的三个数，先排序再双指针
//    public List<List<Integer>> threeSum(int[] nums){
//        Arrays.sort(nums);
//        List<List<Integer>> ans=new ArrayList<>();
//        int n=nums.length;
//        for(int i=0;i<n-2&&nums[i]<=0;i++){
//            if(i>0&&nums[i]==nums[i-1]){//去掉重复的
//                continue;
//            }
//            int j=i+1,k=n-1;
//            while(j<k){
//                int x=nums[i]+nums[j]+nums[k];
//                if(x<0){
//                    ++j;
//                }else if(x>0){
//                    --k;
//                }else{
//                    ans.add(List.of(nums[i],nums[j++],nums[k--]));
//                    while(j<k&&nums[j]==num[j-1]){
//                        ++j;
//                    }
//                    while(j<k&&nums[k]==nums[k+1]) {
//                        --k;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
}

