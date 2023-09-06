package com.huiaicharity.mapper;

import com.huiaicharity.entity.Rewards;
import com.huiaicharity.entity.Volunteers;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RewardsDao {
    public int countAll() {
        String sql = "select COUNT(*) from rewards";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }
    public Rewards selectByRid(int rid){//按id查询
        String sql="select * from rewards WHERE RID='"+rid+"'";
        Rewards re=new Rewards();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                re.setRid(rs.getInt(1));
                re.setName(rs.getString(2));
                re.setCost(rs.getInt(3));
                re.setSum(rs.getInt(4));
            }
            rs.close();
            dao.DBcloseStatement();
            return re;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Rewards> selectAll(){//全部获取
        String sql="select * from rewards";
        ArrayList<Rewards> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                Rewards re=new Rewards();
                re.setRid(rs.getInt(1));
                re.setName(rs.getString(2));
                re.setCost(rs.getInt(3));
                re.setSum(rs.getInt(4));
                list.add(re);
            }
            rs.close();
            dao.DBcloseStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return list;
    }
    public int updateRewards(Rewards re) {//更新
        String sql="UPDATE rewards SET NAME=?,COST=?,SUM=? WHERE RID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, re.getName());
            pstmt.setInt(2, re.getCost());
            pstmt.setInt(3, re.getSum());
            pstmt.setInt(4, re.getRid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteRewardsByRID(int Rid){//删除
        String sql = "DELETE FROM rewards WHERE RID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, Rid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int insertRewards(Rewards re){
        String sql = "INSERT INTO rewards VALUES(?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, re.getRid());
            pstmt.setString(2, re.getName());
            pstmt.setInt(3, re.getCost());
            pstmt.setInt(4, re.getSum());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
