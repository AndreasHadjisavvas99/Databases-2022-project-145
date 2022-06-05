package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class main_panel extends  JFrame{
    public JPanel main_panel;
    private JButton btnquery3_2;
    private JButton btnquery_3_3;
    private JButton btnquery_3_5;
    private JButton btnquery_3_6;
    private JButton btnquery_3_7;
    private JButton btnquery_3_8;
    private JButton btnquery_3_1;
    private JButton deleteresearcherButton;
    private JButton addResearcherButton;


    public main_panel()  {
        btnquery3_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_2().query_3_2);
                setSize(300,300);
                setVisible(true);
            }
        });
        btnquery_3_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_3().query_3_3);
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
        btnquery_3_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new query_3_1().query_3_1);
                setSize(300,300);
                setVisible(true);
            }
        });
        deleteresearcherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new delete_researcher().delete_researcher);
                setSize(300,300);
                setVisible(true);
            }
        });
        addResearcherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                getContentPane().add(new researcher().researcher);
                setSize(300,300);
                setVisible(true);

            }
        });
    }
}
