package com.huiaicharity.mapper;

import com.huiaicharity.entity.Activities;
import com.huiaicharity.entity.Children;
import com.huiaicharity.entity.Projects;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChildrenDao {
    public int countAll() {
        String sql = "SELECT COUNT(*) FROM children";
        Dao dao = new Dao();
        Children children = new Children();
        return dao.searchAll(sql);
    }
    public int deleteChildByCID(String cid){//删除
        String sql = "DELETE FROM children WHERE CID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, cid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public Children selectByCID(String cid) {
        String sql="select * from children WHERE CID='"+cid+"'";
        Children children=new Children();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                children.setCid(rs.getString("CID"));
                children.setName(rs.getString("NAME"));
                children.setSex(rs.getString("SEX"));
                children.setAge(rs.getInt("AGE"));
                children.setRegion(rs.getString("REGION"));
                children.setSituation(rs.getString("SITUATION"));
                children.setAfter_help(rs.getString("AFTER_HELP"));
                children.setTell(rs.getString("TELL"));
                children.setAid(rs.getString("AID"));
            }
            rs.close();
            dao.DBcloseStatement();
            return children;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Children> selectAll(){//全部获取
        String sql="select * from Children";
        ArrayList<Children> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while(rs.next()){
                Children children=new Children();
                children.setCid(rs.getString("CID"));
                children.setName(rs.getString("NAME"));
                children.setSex(rs.getString("SEX"));
                children.setAge(rs.getInt("AGE"));
                children.setRegion(rs.getString("REGION"));
                children.setSituation(rs.getString("SITUATION"));
                children.setAfter_help(rs.getString("AFTER_HELP"));
                children.setTell(rs.getString("TELL"));
                children.setAid(rs.getString("AID"));
                list.add(children);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    public int insertChildren(Children cd){
        String sql = "INSERT INTO children VALUES(?,?,?,?,?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, cd.getCid());
            pstmt.setString(2, cd.getName());
            pstmt.setObject(3, cd.getSex());
            pstmt.setInt(4, cd.getAge());
            pstmt.setString(5, cd.getRegion());
            pstmt.setString(6, cd.getSituation());
            pstmt.setString(7, cd.getAfter_help());
            pstmt.setString(8, cd.getTell());
            pstmt.setString(9, cd.getAid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }

    public int updateChild(Children children) {//更新
        String sql="UPDATE children SET NAME=?,SEX=?,AGE=?,REGION=?,SITUATION=?,AFTER_HELP=?,TELL=?,AID=? WHERE CID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, children.getName());
            pstmt.setObject(2, children.getSex());
            pstmt.setInt(3, children.getAge());
            pstmt.setString(4, children.getRegion());
            pstmt.setString(5, children.getSituation());
            pstmt.setString(6, children.getAfter_help());
            pstmt.setString(7, children.getTell());
            pstmt.setString(8, children.getAid());
            pstmt.setString(9, children.getCid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
