import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Time_Call_Failure {

	
	public static void Part4_xslx() throws IOException
	{
		InputStream ExcelFileToRead = new FileInputStream("Excel_files/Time.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		System.out.println();
		
		Iterator rows = sheet.rowIterator();
		
		int i=0,yes=0,no=0;
		double t;
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
					t = cell.getNumericCellValue(); 
					//System.out.print("t= "+t+"  ");
					if(t>7.00000000000)
						no++;
					else yes++;
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
						percent[j] = ((no*100)/(yes+no));
						//System.out.println(percent[j]);
						//if(percent[j]<50.00000000000)
						//	percent[j] = Idea.idea2(j);
						//System.out.println(percent[j]);
						j++;
					}
				}
			}
			//System.out.println();
		}
		wb.close();
		
		for(i=0;i<j_last;i++){
			if(percent[i]<50.00000000000){
				percent[i] = Idea.idea2(i);
			}
			System.out.println(percent[i]);
		}
		
		BarChart_AWT.main(percent,4,"Failure Prediction due to call time Delay");
		//GraphPanel.main(percent);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		Part4_xslx();
		
	}


}
