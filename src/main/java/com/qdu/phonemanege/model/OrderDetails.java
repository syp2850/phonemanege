package com.qdu.phonemanege.model;

import com.qdu.phonemanege.configurer.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author songyunpeng
 * @decription
 * @date 2019/4/9
 */
@Document(collection="OrderDetails")
public class OrderDetails implements Serializable {
    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;
    private String ProductID;
    private String OrderedQty;
    private String delStatus;

    public String getDelStatus() {
        return delStatus;
    }

    public void setDelStatus(String delStatus) {
        this.delStatus = delStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public String getOrderedQty() {
        return OrderedQty;
    }

    public void setOrderedQty(String orderedQty) {
        OrderedQty = orderedQty;
    }
}
