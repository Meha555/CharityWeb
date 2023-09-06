package com.huiaicharity.service;

import com.huiaicharity.entity.Rewards;
import com.huiaicharity.mapper.RewardsDao;

import java.util.ArrayList;

public class RewardService {
    private RewardsDao rewardsDao = new RewardsDao();

    public int addRewards(String rname, int cost, int sum) {
        Rewards re = new Rewards();
        re.setRid(rewardsDao.countAll() + 1);
        re.setName(rname);
        re.setCost(cost);
        re.setSum(sum);
        return rewardsDao.insertRewards(re);
    }

    public int deleteRewards(int pid) {
        return rewardsDao.deleteRewardsByRID(pid);
    }
    public int editRewards(int rid,String name,int cost,int sum) {
        Rewards rewards=rewardsDao.selectByRid(rid);
        rewards.setCost(cost);
        rewards.setSum(sum);
        rewards.setName(name);
        return rewardsDao.updateRewards(rewards);
    }
    public ArrayList<Rewards> getAll(){//展示学上信息，到时候操作list就行
        return rewardsDao.selectAll();
    }
}
