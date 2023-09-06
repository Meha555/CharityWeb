package com.huiaicharity.mapper;

import com.huiaicharity.entity.Exchange;
import com.huiaicharity.entity.Join;
import com.huiaicharity.entity.News;
import com.huiaicharity.utils.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExchangeDao {
    public int countAll() {
        String sql = "select COUNT(*) from exchange";
        Dao dao = new Dao();
        return dao.searchAll(sql);
    }

    public Exchange selectByID(String vid, String rid) {
        String sql = "select * from exchange WHERE VID='" + vid + "',rid='" + rid + "'";
        Exchange exchange = new Exchange();
        try {
            Dao dao = new Dao();
            ResultSet rs = dao.searchStatement(sql);
            while (rs.next()) {
                exchange.setVid(rs.getString("VID"));
                exchange.setRid(rs.getInt("RID"));
                exchange.setDate(rs.getString("DATE"));
            }
            rs.close();
            dao.DBcloseStatement();
            return exchange;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int insertExchange(Exchange exchange) {//需要使用setDate，所以传入exchange，实现设置好时间
        String sql = "INSERT INTO exchange VALUES(?,?,?)";
        int count = 0;
        try {
            Dao dao = new Dao();
            PreparedStatement pstmt = dao.searchPreparedStatement(sql);
            pstmt.setString(1, exchange.getVid());
            pstmt.setInt(2, exchange.getRid());
            pstmt.setString(3, exchange.getDate());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
    public ArrayList<Exchange> selectAll(){//全部获取
        String sql="select * from news";
        Exchange exchange = new Exchange();
        ArrayList<Exchange> list=new ArrayList<>();
        try{
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            while (rs.next()){
                exchange.setVid(rs.getString("VID"));
                exchange.setRid(rs.getInt("RID"));
                exchange.setDate(rs.getString("DATE"));
                list.add(exchange);
            }
            rs.close();
            dao.DBcloseStatement();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
