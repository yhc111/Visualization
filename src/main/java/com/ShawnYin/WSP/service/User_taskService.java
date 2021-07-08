package com.ShawnYin.WSP.service;

import com.ShawnYin.WSP.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_taskService {

    List<Task> selectAcceptTaskByUserID(Integer id);
}
