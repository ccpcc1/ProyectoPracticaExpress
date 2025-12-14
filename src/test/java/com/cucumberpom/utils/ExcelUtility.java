package com.cucumberpom.utils;

import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    public static Map<String,String> getDataRecord(String routeFile, String sheet){
        Map<String,String> rowReader= new HashMap<>();
        try{
            FileInputStream fileInputStream= new FileInputStream(routeFile);

            Workbook workbook  = new XSSFWorkbook(fileInputStream);

            Sheet sheetReader= workbook.getSheet(sheet);

            Row header = sheetReader.getRow(0);
            //change name
            short colStatus=getColumnIndex(header,"Status");
            if (colStatus==-1){
                System.err.println("Doesn't found the status column");
                return rowReader;
            }
            // record values 
            for (int i=0;i<sheetReader.getLastRowNum();i++){
                Row row= sheetReader.getRow(i);
                if (row==null) continue; //if row doesn't value, continue with next row
                
                Cell statusCell=row.getCell(colStatus);
                if (statusCell==null) continue; // if the cell is null, continue with next row
               
                statusCell.setCellType(CellType.STRING);
                String status=statusCell.getStringCellValue().trim(); //get status column value
                
                if (status.trim().equalsIgnoreCase("Avaible")) {
                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        String key = header.getCell(j).getStringCellValue().trim();
                        Cell cellValue = row.getCell(j);
                        if (cellValue == null) continue;
                        cellValue.setCellType(CellType.STRING);
                        String value = cellValue.getStringCellValue().trim();
                        rowReader.put(key, value);
                    }
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("!!!Exception error: "+e);
        }
        return rowReader;
    }

    private static short getColumnIndex(Row header,String columnName){
        for (short i=0;i<header.getLastCellNum();i++){
            Cell cell= header.getCell(i);
            if (cell!=null && cell.getStringCellValue().trim().equalsIgnoreCase(columnName)){
                return  i;
            }
        }
        return -1;//error way
    }

    public static void markFistRecordLikeUsed(String routeFile){
        try (FileInputStream fis = new FileInputStream(new File(routeFile));
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            Row header = sheet.getRow(0);
            int columnStatus = -1;

            for (int i = 0; i < header.getLastCellNum(); i++) {
                Cell cell = header.getCell(i);
                if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase("Status")) {
                    columnStatus = i;
                    break;
                }
            }
            if (columnStatus == -1)
                return;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null)
                    continue;
                Cell cellStatus = row.getCell(columnStatus);
                if (cellStatus == null)
                    continue;
                cellStatus.setCellType(CellType.STRING);
                String status = cellStatus.getStringCellValue().trim();
                if ("Avaible".equalsIgnoreCase(status)) {
                    cellStatus.setCellValue("Used");

                    try (FileOutputStream fos = new FileOutputStream(new File(routeFile))) {
                        workbook.write(fos);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
