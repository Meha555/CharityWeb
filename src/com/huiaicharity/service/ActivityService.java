package com.huiaicharity.service;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.mapper.ActivitiesDao;

import java.util.ArrayList;

public class ActivityService {
    private ActivitiesDao activitiesDao=new ActivitiesDao();
    public int addActivities(String name, String address, String start_date,String end_date,String aid){
        Activities activities=new Activities();
        activities.setActid(activitiesDao.countAll()+1);
        activities.setName(name);
        activities.setAddress(address);
        activities.setStart_date(start_date);
        activities.setEnd_date(end_date);
        activities.setAid(aid);
        return activitiesDao.insertActivities(activities);
    }
    public int deleteActivities(int actid){
        return activitiesDao.deleteActivitiesByACTID(actid);
    }
    public ArrayList<Activities> showActivity(){
        return activitiesDao.selectAll();
    }
    public int editActivity(int actid,String name,String address,String start_time,String end_time) {
        Activities activities=activitiesDao.selectByACTID(actid);
        activities.setName(name);
        activities.setAddress(address);
        activities.setStart_date(start_time);
        activities.setEnd_date(end_time);
        return activitiesDao.updateActivities(activities);
    }
}
