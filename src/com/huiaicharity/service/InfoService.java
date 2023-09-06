package com.huiaicharity.service;

        import com.huiaicharity.entity.Applications;
        import com.huiaicharity.entity.Info;
        import com.huiaicharity.mapper.InfoDao;

        import java.util.ArrayList;

public class InfoService {
    private InfoDao infoDao=new InfoDao();
    public ArrayList<Info> getAll(){//展示学上信息，到时候操作list就行
        return infoDao.selectAll();
    }
    public int agreeInfo(String aid) {
        return infoDao.updateInfo(aid);
    }
    public int denyInfo(Info info) {
        return infoDao.deleteOneInfo(info);
    }
}

