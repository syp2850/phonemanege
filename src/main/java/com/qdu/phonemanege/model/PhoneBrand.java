package com.qdu.phonemanege.model;

import com.qdu.phonemanege.configurer.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * @author songyunpeng
 * @decription  手机品牌表
 * @date 2019/4/9
 */
@Document(collection="PhoneBrand")
public class PhoneBrand  implements Serializable {

    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;
    private String bName;
    private String bIntro;
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

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbIntro() {
        return bIntro;
    }

    public void setbIntro(String bIntro) {
        this.bIntro = bIntro;
    }
}
