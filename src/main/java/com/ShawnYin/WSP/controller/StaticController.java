package com.ShawnYin.WSP.controller;

import com.ShawnYin.WSP.entity.IssueOneReal;
import com.ShawnYin.WSP.service.IssueOneRealServer;
import com.ShawnYin.WSP.service.IssueOneServer;
import com.ShawnYin.WSP.serviceImpl.UserServiceImpl;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

@Controller
public class StaticController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    private IssueOneServer issueOneServer;
    @Autowired
    private IssueOneRealServer issueOneRealServer;

    @RequestMapping("/mytasks")
    public String mytasks(){
        return "mytasks";
    }

    @RequestMapping("/task_data")
    public String task_data(){
        return "task_data";
    }

    @RequestMapping("/visualization")
    public String visualization(){
        return "visualization";
    }

    @RequestMapping("/NoPermission")
    public String noPer(){
        return "NoPermission";
    }

    @RequestMapping("/algorithmResult")
    public String alRe(){
        return "charts";
    }

    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }

    @RequestMapping("/newHeader")
    public String newHeader(){
        return "newHeader";
    }

    @RequestMapping("/visualization2")
    public String visualization2(){
        return "visualization2";
    }

    @RequestMapping("/Public")
    public String Public(){
        return "public";
    }

    @RequestMapping("/dayanta")
    public String dayanta(){
        return "dayanta";
    }

    @RequestMapping("/xiaozhaiTotal")
    public String xiaozhaiTotal(){
        return "xiaozhaiTotal";
    }

    @RequestMapping("/dayantaPublicSafe")
    public String dayantaPublicSafe(){
        return "dayantaPublicSafe";
    }
    @RequestMapping("/dayantaTotal")
    public String dayantaTotal(){
        return "dayantaTotal";
    }
    @RequestMapping("/dayantarealVideo")
    public String dayantarealVideo(){
        return "dayantarealVideo";
    }


    @RequestMapping("/robot")
    public String robot(){
        return "robot";
    }

    @RequestMapping("/xiaozhaitest")
    public String xiaozhaitest(){
        return "xiaozhaitest";
    }

    @RequestMapping("/yanxingmen")
    public String yanxingmen(){
        return "yanxingmen";
    }

    @RequestMapping("/xinjiamiao02")
    public String xinjiamiao02(){
        return "xinjiamiao02";
    }

    @RequestMapping("/qinglongsi")
    public String qinglongsi(){
        return "qinglongsi";
    }

    @RequestMapping("/beichitou")
    public String beichitou(){
        return "beichitou";
    }

    @RequestMapping("/xiaozhai")
    public String xiaozhai(){
        return "xiaozhai";
    }

    @RequestMapping("/xiaozhaiPublicSafe")
    public String xiaozhaiPublicSafe(){
        return "xiaozhaiPublicSafe";
    }
    @RequestMapping("/xiaozhairealVideo")
    public String xiaozhairealVideo(){
        return "xiaozhairealVideo";
    }



    @ResponseBody
    @RequestMapping(value = "/currentData", method = RequestMethod.POST)
    public Map<String, Object> currentData(@RequestBody JSONObject jsonParam){
        Map<String, Object> map = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.00");
        Iterator it = jsonParam.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
            map.put(entry.getKey(), entry.getValue());
        }
        if (map.get("dataType").equals("temperature")){
            Map<String, Object> temperature = new HashMap<>();
            List<IssueOneReal> issueOneRealsList = issueOneRealServer.SelAll();
            int deviceID = -1;
            int ID_format = -1;
            double deviceTemp = 0.0;
            for (int i = 0; i <issueOneRealsList.size(); i++){
                IssueOneReal issueOneRealelement = issueOneRealsList.get(i);
                deviceID = issueOneRealelement.getDeviceid();
                ID_format = deviceID%10000000;
                deviceTemp = issueOneRealelement.getTemperature();
                temperature.put("temperature0" + Integer.toString(ID_format), deviceTemp/100);
            }
            temperature.put("sensorNum", issueOneRealsList.size());
            return temperature;
        } else if (map.get("dataType").equals("humidity")){
            Map<String, Object> humidity = new HashMap<>();
            List<IssueOneReal> issueOneRealsList = issueOneRealServer.SelAll();
            int deviceID = -1;
            int ID_format = -1;
            double deviceHumi = 0.0;
            for (int i = 0; i <issueOneRealsList.size(); i++){
                IssueOneReal issueOneRealelement = issueOneRealsList.get(i);
                deviceID = issueOneRealelement.getDeviceid();
                ID_format = deviceID%10000000;
                deviceHumi = issueOneRealelement.getHumidity();
                humidity.put("humidity0" + Integer.toString(ID_format), deviceHumi/1000);
            }
            humidity.put("sensorNum", issueOneRealsList.size());
            return humidity;
        } else if (map.get("dataType").equals("pressure")){
            Map<String, Object> pressure = new HashMap<>();
            List<IssueOneReal> issueOneRealsList = issueOneRealServer.SelAll();
            int deviceID = -1;
            int ID_format = -1;
            double devicePress = 0.0;
            for (int i = 0; i <issueOneRealsList.size(); i++){
                IssueOneReal issueOneRealelement = issueOneRealsList.get(i);
                deviceID = issueOneRealelement.getDeviceid();
                ID_format = deviceID%10000000;
                devicePress = issueOneRealelement.getPressure();
                pressure.put("pressure0" + Integer.toString(ID_format), devicePress/100);
            }
            pressure.put("sensorNum", issueOneRealsList.size());
            return pressure;
        } else if (map.get("dataType").equals("electricity")){
            Map<String, Object> electricity = new HashMap<>();
            List<IssueOneReal> issueOneRealsList = issueOneRealServer.SelAll();
            int deviceID = 0;
            int ID_format = -1;
            double deviceElec = 0.0;
            double deviceVolt = 0.0;
            for (int i = 0; i <issueOneRealsList.size(); i++){
                IssueOneReal issueOneRealelement = issueOneRealsList.get(i);
                List<Double> resultList = new ArrayList<>();
                deviceID = issueOneRealelement.getDeviceid();
                ID_format = deviceID%10000000;
                deviceElec = issueOneRealelement.getPercent();
                deviceVolt = issueOneRealelement.getVoltage();
                resultList.add(deviceElec);
                resultList.add(deviceVolt);
                electricity.put("electric0" + Integer.toString(ID_format), resultList);
            }
            electricity.put("sensorNum", issueOneRealsList.size());
            return electricity;
        } else {
            return null;
        }
    }

    @RequestMapping("/taskListstest")
    public String taskListstest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookies
        Cookie[] cs = request.getCookies();
        String username = "",password = "";
        //获取数据，遍历cookies
        if(cs != null){
            for(Cookie c : cs){
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("userName")){
                    username = value;
                }else if(name.equals("userPassword")){
                    password = value;
                }
            }
            //String userPassword = SHA.getSHA256StrJava(password);
            int result = userService.getUser(username,password);
            if(result != 0) {
                return "taskListstest";
            }else {
                response.sendRedirect("http://localhost:8080/login");
            }
        }else {
            response.sendRedirect("http://localhost:8080/login");
        }
        return "taskListstest";
    }

    @RequestMapping("/")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cs = request.getCookies();
        if(cs != null){
            for (Cookie c : cs){
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cs = request.getCookies();
        if(cs != null){
            for (Cookie c : cs){
                c.setMaxAge(0);
                response.addCookie(c);
            }
        }
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register(HttpServletRequest request, HttpServletResponse response){
        return "register";
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookies
        Cookie[] cs = request.getCookies();
        String username = "",password = "";
        //获取数据，遍历cookies
        if(cs != null){
            for(Cookie c : cs){
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("userName")){
                    username = value;
                }else if(name.equals("userPassword")){
                    password = value;
                }
            }
            //String userPassword = SHA.getSHA256StrJava(password);
            int result = userService.getUser(username,password);
            if(result != 0) {
                return "index";
            }else {
                response.sendRedirect("http://localhost:8080/login");
            }
        }else{
            response.sendRedirect("http://localhost:8080/login");
        }
        return "index";
    }

    @RequestMapping("/taskLists")
    public String taskLists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取cookies
        Cookie[] cs = request.getCookies();
        String username = "",password = "";
        //获取数据，遍历cookies
        if(cs != null){
            for(Cookie c : cs){
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("userName")){
                    username = value;
                }else if(name.equals("userPassword")){
                    password = value;
                }
            }
            //String userPassword = SHA.getSHA256StrJava(password);
            int result = userService.getUser(username,password);
            if(result != 0) {
                return "taskLists";
            }else {
                response.sendRedirect("http://localhost:8080/login");
            }
        }else {
            response.sendRedirect("http://localhost:8080/login");
        }
        return "taskLists";
    }

    @RequestMapping("/map")
    public String map(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取cookies
        Cookie[] cs = request.getCookies();
        //获取数据，遍历cookies
        if(cs != null){
            for(Cookie c : cs){
                String name = c.getName();
                String value = c.getValue();
            }
            return "map";
        }else {
            response.sendRedirect("http://localhost:8080/login");
        }
        return "map";
    }

    @RequestMapping("/docs")
    public String docs(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取cookies
        Cookie[] cs = request.getCookies();
        String username = "",password = "";
        //获取数据，遍历cookies
        if(cs != null){
            for(Cookie c : cs){
                String name = c.getName();
                String value = c.getValue();
                if (name.equals("userName")){
                    username = value;
                }else if(name.equals("userPassword")){
                    password = value;
                }
            }
            //String userPassword = SHA.getSHA256StrJava(password);
            int result = userService.getUser(username,password);
            if(result != 0) {
                return "docs";
            }else {
                response.sendRedirect("http://localhost:8080/login");
            }
        }else {
            response.sendRedirect("http://localhost:8080/login");
        }
        return "docs";
    }

    /*
     * 获取download页面
     */
    @RequestMapping("/download")
    public String download(){
        return "download";
    }


    /*
     * 获取file.html页面
     */
    @RequestMapping("/file")
    public String file(){
        return "file";
    }

    /*
     * 获取multifile.html页面
     */
    @RequestMapping("/multifile")
    public String multifile(){
        return "multifile";
    }

}
