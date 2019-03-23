package com.zz.controller;

import com.zz.entity.ProductInfo;
import com.zz.service.ProductInfoService;
import com.zz.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Resource
    ProductInfoService productInfoService;

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
        List<Integer> categoryType=new ArrayList<Integer>();
//        for(ProductInfo productInfo:productInfoList){
//            categoryType.add(productInfo.getCategoryType());
//        }
        for(int i=0;i<productInfoList.size();i++){
            categoryType.add(productInfoList.get(i).getCategoryType());
        }

        resultVO.setData(categoryType);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return  resultVO;
    }


}
