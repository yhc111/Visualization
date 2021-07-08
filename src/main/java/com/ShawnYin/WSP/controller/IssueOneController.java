package com.ShawnYin.WSP.controller;

import com.ShawnYin.WSP.entity.IssueOne;
import com.ShawnYin.WSP.entity.IssueOneReal;
import com.ShawnYin.WSP.service.IssueOneRealServer;
import com.ShawnYin.WSP.service.IssueOneServer;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.*;


@RestController      //进行模块的注明，此处为控制模块
@RequestMapping("/issueOne")


public class IssueOneController {

    @Autowired
    private IssueOneServer issueOneServer;
    @Autowired
    private IssueOneRealServer issueOneRealServer;


    private Object setuser1;

//    @RequestMapping("getDeviceMessageALL/{deviceid}")
//    public List<IssueOne> GetUserInfo(@PathVariable Integer deviceid) {
//        //return userService.SelInfo(userName).toString();
//        System.out.println(deviceid);
//        System.out.println(issueOneServer.SelDeviceid(deviceid));
//
//        return issueOneServer.SelDeviceid(deviceid);
//    }
    //20201211  根据deviceid，返回该id对应的最新的设备感知信息     ------->>>>实时数据，不进行实时表的更新操作
    //url:http://127.0.0.1:8080/issueOne/getDeviceMessage/deviceid
    //其中，web传入的参数是deviceid，返回的数据是一条issueOne类型的数据（也就是一条整个subtask1_online数据）



    @RequestMapping("getDeviceMessage/{deviceid}")
    public ResponseEntity<IssueOne> GetDeviceMessage(@PathVariable Integer deviceid) {

        if (deviceid != 10000001 && deviceid != 10000002 && deviceid != 10000003){
            return new ResponseEntity<IssueOne>(HttpStatus.NOT_FOUND);
        }
        IssueOne issueOne = issueOneServer.SelDevice(deviceid);
        System.out.println("1");
        System.out.println(issueOne);
        return new ResponseEntity<IssueOne>(issueOne, HttpStatus.OK);
    }

    //20201211  根据deviceid，返回该id对应的最新的设备感知信息     ------->>>>实时数据，不进行实时表的更新操作
    //url:http://127.0.0.1:8080/issueOne/getDeviceMessage/deviceid
    //其中，web传入的参数是deviceid，返回的数据是一条issueOne类型的数据（也就是一条整个subtask1_online数据）
    @RequestMapping("getDeviceMessageReal/{deviceid}")
    public ResponseEntity<IssueOne> GetDeviceMessageReal(@PathVariable Integer deviceid) {

        if (deviceid != 10000001 && deviceid != 10000002 && deviceid != 10000003 && deviceid!=0 ){
            return new ResponseEntity<IssueOne>(HttpStatus.NOT_FOUND);
        }
        IssueOne issueOne = issueOneServer.SelDeviceRealTime(deviceid);
        System.out.println("1");
        System.out.println(issueOne);
        return new ResponseEntity<IssueOne>(issueOne, HttpStatus.OK);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity<IssueOne> add(/*@RequestBody*/ IssueOne issueOne){
        issueOneServer.add(issueOne);
        return new ResponseEntity<>(issueOne,HttpStatus.OK);
    }


    //20201211  根据deviceid，返回该id对应的最新的二十条历史的设备感知信息     ------->>>>历史数据
    //url:http://127.0.0.1:8080/issueOne/getDeviceMessageALL/deviceid
    //其中，web传入的参数是deviceid，返回的数据是二十条issueOne类型的数据（也就是二十条整个subtask1数据）
    @RequestMapping("getDeviceMessageAll/{deviceid}")
    public ResponseEntity<List<IssueOne>> GetDeviceMessageAll(@PathVariable Integer deviceid) {

        if (deviceid != 10000001 && deviceid != 10000002 && deviceid != 10000003){
            return new ResponseEntity<List<IssueOne>>(HttpStatus.NOT_FOUND);
        }
        List<IssueOne> issueOne = issueOneServer.SelDevicelist(deviceid);
        System.out.println("1");
        System.out.println(issueOne);
        return new ResponseEntity<List<IssueOne>>(issueOne,HttpStatus.OK);
    }

    //20201213  厚淳--->>实时数据获取接口
//    @ResponseBody
//    @RequestMapping(value = "/currentData", method = RequestMethod.POST)
//    public Map<String, Object> currentData(@RequestBody JSONObject jsonParam){
//        Map<String, Object> map = new HashMap<>();
//        DecimalFormat df = new DecimalFormat("#.00");
//        Iterator it = jsonParam.entrySet().iterator();
//        while (it.hasNext()){
//            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
//            map.put(entry.getKey(), entry.getValue());
//        }
//        if (map.get("dataType").equals("temperature")){
//            Map<String, Object> temperature = new HashMap<>();
//            Random r = new Random();
//            double ranTemp = Double.parseDouble(df.format(r.nextDouble()*3 + 24));
//            //所有最新的传感器感知数据 List
//            List<IssueOneReal> issueOneRealsList = issueOneRealServer.SelAll();
//
//            temperature.put("temperature", ranTemp);
//            return temperature;
//        } else if (map.get("dataType").equals("humidity")){
//            Map<String, Object> humidity = new HashMap<>();
//            Random r = new Random();
//            double ranHumi = Double.parseDouble(df.format(r.nextDouble()*20 + 50));
//            humidity.put("humidity", ranHumi);
//            return humidity;
//        } else {
//            return null;
//        }
//    }




}
