import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;

public class MonthlyCalendarApp extends JFrame {

    private JTable calendarTable;
    private HashMap<String, String> eventsMap;

    public MonthlyCalendarApp() {
        setTitle("Monthly Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        Object[][] data = new Object[5][7];

        eventsMap = new HashMap<>();
        eventsMap.put("2023-10-15", "Meeting");
        eventsMap.put("2023-10-22", "Birthday");

        DefaultTableModel model = new DefaultTableModel(data, columns);
        calendarTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(calendarTable);

        calendarTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = calendarTable.getSelectedRow();
                int col = calendarTable.getSelectedColumn();
                Object date = calendarTable.getValueAt(row, col);

                if (date != null) {
                    String formattedDate = "2023-10-" + date;
                    String event = eventsMap.get(formattedDate);
                    if (event != null) {
                        JOptionPane.showMessageDialog(this, "Event: " + event);
                    } else {
                        String newEvent = JOptionPane.showInputDialog(this, "Add event for this date:");
                        if (newEvent != null && !newEvent.isEmpty()) {
                            eventsMap.put(formattedDate, newEvent);
                        }
                    }
                }
            }
        });

        add(scrollPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MonthlyCalendarApp().setVisible(true);
            }
        });
    }
}
