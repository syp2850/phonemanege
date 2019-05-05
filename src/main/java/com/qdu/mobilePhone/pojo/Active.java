package com.qdu.mobilePhone.pojo;

/**
 * 销售活动类
 */
public class Active {

    private Integer Act_id; //活动ID
    private String Act_name; //活动名称
    private String Act_desc; //活动描述
    private String Act_img; //活动图片
    private String StartTime; //活动开始时间
    private String endTime; //活动截止时间
    private Integer Act_status; //活动状态

    public Integer getAct_status() {
        return Act_status;
    }

    public void setAct_status(Integer act_status) {
        Act_status = act_status;
    }

    public Integer getAct_id() {
        return Act_id;
    }

    public void setAct_id(Integer act_id) {
        Act_id = act_id;
    }

    public String getAct_name() {
        return Act_name;
    }

    public void setAct_name(String act_name) {
        Act_name = act_name;
    }

    public String getAct_desc() {
        return Act_desc;
    }

    public void setAct_desc(String act_desc) {
        Act_desc = act_desc;
    }

    public String getAct_img() {
        return Act_img;
    }

    public void setAct_img(String act_img) {
        Act_img = act_img;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

}
