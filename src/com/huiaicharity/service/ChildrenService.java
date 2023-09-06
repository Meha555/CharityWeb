package com.huiaicharity.service;

import com.huiaicharity.entity.Children;
import com.huiaicharity.mapper.ChildrenDao;

import java.util.ArrayList;

public class ChildrenService {
    private ChildrenDao childrenDao=new ChildrenDao();
    public int addChildren(String cid, String name, String sex,int age,String region,String situation,String after_help,String tell,String aid){
        Children cd=new Children(cid,name,sex,age,region,situation,after_help,tell,aid);
        return childrenDao.insertChildren(cd);
    }
    public int deleteChild(String pid){
        return childrenDao.deleteChildByCID(pid);
    }
    public ArrayList<Children> getAll(){//展示学上信息，到时候操作list就行
        return childrenDao.selectAll();
    }
    public int editChild(String cid,String name,String sex,int age,String region,String situation,String after_help,String tell) {
        Children children=childrenDao.selectByCID(cid);
        children.setName(name);
        children.setSex(sex);
        children.setAge(age);
        children.setRegion(region);
        children.setSituation(situation);
        children.setAfter_help(after_help);
        children.setTell(tell);
        return childrenDao.updateChild(children);
    }
}
