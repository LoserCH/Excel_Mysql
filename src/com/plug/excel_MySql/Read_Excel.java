package com.plug.excel_MySql;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Auther: Htc
 * @Date: 2019/2/13 14:51
 * @Description:读出excel数据
 */
public class Read_Excel {

    public Result readExcel(File e_fileName,Integer sheet_Num){
        /**
         * @param: [e_fileName,文件 sheet_Num 文件页数]
         * @return: java.lang.String[][]
         * @auther: Htc
         * @date: 2019/2/17 21:33
         * @Description:将excel数据读为二元数组
         */
        Workbook workbook = null;
        String[][] excelList=null;
        try {
            //创建Workbook
            workbook=Workbook.getWorkbook(e_fileName);
            //获取第一个sheet
            Sheet sheet=workbook.getSheet(sheet_Num);
            excelList=new String[sheet.getColumns()][sheet.getRows()];
            //获取数据
            for(int i=0;i<sheet.getColumns();i++){
                for(int j=0;j<sheet.getRows();j++){
                    Cell cell=sheet.getCell(i,j);
                    if(j<1){
                        excelList[i][j]=cell.getContents();
                    }else{
                        excelList[i][j]="'"+cell.getContents()+"'";
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }finally {
            workbook.close();
        }
        //封装
        Result result=new Result(excelList.length,excelList[0].length,excelMode(excelList));

        return result;
    }


    public String[] excelMode(String[][] excelData){
        /**
         * @param: [excelData]
         * @return: com.plug.excel_MySql.Result
         * @auther: Htc
         * @date: 2019/2/19 9:24
         * @Description:将元数据整理成sql可以使用的数据，第一行是数据项，其他的是数据
         */
        String[] list=new String[excelData[0].length];
        String var="";

        //获得数据项
        for(int i=0;i<excelData[0].length;i++){
            for(int j=0;j<excelData.length;j++){
                var+=excelData[j][i]+",";
            }
            var=var.substring(0,var.length()-1);
            list[i]=var;
            var="";
        }
        for(int i=0;i<list.length;i++){
            System.out.println(list[i]);
        }
        return list;
    }


    public Mode createExcelMode(String e_fileName,String sheetName,int sheetNum,String title){
        /**
         * @param: [e_fileName(excel文件名), sheetName（单元格名）, sheetNum（单元格编号）, title（头部）]
         * @return: void
         * @auther: Htc
         * @date: 2019/2/13 20:24
         * @Description:根据数据库字段创建excel数据模板
         */

        Mode m=new Mode();
        /*创建文件*/
        String path="D:\\"+e_fileName+".xls";
        File file= new File(path);
        if(file.exists()){
            Date date=new Date();
            path="D:\\"+e_fileName+date.getTime()+".xls";
            file= new File(path);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            m.setCount(1);
            m.setMsg("文件创建失败");
            System.err.println("文件创建失败");
        }
        //2:创建工作簿
        WritableWorkbook workbook= null;
        try {
            workbook = Workbook.createWorkbook(file);
            //3:创建sheet
            WritableSheet sheet=workbook.createSheet(sheetName, sheetNum);
            //4：设置title，分割字符串
            String[] titles=title.split(";");
            //5:单元格
            Label label=null;
            //6:给第一行设置列名
            for(int i=0;i<titles.length;i++){
                //x,y,第一行的列名
                label=new Label(i,0,titles[i]);
                //7：添加单元格
                sheet.addCell(label);
            }
            //写入数据
            workbook.write();
            //最后一步，关闭工作簿
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
            m.setCount(1);
            m.setMsg("文件创建失败");
            System.err.println("文件创建失败");
        } catch (RowsExceededException e) {
            e.printStackTrace();
            m.setCount(1);
            m.setMsg("行列数据不匹配");
            System.err.println("行列数据不匹配");
        } catch (WriteException e) {
            e.printStackTrace();
            m.setCount(1);
            m.setMsg("数据写入失败");
            System.err.println("数据写入失败");
        }
        if(m.getCount()!=1){
            m.setCount(0);
            m.setMsg("文件创建成功，文件位置在:"+path);
        }else{
            m.setCount(0);
            m.setMsg("文件创建失败，查看信息是否完整");
        }
        return m;
    }
}
