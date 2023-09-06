package com.huiaicharity.mapper;

import com.huiaicharity.entity.Administrators;
import com.huiaicharity.utils.Dao;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
    public Administrators selectByAid(String aid){//AID是主键，只有一行查询结果
        Administrators admin=new Administrators();
        try {
            String sql="select * from administrators where AID='"+aid+"'";
            Dao dao=new Dao();
            ResultSet rs=dao.searchStatement(sql);
            if(rs.next()) {
                admin.setAid(rs.getString("AID"));
                admin.setName(rs.getString("NAME"));
                admin.setPwd(rs.getString("PWD"));
            }
            dao.DBcloseStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return admin;
    }
    public String addAdmin(Administrators admin){//跟用户一样生成AID
        int sum=0,temp=0,i=0,j;
        String id="";
        try {
            String sql1="SELECT AID FROM administrators ORDER BY AID DESC LIMIT 1";
            Dao dao=new Dao();
            //ResultSet rs=dao.search(sql);
            ResultSet rs1=dao.searchStatement(sql1);
            if(rs1.next()) {
                sum=Integer.parseInt(rs1.getString("AID"));
            }
            System.out.println("注册前最后一条管理员AID:"+sum);
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
            System.out.println("生成的aid:"+id);
            String sql2="INSERT INTO administrators (AID, NAME, PWD) VALUES ('"+id+"', '"+admin.getName()+"', '"+admin.getPwd()+"')";
            int count=dao.execute(sql2);
            System.out.println("受影响的行数:"+count);
            dao.DBcloseStatement();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }
}
