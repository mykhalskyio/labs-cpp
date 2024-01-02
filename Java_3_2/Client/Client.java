package Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends JFrame  {

    Socket s;
    ObjectOutputStream out;
    private JPanel client_panel;
    private JCheckBox Button_cBox;
    private JCheckBox Panel_cBox;
    private JRadioButton Red_rB;
    private JRadioButton Yellow_rB;
    private JRadioButton Standart_rB;

    public Client() throws IOException {

        initComponents();
        s = new Socket("localhost", 9999);
        out = new ObjectOutputStream(s.getOutputStream());

        Standart_rB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("3");
            }
        });

        Red_rB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("4");

            }
        });

        Yellow_rB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("5");

            }
        });
        Button_cBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("1");
            }
        });
        Panel_cBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("2");
            }
        });
    }

    private void initComponents() {
        setContentPane(client_panel);
        setTitle("Client");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(600,300);
        setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(Standart_rB);
        group.add(Red_rB);
        group.add(Yellow_rB);



    }
    private void SendMessage(String msg) {
        try {
            out.writeObject(msg);
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) throws IOException {
        Client c = new Client();


    }
}
