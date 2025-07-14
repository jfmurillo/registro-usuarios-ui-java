package org.lab1JM.view;

import com.formdev.flatlaf.FlatDarkLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    private JPanel contentPanel;

    public MainMenu() {
        setTitle("User Registration Form");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // fuente
        UIManager.put("Label.font", new Font("Roboto", Font.BOLD, 13));
        UIManager.put("Button.font", new Font("Roboto", Font.PLAIN, 11));

        // menú lateral
        //JPanel menuPanel = new JPanel(new MigLayout("wrap 1", "[fill]", "[]20[]20[]"));
        //menuPanel.setBackground(new Color(40, 44, 52));

        JPanel menuPanel = new JPanel(new MigLayout(
                "wrap 1, aligny center",
                "[fill, grow]",
                ""
        ));
        menuPanel.setBackground(new Color(40, 44, 52));
        menuPanel.setPreferredSize(new Dimension(200, 0));


        JButton btnRegister = createMenuButton("Register User");
        JButton btnEdit = createMenuButton("Update User");
        JButton btnDelete = createMenuButton("Delete User");
        JButton btnExit = createMenuButton("Exit"); 


        menuPanel.add(btnRegister);
        menuPanel.add(btnEdit);
        menuPanel.add(btnDelete);
        menuPanel.add(Box.createVerticalStrut(50));
        menuPanel.add(btnExit);

        contentPanel = new JPanel(new BorderLayout());

        add(menuPanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);

        btnRegister.addActionListener(e -> showPanel(new RegisterPanel()));
        btnEdit.addActionListener(e -> showPanel(new EditPanel()));
        btnDelete.addActionListener(e -> showPanel(new DeletePanel()));
        btnExit.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Are you sure you want to exit?",
                    "Exit",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        Color baseColor;
        Color hoverColor;

        switch (text) {
            case "Register User" -> {
                baseColor = new Color(33, 37, 41);
                hoverColor = new Color(0, 110, 198);
            }
            case "Update User" -> {
                baseColor = new Color(33, 37, 41);
                hoverColor = new Color(255, 160, 0);
            }
            case "Delete User" -> {
                baseColor = new Color(33, 37, 41);
                hoverColor = new Color(200, 35, 51);
            }
            case "Exit" -> {
                baseColor = new Color(33, 37, 41);
                hoverColor = new Color(52, 58, 64);
            }
            default -> {
                baseColor = new Color(70, 80, 90);
                hoverColor = baseColor.darker();
            }
        }

        button.setBackground(baseColor);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(baseColor);
            }
        });
        return button;
    }

    private void showPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            System.out.println("Error setting look and feel.");
        }

        SwingUtilities.invokeLater(MainMenu::new);
    }
}
