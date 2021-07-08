package com.ShawnYin.WSP.service;

import com.ShawnYin.WSP.entity.Emergency;
import com.ShawnYin.WSP.mapper.EmergencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyService {
    @Autowired
    EmergencyMapper emergencyMapper;

    public void addEvent(Emergency tempE)
    {
        emergencyMapper.insert(tempE);
    }

    public List<Emergency> getAll()
    {
        return emergencyMapper.selectAll();
    }
}
