package com.ShawnYin.WSP.mapper;

import com.ShawnYin.WSP.entity.Task;
import com.ShawnYin.WSP.entity.User_task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface User_taskMapper {

    List<Task> selectAcceptTaskByUserID(Integer id);

    /*
    int deleteByPrimaryKey(Integer userTaskid);

    int insert(User_task record);

    int insertSelective(User_task record);

    User_task selectByPrimaryKey(Integer userTaskid);

    int updateByPrimaryKeySelective(User_task record);

    int updateByPrimaryKey(User_task record);
     */
}