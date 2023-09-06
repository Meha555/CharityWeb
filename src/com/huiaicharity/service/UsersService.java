package com.huiaicharity.service;

import com.huiaicharity.entity.Children;
import com.huiaicharity.entity.Exchange;
import com.huiaicharity.entity.Info;
import com.huiaicharity.entity.Users;
import com.huiaicharity.mapper.ChildrenDao;
import com.huiaicharity.mapper.ExchangeDao;
import com.huiaicharity.mapper.InfoDao;
import com.huiaicharity.mapper.UserDao;

import java.util.ArrayList;

public class UsersService {
    private ExchangeDao exchangeDao = new ExchangeDao();
    private InfoDao infoDao = new InfoDao();
    private UserDao userDao=new UserDao();

    public ArrayList<Exchange> getall() {
        ArrayList<Exchange> exchanges = exchangeDao.selectAll();
        return exchanges;
    }
    public int updateUserInfo(Users user){
        return userDao.updateUser(user);
    }
    public int zizhu(String cid, String uid, int num, String type) {
        Info info = new Info();
        info.setCid(cid);
        info.setUid(uid);
        info.setNum(num);
        info.setType(type);
        String aid="";
        info.setAid(aid);
        return infoDao.addInfo(info);
    }
    public Users selectUserByUID(String uid){
        return userDao.selectByUid(uid);
    }
}
