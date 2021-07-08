package com.ShawnYin.WSP.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
public class IssueOne {
//    private Integer issueOneId;                 //ID
//
//    private String Site_server;
//    //振动、声波、磁场、摩擦，以及光、热能源等6种环境获能
//    //温度、湿度和压力3种环境参数感
//    private String temperature_sensor;//温度
//    private Integer temperature;
//    private String humidity_sensor;//湿度
//    private Integer humidity;
//    private String pressure_sensor;//压力
//    private Integer pressure;

    private Long id;
    private Integer tasktype;//任务类型
    private Integer deviceid;//设备号
    private Integer temperature;//温度
    private Integer humidity;//湿度
    private Integer pressure;//压力
    private Integer percent;//电量百分比
    private Integer voltage;//电压

    @JsonFormat(pattern = "yyyy.MM.dd")
    private Date uploadtime; //发布日期

    public IssueOne() {
        super();
    }

    public IssueOne(Long id, Integer tasktype, Integer deviceid, Integer temperature, Integer humidity, Integer pressure, Integer percent, Integer voltage, Date uploadtime) {
        this.id = id;
        this.tasktype = tasktype;
        this.deviceid = deviceid;
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.percent = percent;
        this.voltage = voltage;
        this.uploadtime = uploadtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTasktype() {
        return tasktype;
    }

    public void setTasktype(Integer tasktype) {
        this.tasktype = tasktype;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    @Override
    public String toString() {
        return "IssueOne{" +
                "id=" + id +
                ", tasktype=" + tasktype +
                ", deviceid=" + deviceid +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", percent=" + percent +
                ", voltage=" + voltage +
                ", uploadtime=" + uploadtime +
                '}';
    }
}
