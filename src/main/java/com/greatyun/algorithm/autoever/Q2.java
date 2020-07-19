package com.greatyun.algorithm.autoever;

import java.util.Stack;

/**
 * 문제 설명
 * 문자열을 압축하는 방법에는 여러 가지가 있습니다. 그중 한가지 방법은 다음과 같습니다.
 *
 * 주어진 문자열에서 S라는 문자열이 K 번 반복될 경우 이를 K(S)로 표현할 수 있습니다.
 * 예를 들어 문자열이 hihihi인 경우 3(hi)와 같이 표현할 수 있습니다. 또 문자열이 hihihicohihihico라면 2(3(hi)co)와 같이 표현할 수 있습니다.
 *
 * 압축된 문자열 compressed가 주어질 때, 원래 문자열을 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * compressed의 길이는 1 이상 100 이하입니다.
 * compressed는 숫자 '0'~'9', 괄호 '(', ')', 알파벳 소문자로만 이루어진 문자열입니다.
 * compressed는 알파벳 소문자로만 이루어진 문자열을 압축한 문자열입니다.
 * 따라서, compressed를 원래 문자열로 복원하면 알파벳 소문자로만 이루어진 문자열이 됩니다.
 * 항상 올바르게 압축된 문자열만 입력으로 주어집니다.
 * return 하는 원래 문자열의 길이는 1 이상 1,000 이하입니다.
 * 입출력 예
 * compressed	result
 * "3(hi)"	"hihihi"
 * "2(3(hi)co)"	"hihihicohihihico"
 * "10(p)"	"pppppppppp"
 * "2(2(hi)2(co))x2(bo)"	"hihicocohihicocoxbobo"
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 설명과 같습니다.
 *
 * 입출력 예 #2
 * 문제 설명과 같습니다.
 *
 * 입출력 예 #3
 * 원래 문자열은 p가 연속해서 10개 나오는 문자열입니다.
 *
 * 입출력 예 #4
 * "2(2(hi)2(co))x2(bo)" 의 원래 문자열은 "hihicocohihicocoxbobo"입니다.
 */
public class Q2 {

    class CompString {
        int count;
        String content;
    }

    public String sol(String compressed) {
        String ret = "";

        Stack<CompString> stack = new Stack<>();
        Stack<String> checkStack = new Stack<>();

        char[] chars = compressed.toCharArray();

        int index = 0;
        while(chars.length > index) {

            if(chars[index] == '(') {
                checkStack.push(String.valueOf(chars[index]));

                int tempIndex = index - 1;
                String tempString = "";
                while(tempIndex >= 0) {
                    if(Character.isDigit(chars[tempIndex])) {
                        tempString = String.valueOf(chars[tempIndex]) + tempString;
                        tempIndex--;
                    } else {
                        break;
                    }
                }
                int count = Integer.parseInt(tempString);

                System.out.println("## count -> " + count);

                index++;
                StringBuilder builder = new StringBuilder();
                while(!checkStack.isEmpty()) {
                    builder.append(String.valueOf(chars[index]));
                    if(chars[index] == ')') {
                        checkStack.pop();
                    } else if(chars[index] == '(') {
                        checkStack.push(String.valueOf(chars[index]));

                    } else {

                    }
                    index++;
                }
                CompString obj = new CompString();
                obj.count = count;
                obj.content = builder.toString();
                stack.push(obj);
            } else if(chars[index] == ')') {

            } else if(!Character.isDigit(chars[index])) {
                CompString obj = new CompString();
                obj.count = 1;
                obj.content = String.valueOf(chars[index]);
                stack.push(obj);
                index++;
            } else {
                index++;
            }

        }

        while (!stack.isEmpty()) {
            CompString pop = stack.pop();
            int count = pop.count;
            String content = pop.content;
            if(content.endsWith(")")) {
                content = content.substring(0 , content.length() - 1);
            }
            System.out.println(count + " , " + content);
            String tempResult = getContentInfo(content , count);
            System.out.println("## " + tempResult);
            ret = tempResult + ret;
        }
        System.out.println("!! ret [" + ret + "]");
        return ret;
    }

    private String getContentInfo(String content , int count) {
        String ret = "";
        if(content.contains(")")) {
            char[] contentArray = content.toCharArray();
            for (int i = 0; i < contentArray.length; i++) {
                if(contentArray[i] == '(') {
                    int innerCnt = Integer.parseInt(String.valueOf(contentArray[i-1]));
                    String str = "";
                    String subResult = "";
                    int innerIndex = i + 1;
                    while(innerIndex < contentArray.length) {
                        if(contentArray[innerIndex] == ')') {
                            break;
                        } else {
                            str += String.valueOf(contentArray[innerIndex]);
                        }
                        innerIndex++;
                    }
                    for (int j = 0; j < innerCnt; j++) {
                        subResult += str;
                    }
//                    ret = subResult + ret;
                    ret = ret + subResult;
                    i = innerIndex;
                } else if(!Character.isDigit(contentArray[i])) {
                    ret += String.valueOf(contentArray[i]);
                }
            }
            String sumStr = "";
            for (int i = 0; i < count; i++) {
                sumStr = sumStr + ret;
            }
            ret = sumStr;
        } else {
            for (int i = 0; i < count; i++) {
                ret = content + ret;
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        Q2 obj = new Q2();
//        String test = "2(3(hi)co)";
//        String test = "2(2(hi)2(co))x2(bo)";
        String test = "10(p)";
        obj.sol(test);

    }
}
