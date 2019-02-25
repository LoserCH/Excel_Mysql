package com.plug.excel_MySql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Auther: Htc
 * @Date: 2019/2/20 21:05
 * @Description:第一个面板的所有功能
 */
public class FirstJpanel implements ActionListener {
    //获得创建模板的信息
    //创建主页的四个面板
    JPanel jmp=new JPanel();
    //数据库信息
    JPanel jmp1=new JPanel();
    //excel文件信息
    JPanel jmp2=new JPanel();
    //excel模板
    JPanel jmp3=new JPanel();

    /*创建组件*/
    //数据库信息
    JTextField jt1=null;
    JTextField jt2=null;
    JComboBox jt3=null;
    JTextField jt4=null;
    JTextField jt5=null;
    JTextField jt6=null;
    JComboBox jt7=null;
    JTextField jt8=null;
    //excel文件信息
    JTextField jt9=null;
    JTextField jt10=null;
    //excel模板
    JTextField jt11=null;
    JTextField jt12=null;
    JTextField jt13=null;
    JTextField jt14=null;

    //获得excel模板按钮
    JButton bgMode=null;
    JButton binsert=null;

    public FirstJpanel(){
        //初始化面板1
        jmp1.setBorder(BorderFactory.createTitledBorder("数据库信息"));
        jmp1.setPreferredSize(new Dimension(800,130));
        jmp1.setLayout(new FlowLayout(FlowLayout.LEFT,15,10));
        //初始化面板2
        jmp2.setBorder(BorderFactory.createTitledBorder("excel数据信息"));
        jmp2.setPreferredSize(new Dimension(800,100));
        jmp2.setLayout(new FlowLayout(FlowLayout.LEFT,30,10));
        //初始化面板3
        jmp3.setBorder(BorderFactory.createTitledBorder("模板信息"));
        jmp3.setPreferredSize(new Dimension(800,100));
        jmp3.setLayout(new FlowLayout(FlowLayout.LEFT,20,10));

        //创建文本框
        jt1=new JTextField(13);
        jt2=new JTextField(13);
        //下拉框
        jt3=new JComboBox();
        jt3.addItem("com.mysql.cj.jdbc.Driver");
        jt3.addItem("com.mysql.jdbc.Driver");
        jt4=new JTextField(16);
        jt5=new JTextField(12);
        jt6=new JTextField(12);
        jt7=new JComboBox();
        jt7.addItem("UTF8");
        jt7.addItem("GBK");
        jt8=new JTextField(12);
        jt9=new JTextField(16);
        jt9.setText("D:\\excel模板.xls");
        jt10=new JTextField(12);
        jt10.setText("0");
        jt11=new JTextField(16);
        jt11.setText("excel模板");
        jt12=new JTextField(12);
        jt12.setText("sheet1");
        jt13=new JTextField(5);
        jt13.setText("0");
        jt14=new JTextField(40);
        //创建btn
        bgMode=new JButton("生成excel模板");
        bgMode.addActionListener(this);
        binsert=new JButton("开始插入");
        binsert.addActionListener(this);


        /*设置样式*/
        //输入框设置透明
        jt1.setOpaque(false);
        jt2.setOpaque(false);
        jt3.setOpaque(false);
        jt4.setOpaque(false);
        jt5.setOpaque(false);
        jt6.setOpaque(false);
        jt7.setOpaque(false);
        jt8.setOpaque(false);
        jt9.setOpaque(false);
        jt10.setOpaque(false);
        jt11.setOpaque(false);
        jt12.setOpaque(false);
        jt13.setOpaque(false);
        jt14.setOpaque(false);

        /*添加到面板*/
        //数据库信息
        jmp1.add(new JLabel("用户名："));
        jmp1.add(jt1);
        jmp1.add(new JLabel("密码："));
        jmp1.add(jt2);
        jmp1.add(new JLabel("数据库驱动："));
        jmp1.add(jt3);
        jmp1.add(new JLabel("数据库地址："));
        jmp1.add(jt4);
        jmp1.add(new JLabel("端口号："));
        jmp1.add(jt5);
        jmp1.add(new JLabel("数据库名称："));
        jmp1.add(jt6);
        jmp1.add(new JLabel("编码方式："));
        jmp1.add(jt7);
        jmp1.add(new JLabel("数据库表名称："));
        jmp1.add(jt8);
        //excel文件信息
        jmp2.add(new JLabel("文件路径："));
        jmp2.add(jt9);
        jmp2.add(new JLabel("sheet编号："));
        jmp2.add(jt10);
        //excel模板
        jmp3.add(new JLabel("文件名称："));
        jmp3.add(jt11);
        jmp3.add(new JLabel("sheet名称："));
        jmp3.add(jt12);
        jmp3.add(new JLabel("sheet编号："));
        jmp3.add(jt13);
        jmp3.add(new JLabel("数据库字段："));
        jmp3.add(jt14);
        jmp3.add(bgMode);

        //添加主页面板内容
        jmp.add(jmp1);
        jmp.add(jmp2);
        jmp.add(jmp3);
        jmp.add(binsert);
    }


