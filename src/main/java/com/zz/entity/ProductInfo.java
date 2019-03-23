package com.zz.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private String productIcon;
    //**0 表示正常， 1，表示下架
    private Integer productStatus;
    //**类目编号
    private Integer categoryType;
    private Date updateDate;

}
