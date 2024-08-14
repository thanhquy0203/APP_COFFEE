package app;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import DAO.ChiTietHoaDon_DAO;
import DAO.DoUong_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.NhanVien_DAO;
import DAO.TaiKhoan_DAO;
import Entity.ChiTietHoaDon;
import Entity.HoaDon;
import Entity.NhanVien;
import Entity.TaiKhoan;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NhanVien_app extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Container sideMenu;
	private JTextField nhapTen;
	private JTextField nhapDC;
	private JTable table;
	private DefaultTableModel modelTable;
	private TaiKhoan_DAO tk_dao;
	private NhanVien_DAO nv_dao;
	private JTextField nhapSDT;
	private JTextField nhapLuong;
	private JTextField nhapTK;
	private JTextField nhapMK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_app frame = new NhanVien_app();
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
	public NhanVien_app() {
		setTitle("Quản lý nhân viên");
		try {
			ConnectDB.getInstance().connect();
			System.out.println("Connected!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		tk_dao = new TaiKhoan_DAO();
		nv_dao = new NhanVien_DAO();
		
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
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DatNguyenLieu app2 = new DatNguyenLieu();
				app2.setVisible(true);
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
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
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
		panel_3.setBounds(388, 69, 162, 675);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 140, 37);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 103, 140, 37);
		panel_3.add(lblNewLabel_1_1);
		
		nhapTen = new JTextField();
		nhapTen.setBounds(10, 59, 140, 33);
		panel_3.add(nhapTen);
		nhapTen.setColumns(10);
		
		nhapDC = new JTextField();
		nhapDC.setColumns(10);
		nhapDC.setBounds(10, 151, 140, 33);
		panel_3.add(nhapDC);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quyển quản lý ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 563, 140, 37);
		panel_3.add(lblNewLabel_1_1_1);
		
		JCheckBox quyenQuanLy = new JCheckBox("");
		quyenQuanLy.setBounds(125, 572, 29, 23);
		panel_3.add(quyenQuanLy);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Số điện thoại :");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2.setBounds(10, 195, 140, 37);
		panel_3.add(lblNewLabel_1_1_2);
		
		nhapSDT = new JTextField();
		nhapSDT.setColumns(10);
		nhapSDT.setBounds(10, 243, 140, 33);
		panel_3.add(nhapSDT);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Lương (nghìn) :");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2_1.setBounds(10, 287, 140, 37);
		panel_3.add(lblNewLabel_1_1_2_1);
		
		nhapLuong = new JTextField();
		nhapLuong.setColumns(10);
		nhapLuong.setBounds(10, 335, 140, 33);
		panel_3.add(nhapLuong);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Tài khoản :");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2_1_1.setBounds(10, 379, 140, 37);
		panel_3.add(lblNewLabel_1_1_2_1_1);
		
		nhapTK = new JTextField();
		nhapTK.setColumns(10);
		nhapTK.setBounds(10, 427, 140, 33);
		panel_3.add(nhapTK);
		
		JLabel lblNewLabel_1_1_2_1_1_1 = new JLabel("Mật khẩu :");
		lblNewLabel_1_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_2_1_1_1.setBounds(10, 471, 140, 37);
		panel_3.add(lblNewLabel_1_1_2_1_1_1);
		
		nhapMK = new JTextField();
		nhapMK.setColumns(10);
		nhapMK.setBounds(10, 519, 140, 33);
		panel_3.add(nhapMK);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(560, 80, 859, 504);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 839, 482);
		panel_4.add(scrollPane);
		String[] colHeader = {"Mã NV", "Tên NV","Địa chỉ","Số điện thoại","Lương (nghìn)","Tài khoản","Chức vụ","Mật khẩu"};
		modelTable = new DefaultTableModel(colHeader, 0) {
			@Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
		};
		table = new JTable(modelTable);
		table.removeColumn(table.getColumnModel().getColumn(7));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				if (row >= 0) {
					nhapTen.setText(modelTable.getValueAt(row, 1).toString());
					nhapDC.setText(modelTable.getValueAt(row, 2).toString());
					nhapSDT.setText(modelTable.getValueAt(row, 3).toString());
					nhapLuong.setText(modelTable.getValueAt(row, 4).toString());
					nhapTK.setText(modelTable.getValueAt(row, 5).toString());
					nhapMK.setText(modelTable.getValueAt(row, 7).toString());
					if(modelTable.getValueAt(row, 6).toString().equalsIgnoreCase("Quan ly")) 
						quyenQuanLy.setSelected(true);
					else
						quyenQuanLy.setSelected(false);
				}
			}
		});
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
		scrollPane.setViewportView(table);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(560, 595, 859, 149);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		JButton them = new JButton("Thêm");
		them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = nhapTen.getText();
				String diaChi = nhapDC.getText();
				String sdt = nhapSDT.getText();
				double luong = Double.parseDouble(nhapLuong.getText());
				String tk = nhapTK.getText();
				String mk = nhapMK.getText();
				String chucVu = "Nhan vien";
				if (quyenQuanLy.isSelected())
					chucVu = "Quan ly";
				List<NhanVien> listnv = nv_dao.getAllTableNhanVien();
				String nvLast=listnv.get(listnv.size()-1).getMaNhanVien();
				int num = Integer.parseInt(nvLast.substring(2));
				num++;
				String hdNew = "NV"+String.format("%03d", num);
				TaiKhoan tk2 = new TaiKhoan(tk,mk);
				NhanVien nv = new NhanVien(hdNew,ten,diaChi,sdt,luong,chucVu,tk2);
				tk_dao.insert(tk2);
				nv_dao.insert(nv);
				modelTable.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getLuong(),nv.getTaiKhoan().getTaiKhoan(),nv.getChucVu(),mk});
			}
		});
		them.setForeground(Color.WHITE);
		them.setFont(new Font("Tahoma", Font.BOLD, 20));
		them.setBackground(Color.RED);
		them.setBounds(81, 37, 178, 78);
		panel_5.add(them);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row >= 0) {
					String temp = modelTable.getValueAt(row, 5).toString();
					String tk = nhapTK.getText();
					String mk = nhapMK.getText();
					TaiKhoan taiKhoan = new TaiKhoan(tk, mk);
					String ten = nhapTen.getText();
					String diaChi = nhapDC.getText();
					String sdt = nhapSDT.getText();
					double luong = Double.parseDouble(nhapLuong.getText());
					String chucVu = "Nhan vien";
					if (quyenQuanLy.isSelected())
						chucVu = "Quan ly";
					NhanVien nv = new NhanVien(modelTable.getValueAt(row, 0).toString(),ten,diaChi,sdt,luong,chucVu,taiKhoan);
					if(!nhapTK.getText().equals(temp)) {
						tk_dao.insert(taiKhoan);
						nv_dao.update(nv);
						tk_dao.delete(temp);
					} else {
						nv_dao.update(nv);
						tk_dao.capNhatPass(tk, mk);
					}
					modelTable.setRowCount(0);
					docDuLieuDatabaseVaoTable();
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn trước khi sửa!");
				}
			}
		});
		btnSa.setForeground(Color.WHITE);
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSa.setBackground(Color.RED);
		btnSa.setBounds(340, 37, 178, 78);
		panel_5.add(btnSa);
		
		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lamMoi();
			}
		});
		btnLmMi.setForeground(Color.WHITE);
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLmMi.setBackground(Color.RED);
		btnLmMi.setBounds(599, 37, 178, 78);
		panel_5.add(btnLmMi);
		
		docDuLieuDatabaseVaoTable();
	}

	private void lamMoi() {
		nhapTen.setText("");
		nhapDC.setText("");
		nhapLuong.setText("");
		nhapMK.setText("");
		nhapTK.setText("");
		nhapSDT.setText("");
		table.clearSelection();
		
	}

	private void docDuLieuDatabaseVaoTable() {
		List<TaiKhoan> listtk = tk_dao.getAllTableTaiKhoan();
		List<NhanVien> listnv = nv_dao.getAllTableNhanVien();
		for (NhanVien nv : listnv) {
			for(Entity.TaiKhoan tk : listtk) {
				String mk = null;
				if(nv.getTaiKhoan().getTaiKhoan().equals(tk.getTaiKhoan())) {
					mk = tk.getMatKhau();
				}
				if(mk != null) {
					modelTable.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getDiaChi(),nv.getSoDienThoai(),nv.getLuong(),nv.getTaiKhoan().getTaiKhoan(),nv.getChucVu(),mk});
				}
			}
		}
	}
}
