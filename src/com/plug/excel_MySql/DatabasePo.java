package com.plug.excel_MySql;

/**
 * @Auther: Htc
 * @Date: 2019/2/13 20:38
 * @Description:数据库的连接参数
 */
public class DatabasePo {
    private String userName;
    private String passWord;
    private String drivers;
    private String Url;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getDrivers() {
        return drivers;
    }

    public void setDrivers(String drivers) {
        this.drivers = drivers;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public DatabasePo() {
    }

    public DatabasePo(String userName, String passWord, String drivers, String url) {
        this.userName = userName;
        this.passWord = passWord;
        this.drivers = drivers;
        Url = url;
    }

    @Override
    public String toString() {
        return "DatabasePo{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", drivers='" + drivers + '\'' +
                ", Url='" + Url + '\'' +
                '}';
    }
}
