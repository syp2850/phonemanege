package com.qdu.phonemanege.model;

import com.qdu.phonemanege.configurer.AutoIncKey;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @author songyunpeng
 * @decription 用户表
 * @date 2019/4/9
 */
@Document(collection="Users")
public class Users  implements Serializable {

    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;

    private String uName;
    private String uPwd;
    private String uQuestion;
    private String uAnswer;
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

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuQuestion() {
        return uQuestion;
    }

    public void setuQuestion(String uQuestion) {
        this.uQuestion = uQuestion;
    }

    public String getuAnswer() {
        return uAnswer;
    }

    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer;
    }
}
