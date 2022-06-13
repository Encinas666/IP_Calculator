package main.GUI;

import main.Algoritmos.NetworkCalculations;
import main.Algoritmos.metodos.NetworkMask;
import main.Algoritmos.metodos.SubNetworks;
import main.ValoresIniciales;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import java.awt.*;
import java.io.*;

public class Panel extends JPanel {
    //private Red red1;
    private NetworkCalculations cr;
    private final int np;

    private String[] itemSN, itemBR, item3;
    private JComboBox<String> bitsR;
    private JLabel hostXsubnet, subNetworks, subMask;
    private JButton list;
    private JList<String> listSN, listHR, listB;

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
        }else if(np == 2){
            panel2();
        }else if(np == 3){
            panelList();
        }else{
            panelHelp();
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
        ValoresIniciales.remainingBits = ValoresIniciales.bits-ValoresIniciales.mask;
        setItemBR();

        this.setBorder(borderTitle("Sub-network"));
        Font font = new Font("Arial", Font.PLAIN, 15);

        subMask = new JLabel();
        subMask.setBounds(120,20 , 150, 50);
        subMask.setFont(font);
        subMask.setForeground(Color.WHITE);
        subMask.setBorder(BorderFactory.createTitledBorder(null, "Sub-Mask",2,0, null, Color.white));

        hostXsubnet = new JLabel();
        hostXsubnet.setBounds(20, 70, 80, 50);
        hostXsubnet.setFont(font);
        hostXsubnet.setForeground(Color.WHITE);
        hostXsubnet.setBorder(BorderFactory.createTitledBorder(null, "Host",2,0, null, Color.white));

        subNetworks = new JLabel();
        subNetworks.setBounds(280, 70, 80, 50);
        subNetworks.setFont(font);
        subNetworks.setForeground(Color.WHITE);
        subNetworks.setBorder(BorderFactory.createTitledBorder(null, "Sub-Network",2,0, null, Color.white));


        bitsR = new JComboBox<>();
        bitsR.setBounds(180, 70, 60, 25);
        bitsR.setModel(new DefaultComboBoxModel<>(itemBR));
        bitsR.addActionListener(e -> {
            ValoresIniciales.subM =Integer.parseInt(bitsR.getItemAt(bitsR.getSelectedIndex()));
            ValoresIniciales.m = ValoresIniciales.bits-ValoresIniciales.subM;
            int y = (int)Math.pow(2,bitsR.getSelectedIndex());
            int z = (int)Math.pow(2,ValoresIniciales.m)-2;
            ValoresIniciales.subMask = NetworkMask.getNetworkMask().getNetworkMaskM(0);
            subMask.setText(ValoresIniciales.subMask);
            hostXsubnet.setText(""+z);
            subNetworks.setText(""+y);
        });


        list = new JButton("List");
        list.setForeground(Color.WHITE);
        list.setBounds(145, 100, 100, 40);
        list.setBorder(null);
        list.setFocusable(false);
        list.setBackground(Color.BLUE);

        this.add(subMask);
        this.add(bitsR);
        this.add(hostXsubnet);
        this.add(subNetworks);
        this.add(list);

        list.addActionListener(e -> {
            try {
                ValoresIniciales.numberSubnets = Integer.parseInt(subNetworks.getText());
                new FrameContenedor();
            }catch (NumberFormatException ex){
                ex.getStackTrace();
                JOptionPane.showMessageDialog(null, "Modifique los valores");
            }

        });
    }

    public void panelList(){
        this.setBorder(borderTitle("List Sub-Network"));

        Font font = new Font("Arial", Font.PLAIN, 15);
        DefaultListModel listModelSN = new DefaultListModel<>();
        DefaultListModel listModelHR = new DefaultListModel<>();
        DefaultListModel listModelB = new DefaultListModel<>();

        network= new JLabel();
        network.setBounds(10,  20, 300, 50);
        network.setFont(font);
        network.setForeground(Color.WHITE);
        network.setBorder(border("Network"));
        network.setText(ValoresIniciales.network);

        subMask = new JLabel();
        subMask.setBounds(10,70 , 300, 50);
        subMask.setFont(font);
        subMask.setForeground(Color.WHITE);
        subMask.setBorder(border("Sub Mask"));
        subMask.setText(ValoresIniciales.subMask);



        listSN = new JList<>();
        listSN.setBorder(borderTitle("Sub-Network List"));
        listSN.setBounds(10,  130, 230, 400);
        listSN.setFont(font);
        listSN.setForeground(Color.WHITE);
        listSN.setBackground(Color.BLACK);

        listHR = new JList<>();
        listHR.setBorder(borderTitle("Host Range"));
        listHR.setBounds(245,  130, 300, 400);
        listHR.setFont(font);
        listHR.setForeground(Color.WHITE);
        listHR.setBackground(Color.BLACK);

        listB = new JList<>();
        listB.setBorder(borderTitle("Broadcast"));
        listB.setBounds(555,  130, 230, 400);
        listB.setFont(font);
        listB.setForeground(Color.WHITE);
        listB.setBackground(Color.BLACK);




        String[] listSubnet = SubNetworks.getSubNetwork().subnets();

        String[] lsn, lhr,lb;

        lsn = new String[ValoresIniciales.numberSubnets];
        lhr = new String[ValoresIniciales.numberSubnets];
        lb = new String[ValoresIniciales.numberSubnets];

        for (int j = 0; j < ValoresIniciales.numberSubnets;j++){
            String [] aux = listSubnet[j].split("#");

            lsn[j] = aux [0];
            lhr[j] = aux [1];
            lb[j] = aux [2];
        }

        for (int j = 0; j < ValoresIniciales.numberSubnets;j++){
            listModelSN.add(j,lsn[j]);
            listModelHR.add(j,lhr[j]);
            listModelB.add(j,lb[j]);

        }


        listSN.setModel(listModelSN);
        listHR.setModel(listModelHR);
        listB.setModel(listModelB);

        this.add(network);
        this.add(subMask);
        this.add(listSN);
        this.add(listHR);
        this.add(listB);

    }

    public void panelHelp(){
        String text = getFile("/home/jhonatan/Escritorio/gitHub/folder2/IP_Calculator/src/help/HELP.txt");
        this.setBorder(borderTitle("HELP"));
        Font font = new Font("Arial", Font.PLAIN, 15);

        JTextPane txA = new JTextPane();
        txA.setFont(font);
        txA.setBackground(Color.BLACK);
        txA.setForeground(Color.WHITE);
        txA.setBounds(10,15,780,540);
        txA.setBorder(borderTitle("_____"));
        JScrollBar bar = new JScrollBar();
        bar.add(txA);
        bar.setBackground(Color.WHITE);
        txA.setText(text);

        this.add(txA);
        this.add(bar);
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
        ValoresIniciales.hostRangeBorder= "Host Range("+cr.getIpAvailable()+"):";
        ValoresIniciales.network = cr.getNetwork();
        ValoresIniciales.networkAddress = cr.getNetworkAddress();
        ValoresIniciales.networkMask = cr.getNetworkMask();
        ValoresIniciales.binary = cr.getNetworkBinary();
        ValoresIniciales.broadcast = cr.getBroadcast();
        ValoresIniciales.hostRange = cr.getHostRange();

        hostRange.setBorder(border(ValoresIniciales.hostRangeBorder));
        network.setText(ValoresIniciales.network);
        networkAddress.setText(ValoresIniciales.networkAddress);
        networkMask.setText(ValoresIniciales.networkMask);
        binary.setText(ValoresIniciales.binary);
        broadcast.setText(ValoresIniciales.broadcast);
        hostRange.setText(ValoresIniciales.hostRange);
    }

    //aux
    private void setItemBR() {
        itemBR = new String[ValoresIniciales.remainingBits +1];
        for(int i = ValoresIniciales.mask, j=0; i<=32;i++,j++){
            itemBR[j]= (""+i);
        }
    }

    private String getFile(String ruta){
        File file;
        FileReader fr;
        BufferedReader  br ;
        StringBuilder content = null;
        String text = "";
        try {
            file = new File(ruta);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            content = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null){
                content.append(linea).append("\n");
            }
            br.close();
            fr.close();
            text = content.toString();
        } catch (Exception ignored) {
        }
        return text;
    }
}
