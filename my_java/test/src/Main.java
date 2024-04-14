import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        test1 t=new test1();
//        System.out.println(t.divide(3,1));
//        System.out.println("hello world");
//        System.out.println(Integer.MIN_VALUE);

        //2|    二进制加法
//        t.addBinary("1010","1011");
//        System.out.println(t.addBinary("1010","1011"));

        //  3、  前 n 个数字二进制中 1 的个数
//        System.out.println(t.countBits(5));

        //    4\只出现一次的数字
//        int[] i={2,2,3,2};
//        System.out.println(t.singleNumber(i));
        //5\单词长度的最大乘积
//        String[] words={"abcw","baz","foo","bar","fxyz","abcdef"};
//        System.out.println(t.maxProduct(words));
        //6、排序数组中两个数字之和
//        System.out.println(t.twoSum(new int[]{1,2,4,6,10},8));
//        for(int i:t.twoSum2(new int[]{1,2,4,6,10},8)){
//            System.out.println(i);
//
//        }
//        //7 数组中和为 0 的三个数，先排序再双指针
//        for(List i:t.threeSum(new int[]{-1,0,1,2,-1,-4})){
//            System.out.println(i);
//        }


//        meituan xiaomei=new meituan();
//        String x = "12121";
//
//        // 计算集合的大小
//        int result = xiaomei.findDistinctSubsequences(x);
//
//        // 输出结果
//        System.out.println("集合的大小: " + result);


        daytwo dayt = new daytwo();
//        8、和大于等于 target 的最短子数组  【连续子数组】
//        System.out.println(dayt.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        //9、    乘积小于 K 的子数组个数 双执政滑动窗口
//        System.out.println(dayt.numSubarrayProductLessThanK( new int[]{10,5,2,6},100));

//learn map
//        Map<String, Integer> map1 = new HashMap<>();
//        map1.put("a",1);
//        map1.put("b",2);
//        map1.put("c",3);
//        System.out.println(map1);
//        //key不存在等于是map1.put(key, value),后面的处理失效。
//        map1.merge("d",4,(v1,v2)->v2+100);
//        //如果存在就会变成你处理后的value值
//        map1.merge("a",100,(v1,v2)->v1-v2);
//        System.out.println(map1);
//        map1.merge("c",6,Integer::sum);
//        map1.merge("a",4,(v1,v2)->null);
//        System.out.println(map1);

//    11、0 和 1 个数相同的最长子数组，返回长度
//        System.out.println(dayt.findMaxLength(new int[]{0,1,0,1,1}));

//12\左右两边子数组的和相等
        System.out.println(dayt.pivotIndex(new int[]{2, 1, -1}));


    }
}
