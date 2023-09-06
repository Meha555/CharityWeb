package com.huiaicharity.mapper;

import com.huiaicharity.entity.Exchange;
import com.huiaicharity.entity.News;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class NewsDao {
    public int countAll(){//统计新闻总行数
        String sql="SELECT COUNT(*) FROM news";
        Dao dao=new Dao();
        return dao.searchAll(sql);
    }
    public int insertNews(News news){
        String sql = "INSERT INTO news VALUES(?,?,?,?,?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, news.getNid());
            pstmt.setString(2, news.getTitle());
            pstmt.setString(3, news.getContent());
            pstmt.setString(4, news.getAuthor());
            pstmt.setString(5, news.getTime());
            pstmt.setString(6, news.getAid());
            pstmt.setString(7, news.getMedia());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public int deleteNewsByNID(int nid){
        String sql = "DELETE FROM news WHERE NID=?";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setInt(1, nid);
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public ArrayList<News> selectAll(){//全部获取
        String sql="select * from news";
        ArrayList<News> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                News n=new News();
                n.setNid(rs.getInt(1));
                n.setTitle(rs.getString(2));
                n.setContent(rs.getString(3));
                n.setAuthor(rs.getString(4));
                n.setTime(rs.getString(5));
                n.setAid(rs.getString(6));
                n.setMedia(rs.getString(7));
                list.add(n);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public News selectByNID(int nid) {
        String sql = "select * from news WHERE NID='" + nid+"'";
        News news = new News();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                news.setNid(rs.getInt("NID"));
                news.setTitle(rs.getString("TITLE"));
                news.setContent(rs.getString("CONTENT"));
                news.setAuthor(rs.getString("AUTHOR"));
                news.setTime(rs.getString("TIME"));
                news.setAid(rs.getString("AID"));
                news.setMedia(rs.getString("MEDIA"));
            }
            rs.close();
            dao.DBcloseStatement();
            return news;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
