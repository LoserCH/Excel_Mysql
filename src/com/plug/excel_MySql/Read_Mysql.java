package com.plug.excel_MySql;

import java.io.*;
import java.sql.*;

/**
 * @Auther: Htc
 * @Date: 2019/2/13 14:52
 * @Description:读出MySQL数据。
 */
public class Read_Mysql {
    public int insertExcel(Result dataSource,String tableName,Connection con){
        int num=0;
        String[] source=dataSource.getO_array();
        //字段拼接做插入，需要表名（后期传入），表字段，表数据

        String sql="insert into "+tableName+"("+source[0]+") values";
        for(int i=1;i<source.length;i++){
            sql+="("+source[i]+"),";
        }
        //将最后的一个逗号处理成分号
        sql=sql.substring(0,sql.length()-1)+";";
        System.out.println(sql);
        //进行数据插入
        Statement statement=null;
        try {
            statement =con.createStatement();
            num=(int) statement.executeLargeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    public Mode readFile(){
        Mode mode=new Mode();
        BufferedReader bf=null;
        //创建缓存区
        char[] b=new char[50];
        //保存实际读取的字节数
        int h=0;
        //取出的字符串
        String str="";
        try {
            bf=new BufferedReader(new InputStreamReader(new FileInputStream("src/com/plug/other/readme.txt"),"GB2312"));
            while ((h=bf.read(b))>0){
                str+=new String(b,0,h);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            mode.setCount(1);
            mode.setMsg("文件不存在");
            System.err.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            mode.setCount(1);
            mode.setMsg("文件读取异常");
            System.err.println("文件读取异常");
        }finally {
            try {
                bf.close();
            } catch (IOException e) {
                e.printStackTrace();
                mode.setCount(1);
                mode.setMsg("文件读取异常");
                System.err.println("文件读取异常");
            }
        }
        if(mode.getCount()!=1){
            mode.setCount(0);
            mode.setMsg("文件加载成功");
            mode.setValue(str);
        }
        return mode;
    }

}
