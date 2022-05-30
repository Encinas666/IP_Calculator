package main.GUI;

import main.Algoritmos.NetworkCalculations;
import main.Algoritmos.metodos.NetworkMask;
import main.ValoresIniciales;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class Panel extends JPanel {
    //private Red red1;
    private NetworkCalculations cr;
    private int np;
    private JComboBox<String> bitsR, requieredIP;
    private JButton list;

     private JLabel broadcast, networkAddress, networkMask,binary, network, hostRange;
    public Panel(int np) {
        this.np = np;
        init();
    }

    //Information del calculo
    public Panel(String red, int np) {
        this(np);
        cr = new NetworkCalculations(red);
        setLblText();
    }

    private void init() {
        if(np == 1){
            panel1();
        }else{
            panel2();
        }

    }

    public void panel1(){

        Font font = new Font("Arial", Font.PLAIN, 15);
        network= new JLabel();
        network.setBounds(40,  40, 300, 50);
        network.setFont(font);
        network.setForeground(Color.WHITE);
        network.setBorder(border("Network"));

        networkAddress = new JLabel();
        networkAddress.setBounds(40,  100, 300, 50);
        networkAddress.setFont(font);
        networkAddress.setForeground(Color.WHITE);
        networkAddress.setBorder(border(" Network Address:"));

        networkMask = new JLabel();
        networkMask.setBounds(40, 160, 300, 50);
        networkMask.setFont(font);
        networkMask.setForeground(Color.WHITE);
        networkMask.setBorder(border("Network Mask:"));

        broadcast = new JLabel();
        broadcast.setBounds(40,  220, 300, 50);
        broadcast.setFont(font);
        broadcast.setForeground(Color.WHITE);
        broadcast.setBorder(border("Broadcast:"));

        hostRange = new JLabel();
        hostRange.setBounds(40,  280, 300, 50);
        hostRange.setFont(font);
        hostRange.setForeground(Color.WHITE);


        binary = new JLabel();
        binary.setBounds(10,  340, 380, 50);

        binary.setFont(font);
        binary.setForeground(Color.WHITE);
        binary.setBorder(BorderFactory.createTitledBorder(null, "Binary",2,0, null, Color.white));

        this.add(network);
        this.add(networkAddress);
        this.add(networkMask);
        this.add(broadcast);
        this.add(hostRange);
        this.add(binary);
    }
    public void panel2(){
        this.setBorder(borderTitle("Sub-network"));
        Font font = new Font("Arial", Font.PLAIN, 15);

        networkMask = new JLabel();
        networkMask.setBounds(120,40 , 150, 50);
        networkMask.setFont(font);
        networkMask.setForeground(Color.WHITE);
        networkMask.setBorder(BorderFactory.createTitledBorder(null, "Sub-Mask",2,0, null, Color.white));

        bitsR = new JComboBox<>();
        bitsR.setBounds(280, 70, 80, 25);
        int r = ValoresIniciales.mask +1;
        for(int i = r; i<=32;i++){
            bitsR.addItem(""+i);
        }

        requieredIP = new JComboBox<>();
        requieredIP.setBounds(20, 70, 80, 25);
        int r1 = ValoresIniciales.bits-ValoresIniciales.mask;
        int z = (int)Math.pow(2,r1);
        for(int i = r; i<=32;i++){
            requieredIP.addItem(""+ z);
            z = z/2;
        }
        list = new JButton("List");
        list.setForeground(Color.WHITE);
        list.setBounds(145, 100, 100, 40);
        list.setBorder(null);
        list.setFocusable(false);
        list.setBackground(Color.BLUE);

        this.add(networkMask);
        this.add(bitsR);
        this.add(requieredIP);
        this.add(list);

        list.addActionListener(e -> {
            new FrameContenedor();
        });
    }

    public Border border(String title){
        return BorderFactory.createTitledBorder(null, title,1,0, null, Color.white);
    }

    public Border borderTitle(String title){
        return BorderFactory.createTitledBorder(null, title,2,0, null, Color.white);
    }

    public void setLblText(){
        cr.run();
        this.setBorder(borderTitle(cr.getTypeNetwork()));
        hostRange.setBorder(border("Host Range("+cr.getIpAvailable()+"):"));
        network.setText(cr.getNetwork());
        networkAddress.setText(cr.getNetworkAddress());
        networkMask.setText(cr.getNetworkMask());
        binary.setText(cr.getNetworkBinary());
        broadcast.setText(cr.getBroadcast());
        hostRange.setText(cr.getHostRange());
    }

    //aux
    private void selectionBits(JComboBox<String> bitsR) {
        FramePrincipal.opcion(bitsR);
    }
}
