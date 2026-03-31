package org.learn;

public class Divide {
    public int divide(int a, int b){
        if(b == 0){
            throw new ArithmeticException("divisor cannot be zero");
        }
        return a/b;
    }
}
