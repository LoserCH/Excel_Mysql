package com.plug.excel_MySql;

import javax.swing.*;

/**
 * @Auther: Htc
 * @Date: 2019/2/20 21:12
 * @Description:第二个页面，用于介绍使用方法
 */
public class SecondJpanel{
    JPanel jPanel=new JPanel();
    JTextArea jTextArea=new JTextArea(50,80);
    public SecondJpanel(){
        jTextArea.setLineWrap(true);
        Read_Mysql read_mysql=new Read_Mysql();
        Mode m=read_mysql.readFile();
        if(m.getCount()!=1){
            jTextArea.setText(m.getValue());
        }else{
            System.err.println(m.getMsg());
        }
        jPanel.add(jTextArea);
    }
}
