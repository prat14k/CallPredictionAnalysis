	import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.RefineryUtilities; 

public class BarChart_AWT extends JFrame
{
	public static String chartTitle;
	public static double[] arr;
	public static String str1; 
	public static int token;
   private static final long serialVersionUID = -3274051801568143285L;
   public BarChart_AWT(String applicationTitle)
   {
      super( applicationTitle );        
      if(BarChart_AWT.token==1){
    	  chartTitle="% vs Time";
    	  
      }
      else if(BarChart_AWT.token==2){
    	  chartTitle="% vs Time";
      }
      else if(BarChart_AWT.token==3){
    	  chartTitle="% vs Time";
      }
      else if(BarChart_AWT.token==4){
    	  chartTitle="% vs Time";
      }
      else{
    	  chartTitle = "% vs Time";
      }
      JFreeChart barChart = ChartFactory.createBarChart(
         "",           
         "Dataset",            
         "% of failure prediction",            
         createDataset(),          
         PlotOrientation.VERTICAL,           
         true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      setLocation(60,130);
      //JLabel lab = new JLabel("fdsfdsf");
      //getContentPane().add(lab);
   }
   private CategoryDataset createDataset( )
   {
      final DefaultCategoryDataset dataset = 
      new DefaultCategoryDataset( );  
      int x;
      for(int i=0;i<BarChart_AWT.arr.length;i++){
    	  x=((i+1)*15);
    	  if(BarChart_AWT.token == 2)
    		  dataset.addValue( BarChart_AWT.arr[i] , BarChart_AWT.chartTitle , "Rain "+(i+1) );
    	  else
    		  dataset.addValue( BarChart_AWT.arr[i] , BarChart_AWT.chartTitle , x+" : "+(x+5));
      }
      return dataset; 
   }
   public static void main( double[ ] args ,int tok,String appliTitle)
   {
	  arr=args;
      BarChart_AWT.token = tok;
      BarChart_AWT chart = new BarChart_AWT(appliTitle);  
      
	  chart.pack();
	  chart.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      chart.setVisible( true ); 
   }
}