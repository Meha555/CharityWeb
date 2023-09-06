package com.huiaicharity.service;

import com.huiaicharity.entity.Applications;
import com.huiaicharity.mapper.ApplicationsDao;

import java.util.ArrayList;

public class ApplyService {
    private ApplicationsDao applicationsDao=new ApplicationsDao();
    public int insertApplication(String uid,String content){
        Applications applications=new Applications();
        applications.setAppid(applicationsDao.countAll() + 1);
        applications.setTime();
        applications.setUid(uid);
        applications.setContent(content);
        return applicationsDao.insertApplications(applications);
    }
    public ArrayList<Applications> getAll(){
        return applicationsDao.selectAllWithAIDisNull();
    }
}
