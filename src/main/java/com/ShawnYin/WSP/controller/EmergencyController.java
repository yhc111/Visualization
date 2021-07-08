package com.ShawnYin.WSP.controller;

import com.ShawnYin.WSP.entity.Emergency;
import com.ShawnYin.WSP.mapper.EmergencyMapper;
import com.ShawnYin.WSP.service.EmergencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {
    @Autowired
    EmergencyService emergencyService;

    @RequestMapping("/addEvent")
    public void addEvent(@RequestBody Emergency tempE)
    {
//        System.out.println(tempE.getId());
//        System.out.println(tempE.getType());
//        System.out.println(tempE.getDate());
//        System.out.println(tempE.getTime());
        emergencyService.addEvent(tempE);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public Map<String, Object> getAll()
    {
        List<Emergency> emergencies= emergencyService.getAll();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("emergencies", emergencies);
        return map;
    }

}
