package com.huiaicharity.mapper;

import com.huiaicharity.entity.Applications;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationsDao {
    public int countAll() {
        String sql = "select COUNT(*) from applications";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }
    public ArrayList<Applications> selectAllWithAIDisNull() {
        String sql = "select * from applications WHERE AID IS NULL";
        ArrayList<Applications> list=new ArrayList<>();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                Applications applications = new Applications();
                applications.setAppid(rs.getInt("APPID"));
                applications.setUid(rs.getString("UID"));
                applications.setTime(rs.getString("TIME"));
                applications.setContent(rs.getString("CONTENT"));
                applications.setAid(rs.getString("AID"));
                list.add(applications);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Applications selectByAppid(int appid) {
        String sql = "select * from applications WHERE APPID='" + appid + "'";
        Applications applications = new Applications();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                applications.setAppid(rs.getInt("APPID"));
                applications.setUid(rs.getString("UID"));
                applications.setTime(rs.getString("TIME"));
                applications.setContent(rs.getString("CONTENT"));
                applications.setAid(rs.getString("AID"));
            }
            rs.close();
            dao.DBcloseStatement();
            return applications;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int insertApplications(Applications applications) {
        String sql = "INSERT INTO applications VALUES(?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, applications.getAppid());
            pstmt.setString(2, applications.getUid());
            pstmt.setString(3, applications.getTime());
            pstmt.setString(4, applications.getContent());
            pstmt.setString(5, applications.getAid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int updateApplications(int appid,String aid) {
        String sql = "UPDATE applications SET AID=? WHERE APPID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, aid);
            pstmt.setInt(2, appid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteApplicationByAPPID(int appid){//删除
        String sql = "DELETE FROM applications WHERE APPID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, appid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
