package Server;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server extends JFrame{

    ServerSocket ss;
    Socket s;

    ObjectInputStream in;

    private JPanel server_panel;
    private JButton Button;
    private JPanel panel;
    private JLabel panelLabel;


    public Server() throws IOException {
        initComponents();
        ss = new ServerSocket(9999);
        s = ss.accept();
        in = new ObjectInputStream(s.getInputStream());

    }

    private void initComponents() {
        setContentPane(server_panel);
        setTitle("Server");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(600,300);
        setVisible(true);

    }


    private void ReciveMessage() {
        String msg;
        while (true) {
            try {
                msg = (String) in.readObject();
                switch (msg)
                {
                    case "1":
                    {
                        boolean toBe = Button.isEnabled()==true?false:true;
                        Button.setEnabled(toBe);
                        break;
                    }
                    case "2":
                    {
                        boolean toBe_1 = panel.isVisible()==true?false:true;
                        panel.setVisible(toBe_1);
                        boolean toBe_2 = panelLabel.isVisible()==true?false:true;
                        panelLabel.setVisible(toBe_2);
                        break;
                    }
                    case "3":
                    {
                        server_panel.setBackground(Color.WHITE);
                        break;
                    }
                    case "4":
                    {
                        server_panel.setBackground(Color.RED);
                        break;
                    }
                    case "5":
                    {
                        server_panel.setBackground(Color.YELLOW);
                        break;
                    }

                    default : break;
                }

            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Server ser = new Server();
        ser.ReciveMessage();

    }
}
