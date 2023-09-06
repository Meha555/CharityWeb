package com.huiaicharity.service;

import com.huiaicharity.entity.Administrators;
import com.huiaicharity.entity.Users;
import com.huiaicharity.entity.vo.MsgModel;
import com.huiaicharity.mapper.AdminDao;
import com.huiaicharity.mapper.UserDao;

public class RegisterService {
    public MsgModel userReg(String utell,String upwd){//用户注册输电话和密码
        MsgModel mm=new MsgModel();
        Users user=new Users();
        user.setPwd(upwd);
        user.setTell(utell);
        UserDao ud=new UserDao();
        String uid=ud.addUser(user);
        user.setUid(uid);
        mm.setCode(true);
        mm.setObject(user);
        mm.setMsg("用户注册成功");
        return mm;
    }
    public MsgModel adminReg(String aname,String apwd){//管理员注册输姓名和密码
        MsgModel mm=new MsgModel();
        Administrators admin=new Administrators();
        admin.setName(aname);
        admin.setPwd(apwd);
        AdminDao ad=new AdminDao();
        String aid=ad.addAdmin(admin);
        admin.setAid(aid);
        mm.setCode(true);
        mm.setObject(admin);
        mm.setMsg("管理员注册成功");
        return mm;
    }

}
