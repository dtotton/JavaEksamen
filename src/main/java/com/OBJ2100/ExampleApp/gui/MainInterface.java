package com.OBJ2100.ExampleApp.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface frame = new MainInterface();
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
	public MainInterface() {
		setBackground(new Color(100, 149, 237));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\2 år\\APP2000\\App\\Backups\\hundenmin\\dist\\assets\\Staale-hode-8dad3f40.jpg"));
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1110, 552);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.setBackground(new Color(176, 196, 222));
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		menuBar.add(menuFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Item 1");
		menuFile.add(mntmNewMenuItem);
		
		JSeparator separator_2 = new JSeparator();
		menuFile.add(separator_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Item 2");
		menuFile.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Database");
		mnNewMenu_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Check database connection");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_2.add(separator_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Erase Database");
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Help");
		mnNewMenu_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Call Ståle");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Documentation");
		mnNewMenu_1.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTestConnection = new JButton("Test database connection");
		btnTestConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTestConnection.setBackground(new Color(176, 196, 222));
		btnTestConnection.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTestConnection.setBounds(10, 11, 200, 35);
		contentPane.add(btnTestConnection);
		
		JButton btnExectuteSqlQuery = new JButton("Exectute sql query");
		btnExectuteSqlQuery.setBackground(new Color(176, 196, 222));
		btnExectuteSqlQuery.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExectuteSqlQuery.setBounds(10, 62, 200, 35);
		contentPane.add(btnExectuteSqlQuery);
		
		JButton btAbout = new JButton("About the app");
		btAbout.setBackground(new Color(176, 196, 222));
		btAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btAbout.setBounds(10, 113, 200, 35);
		contentPane.add(btAbout);
		
		JButton btnExitApp = new JButton("Exit app");
		btnExitApp.setBackground(new Color(176, 196, 222));
		btnExitApp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExitApp.setBounds(10, 439, 200, 35);
		contentPane.add(btnExitApp);
		
		JLabel lbFileAccess = new JLabel("File access settings");
		lbFileAccess.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbFileAccess.setBounds(241, 11, 200, 40);
		contentPane.add(lbFileAccess);
		
		JButton btnChangeFolder = new JButton("Change Folder");
		btnChangeFolder.setBackground(new Color(176, 196, 222));
		btnChangeFolder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChangeFolder.setBounds(241, 62, 200, 35);
		contentPane.add(btnChangeFolder);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(241, 50, 600, 1);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(241, 203, 600, 1);
		contentPane.add(separator_1);
		
		JRadioButton rbtCity = new JRadioButton("by City");
		rbtCity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtCity.setSelected(true);
		rbtCity.setBackground(new Color(230, 230, 250));
		rbtCity.setBounds(250, 215, 109, 23);
		contentPane.add(rbtCity);
		
		JRadioButton rbtState = new JRadioButton("by State");
		rbtState.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rbtState.setBackground(new Color(230, 230, 250));
		rbtState.setBounds(250, 250, 109, 23);
		contentPane.add(rbtState);
		
		JComboBox comboCity = new JComboBox();
		comboCity.setBackground(new Color(211, 211, 211));
		comboCity.setToolTipText("Select state");
		comboCity.setBounds(376, 215, 200, 22);
		contentPane.add(comboCity);
		
		JComboBox comboState = new JComboBox();
		comboState.setBackground(new Color(211, 211, 211));
		comboState.setToolTipText("Select City");
		comboState.setBounds(376, 250, 200, 22);
		contentPane.add(comboState);
		
		JButton btnWriteCustomersList = new JButton("Write customers list that match selected criterea into file");
		btnWriteCustomersList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWriteCustomersList.setBackground(new Color(176, 196, 222));
		btnWriteCustomersList.setBounds(241, 290, 420, 35);
		contentPane.add(btnWriteCustomersList);
		
		JLabel lblReportsAndUpdates = new JLabel("Reports and updates");
		lblReportsAndUpdates.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReportsAndUpdates.setBounds(251, 376, 200, 50);
		contentPane.add(lblReportsAndUpdates);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(Color.BLACK);
		separator_1_1.setBackground(Color.BLACK);
		separator_1_1.setBounds(250, 425, 500, 1);
		contentPane.add(separator_1_1);
		
		JButton btnAddEmployee = new JButton("Add or modify employee");
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddEmployee.setBackground(new Color(176, 196, 222));
		btnAddEmployee.setBounds(250, 439, 200, 35);
		contentPane.add(btnAddEmployee);
		
		JButton btnListProducts = new JButton("List all products");
		btnListProducts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListProducts.setBackground(new Color(176, 196, 222));
		btnListProducts.setBounds(460, 439, 200, 35);
		contentPane.add(btnListProducts);
		
		JButton btnListOffices = new JButton("List all offices");
		btnListOffices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnListOffices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListOffices.setBackground(new Color(176, 196, 222));
		btnListOffices.setBounds(670, 439, 200, 35);
		contentPane.add(btnListOffices);
		
		JButton btnBulkImport = new JButton("Bulk import of orders");
		btnBulkImport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBulkImport.setBackground(new Color(176, 196, 222));
		btnBulkImport.setBounds(880, 439, 200, 35);
		contentPane.add(btnBulkImport);
		
		JLabel lbCurrentFolder = new JLabel("Current Folder: c:/My Documents/exam/2023/employees");
		lbCurrentFolder.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbCurrentFolder.setBounds(241, 110, 500, 40);
		contentPane.add(lbCurrentFolder);
		
		JLabel lblListCustomers = new JLabel("List customers");
		lblListCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblListCustomers.setBounds(241, 164, 200, 40);
		contentPane.add(lblListCustomers);
	}
}
