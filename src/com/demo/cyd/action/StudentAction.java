package com.demo.cyd.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.demo.cyd.java.UploadFile;
import com.demo.cyd.model.Student;
import com.demo.cyd.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Scope("prototype")
@Component
public class StudentAction extends ActionSupport {

	private InputStream excelFile;
	private File uploadFile;
	private String uploadFileFileName;
	private StudentService studentService;

	// 进入页面查询数据
	public String listAll() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Student> sList = studentService.findAll();
		request.setAttribute("list", sList);
		return "listAll";
	}

	// 导出Excel
	public String ExcelExport() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids = request.getParameter("ids");
		List<Student> list = new ArrayList<Student>();
		String[] array = ids.split(",");
		int[] id = new int[array.length];
		for (int i = 0; i < id.length; i++) {
			Student student = studentService
					.findById(Integer.valueOf(array[i]));
			list.add(student);
		}
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("学生信息");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("学号");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("年龄");
		row.createCell(3).setCellValue("性别");
		row.createCell(4).setCellValue("地址");
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		for (int i = 1; i <= list.size(); i++) {
			Student stu = list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(stu.getS_id());
			row.createCell(1).setCellValue(stu.getS_name());
			row.createCell(2).setCellValue(stu.getS_age());
			row.createCell(3).setCellValue(stu.getS_sex());
			row.createCell(4).setCellValue(stu.getS_address());
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		workbook.write(baos);
		excelFile = new ByteArrayInputStream(baos.toByteArray());
		baos.close();
		return "excel";
	}

	// 导入Excel
	public String ExcelInto() throws Exception {
		String directory = "/file";
		String targetDirectory = ServletActionContext.getServletContext().getRealPath(directory);
		File target = UploadFile.Upload(uploadFile, uploadFileFileName,targetDirectory);
		List<Student> sList = new ArrayList<Student>();
		excelFile = new FileInputStream(target);
		Workbook wb = new HSSFWorkbook(excelFile);
		Sheet sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		for (int i = 0; i < rowNum; i++) {
			Student student = new Student();
			Row row = sheet.getRow(i);
			int cellNum = row.getLastCellNum();
			for (int j = 0; j < 5; j++) {
				Cell cell = row.getCell(j);
				String cellValue = null;
				switch (cell.getCellType()) { // 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
				case 0:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 1:
					cellValue = cell.getStringCellValue();
					break;
				case 2:
					cellValue = String
							.valueOf((int) cell.getNumericCellValue());
					break;
				case 3:
					cellValue = cell.getStringCellValue();
					break;
				case 4:
					cellValue = cell.getStringCellValue();
					break;
				}
				if(cellValue==null||cellValue.length()==0){
					break;
				}else{

				switch (j) {// 通过列数来判断对应插如的字段
				case 0:
					student.setS_address(cellValue);
					break;
				case 1:
					student.setS_age(Integer.valueOf(cellValue));
					break;
				case 2:
					break;
				case 3:
					student.setS_name(cellValue);
					break;
				case 4:
					student.setS_sex(cellValue);
					break;
				}
			sList.add(student);
			}
		}
		}
		studentService.add(sList);
		return "listAll";
	}

	public InputStream getExcelFile() {
		return excelFile;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name = "studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
}
