import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Idea {
		
	//static final double k = (0.0158064852); 
	
	public static double idea2(int k) throws IOException{
		System.out.println("aa ");
		
		InputStream ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") + "/Excel_files/Call_Setup_Failure.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		System.out.println();
		
		Iterator rows = sheet.rowIterator();
		
		int i=0;
		double[] arr = new double[15];
		rows.next();
		for(int l=0;l<k*15;l++)
			rows.next();
		System.out.println(k);
		i=0;
	
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
					System.out.print("arr_:"+i+" "+arr[i]+" ");
					i++;
					System.out.println(i);
					if(i>=15){
						break;
						//System.out.println(percent[j]);
					}
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
				
			}
			if(i>=15){
				break;
				//System.out.println(percent[j]);
			}
			//System.out.println();
		}
		wb.close();

		return Idea.algo(arr);
}
	
	public static double algo(double arr[]){
		
		double yes=0,no=0;
		double[] r = new double[arr.length];
		for(int i=0;i<arr.length;i++){
			//System.out.println("ele: -"+arr[i]);
				
			//p = (k/(Math.pow(arr[i], 2)));
			r[i] = (34.7864 * Math.log10(arr[i]))+125.4949;
			
			double p = 33-(r[i]/1.5)-2-5-3+14;
			//System.out.println(p);
			if((p<-50.000000000000000) && (p>-78.000000000000000)){
				yes++;
			}
			else{
				no++;
			}
			//System.out.println(r[i]);
		}
		
		//System.out.println(yes+" "+no+" "+(yes*100)/15);
		return ((no*100)/(yes+no)) ;
	}
	
}
