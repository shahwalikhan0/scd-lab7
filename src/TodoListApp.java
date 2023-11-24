//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TodoListApp extends JFrame {
//    private JTextField taskField;
//    private JButton addButton;
//    private JList<String> todoList;
//    private DefaultListModel<String> listModel;
//
//    public TodoListApp() {
//        setTitle("Todo List");
//        setSize(300, 400);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        taskField = new JTextField();
//
//        addButton = new JButton("Add");
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String task = taskField.getText();
//                if (!task.isEmpty()) {
//                    listModel.addElement(task);
//                    taskField.setText("");
//                }
//            }
//        });
//
//        listModel = new DefaultListModel<>();
//        todoList = new JList<>(listModel);
//        todoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//
//        JButton deleteButton = new JButton("Delete");
//        deleteButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedIndex = todoList.getSelectedIndex();
//                if (selectedIndex != -1) {
//                    listModel.remove(selectedIndex);
//                }
//            }
//        });
//
//        JButton completeButton = new JButton("Complete");
//        completeButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int selectedIndex = todoList.getSelectedIndex();
//                if (selectedIndex != -1) {
//                    String task = listModel.getElementAt(selectedIndex);
//                    listModel.setElementAt("[Completed] " + task, selectedIndex);
//                }
//            }
//        });
//
//        setLayout(new BorderLayout());
//        JPanel inputPanel = new JPanel(new BorderLayout());
//        inputPanel.add(taskField, BorderLayout.CENTER);
//        inputPanel.add(addButton, BorderLayout.EAST);
//        add(inputPanel, BorderLayout.NORTH);
//        add(new JScrollPane(todoList), BorderLayout.CENTER);
//        JPanel buttonPanel = new JPanel(new FlowLayout());
//        buttonPanel.add(deleteButton);
//        buttonPanel.add(completeButton);
//        add(buttonPanel, BorderLayout.SOUTH);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                TodoListApp app = new TodoListApp();
//                app.setVisible(true);
//            }
//        });
//    }
//}
