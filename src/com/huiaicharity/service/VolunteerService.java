package com.huiaicharity.service;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Applications;
import com.huiaicharity.entity.Rewards;
import com.huiaicharity.entity.Volunteers;
import com.huiaicharity.mapper.ActivitiesDao;
import com.huiaicharity.mapper.ApplicationsDao;
import com.huiaicharity.mapper.RewardsDao;
import com.huiaicharity.mapper.VolunteersDao;

public class VolunteerService {
    private VolunteersDao volunteersDao = new VolunteersDao();

    public int ClockIn(String vid, int hours) {//志愿者打卡
        Volunteers volunteers = volunteersDao.selectByVid(vid);
        volunteers.setCredit(volunteers.getCredit() + 2 * hours);
        volunteers.setHours(volunteers.getHours() + hours);
        return volunteersDao.updateVolunteers(volunteers);
    }

    public int exchangeReward(String vid, int rid, int num) {//兑换奖品
        VolunteersDao volunteersDao = new VolunteersDao();
        RewardsDao rewardsDao = new RewardsDao();
        int result;
        Volunteers volunteers = volunteersDao.selectByVid(vid);
        Rewards rewards = rewardsDao.selectByRid(rid);
        int sum = rewards.getSum();
        int cost = rewards.getCost();
        if (volunteers.getCredit() >= (cost * num) && (sum >= num)) {
            result = num;
            rewards.setSum(rewards.getSum() - num * cost);
            rewardsDao.updateRewards(rewards);
            volunteers.setCredit(volunteers.getCredit() - num * cost);
            volunteersDao.updateVolunteers(volunteers);
        } else result = 0;
        return result;//兑换的数量
    }


}
