//package org.lab1JM.view;
//
//import com.formdev.flatlaf.FlatDarkLaf;
//import com.formdev.flatlaf.FlatLightLaf;
//import net.miginfocom.swing.MigLayout;
//import org.lab1JM.controller.UserController;
//import org.lab1JM.model.User;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//
//public class RegisterForm extends JFrame {
//
//    private JTextField txtName = new JTextField(20);
//    private JTextField txtEmail = new JTextField(20);
//    private JPasswordField txtPassword = new JPasswordField(20);
//    private JButton btnRegister = new JButton("Register");
//
//    private UserController controller = new UserController();
//
//    public RegisterForm() {
//        setTitle("Registro de Usuario");
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setSize(400, 250);
//        setLocationRelativeTo(null);
//
//        // Layout estilo Bootstrap (columnas, espaciado)
//        JPanel panel = new JPanel(new MigLayout("wrap 2", "[right][grow, fill]", "[]15[]15[]15[]"));
//
//        panel.add(new JLabel("Nombre:"));
//        panel.add(txtName);
//
//        panel.add(new JLabel("Correo:"));
//        panel.add(txtEmail);
//
//        panel.add(new JLabel("Contraseña:"));
//        panel.add(txtPassword);
//
//        panel.add(new JLabel("")); // espacio
//        panel.add(btnRegister, "center");
//
//        add(panel);
//
//        btnRegister.addActionListener(this::registerAction);
//        setVisible(true);
//    }
//
//    private void registerAction(ActionEvent e) {
//        String name = txtName.getText();
//        String email = txtEmail.getText();
//        String password = new String(txtPassword.getPassword());
//
//        User user = new User(name, email, password);
//        boolean success = controller.register(user);
//
//        if (success) {
//            JOptionPane.showMessageDialog(this, "Usuario creado.\nID: " + user.getUserID());
//        } else {
//            JOptionPane.showMessageDialog(this, "Error. Verifique los datos.");
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            // dark mode
//            UIManager.setLookAndFeel(new FlatDarkLaf());
//        } catch (Exception e) {
//            System.err.println("No se pudo aplicar FlatLaf: " + e.getMessage());
//        }
//        SwingUtilities.invokeLater(RegisterForm::new);
//    }
//}
