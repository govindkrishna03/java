package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

public class FacAccess extends JFrame {

    public FacAccess() {
        setTitle("Swing Button Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JButton maintenanceButton = createButton("Maintenance", "onMaintenanceButtonClick");
        panel.add(maintenanceButton, gbc);

        JButton bookClassButton = createButton("Book Class/Lab", "onBookClassButtonClick");
        panel.add(bookClassButton, gbc);

        JButton uploadFilesButton = createButton("Upload Files", "onUploadFilesButtonClick");
        panel.add(uploadFilesButton, gbc);

        add(panel);
    }

    private JButton createButton(String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle button click action
                System.out.println("Button clicked: " + text);
                if (actionCommand.equals("onMaintenanceButtonClick")) {
                    try {
                        // Open MaintenancePanel upon clicking the Maintenance button
                        MaintenancePanel maintenancePanel = new MaintenancePanel();
                        maintenancePanel.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else if (actionCommand.equals("onUploadFilesButtonClick")) {
                    try {
                        // Open NotesUploader upon clicking the Upload Files button
                        NotesUploader notesUploader = new NotesUploader();
                        notesUploader.setVisible(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FacAccess().setVisible(true);
            }
        });
    }
}
