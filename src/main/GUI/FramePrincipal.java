package main.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.ValoresIniciales;
import main.Algoritmos.metodos.MascaraDeRed;

public class FramePrincipal extends JFrame {

    JFrame frame;
    JComboBox<String> bits;

    public FramePrincipal(){
        init();
        setIconImage(new ImageIcon(getClass().getResource("src/resource/red1.png")).getImage());
        frame = this;
    }

    private void init(){
        this.bits = new JComboBox<>();
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(ValoresIniciales.MAIN_WIDTH, ValoresIniciales.MAIN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("CALCULADORA_IP");

        this.add(pCalculadoraIp());

        this.setVisible(true);
    }

    private JPanel pCalculadoraIp(){
        JPanel panel = new JPanel(null);
        panel.setBackground(Color.BLACK);
        panel.setBorder(BorderFactory.createTitledBorder(null, "DIRECCION DE RED:",1,0, null, Color.white));
    
        //Imagen
        try{
           JLabel imagenContenedor = new JLabel(new ImageIcon(new ImageIcon("src/resource/calc_ip.png").getImage().getScaledInstance(180, 180, Image.SCALE_DEFAULT)));
           imagenContenedor.setBounds(20, 25, 180, 180);
           panel.add(imagenContenedor);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Font font = new Font("Arial", Font.PLAIN, 15);
        JLabel lblIP = new JLabel("IP:");
        lblIP.setBounds(250, 55, 150, 25);
        lblIP.setFont(font);
        lblIP.setForeground(Color.WHITE);
        panel.add(lblIP);

        JLabel lblNMDecimal = new JLabel("255.255.255.0");
        lblNMDecimal.setBounds(310, 110, 150, 50);
        lblNMDecimal.setFont(font);
        lblNMDecimal.setForeground(Color.WHITE);
        lblNMDecimal.setBorder(BorderFactory.createTitledBorder(null, "NetMask Decimal:",
        1,0, null, Color.white));
        //MascaraDeRed.getMascaraDeRed().mascaraDeRed(red);
        panel.add(lblNMDecimal);

        JTextField txtDR = new JTextField("0.0.0.0");
        txtDR.setBounds(250, 80, 200, 25);
        panel.add(txtDR);

        
        bits.setBounds(250, 130, 50, 25);
        for(int i = 1; i<=32;i++){
            bits.addItem(""+i);
        }
        panel.add(bits);

        selectionBits(bits);
        

        JButton calcular = new JButton("<html><span style='font-size:10px'>"+"Calcular"+"</span></html>");
        calcular.setForeground(Color.WHITE);
        calcular.setBounds(300, 200, 100, 40);
        calcular.setBorder(null);
        calcular.setFocusable(false);
        calcular.setBackground(Color.BLUE);
        panel.add(calcular);

        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isACorrectIp(txtDR.getText()) == true){
                    new FrameContenedor(txtDR.getText());
                    frame.setState(Frame.ICONIFIED);
                }else{
                    mensajeError();
                }
            }
        });

        return panel;
    }

    private void mensajeError(){
        JOptionPane.showMessageDialog(null, "Debe ingresar una direccion ip válida", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean isACorrectIp(String cadIP){
        boolean res = false;
        int[] ip = new int[4];
        int tamCad = cadIP.length();
        int aux = 0;
        int j = 0, i = 0;
        if(tamCad>=7 && tamCad <= 15){
           while(i < tamCad){
               if(cadIP.charAt(i) == '.'){
                   String a = cadIP.substring(aux,i);
                    try{
                        int x = Integer.parseInt(a);
                        if(x >= 0 && x < 256){
                            ip[j] = x;
                            aux = i+1;
                            j++;
                            res = true;
                        }else{
                            res = false;
                            break;
                        }
                    }catch(NumberFormatException e){  
                        res = false;
                        break;
                    }   
               }else if(i == tamCad-1){
                    String a = cadIP.substring(aux,i+1);
                    try{
                        int x = Integer.parseInt(a);
                        if(x >= 0 && x < 256){
                            ip[j] = x;
                            res = true;
                        }else{
                            res = false;
                            break;
                        }
                    }catch(NumberFormatException e){
                        res = false;
                        break;
                    }   
               }
               i++;
           }
       }
       return res;
    }

    private void selectionBits(JComboBox<String> bits){
        int op = bits.getSelectedIndex();

        switch(op){
            case 0: ValoresIniciales.mask = 1; break;
            case 1: ValoresIniciales.mask = 2; break;
            case 2: ValoresIniciales.mask = 3; break;
            case 3: ValoresIniciales.mask = 4; break;
            case 4: ValoresIniciales.mask = 5; break;
            case 5: ValoresIniciales.mask = 6; break;
            case 6: ValoresIniciales.mask = 7; break;
            case 7: ValoresIniciales.mask = 8; break;
            case 8: ValoresIniciales.mask = 9; break;
            case 9: ValoresIniciales.mask = 10; break;
            case 10: ValoresIniciales.mask = 11; break;
            case 11: ValoresIniciales.mask = 12; break;
            case 12: ValoresIniciales.mask = 13; break;
            case 13: ValoresIniciales.mask = 14; break;
            case 14: ValoresIniciales.mask = 15; break;
            case 15: ValoresIniciales.mask = 16; break;
            case 16: ValoresIniciales.mask = 17; break;
            case 17: ValoresIniciales.mask = 18; break;
            case 18: ValoresIniciales.mask = 19; break;
            case 19: ValoresIniciales.mask = 20; break;
            case 20: ValoresIniciales.mask = 21; break;
            case 21: ValoresIniciales.mask = 22; break;
            case 22: ValoresIniciales.mask = 23; break;
            case 23: ValoresIniciales.mask = 24; break;
            case 24: ValoresIniciales.mask = 25; break;
            case 25: ValoresIniciales.mask = 26; break;
            case 26: ValoresIniciales.mask = 27; break;
            case 27: ValoresIniciales.mask = 28; break;
            case 28: ValoresIniciales.mask = 29; break;
            case 29: ValoresIniciales.mask = 30; break;
            case 30: ValoresIniciales.mask = 30; break;
            case 31: ValoresIniciales.mask = 30; break;
        }
    }
}
