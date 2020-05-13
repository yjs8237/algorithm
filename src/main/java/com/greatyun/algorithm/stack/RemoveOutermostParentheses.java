package com.greatyun.algorithm.stack;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        StringBuilder ret = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        if(S.length() == 0) return ret.toString();

        int thesesCount = 0;
        for (int i = 0; i < S.length(); i++) {
            char charAt = S.charAt(i);
            builder.append(charAt);
            if(charAt == '(') {
                thesesCount++;
            } else if(charAt == ')') {
                thesesCount--;
            }
            if(thesesCount == 0) {
                ret.append(builder.toString().substring(1 , builder.toString().length() - 1));
                builder = new StringBuilder();
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses obj = new RemoveOutermostParentheses();
        String str = "()()";
        System.out.println(obj.removeOuterParentheses(str));
    }
}
