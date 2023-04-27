package weew;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonCRUDGUI extends JFrame implements ActionListener {
    private DefaultListModel<Person> listModel;
    private JList<Person> personList;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField birthDateField;
    private JTextField emailField;
    private JRadioButton maleRadioBtn;
    private JRadioButton femaleRadioBtn;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    public PersonCRUDGUI() {
        // Set up the JFrame
        setTitle("Person CRUD GUI");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the list model and list
        listModel = new DefaultListModel<>();
        personList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(personList);

        // Set up the input fields
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel birthDateLabel = new JLabel("Birth Date:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel sexLabel = new JLabel("Sex:");
        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        birthDateField = new JTextField(10);
        emailField = new JTextField(20);
        maleRadioBtn = new JRadioButton("Male");
        femaleRadioBtn = new JRadioButton("Female");
        ButtonGroup sexButtonGroup = new ButtonGroup();
        sexButtonGroup.add(maleRadioBtn);
        sexButtonGroup.add(femaleRadioBtn);

        // Set up the buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        // Set up the layout
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(birthDateLabel);
        inputPanel.add(birthDateField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(sexLabel);
        inputPanel.add(maleRadioBtn);
        inputPanel.add(new JLabel());
        inputPanel.add(femaleRadioBtn);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        PersonCRUDGUI gui = new PersonCRUDGUI();
        gui.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Add a new person to the list
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            LocalDate birthDate = LocalDate.parse(birthDateField.getText());
            String email = emailField.getText();
            String sex = maleRadioBtn.isSelected() ? "Male" : "Female";
            Person person = new Person(firstName, lastName, birthDate, email, sex);
            listModel.addElement(person);
            System.out.println("");
            System.out.println("New Person was Added");
            System.out.println(person);
        }  else if (e.getSource() == updateButton) {
            // Update an existing item in the list
            int index = personList.getSelectedIndex();
            if (index != -1) {
	        	String firstName = firstNameField.getText();
	            String lastName = lastNameField.getText();
	            LocalDate birthDate = LocalDate.parse(birthDateField.getText());
	            String email = emailField.getText();
	            String sex = maleRadioBtn.isSelected() ? "Male" : "Female";
                Person person = new Person(firstName, lastName, birthDate, email, sex);
                listModel.setElementAt(person, index);
                System.out.println("");
                System.out.println("Person was Edited");
                System.out.println(person);
            }
        } else if (e.getSource() == deleteButton) {
            // Delete an item from the list
            int index = personList.getSelectedIndex();
            if (index != -1) {
                listModel.removeElementAt(index);
                System.out.println("");
                System.out.println("Person was Deleted");
            }
        }
    }
}