    public Mode createMode(){
        Mode m=new Mode();
        Mode mode=new Mode();
        if("".equals(jt11.getText())||jt11.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写文件名");
            System.err.println("未填写文件名");
        }else if("".equals(jt12.getText())||jt12.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写sheet名称");
            System.err.println("未填写sheet名称");
        }else if("".equals(jt13.getText())||jt13.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写sheet编号");
            System.err.println("未填写sheet编号");
        }else if("".equals(jt14.getText())||jt14.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写数据库字段");
            System.err.println("未填写数据库字段");
        }else{
            Read_Excel re=new Read_Excel();
            try{
                m=re.createExcelMode(jt11.getText(),jt12.getText(),Integer.valueOf(jt13.getText()),jt14.getText());
            }catch (java.lang.NumberFormatException e){
                mode.setCount(1);
                mode.setMsg("未填写sheet编号");
                System.err.println("未填写sheet编号");
            }
            if(m.getCount()==1){
                mode.setCount(1);
                mode.setMsg("创建失败");

            }else{
                mode.setCount(0);
                mode.setMsg(m.getMsg());
            }
        }
        return mode;
    }



    //数据插入
    public Mode insertSql(){
        int num=0;
        Mode m=new Mode();
        Mode mode=new Mode();
        if("".equals(jt1.getText())||jt1.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写用户名");
        }else if("".equals(jt2.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写密码");
        }else if("".equals(jt4.getText())||jt4.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写数据库地址");
        }else if("".equals(jt5.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写端口号");
        }else if("".equals(jt6.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写数据库名称");
        }else if("".equals(jt8.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写数据库表名称");
        }else if("".equals(jt9.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写文件路径");
        }else if("".equals(jt10.getText())||jt2.getText().equals(null)){
            mode.setCount(1);
            mode.setMsg("未填写sheet编号");
        }else {
            Read_Excel read_excel=new Read_Excel();
            Read_Mysql read_mysql=new Read_Mysql();
            DbHelper dbHelper=new DbHelper();
            String url="jdbc:mysql://"+jt4.getText()+":"+jt5.getText()+"/"+jt6.getText()+"?characterEncoding="+jt7.getSelectedItem()+"&useSSL=true&serverTimezone=GMT";
            DatabasePo dp=new DatabasePo(jt1.getText(),jt2.getText(),(String) jt3.getSelectedItem(),url);
            //读出文件
            File file=new File(jt9.getText());
            Result result=read_excel.readExcel(file,Integer.valueOf(jt10.getText()));
            Mode mode1=dbHelper.dbBase(dp);
            //插入数据
            try{
                num=read_mysql.insertExcel(result,jt8.getText(),mode1.getCon());
            }catch (java.lang.NullPointerException e){
                mode.setCount(1);
                mode.setMsg(mode1.getMsg());
            }
            if(num>0){
                mode.setCount(0);
                mode.setMsg("插入完成");
            }else{
                mode.setCount(1);
                mode.setMsg("插入失败");
            }
        }
        return mode;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bgMode){
            Mode m=createMode();
            if(m.getCount()==1){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, m.getMsg(), "提示",JOptionPane.ERROR_MESSAGE);
            }else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, m.getMsg(), "提示",JOptionPane.INFORMATION_MESSAGE);
            }

        }else if(e.getSource() == binsert){
            Mode m=insertSql();
            if(m.getCount()==1){
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, m.getMsg(), "提示",JOptionPane.ERROR_MESSAGE);
            }else{
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, m.getMsg(), "提示",JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
