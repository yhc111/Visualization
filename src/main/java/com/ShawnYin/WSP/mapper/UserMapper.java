package com.ShawnYin.WSP.mapper;

import com.ShawnYin.WSP.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserMapper {

    int getUserNum();

    User getUser(Map map);

    void userRegister(User user);

    User getUserByName(String username);

    int getDownloadPermission(int userID);

    /*
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
     */

}