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
    private JLabel Label;


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
        Label.setOpaque(true);
        Label.setBackground(Color.white);
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
                        boolean toBe = Button.isVisible()==true?false:true;
                        Button.setVisible(toBe);
                        break;
                    }
                    case "2":
                    {
                        Label.setText("Панель");
                        break;
                    }
                    case "3":
                    {
                        server_panel.setBackground(Color.white);
                        break;
                    }
                    case "4":
                    {
                        server_panel.setBackground(Color.red);
                        break;
                    }
                    case "5":
                    {
                        server_panel.setBackground(Color.blue);
                        break;
                    }
                    case "6":
                    {
                        server_panel.setBackground(Color.yellow);
                        break;
                    }
                    case "7":
                    {
                        System.exit(0);
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
