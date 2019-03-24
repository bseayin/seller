package com.zz.service;

import com.zz.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> types);
}
