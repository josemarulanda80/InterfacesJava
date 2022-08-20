/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio3;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author josem
 */
public class Ventana extends JFrame{
    JPanel panel;
    JLabel etiqueta;
    JButton btn1,btn2,btn3;
    private int pulsado=0;
    private int contadorRojo=0,contadorVerde=0,contadorAzul=0;
    
    public Ventana(){
        setSize(600, 400);
        setTitle("Ejercicio 3");
        setLocationRelativeTo(null);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        colocarPanel();
        colocarEtiqueta();
        colocarBotones();
    }
    private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
        
        eventoDeRuedaRaton();
    }
    private void colocarEtiqueta(){
        etiqueta = new JLabel("Color (Rojo, Verde, Azul)");
        etiqueta.setBounds(100,30,400,50);
        etiqueta.setFont(new Font("arial",0,20));
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
    }
    private void colocarBotones(){
        /*pusado =0 ningunboton
        pulsado =1 es buton rojo
        pulsado =2 buton berde
        pusado=3 boton azul*/
        btn1=new JButton("Rojo");
        btn1.setBounds(50,230,130,50);
        btn1.setForeground(Color.RED);
        btn1.setFont(new Font("arial rounded mt bold",0,20));
        panel.add(btn1);
        
        btn1.addActionListener(new ActionListener(){
         

            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado = 1;System.out.println(pulsado);
                
            }
        });
        
        btn2=new JButton("VERDE");
        btn2.setBounds(230,230,130,50);
        btn2.setForeground(Color.GREEN);
        btn2.setFont(new Font("arial rounded mt bold",0,20));
        panel.add(btn2);

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado=2;System.out.println(pulsado);;
            }
        });
        
        btn3=new JButton("Azul");
        btn3.setBounds(410,230,130,50);
        btn3.setForeground(Color.BLUE);
        btn3.setFont(new Font("arial rounded mt bold",0,20));
        panel.add(btn3);
        
        btn3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                pulsado=3;System.out.println(pulsado);
            }
        });
    }   
    public void eventoDeRuedaRaton(){
        MouseWheelListener eventoRueda = new MouseWheelListener(){
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (pulsado !=0) {
                    if (pulsado ==1) {
                        contadorRojo+=e.getWheelRotation();
                        if (contadorRojo <0) {
                            contadorRojo=0;
                            
                        }
                        if (contadorRojo >255) {
                            contadorRojo=255;
                            
                        }
                    }
                    else if (pulsado==2) {
                        contadorVerde += e.getWheelRotation();
                        if (contadorVerde <0) {
                            contadorVerde=0;
                        }
                        if (contadorVerde >255) {
                            contadorVerde=255;
                            
                        }
                    }else{
                        contadorAzul += e.getWheelRotation();
                        if (contadorAzul<0) {
                            contadorAzul=0;
                            
                        }
                        if (contadorAzul >255) {
                            contadorAzul=255;
                            
                        }
                    }
                }
                etiqueta.setText("Color (Rojo = "+contadorRojo +", Azul= "+contadorVerde+", Verde = "+contadorAzul+")");
                panel.setBackground(new Color(contadorRojo,contadorVerde,contadorAzul));
            }
            
            
        };
        panel.addMouseWheelListener(eventoRueda);  
        };
}
