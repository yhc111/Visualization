package com.ShawnYin.WSP.mapper;


import com.ShawnYin.WSP.entity.Server;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;



/**
 * @Author:DarenSu
 * @Date: 2021/04/21
 * @Time: 14:42
 */
@Mapper
@Repository
public interface ServerMapper {



    //2021 04 21 将设备信息存储到数据库中
    void addServer(Server service);

    //2021 04 21  获取最新的一条数据信息
    Server getServer();
    List<Server> getAllServer();


}
