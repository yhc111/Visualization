package com.ShawnYin.WSP.mapper;

import com.ShawnYin.WSP.entity.Emergency;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmergencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emergency record);

    int insertSelective(Emergency record);

    Emergency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Emergency record);

    int updateByPrimaryKey(Emergency record);

    List<Emergency> selectAll();
}