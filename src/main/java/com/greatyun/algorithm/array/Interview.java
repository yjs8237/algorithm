package com.greatyun.algorithm.array;

import java.util.*;

public class Interview {

    static class Product {
        String name;
        Float price;
        public  Product(String name , Float price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return this.name;
        }
        public Float getPrice() {
            return this.price;
        }
    }

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Write your code here
        Map<String , Product> map = new HashMap<>();
        int ret = 0;
        for (int i = 0; i < products.size(); i++) {
            String prdtName = products.get(i);
            Float price = productPrices.get(i);
            Product product = new Product(prdtName , price);
            map.put(prdtName , product);
        }

        for (int i = 0; i < productSold.size(); i++) {
            String soldProduct = productSold.get(i);
            Product product = map.get(soldProduct);
            Float basePrice = product.getPrice();
            Float price = soldPrice.get(i);
            System.out.println(basePrice + " , " + price);
            if(Float.compare(price , basePrice) != 0 ) {
                ret++;
            }
        }
        return ret;
    }

    public static String decodeString(int numberOfRows, String encodedString) {
        // Write your code here

        if(encodedString == null || encodedString.isEmpty()) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int col = encodedString.length() / numberOfRows;

        int index = encodedString.length();
        String [][] strArr = new String[numberOfRows][col];

        for (int i = strArr.length-1 ; i >= 0; i--) {
            for (int j = strArr[0].length-1; j >= 0; j--) {
                String substring = encodedString.substring(index - 1, index);
                strArr[i][j] = substring;
                index--;
            }
        }

        int rowIndex = 0;
        int colIndex = 0;
        int prevColIndex = colIndex;
        while (prevColIndex < strArr[0].length) {
//            System.out.print(strArr[rowIndex][colIndex] + " ");
            if(strArr[rowIndex][colIndex].equals("_")) {
                builder.append(" ");
            } else {
                builder.append(strArr[rowIndex][colIndex]);
            }
            rowIndex++;
            colIndex++;


            if(rowIndex >= strArr.length) {
                rowIndex = 0;
                colIndex = prevColIndex + 1;
                prevColIndex++;
            }
            if(colIndex >= strArr[0].length) {
                break;
            }
        }
        return builder.toString().trim();
    }


    public static void main(String[] args) {
        System.out.println();
        System.out.println(Interview.decodeString(3 , "mnes__ya_____mi"));
        String temp = "hlowrd_el_ol";





        List<String> products = Arrays.asList("a" , "b" , "c");
        List<Float> productPrices = new ArrayList<>();
        productPrices.add((float) 15);
        productPrices.add((float) 300.90);
        productPrices.add((float) 23.44);
        List<String> productSold = Arrays.asList("b" , "c" , "a");
        List<Float> soldPrice = new ArrayList<>();
        soldPrice.add((float) 300.90);
        soldPrice.add((float) 23.44);
        soldPrice.add((float) 10);
//        System.out.println(Interview.priceCheck(products , productPrices , productSold , soldPrice));
    }
}
