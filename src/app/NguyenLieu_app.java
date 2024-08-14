package app;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.NguyenLieu_DAO;
import Entity.NguyenLieu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class NguyenLieu_app extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel sideMenu;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JButton btnNewButton;
	private JPanel panel_2;
	private NguyenLieu_DAO nl_dao;
	private DefaultTableModel modelTable;
	private JButton btnNewButton1;
	private JTextField findma;
	private JButton btntimma;
	private JTextField findten;
	private JButton btntimTen;
	private DefaultComboBoxModel<String> donvicombobox;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NguyenLieu_app frame = new NguyenLieu_app();
					frame.setLocationRelativeTo(null);
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
	public NguyenLieu_app() {
		setTitle("Quản lí nguyên liệu");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		nl_dao=new NguyenLieu_DAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1435, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imageIcon = new ImageIcon(ThanhToan.class.getResource("/image/logo1.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(368, 239,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1646, 868);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		sideMenu = new JPanel();
		sideMenu.setBorder(null);
		sideMenu.setBackground(new Color(128, 128, 128));
		sideMenu.setBounds(0, 69, 388, 799);
		panel_1.add(sideMenu);
		sideMenu.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBorder(null);
		body.setBackground(Color.DARK_GRAY);
		body.setBounds(0, 261, 388, 326);
		sideMenu.add(body);
		body.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("  Bán hàng");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThanhToan app = new ThanhToan();
				app.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 11, 388, 52);
		body.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("  Hóa đơn");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDon_app app1 = new HoaDon_app();
				app1.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 74, 388, 52);
		body.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("  Khách hàng");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang_app app2 = new KhachHang_app();
				app2.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.GRAY);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(0, 137, 388, 52);
		body.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("  Nguyên liệu");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(0, 200, 388, 52);
		body.add(lblNewLabel_6);
		
		JPanel foot = new JPanel();
		foot.setBorder(null);
		foot.setBackground(Color.DARK_GRAY);
		foot.setBounds(0, 587, 388, 89);
		sideMenu.add(foot);
		foot.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("  Đăng xuất");
		lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Login.main(null);
			}
		});
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setOpaque(true);
		lblNewLabel_7.setBackground(Color.GRAY);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(0, 13, 388, 65);
		foot.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, -19, 388, 21);
		foot.add(separator);
		separator.setOpaque(true);
		separator.setBackground(Color.BLACK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 368, 239);
		sideMenu.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(imageIcon);
		lblNewLabel.setBounds(0, 0, 368, 239);
		panel_2.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 1646, 69);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Quán cà phê abc");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 37));
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(10, 11, 1626, 45);
		panel.add(lblNewLabel_8);
		
		panel_2 = new JPanel();
		panel_2.setBounds(388, 69, 298, 675);
		panel_2.setBackground(new Color(212, 212, 212));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Mã nguyên liệu :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 11, 135, 29);
		panel_2.add(lblNewLabel_10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 51, 278, 29);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Tên nguyên liệu :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(10, 91, 135, 29);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Số lượng");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 171, 135, 29);
		panel_2.add(lblNewLabel_12);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(10, 131, 278, 29);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_2.setBounds(10, 211, 278, 29);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Đơn vị");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_15.setBounds(10, 251, 135, 29);
		panel_2.add(lblNewLabel_15);
		
		String[] donVi = {"kg","chai","thùng","túi"};
		
