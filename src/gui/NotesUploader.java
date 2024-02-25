package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class NotesUploader extends JFrame {

    private JLabel statusLabel;

    public NotesUploader() {
        setTitle("Notes Uploader");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton browseButton = new JButton("Select File");
        browseButton.setFont(new Font("Arial", Font.PLAIN, 16));
        browseButton.setBorder(BorderFactory.createTitledBorder("Browse"));
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    uploadNotes(selectedFile.getAbsolutePath());
                }
            }
        });
        panel.add(browseButton, gbc);

        gbc.gridy++;
        JButton uploadButton = new JButton("Upload File");
        uploadButton.setFont(new Font("Arial", Font.PLAIN, 16));
        uploadButton.setBorder(BorderFactory.createTitledBorder("Upload"));
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement upload functionality directly without specifying a file path
                uploadNotes("");
            }
        });
        panel.add(uploadButton, gbc);

        gbc.gridy++;
        statusLabel = new JLabel(" ");
        statusLabel.setBorder(BorderFactory.createTitledBorder("Status"));
        panel.add(statusLabel, gbc);

        add(panel);
    }

    private void uploadNotes(String filePath) {
        // Implement upload notes functionality
        // For simplicity, let's just print a status message
        if (filePath.isEmpty()) {
            setStatus("Uploading notes...");
        } else {
            setStatus("Uploading notes from file: " + filePath);
        }
        // Simulate upload process
        try {
            Thread.sleep(2000); // Simulating upload process
            setStatus("Notes uploaded successfully.");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void setStatus(String message) {
        statusLabel.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NotesUploader().setVisible(true);
            }
        });
    }
}
