package br.sc.senac.mcap.view;

import javax.swing.*;

public class menu extends JFrame{
    private JButton button1;
    private JPanel PNLmenu;

    public menu() {
        initComponents();
       // listeners();
    }
    private void initComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Login");
        setContentPane(PNLmenu);
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
    }

}
