package Client;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
public class Client extends JFrame {
    Socket s;
    ObjectOutputStream out;
    private JPanel client_panel;
    private JLabel Label;

    public Client() throws IOException {

        initComponents();
        s = new Socket("localhost", 9999);
        out = new ObjectOutputStream(s.getOutputStream());


        JPopupMenu popupMenu = new JPopupMenu();
        JMenu Menu1 = new JMenu("JButton >");
        JCheckBoxMenuItem item1 = new JCheckBoxMenuItem("Visible");
        item1.setSelected(true);
        item1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                SendMessage("1");

            }
        });

        Menu1.add(item1);
        popupMenu.add(Menu1);

        JMenu Menu2 = new JMenu("View >");
        JMenu Menu2_2 = new JMenu("Form1.Color >");
        JRadioButtonMenuItem r1 =new JRadioButtonMenuItem("clBthFace");
        JRadioButtonMenuItem r2 =new JRadioButtonMenuItem("clRed");
        JRadioButtonMenuItem r3 =new JRadioButtonMenuItem("clBlue");
        JRadioButtonMenuItem r4 =new JRadioButtonMenuItem("clYellow");
        r1.setSelected(true);
        ButtonGroup group = new ButtonGroup();
        group.add(r1);group.add(r2);group.add(r3);group.add(r4);

        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(r1.isSelected())SendMessage("3");
                if(r2.isSelected())SendMessage("4");
                if(r3.isSelected())SendMessage("5");
                if(r4.isSelected())SendMessage("6");

            }
        };
        r1.addItemListener(itemListener);
        r2.addItemListener(itemListener);
        r3.addItemListener(itemListener);
        r4.addItemListener(itemListener);

        Menu2_2.add(r1);
        Menu2_2.add(r2);
        Menu2_2.add(r3);
        Menu2_2.add(r4);

        JRadioButtonMenuItem item2_1 = new JRadioButtonMenuItem("JPanel.Caption = Панель");
        item2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendMessage("2");
            }
        });

        Menu2.add(Menu2_2);
        Menu2.add(item2_1);
        popupMenu.add(Menu2);

        JMenuItem item3 = new JMenuItem("Exit F10");
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SendMessage("7");
                System.exit(0);
            }
        });
        popupMenu.add(item3);

        Label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if(SwingUtilities.isRightMouseButton(e)){
                    popupMenu.show(Label,e.getX(),e.getY());
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
