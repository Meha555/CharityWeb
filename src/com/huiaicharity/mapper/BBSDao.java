package com.huiaicharity.mapper;

import com.huiaicharity.entity.BBS;
import com.huiaicharity.entity.Children;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BBSDao {
    public int countAll() {
        String sql = "select COUNT(*) from bbs";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }
    public BBS selectByBid(int bid) {
        String sql = "select * from bbs WHERE BID='" + bid + "'";
        BBS bbs = new BBS();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                bbs.setBid(rs.getInt("BID"));
                bbs.setTitle(rs.getString("TITLE"));
                bbs.setTime(rs.getString("TIME"));
                bbs.setAuthor(rs.getString("AUTHOR"));
                bbs.setContent(rs.getString("CONTENT"));
            }
            rs.close();
            dao.DBcloseStatement();
            return bbs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int insertBBS(BBS bbs) {
        String sql = "INSERT INTO bbs VALUES(?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, bbs.getBid());
            pstmt.setString(2, bbs.getTitle());
            pstmt.setString(3, bbs.getTime());
            pstmt.setString(4, bbs.getAuthor());
            pstmt.setString(5, bbs.getContent());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    /*public int updateBBS(BBS bbs) {
        String sql = "UPDATE volunteers SET BID=?,TITLE=?,TIME=?,AUTHOR=?,CONTENT=? WHERE BID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, bbs.getBid());
            pstmt.setString(2, bbs.getTitle());
            pstmt.setString(3, bbs.getTime());
            pstmt.setString(4, bbs.getAuthor());
            pstmt.setString(5, bbs.getContent());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }*/
    public ArrayList<BBS> selectAll(){//全部获取
        String sql="select * from bbs";

        ArrayList<BBS> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while(rs.next()){
                BBS bbs=new BBS();
                bbs.setBid(rs.getInt("BID"));
                bbs.setTitle(rs.getString("TITLE"));
                bbs.setTime(rs.getString("TIME"));
                bbs.setAuthor(rs.getString("AUTHOR"));
                bbs.setContent(rs.getString("CONTENT"));
                list.add(bbs);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
