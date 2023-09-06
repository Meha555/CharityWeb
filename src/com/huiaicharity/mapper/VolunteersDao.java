package com.huiaicharity.mapper;

import com.huiaicharity.entity.Volunteers;
import com.huiaicharity.utils.Dao;

import java.sql.*;
import java.util.ArrayList;

public class VolunteersDao {
    public Volunteers selectByVid(String vid){
        String sql="select * from volunteers WHERE VID='"+vid+"'";
        Volunteers volunteers=new Volunteers();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                volunteers.setVid(rs.getString("VID"));
                volunteers.setName(rs.getString("NAME"));
                volunteers.setTell(rs.getString("TELL"));
                volunteers.setHours(rs.getInt("HOURS"));
                volunteers.setCredit(rs.getInt("CREDIT"));
                volunteers.setUid(rs.getString("UID"));
            }
            rs.close();
            dao.DBcloseStatement();
            return volunteers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Volunteers> selectAll(){
        String sql="select * from volunteers";
        Volunteers volunteers=new Volunteers();
        ArrayList<Volunteers> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                volunteers.setVid(rs.getString("VID"));
                volunteers.setName(rs.getString("NAME"));
                volunteers.setTell(rs.getString("TELL"));
                volunteers.setHours(rs.getInt("HOURS"));
                volunteers.setCredit(rs.getInt("CREDIT"));
                volunteers.setUid(rs.getString("UID"));
                list.add(volunteers);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateVolunteers(Volunteers volunteers) {
        String sql="UPDATE volunteers SET HOURS=?,CREDIT=? WHERE VID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setInt(1, volunteers.getHours());
            pstmt.setInt(2, volunteers.getCredit());
            pstmt.setString(3, volunteers.getVid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }

    public int deleteVolunteerByVID(String vid) {
        String sql = "DELETE FROM volunteers WHERE VID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, vid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
