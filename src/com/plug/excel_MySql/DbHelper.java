package com.plug.excel_MySql;

import java.sql.*;

/**
 * @Auther: Htc
 * @Date: 2019/2/13 15:23
 * @Description:连接数据库
 */
public class DbHelper {

    public Mode dbBase(DatabasePo databasePo){
        /**
         * @param: []
         * @return: java.sql.Connection
         * @auther: Htc
         * @date: 2019/2/13 15:36
         * @Description:数据库初始化，后期将以传参的形式进行
         */

        /*数据库驱动*/
        String username=databasePo.getUserName();
        String password=databasePo.getPassWord();
        String driver=databasePo.getDrivers();
        String url=databasePo.getUrl();

        Connection con=null;
        Mode mode=new Mode();

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("驱动装载失败");
            mode.setCount(1);
            mode.setMsg("驱动装载失败");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("数据库连接失败");
            mode.setCount(1);
            mode.setMsg("数据库连接失败");
        }
        mode.setCon(con);
        return  mode;
    }

}
