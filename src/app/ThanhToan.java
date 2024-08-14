package app;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class ThanhToan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel sideMenu;
	private JTable table_1;
	private JTable table;
	private JTable table2;
	private DoUong_DAO du_dao;
	private DefaultTableModel modelTable;
	private DefaultTableModel modelTable2;
	private DefaultTableModel modelTable_1;
	private JTextField nhapHD;
	private JTextField nhapNV;
	private JTextField nhapTongTien;
	private JTextField nhapSDT;
	private JTextField nhapVAT;
	private JTextField nhapThanhTien;
	private JTextField nhapTienDua;
	private JTextField nhapTienThoi;
	private JTextField nhapNgay;
	private JTextField nhapLoai;
	private JTextField nhapGiam;
	private HoaDon_DAO hd_dao;
	private NhanVien_DAO nv_dao;
	private KhachHang_DAO kh_dao;
	private JTextField nhapTenKH;
	private JTextField nhapTienGiam;
	private JLabel lblClock;
	private ChiTietHoaDon_DAO cthd_dao;
	private The_DAO the_dao;
	private DefaultTableModel modelTable3;
	private JTable table3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThanhToan frame = new ThanhToan();
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
	public ThanhToan() {
		setTitle("Bán hàng");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		du_dao=new DoUong_DAO();
		hd_dao=new HoaDon_DAO();
		nv_dao=new NhanVien_DAO();
		kh_dao=new KhachHang_DAO();
		cthd_dao=new ChiTietHoaDon_DAO();
		the_dao = new The_DAO();
		
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
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 534, 404);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JTextArea hoaDon = new JTextArea();
		hoaDon.setBounds(10, 11, 520, 385);
		hoaDon.setFont(new Font("Monospaced", Font.BOLD, 18));
		panel_7.add(hoaDon);
		panel_7.setVisible(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1646, 868);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		sideMenu = new JPanel();
		sideMenu.setBorder(null);
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
		
		JLabel lblNewLabel_2 = new JLabel("  Bán hàng");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 11, 388, 52);
		body.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("  Hóa đơn");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HoaDon_app app = new HoaDon_app();
				app.setVisible(true);
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
				KhachHang_app app1 = new KhachHang_app();
				app1.setVisible(true);
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
				NguyenLieu_app app2 = new NguyenLieu_app();
				app2.setVisible(true);
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
		
		lblClock = new JLabel("Clock");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblClock.setBounds(10, 11, 358, 45);
		panel.add(lblClock);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240,240,240));
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 2), "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 15), new Color(0, 0, 0)));
		panel_3.setBounds(987, 385, 432, 272);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã HD :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 19, 105, 17);
		panel_3.add(lblNewLabel_1);
		
		nhapHD = new JTextField();
		nhapHD.setEditable(false);
		nhapHD.setBounds(115, 16, 96, 20);
		panel_3.add(nhapHD);
		nhapHD.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã NV :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(202, 19, 105, 17);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng tiền :");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(202, 55, 105, 17);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("SĐT KH :");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(0, 91, 105, 17);
		panel_3.add(lblNewLabel_1_2_1);
		
		nhapNV = new JTextField();
		nhapNV.setEditable(false);
		nhapNV.setColumns(10);
		nhapNV.setBounds(317, 16, 96, 20);
		panel_3.add(nhapNV);
		
		nhapTongTien = new JTextField();
		nhapTongTien.setEditable(false);
		nhapTongTien.setColumns(10);
		nhapTongTien.setBounds(317, 52, 96, 20);
		nhapTongTien.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatTienGiam();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatTienGiam();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel_3.add(nhapTongTien);
		
		nhapSDT = new JTextField();
		nhapSDT.setColumns(10);
		nhapSDT.setBounds(115, 90, 96, 20);
		nhapSDT.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				List<KhachHang> listkh = kh_dao.getAllTableKhachHang();
				for(KhachHang kh : listkh) {
					if(kh.getSoDienThoai().equalsIgnoreCase(nhapSDT.getText())) {
						nhapTenKH.setText(kh.getTenKhachHang());
						if(kh.getDiemTichLuy() >=30 && kh.getDiemTichLuy() < 100) {
							nhapLoai.setText("Bậc đồng");
							break;
						}
						if(kh.getDiemTichLuy() >= 100 && kh.getDiemTichLuy() < 300) {
							nhapLoai.setText("Bậc bạc");
							break;
						}
						if(kh.getDiemTichLuy() > 300 && kh.getDiemTichLuy() < 800) {
							nhapLoai.setText("Bậc vàng");
							break;
						}
						if(kh.getDiemTichLuy() >= 800) {
							nhapLoai.setText("Bậc kim cương");
							break;
						}
					} else {
						nhapLoai.setText("");
						nhapTenKH.setText("");
					}
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				List<KhachHang> listkh = kh_dao.getAllTableKhachHang();
				for(KhachHang kh : listkh) {
					if(kh.getSoDienThoai().equalsIgnoreCase(nhapSDT.getText())) {
						nhapTenKH.setText(kh.getTenKhachHang());
						if(kh.getDiemTichLuy() >=30 && kh.getDiemTichLuy() < 100) {
							nhapLoai.setText("Bậc đồng");
							break;
						}
						if(kh.getDiemTichLuy() >= 100 && kh.getDiemTichLuy() < 300) {
							nhapLoai.setText("Bậc bạc");
							break;
						}
						if(kh.getDiemTichLuy() > 300 && kh.getDiemTichLuy() < 800) {
							nhapLoai.setText("Bậc vàng");
							break;
						}
						if(kh.getDiemTichLuy() >= 800) {
							nhapLoai.setText("Bậc kim cương");
							break;
						}
					} else {
						nhapLoai.setText("");
					}
				}
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		panel_3.add(nhapSDT);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("VAT :");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(202, 127, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_1);
		
		nhapVAT = new JTextField();
		nhapVAT.setEditable(false);
		nhapVAT.setColumns(10);
		nhapVAT.setBounds(317, 124, 96, 20);
		panel_3.add(nhapVAT);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Số thẻ rung :");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_2.setBounds(0, 55, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_2);
		
		JComboBox theRung = new JComboBox();
		theRung.setBounds(115, 52, 96, 22);
		ArrayList<The> listT = the_dao.getAllTableThe();
		for (The t : listT) {
			if(t.getTinhTrang().equals("Trong"))
				theRung.addItem(t.getSoThe());
		}
		panel_3.add(theRung);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Thành tiền :");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(202, 163, 105, 17);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		nhapThanhTien = new JTextField();
		nhapThanhTien.setEditable(false);
		nhapThanhTien.setColumns(10);
		nhapThanhTien.setBounds(317, 160, 96, 20);
		nhapThanhTien.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatTienThoi();				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatTienThoi();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel_3.add(nhapThanhTien);
		
		nhapTienDua = new JTextField();
		nhapTienDua.setColumns(10);
		nhapTienDua.setBounds(317, 196, 96, 20);
		nhapTienDua.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatTienThoi();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatTienThoi();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				
			}
		});
		panel_3.add(nhapTienDua);
		
		JLabel lblNewLabel_1_2_1_3_1 = new JLabel("Tiền đưa :");
		lblNewLabel_1_2_1_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_3_1.setBounds(202, 199, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_3_1);
		
		JLabel lblNewLabel_1_2_1_3_1_1 = new JLabel("Tiền thối :");
		lblNewLabel_1_2_1_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_3_1_1.setBounds(202, 235, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_3_1_1);
		
		nhapTienThoi = new JTextField();
		nhapTienThoi.setEditable(false);
		nhapTienThoi.setColumns(10);
		nhapTienThoi.setBounds(317, 232, 96, 20);
		panel_3.add(nhapTienThoi);
		
		JLabel lblNewLabel_1_2_1_3_1_2 = new JLabel("Ngày lập :");
		lblNewLabel_1_2_1_3_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_3_1_2.setBounds(0, 235, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_3_1_2);
		
		nhapNgay = new JTextField();
		nhapNgay.setEditable(false);
		nhapNgay.setColumns(10);
		nhapNgay.setBounds(115, 234, 96, 20);
		LocalDate currentDate = LocalDate.now();
		// Định dạng ngày
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = currentDate.format(formatter);
		// Hiển thị ngày lên text field
		nhapNgay.setText(formattedDate);
		panel_3.add(nhapNgay);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Loại KH :");
		lblNewLabel_1_2_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_3.setBounds(0, 163, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_3);
		
		nhapLoai = new JTextField();
		nhapLoai.setEditable(false);
		nhapLoai.setColumns(10);
		nhapLoai.setBounds(115, 162, 96, 20);
		nhapLoai.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatGiam();
				capNhatDuLieu();
				capNhatTienThoi();
				capNhatTienGiam();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatGiam();
				capNhatDuLieu();
				capNhatTienThoi();
				capNhatTienGiam();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
		panel_3.add(nhapLoai);
		
		JLabel lblNewLabel_1_2_1_3_2 = new JLabel(" Giảm (%) :");
		lblNewLabel_1_2_1_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_3_2.setBounds(0, 199, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_3_2);
		
		nhapGiam = new JTextField();
		nhapGiam.setEditable(false);
		nhapGiam.setColumns(10);
		nhapGiam.setBounds(115, 198, 96, 20);
		nhapGiam.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatTienGiam();
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatTienGiam();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel_3.add(nhapGiam);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Tiền giảm :");
		lblNewLabel_1_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_2_1.setBounds(202, 91, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Tên KH :");
		lblNewLabel_1_2_1_2_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_1_2_2.setBounds(0, 127, 105, 17);
		panel_3.add(lblNewLabel_1_2_1_2_2);
		
		nhapTenKH = new JTextField();
		nhapTenKH.setEditable(false);
		nhapTenKH.setColumns(10);
		nhapTenKH.setBounds(115, 126, 96, 20);
		panel_3.add(nhapTenKH);
		
		nhapTienGiam = new JTextField();
		nhapTienGiam.setEditable(false);
		nhapTienGiam.setColumns(10);
		nhapTienGiam.setBounds(317, 88, 96, 20);
		panel_3.add(nhapTienGiam);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 2), "Gi\u1ECF h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 15), new Color(0, 0, 0)));
		panel_4.setBounds(987, 80, 432, 294);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 22, 412, 207);
		panel_4.add(scrollPane_1);
		
		String[] colHeader_1 = {"Tên đồ uống", "Giá tiền","Số lượng","Thành tiền"};
		modelTable_1 = new DefaultTableModel(colHeader_1, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		table_1 = new JTable(modelTable_1);
		scrollPane_1.setViewportView(table_1);
		
		table_1.getTableHeader().setResizingAllowed(false);
        table_1.getTableHeader().setReorderingAllowed(false);
        table_1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane_1.setColumnHeader(new JViewport() {
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table_1.setRowHeight(table_1.getRowHeight()+10);
		
		JButton btnNewButton = new JButton("Xóa một");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if (row >= 0) {
					modelTable_1.removeRow(row);
					capNhatDuLieu();
					capNhatGiam();
					capNhatTienGiam();
					capNhatTienThoi();
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng cần xóa!");
				}
			}
		});
		btnNewButton.setBounds(10, 246, 114, 37);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Xóa tất cả");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable_1.setRowCount(0);
				capNhatDuLieu();
				capNhatGiam();
				capNhatTienGiam();
				capNhatTienThoi();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(160, 246, 114, 37);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Sửa");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table_1.getSelectedRow();
				if(row >= 0) {
					String soLuong;
					do {
						soLuong = JOptionPane.showInputDialog("Hãy nhập số lượng");
						if(!soLuong.matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng chỉ được là số. Hãy nhập lại!");
						}
					} while(!soLuong.matches("[0-9]+"));
					modelTable_1.setValueAt(soLuong, row, 2);
					double thanhTien = Integer.parseInt(soLuong)*Double.parseDouble(String.valueOf(modelTable.getValueAt(row,2)));
					modelTable_1.setValueAt(thanhTien, row, 3);
				}
				capNhatDuLieu();
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(308, 246, 114, 37);
		panel_4.add(btnNewButton_1_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(255, 175, 175), 2), "Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 15), new Color(0, 0, 0)));
		panel_5.setBounds(398, 80, 579, 577);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabbedPane.setBounds(10, 24, 559, 542);
		panel_5.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Coffee", null, scrollPane, null);
		
		String[] colHeader = { "Mã đồ uống", "Tên đồ uống", "Giá tiền"};
		modelTable = new DefaultTableModel(colHeader, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		String[] colHeader2 = { "Mã đồ uống", "Tên đồ uống", "Giá tiền"};
		modelTable2 = new DefaultTableModel(colHeader2, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		String[] colHeader3 = { "Mã đồ uống", "Tên đồ uống", "Giá tiền"};
		modelTable3 = new DefaultTableModel(colHeader3, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		
		table = new JTable(modelTable);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
					int row = table.getSelectedRow();
					for(int i = 0;i<modelTable_1.getRowCount();i++) {
						if(String.valueOf(modelTable.getValueAt(row, 1)).equalsIgnoreCase(String.valueOf(modelTable_1.getValueAt(i, 0)))) {
							JOptionPane.showMessageDialog(null, "Món đã tồn tại trong giỏ hàng");
							return;
						}
					}
					String soLuong;
					do {
						soLuong = JOptionPane.showInputDialog("Hãy nhập số lượng");
						if(!soLuong.matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng chỉ được là số. Hãy nhập lại!");
						}
					} while(!soLuong.matches("[0-9]+"));
					modelTable_1.addRow(new Object[] {modelTable.getValueAt(row,1),modelTable.getValueAt(row,2),soLuong,Integer.parseInt(soLuong)*Double.parseDouble(String.valueOf(modelTable.getValueAt(row,2)))});
					capNhatDuLieu();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane2 = new JScrollPane();
		tabbedPane.addTab("Smoothie", null, scrollPane2, null);
		
		table2 = new JTable(modelTable2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
					int row = table2.getSelectedRow();
					for(int i = 0;i<modelTable_1.getRowCount();i++) {
						if(String.valueOf(modelTable2.getValueAt(row, 1)).equalsIgnoreCase(String.valueOf(modelTable_1.getValueAt(i, 0)))) {
							JOptionPane.showMessageDialog(null, "Món đã tồn tại trong giỏ hàng");
							return;
						}
					}
					String soLuong;
					do {
						soLuong = JOptionPane.showInputDialog("Hãy nhập số lượng");
						if(!soLuong.matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng chỉ được là số. Hãy nhập lại!");
						}
					} while(!soLuong.matches("[0-9]+"));
					modelTable_1.addRow(new Object[] {modelTable2.getValueAt(row,1),modelTable2.getValueAt(row,2),soLuong,Integer.parseInt(soLuong)*Double.parseDouble(String.valueOf(modelTable2.getValueAt(row,2)))});
					capNhatDuLieu();
				}
			}
		});
		scrollPane2.setViewportView(table2);
		
		JScrollPane scrollPane3 = new JScrollPane();
		tabbedPane.addTab("Tea", null, scrollPane3, null);
		
		table3 = new JTable(modelTable3);
		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
					int row = table3.getSelectedRow();
					for(int i = 0;i<modelTable_1.getRowCount();i++) {
						if(String.valueOf(modelTable3.getValueAt(row, 1)).equalsIgnoreCase(String.valueOf(modelTable_1.getValueAt(i, 0)))) {
							JOptionPane.showMessageDialog(null, "Món đã tồn tại trong giỏ hàng");
							return;
						}
					}
					String soLuong;
					do {
						soLuong = JOptionPane.showInputDialog("Hãy nhập số lượng");
						if(!soLuong.matches("[0-9]+")) {
							JOptionPane.showMessageDialog(null, "Số lượng chỉ được là số. Hãy nhập lại!");
						}
					} while(!soLuong.matches("[0-9]+"));
					modelTable_1.addRow(new Object[] {modelTable3.getValueAt(row,1),modelTable3.getValueAt(row,2),soLuong,Integer.parseInt(soLuong)*Double.parseDouble(String.valueOf(modelTable3.getValueAt(row,2)))});
					capNhatDuLieu();
				}
			}
		});
		scrollPane3.setViewportView(table3);
		
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
		
		table2.getTableHeader().setResizingAllowed(false);
        table2.getTableHeader().setReorderingAllowed(false);
        table2.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane2.setColumnHeader(new JViewport() {
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table2.setRowHeight(table2.getRowHeight()+10);
		
		table3.getTableHeader().setResizingAllowed(false);
        table3.getTableHeader().setReorderingAllowed(false);
        table3.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane3.setColumnHeader(new JViewport() {
			@Override public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table3.setRowHeight(table3.getRowHeight()+10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(388, 667, 1031, 77);
		panel_1.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Tạo hóa đơn");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nhapTongTien.getText().equals("0.0") || nhapTongTien.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Chưa có món để tạo hóa đơn!");
					return;
				} else if (nhapSDT.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại , nếu chưa có xin hãy tạo");
					nhapSDT.requestFocus();
					return;
				} else if (nhapTienDua.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Nhập số tiền khách đưa!");
					nhapTienDua.requestFocus();
					return;
				} else if (Double.parseDouble(nhapTienThoi.getText())< 0) {
					JOptionPane.showMessageDialog(null, "Tiền khách đưa thiếu!");
					nhapTienDua.requestFocus();
					return;
				}else {
					try {
						hoaDon.setText("--------------------------------------\n");
						hoaDon.setText(hoaDon.getText() + "-              Coffee ABC            -\n");
						hoaDon.setText(hoaDon.getText() + "--------------------------------------\n");
						hoaDon.setText(hoaDon.getText() + "\nNgày : "+nhapNgay.getText()+"\n");
						hoaDon.setText(hoaDon.getText() + "\nMã hóa đơn : "+nhapHD.getText()+"\n");
						hoaDon.setText(hoaDon.getText() + "Mã nhân viên : "+nhapNV.getText()+"\n");
						if(nhapTenKH.getText().equals("")||nhapTenKH.getText().trim().isEmpty())
							hoaDon.setText(hoaDon.getText() + "Tên khách hàng : Khách hàng vãng lai\n");
						else
							hoaDon.setText(hoaDon.getText() + "Tên khách hàng : "+nhapTenKH.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"Số thẻ : "+theRung.getSelectedItem()+"\n");
						hoaDon.setText(hoaDon.getText() + "--------------------------------------\n");
						hoaDon.setText(hoaDon.getText() +"\nTT Tên món       SL    Đơn giá   Thành tiền\n");
						for(int i = 0 ; i<modelTable_1.getRowCount();i++) {
							String line = formatRow(i+1,modelTable_1.getValueAt(i, 0).toString(),modelTable_1.getValueAt(i, 2).toString(),modelTable_1.getValueAt(i, 1).toString(),modelTable_1.getValueAt(i, 3).toString());
							hoaDon.setText(hoaDon.getText() + line);
						}
						hoaDon.setText(hoaDon.getText() + "--------------------------------------\n");
						hoaDon.setText(hoaDon.getText()+"\nTổng tiền      :\t"+nhapTongTien.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"VAT (10%)      :\t"+nhapVAT.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"Giảm giá       :\t"+nhapTienGiam.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"Thành tiền     :\t"+nhapThanhTien.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"Tiền khách đưa :\t"+nhapTienDua.getText()+"\n");
						hoaDon.setText(hoaDon.getText()+"Tiền thừa      :\t"+nhapTienThoi.getText()+"\n");
						hoaDon.print();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					String maHD = nhapHD.getText();
					Double tt = Double.parseDouble(nhapThanhTien.getText());
					String ngayBanString = nhapNgay.getText();
				    LocalDate ngayBan = LocalDate.parse(ngayBanString);
				    String maNV = nhapNV.getText();
				    NhanVien nv = new NhanVien(maNV);
				    KhachHang kh1 = null;
				    List<KhachHang> listKH = kh_dao.getAllTableKhachHang();
				    for (KhachHang kh : listKH) {
				    	if(kh.getSoDienThoai().equals(nhapSDT.getText())) {
				    		String maKH = kh.getMaKhachHang();
				    		kh1 = new KhachHang(maKH);
				    		break;
				    	}
				    }
				    int soThe = Integer.parseInt(theRung.getSelectedItem().toString());
				    The the = new The(soThe);
					HoaDon hd = new HoaDon(maHD, tt, ngayBan, nv, kh1, the);
					hd_dao.insert(hd);
					for(int i = 0 ; i<modelTable_1.getRowCount();i++) {
						HoaDon hd1 = new HoaDon(maHD);
						List<DoUong> dU = du_dao.getAllTableDoUong();
						DoUong dU1 = null;
						for(DoUong doU : dU) {
							if(modelTable_1.getValueAt(i, 0).toString().equals(doU.getTenDoUong())) {
								String maDoUong = doU.getMaDoUong();
								dU1 = new DoUong(maDoUong);
								break;
							}
						}
						int soL = Integer.parseInt(modelTable_1.getValueAt(i, 2).toString());
						double donGia = Double.parseDouble(modelTable_1.getValueAt(i, 1).toString());
						ChiTietHoaDon ct = new ChiTietHoaDon(hd1, dU1, soL,donGia);
						cthd_dao.insert(ct);
						the_dao.capNhat(theRung.getSelectedItem().toString());
						reset();
						theRung.removeAllItems();;
						ArrayList<The> listT = the_dao.getAllTableThe();
						for (The t : listT) {
							if(t.getTinhTrang().equals("Trong"))
								theRung.addItem(t.getSoThe());
						}
					}
				}
			}
		});
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(10, 10, 494, 57);
		panel_6.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Làm mới");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2_1.setBackground(Color.RED);
		btnNewButton_2_1.setBounds(527, 10, 494, 57);
		panel_6.add(btnNewButton_2_1);
		
		
		docDuLieuDatabaseVaoTable();
		clock();
	}
	
	private void docDuLieuDatabaseVaoTable() {
		List<DoUong> list = du_dao.getAllTableDoUong();
		for (DoUong du: list) {
			if(du.getLoaiDoUong().equalsIgnoreCase("Coffee")) {
				modelTable.addRow(new Object[] {du.getMaDoUong(),du.getTenDoUong(),du.getGiaTien()});
			} else if(du.getLoaiDoUong().equalsIgnoreCase("Smoothie")) {
				modelTable2.addRow(new Object[] {du.getMaDoUong(),du.getTenDoUong(),du.getGiaTien()});
			} else if(du.getLoaiDoUong().equalsIgnoreCase("Tea")) {
				modelTable3.addRow(new Object[] {du.getMaDoUong(),du.getTenDoUong(),du.getGiaTien()});
			}
		}
	}
	
	private void capNhatDuLieu() {
		if(nhapHD.getText().trim().equalsIgnoreCase("")) {
			List<HoaDon> listhd = hd_dao.getAllTableHoaDon();
			String hdLast=listhd.get(listhd.size()-1).getMaHoaDon();
			int num = Integer.parseInt(hdLast.substring(2));
			num++;
			String hdNew = "HD"+String.format("%03d", num);
			nhapHD.setText(hdNew);
		}
		if(nhapNV.getText().trim().equalsIgnoreCase("")) {
			String tk = Login.tk;
			List<NhanVien> listnv = nv_dao.getAllTableNhanVien();
			for(NhanVien nv : listnv) {
				if(nv.getTaiKhoan().getTaiKhoan().equalsIgnoreCase(tk)) {
					nhapNV.setText(nv.getMaNhanVien());
					break;
				}
			}
		}
		double sum = 0;
		for(int i =0;i<modelTable_1.getRowCount();i++) {
			sum += Double.parseDouble(modelTable_1.getValueAt(i, 3).toString());
		}
		nhapTongTien.setText(String.valueOf(sum));
		
		nhapVAT.setText(String.valueOf(Double.parseDouble(nhapTongTien.getText())*(1-tinhPhanTram())*0.1));
		
		nhapThanhTien.setText(String.valueOf(Double.parseDouble(nhapTongTien.getText())*(1-tinhPhanTram())+Double.parseDouble(nhapVAT.getText())));
	}
	
	private void capNhatTienThoi() {
		if((!nhapTienDua.getText().trim().equalsIgnoreCase("") || !nhapTienDua.getText().isEmpty()) && (!nhapThanhTien.getText().isEmpty() || !nhapThanhTien.getText().trim().equalsIgnoreCase("")))
			nhapTienThoi.setText(String.valueOf(Double.parseDouble(nhapTienDua.getText())-Double.parseDouble(nhapThanhTien.getText())));
		else
			nhapTienThoi.setText("");
	}
	
	private String loai() {
		return nhapLoai.getText();
	}
	
	private double tinhPhanTram() {
		if(loai().equals("Bậc đồng")) {
			return 0.05;
		} else if(loai().equals("Bậc bạc")) {
			return 0.1;
		} else if (loai().equals("Bậc vàng")) {
			return 0.2;
		} else if (loai().equals("Bậc kim cương")) {
			return 0.3;
		} else {
			return 0;
		}
	}
	
	private void capNhatGiam() {
		if(!nhapLoai.getText().trim().equalsIgnoreCase("") || !nhapLoai.getText().isEmpty())
			nhapGiam.setText(String.valueOf(tinhPhanTram()*100));
		else
			nhapGiam.setText("");
	}
	
	private void capNhatTienGiam() {
		if((!nhapGiam.getText().trim().equalsIgnoreCase("") || !nhapGiam.getText().isEmpty()) && (!nhapTongTien.getText().isEmpty() || !nhapTongTien.getText().trim().equalsIgnoreCase("")))
			nhapTienGiam.setText(String.valueOf(Double.parseDouble(nhapGiam.getText())/100*Double.parseDouble(nhapTongTien.getText())));
		else
			nhapTienGiam.setText("");
	}
	
	public void reset() {
	    nhapTienDua.setText("");
	    nhapSDT.setText("");
	    nhapHD.setText("");
	    nhapThanhTien.setText("");
	    nhapVAT.setText("");
	    nhapTongTien.setText("");
	    table.clearSelection();
	    table2.clearSelection();
		modelTable_1.setRowCount(0);
	}
	
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH) + 1;
						int year = cal.get(Calendar.YEAR);
						
						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						
						lblClock.setText("Date "+day+"/"+month+"/"+year+"  Time "+hour+":"+String.format("%02d", minute) +":"+second);
						sleep(1000);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
		
	}
	
	public String formatRow(int stt,String item, String quantity, String price, String total) {
	    return String.format("%-2d %-13s %-5s %-9s %-10s\n",stt, item, quantity, price, total);
	}
}
