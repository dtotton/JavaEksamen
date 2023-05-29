package com.OBJ2100.ExampleApp.gui;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JScrollPane;
import com.OBJ2100.ExampleApp.db.DatabaseHelper;
import com.OBJ2100.ExampleApp.db.Employee;
import com.OBJ2100.ExampleApp.documents.DocumentsManager;

public class MainContent extends JPanel implements DocumentsManager {

    private Font bigFont = new Font("Calibri", Font.PLAIN, 40);
    private DatabaseHelper dbHelper = new DatabaseHelper();
    private final JFileChooser fc = new JFileChooser();
    private JLabel nameLabel = new JLabel("First name:");
    private JTextField nameTextField = new JTextField(10);
    private JLabel lastnameLabel = new JLabel("Last name:");
    private JTextField lastnameTextField = new JTextField(10);
    private JButton addEmployeeButton = new JButton("Save employee");
    private JButton displayEmployees = new JButton("Display employees");
    private JButton clear = new JButton("Clear results");
    private JButton storeInFile = new JButton("Store results");
    private JButton importFromFile = new JButton("Import data");
    private JTextArea results = new JTextArea();
    private JButton updateEmployeeButton = new JButton("Update employee");
    private JButton deleteEmployeeButton = new JButton("Delete employee");
    private JButton exitButton = new JButton("Exit");
    private static final long serialVersionUID = 1L;
    private final static String newline = "\n";

