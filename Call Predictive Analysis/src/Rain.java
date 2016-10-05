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


public class Rain {
	
	public static void Part2_xslx() throws IOException{
		double[] percent = new double[4];
		for(int l=1;l<=4;l++){
			InputStream ExcelFileToRead = new FileInputStream("Excel_files/Rain"+l+".xlsx");
			XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
			
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row; 
			XSSFCell cell;
	
			System.out.println();
			
			Iterator rows = sheet.rowIterator();
			
			String j="";
			rows.next();
			//System.out.println();
			int yes=0,no=0;
			while (rows.hasNext())
			{	
				row=(XSSFRow) rows.next();
				Iterator cells = row.cellIterator();
				cells.next();
				cells.next();
				
				if (cells.hasNext())
				{
					cell=(XSSFCell) cells.next();
			
					if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					{
						j=cell.getStringCellValue();
						System.out.println(j);
					}
					else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						cell.getNumericCellValue(); 
						//System.out.print(arr[i]+" ");
							
					}
					else
					{
						System.out.println("Not parseable ..... ");
						break;
					}
				}
				if(j.equalsIgnoreCase("No"))
					no++;
				else
					yes++;
			}
			
			percent[l-1] = ((no*100)/(yes+no));
			System.out.println("Probability "+l+": "+percent[l-1]);
			wb.close();
			//GraphPanel.main(percent);
		}

		BarChart_AWT.main(percent,2,"Rain Effect on Calls");		

	}
	
	public static void main(String[] args) throws IOException {
		
		Part2_xslx();
		JComponent[] strings = new JComponent[6];
		strings[0] = new JLabel("This dialog box is showing the quality of the voice on basis of their MOS value");
		strings[1] = new JLabel("   ");
		strings[2] = new JLabel("Rain1 : rain < 4.833 mm/hr");
		strings[3] = new JLabel("Rain2 : 4.8 - 15.133 mm/hr");
		strings[4] = new JLabel("Rain3 : 28.5-33.899 mm/hr");
		strings[5] = new JLabel("Rain4 :  rain >= 33.899 mm/hr");
		final JOptionPane pane = new JOptionPane(strings);
	    final JDialog d = pane.createDialog(null, "Info" );
	    d.setLocation(800,300);
	    d.setVisible(true);
	}
}
