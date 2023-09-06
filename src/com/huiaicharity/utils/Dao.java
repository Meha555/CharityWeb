package com.huiaicharity.utils;

import java.sql.*;
public class Dao {//每次创建的Dao对象有conn和stmt在各个函数里共用
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    public Connection connect(){//数据库连接
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/charity?useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf-8&useUnicode=true";
            String username = "root";
            String pwd = "mysql123";
            conn = DriverManager.getConnection(url, username, pwd);
        } catch (ClassNotFoundException | SQLException e){
            System.out.println(e.toString());
        }
        return conn;
    }
    public int execute(String sql) {//增删改操作
        int count=0;
        try {
            connect();
            stmt = conn.createStatement();
            count=stmt.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return count;
    }
    public ResultSet searchStatement(String sql){//查询操作，返回结果集rs，需要手动next遍历，因为每张表的属性不一样
        ResultSet rs = null;
        try {
            connect();
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return rs;
    }
    public int searchAll(String sql){//查询所有行数
        ResultSet rs = null;
        int count=0;
        try {
            connect();
            stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()) count=rs.getInt(1);
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return count;
    }
    public PreparedStatement searchPreparedStatement(String sql){//返回PreparedStatement，需要手动查询，因为每张表的属性不一样
        try {
            connect();
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return pstmt;
    }
    public void DBcloseStatement(){
        try {
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    public void DBclosePreparedStatement(){
        try {
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    //以下写法是在发现空指针异常后采取的笨方法，虽然避免了空指针异常，但是由于要对rs进行操作，无法释放数据库操作对象和连接对象
    /*public int execute(String sql) {//增删改操作
        int count=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/charity?useSSL=false&serverTimezone=GMT%2B8";
            String username = "root";
            String pwd = "mysql123";
            Connection conn = DriverManager.getConnection(url, username, pwd);
            Statement stmt = conn.createStatement();
            count=stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.toString());
        }
        return count;
    }
    public ResultSet search(String sql){//查询操作，返回结果集rs，需要手动next遍历，因为每张表的属性不一样
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/charity";
            String username = "root";
            String pwd = "mysql123";
            Connection conn = DriverManager.getConnection(url, username, pwd);
            Statement stmt = conn.createStatement();
            rs=stmt.executeQuery(sql);
            //stmt.close();
            //conn.close();

        } catch (SQLException | ClassNotFoundException e){
            System.out.println(e.toString());
        }
        return rs;
    }*/
}