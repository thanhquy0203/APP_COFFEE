package app;

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
import java.time.LocalDate;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.HoaDon_DAO;
import DAO.NhanVien_DAO;
import Entity.HoaDon;
import Entity.NhanVien;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ThongKeHoaDon extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container sideMenu;
	private JTable table;
	private JTextField mahd;
	private JTextField manv;
	private JTextField tongtien;
	private JTextField makh;
	private JTextField ngayban;
	private JTextField maban;
	private HoaDon_DAO hd_dao;
	private JScrollPane scrollPane;
	private DefaultTableModel modelTable;
	private JComboBox<Object> dayComboBox;
	private JComboBox<Object> monthComboBox;
	private JComboBox<Object> yearComboBox;
	private JComboBox<Object> nvComboBox = new JComboBox<>();
	private JButton tim;
	private JButton loc;
	private NhanVien_DAO nv_dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeHoaDon frame = new ThongKeHoaDon();
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
	public ThongKeHoaDon() {
		setTitle("Quản lí hóa đơn");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		hd_dao = new HoaDon_DAO();
		nv_dao = new NhanVien_DAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1435, 782);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		ImageIcon imageIcon = new ImageIcon(ThanhToan.class.getResource("/image/logo1.jpg"));
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(368, 239, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
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
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(0, 11, 388, 52);
		body.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("  Đặt nguyên liệu");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatNguyenLieu app = new DatNguyenLieu();
				app.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setBackground(Color.GRAY);
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
		panel_3.setBounds(398, 80, 1021, 273);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1021, 273);
		panel_3.add(scrollPane);

		String[] colHeader = { "Mã hóa đơn", "Tổng tiền", "Ngày Bán", "Mã Nhân Viên", "Mã Khách Hàng", "Số thẻ" };
		modelTable = new DefaultTableModel(colHeader, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(modelTable);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
		scrollPane.setViewportView(table);
		scrollPane.setColumnHeader(new JViewport() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				d.height = 32;
				return d;
			}
		});
		table.setRowHeight(table.getRowHeight() + 10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					mahd.setText((String) modelTable.getValueAt(row, 0));
					double tongTien = (Double) modelTable.getValueAt(row, 1);
					tongtien.setText(String.valueOf(tongTien));
					ngayban.setText(((LocalDate) modelTable.getValueAt(row, 2)).toString());
					manv.setText((String) modelTable.getValueAt(row, 3));
					makh.setText((String) modelTable.getValueAt(row, 4));
					maban.setText((String) modelTable.getValueAt(row, 5).toString());
				}
			}
		});
		docDuLieuDatabaseVaoTable();
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(398, 388, 128, 51);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã nhân viên :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(872, 388, 164, 51);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Mã Khách hàng :");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(872, 450, 164, 51);
		panel_1.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Tổng tiền :");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(398, 450, 128, 51);
		panel_1.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Ngày bán :");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(398, 512, 128, 51);
		panel_1.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Số thẻ :");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(872, 512, 164, 51);
		panel_1.add(lblNewLabel_1_5);

		mahd = new JTextField();
		mahd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mahd.setEditable(false);
		mahd.setBounds(536, 396, 253, 40);
		panel_1.add(mahd);
		mahd.setColumns(10);

		manv = new JTextField();
		manv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		manv.setEditable(false);
		manv.setColumns(10);
		manv.setBounds(1046, 396, 253, 40);
		panel_1.add(manv);

		tongtien = new JTextField();
		tongtien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tongtien.setEditable(false);
		tongtien.setColumns(10);
		tongtien.setBounds(536, 458, 253, 40);
		panel_1.add(tongtien);

		makh = new JTextField();
		makh.setEditable(false);
		makh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		makh.setColumns(10);
		makh.setBounds(1046, 458, 253, 40);
		panel_1.add(makh);

		ngayban = new JTextField();
		ngayban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ngayban.setEditable(false);
		ngayban.setColumns(10);
		ngayban.setBounds(536, 520, 253, 40);
		panel_1.add(ngayban);

		maban = new JTextField();
		maban.setFont(new Font("Tahoma", Font.PLAIN, 18));
		maban.setEditable(false);
		maban.setColumns(10);
		maban.setBounds(1046, 520, 253, 40);
		panel_1.add(maban);

		JLabel lblNewLabel_1_6 = new JLabel("Ngày bán :");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(310, 600, 233, 51);
		panel_1.add(lblNewLabel_1_6);
		// Tạo JComboBox cho ngày
		dayComboBox = new JComboBox<>();
		dayComboBox.addItem("Tất cả");
		dayComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dayComboBox.setBounds(550, 615, 80, 25);
		IntStream.rangeClosed(1, 31).forEach(dayComboBox::addItem);
		panel_1.add(dayComboBox);

		// Tạo JComboBox cho tháng
		monthComboBox = new JComboBox<>();
		monthComboBox.addItem("Tất cả");
		monthComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		monthComboBox.setBounds(640, 615, 80, 25);
		IntStream.rangeClosed(1, 12).forEach(monthComboBox::addItem);
		panel_1.add(monthComboBox);

		// Tạo JComboBox cho năm
		yearComboBox = new JComboBox<>();
		yearComboBox.addItem("Tất cả");
		yearComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yearComboBox.setBounds(730, 615, 80, 25);
		int currentYear = LocalDate.now().getYear();
		for (int year = currentYear; year >= currentYear - 5; year--) {
			yearComboBox.addItem(year);
		}
		panel_1.add(yearComboBox);

		JLabel lblNewLabel_1_7 = new JLabel("Nhân viên :");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(310, 650, 233, 51);
		panel_1.add(lblNewLabel_1_7);

		nvComboBox.addItem("Tất cả");
		docDuLieuDatacbb();
		nvComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nvComboBox.setBounds(550, 665, 100, 25);
		panel_1.add(nvComboBox);

		tim = new JButton("Lọc");
		tim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				int ngay;
				int thang;
				int nam;
				if(dayComboBox.getSelectedIndex()!=0) {
					ngay = Integer.parseInt(dayComboBox.getSelectedItem().toString());
				}else {
					ngay = 0;
				}
				if(monthComboBox.getSelectedIndex()!=0) {
					thang = Integer.parseInt(monthComboBox.getSelectedItem().toString());
				}else {
					thang = 0;
				}
				if(yearComboBox.getSelectedIndex()!=0) {
					nam = Integer.parseInt(yearComboBox.getSelectedItem().toString());
				}else {
					nam = 0;
				}
				String nv;
				if(nvComboBox.getSelectedIndex()!=0) {
					nv = nvComboBox.getSelectedItem().toString();
				}else {
					nv = null;
				}
				filltercbb(ngay, thang, nam, nv);
			}
		});
		tim.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tim.setBounds(1066, 600, 233, 50);
		panel_1.add(tim);

		loc = new JButton("Làm mới");
		loc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				mahd.setText("");
				manv.setText("");
				makh.setText("");
				tongtien.setText("");
				ngayban.setText("");
				maban.setText("");
				dayComboBox.setSelectedIndex(0);
				monthComboBox.setSelectedIndex(0);
				yearComboBox.setSelectedIndex(0);
				nvComboBox.setSelectedIndex(0);
				table.clearSelection();
				docDuLieuDatabaseVaoTable();
			}
		});
		loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loc.setBounds(1066, 665, 233, 50);
		panel_1.add(loc);
	}

	private void docDuLieuDatabaseVaoTable() {
		List<HoaDon> list = hd_dao.getAllTableHoaDon();
		for (HoaDon hd : list) {
			modelTable.addRow(new Object[] { hd.getMaHoaDon(), hd.getTongTien(), hd.getNgayBan(),
					hd.getMaNhanVien().getMaNhanVien(), hd.getMaKhachHang().getMaKhachHang(),
					hd.getSoThe().getSoThe() });
		}
	}

	private void docDuLieuDatacbb() {
		List<NhanVien> list = nv_dao.getAllTableNhanVien();
		for (NhanVien nv : list) {
			nvComboBox.addItem(nv.getMaNhanVien());
		}
	}

	private void filltercbb(int ngay, int thang, int nam, String nv) {
		List<HoaDon> list = hd_dao.fillter(ngay, thang, nam, nv);
		for (HoaDon hd : list) {
			modelTable.addRow(new Object[] { hd.getMaHoaDon(), hd.getTongTien(), hd.getNgayBan(),
					hd.getMaNhanVien().getMaNhanVien(), hd.getMaKhachHang().getMaKhachHang(),
					hd.getSoThe().getSoThe() });
		}
	}
}
