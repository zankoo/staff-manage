package cn.kokoda.demo.service;


import cn.kokoda.demo.mapper.BonusMapper;
import cn.kokoda.demo.pojo.Bonus;
import cn.kokoda.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {

    @Autowired
    BonusMapper bonusMapper;

    public List<Bonus> getAllBonus(int userId) {
        return bonusMapper.selectAllByUserId(userId);
    }

    public boolean addBonus(Bonus bonus) {
        return bonusMapper.insert(bonus) == 1;
    }

    public boolean editBonus(Bonus bonus) {
        return bonusMapper.updateByPrimaryKeySelective(bonus) == 1;
    }

    public boolean deleteBonus(int id) {
        return bonusMapper.deleteByPrimaryKey(id) == 1;
    }
}