    public MainContent() {
        super();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        nameLabel.setFont(bigFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        nameTextField.setFont(bigFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(nameTextField, gbc);

        lastnameLabel.setFont(bigFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lastnameLabel, gbc);

        lastnameTextField.setFont(bigFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(lastnameTextField, gbc);

        JScrollPane scrollPane = new JScrollPane(results);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 1.0;  // Give vertical weight to JTextArea
        gbc.fill = GridBagConstraints.BOTH;  // Fill both horizontally and vertically
        add(scrollPane, gbc);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbcButton = new GridBagConstraints();
        gbcButton.fill = GridBagConstraints.HORIZONTAL;
        gbcButton.insets = new Insets(10, 10, 10, 10);

        gbcButton.gridx = 5;
        gbcButton.gridy = 3;
        add(buttonPanel, gbcButton);
        
        addEmployeeButton.setFont(bigFont);
        gbc.gridx = 5;
        gbc.gridy = 0;
        add(addEmployeeButton, gbc);
        addEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    dbHelper.addEmployee(getFirstName(), getLastName(), "HR", "temp@usn.no", 35000);
                    displayMessage("Successful update!");
                } catch (SQLException e1) {
                    displayMessage("Something went wrong!");
                }
            }
        });

       
        gbcButton.gridx = 0;
        gbcButton.gridy = 3;
        gbcButton.gridwidth = 1;
        buttonPanel.add(displayEmployees, gbcButton);
        displayEmployees.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    List<Employee> employees = dbHelper.getEmployees();
                    results.setText("");
                    for (Employee employee : employees) {
                        results.append(employee.getFirstName() + ", " + employee.getLastName() + newline);
                    }
                } catch (SQLException e1) {
                    displayMessage("Error in fetching employees");
                }
            }
        });
        gbcButton.gridx = 1;
        gbcButton.gridy = 5;
        clear.setFont(bigFont);
        buttonPanel.add(clear);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                results.setText("");
            }
        });
        // Creating update employee button
        gbcButton.gridx = 0;
        gbcButton.gridy = 6;
        updateEmployeeButton.setFont(bigFont);
        buttonPanel.add(updateEmployeeButton, gbcButton);

        updateEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName();
                String lastName = getLastName();

                try {
                    Employee employee = dbHelper.getEmployee(firstName, lastName);
                    if (employee != null) {
                        // Show a dialog to enter the updated employee information
                        String newDepartment = JOptionPane.showInputDialog("Enter new department:");
                        String newEmail = JOptionPane.showInputDialog("Enter new email:");
                        String newSalaryString = JOptionPane.showInputDialog("Enter new salary:");
                        double newSalary = Double.parseDouble(newSalaryString);

                        dbHelper.updateEmployee(firstName, lastName, newDepartment, newEmail, newSalary);
                        displayMessage("Successfully updated employee!");
                    } else {
                        displayMessage("Employee not found!");
                    }
                } catch (SQLException ex) {
                    displayMessage("Something went wrong!");
                }
            }
        });
        // Creating delete employee button
        gbcButton.gridy = 7;
        deleteEmployeeButton.setFont(bigFont);
        buttonPanel.add(deleteEmployeeButton, gbcButton);

        deleteEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = getFirstName();
                String lastName = getLastName();

                try {
                    Employee employee = dbHelper.getEmployee(firstName, lastName);
                    if (employee != null) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this employee?");
                        if (confirm == JOptionPane.YES_OPTION) {
                            dbHelper.deleteEmployee(firstName, lastName);
                            displayMessage("Successfully deleted employee!");
                        }
                    } else {
                        displayMessage("Employee not found!");
                    }
                } catch (SQLException ex) {
                    displayMessage("Something went wrong!");
                }
            }
        });

        gbcButton.gridy = 8;
        clear.setFont(bigFont);
        buttonPanel.add(clear, gbcButton);
        

        gbcButton.gridy = 9;
        storeInFile.setFont(bigFont);
        buttonPanel.add(storeInFile, gbcButton);
        storeInFile.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        		
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setDialogTitle("Specify a file to save");
                
                //set default folder
                fc.setCurrentDirectory(new File("c:\\temp"));
                
                // adding filter to only accept .txt
                FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt", "text");
                fc.setFileFilter(filter);
                
                int returnVal = fc.showSaveDialog(null);
                
        		if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fc.getSelectedFile();

                    try {
						writeToFile(results.getText(), fileToSave);
						displayMessage("Succesfull update!");
					} catch (IOException e1) {
						displayMessage("Error writing into file");
					}

                }
        	} 
        });
        

        gbcButton.gridy = 11;
        exitButton.setFont(bigFont);
        buttonPanel.add(exitButton, gbcButton);
        exitButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        	    System.exit(0);
        	} 
        });

        gbcButton.gridy = 10;
        importFromFile.setFont(bigFont);
        buttonPanel.add(importFromFile, gbcButton);
        importFromFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fc.setDialogTitle("Select a file or directory to import");

                // Set default folder
                fc.setCurrentDirectory(new File("c:\\temp"));

                int returnVal = fc.showOpenDialog(null);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fc.getSelectedFile();

                    if (selectedFile.isDirectory()) {
                        File[] files = selectedFile.listFiles();
                        for (File file : files) {
                            if (file.isFile()) {
                                try {
                                    readFromFile(file);
                                    displayMessage("Imported file: " + file.getName());
                                } catch (IOException e1) {
                                    displayMessage("Error reading file: " + file.getName());
                                }
                            }
                        }
                        displayMessage("Import complete!");
                    } else if (selectedFile.isFile()) {
                        try {
                            readFromFile(selectedFile);
                            displayMessage("Imported file: " + selectedFile.getName());
                        } catch (IOException e1) {
                            displayMessage("Error reading file: " + selectedFile.getName());
                        }
                    }
                }
            }
        });       
        
	} String getFirstName() {
		return nameTextField.getText();
	}
	
	public String getLastName() {
		return lastnameTextField.getText();
	}
	
	// simple method that display option pane with the provided message
	private void displayMessage(String message) {
		UIManager.put("OptionPane.messageFont", bigFont);
		UIManager.put("OptionPane.buttonFont", bigFont);
		JOptionPane.showMessageDialog(this, message);
	}
	
	
	// this method overrides the one from the interface
	// it is not used in this version of the software
	/*@Override
	public String readFromFile(File file) throws IOException {
		// TODO
		return null;
	} */
	public String readFromFile(File file) throws IOException {
	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] values = line.split(",");
	            
	            String lastName = "";
	            String firstName = "";
	            String email = "";
	            String department = "";
	            double salary = 0.0;
	            
	            if (values.length >= 1 && !values[0].isEmpty()) {
	                lastName = values[0].trim();
	            }
	            if (values.length >= 2 && !values[1].isEmpty()) {
	                firstName = values[1].trim();
	            }
	            if (values.length >= 3 && !values[2].isEmpty()) {
	                email = values[2].trim();
	            }
	            if (values.length >= 4 && !values[3].isEmpty()) {
	                department = values[3].trim();
	            }
	            if (values.length >= 5 && !values[4].isEmpty()) {
	                try {
	                    salary = Double.parseDouble(values[4].trim());
	                } catch (NumberFormatException e) {
	                    displayMessage("Invalid salary value: " + values[4]);
	                    continue;
	                }
	            }
	            
	            try {
	                dbHelper.addEmployee(firstName, lastName, department, email, salary);
	                results.append("Imported: " + line + newline);
	                System.out.println("Imported: " + line);
	            } catch (SQLException e) {
	                results.append("Failed: " + line + newline);
	                System.out.println("Failed: " + line);
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	
	//method that writes text into the file
	// this version does not give warning about overwriting the file content
	@Override
    public void writeToFile(String text, File file) throws IOException {
        if (!file.getName().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(text);
        writer.close();

    }

}
