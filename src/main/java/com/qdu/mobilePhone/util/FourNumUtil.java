package com.qdu.mobilePhone.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FourNumUtil {

    /**
     * 随机四位数字
     * @return  生成账号
     */
    public String CreateAccount() {
        String num = "";
        Random random = new Random();
        for(int i = 0;i < 4;i ++){
            num += random.nextInt(10);
        }
        return num;
    }

}
