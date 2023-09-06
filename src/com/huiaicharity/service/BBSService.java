package com.huiaicharity.service;


import com.huiaicharity.entity.BBS;
import com.huiaicharity.mapper.BBSDao;

import java.util.ArrayList;

public class BBSService {
    private BBSDao bbsDao = new BBSDao();

    public int sendTiezi(String title, String author, String content) {
        BBS bbs = new BBS();
        bbs.setBid(bbsDao.countAll() + 1);
        bbs.setTime();
        bbs.setTitle(title);
        bbs.setAuthor(author);
        bbs.setContent(content);
        return bbsDao.insertBBS(bbs);
    }
    public ArrayList<BBS> getAll(){//展示学上信息，到时候操作list就行
        return bbsDao.selectAll();
    }

}
