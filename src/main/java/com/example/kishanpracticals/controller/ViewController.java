package com.example.kishanpracticals.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.kishanpracticals.model.ExcelUploadDetail;
import com.example.kishanpracticals.repo.ExcelUploadDetailRepo;
import com.example.kishanpracticals.service.ExcelUploadService;

@Controller
public class ViewController {
	
	@Autowired
	ExcelUploadService euservice;
	
	@Autowired
	ExcelUploadDetailRepo eudrepo;
	
	@GetMapping("/upload")
	public String excelUploadPage(){
		return "excelupload";
	}

	@GetMapping("/dbdata")
	public String dbDataPage(HttpServletRequest request){
		List<ExcelUploadDetail> eudlist = new ArrayList<ExcelUploadDetail>();
		eudlist = eudrepo.findAll();
		request.setAttribute("eudlist", eudlist);
		return "exceldbdata";
	}
	
	@PostMapping("/excelupload")
	public String excelUpload(@RequestPart(value = "eufile") MultipartFile file){
		boolean b = false;
		if(file != null) {
			String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
			if(ext.equalsIgnoreCase("xlsx")) {
				try {
		            XSSFWorkbook workbook = null;
		            workbook = new XSSFWorkbook(file.getInputStream());
		            XSSFSheet worksheet = workbook.getSheetAt(0);
		            b = euservice.saveExcel(worksheet);
		            System.out.println(b);

		        }catch (Exception ex){
		            ex.printStackTrace();
		            return "redirect:/upload";
		        }
				
				if(b == true) {
					System.out.println(b+"list set");
					return "redirect:/dbdata";
				}
				
			}
			
		}
		else {
			return "redirect:/upload";
		}
		return null;
	}
	
	
	@GetMapping("/downloadexcel")
	public void downloadExcel(HttpServletResponse response) {
		System.out.println("Inside download");
		
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=Downloaded_Task_File.xlsx");
		
        List<ExcelUploadDetail> datalist = eudrepo.findAll();
        System.out.println("datalist------------->>>>>>"+datalist.size());
        Field[] f = ExcelUploadDetail.class.getDeclaredFields();
        System.out.println(f.length+"-------------");
        
        List<List<String>> sl = new ArrayList<List<String>>();
        System.out.println("sl------------->>>>>>"+sl.size());
        List<String> l = new ArrayList<String>();
        l.add("Sr.No.");
    	l.add("Id");
    	l.add("A");
    	l.add("B");
    	l.add("Date");
    	l.add("C");
    	l.add("D");
    	sl.add(l);
        
        for(int i=0; i<datalist.size(); i++) {
        	List<String> list = new ArrayList<String>();
        	list.add(String.valueOf(datalist.get(i).getSrNo()));
        	list.add(String.valueOf(datalist.get(i).getId()));
        	list.add(String.valueOf(datalist.get(i).getaA()));
        	list.add(String.valueOf(datalist.get(i).getbB()));
        	list.add(String.valueOf(datalist.get(i).getDate()));
        	list.add(String.valueOf(datalist.get(i).getcC()));
        	list.add(String.valueOf(datalist.get(i).getdD()));
        	sl.add(list);
        }
		
        System.out.println("sl------------->>>>>>"+sl.size());
        System.out.println("sl.get(0)------------->>>>>>"+sl.get(0).size());
		
		try(Workbook wb = new XSSFWorkbook()){
			
			Sheet sheet = wb.createSheet("Audit Detail");
			
			for(int i=0; i < sl.size(); i++) {
				Row row = sheet.createRow(i);
				for(int j = 0; j< sl.get(0).size(); j++) {
					Cell cell = row.createCell(j);
					cell.setCellValue(sl.get(i).get(j));
				}
				
			}
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        wb.write(outputStream);
	        
	        
	        ByteArrayInputStream stream =  new ByteArrayInputStream(outputStream.toByteArray());
	        IOUtils.copy(stream, response.getOutputStream());
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	@ResponseBody
	@GetMapping("/test")
	public String test(){
		
  		String str = "abcdab";
  		
  		HashSet<Character> hs = new HashSet<Character>();
  		String lt = "";
  		String lo = "";
  		
  		for(int i=0; i<str.length(); i++) {
  			char c = str.charAt(i);
  			
  			if(hs.contains(c)) {
  				hs.clear();
  				lt="";
  			}
  			lt+=c;
  			hs.add(c);
  			
  			if(lt.length()>lo.length()) {
  				lo = lt;
  			}

  		}
  		return lo;
	}
	
}