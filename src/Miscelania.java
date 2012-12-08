//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfContentByte;
//import com.lowagie.text.pdf.PdfTemplate;
//import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
//import net.java.balloontip.BalloonTip;
//import net.java.balloontip.styles.EdgedBalloonStyle;
//import net.java.balloontip.styles.MinimalBalloonStyle;
//import net.java.balloontip.styles.ModernBalloonStyle;
//import net.java.balloontip.styles.RoundedBalloonStyle;
//import net.java.balloontip.styles.TexturedBalloonStyle;

    /* METODO PARA CENTRAR LA ENTANA */
    public class Miscelania {

    public static void centrarVentana(Component ventana){
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        ventana.setLocation((pantalla.width-ventana.getSize().width)/2,(pantalla.height-ventana.getSize().height)/2);
    }

   public static void numbersOnly(java.awt.event.KeyEvent evt){
        //codigo para ingresar solo numeros en el texField
        if(evt.getKeyChar()!=KeyEvent.VK_ENTER){
            if(!Character.isDigit(evt.getKeyChar())){
                evt.consume();
            }
        }
   }

    /* METODO PARA DESPLEGAR UN NODO DEL ALBOL */
    //**PARA EL TRABAJO CON NODOS
   public static void expandAll(JTree tree, TreePath parent, boolean expand) {
        TreeNode node = (TreeNode)parent.getLastPathComponent();
        if (node.getChildCount() >= 0) {
            for (Enumeration e=node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode)e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                expandAll(tree, path, expand);
            }
        }
        if (expand) {
            tree.expandPath(parent);
        } else {
            tree.collapsePath(parent);
        }
    }
   
   /* metodo para validar correos */
   public  static boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        }else{
            return false;
        }
    }

   //otro metodo para vilidar correo
   public static boolean valida_E_mails(String dir, JTextField campo){
        String validaCorreo = dir.trim();
        if(validaCorreo.indexOf("@")>2 && validaCorreo.indexOf(".")>0 && !(validaCorreo.indexOf(" ")>validaCorreo.length()-1)){
            return true;
//            if(validaCorreo.trim().indexOf(" ")>0){
//                correoValidado = false;
//            }
        }else{
            JOptionPane.showMessageDialog(null, "<html>Se ha efectuado un <b>error</b> en el ingreso del <b>E_mail</b>. Es posible que no cumpla con el formato adecuado.</html>\n<html>Recuerde que no debe llevar espacios entre palabras</html>");
            campo.grabFocus();
            return false;
        }
   }

   public void paintComponent(Graphics g, JPanel panel) {
        Dimension tamanio = panel.getSize();
        ImageIcon fondo = new ImageIcon(getClass().getResource("imagenes/Bienvenida.png"));
        g.drawImage(fondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        panel.setOpaque(false);
        //super.paintComponent(g);
  }

   /*
    ******este codigo es el de   FocusLost*******

    if(!cMiscelania.isEmail(txtEmail.getText())){
        lblCorreo11.setForeground(Color.red);
        cmdGuardar.setEnabled(false);
        lblCorreo11.setText("Dirección de correo no valida ");
        }else{
            lblCorreo11.setText("");
            cmdGuardar.setEnabled(true);
    }

    */

   


//    public static void setBalloonTipStyle(BalloonTip balloonTip, int estilo, Color fillColor, Color borderColor) {
//        switch (estilo) {
//            case 0:
//                    balloonTip.setStyle(new EdgedBalloonStyle(fillColor, borderColor));
//                    break;
//            case 1:
//                    balloonTip.setStyle(new RoundedBalloonStyle(5, 5, fillColor, borderColor));
//                    break;
//            case 2:
//                    ModernBalloonStyle style = new ModernBalloonStyle(10, 10, fillColor, new Color(230,230,230), borderColor);
//                    style.setBorderThickness(3);
//                    style.enableAntiAliasing(true);
//                    balloonTip.setStyle(style);
//                    break;
//            case 3:
//                    Color transparentFill = new Color(fillColor.getRed(), fillColor.getGreen(), fillColor.getBlue(), 180);
//                    balloonTip.setStyle(new MinimalBalloonStyle(transparentFill, 8));
//                    break;
//            case 4:
//                    balloonTip.setStyle(new TexturedBalloonStyle(5, 5, new ImageIcon(Miscelania.class.getResource("/imagenes/information.png")).getImage(), borderColor));
//                    break;
//        }
//    }

//     public static void poneSelloAgua(PdfWriter writer) {
//           try {
//               PdfContentByte cb = writer.getDirectContent();
//               //Se crea un templete para asignar la marca de agua
//               PdfTemplate template = cb.createTemplate(700, 300);
//               template.beginText();
//               //Inicializamos los valores para el templete
//               //Se define el tipo de letra, color y tamaño
//               BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
//               template.setColorFill(new Color(220, 220, 220));
//               template.setFontAndSize(bf, 6);
//
//               template.setTextMatrix(0, 0);
//               //Se define el texto que se agregara como marca de agua
//               template.showText("IPS TOLUSALUD");
//               //template.showTextAlignedKerned(PdfContentByte .ALIGN_CENTER, "" + " Center" , 250 , 650, 0 );
//
//               template.endText();
//               //Se asigna el templete
//               //Se asignan los valores para el texto de marca de agua
//               // Se asigna el grado de inclinacion y la posicion donde aparecerá el texto
//               //                                                     x    y
//               cb.addTemplate(template, 1, 1, -1,1, 50, 500);
//           }
//           catch (Exception e) {
//               e.printStackTrace();
//               System.out.println("error en poneSelloAgua : "+e.toString());
//           }
//       }


}
