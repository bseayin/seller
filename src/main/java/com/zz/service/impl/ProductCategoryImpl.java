package com.zz.service.impl;

import com.zz.entity.ProductCategory;
import com.zz.repository.ProductCategoryRepository;
import com.zz.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductCategoryImpl implements ProductCategoryService {
    //把repository注入到service层
    //service引用了repository
    @Resource
    ProductCategoryRepository productCategoryRepository;
    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types) {
        return productCategoryRepository.findByCategoryTypeIn(types);
    }
}
