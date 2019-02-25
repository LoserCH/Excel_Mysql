package com.plug.excel_MySql;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @Auther: Htc
 * @Date: 2019/2/19 15:36
 * @Description: 主面板程序
 */
public class Excel_sql_Main extends JFrame implements ActionListener {
    /**
     * @param: []
     * @return:
     * @auther: Htc
     * @date: 2019/2/19 15:38
     * @Description:主构造函数，用于初始化面板
     */
    //第一个界面
    FirstJpanel f=new FirstJpanel();
    //第二个界面
    SecondJpanel s=new SecondJpanel();
    JFrame jFrame=new JFrame("sql数据导入插件");
    /*创建菜单栏*/
    JMenuBar jMenuBar=new JMenuBar();
    //主页
    JMenu jMainMenu=new JMenu("主页");
    JMenuItem jMainItem=new JMenuItem("主页");
    //使用教程
    JMenu jUseMenu=new JMenu("使用指南");
    JMenuItem jUseItem=new JMenuItem("使用指南");
    //更多
    JMenu jMoreMenu=new JMenu("更多");
    JMenuItem jMoreItem=new JMenuItem("更多");


    //创建主页
    JPanel jmp=new JPanel();
    //创建使用指南面板
    JPanel jmp2=new JPanel();
    //创建"更多"的面板
    JPanel jmp3=new JPanel();


    public Excel_sql_Main(){
        //初始化主体
        jFrame.setSize(900,550);
        jFrame.setLocation(600,150);
        //设置窗口大小不能改变
        jFrame.setResizable(false);

        //初始化主页
        jmp=f.jmp;
        //初始化使用指南
        jmp2=s.jPanel;

        //菜单添加菜单项
        jMainMenu.add(jMainItem);
        jUseMenu.add(jUseItem);
        jMoreMenu.add(jMoreItem);
        //添加菜单
        jMenuBar.add(jMainMenu);
        jMenuBar.add(jUseMenu);
        jMenuBar.add(jMoreMenu);
        jFrame.setJMenuBar(jMenuBar);

        jFrame.add(jmp2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==jMainItem){
           jmp.setVisible(true);
           jFrame.add(jmp);
           jmp2.setVisible(false);
       }else if(e.getSource()==jUseItem){
           jmp2.setVisible(true);
           jFrame.add(jmp2);
           jmp.setVisible(false);
       }
    }
    public void start(){
        //切换标题
        jMainItem.addActionListener(this);
        jUseItem.addActionListener(this);
        jMoreItem.addActionListener(this);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
