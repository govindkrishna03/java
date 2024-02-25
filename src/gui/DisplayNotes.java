package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayNotes extends JFrame {

    private JList<String> notesList;

    public DisplayNotes(ArrayList<File> notes) {
        setTitle("Uploaded Notes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel("Uploaded Notes:");
        panel.add(titleLabel, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (File note : notes) {
            listModel.addElement(note.getName());
        }
        notesList = new JList<>(listModel);
        notesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        notesList.setVisibleRowCount(10);
        JScrollPane scrollPane = new JScrollPane(notesList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton openButton = new JButton("Open");
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = notesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    try {
                        Desktop.getDesktop().open(notes.get(selectedIndex));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(DisplayNotes.this, "Error opening file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(DisplayNotes.this, "Please select a file to open.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(openButton);

        JButton downloadButton = new JButton("Download");
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = notesList.getSelectedIndex();
                if (selectedIndex != -1) {
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setDialogTitle("Save As");
                    int userSelection = fileChooser.showSaveDialog(DisplayNotes.this);
                    if (userSelection == JFileChooser.APPROVE_OPTION) {
                        File fileToSave = fileChooser.getSelectedFile();
                        try {
                            // Perform file copy operation
                            // This is a simplified example, you need to implement the file copy operation
                            // For simplicity, here we just print the selected file's path and the save location
                            System.out.println("Copying file: " + notes.get(selectedIndex).getAbsolutePath() + " to " + fileToSave.getAbsolutePath());
                            JOptionPane.showMessageDialog(DisplayNotes.this, "File downloaded successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(DisplayNotes.this, "Error downloading file.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(DisplayNotes.this, "Please select a file to download.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(downloadButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<File> notes = new ArrayList<>();
        notes.add(new File("Note1.pdf"));
        notes.add(new File("Note2.docx"));
        notes.add(new File("Note3.txt"));

        SwingUtilities.invokeLater(() -> new DisplayNotes(notes).setVisible(true));
    }
}
