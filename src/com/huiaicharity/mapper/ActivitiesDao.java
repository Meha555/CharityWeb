package com.huiaicharity.mapper;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ActivitiesDao {
    public int countAll() {
        String sql = "select COUNT(*) from activities";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }
    public Activities selectByACTID(int actid){//按id查询
        String sql="select * from activities WHERE ACTID='"+actid+"'";
        Activities activities=new Activities();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                activities.setActid(rs.getInt(1));
                activities.setName(rs.getString(2));
                activities.setAddress(rs.getString(3));
                activities.setStart_date(rs.getString(4));
                activities.setEnd_date(rs.getString(5));
                activities.setAid(rs.getString(6));
            }
            rs.close();
            dao.DBcloseStatement();
            return activities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Activities> selectAll(){//全部获取
        String sql="select * from activities";

        ArrayList<Activities> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){Activities activities=new Activities();
                activities.setActid(rs.getInt(1));
                activities.setName(rs.getString(2));
                activities.setAddress(rs.getString(3));
                activities.setStart_date(rs.getString(4));
                activities.setEnd_date(rs.getString(5));
                activities.setAid(rs.getString(6));
                list.add(activities);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateActivities(Activities activities) {//更新
        String sql="UPDATE activities SET NAME=?,ADDRESS=?,START_DATE=?,END_DATE=?,AID=? WHERE ACTID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, activities.getName());
            pstmt.setString(2, activities.getAddress());
            pstmt.setString(3, activities.getStart_date());
            pstmt.setString(4, activities.getEnd_date());
            pstmt.setString(5, activities.getAid());
            pstmt.setInt(6, activities.getActid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteActivitiesByACTID(int pid){//删除
        String sql = "DELETE FROM activities WHERE ACTID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, pid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int insertActivities(Activities activities){
        String sql = "INSERT INTO activities VALUES(?,?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, activities.getActid());
            pstmt.setString(2, activities.getName());
            pstmt.setString(3, activities.getAddress());
            pstmt.setString(4, activities.getStart_date());
            pstmt.setString(5, activities.getEnd_date());
            pstmt.setString(6, activities.getAid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
