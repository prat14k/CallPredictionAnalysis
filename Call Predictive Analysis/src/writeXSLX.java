import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class writeXSLX {

	public static void writeXLSXFile() throws IOException{
		for(int K=0;K<7;K++){
			String excelFileName = "E:/codes/java/int1/Excel_files/TCH_"+K+".xlsx";//name of excel file
	
			String sheetName = "Sheet1";//name of sheet
	
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFSheet sheet = wb.createSheet(sheetName) ;
			XSSFRow row = sheet.createRow(0);
	
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("Date(DD/MM/YYYY)");
			
			cell = row.createCell(1);
			cell.setCellValue("Time(h:m:s)");
			
			cell = row.createCell(2);
			cell.setCellValue("Cell ID");
			
			cell = row.createCell(3);
			cell.setCellValue("CTO11");
			
			cell = row.createCell(4);
			cell.setCellValue("CTO12");
			
			Random rr = new Random();
			//iterating r number of rows
			double a,b,c;
			int i=0,cc=1;
			//for (int r=0;r < 7; r++ )
			{
				for(int j=0;j<24;j++){
					row = sheet.createRow(cc);
					
					for(int u=0;u<3;u++){
						cell = row.createCell(u);
						c= (1.0+ (1000.0-1.0)*rr.nextDouble());
						cell.setCellValue(c);
					}
					
					cell = row.createCell(4);
					c= (1.0+ (1000.0-1.0)*rr.nextDouble());
					cell.setCellValue(c);
					
					cell = row.createCell(3);
					b= (1.0+ (c-1.0)*rr.nextDouble());
					cell.setCellValue(b);
					cc++;
				}
				//row = sheet.createRow(cc);
				cc++;
			}
	
			FileOutputStream fileOut = new FileOutputStream(excelFileName);
	
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			wb.close();
		}
	}
	
	public static void main(String[] a) throws IOException{
		writeXLSXFile();
	}	
}
