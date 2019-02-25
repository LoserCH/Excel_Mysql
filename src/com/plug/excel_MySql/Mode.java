package com.plug.excel_MySql;

import java.sql.Connection;

/**
 * @Auther: Htc
 * @Date: 2019/2/20 11:04
 * @Description:
 */
public class Mode {
    private int count;
    private String msg;
    private String value;
    private Connection con;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Mode(int count, String msg) {
        this.count = count;
        this.msg = msg;
    }

    public Mode() {
    }

    @Override
    public String toString() {
        return "Mode{" +
                "count=" + count +
                ", msg='" + msg + '\'' +
                ", value='" + value + '\'' +
                ", con=" + con +
                '}';
    }
}
