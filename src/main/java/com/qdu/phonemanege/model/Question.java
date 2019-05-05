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
@Document(collection="Question")
public class Question implements Serializable {
    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;
    private String qContent;
    private String qType;
    private String qAnswer;
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

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String getqType() {
        return qType;
    }

    public void setqType(String qType) {
        this.qType = qType;
    }

    public String getqAnswer() {
        return qAnswer;
    }

    public void setqAnswer(String qAnswer) {
        this.qAnswer = qAnswer;
    }
}
