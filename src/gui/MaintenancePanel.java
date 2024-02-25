package gui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class MaintenancePanel extends JPanel {

    public MaintenancePanel() {
        setLayout(new BorderLayout(0, 10));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel titleLabel = new JLabel("Report Repair");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(5, 10, 5, 15));
        add(inputPanel, BorderLayout.CENTER);

        JTextField equipmentField = new JTextField();
        addPlaceholder(equipmentField, "Select Equipment");
        inputPanel.add(equipmentField);

        JTextField issueField = new JTextField();
        addPlaceholder(issueField, "Describe the Issue");
        inputPanel.add(issueField);

        JTextArea solutionArea = new JTextArea();
        solutionArea.setLineWrap(true);
        solutionArea.setWrapStyleWord(true);
        addPlaceholder(solutionArea, "Provide a Solution");
        JScrollPane scrollPane = new JScrollPane(solutionArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        inputPanel.add(scrollPane);

        JButton reportButton = new JButton("Report");
        reportButton.setFont(new Font("Arial", Font.PLAIN, 16));
        reportButton.addActionListener(e -> {
            // Handle report button click
            String equipment = equipmentField.getText();
            String issue = issueField.getText();
            String solution = solutionArea.getText();
            System.out.println("Equipment: " + equipment);
            System.out.println("Issue: " + issue);
            System.out.println("Solution: " + solution);
        });
        add(reportButton, BorderLayout.SOUTH);
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
            JFrame frame = new JFrame("Repair Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new MaintenancePanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}