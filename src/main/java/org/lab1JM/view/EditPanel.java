package org.lab1JM.view;

import net.miginfocom.swing.MigLayout;
import org.lab1JM.controller.UserController;
import org.lab1JM.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditPanel extends JPanel {

    private JTextField txtId = new JTextField(10);
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JPasswordField txtPassword = new JPasswordField(20);
    private JButton btnSearch = new JButton("Search");
    private JButton btnUpdate = new JButton("Update");

    private UserController controller = new UserController();
    private User currentUser = null;

    public EditPanel() {
        setLayout(new MigLayout("wrap 2", "[right][grow,fill]", "[]10[]10[]10[]10[]10[]"));

        add(new JLabel("ID User:"));
        add(txtId);

        add(new JLabel(""));
        add(btnSearch);

        add(new JLabel("Name:"));
        add(txtName);

        add(new JLabel("Email:"));
        add(txtEmail);

        add(new JLabel("Password:"));
        add(txtPassword);

        add(new JLabel(""));
        add(btnUpdate);

        setFormEnabled(false);

        btnSearch.addActionListener(this::searchUser);
        btnUpdate.addActionListener(this::updateUser);
    }

    private void searchUser(ActionEvent e) {
        try {
            int id = Integer.parseInt(txtId.getText());
            currentUser = controller.getUserById(id);

            if (currentUser != null) {
                txtName.setText(currentUser.getName());
                txtEmail.setText(currentUser.getEmail());
                txtPassword.setText(currentUser.getPassword());
                setFormEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "User not found");
                setFormEnabled(false);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID");
        }
    }

    private void updateUser(ActionEvent e) {
        if (currentUser == null) return;

        currentUser.setName(txtName.getText());
        currentUser.setEmail(txtEmail.getText());
        currentUser.setPassword(new String(txtPassword.getPassword()));

        boolean updated = controller.updateUser(currentUser);

        if (updated) {
            JOptionPane.showMessageDialog(this, "Changed user successfully");
        } else {
            JOptionPane.showMessageDialog(this, "Error while updating user");
        }
    }

    private void setFormEnabled(boolean enabled) {
        txtName.setEnabled(enabled);
        txtEmail.setEnabled(enabled);
        txtPassword.setEnabled(enabled);
        btnUpdate.setEnabled(enabled);
    }
}
