package proje1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.ParseConversionEvent;

import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;

public class AnaFrm extends JFrame {

	private JPanel contentPane;
	public JTextField txtX;
	public JTextField txtY;
	public JTable table;
	JLabel maliyetlabel = new JLabel("");
	Islemler dugum = new Islemler(this);
	public Object [][] data = {{"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},};
	
	public Object [][] data2 = {{"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},
            {"","","","","","","","","","","","","","","","","","","",""},};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnaFrm frame = new AnaFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnaFrm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.3);
		contentPane.add(splitPane);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(null);
		
		JLabel lblDugumGiriniz = new JLabel("D\u00FCg\u00FCm Giriniz:");
		lblDugumGiriniz.setBounds(0, 59, 93, 14);
		panel.add(lblDugumGiriniz);
		
		txtX = new JTextField();
		txtX.setBounds(103, 56, 44, 20);
		panel.add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setColumns(10);
		txtY.setBounds(157, 56, 44, 20);
		panel.add(txtY);
		
		JLabel lblX = new JLabel("--Y--");
		lblX.setBounds(103, 31, 44, 14);
		panel.add(lblX);
		
		JLabel lblY = new JLabel("--X--");
		lblY.setBounds(161, 31, 40, 14);
		panel.add(lblY);
		
		JButton btnDmEkle = new JButton("D\u00FC\u011F\u00FCm Ekle");
		btnDmEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				int x=Integer.parseInt(txtX.getText());
				int y=Integer.parseInt(txtY.getText());			
				
				txtX.setText("");
				txtY.setText("");
				
				dugum.DugumEkle(x,y);
			
	           
				table.setGridColor(Color.green);
			 
				
				
	           for(int i=dugum.son-1;i>=0;i--)
	           {
		             
	        	   data[dugum.koordinatlar[i][0]][dugum.koordinatlar[i][1]]="D"+i;
	        	  
	        	   
	           }
	table.setModel(new DefaultTableModel(data,new String[] {"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"}
	));
	table.setBounds(36, 33, 419, 320);
				
				
				
				
				
			}
		});
		btnDmEkle.setBounds(86, 99, 115, 23);
		panel.add(btnDmEkle);
		
		JButton btnAacGr = new JButton("A\u011Fac\u0131 G\u00F6r");
		btnAacGr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				//txtMaliyet.setText(dugum.maliyetler[]);
			dugum.maliyet();
			dugum.yol();
			maliyetlabel.setText(""+dugum.maliyet_hesapla());
			
	
			}
		});
		btnAacGr.setBounds(10, 210, 89, 23);
		panel.add(btnAacGr);
		
		JLabel lblNewLabel = new JLabel("Maliyet-->");
		lblNewLabel.setBounds(103, 214, 64, 14);
		panel.add(lblNewLabel);
		
		
		maliyetlabel.setBounds(177, 214, 24, 14);
		panel.add(maliyetlabel);
		
		JLabel lblBr = new JLabel("br");
		lblBr.setBounds(212, 214, 24, 14);
		panel.add(lblBr);
		
		
	
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "A\u011Fac\u0131n G\u00F6sterimi", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(null);
		
		
		table = new JTable();
		panel_1.add(table);
		
		JLabel label = new JLabel("0");
		label.setBounds(41, 21, 11, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(62, 21, 11, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("2");
		label_2.setBounds(83, 21, 11, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("3");
		label_3.setBounds(104, 21, 11, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("4");
		label_4.setBounds(125, 21, 11, 14);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("5");
		label_5.setBounds(147, 21, 11, 14);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("6");
		label_6.setBounds(168, 21, 11, 14);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("7");
		label_7.setBounds(189, 21, 11, 14);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("8");
		label_8.setBounds(210, 21, 11, 14);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("9");
		label_9.setBounds(231, 21, 11, 14);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("10");
		label_10.setBounds(248, 21, 18, 14);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("11");
		label_11.setBounds(265, 21, 18, 14);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("12");
		label_12.setBounds(286, 21, 18, 14);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("13");
		label_13.setBounds(307, 21, 18, 14);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("14");
		label_14.setBounds(334, 21, 18, 14);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("15");
		label_15.setBounds(353, 21, 18, 14);
		panel_1.add(label_15);
		
		JLabel label_16 = new JLabel("16");
		label_16.setBounds(377, 21, 18, 14);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("17");
		label_17.setBounds(398, 21, 18, 14);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("18");
		label_18.setBounds(419, 21, 18, 14);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("19");
		label_19.setBounds(440, 21, 18, 14);
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("0");
		label_20.setBounds(21, 32, 11, 14);
		panel_1.add(label_20);
		
		JLabel label_21 = new JLabel("1");
		label_21.setBounds(21, 49, 11, 14);
		panel_1.add(label_21);
		
		JLabel label_22 = new JLabel("2");
		label_22.setBounds(21, 65, 11, 20);
		panel_1.add(label_22);
		
		JLabel label_23 = new JLabel("3");
		label_23.setBounds(21, 80, 11, 20);
		panel_1.add(label_23);
		
		JLabel label_24 = new JLabel("4");
		label_24.setBounds(21, 96, 11, 14);
		panel_1.add(label_24);
		
		JLabel label_25 = new JLabel("5");
		label_25.setBounds(21, 111, 11, 14);
		panel_1.add(label_25);
		
		JLabel label_26 = new JLabel("6");
		label_26.setBounds(21, 129, 11, 14);
		panel_1.add(label_26);
		
		JLabel label_27 = new JLabel("7");
		label_27.setBounds(21, 148, 11, 14);
		panel_1.add(label_27);
		
		JLabel label_28 = new JLabel("8");
		label_28.setBounds(21, 161, 11, 14);
		panel_1.add(label_28);
		
		JLabel label_29 = new JLabel("9");
		label_29.setBounds(21, 173, 11, 20);
		panel_1.add(label_29);
		
		JLabel label_30 = new JLabel("10");
		label_30.setBounds(21, 193, 18, 14);
		panel_1.add(label_30);
		
		JLabel label_31 = new JLabel("11");
		label_31.setBounds(21, 209, 18, 14);
		panel_1.add(label_31);
		
		JLabel label_32 = new JLabel("12");
		label_32.setBounds(21, 227, 18, 14);
		panel_1.add(label_32);
		
		JLabel label_33 = new JLabel("13");
		label_33.setBounds(21, 239, 18, 20);
		panel_1.add(label_33);
		
		JLabel label_34 = new JLabel("14");
		label_34.setBounds(21, 252, 18, 20);
		panel_1.add(label_34);
		
		JLabel label_35 = new JLabel("15");
		label_35.setBounds(21, 270, 18, 20);
		panel_1.add(label_35);
		
		JLabel label_36 = new JLabel("16");
		label_36.setBounds(21, 291, 18, 14);
		panel_1.add(label_36);
		
		JLabel label_37 = new JLabel("17");
		label_37.setBounds(21, 306, 18, 14);
		panel_1.add(label_37);
		
		JLabel label_38 = new JLabel("18");
		label_38.setBounds(21, 323, 18, 14);
		panel_1.add(label_38);
		
		JLabel label_39 = new JLabel("19");
		label_39.setBounds(21, 337, 18, 16);
		panel_1.add(label_39);
		
	}
}
