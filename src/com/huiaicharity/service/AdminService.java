package com.huiaicharity.service;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Applications;
import com.huiaicharity.entity.Info;
import com.huiaicharity.entity.Volunteers;
import com.huiaicharity.mapper.*;

public class AdminService {
    private VolunteersDao volunteersDao = new VolunteersDao();
    private ChildrenDao childrenDao = new ChildrenDao();
    private UserDao userDao = new UserDao();
    private InfoDao infoDao = new InfoDao();
    private RewardsDao rewardsDao = new RewardsDao();
    private ActivitiesDao activitiesDao = new ActivitiesDao();
    private ApplicationsDao applicationsDao = new ApplicationsDao();

    /**
     * 对接模块，获取资助者uid和贫困儿童cid
     * info表、users表、children表
     *
     * @param uid
     * @param cid
     */
    public int storeZizhuMsg(String uid, String cid, int num, String type, String aid) {
        Info info = new Info(uid, cid, num, type, aid);
        return infoDao.addInfo(info);
    }

    public int deleteRewards(int rid) {
        return rewardsDao.deleteRewardsByRID(rid);
    }

    public int deleteVolunteer(String vid) {
        Volunteers volunteers = new Volunteers();
        return volunteersDao.deleteVolunteerByVID(vid);
    }

    /*public int addActivity(Activities activities) {
        return activitiesDao.insertActivities(activities);
    }*/
    public int agreeApplication(int appid,String aid) {
        return applicationsDao.updateApplications(appid,aid);
    }
    public int denyApplication(int appid) {
        return applicationsDao.deleteApplicationByAPPID(appid);
    }
}
