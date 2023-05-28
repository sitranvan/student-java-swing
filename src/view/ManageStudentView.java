package view;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.City;
import model.ManageStudentModel;
import model.Student;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.ManageStudentController;

import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManageStudentView extends JFrame {

	private JPanel contentPane;
	private ManageStudentModel studentModel;
	private JTable table;
	private JTextField textField_id_info;
	private JTextField textField_id_name;
	private JTextField textField_date_info;
	private JTextField textField_math_info;
	private JTextField textField_chemistry_info;
	private JTextField textField_physical_info;
	public ButtonGroup btn_ground;
	private JComboBox<String> comboBox_city_info;
	private JComboBox<String> comboBox_city;
	private JRadioButton rdbtn_famle_info;
	private JRadioButton rdbtn_male_info;

	public ManageStudentModel getModel() {
		return studentModel;
	}

	public void setModel(ManageStudentModel studentModel) {
		this.studentModel = studentModel;
	}

	
	/**
	 * Create the frame.
	 */
	public ManageStudentView() {

		this.studentModel = new ManageStudentModel();
		ActionListener ac = new ManageStudentController(this, this.studentModel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 659);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(menuFile);

		JMenuItem menuOpen = new JMenuItem("Open File");
		menuOpen.setFont(new Font("Arial", Font.PLAIN, 14));
		menuFile.add(menuOpen);

		JMenuItem menuSave = new JMenuItem("Save File");
		menuSave.setFont(new Font("Arial", Font.PLAIN, 14));
		menuFile.add(menuSave);

		JSeparator separator = new JSeparator();
		menuFile.add(separator);

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Arial", Font.PLAIN, 14));
		menuFile.add(menuExit);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbCity = new JLabel("Filter City");
		lbCity.setFont(new Font("Arial", Font.BOLD, 14));
		lbCity.setBounds(33, 21, 95, 24);
		contentPane.add(lbCity);

		JButton btn_filter = new JButton("Filter");
		btn_filter.setForeground(Color.BLUE);
		btn_filter.setBackground(Color.WHITE);
		btn_filter.setFont(new Font("Arial", Font.BOLD, 14));
		btn_filter.setBounds(471, 21, 120, 24);
		contentPane.add(btn_filter);

		ArrayList<City> listCity = City.getListCity();
		comboBox_city = new JComboBox<String>();
		for (City city : listCity) {
			comboBox_city.addItem(city.getCityName());
		}

		comboBox_city.setBackground(Color.WHITE);
		comboBox_city.setBounds(124, 21, 141, 24);
		contentPane.add(comboBox_city);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(33, 56, 690, 2);
		contentPane.add(separator_1);

		JLabel lblNewLabel = new JLabel("Student list");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(33, 68, 102, 27);
		contentPane.add(lblNewLabel);

		table = new JTable();
		table.setBackground(SystemColor.text);
		table.setFont(new Font("Arial", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "City", "Date", "Sex", "Math", "Physical", "Chemistry" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(42);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);

		Font font = new Font("Arial", Font.BOLD, 14);
		JTableHeader tableHeader = table.getTableHeader();
		tableHeader.setFont(font);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(34, 103, 689, 143);
		contentPane.add(scrollPane);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.LIGHT_GRAY);
		separator_1_1.setBackground(Color.GRAY);
		separator_1_1.setBounds(33, 267, 690, 2);
		contentPane.add(separator_1_1);

		JLabel lblNewLabel_1 = new JLabel("Student Infomation");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(33, 279, 179, 26);
		contentPane.add(lblNewLabel_1);

		JLabel lb_id = new JLabel("ID");
		lb_id.setFont(new Font("Arial", Font.BOLD, 14));
		lb_id.setBounds(33, 312, 45, 24);
		contentPane.add(lb_id);

		textField_id_info = new JTextField();
		textField_id_info.setBackground(Color.WHITE);
		textField_id_info.setBounds(82, 312, 162, 24);
		contentPane.add(textField_id_info);
		textField_id_info.setColumns(10);

		JLabel lb_name = new JLabel("Name");
		lb_name.setFont(new Font("Arial", Font.BOLD, 14));
		lb_name.setBounds(33, 346, 45, 24);
		contentPane.add(lb_name);

		textField_id_name = new JTextField();
		textField_id_name.setBackground(Color.WHITE);
		textField_id_name.setColumns(10);
		textField_id_name.setBounds(82, 346, 162, 24);
		contentPane.add(textField_id_name);

		JLabel lb_city = new JLabel("City");
		lb_city.setFont(new Font("Arial", Font.BOLD, 14));
		lb_city.setBounds(33, 380, 45, 24);
		contentPane.add(lb_city);

		textField_date_info = new JTextField();
		textField_date_info.setBackground(Color.WHITE);
		textField_date_info.setColumns(10);
		textField_date_info.setBounds(82, 414, 162, 24);
		contentPane.add(textField_date_info);

		JLabel lb_date = new JLabel("Date");
		lb_date.setFont(new Font("Arial", Font.BOLD, 14));
		lb_date.setBounds(33, 414, 45, 24);
		contentPane.add(lb_date);

		comboBox_city_info = new JComboBox<String>();
		comboBox_city_info.setToolTipText("");

		for (City city : listCity) {
			comboBox_city_info.addItem(city.getCityName());
		}

		comboBox_city_info.setBackground(Color.WHITE);
		comboBox_city_info.setBounds(82, 380, 162, 24);
		contentPane.add(comboBox_city_info);

		JLabel lb_sex = new JLabel("Sex");
		lb_sex.setFont(new Font("Arial", Font.BOLD, 14));
		lb_sex.setBounds(474, 310, 45, 24);
		contentPane.add(lb_sex);

		JLabel lb_math = new JLabel("Math");
		lb_math.setFont(new Font("Arial", Font.BOLD, 14));
		lb_math.setBounds(474, 344, 45, 24);
		contentPane.add(lb_math);

		textField_math_info = new JTextField();
		textField_math_info.setBackground(Color.WHITE);
		textField_math_info.setColumns(10);
		textField_math_info.setBounds(561, 344, 162, 24);
		contentPane.add(textField_math_info);

		JLabel lb_physical = new JLabel("Physical");
		lb_physical.setFont(new Font("Arial", Font.BOLD, 14));
		lb_physical.setBounds(474, 378, 77, 24);
		contentPane.add(lb_physical);

		JLabel lb_chemistry = new JLabel("Chemistry");
		lb_chemistry.setFont(new Font("Arial", Font.BOLD, 14));
		lb_chemistry.setBounds(474, 412, 77, 24);
		contentPane.add(lb_chemistry);

		textField_chemistry_info = new JTextField();
		textField_chemistry_info.setBackground(Color.WHITE);
		textField_chemistry_info.setColumns(10);
		textField_chemistry_info.setBounds(561, 412, 162, 24);
		contentPane.add(textField_chemistry_info);

		rdbtn_male_info = new JRadioButton("Male");
		rdbtn_male_info.setBackground(Color.WHITE);
		rdbtn_male_info.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtn_male_info.setBounds(561, 310, 61, 24);
		contentPane.add(rdbtn_male_info);

		rdbtn_famle_info = new JRadioButton("Female");
		rdbtn_famle_info.setBackground(Color.WHITE);
		rdbtn_famle_info.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtn_famle_info.setBounds(636, 310, 87, 24);
		contentPane.add(rdbtn_famle_info);

		btn_ground = new ButtonGroup();
		btn_ground.add(rdbtn_famle_info);
		btn_ground.add(rdbtn_male_info);

		textField_physical_info = new JTextField();
		textField_physical_info.setBackground(Color.WHITE);
		textField_physical_info.setColumns(10);
		textField_physical_info.setBounds(561, 378, 162, 24);
		contentPane.add(textField_physical_info);

		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setForeground(Color.LIGHT_GRAY);
		separator_1_1_1.setBackground(Color.GRAY);
		separator_1_1_1.setBounds(33, 466, 690, 2);
		contentPane.add(separator_1_1_1);

		JButton btn_clean = new JButton("Clean");
		btn_clean.setForeground(new Color(0, 0, 255));
		btn_clean.setBackground(new Color(255, 240, 245));
		btn_clean.setFont(new Font("Arial", Font.BOLD, 14));
		btn_clean.setBounds(33, 503, 151, 38);
		contentPane.add(btn_clean);

		JButton btn_delete = new JButton("Delete");
		btn_delete.setForeground(new Color(139, 0, 0));
		btn_delete.setBackground(new Color(255, 240, 245));
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_delete.setFont(new Font("Arial", Font.BOLD, 14));
		btn_delete.setBounds(215, 503, 151, 38);
		contentPane.add(btn_delete);

		JButton btn_update = new JButton("Update");
		btn_update.setForeground(new Color(50, 205, 50));
		btn_update.setBackground(new Color(255, 240, 245));
		btn_update.setFont(new Font("Arial", Font.BOLD, 14));
		btn_update.setBounds(400, 503, 151, 38);
		contentPane.add(btn_update);

		JButton btn_save = new JButton("Save");
		btn_save.setForeground(new Color(0, 0, 128));
		btn_save.setBackground(new Color(255, 240, 245));
		btn_save.setFont(new Font("Arial", Font.BOLD, 14));
		btn_save.setBounds(572, 503, 151, 38);
		contentPane.add(btn_save);

		JButton btn_cancle = new JButton("Cancle");
		btn_cancle.setForeground(Color.RED);
		btn_cancle.setHorizontalAlignment(SwingConstants.LEFT);
		btn_cancle.setFont(new Font("Arial", Font.BOLD, 14));
		btn_cancle.setBackground(Color.WHITE);
		btn_cancle.setBounds(356, 21, 87, 24);
		contentPane.add(btn_cancle);

		// Add event
		btn_clean.addActionListener(ac);
		btn_delete.addActionListener(ac);
		btn_update.addActionListener(ac);
		btn_save.addActionListener(ac);
		btn_cancle.addActionListener(ac);
		btn_filter.addActionListener(ac);
		menuOpen.addActionListener(ac);
		menuSave.addActionListener(ac);
		menuExit.addActionListener(ac);
	}

	public void cleanForm() {
		textField_id_info.setText("");
		textField_id_name.setText("");
		textField_date_info.setText("");
		textField_math_info.setText("");
		textField_physical_info.setText("");
		textField_chemistry_info.setText("");
		comboBox_city_info.setSelectedIndex(-1);
		btn_ground.clearSelection();
		this.textField_id_info.setEnabled(true);
	}

	public Student getInfo() {
		int id = Integer.valueOf(textField_id_info.getText());
		String fullName = textField_id_name.getText();
		int index = comboBox_city_info.getSelectedIndex();
		City city = City.getCityById(index);
		@SuppressWarnings("deprecation")
		Date birthday = new Date(textField_date_info.getText());
		boolean sex = true;
		if (this.rdbtn_male_info.isSelected()) {
			sex = true;
		} else if (this.rdbtn_famle_info.isSelected()) {
			sex = false;
		}
		float subScore_1 = Float.valueOf(textField_math_info.getText());
		float subScore_2 = Float.valueOf(textField_physical_info.getText());
		float subScore_3 = Float.valueOf(textField_chemistry_info.getText());
		return new Student(id, fullName, city, birthday, sex, subScore_1, subScore_2, subScore_3);
	}

	public void insertOrUpdate(Student st) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		if (!this.studentModel.checkExists(st)) {
			// Insert student
			JOptionPane.showMessageDialog(this, "Insert successfully!");
			this.textField_id_info.setEnabled(true);
			this.studentModel.insert(getInfo());
			model.addRow(new Object[] { st.getId() + "", st.getFullName(), st.getCity().getCityName(),
					sf.format(st.getBirthday()), (st.isSex() ? "Male" : "Female"), st.getSubScore_1() + "",
					st.getSubScore_2() + "", st.getSubScore_3() + "" });
		} else {
			// Update student
			Student existingStudent = this.studentModel.findStudentById(st.getId());
			if (existingStudent != null && existingStudent.getId() != st.getId()) {
				JOptionPane.showMessageDialog(this, "Student ID already exists!");
				return;
			}
			JOptionPane.showMessageDialog(this, "Update successfully!");
			this.textField_id_info.setEditable(true);
			this.studentModel.update(st);
			int indexCount = model.getRowCount();
			for (int i = 0; i < indexCount; i++) {
				String id = model.getValueAt(i, 0) + "";
				if (id.equals(st.getId() + "")) {
					model.setValueAt(st.getId() + "", i, 0);
					model.setValueAt(st.getFullName() + "", i, 1);
					model.setValueAt(st.getCity().getCityName() + "", i, 2);
					model.setValueAt(sf.format(st.getBirthday()) + "", i, 3);
					model.setValueAt((st.isSex() ? "Male" : "Female"), i, 4);
					model.setValueAt(st.getSubScore_1() + "", i, 5);
					model.setValueAt(st.getSubScore_2() + "", i, 6);
					model.setValueAt(st.getSubScore_3() + "", i, 7);
				}
			}
		}
	}

	public void edit() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		this.textField_id_info.setEnabled(false);
		int row = table.getSelectedRow();

		int id = Integer.valueOf((String) model.getValueAt(row, 0));
		String fullName = (String) model.getValueAt(row, 1);
		City city = City.getCityByName((String) model.getValueAt(row, 2));
		String birthday_string = (String) model.getValueAt(row, 3);
		String textSex = (String) model.getValueAt(row, 4);
		boolean sex = textSex.equals("Male");
		if (sex) {
			rdbtn_male_info.setSelected(true);
		} else {
			rdbtn_famle_info.setSelected(true);
		}
		float subScore_1 = Float.valueOf((String) model.getValueAt(row, 5));
		float subScore_2 = Float.valueOf((String) model.getValueAt(row, 6));
		float subScore_3 = Float.valueOf((String) model.getValueAt(row, 7));
		this.textField_id_info.setText(id + "");
		this.textField_id_name.setText(fullName);
		this.comboBox_city_info.setSelectedItem(city.getCityName());
		this.textField_date_info.setText(birthday_string);
		this.textField_math_info.setText(subScore_1 + "");
		this.textField_physical_info.setText(subScore_2 + "");
		this.textField_chemistry_info.setText(subScore_3 + "");
	}

	public void delete() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int rowId = Integer.parseInt(table.getValueAt(row, 0).toString());
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to delete?", "Delete",
				JOptionPane.YES_NO_OPTION);
		Student st = this.studentModel.findStudentById(rowId);
		if (choice == JOptionPane.YES_OPTION) {
			this.studentModel.delete(st);
			model.removeRow(row);
			JOptionPane.showMessageDialog(this, "Delete successfully!");
		}
	}

	public void filterByCity() {
		String selectedCity = (String) comboBox_city.getSelectedItem(); // Lấy tỉnh được chọn từ JComboBox
		ArrayList<Student> filteredStudents = new ArrayList<>(); // Tạo danh sách sinh viên đã lọc
		boolean hasStudent = false; // Tạo biến kiểm tra có sinh viên có tỉnh trùng với tỉnh được chọn hay không
		for (Student student : studentModel.getListStudent()) {
			if (student.getCity().getCityName().equals(selectedCity)) { // Nếu sinh viên có tỉnh trùng với tỉnh đã chọn
				filteredStudents.add(student); // Thêm sinh viên vào danh sách đã lọc
				hasStudent = true; // Cập nhật biến kiểm tra có sinh viên có tỉnh trùng với tỉnh được chọn
			}
		}
		if (!hasStudent) { // Kiểm tra nếu không có sinh viên có tỉnh trùng với tỉnh được chọn thì xóa tất
							// cả các dòng trên table và trả về
			DefaultTableModel model = (DefaultTableModel) table.getModel(); // Lấy model hiện tại của table
			JOptionPane.showMessageDialog(this, "No corresponding city found!");
			model.setRowCount(0); // Xóa tất cả các dòng trên table
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel(); // Lấy model hiện tại của table
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		model.setRowCount(0); // Xóa tất cả các dòng trên table
		for (Student student : filteredStudents) { // Thêm các sinh viên đã lọc vào model
			model.addRow(new Object[] { student.getId(), student.getFullName(), student.getCity().getCityName(),
					sf.format(student.getBirthday()), student.isSex() ? "Male" : "Female", student.getSubScore_1(),
					student.getSubScore_2(), student.getSubScore_3() });
		}
	}

	public void cancle() {
		DefaultTableModel model = (DefaultTableModel) table.getModel(); // Lấy model hiện tại của table
		model.setRowCount(0); // Xóa tất cả các dòng trên table
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		for (Student student : studentModel.getListStudent()) { // Thêm toàn bộ sinh viên vào model
			model.addRow(new Object[] { student.getId(), student.getFullName(), student.getCity().getCityName(),
					sf.format(student.getBirthday()), student.isSex() ? "Male" : "Female", student.getSubScore_1(),
					student.getSubScore_2(), student.getSubScore_3() });
		}
		comboBox_city.setSelectedIndex(-1);
	}
	
	public void exit() {
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit",
				JOptionPane.YES_NO_OPTION);
		if(choice==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void saveFile(String path) {
		try {
			this.studentModel.setFileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student st : this.studentModel.getListStudent()) {
				oos.writeObject(st);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public void handleSaveFile() {
		if(this.studentModel.getFileName().length()>0) {
			saveFile(this.studentModel.getFileName());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	
	public void openFile(File file) {
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			this.studentModel.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student st = null;
			while((st = (Student) ois.readObject())!=null) {
				list.add(st);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.studentModel.setListStudent(list);
	}
	public void handleOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			cancle();
		} 
	}
}


