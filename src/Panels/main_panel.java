package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class main_panel extends  JFrame{
    public JPanel main_panel;
    private JButton btnPanel1;
    private JButton btnPanel2;
    private JButton btnquery_3_5;
    private JButton btnquery_3_6;
    private JButton btnquery_3_7;
    private JButton btnquery_3_8;
    private JButton btnquery_3_1;


    public main_panel()  {
        btnPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new panel1().panel1);
                setSize(300,300);
                setVisible(true);
            }
        });
        btnPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new panel2().panel2);
                setSize(300,300);
                setVisible(true);
            }
        });
        btnquery_3_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_5().query_3_5);
                setSize(300,300);
                setVisible(true);
            }
        });
        btnquery_3_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_6().query_3_6);
                setSize(300,300);
                setVisible(true);
            }
        });
        btnquery_3_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_7().query_3_7);
                setSize(300,300);
                setVisible(true);

            }
        });
        btnquery_3_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_8().query_3_8);
                setSize(300,300);
                setVisible(true);
            }
        });
    }
}
