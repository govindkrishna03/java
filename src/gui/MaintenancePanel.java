package gui;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MaintenancePanel extends JPanel {

    public MaintenancePanel() {
        setLayout(new BorderLayout(0, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Request Maintenance");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 1, 0, 5));
        add(inputPanel, BorderLayout.CENTER);

        JTextField buildingField = new JTextField();
        addPlaceholder(buildingField, "Select Building");
        inputPanel.add(buildingField);

        JTextField classField = new JTextField();
        addPlaceholder(classField, "Select Class");
        inputPanel.add(classField);

        JTextArea problemArea = new JTextArea();
        problemArea.setLineWrap(true);
        problemArea.setWrapStyleWord(true);
        addPlaceholder(problemArea, "Describe the problem");
        JScrollPane scrollPane = new JScrollPane(problemArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inputPanel.add(scrollPane);

        JButton requestButton = new JButton("Request");
        requestButton.setFont(new Font("Arial", Font.PLAIN, 16));
        requestButton.addActionListener(e -> {
            // Handle request button click
            String building = buildingField.getText();
            String classroom = classField.getText();
            String problem = problemArea.getText();
            System.out.println("Building: " + building);
            System.out.println("Classroom: " + classroom);
            System.out.println("Problem: " + problem);
        });
        add(requestButton, BorderLayout.SOUTH);
    }

    private void addPlaceholder(JTextComponent textComponent, String placeholder) {
        textComponent.setText(placeholder);
        textComponent.setForeground(Color.GRAY);
        textComponent.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textComponent.getText().equals(placeholder)) {
                    textComponent.setText("");
                    textComponent.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textComponent.getText().isEmpty()) {
                    textComponent.setText(placeholder);
                    textComponent.setForeground(Color.GRAY);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Maintenance Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new MaintenancePanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
