import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MOS {

	
	
public static void Part3_xslx() throws IOException{
		
		InputStream ExcelFileToRead = new FileInputStream("Excel_files/MOS.xlsx");
		XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row; 
		XSSFCell cell;

		System.out.println();
		
		Iterator rows = sheet.rowIterator();
		
		int i=0,j=0;
		
		int j_last = (sheet.getLastRowNum()+1)/15;
		double[] percent = new double[j_last];
		double[] latency = new double[sheet.getLastRowNum()];
		double[] jitter = new double[j_last];
		Arrays.fill(jitter, 0);
		double[] packet = new double[sheet.getLastRowNum()];
		
		rows.next();
		//System.out.println();
		
		row=(XSSFRow) rows.next();
		Iterator cells = row.cellIterator();
		if (cells.hasNext())
		{
			cell=(XSSFCell) cells.next();
	
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
			{
				//System.out.print(cell.getStringCellValue()+" ");
			}
			else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
			{
				packet[i] = cell.getNumericCellValue(); 
				//System.out.print(arr[i]+" ");
				//i++;
			}
			else
			{
				//System.out.println("Not parseable ..... ");
			}
		}
		if (cells.hasNext())
		{
			cell=(XSSFCell) cells.next();
	
			if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
			{
				//System.out.print(cell.getStringCellValue()+" ");
			}
			else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
			{
				latency[i] = cell.getNumericCellValue(); 
				//System.out.print(arr[i]+" ");
				i++;
			}
			else
			{
				System.out.println("Not parseable ..... ");
			}
		}
	
		
		
		while (rows.hasNext())
		{	
			row=(XSSFRow) rows.next();
			cells = row.cellIterator();
			if (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					//System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					packet[i] = cell.getNumericCellValue(); 
					//System.out.print(arr[i]+" ");
					//i++;
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
			}
			if (cells.hasNext())
			{
				cell=(XSSFCell) cells.next();
		
				if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
				{
					//System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
				{
					latency[i] = cell.getNumericCellValue(); 
					double o = (latency[i] - latency[i-1]);
					if(o<0.000000000000)
						o=o*-1;
					jitter[j]+=o;
					//System.out.print(arr[i]+" ");
					i++;
				}
				else
				{
					System.out.println("Not parseable ..... ");
					break;
				}
			}
			if((i-1)%15==0){
				jitter[j] = (jitter[j]/14);
				j++;
			}
			//System.out.println();
		}
		String msg[] = new String[15];
		double[] mos = new double[105];
		double avg=0;
		double var=0;
		int yes=0,no=0;
		int pos;
		double var1,var2;
		for(j=0;j<jitter.length;j++){
			for(i=0;i<15;i++){
				pos = (j*15)+i;
				var = latency[pos] + jitter[j]*2 +10;
				if(var<160){
					var1 = 93.2 - (var/40);
				}
				else
					var1 = 93.2 - ((var-120)/10);
				
				var2 = var1 - (packet[pos]*2.5);
				mos[pos] = 1 + (0.035*var2) + (0.000007*var2*(var2-60)*(100-var2));  
				avg+=mos[pos];
				if((mos[pos]>2.5)&&(mos[pos]<5))
					yes++;
				else no++;
				System.out.println("Mos:"+ mos[pos]);
			}
			System.out.println("jitter: "+jitter[j]);
			avg=avg/15;
			if((avg>2.5)&&(avg<3.5))
				msg[j]="Normal";

			else if((avg>3.5))
				msg[j]="Excellent";

			else if((avg<2.5))
				msg[j]="Worst";
			System.out.println("Msg:"+ msg[j]+" avg:"+avg);
			
			percent[j] = ((yes*100)/(yes+no));
			System.out.println("%:"+ percent[j]);
			System.out.println();
			
		}

		wb.close();
		BarChart_AWT.main(percent,3,"MOS Calculation and Analysis");
		//GraphPanel.main(percent);
		JComponent[] strings = new JComponent[9];
		strings[0] = new JLabel("This dialog box is showing the quality of the voice on basis of their MOS value");
		strings[1] = new JLabel("   ");
		for(int c=0;c<7;c++){
			strings[c+2] = new JLabel("Dataset"+(c+1)+" : "+ msg[c] + "\n");
	  	}
		final JOptionPane pane = new JOptionPane(strings);
	    final JDialog d = pane.createDialog(null, "MOS Files" );
	    d.setLocation(800,300);
	    d.setVisible(true);
	
	}

	public static void main(String[] args) throws IOException {
		
		Part3_xslx();
	}

}
