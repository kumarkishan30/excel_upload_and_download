package com.example.kishanpracticals.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.kishanpracticals.model.ExcelUploadDetail;
import com.example.kishanpracticals.repo.ExcelUploadDetailRepo;

@Component
public class ExcelUploadService {

	@Autowired
	ExcelUploadDetailRepo eudrepo;
	
	@SuppressWarnings("deprecation")
	public boolean saveExcel(XSSFSheet worksheet){
	    try {


	    	List<ExcelUploadDetail> eudlist = new ArrayList<ExcelUploadDetail>();

	        // getting rows from excel file
	        for (int i = 1; i <= worksheet.getLastRowNum(); i++) {
	        	ExcelUploadDetail eud = new ExcelUploadDetail();

	            XSSFRow row = worksheet.getRow(i);
	            
	            //setting excel data to model
	            
	            Cell cell = row.getCell(0);
	            cell.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setSrNo(cell.getStringCellValue());
	            Cell cell1 = row.getCell(1);
	            cell1.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setId(cell1.getStringCellValue());
	            Cell cell2 = row.getCell(2);
	            cell2.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setaA(cell2.getStringCellValue());
	            Cell cell3 = row.getCell(3);
	            cell3.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setbB(cell3.getStringCellValue());
	            Cell cell4 = row.getCell(4);
	            cell4.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setDate(cell4.getStringCellValue());
	            Cell cell5 = row.getCell(5);
	            cell5.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setcC(cell5.getStringCellValue());
	            Cell cell6 = row.getCell(6);
	            cell6.setCellType(Cell.CELL_TYPE_STRING);
	            eud.setdD(cell6.getStringCellValue());
	            
	            eudlist.add(eud);

	        }

	       for (ExcelUploadDetail eud : eudlist) {
	    	   eudrepo.save(eud);
	        }

	        return true;

	    }catch (Exception ex){
	        ex.printStackTrace();
	        return false;
	    }

	}
	
}
