package br.sc.senac.mcap.view;

import br.sc.senac.mcap.controller.LoginControler;
import br.sc.senac.mcap.model.Login;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class TelaLogin extends JFrame {
    private JPanel panel1;
    private JPasswordField txtSenha;
    private JTextField txtLogin;
    private JButton loginButton;
    private JButton limparButton;

    public TelaLogin() {
        initComponents();
        listeners();
    }
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setContentPane(panel1);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }

    public void listeners() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = txtLogin.getText();
                char[] senha = txtSenha.getPassword();

                try {
                    LoginControler lc = new LoginControler();
                    ArrayList<Login> loginList = lc.buscarLoginSenha();
                    for (Login l : loginList) {
                        if (l.getLogin().equalsIgnoreCase(login) &&
                                l.getSenha().equalsIgnoreCase(new String(senha))) {
                            System.out.println("Login Validado");

                            menu m = new menu();
                            dispose();

                        } else {
                            JOptionPane.showMessageDialog(null, "Verique usuario e senha", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (SQLException ex) {
                   ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    System.out.println("Classe não encontrada");
                }
            }});
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtLogin.setText("");
                txtSenha.setText("");
            }

        });
    }

    public static void main(String[] args) {
        TelaLogin lv = new TelaLogin();
    }

    private void createUIComponents() {
// TODO: place custom component creation code here
    }
}
