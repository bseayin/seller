package com.zz.controller;

import com.zz.entity.ProductCategory;
import com.zz.entity.ProductInfo;
import com.zz.service.ProductCategoryService;
import com.zz.service.ProductInfoService;
import com.zz.vo.ProductInfoVO;
import com.zz.vo.ProductVO;
import com.zz.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Resource
    ProductInfoService productInfoService;
    //把service注入到Control层
    //或者说 control层引用了service层
    @Resource
    ProductCategoryService productCategoryService;

    @RequestMapping("tt")
    public String init(){
        return "hello";
    }

    @RequestMapping("upAll")
    public List<ProductInfo> showProducts(){
        return productInfoService.getUpAll();
    }
    @GetMapping("/list")
    public ResultVO list(){
        ResultVO resultVO=new ResultVO();
        List<ProductInfo> productInfoList=productInfoService.getUpAll();
//        List<Integer> categoryType=new ArrayList<Integer>();
//        for(ProductInfo productInfo:productInfoList){
//            categoryType.add(productInfo.getCategoryType());
//        }
//        for(int i=0;i<productInfoList.size();i++){
//            categoryType.add(productInfoList.get(i).getCategoryType());
//        }

//精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categorylist= productCategoryService.findByCategoryTypeIn(categoryTypeList);
        //data[]
        List<ProductVO> productVOList=new ArrayList<>();
        categorylist.forEach(c->{
            ProductVO productVO=new ProductVO();
            //name
            productVO.setCategoryName(c.getCategoryName());
            //type
            productVO.setCategoryType(c.getCategoryType());
            //foods
            List<ProductInfoVO> productInfoVOList=new ArrayList<>();
            productInfoList.forEach(p->{
                if(c.getCategoryType().equals(p.getCategoryType())){
                    ProductInfoVO productInfoVO=new ProductInfoVO();
                    BeanUtils.copyProperties(p,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            });
            //set foods
            productVO.setProductInfoVOList(productInfoVOList);
            //给[]添加了一个记录
            productVOList.add(productVO);
        });

        resultVO.setData(productVOList);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return  resultVO;
    }


}
