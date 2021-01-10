public class Solution {
    public boolean isAnagram(String s, String t) {
    //1 暴力法：直接将字符串转化为char类型数组，排序后比较两个数组是否相等
        //字符串长度不等，肯定不是异位词
        if(s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sout(a);
        Arrays.sour(b);
        return Arrays.equals(a,b);
    }
}
