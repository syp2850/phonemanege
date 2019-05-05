package com.qdu.phonemanege.model;

import com.qdu.phonemanege.configurer.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author songyunpeng
 * @decription 手机信息表
 * @date 2019/4/9
 */
@Document(collection="Phones")
public class Phones  implements Serializable {
    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;
    private String pName;
    private String pPrice;
    private String pNum;
    /* 这里应该存储文件的oID信息 数组  后续再改*/
    private String pImagePath;
    private long pCategoryId;
    private String pColor;
    private String pConfig;
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

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpPrice() {
        return pPrice;
    }

    public void setpPrice(String pPrice) {
        this.pPrice = pPrice;
    }

    public String getpNum() {
        return pNum;
    }

    public void setpNum(String pNum) {
        this.pNum = pNum;
    }

    public String getpImagePath() {
        return pImagePath;
    }

    public void setpImagePath(String pImagePath) {
        this.pImagePath = pImagePath;
    }

    public long getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(long pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public String getpColor() {
        return pColor;
    }

    public void setpColor(String pColor) {
        this.pColor = pColor;
    }

    public String getpConfig() {
        return pConfig;
    }

    public void setpConfig(String pConfig) {
        this.pConfig = pConfig;
    }
}
