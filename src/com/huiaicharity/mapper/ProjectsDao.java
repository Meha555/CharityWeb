package com.huiaicharity.mapper;

import com.huiaicharity.entity.News;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.utils.Dao;

import java.sql.*;
import java.util.ArrayList;
public class ProjectsDao {
    public int countAll() {
        String sql = "select COUNT(*) from projects";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }
    public Projects selectByPid(int pid){//按id查询
        String sql="select * from projects WHERE PID='"+pid+"'";
        Projects pj=new Projects();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                pj.setPid(rs.getInt(1));
                pj.setName(rs.getString(2));
                pj.setOrganizer(rs.getString(3));
                pj.setStart_date(rs.getString(4));
                pj.setEnd_date(rs.getString(5));
                pj.setAid(rs.getString(6));
            }
            rs.close();
            dao.DBcloseStatement();
            return pj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Projects> selectAll(){//全部获取
        String sql="select * from projects";

        ArrayList<Projects> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){Projects pj=new Projects();
                pj.setPid(rs.getInt(1));
                pj.setName(rs.getString(2));
                pj.setOrganizer(rs.getString(3));
                pj.setStart_date(rs.getString(4));
                pj.setEnd_date(rs.getString(5));
                pj.setAid(rs.getString(6));
                list.add(pj);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateProjects(Projects pj) {//更新
        String sql="UPDATE projects SET NAME=?,ORGANIZER=?,START_DATE=?,END_DATE=?,AID=? WHERE PID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, pj.getName());
            pstmt.setString(2, pj.getOrganizer());
            pstmt.setString(3, pj.getStart_date());
            pstmt.setString(4, pj.getEnd_date());
            pstmt.setString(5, pj.getAid());
            pstmt.setInt(6, pj.getPid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteProjectByPID(int pid){//删除
        String sql = "DELETE FROM projects WHERE PID=?";
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
    public int insertProject(Projects pj){
        String sql = "INSERT INTO projects VALUES(?,?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, pj.getPid());
            pstmt.setString(2, pj.getName());
            pstmt.setString(3, pj.getOrganizer());
            pstmt.setString(4, pj.getStart_date());
            pstmt.setString(5, pj.getEnd_date());
            pstmt.setString(6, pj.getAid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
