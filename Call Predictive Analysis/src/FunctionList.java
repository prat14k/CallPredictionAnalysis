import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import org.jfree.ui.RefineryUtilities;



public class FunctionList extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2105168903611371125L;
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JButton btnNewButton_6;
	public JButton btnExit;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			if(e.getSource() == btnExit){
				this.dispose();
				System.exit(0);
			}
			else if(e.getSource() == btnNewButton){
				Call_Setup_Failure.main(null);
			}
			else if(e.getSource() == btnNewButton_1){
				MOS.main(null);
			}
			else if(e.getSource() == btnNewButton_2){
				Time_Call_Failure.main(null);
			}
			else if(e.getSource() == btnNewButton_3){
				Rain.main(null);
			}
			else if(e.getSource() == btnNewButton_4){
				CSSR.main(null);
			}
			else if(e.getSource() == btnNewButton_5){
				CDR.main(null);
			}
			else if(e.getSource() == btnNewButton_6){
				TCH.main(null);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	public FunctionList(String str){
		super(str);
		initialize();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}
	private void initialize() {
		new JFrame();
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblFunctionsForPredictive = new JLabel("Functions for",SwingConstants.CENTER);
		lblFunctionsForPredictive.setFont(new Font("Comic Sans MS",Font.BOLD,24));
		lblFunctionsForPredictive.setBounds(84, 11, 263, 34);
		getContentPane().add(lblFunctionsForPredictive);
		
		btnNewButton = new JButton("Call Setup Failure Analysis");
		btnNewButton.setBounds(40, 111, 168, 29);
		btnNewButton.setBackground(Color.YELLOW);
		//btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(this);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("MOS");
		btnNewButton_1.setBounds(243, 111, 168, 29);
		btnNewButton_1.setBackground(Color.YELLOW);
		//btnNewButton.setOpaque(true);
		btnNewButton_1.addActionListener(this);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Call Time Failure Anaysis");
		btnNewButton_2.setBounds(40, 166, 168, 29);
		btnNewButton_2.setBackground(Color.YELLOW);
		//btnNewButton_2.setOpaque(true);
		btnNewButton_2.addActionListener(this);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Rain");
		btnNewButton_3.setBackground(Color.YELLOW);
		//btnNewButton_3.setOpaque(true);
		btnNewButton_3.setBounds(243, 169, 168, 23);
		btnNewButton_3.addActionListener(this);
		getContentPane().add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("CSSR");
		btnNewButton_4.setBackground(Color.YELLOW);
		//btnNewButton_4.setOpaque(true);
		btnNewButton_4.setBounds(40, 215, 168, 23);
		btnNewButton_4.addActionListener(this);
		getContentPane().add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("CDR");
		btnNewButton_5.setBackground(Color.YELLOW);
		//btnNewButton_5.setOpaque(true);
		btnNewButton_5.setBounds(243, 215, 168, 23);
		btnNewButton_5.addActionListener(this);
		getContentPane().add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("TCH");
		btnNewButton_6.setBackground(Color.YELLOW);
		//btnNewButton_6.setOpaque(true);
		btnNewButton_6.setBounds(150, 249, 168, 23);
		btnNewButton_6.addActionListener(this);
		getContentPane().add(btnNewButton_6);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		//btnExit.setOpaque(true);
		btnExit.addActionListener(this);
		btnExit.setBounds(186, 293, 89, 35);
		getContentPane().add(btnExit);
		
		JLabel lblLl = new JLabel("Predictive Analysis",SwingConstants.CENTER);
		lblLl.setFont(new Font("Comic Sans MS",Font.BOLD,24));
		lblLl.setBounds(94, 48, 253, 33);
		getContentPane().add(lblLl);
		
		
	}
}
