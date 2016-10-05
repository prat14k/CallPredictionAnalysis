import java.awt.Canvas;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.apache.poi.ss.usermodel.Font;
import org.jfree.ui.RefineryUtilities;

import javax.swing.JButton;


public class MainWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 5980844090784956682L;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow("Predictive Analysis");
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JButton btnExit;
	public JButton btnNext;

	/**
	 * Create the application.
	 */
	public MainWindow(String str) {
		super(str);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Container c = getContentPane();
		c.setLayout(null);
		setBounds(50, 100, 750, 670);
		
		JLabel lblSubmittedTo = new JLabel("Submitted To :-");
		lblSubmittedTo.setFont(new java.awt.Font("Comic Sans MS",Font.BOLDWEIGHT_BOLD,23));
		lblSubmittedTo.setBounds(520, 374, 168, 46);
		c.add(lblSubmittedTo);
		
		JLabel lblHeading = new JLabel("Heading", SwingConstants.CENTER);
		lblHeading.setFont(new java.awt.Font("Monotype Corsiva",Font.BOLDWEIGHT_BOLD,33));
		lblHeading.setBounds(110, 31, 514, 63);
		c.add(lblHeading);
		
		JLabel lblSubmittedBy = new JLabel("Submitted By :-");
		lblSubmittedBy.setFont(new java.awt.Font("Comic Sans MS",Font.BOLDWEIGHT_BOLD,22));
		lblSubmittedBy.setBounds(29, 375, 179, 46);
		c.add(lblSubmittedBy);
		
		JLabel lblXyz = new JLabel("XYZ (1210)");
		lblXyz.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz.setBounds(81, 432, 118, 27);
		c.add(lblXyz);
		
		JLabel lblXyz_1 = new JLabel("XYZ(1210)");
		lblXyz_1.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz_1.setBounds(81, 470, 118, 27);
		c.add(lblXyz_1);
		
		JLabel lblXyz_2 = new JLabel("XYZ(1210)");
		lblXyz_2.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz_2.setBounds(81, 508, 118, 32);
		c.add(lblXyz_2);
		
		JLabel lblXyz_3 = new JLabel("XYZ(1210)");
		lblXyz_3.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz_3.setBounds(81, 551, 118, 27);
		c.add(lblXyz_3);
		
		MyCanvas m=new MyCanvas();
		m.setSize(222, 275);
		m.setLocation(272,100);
		c.add(m);
		
		JLabel lblXyz_4 = new JLabel("XYZ");
		lblXyz_4.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz_4.setBounds(594, 432, 79, 27);
		c.add(lblXyz_4);
		
		JLabel lblXyz_5 = new JLabel("XYZ");
		lblXyz_5.setFont(new java.awt.Font("Times New Roman",java.awt.Font.PLAIN,13));
		lblXyz_5.setBounds(594, 470, 79, 27);
		c.add(lblXyz_5);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new java.awt.Font("Harrington",java.awt.Font.BOLD,16));
		btnNext.setBounds(257, 562, 99, 46);
		btnNext.addActionListener(this);
		c.add(btnNext);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new java.awt.Font("Harrington",java.awt.Font.BOLD,16));
		btnExit.setBounds(402, 562, 107, 46);
		btnExit.addActionListener(this);
		c.add(btnExit);
		
		RefineryUtilities.centerFrameOnScreen(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnExit){
			this.dispose();
			System.exit(0);
		}
		else if(e.getSource() == btnNext){
			new FunctionList("Functions");
		}
	}
}


class MyCanvas extends Canvas
{
	private static final long serialVersionUID = 8861118917278931969L;
	Image i;
	MyCanvas()
	{
		Toolkit t=Toolkit.getDefaultToolkit();
		i=t.getImage("E:\\codes\\java\\eclipse\\excel\\src\\logo.png");
	}
	public void paint(Graphics g)
	{
		g.drawImage(i,0,0,200 ,250,this);
	}
} 




