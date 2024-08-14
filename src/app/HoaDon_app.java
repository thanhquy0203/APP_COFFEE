package app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.ChiTietHoaDon_DAO;
import DAO.DoUong_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.The_DAO;
import Entity.ChiTietHoaDon;
import Entity.DoUong;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.The;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;

public class HoaDon_app extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container sideMenu;
	private JComboBox day;
	private JComboBox month;
	private JComboBox year;
	private JButton tim;
	private JPanel panel_2;
	private JTable table;
	private DefaultTableModel modelTable;
	private HoaDon_DAO hd_dao;
	private ChiTietHoaDon_DAO cthd_dao;
	private JPanel panel_3;
	private JComboBox cboHD;
	private JComboBox cboKH;
	private JComboBox cboDU;
	private JComboBox cboNV;
	private KhachHang_DAO kh_dao;
	private DoUong_DAO du_dao;
	private NhanVien_DAO nv_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon_app frame = new HoaDon_app();
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
	public HoaDon_app() {
		setTitle("Danh sách hóa đơn");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		hd_dao=new HoaDon_DAO();
		cthd_dao=new ChiTietHoaDon_DAO();
		kh_dao = new KhachHang_DAO();
		du_dao = new DoUong_DAO();
		nv_dao = new NhanVien_DAO();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1662, 907);
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
				ThanhToan app2 = new ThanhToan();
				app2.setVisible(true);
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
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 74, 388, 52);
		body.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("  Khách hàng");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				KhachHang_app app0 = new KhachHang_app();
				app0.setVisible(true);
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
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NguyenLieu_app app3 = new NguyenLieu_app();
				app3.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.GRAY);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(0, 200, 388, 52);
		body.add(lblNewLabel_6);
		
		JPanel foot = new JPanel();
		foot.setBorder(null);
		foot.setBackground(Color.DARK_GRAY);
		foot.setBounds(0, 587, 388, 215);
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
		lblNewLabel_7.setBounds(0, 152, 388, 52);
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
		
		panel_3 = new JPanel();
		panel_3.setBounds(388, 69, 289, 799);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("Mã hóa đơn :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 11, 269, 25);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Mã khách hàng :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(10, 83, 269, 25);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Ngày bán :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 155, 269, 25);
		panel_3.add(lblNewLabel_12);
		
		day = new JComboBox();
		day.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		day.setBounds(10, 191, 81, 25);
		panel_3.add(day);
		
		month = new JComboBox();
		month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCalender();
			}
		});
		month.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		month.setBounds(101, 191, 81, 25);
		panel_3.add(month);
		
		year = new JComboBox();
		year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCalender();
			}
		});
		year.setModel(new DefaultComboBoxModel(new String[] {"Tất cả", "2023", "2024"}));
		year.setBounds(192, 191, 87, 25);
		panel_3.add(year);
		
		JLabel lblNewLabel_13 = new JLabel("Mã đồ uống :");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(10, 227, 269, 25);
		panel_3.add(lblNewLabel_13);
		
		cboDU = new JComboBox();
		cboDU.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cboDU.setBounds(10, 263, 269, 25);
		ArrayList<DoUong> listdu = du_dao.getAllTableDoUong();
		for (DoUong du : listdu) {
			cboDU.addItem(du.getMaDoUong());
		}
		panel_3.add(cboDU);
		
		JLabel lblNewLabel_14 = new JLabel("Mã nhân viên :");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(10, 299, 269, 25);
		panel_3.add(lblNewLabel_14);
		
		cboNV = new JComboBox();
		cboNV.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cboNV.setBounds(10, 335, 269, 25);
		ArrayList<NhanVien> listnv = nv_dao.getAllTableNhanVien();
		for (NhanVien nv : listnv) {
			cboNV.addItem(nv.getMaNhanVien());
		}
		panel_3.add(cboNV);
		
		tim = new JButton("Tìm");
		tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				int ngay;
				int thang;
				int nam;
				if(day.getSelectedIndex()!=0) {
					ngay = Integer.parseInt(day.getSelectedItem().toString());
				}else {
					ngay = 0;
				}
				if(month.getSelectedIndex()!=0) {
					thang = Integer.parseInt(month.getSelectedItem().toString());
				}else {
					thang = 0;
				}
				if(year.getSelectedIndex()!=0) {
					nam = Integer.parseInt(year.getSelectedItem().toString());
				}else {
					nam = 0;
				}
				String nv;
				if(cboNV.getSelectedIndex()!=0) {
					nv = cboNV.getSelectedItem().toString();
				}else {
					nv = null;
				}
				String kh;
				if(cboKH.getSelectedIndex()!=0) {
					kh = cboKH.getSelectedItem().toString();
				}else {
					kh = null;
				}
				String hd;
				if(cboHD.getSelectedIndex()!=0) {
					hd = cboHD.getSelectedItem().toString();
				}else {
					hd = null;
				}
				String du;
				if(cboDU.getSelectedIndex()!=0) {
					du = cboDU.getSelectedItem().toString();
				}else {
					du = null;
				}
				search(ngay,thang,nam,nv,kh,hd,du);
			}
		});
		tim.setBackground(new Color(255, 0, 0));
		tim.setForeground(new Color(255, 255, 255));
		tim.setOpaque(true);
		tim.setFont(new Font("Tahoma", Font.BOLD, 20));
		tim.setBounds(10, 710, 269, 78);
		panel_3.add(tim);
		
		cboHD = new JComboBox();
		cboHD.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cboHD.setBounds(10, 47, 269, 25);
		ArrayList<HoaDon> listhd = hd_dao.getAllTableHoaDon();
		for (HoaDon hd : listhd) {
			cboHD.addItem(hd.getMaHoaDon());
		}
		panel_3.add(cboHD);
		
		cboKH = new JComboBox();
		cboKH.setModel(new DefaultComboBoxModel(new String[] {"Tất cả"}));
		cboKH.setBounds(10, 119, 269, 25);
		ArrayList<KhachHang> listkh = kh_dao.getAllTableKhachHang();
		for (KhachHang kh : listkh) {
			cboKH.addItem(kh.getMaKhachHang());
		}
		panel_3.add(cboKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(687, 80, 949, 777);
		panel_1.add(scrollPane);
		String[] colHeader = { "Mã hóa đơn", "Tổng tiền", "Ngày bán","Mã nhân viên","Mã khách hàng","Số thẻ","Mã đồ uống","Số lượng","Đơn giá"};
		modelTable = new DefaultTableModel(colHeader, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		table = new JTable(modelTable);
		scrollPane.setViewportView(table);
		table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane.setColumnHeader(new JViewport() {
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table.setRowHeight(table.getRowHeight()+10);
		docDuLieuDatabaseVaoTable();
	}
	
	void checkCalender() {
		String[] monthsHave30 = {"4", "6", "9", "11"};
		String[] monthsHave31 = {"1", "3", "5", "7","8","10","12"};
		if(year.getSelectedItem().toString().equals("2024") && month.getSelectedItem().toString().equals("2")) {
			String index = day.getSelectedItem().toString();
			day.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
			day.setSelectedItem(index);
		} else if (year.getSelectedItem().toString().equals("2023") && month.getSelectedItem().toString().equals("2")) {
			String index = day.getSelectedItem().toString();
			day.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"}));
			day.setSelectedItem(index);
		} else if (Arrays.asList(monthsHave30).contains(month.getSelectedItem().toString())) {
			String index = day.getSelectedItem().toString();
			day.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29","30"}));
			day.setSelectedItem(index);
		} else if (Arrays.asList(monthsHave31).contains(month.getSelectedItem().toString())) {
			String index = day.getSelectedItem().toString();
			day.setModel(new DefaultComboBoxModel(new String[] {"Tất cả","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28","29","30","31"}));
			day.setSelectedItem(index);
		}
	}
	
	private void docDuLieuDatabaseVaoTable() {
		List<HoaDon> listhd = hd_dao.getAllTableHoaDon();
		for (HoaDon hd: listhd) {
			List<ChiTietHoaDon> listct = cthd_dao.getAllTableChiTietHoaDonByHoaDon(hd.getMaHoaDon());
			for (ChiTietHoaDon cthd : listct) {
				modelTable.addRow(new Object[] {hd.getMaHoaDon(),hd.getTongTien(),hd.getNgayBan(),hd.getMaNhanVien().getMaNhanVien(),hd.getMaKhachHang().getMaKhachHang(),hd.getSoThe().getSoThe(),cthd.getMaDoUong().getMaDoUong(),cthd.getSoLuong(),cthd.getDonGia()});
			}
		}
	}
	
	private void search(int ngay, int thang, int nam, String nv,String kh,String hd,String du) {
		List<HoaDon> listhd = hd_dao.search(ngay, thang, nam, nv,kh,hd);
		for (HoaDon hd1 : listhd) {
			List<ChiTietHoaDon> listct = cthd_dao.search(hd, du,hd1.getMaHoaDon());
			for (ChiTietHoaDon ct1 : listct) {
				modelTable.addRow(new Object[] {hd1.getMaHoaDon(),hd1.getTongTien(),hd1.getNgayBan(),hd1.getMaNhanVien().getMaNhanVien(),hd1.getMaKhachHang().getMaKhachHang(),hd1.getSoThe().getSoThe(),ct1.getMaDoUong().getMaDoUong(),ct1.getSoLuong(),ct1.getDonGia()});
			}
		}
	}
}
