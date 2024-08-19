package openCratProject.org.Resources.utilities;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

public class ExcelSheetUtils {
    
    String path;
   
    public ExcelSheetUtils(String path){
        this.path=path;
    }

    public FileInputStream fis = null;
    public XSSFWorkbook workbook = null;
    public XSSFSheet sheet = null;
    public XSSFRow row = null;
    public XSSFCell cell = null;
    public FileOutputStream fout=null;
    public File file;
    public CellStyle style;
    
    public int getRowCount(String sheetName) throws IOException
    {
        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        int rowcount=sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowcount;
    }

    public int getCellCount(String sheetName,int rownum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        int cellcount=row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellcount;
    }


    public String getCellData(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        DataFormatter formatter = new DataFormatter();
        String data;
        try{
            data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
        }
        catch(Exception e)
        {
            data="";
        }
        workbook.close();
        fis.close();
        return data;
    }

    public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
    {
        file = new File(path);
        if(!file.exists())    // If file not exists then create new file
        {
            workbook= new XSSFWorkbook();
            fout =new FileOutputStream(path);
            workbook.write(fout);
        }

        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);

        if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
            workbook.createSheet(sheetName);
        sheet=workbook.getSheet(sheetName);

        if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
            sheet.createRow(rownum);
        row=sheet.getRow(rownum);

        cell=row.createCell(colnum);
        cell.setCellValue(data);
        fout=new FileOutputStream(path);
        workbook.write(fout);
        workbook.close();
        fis.close();
        fout.close();
    }


    public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);

        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        style=workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fout);
        workbook.close();
        fis.close();
        fout.close();
    }


    public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
    {
        fis=new FileInputStream(path);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheet(sheetName);
        row=sheet.getRow(rownum);
        cell=row.getCell(colnum);

        style=workbook.createCellStyle();

        style.setFillForegroundColor(IndexedColors.RED.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        workbook.write(fout);
        workbook.close();
        fis.close();
        fout.close();
    }
}
