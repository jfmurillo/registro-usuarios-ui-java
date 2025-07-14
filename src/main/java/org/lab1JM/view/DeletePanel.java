package org.lab1JM.view;

import net.miginfocom.swing.MigLayout;
import org.lab1JM.controller.UserController;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeletePanel extends JPanel {

    private JTextField txtId = new JTextField(10);
    private JButton btnDelete = new JButton("Delete User");

    private UserController controller = new UserController();

    public DeletePanel() {
        setLayout(new MigLayout("wrap 2", "[right][grow,fill]", "[]20[]"));

        add(new JLabel("User ID:"));
        add(txtId);

        add(new JLabel(""));
        add(btnDelete);

        btnDelete.addActionListener(this::deleteUser);
    }

    private void deleteUser(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            boolean deleted = controller.deleteUser(id);

            if (deleted) {
                JOptionPane.showMessageDialog(this, "User deleted successfully");
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID");
        }
    }
}
