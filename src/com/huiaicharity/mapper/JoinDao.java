package com.huiaicharity.mapper;

import com.huiaicharity.entity.Join;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinDao {
    public int countAll() {
        String sql = "select COUNT(*) from join";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }

    public Join selectByID(String vid,String actid) {
        String sql = "select * from join WHERE VID='" + vid + "',ACTID='" + actid + "'";
        Join join = new Join();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                join.setVid(rs.getString("VID"));
                join.setActid(rs.getString("ACTID"));
                join.setDate(rs.getString("DATE"));
            }
            rs.close();
            dao.DBcloseStatement();
            return join;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertJoin(Join join) {//需要使用setDate，所以传入join，实现设置好时间
        String sql = "INSERT INTO join VALUES(?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, join.getVid());
            pstmt.setString(2, join.getActid());
            pstmt.setString(3, join.getDate());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
