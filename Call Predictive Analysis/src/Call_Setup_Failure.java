import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Call_Setup_Failure {

	public static void Part1_xslx() throws IOException
	{	
		
		InputStream ExcelFileToRead = new FileInputStream("Excel_files/Call_Setup_Failure.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		System.out.println();
		
		Iterator rows = sheet.rowIterator();
		
		int i=0;
		double[] arr = new double[15];
		int j_last = (sheet.getLastRowNum()+1)/15;
		double[] percent = new double[j_last];
		int j=0;
		rows.next();
		//System.out.println();
		while (rows.hasNext())
		{	
			row=(XSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			while (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					arr[i] = cell.getNumericCellValue(); 
					//System.out.print(arr[i]+" ");
					i++;
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
				if(i==15){
					i=0;
					if(j<j_last){
						percent[j] = Idea.algo(arr);
						//System.out.println(percent[j]);
						j++;
					}
				}
			}
			//System.out.println();
		}
		wb.close();
		
		BarChart_AWT.main(percent,1,"Call Drop Predictive Analysis");
		//GraphPanel.main(percent);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Part1_xslx();
		
	}
	
}
