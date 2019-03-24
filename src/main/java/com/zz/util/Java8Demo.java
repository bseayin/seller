package com.zz.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Demo {
    public static void main(String[] args) {
        List<Integer> ls= Arrays.asList(10,5,6,7);
        //stream方法定义在Collection接口上
        List<Integer> ls1=ls.stream().map(aa->aa*3).collect(Collectors.toList());
        ls1.forEach(yy-> System.out.println(yy));
    }
}
