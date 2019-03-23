package com.zz.service.impl;

import com.zz.entity.ProductInfo;
import com.zz.repository.ProductInfoRepository;
import com.zz.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
   @Resource
    ProductInfoRepository productInfoRepository;
    @Override
    public List<ProductInfo> getUpAll() {
        return productInfoRepository.findByProductStatus(0);
    }
}
