package gui;

import javax.swing.*;
import java.awt.*;

public class NotificationPanel extends JPanel {

    public NotificationPanel() {
        initComponents();
    }

    private void initComponents() {
        // Set layout
        setLayout(new BorderLayout());

        // Create title label
        JLabel titleLabel = new JLabel("Notifications/News");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create text area for notifications
        JTextArea notificationArea = new JTextArea();
        notificationArea.setEditable(false);
        notificationArea.setFont(new Font("Arial", Font.PLAIN, 14));
        notificationArea.setLineWrap(true);
        notificationArea.setWrapStyleWord(true);

        // Add scroll pane for notifications text area
        JScrollPane scrollPane = new JScrollPane(notificationArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Add components to panel
        add(titleLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Example: Populate notification area with sample data
        notificationArea.setText("1. Welcome to CampusConnect!\n" +
                                 "2. New event: Guest lecture on Robotics.\n" +
                                 "3. Maintenance notice: Building A will be closed for renovations.");

        // Set panel properties
        setPreferredSize(new Dimension(600, 400));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    // Main method for testing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Notification Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new NotificationPanel());
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        });
    }
}
