/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2iav1.pkg0;

import chatbot.AgenteBasadoEnConocimiento;
import sttYtts.EscribirArchivo;
import sttYtts.Escucha;
import sttYtts.Habla;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Santo
 */
public class interfazPrincipal extends javax.swing.JFrame {
    private static boolean pressed = false;
    private static boolean userMode = true;    
    private Escucha e = new Escucha();
	private Habla habla = new Habla();
	private EscribirArchivo escribe = new EscribirArchivo();
    private String escribirEnElChat = "";    
    public static String userText;
    public AgenteBasadoEnConocimiento agent;
	
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea JlabelBotText;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jImageLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonCliente;
    private javax.swing.JRadioButton jRadioButtonVendedor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form interfazPrincipal
     */
    public interfazPrincipal(AgenteBasadoEnConocimiento agent) {
        this.agent = agent;
        initComponents();
    }
    public interfazPrincipal(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButtonEnviar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jImageLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JlabelBotText = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonCliente = new javax.swing.JRadioButton();
        jRadioButtonVendedor = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        
        jTextField1.setFocusable(true);        
        
        jTextField1.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                	enviarKeyTyped(e);
                }
            }
            public void keyReleased(KeyEvent e){
            }
        }); 
        
        jButton2.setFocusable(true);        
        
        jButton2.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
            }
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                	enviarKeyTyped(e);
                }
            }
            public void keyReleased(KeyEvent e){
            }
        });       

        jButtonEnviar.setText("Enviar");          
        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButtonEnviarActionPerformed(evt);
            }
        });
        
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/60540small.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setToolTipText("Escribe algo");

        jImageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noVoice.png"))); // NOI18N

        JlabelBotText.setEditable(false);
        JlabelBotText.setColumns(20);
        JlabelBotText.setRows(10);
        jScrollPane1.setViewportView(JlabelBotText);

        buttonGroup1.add(jRadioButtonCliente);
        jRadioButtonCliente.setSelected(true);
        jRadioButtonCliente.setText("Modo cliente");

        buttonGroup1.add(jRadioButtonVendedor);
        jRadioButtonVendedor.setText("Modo vendedor");

        jButton3.setText("Recomendar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonCliente)
                    .addComponent(jRadioButtonVendedor)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonVendedor)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jImageLogo)
                        .addGap(321, 321, 321))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jImageLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEnviar))
                    .addComponent(jTextField1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void setBotText(String entrada, boolean robot){
    	DateFormat dateFormat = new SimpleDateFormat("HH:mm");
      	 Date date = new Date();
    	if(robot) {
           this.JlabelBotText.append(dateFormat.format(date)+ " Asistente:           " + entrada + "\n" );
           this.JlabelBotText.append("- - - - - - - - - - - - - - - - - - - - -" + "\n" );
    	}else {
    		this.JlabelBotText.append(dateFormat.format(date)+ " Yo:                      " + entrada + "\n" );
            this.JlabelBotText.append("- - - - - - - - - - - - - - - - - - - - -" + "\n" );
    	}
    	 
    }
    
    public String getUserText(){
        return this.userText;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    	if(pressed){

            this.jButton2.setBackground(Color.white);            
            e.terminarEscucha();
            pressed = false;

        }else{

            this.jButton2.setBackground(Color.red);
            e.empezarEscucha(this);
            pressed = true;
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void dejarDeEscuchar() {
    	this.jButton2.setBackground(Color.white);
        pressed = false;
    }
    
    public void actualizarTexto(String texto, boolean borrar) {
    	if(borrar) {
    		this.jTextField1.setText(texto);
    	}else {
        	this.jTextField1.setText(this.jTextField1.getText().concat(" "+texto));    		
    	}
    }
    
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
            
    }//GEN-LAST:event_jButton2MouseClicked    
    
    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
    	//Por si aprieta enviar y el microfono est� prendido. Dejo de escuchar         
    	if(pressed){
    		e.terminarEscucha();
    	}
    	
    	boolean isUserMode = true;
        if(this.jRadioButtonCliente.isSelected()){
            isUserMode = true;
        }else{
             isUserMode = false;
        }
        //Escribo en el txt
	 	escribe.escribir("Usuario", this.jTextField1.getText(), "Prueba");
    	this.setBotText(this.jTextField1.getText(), false);
    	String respuesta;
        
    	respuesta = agent.start(this.jTextField1.getText(), isUserMode);
    	this.jTextField1.setText("");
    	this.setBotText(respuesta, true);
    	habla.leer(respuesta);
        moverImagen();
        /*try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(interfazPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        pararImagen();
        
        if(pressed){
        	//Cuando termina de responder vuelvo a escuchar
        	e.empezarEscucha(this);
        }
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazPrincipal().setVisible(true);
            }
        });
    }*/

    private void pararImagen() {
       jImageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/noVoice.png"))); 
    }

    private void moverImagen() {
        jImageLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ezgif.com-resize.gif"))); 
    }
	
	//SI SE PRESIONA ENTER SE ENVIA EL TEXTO
    private void enviarKeyTyped(java.awt.event.KeyEvent evt) {
    	if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
    		this.jButtonEnviar.doClick();
    	}
    }
}
