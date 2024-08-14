package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import Entity.KhachHang;
import ConnectDB.ConnectDB;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KhachHang_app extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel sideMenu;
	private JTextField nhapMa;
	private JTextField nhapTen;
	private JTextField nhapDC;
	private JTextField nhapPhone;
	private JTextField nhapChiTieu;
	private JTable table;
	private JScrollPane scrollPane;
	private KhachHang_DAO kh_dao;
	private DefaultTableModel modelTable;
	private JTextField findphone;
	private JTextField findcode;
	private JButton btnfphone;
	private JButton btnfcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_app frame = new KhachHang_app();
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
	public KhachHang_app() {
		setTitle("Danh sách khách hàng");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		kh_dao = new KhachHang_DAO();

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
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBackground(Color.LIGHT_GRAY);
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

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(388, 69, 298, 574);
		panel_3.setBackground(new Color(240, 240, 240));
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã khách hàng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 278, 25);
		panel_3.add(lblNewLabel_1);

		nhapMa = new JTextField();
		nhapMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapMa.setBounds(10, 47, 278, 25);
		panel_3.add(nhapMa);
		nhapMa.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Tên khách hàng :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 83, 278, 25);
		panel_3.add(lblNewLabel_9);

		nhapTen = new JTextField();
		nhapTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapTen.setBounds(10, 119, 278, 25);
		panel_3.add(nhapTen);
		nhapTen.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Địa chỉ :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(10, 155, 278, 25);
		panel_3.add(lblNewLabel_10);

		nhapDC = new JTextField();
		nhapDC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapDC.setBounds(10, 191, 278, 25);
		panel_3.add(nhapDC);
		nhapDC.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Số điện thoại :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(10, 227, 278, 25);
		panel_3.add(lblNewLabel_11);

		nhapPhone = new JTextField();
		nhapPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapPhone.setBounds(10, 263, 278, 25);
		panel_3.add(nhapPhone);
		nhapPhone.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Điểm tích lũy :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(10, 299, 278, 25);
		panel_3.add(lblNewLabel_12);

		nhapChiTieu = new JTextField();
		nhapChiTieu.setEditable(false);
		nhapChiTieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nhapChiTieu.setBounds(10, 335, 278, 25);
		panel_3.add(nhapChiTieu);
		nhapChiTieu.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Tìm theo số điện thoại:");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(10, 368, 278, 25);
		panel_3.add(lblNewLabel_13);

		findphone = new JTextField();
		findphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		findphone.setBounds(10, 404, 200, 25);
		panel_3.add(findphone);
		findphone.setColumns(10);

		btnfphone = new JButton("Tìm");
		btnfphone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				finddsphone(findphone.getText());
			}
		});
		btnfphone.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnfphone.setBackground(new Color(8, 102, 255));
		btnfphone.setForeground(new Color(255, 255, 255));
		btnfphone.setBounds(220, 404, 70, 25);
		panel_3.add(btnfphone);

		JLabel lblNewLabel_14 = new JLabel("Tìm theo Mã:");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(10, 437, 278, 25);
		panel_3.add(lblNewLabel_14);

		findcode = new JTextField();
		findcode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		findcode.setBounds(10, 473, 200, 25);
		panel_3.add(findcode);
		findcode.setColumns(10);

		btnfcode = new JButton("Tìm");
		btnfcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				finddscode(findcode.getText());
			}
		});
		btnfcode.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnfcode.setBackground(new Color(8, 102, 255));
		btnfcode.setForeground(new Color(255, 255, 255));
		btnfcode.setBounds(220, 473, 70, 25);
		panel_3.add(btnfcode);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(388, 643, 1257, 101);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = nhapMa.getText();
				String ten = nhapTen.getText();
				String dc = nhapDC.getText();
				String sdt = nhapPhone.getText();
				KhachHang kh = new KhachHang(ma, ten, dc, sdt, 0);
				try {
					kh_dao.create(kh);
					modelTable.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDiaChi(),
							kh.getSoDienThoai(), kh.getDiemTichLuy() });
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Khách Hàng đã tồn tại");
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(96, 11, 202, 78);
		panel_4.add(btnNewButton);

		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = nhapMa.getText();
				String ten = nhapTen.getText();
				String dc = nhapDC.getText();
				String sdt = nhapPhone.getText();
				int chitieu = Integer.parseInt(nhapChiTieu.getText());

				KhachHang kh = new KhachHang(ma, ten, dc, sdt, chitieu);
				if (kh_dao.update(kh)) {
					int row = table.getSelectedRow();
					modelTable.setValueAt(kh.getMaKhachHang(), row, 0);
					modelTable.setValueAt(kh.getTenKhachHang(), row, 1);
					modelTable.setValueAt(kh.getDiaChi(), row, 2);
					modelTable.setValueAt(kh.getSoDienThoai(), row, 3);
					modelTable.setValueAt(kh.getDiemTichLuy(), row, 4);
				}
			}
		});
		btnSa.setBackground(new Color(255, 0, 0));
		btnSa.setForeground(new Color(255, 255, 255));
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSa.setBounds(308, 11, 202, 78);
		panel_4.add(btnSa);

		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					if (kh_dao.delete(nhapMa.getText())) {
						modelTable.removeRow(row);
						nhapChiTieu.setText("");
						nhapDC.setText("");
						nhapMa.setText("");
						nhapPhone.setText("");
						nhapTen.setText("");
						table.clearSelection();
					}
				}
			}
		});
		btnXa.setBackground(new Color(255, 0, 0));
		btnXa.setForeground(new Color(255, 255, 255));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXa.setBounds(520, 11, 202, 78);
		panel_4.add(btnXa);

		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelTable.setRowCount(0);
				nhapChiTieu.setText("");
				nhapDC.setText("");
				nhapMa.setText("");
				nhapPhone.setText("");
				nhapTen.setText("");
				table.clearSelection();
				docDuLieuDatabaseVaoTable();
			}
		});
		btnLmMi.setForeground(Color.WHITE);
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLmMi.setBackground(Color.RED);
		btnLmMi.setBounds(732, 11, 202, 78);
		panel_4.add(btnLmMi);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(696, 80, 723, 552);
		panel_1.add(scrollPane);

		String[] colHeader = { "Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại", "Điểm tích lũy" };
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
					nhapMa.setText((String) modelTable.getValueAt(row, 0));
					nhapTen.setText((String) modelTable.getValueAt(row, 1));
					nhapDC.setText((String) modelTable.getValueAt(row, 2));
					nhapPhone.setText((String) modelTable.getValueAt(row, 3));
					nhapChiTieu.setText(String.valueOf(modelTable.getValueAt(row, 4)));
				}
			}
		});

		docDuLieuDatabaseVaoTable();
	}

	private void docDuLieuDatabaseVaoTable() {
		List<KhachHang> list = kh_dao.getAllTableKhachHang();
		for (KhachHang kh : list) {
			modelTable.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDiaChi(),
					kh.getSoDienThoai(), kh.getDiemTichLuy() });
		}
	}

	private void finddsphone(String phone) {
		List<KhachHang> list = kh_dao.findphone(phone);
		for (KhachHang kh : list) {
			modelTable.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDiaChi(),
					kh.getSoDienThoai(), kh.getDiemTichLuy() });
		}
	}

	private void finddscode(String id) {
		List<KhachHang> list = kh_dao.findcode(id);
		for (KhachHang kh : list) {
			modelTable.addRow(new Object[] { kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getDiaChi(),
					kh.getSoDienThoai(), kh.getDiemTichLuy() });
		}
	}
}
