package com.zz.util;

import com.zz.entity.ProductInfo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8Demo1 {


    public static void main(String[] args) {
        List<Integer> ls= Arrays.asList(10,5,6,7);
        List<ProductInfo> productInfos=new ArrayList<>();
//        for(Integer i:ls){
//            ProductInfo productInfo=new ProductInfo();
//            productInfo.setProductPrice(BigDecimal.valueOf(i));
//            productInfos.add(productInfo);
//        }
        ls.forEach(a->{
            ProductInfo productInfo=new ProductInfo();
            productInfo.setProductPrice(BigDecimal.valueOf(a));
            productInfos.add(productInfo);
        });

        productInfos.forEach(a-> System.out.println(a.getProductPrice()));
    }


}
