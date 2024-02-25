package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel logoLabel = new JLabel(new ImageIcon("~/Downloads/Logo.png"));
        add(logoLabel, gbc);

        gbc.gridy++;
        JLabel titleLabel = new JLabel("CampusConnect");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel usernameLabel = new JLabel("Username:");
        add(usernameLabel, gbc);

        gbc.gridy++;
        usernameField = new JTextField(15);
        add(usernameField, gbc);

        gbc.gridy++;
        JLabel passwordLabel = new JLabel("Password:");
        add(passwordLabel, gbc);

        gbc.gridy++;
        passwordField = new JPasswordField(15);
        add(passwordField, gbc);

        gbc.gridy++;
        gbc.fill = GridBagConstraints.NONE;
        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 40)); 
        loginButton.setBackground(new Color(0, 102, 102)); 
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14)); 
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Check login credentials here
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }

                // Clear fields after login attempt
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        add(loginButton, gbc);

        gbc.gridx++;
        JButton clearButton = new JButton("Clear");
        clearButton.setPreferredSize(new Dimension(100, 40)); // Customize button size
        clearButton.setBackground(new Color(255, 51, 51)); // Customize button background color
        clearButton.setForeground(Color.WHITE); // Set text color
        clearButton.setFont(new Font("Arial", Font.BOLD, 14)); // Set font
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        add(clearButton, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        JLabel footerLabel = new JLabel("Copyright ©  CampusConnect. All rights reserved.");
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(footerLabel, gbc);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new LoginPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
