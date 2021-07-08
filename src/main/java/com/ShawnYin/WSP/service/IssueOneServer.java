package com.ShawnYin.WSP.service;

import com.ShawnYin.WSP.entity.IssueOne;
import com.ShawnYin.WSP.entity.IssueOneReal;
import com.ShawnYin.WSP.mapper.IssueOneMapper;
import com.ShawnYin.WSP.mapper.IssueOneRealMapper;
import com.ShawnYin.WSP.utils.CopyClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IssueOneServer {

    @Autowired
    IssueOneMapper issueOneMapper;

    @Autowired
    IssueOneRealMapper issueOneRealMapper;

    //20201211   获取实时数据，不进行实时表中的更新操作
    public IssueOne SelDevice(Integer deviceid) {
        return issueOneMapper.Sel(deviceid);
    }
    //20201212   获取实时数据，且在后端进行实时表中的更新操作
    public IssueOne SelDeviceRealTime(Integer deviceid) {
        IssueOne issueOneTemp = issueOneMapper.SelDeviceRealTime(deviceid);
        //20201212   获取实时数据，且在后端进行实时表中的更新操作，此处为更新实时表的功能函数
        if(issueOneTemp == null)
        {
            List<IssueOne> issueOnesTemp = issueOneMapper.SelDevicelist(deviceid);
            System.out.println("List长度："+issueOnesTemp.size());
            IssueOne issueOneTemp2 = issueOnesTemp.get(issueOnesTemp.size()-1);
            IssueOneReal issueOneRealTemp2 = new IssueOneReal();
            issueOneRealTemp2 = CopyClass.copyOneToOnereal(issueOneRealTemp2, issueOneTemp2);
            issueOneRealMapper.insertDeviceRealTime(issueOneRealTemp2);
            return issueOneTemp2;
        }

        System.out.println("此处是IssueOneServer的SelDeviceRealTime：" + issueOneTemp);

        return issueOneMapper.SelDeviceRealTime(deviceid);
    }

    public void add(IssueOne issueOne) {issueOneMapper.insertDeviceRealTime(issueOne);}


    //20201211   获取历史数据，由于数据太多，就只返回二十条
    public List<IssueOne> SelDevicelist(Integer deviceid) {
        return issueOneMapper.SelDevicelist(deviceid);
    }



//    public abstract List<IssueOne> SelDeviceid(Integer deviceid);


}
