package com.zz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参考文档： https://www.jdon.com/idea/java/10-example-of-lambda-expressions-in-java8.html
 */
public class Java8Lam {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(234);
        list.add(11);
        list.add(666);
        list.add(999);
        list.add("hello");
//        for(Object a:list){
//            //System.out.println里面的参数，会默认的
//            //调用参数的toString();
//            System.out.println(a);
//        }
        //java 8的方式
        list.forEach(a->System.out.println(a));


        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//        for (Integer cost : costBeforeTax) {
//            double price = cost + .12*cost;
//            System.out.println(price);
//        }

// 使用lambda表达式
//        List costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
//          costBeforeTax.forEach(a->System.out.println(a+a*0.12));
        //stream()把集合转成了流
        //map(方法)， 把流里面的每个元素都执行一些
        //map里面的方法，转换了一下。
        //collect(Collectors.toList()) 把转换以后的元素
        //收集起来放到一个新的list里面

         List ls=costBeforeTax.stream().map((cost) -> cost + 0.12*cost).collect(Collectors.toList());
        //遍历集合costBeforeTax，并且打印里面的元素
        ls.forEach(a->System.out.println("集合里面的值是："+a));

//        costBeforeTax.stream().map((cost) -> cost + .12*cost);


//        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }
}
