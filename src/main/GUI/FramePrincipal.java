package main.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.ValoresIniciales;

public class FramePrincipal extends JFrame {

    JFrame frame;
    JComboBox<String> bits;
    JComboBox<String> hexa;
    JComboBox<String> decimal;

    public FramePrincipal(){
        init();
        setIconImage(new ImageIcon(getClass().getResource("src/resource/red1.png")).getImage());
        frame = this;
    }

    private void init(){
        this.bits = new JComboBox<>();
        this.decimal = new JComboBox<>();
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.setSize(ValoresIniciales.MAIN_WIDTH, ValoresIniciales.MAIN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("CALCULADORA_IP");

        this.add(pAjustes());
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

        JTextField txtDR = new JTextField("0.0.0.0");
        txtDR.setBounds(250, 80, 200, 25);
        panel.add(txtDR);

        JButton calcular = new JButton("<html><span style='font-size:10px'>"+"Calcular"+"</span></html>");
        calcular.setForeground(Color.WHITE);
        calcular.setBounds(300, 120, 100, 40);
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

    private JPanel pAjustes(){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(null, "AJUSTES:",1,0, null, Color.white));
    
        panel.setBackground(Color.BLACK);
        panel.setMaximumSize(new Dimension(this.getWidth(), 50));

        bits.setBounds(70, 10, 120, 25);
        for(int i = 1; i<=32;i++){
            bits.addItem(""+i);
        }
        panel.add(bits);

        decimal.setBounds(330, 10, 120, 25);
        panel.add(decimal);

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
}
