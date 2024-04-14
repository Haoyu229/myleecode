import java.lang.reflect.Array;
import java.util.*;

public class daytwo {

//    8、和大于等于 target 的最短子数组  【连续子数组】
    public int minSubArrayLen(int target, int[] nums) {
        final int inf=1<<30;
        int ans=inf;//最短子数组长度
        int s=0;//子字符串之和
        for(int i=0,j=0;j<nums.length;++j){
            s+=nums[j];
            while(s>=target){//从i那边删除
                ans=Math.min(ans,j-i+1);
                s-=nums[i];
                i++;
            }
        }
        return ans==inf?0:ans;
    }

//9、    乘积小于 K 的子数组个数 双执政滑动窗口
public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        long mul=1;
        for(int i=0,j=0;j<nums.length;++j){
            mul*=nums[j];
//            if(mul<k){
//                ans++;
//            }
//            大于k,从做指针删除
            while(mul>=k && i<=j){
                mul/=nums[i++];
            }
            ans+=j-i+1;
        }
        return ans;
    }

//    10\和为 k 的子数组  连续子数组的个数,*****数组有正有负****
//    暴力枚举
    public int subarraySum(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j>=0;j--){
                sum+=nums[j];
                if(sum==k){
                    ans++;
                }
            }
        }
        return ans;
    }

//    前缀和法
    public int subarraySum2(int[] nums, int k) {
//     前缀数组
        int[] pre=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                pre[i]=nums[i];
            }
            pre[i]=pre[i-1]+nums[i];
        }
//     计算数量
        int ans=0;
        for(int i=0; i<pre.length;i++){
            if(pre[i]==k){
                ans++;
            }
            for(int j=i+1;j<pre.length;j++){
                if(pre[j]-pre[i]==k){
                    ans++;
                }
            }
        }
        return ans;
    }
//    用前缀和+哈希表,map里key是前缀和，value是出现次数
    public int subarraySum3(int[] nums, int k) {
        Map<Integer,Integer> cnt= new HashMap<>();
        cnt.put(0,1);
        int ans=0,sum=0;
        for(int x:nums){
            sum+=x;
//            是否存在和为k的前缀，没有的话返回0,k是个整体，找到一部分减去以后得到k
            ans+=cnt.getOrDefault(sum-k,0);
//            把长度为这个的加上，没有就为1，有就加和
            cnt.merge(sum,1,Integer::sum);
        }
        return ans;
    }
//    11、0 和 1 个数相同的最长子数组，返回长度
//    哈希表里存 key 和，v 第一次出现的位置，因为要返回长度
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> cnt=new HashMap<>();
        cnt.put(0,-1);
        int ans=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]==0?-1:1;
            if(cnt.containsKey(sum)) {
                ans = Math.max(ans, i - cnt.get(sum));
            }else{
                cnt.put(sum,i);
            }
        }
        return ans;
    }
//12\左右两边子数组的和相等,返回中心下标的位置
    public int pivotIndex(int[] nums) {
        int l=0,r=0;
        for(int i:nums){
            r+=i;
        }
        for(int i=0;i<nums.length;i++){
            r-=nums[i];
            if(l==r){
                return i;
            }
            l+=nums[i];
        }
        return -1;
    }

// 13、   二维子矩阵的和
//  14、 字符串中的变位词
public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();
        if(m>n){
            return false;
        }
        int[] cnt1=new int[26];
        int[] cnt2=new int[26];
        for(int i=0;i<m;i++){
            ++cnt1[s1.charAt(i)-'a'];
            ++cnt2[s2.charAt(i)-'a'];
        }
        if(Arrays.equals(cnt2,cnt2)){
            return true;
        }
        for(int i=m;i<n;i++){
            ++cnt2[s2.charAt(i)-'a'];
            --cnt2[s2.charAt(i-m)-'a'];
            if(Arrays.equals(cnt2,cnt2)){
                return true;
            }
        }
        return false;
}

//    15\字符串中的所有变位词
    public List<Integer> findAnagrams(String s, String p) {
            int m=s.length();
            int n=p.length();
            List<Integer> ans=new ArrayList<>();
            if(m<n){
                return ans;
            }
            int[] cnt1=new int[26];
            int[] cnt2=new int[26];
            for(int i=0;i<n;i++){
                ++cnt1[s.charAt(i)-'a'];
                ++cnt2[p.charAt(i)-'a'];
            }
            if(Arrays.equals(cnt1,cnt2)){
                ans.add(0);
            }
            for(int i=n;i<m;i++){
                ++cnt2[s.charAt(i)-'a'];
                --cnt2[s.charAt(i-n)-'a'];
                if(Arrays.equals(cnt1,cnt2)){
                    ans.add(i-n+1);
                }
            }
            return ans;

    }
}
