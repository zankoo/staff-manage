package cn.kokoda.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.kokoda.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByUsernameAndPassword(@Param("username")String username,@Param("password")String password);


}