//		donvicombobox = new DefaultComboBoxModel<String>(donVi);
		
		comboBox = new JComboBox<>(donVi);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox.setBounds(10, 291,  278, 29);
        panel_2.add(comboBox);
        
		JLabel lblNewLabel_13 = new JLabel("Tìm theo mã:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(10, 368, 278, 25);
		panel_2.add(lblNewLabel_13);

		findma = new JTextField();
		findma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		findma.setBounds(10, 404, 200, 25);
		panel_2.add(findma);
		findma.setColumns(10);

		btntimma = new JButton("Tìm");
		
		btntimma.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntimma.setBackground(new Color(8, 102, 255));
		btntimma.setForeground(new Color(255, 255, 255));
		btntimma.setBounds(220, 404, 70, 25);
		panel_2.add(btntimma);
		
		JLabel lblNewLabel_14 = new JLabel("Tìm theo tên:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(10, 444, 278, 25);
		panel_2.add(lblNewLabel_14);

		findten = new JTextField();
		findten.setFont(new Font("Tahoma", Font.PLAIN, 15));
		findten.setBounds(10, 480, 200, 25);
		panel_2.add(findten);
		findten.setColumns(10);

		btntimTen = new JButton("Tìm");
		btntimTen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntimTen.setBackground(new Color(8, 102, 255));
		btntimTen.setForeground(new Color(255, 255, 255));
		btntimTen.setBounds(220, 480, 70, 25);
		panel_2.add(btntimTen);
		
		btnNewButton = new JButton("Cập nhật");
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 584, 278, 50);
		panel_2.add(btnNewButton);
		
		btnNewButton1 = new JButton("Thêm");
		btnNewButton1.setBackground(new Color(255, 0, 0));
		btnNewButton1.setForeground(new Color(255, 255, 255));
		btnNewButton1.setOpaque(true);
		btnNewButton1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton1.setBounds(10, 520, 278, 50);
		panel_2.add(btnNewButton1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(696, 80, 723, 664);
		panel_1.add(scrollPane);
		
//		table = new JTable();
//		scrollPane.setViewportView(table);
		
		
		String[] colHeader = {"Mã nguyên liệu", "Tên Nguyên Liệu", "Số lượng", "Đơn vị"};
		modelTable = new DefaultTableModel(colHeader, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
		}
		};
		table = new JTable(modelTable);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		scrollPane.setColumnHeader(new JViewport() {
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table.setRowHeight(table.getRowHeight()+10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
		        if (row >= 0) {
		        	textField.setText((String)modelTable.getValueAt(row, 0));
		        	textField_1.setText((String)modelTable.getValueAt(row, 1));
		        	textField_2.setText(String.valueOf(modelTable.getValueAt(row, 2)));
		        	
		        	 String donViValue = (String) modelTable.getValueAt(row, 3);
		        	    int selectedIndex = -1;
		        	    for (int i = 0; i < donVi.length; i++) {
		        	        if (donVi[i].equals(donViValue)) {
		        	            selectedIndex = i;
		        	            break;
		        	        }
		        	    }
		        	    comboBox.setSelectedIndex(selectedIndex);

		        }
			}
		});
		docDuLieuDatabaseVaoTable();
		btnNewButton.addActionListener(this);
		btnNewButton1.addActionListener(this);
		btntimma.addActionListener(this);
		btntimTen.addActionListener(this);
	}
	
	private void docDuLieuDatabaseVaoTable() {
		List<NguyenLieu> list = nl_dao.getAllTableNguyenLieu();
		for (NguyenLieu nl:list) {
			modelTable.addRow(new Object[] {nl.getMaNguyenLieu(), nl.getTenNguyenLieu(), nl.getSoLuong(), nl.getDonVi()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNewButton1)) {
			String ma = textField.getText();
			String ten = textField_1.getText();
			int soluong = Integer.parseInt(textField_2.getText());
			String donVi = (String) comboBox.getSelectedItem();
			
			NguyenLieu nl = new NguyenLieu(ma, ten, soluong, donVi);
			try {
				nl_dao.create(nl);
				modelTable.addRow(new Object[] {
						nl.getMaNguyenLieu(), nl.getTenNguyenLieu(),nl.getSoLuong(), nl.getDonVi()
						
				});
				textField.requestFocus();
				
				;
			}catch (Exception e1) {
				
				JOptionPane.showMessageDialog(this, "Trung");
			}
		}
		
		if(o.equals(btnNewButton)) {
			String ma = textField.getText();
			String ten = textField_1.getText();
			int soluong = Integer.parseInt(textField_2.getText());
			String donVi = (String) comboBox.getSelectedItem();
			
			NguyenLieu nl = new NguyenLieu(ma, ten, soluong, donVi);
			
			if(nl_dao.update(nl)) {
				int row = table.getSelectedRow();
				modelTable.setValueAt(nl.getMaNguyenLieu(), row, 0);
				modelTable.setValueAt(nl.getTenNguyenLieu(), row, 1);
				modelTable.setValueAt(nl.getSoLuong()+ Integer.parseInt(modelTable.getValueAt(row, 2).toString()), row, 2);
				modelTable.setValueAt(nl.getDonVi(), row, 3);
				JOptionPane.showMessageDialog(null, "Cap nhat thanh cong");
				
			}
		}
		

		if(o.equals(btntimma)) {
		    String ma = findma.getText(); 
		    if(ma.trim().equals("")) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập mã cần tìm");
		        xoaRong();
		        findma.requestFocus();
		        return;
		    }
		    int row = table.getRowCount();
		    for(int i = 0; i < row; i++) {
		        if(modelTable.getValueAt(i, 0).toString().equals(ma)) {
		            table.setRowSelectionInterval(i, i);
		            textField.setText(modelTable.getValueAt(i, 0).toString());
		            textField_1.setText(modelTable.getValueAt(i, 1).toString());
		            textField_2.setText(modelTable.getValueAt(i, 2).toString());
		            String donVi = modelTable.getValueAt(i, 3).toString();
		            comboBox.setSelectedItem(donVi);
		            table.scrollRectToVisible(table.getCellRect(i, 0, true));	
		            return;
		        }
		    }
		    JOptionPane.showMessageDialog(this, "Không tìm thấy mã nguyên liệu");
		}
		if (o.equals(btntimTen)) {
		    String ten = findten.getText();
		    if (ten.trim().equals("")) {
		        JOptionPane.showMessageDialog(this, "Vui lòng nhập tên cần tìm");
		        findten.requestFocus();
		        return;
		    }
		    int row = table.getRowCount(); 
		    for (int i = 0; i < row; i++) {
		        if (modelTable.getValueAt(i, 1).toString().contains(ten)) {
		            table.setRowSelectionInterval(i, i);
		    
		            textField.setText(modelTable.getValueAt(i, 0).toString());
		            textField_1.setText(modelTable.getValueAt(i, 1).toString());
		            textField_2.setText(modelTable.getValueAt(i, 2).toString());
		            String donVi = modelTable.getValueAt(i, 3).toString();
		            comboBox.setSelectedItem(donVi);
		            table.scrollRectToVisible(table.getCellRect(i, 0, true));
		            return;
		        }
		    }
		    JOptionPane.showMessageDialog(this, "Không tìm thấy tên nguyên liệu");
		}


	}
	
	

	private void xoaRong() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}
	
	
	
	//phương thức đóng menu
	protected void closeMenuBar() {
		int width = 228;
		int height = 763;
		for (Component component : panel_2.getComponents()) {
	        component.setEnabled(true);
		}
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = width;i>0;i--) {
					sideMenu.setSize(i,height);
					btnNewButton.setEnabled(true);
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
	}



	
}
