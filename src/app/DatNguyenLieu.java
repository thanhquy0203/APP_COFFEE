package app;
import Entity.NguyenLieu;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.NguyenLieu_DAO;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class DatNguyenLieu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container sideMenu;
	private JTextField nhapSL;
	private JTextField textField;
	private NguyenLieu_DAO nl_dao;
	private JComboBox<String> comboBox;
	private DefaultTableModel modelTable;
	private JTable table;
	private JComboBox<String> comboBox2;
	private JButton dat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatNguyenLieu frame = new DatNguyenLieu();
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
	public DatNguyenLieu() {
		setTitle("Đặt nguyên liệu");
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
		sideMenu.setBackground(new Color(128, 128, 128));
		sideMenu.setBounds(0, 69, 388, 675);
		panel_1.add(sideMenu);
		sideMenu.setLayout(null);
		
		JPanel body = new JPanel();
		body.setBorder(null);
		body.setBackground(Color.DARK_GRAY);
		body.setBounds(0, 261, 388, 326);
		sideMenu.add(body);
		body.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("  Thống kê hóa đơn");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ThongKeHoaDon app = new ThongKeHoaDon();
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
		
		JLabel lblNewLabel_3 = new JLabel("  Đặt nguyên liệu");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(0, 74, 388, 52);
		body.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("  Tài khoản nhân viên");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NhanVien_app app2 = new NhanVien_app();
				app2.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 137, 388, 52);
		body.add(lblNewLabel_4);
		
		JPanel foot = new JPanel();
		foot.setBorder(null);
		foot.setBackground(Color.DARK_GRAY);
		foot.setBounds(0, 587, 388, 88);
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
		lblNewLabel_7.setBounds(0, 11, 388, 66);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(388, 69, 228, 675);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nguyên liệu :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 140, 37);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số lượng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 103, 140, 37);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn vị");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 195, 140, 37);
		panel_3.add(lblNewLabel_1_1_1);
		
		nhapSL = new JTextField();
		nhapSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapSL.setColumns(10);
		nhapSL.setBounds(10, 151, 202, 33);
		panel_3.add(nhapSL);
		
		comboBox = new JComboBox<String>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(10, 59, 202, 33);
		panel_3.add(comboBox);
		docDuLieuDatacbb("tenNguyenLieu");
		
		comboBox2 = new JComboBox<String>();
		comboBox2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox2.setBounds(10, 243, 202, 33);
		panel_3.add(comboBox2);
		docDuLieuDatacbb("donVi");
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Đường") || comboBox.getSelectedItem().equals("Cà chua") ||comboBox.getSelectedItem().equals("Cà rốt") || comboBox.getSelectedItem().equals("Socola") || comboBox.getSelectedItem().equals("Hạt cà phê"))
					comboBox2.setSelectedIndex(1);
				else if(comboBox.getSelectedItem().equals("Sữa Tươi") || comboBox.getSelectedItem().equals("Cream") ||comboBox.getSelectedItem().equals("Bột kem") || comboBox.getSelectedItem().equals("Sữa đặc") || comboBox.getSelectedItem().equals("Siro"))
					comboBox2.setSelectedIndex(0);
				else if(comboBox.getSelectedItem().equals("Nước Ngọt") || comboBox.getSelectedItem().equals("Đá") ||comboBox.getSelectedItem().equals("Sữa chua"))
					comboBox2.setSelectedIndex(2);
				else if(comboBox.getSelectedItem().equals("Bột sữa") || comboBox.getSelectedItem().equals("Cacao") ||comboBox.getSelectedItem().equals("Trà sen"))
					comboBox2.setSelectedIndex(3);
			}
		});
		
		dat = new JButton("Đặt");
		dat.setForeground(Color.WHITE);
		dat.setFont(new Font("Tahoma", Font.BOLD, 20));
		dat.setBackground(Color.RED);
		dat.setBounds(10, 586, 202, 78);
		panel_3.add(dat);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(10, 535, 155, 20);
		textField.setVisible(false);
		panel_3.add(textField);
		textField.setColumns(10);
		
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
		        	comboBox.setSelectedIndex(row);
		        }
			}
		});
		docDuLieuDatabaseVaoTable();
		dat.addActionListener(this);
	}
	
	private void docDuLieuDatacbb(String type) {
		if (type.equals("tenNguyenLieu")) {
			List<NguyenLieu> list = nl_dao.getAllTableNguyenLieu();
			for (NguyenLieu nv : list) {
				comboBox.addItem(nv.getTenNguyenLieu());
		    }
        } else if (type.equals("donVi")) {
        	List<String> list = nl_dao.getDonVi();
        	for (String nl : list) {
				comboBox2.addItem(nl);
		    }
        }
	}

	
	private void docDuLieuDatabaseVaoTable() {
		List<NguyenLieu> list = nl_dao.getAllTableNguyenLieu();
		for (NguyenLieu nl:list) {
			modelTable.addRow(new Object[] {nl.getMaNguyenLieu(), nl.getTenNguyenLieu(), nl.getSoLuong(), nl.getDonVi()});
		}
	}

	@Override
		public void actionPerformed(ActionEvent e) {
			Object o =e.getSource();
			if(o.equals(dat)) {
				String soluong = nhapSL.getText();
				   if (!soluong.isEmpty()) { 
				        try {
				            int sl = Integer.parseInt(soluong);
				            String ma = textField.getText();
							String ten = (String) comboBox.getSelectedItem();
							String donVi = (String) comboBox2.getSelectedItem();
							
							NguyenLieu nl = new NguyenLieu(ma, ten, sl, donVi);
							
							if(nl_dao.datNL(nl)) {
								int row = table.getSelectedRow();
								
								modelTable.setValueAt(nl.getSoLuong()+ Integer.parseInt(modelTable.getValueAt(row, 2).toString()), row, 2);
								
								JOptionPane.showMessageDialog(null, "Cap nhat thanh cong");
								nhapSL.setText("");
							}
				        } catch (Exception e1) {
				            JOptionPane.showMessageDialog(this, "Số lượng là số");
				        }
				    } else {
				    	JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
				        
				    }
			}
			
	}
}
