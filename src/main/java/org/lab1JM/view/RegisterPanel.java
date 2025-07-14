package org.lab1JM.view;

import net.miginfocom.swing.MigLayout;
import org.lab1JM.controller.UserController;
import org.lab1JM.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RegisterPanel extends JPanel {
    private JTextField txtName = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JPasswordField txtPassword = new JPasswordField(20);
    private JButton btnRegister = new JButton("Register User");

    private UserController controller = new UserController();

    public RegisterPanel() {
        setLayout(new MigLayout("wrap 2", "[right][grow, fill]", "[]15[]15[]15[]15[]"));

        add(new JLabel("Name:"));
        add(txtName);

        add(new JLabel("Email:"));
        add(txtEmail);

        add(new JLabel("Password:"));
        add(txtPassword);

        add(new JLabel(""));
        add(btnRegister);

        btnRegister.addActionListener(this::registerAction);
    }

    private void registerAction(ActionEvent e) {
        String name = txtName.getText();
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());

        User user = new User(name, email, password);
        boolean success = controller.register(user);

        if (success) {
            JLabel successLabel = new JLabel(
                    "<html><center><b>¡Usuario creado correctamente!</b><br>ID generado: " + user.getUserID() + "</center></html>"
            );
            successLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            successLabel.setForeground(new Color(40, 167, 69));

            JOptionPane.showMessageDialog(
                    this,
                    successLabel,
                    "User registered successfully!",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JLabel errorLabel = new JLabel(
                    "<html><center><b>Error while creating user.</b><br>Please check your data.</center></html>"
            );
            errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            errorLabel.setForeground(new Color(220, 53, 69)); // rojo error

            JOptionPane.showMessageDialog(
                    this,
                    errorLabel,
                    "Error while creating user!",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
