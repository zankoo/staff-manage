package cn.kokoda.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import cn.kokoda.demo.pojo.Bonus;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BonusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bonus record);

    int insertSelective(Bonus record);

    Bonus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bonus record);

    int updateByPrimaryKey(Bonus record);

    List<Bonus> selectAllByUserId(@Param("userId")Integer userId);


}