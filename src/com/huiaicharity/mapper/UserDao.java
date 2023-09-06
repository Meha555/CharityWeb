package com.huiaicharity.mapper;

import java.sql.*;

import com.huiaicharity.entity.Projects;
import com.huiaicharity.entity.Users;
import com.huiaicharity.utils.Dao;

public class UserDao {//Model层
    /*public Users loginDao(String uid,String pwd){//登录SQL操作
        try {
            String sql="select * from users where UID=? and PWD=?";
            Dao dao=new Dao();
            Connection conn=dao.connect();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,uid);
            pstmt.setString(2,pwd);
            ResultSet rs=pstmt.executeQuery();
            //List<Users> userlist=new ArrayList<>();
            Users user=new Users();
            if(rs.next()){
                user.setUid(rs.getString("UID"));
                user.setPwd(rs.getString("PWD"));
                //userlist.add(user);
            }
            dao.DBclose();
            //return userlist;
            return user;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }*/
    public Users selectByUid(String uid){//UID是主键，只有一行查询结果
        Users user=new Users();
        try {
            String sql="select * from users where UID='"+uid+"'";
            Dao dao=new Dao();
            //ResultSet rs=dao.search(sql);
            ResultSet rs=dao.searchStatement(sql);
            if(rs.next()) {
                user.setUid(rs.getString("UID"));
                user.setName(rs.getString("NAME"));
                user.setPwd(rs.getString("PWD"));
                user.setSex(rs.getString("SEX"));
                user.setAge(rs.getInt("AGE"));
                user.setEmail(rs.getString("EMAIL"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setIs_volunteer(rs.getString("IS_VOLUNTEER"));
                user.setTell(rs.getString("TELL"));
                user.setIdentity(rs.getString("IDENTITY"));
                user.setAid(rs.getString("AID"));
            }
            dao.DBcloseStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return user;
    }
    public String addUser(Users user){
        int sum=0,temp=0,i=0,j;
        String id="";
        try {
            String sql1="SELECT UID FROM users ORDER BY UID DESC LIMIT 1";//获取注册前最后一条用户UID
            Dao dao=new Dao();
            //ResultSet rs=dao.search(sql);
            ResultSet rs1=dao.searchStatement(sql1);
            if(rs1.next()) {
                sum=Integer.parseInt(rs1.getString("UID"));
            }
            temp=sum;
            System.out.println("注册前最后一条用户UID:"+sum);
            sum++;
            if(sum==1) id="00001";
            else {
                temp = sum;
                while(temp<100000){
                    temp=temp*10;
                    i++;
                }
                i--;
                for (j = 1; j <= i; j++) {
                    id = id + "0";
                }
                id = id + sum + "";
            }
            System.out.println("生成的uid:"+id);
            //生成UID后开始插入
            String sql2="INSERT INTO users (UID, TELL, PWD) VALUES ('"+id+"', '"+user.getTell()+"', '"+user.getPwd()+"')";
            int count=dao.execute(sql2);
            System.out.println("受影响的行数:"+count);
            dao.DBcloseStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
    public int updateUser(Users user) {//更新
        String sql="UPDATE users SET NAME=?,SEX=?,AGE=?,EMAIL=?,ADDRESS=?,IS_VOLUNTEER=?,TELL=?,PWD=?,IDENTITY=? WHERE UID=?";
        int count=0;
        try {
            Dao dao=new Dao();
            PreparedStatement pstmt=dao.searchPreparedStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getSex());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getEmail());
            pstmt.setString(5, user.getAddress());
            pstmt.setString(6, user.getIs_volunteer());
            pstmt.setString(7, user.getTell());
            pstmt.setString(8, user.getPwd());
            pstmt.setString(9, user.getIdentity());
            pstmt.setString(10, user.getUid());
            count = pstmt.executeUpdate();
            pstmt.close();
            dao.DBclosePreparedStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return count;//受影响的行数
    }
}
