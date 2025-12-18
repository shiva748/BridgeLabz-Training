import java.util.Stack;

public class validparentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";
        boolean result = solution.isValid(s);
        System.out.println("Is the parentheses valid? " + result);
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack <Character> brak = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);
            if('{' == cur || '[' == cur || '(' == cur){
                brak.add(cur);
            }else if(!brak.isEmpty() && cur == '}' && brak.peek() == '{'){
                brak.pop();
            }else if(!brak.isEmpty() && cur == ']' && brak.peek() == '['){
                brak.pop();
            }else if(!brak.isEmpty() && cur == ')' && brak.peek() == '('){
                brak.pop();
            }else{
                return false;
            }
        }
        return brak.isEmpty();
    }
}