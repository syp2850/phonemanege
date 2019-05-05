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
@Document(collection="UserInfo")
public class UserInfo implements Serializable {
    @Id
    @AutoIncKey    // 注解说明该成员为自增ID
    @Field("_id")
    private long id;
    /*外键ID 连接用户登录表表ID*/
    private long uId;
    private String uGender;
    private String uProvince;
    private String uCity;
    private String uContact;
    private String uName;
    private String uAddress;
    private String uZipCode;
    private String uEmail;
    private String uIdentityType;
    private String uIdentityNumber;
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

    public String getuGender() {
        return uGender;
    }

    public void setuGender(String uGender) {
        this.uGender = uGender;
    }

    public String getuProvince() {
        return uProvince;
    }

    public void setuProvince(String uProvince) {
        this.uProvince = uProvince;
    }

    public String getuCity() {
        return uCity;
    }

    public void setuCity(String uCity) {
        this.uCity = uCity;
    }

    public String getuContact() {
        return uContact;
    }

    public void setuContact(String uContact) {
        this.uContact = uContact;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public String getuZipCode() {
        return uZipCode;
    }

    public void setuZipCode(String uZipCode) {
        this.uZipCode = uZipCode;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuIdentityType() {
        return uIdentityType;
    }

    public void setuIdentityType(String uIdentityType) {
        this.uIdentityType = uIdentityType;
    }

    public String getuIdentityNumber() {
        return uIdentityNumber;
    }

    public void setuIdentityNumber(String uIdentityNumber) {
        this.uIdentityNumber = uIdentityNumber;
    }
}
