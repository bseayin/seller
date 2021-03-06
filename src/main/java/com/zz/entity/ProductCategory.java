package com.zz.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data
@DynamicUpdate
public class ProductCategory {
    @Id
    private Integer categoryId;
    private Integer categoryType;
    private Date updateDate;
    /** 类目名字. */
    private String categoryName;

}
