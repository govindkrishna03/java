
package gui;
import gui.MaintenancePanel;
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
                // Corrected to match the button's text
                if ("Maintenance".equalsIgnoreCase(text)) {
                    SwingUtilities.invokeLater(() -> {
                        JFrame repairFrame = new JFrame("Repair Panel");
                       
                        repairFrame.getContentPane().add(new MaintenancePanel());
                        repairFrame.pack();
                        repairFrame.setLocationRelativeTo(null);
                        repairFrame.setVisible(true);
                    });
                }
                

                // Add other conditions for additional buttons here
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