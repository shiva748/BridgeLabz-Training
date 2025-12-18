
public class squareroot {
    public static void main(String[] args) {
        int x = 8;
        Solution solution = new Solution();
        int result = solution.mySqrt(x);
        System.out.println(result);
    }
}

class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while(left <= right){
            int mid = (left+right)/2;
            long sqr = (long) mid*mid;
            if(sqr == x){
                return mid;
            }else if(sqr > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}