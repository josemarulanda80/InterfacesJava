
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josem
 */
public class Ventana extends JFrame{  
    private JPanel panel;
    private JLabel etiqueta;
    private JButton boton;
    private int sum;
    
     public Ventana(){
        setBounds(50,50,400,400);//Posicion de la ventana
        setTitle("Ejercicio1");
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
     private void iniciarComponentes(){
         colocarPanel();
         colocarEtiqueta();
         colocarBoton();
         
     }
     private void colocarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);
     }
     private void colocarEtiqueta(){
         etiqueta = new JLabel();
         etiqueta.setBounds(0,50,400,40);
         etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
         etiqueta.setFont(new Font("arial",0,20));
         panel.add(etiqueta);
         etiqueta.setText("Pulsa el boton");
         
     }
     private void colocarBoton(){
         boton = new JButton();
         boton.setBounds(90,250,200,50);
         boton.setHorizontalAlignment(SwingConstants.CENTER);
         boton.setText("Pulsa aquí");
         boton.setFont(new Font("cooper black",0,20));
         panel.add(boton);
         eventoDeAccion();
     }
     private void eventoDeAccion(){
         ActionListener evento = new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e){
                  sum ++;
                  if (sum ==1){
                      etiqueta.setText("Has precionado el boton una vez "+sum);
                  }else{
                      etiqueta.setText("Has presionado el botón "+sum+"veces");
                  }
                  
             }
         };
         boton.addActionListener(evento);
         
     }
     
}
