package main.GUI;

import main.Algoritmos.NetworkCalculations;
import main.ValoresIniciales;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class Panel extends JPanel {
    //private Red red1;
    private NetworkCalculations cr;
    private int np;
    private JComboBox<String> bitsR, requieredIP, subNetworks;
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
        networkMask.setBounds(120,20 , 150, 50);
        networkMask.setFont(font);
        networkMask.setForeground(Color.WHITE);
        networkMask.setBorder(BorderFactory.createTitledBorder(null, "Sub-Mask",2,0, null, Color.white));

        bitsR = new JComboBox<>();
        bitsR.setBounds(180, 70, 40, 25);
        for(int i = ValoresIniciales.mask; i<=32;i++){
            bitsR.addItem(""+i);
        }

        requieredIP = new JComboBox<>();
        requieredIP.setBounds(20, 70, 80, 25);
        int r1 = ValoresIniciales.bits-ValoresIniciales.mask;
        int j = r1;
        while(j>=0){
            int z = (int)Math.pow(2,j);
            requieredIP.addItem(""+ z);
            j--;
        }

        subNetworks = new JComboBox<>();
        subNetworks.setBounds(280, 70, 80, 25);
        for(int i = 0; i<=r1;i++){
            int y = (int)Math.pow(2,i);
            subNetworks.addItem(""+ y);
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
        this.add(subNetworks);
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
        int op = bitsR.getSelectedIndex();
        switch (op) {
            case 0->item(0, 1);
            case 1->item(1, 2);
            case 2->item(2, 3);
            case 3->item(3, 4);
            case 4->item(4, 5);
            case 5->item(5, 6);
            case 6->item(6, 7);
            case 7->item(7, 8);
            case 8->item(8, 9);
            case 9->item(9, 10);
            case 10->item(10, 11);
            case 11->item(11, 12);
            case 12->item(12, 13);
            case 13->item(13, 14);
            case 14->item(14, 15);
            case 15->item(15, 16);
            case 16->item(16, 17);
            case 17->item(17, 18);
            case 18->item(18, 19);
            case 19->item(19, 20);
            case 20->item(20, 21);
            case 21->item(21, 22);
            case 22->item(22, 23);
            case 23->item(23, 24);
            case 24->item(24, 25);
            case 25->item(25, 26);
            case 26->item(26, 27);
            case 27->item(27, 28);
            case 28->item(28, 29);
            case 29->item(29, 30);
            case 30->item(30, 32);
            case 31->item(31, 32);
        }
    }
    private void item(int op, int mask ){
        ValoresIniciales.mask = mask;
        requieredIP.setSelectedIndex(op);
    }
}
