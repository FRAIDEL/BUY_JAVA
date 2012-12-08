
import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GaleriaFotos.java
 *
 * Created on 16-may-2011, 13:43:11
 */

/**
 *
 * @author Administrador
 */
public class GaleriaFotos extends javax.swing.JDialog {

    /** Creates new form GaleriaFotos */
    public GaleriaFotos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLImagenCentroGrande = new javax.swing.JLabel();
        jLAntes = new javax.swing.JLabel();
        jLDespues = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLImagenCentroGrande.setText("jLabel1");
        jPanel2.add(jLImagenCentroGrande, java.awt.BorderLayout.CENTER);

        jLAntes.setText("jLabel2");
        jLAntes.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLAntes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAntesMouseClicked(evt);
            }
        });

        jLDespues.setText("jLabel2");
        jLDespues.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLAntes, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
                .addComponent(jLDespues, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void jLAntesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAntesMouseClicked
        imageLoad();
    }//GEN-LAST:event_jLAntesMouseClicked

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GaleriaFotos dialog = new GaleriaFotos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLAntes;
    private javax.swing.JLabel jLDespues;
    private javax.swing.JLabel jLImagenCentroGrande;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    Thread hilo = null;
    String bandera = null;
    int aux = 0;
    public void start(){

    }

    public void run(){
        while(bandera == null && hilo == null){
            try{
                hilo.sleep(60000);
//                //cargo la imagen de la 1 a la 20
//                ImageIcon imagenFoto = new ImageIcon("temp/foto_"+aux+".jpg");
//                Image imageAuxiliar = imagenFoto.getImage();
//                imageAuxiliar = imageAuxiliar.getScaledInstance(jLImagenCentroGrande.getWidth(), jLImagenCentroGrande.getHeight(), Image.SCALE_AREA_AVERAGING);
//                imagenFoto.setImage(imageAuxiliar);
//                jLImagenCentroGrande.setIcon(imagenFoto);
//                jLImagenCentroGrande.updateUI();
//                System.out.println("la imagen q cargo fue : foto_"+aux+".jpg");
//                aux++;
//                if(aux > 3){
//                    bandera = "fin del hilo";
//                }
            }catch(Exception er){
                System.out.println("error conel hilo : "+er.toString());
            }
        }
    }

    public void imageLoad(){
        //cargo la imagen de la 1 a la 20
        ImageIcon imagenFoto = new ImageIcon("temp/foto_"+aux+".jpg");
        Image imageAuxiliar = imagenFoto.getImage();
        imageAuxiliar = imageAuxiliar.getScaledInstance(jLImagenCentroGrande.getWidth(), jLImagenCentroGrande.getHeight(), Image.SCALE_AREA_AVERAGING);
        imagenFoto.setImage(imageAuxiliar);
        jLImagenCentroGrande.setIcon(imagenFoto);
        jLImagenCentroGrande.updateUI();
        System.out.println("la imagen q cargo fue : foto_"+aux+".jpg");
        aux++;
        //***
//        imageAuxiliar = imageAuxiliar.getScaledInstance(jLAntes.getWidth(), jLAntes.getHeight(), Image.SCALE_AREA_AVERAGING);
//        imagenFoto.setImage(imageAuxiliar);
//        jLAntes.setIcon(imagenFoto);
//        jLAntes.updateUI();
//        //***
//        imageAuxiliar = imageAuxiliar.getScaledInstance(jLDespues.getWidth(), jLDespues.getHeight(), Image.SCALE_AREA_AVERAGING);
//        imagenFoto.setImage(imageAuxiliar);
//        jLDespues.setIcon(imagenFoto);
//        jLDespues.updateUI();
        if(aux > 3){
            bandera = "fin del hilo";
        }
    }
}
