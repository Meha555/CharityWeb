package com.huiaicharity.service;

import com.huiaicharity.entity.Administrators;
import com.huiaicharity.entity.Users;
import com.huiaicharity.entity.vo.MsgModel;
import com.huiaicharity.mapper.AdminDao;
import com.huiaicharity.mapper.UserDao;
import com.huiaicharity.utils.ToolsUtil;

public class LoginService {//Model层
    public MsgModel userLogin(String uid,String pwd){
        MsgModel mm=new MsgModel();
        Users user=new Users();
        user.setUid(uid);
        user.setPwd(pwd);
        mm.setObject(user);
       /* if(ToolsUtil.isEmpty(uid)|| ToolsUtil.isEmpty(pwd)){
            mm.setCode(false);
            mm.setMsg("输入信息不能为空");
            return mm;
        }*/
        UserDao ud=new UserDao();
        Users u=ud.selectByUid(uid);
        if(u.getUid()==null){
            mm.setCode(false);
            mm.setMsg("用户不存在");
            return mm;
        }
        else if(!(pwd.equals(u.getPwd()))){
            mm.setCode(false);
            mm.setMsg("密码不正确");
            return mm;
        }
        else{
            mm.setCode(true);
            mm.setMsg("登陆成功");
            return mm;
        }
    }
    public MsgModel adminLogin(String aid,String pwd){
        MsgModel mm=new MsgModel();
        Administrators admin=new Administrators();
        admin.setAid(aid);
        admin.setPwd(pwd);
        mm.setObject(admin);
        if(ToolsUtil.isEmpty(aid)|| ToolsUtil.isEmpty(pwd)){
            mm.setCode(false);
            mm.setMsg("输入信息不能为空");
            return mm;
        }
        AdminDao ad=new AdminDao();
        Administrators a=ad.selectByAid(aid);
        if(a.getAid()==null){
            mm.setCode(false);
            mm.setMsg("管理员不存在");
            return mm;
        }
        else if(!(pwd.equals(a.getPwd()))){
            mm.setCode(false);
            mm.setMsg("密码不正确");
            return mm;
        }
        else{
            mm.setCode(true);
            mm.setMsg("登陆成功");
            return mm;
        }
    }
}
