package com.huiaicharity.mapper;
import com.huiaicharity.entity.Info;
import com.huiaicharity.entity.Rewards;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class InfoDao {
    public int addInfo(Info info){
        String sql="INSERT INTO info VALUES(?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, info.getUid());System.out.println("*1");
            pstmt.setString(2, info.getCid());System.out.println("*2");
            pstmt.setInt(3, info.getNum());System.out.println("*3");
            pstmt.setObject(4, info.getType());System.out.println("*4");
            pstmt.setString(5, info.getAid());System.out.println("*5");
            System.out.println(info.getUid());
            System.out.println(info.getCid());
            System.out.println(info.getNum());
            System.out.println(info.getType());
            System.out.println(info.getAid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public ArrayList<Info> selectAll(){//全部获取
        String sql="select * from info";
        Info info=new Info();
        ArrayList<Info> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while(rs.next()){
                info.setUid(rs.getString(1));
                info.setCid(rs.getString(2));
                info.setNum(rs.getInt(3));
                info.setType(rs.getString(4));
                info.setAid(rs.getString(5));
                list.add(info);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int updateInfo(String aid) {//更新
        String sql="UPDATE info SET AID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, aid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteOneInfo(Info info){
        String sql = "DELETE FROM info WHERE UID=?,CID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, info.getUid());
            pstmt.setString(2, info.getCid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
