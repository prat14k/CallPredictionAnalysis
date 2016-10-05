import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class CSSR {

	public static void Part5_xslx() throws IOException{
		
		double[] percent = new double[7];
		double[] cto1 = new double[24];
		double[] cto2 = new double[24];
		double[] cto3 = new double[24];
				
		int yes=0,no=0;
		double var;
		for(int i=0;i<7;i++)
		{	
			InputStream ExcelFileToRead = new FileInputStream("Excel_files/CSSR_"+i+".xlsx");
			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;

			//System.out.println();
			
			Iterator rows = sheet.rowIterator();
			
			//String j="";
			rows.next();
			//System.out.println();

			
			for(int j=0;j<24;j++){
				row=(XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				cells.next();
				cells.next();
				cells.next();
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{	
					System.out.println(cell.getStringCellValue());
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					cto1[j] = cell.getNumericCellValue(); 
					//System.out.print(arr[i]+" ");	
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{	
					System.out.println(cell.getStringCellValue());
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					cto2[j] = cell.getNumericCellValue(); 
					//System.out.print(arr[i]+" ");		
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
				
				cell=(XSSFCell) cells.next();
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					
					System.out.println(cell.getStringCellValue());
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					cto3[j] = cell.getNumericCellValue(); 
					//System.out.print(arr[i]+" ");
						
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
				
				var = (((cto1[j]+cto2[j])*100)/cto3[j]);
				if(var>50.000000000000)
					yes++;
				else
					no++;
				//System.out.println(cc++);
			}
			//rows.next();
			//cc++;
			percent[i] = (float)(yes*100)/(yes+no);
			System.out.println("Probability "+i+": "+percent[i]);
			
			wb.close();
		}
		
		
		BarChart_AWT.main(percent,5,"CSSR");		

	}
	
	public static void main(String[] args) throws IOException {
		
		Part5_xslx();
	
		JComponent[] strings = new JComponent[9];
		strings[0] = new JLabel("This dialog box is showing the Day of the calls the files contain");
		strings[1] = new JLabel("   ");
		for(int i=2;i<9;i++){
			strings[i] = new JLabel("CSSR_"+(i-1)+".xlsx -  Day-"+(i-1));
		}
		final JOptionPane pane = new JOptionPane(strings);
	    final JDialog d = pane.createDialog(null, "CSSR Files" );
	    d.setLocation(800,300);
	    d.setVisible(true);
	
	
	}

	
	
}
