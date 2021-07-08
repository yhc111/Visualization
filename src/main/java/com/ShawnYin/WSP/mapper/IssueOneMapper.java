package com.ShawnYin.WSP.mapper;

import com.ShawnYin.WSP.entity.IssueOne;
import com.ShawnYin.WSP.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IssueOneMapper {

    //    public List<IssueOne> SelDeviceid(Integer deviceid) {
//    }

//    public List<IssueOne> SelDeviceid(Integer deviceid) {
//        return null;
//    }

//    public abstract
//
    //20201211   获取实时数据，不进行实时表中的更新操作
    IssueOne Sel(Integer deviceid);
    //20201212   获取实时数据，且在后端进行实时表中的更新操作
    IssueOne SelDeviceRealTime(Integer deviceid);

    //20201211   获取历史数据，由于数据太多，就只返回二十条
    List<IssueOne> SelDevicelist(Integer deviceid);

    //20201212   获取实时数据，且在后端进行实时表中的更新操作，此处为更新实时表的功能函数
    void insertDeviceRealTime(IssueOne issueOneTemp2);

    List<IssueOne> SelDeviceid(Integer deviceid);


}