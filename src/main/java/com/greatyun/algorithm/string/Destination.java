package com.greatyun.algorithm.string;

import java.util.ArrayList;
import java.util.List;

public class Destination {


    public String destCity(List<List<String>> paths) {
        String ret = "";

        int index = 0;
        boolean isRight = true;
        while(isRight) {
            isRight = false;
            List<String> strings = paths.get(index);
            String path = strings.get(1);
            for (int i = 0; i < paths.size(); i++) {
                List<String> list = paths.get(i);
                if(path.equals(list.get(0))) {
                    index = i;
                    isRight = true;
                    break;
                }
            }
            if(!isRight) {
                ret = path;
                return ret;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Destination obj = new Destination();
        List<List<String>> paths = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list.add("B");list.add("C");
        paths.add(list);

        list = new ArrayList<>();
        list.add("D");list.add("B");
        paths.add(list);

        list = new ArrayList<>();
        list.add("C");list.add("A");
        paths.add(list);

        System.out.println(obj.destCity(paths));

    }
}
