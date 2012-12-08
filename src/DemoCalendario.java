
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;


public class DemoCalendario extends JInternalFrame implements ActionListener{

    private JButton Barr;            // boton para aumentar el año
    private JButton Baba;			// boton para disminuir el año
    private JTable table;
    private JComboBox Cmes;          // da los meses del años
    private JList JLano;             // para el año
    private JTextField Tfecha;       // la fecha de ecojamos
    private int cambiarano;
    private int f,c;
    private int fila = 0,colum = 0;
    private int dia; // es el dia de la decha del sistema por primera vez
    private String anoss="2004";  // se inicia por primera vez con el 2006 para el JList
    private String elementos[]={anoss};

    protected Calendario calen;
    protected Fecha fecha;

    EtchedBorder etched;           // es el borde para el panel de la fecha
  	TitledBorder titled;     // es el titulo para el panel de la fecha

    public void actionPerformed(ActionEvent a){

  	    Object fuente = a.getSource();

  	    // seleccionar el mese en el comboBox
  	    if(fuente ==Cmes){
  	   	  cambiarano=Integer.parseInt(elementos[0]);
  	   	  calen.mostar(cambiarano,Cmes.getSelectedIndex());
  	   	  borraTable();
  	      buscarCalendario(calen.getDayOfWeek(),calen.getDays());
  	      mostrarFecha();
  	    }

  	    // los botones para aumentar y disminuir el año
  	    if(fuente==Barr || fuente==Baba){

	  	    if(fuente==Barr)
	  	       modificar(0);
	  	    else
	  	       if(fuente==Baba)
	  	          modificar(1);


	  	    cambiarano=Integer.parseInt(elementos[0]);
	  	    calen.mostar(cambiarano,Cmes.getSelectedIndex());
	  	    borraTable();
	  	    buscarCalendario(calen.getDayOfWeek(),calen.getDays());
	  	    mostrarFecha();
  	   }
   }


   public DemoCalendario(String titulo) {
	  super(titulo,
	      false, //resizable
	      false, //closable
	      false, //maximizable
	      false);//iconifiable

      // se configura el JInternalFrame
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
	  this.setLayout(null);
	  // Se especifica el tamaño y posicion
	  this.setSize(240,225);
	  // Se configura el icono del JInternal
	  this.setFrameIcon(new ImageIcon(DemoCalendario.class.getResource("images/imagenesCalendario/Calendario.gif")));

          addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
                public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                }
                public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {

                }
                public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                    //
                }
                public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
                }
                public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                }
                public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                }
                public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                }
            });

  	  Tfecha=new JTextField("");

  	 //  Ejecutar el constructor de Calendario
  	  calen=new Calendario();

      etched = new EtchedBorder(EtchedBorder.RAISED,Color.white,new Color(164, 163, 165));
      titled=new TitledBorder(etched,"Fecha") ;

	  // Lpanel de las fechas
	  JLabel Lpanel = new JLabel();
	  Lpanel.setBounds(10,10,210,175);
	  Lpanel.setBorder( titled );
	  this.add(Lpanel);

  	  // *********** Combobox de mes
  	  Cmes=new JComboBox();
            Cmes.setBounds(20,25,100,20);
  	  Cmes.addItem("Enero");
   	  Cmes.addItem("Febrero");
   	  Cmes.addItem("Marzo");
   	  Cmes.addItem("Abril");
   	  Cmes.addItem("Mayo");
   	  Cmes.addItem("Junio");
   	  Cmes.addItem("Julio");
   	  Cmes.addItem("Agosto");
   	  Cmes.addItem("Septiembre");
   	  Cmes.addItem("Octubre");
   	  Cmes.addItem("Noviembre");
   	  Cmes.addItem("Diciembre");
   	  Lpanel.add(Cmes);
   	  Cmes.addActionListener(this);

  	  // Jlist del año
      JLano = new JList(elementos);
  	  JLano.setBounds(125,25,40,20);
  	  JLano.setBorder(new EtchedBorder());
  	  JLano.setSelectionBackground(Color.white);
  	  Lpanel.add(JLano);

  	  // boton aumenta el año
  	  Barr = new JButton(new ImageIcon(DemoCalendario.class.getResource("images/imagenesCalendario/Arriba.jpg")));
  	  Barr.setBounds(165,25,18,10);
      Barr.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Barr.addActionListener(this);
      Lpanel.add(Barr);

      // boton disminuye el año
      Baba = new JButton(new ImageIcon(DemoCalendario.class.getResource("images/imagenesCalendario/Abajo.jpg")));
      Baba.setBounds(165,33,18,10);
      Baba.setCursor(new Cursor(Cursor.HAND_CURSOR));
      Baba.addActionListener(this);
      Lpanel.add(Baba);


  	  // se crea los objeto y la tabla para el calendario
  	  Object num[][] = new Object[6][7];

 	  Object columnNames[] = {"L", "M", "M", "J", " V ", " S ", " D "};

      TableModel model = new DefaultTableModel(num, columnNames) {
         public boolean isCellEditable(int x, int y) {
           return false;
         }
      };


      table = new JTable(model);
      table.setFont(new Font("Arial",Font.BOLD,12));
      table.setGridColor(Color.white);
      table.setCellSelectionEnabled( true);  // selecciona celda no filas
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      table.setBorder(etched);
      table.getTableHeader().setReorderingAllowed(false);
      final TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
	  table.getTableHeader().setDefaultRenderer( new TableCellRenderer() {
			public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column ) {
				Component comp = headerRenderer.getTableCellRendererComponent( table, value, isSelected, hasFocus, row, column );
				if ( column == 6 )
				   comp.setBackground(Color.red);
				else
				   comp.setBackground(new Color(0,57,106));

				  comp.setForeground(Color.white);

				return comp;

			}
	  });


      JScrollPane scroll = new JScrollPane(table);
      scroll.setBounds(20,50,165,116);
      scroll.setBorder(etched);
      Lpanel.add(scroll);

      table.addMouseListener(new MouseAdapter() {

	    public void mouseReleased(MouseEvent evt) {

	 	  fila = table.getSelectedRow();
	      colum=table.getSelectedColumn();

  	      if(table.getValueAt(fila,colum).toString().equals("")) {

	         table.setRowSelectionInterval(f,f);
	         table.setColumnSelectionInterval(c,c);

  	       } else {
  	         f=fila;
  	         c=colum;
  	         mostrarFecha();
                 //en este punto se desaparace la ventana
  	         setVisible(false);
  	       }
	      }
      });

      configurarColumnas();

      fecha =new Fecha();  // se crea el constructor de las fecha
  	  Tfecha.setText(fecha.fechasistema);
  	  saberFecha(Tfecha);

  }

  // borrar la table
  public void borraTable(){
  	for(int i=0;i<6;i++)
       for(int j=0;j<7;j++)
  	  	 table.setValueAt("",i,j);
  }

  public void posicionJIntenal(int posX,int  posY){
	    this.setLocation(posX, posY);
  }

  // es el set para el textfiel de la fecha inicial y final
   public void setTfecha(JTextField Tfecha,int n){
  	 this.Tfecha=Tfecha;
   	 mostrarFecha();
   	 //limitefechas(Tfecha.getText(),n);
   }

   // es el intervalos de las fechas iniciales y de la fechas finales
   public void limitefechas(String fec,int n){
   	int num;
   	if(n==0){
   		num=Integer.parseInt(fec.substring(5,7));
   		if(num<=3){
   		  Tfecha.setText(String.valueOf(Integer.parseInt(elementos[0])-1)+"-07-01");
   		}
   		else{
   		  if(num<=8){
   		    Tfecha.setText(elementos[0]+"-01-01");
   		  }
   		  else{
   		  	  Tfecha.setText(elementos[0]+"-07-01");
   		  }

   		}
   	}
   	else{
   		num=Integer.parseInt(fec.substring(5,7));
   		if(num<=3){
   		   Tfecha.setText(String.valueOf(Integer.parseInt(elementos[0])-1)+"-12-31");
   		}
   		else{
   		  if(num<=8){
   		     Tfecha.setText(elementos[0]+"-06-30");
   		  }
   		  else{
   		  	 Tfecha.setText(elementos[0]+"-12-31");
   		  }

   		}
   	}

  }

   // muestra los numero en la table
  public void buscarCalendario(int dw,int nd ){//recive dia de la semana y numero de dias ???
  	if(dw==1)
  	  dw=6;
  	else
  	  dw=dw-2;

  	f=1;
  	c=dw;

  	int cogerfila=0; // para saber seleccionar el dia por primera vez
  	int cogercolumnas=dw; // para saber seleccionar el dia por primera vez

  	int cont=1;

  	for(int i=0;i<6;i++){///me indica en que fila inician los dias del mes
       for(int j=dw;j<7;j++){///me indica en que columna inician los dias del mes
  	    table.setValueAt(""+cont,i,j);

  	    if(cont==dia){ // saber las filas y columnas para seleccionarla
  	      cogerfila=i;
  	      cogercolumnas=j;
  	    }

  	  	if(cont==nd){
  	  	  j=8;///para q se salgadel ciclo
  	  	  i=9;///para q se salgadel ciclo
  	  	 }
  	  	 cont++;
  	  	 dw=0;

  	   }
  	}
  	table.setRowSelectionInterval(cogerfila,cogerfila);
  	table.setColumnSelectionInterval(cogercolumnas,cogercolumnas);
  	fila=cogerfila;
  	colum=cogercolumnas;
  	f= fila;
  	c = colum;
  }

  // configura las columnas
  public void configurarColumnas() {
       for (int i = 0; i<=6 ; i++)
 	  	 table.getColumnModel().getColumn(i).setCellRenderer(new MyRenderer());

  }

  // muestra  la fecha en el texfield cada vez que le debes a la tabla
  public void mostrarFecha(){

  	  String dia,mes;
  	  int d=Integer.parseInt(table.getValueAt(fila,colum).toString());///se obtiene el numero del dia q esta en la tabla
  	  if(d<10)
  	   dia='0'+table.getValueAt(fila,colum).toString();
  	  else
  	   dia=table.getValueAt(fila,colum).toString();

  	  int m=Cmes.getSelectedIndex()+1;
  	  if(m<10)
  	   mes='0'+String.valueOf(m);
  	  else
  	   mes=String.valueOf(m);


  	  Tfecha.setText(elementos[0]+'-'+mes+'-'+dia);

  }

  // modifica el año si es mayor o menor de 2006 dandole a los botones
  public void modificar(int a){
  	int ano=Integer.parseInt(elementos[0]);

  	if(ano==2099 && a==0)
  	 ano=1979;

  	if(ano==1980 && a==1)
  	 ano=2100;

  	if(a==0)
  	    elementos[0]=String.valueOf(ano+1);
  	 else
  	    elementos[0]=String.valueOf(ano-1);

  	 JLano.setListData(elementos);

  }

   // saber la fecha para  colocarla en la tabla por primera vez ***************************************************************************************
  public void saberFecha(JTextField Tfecha){
  	this.Tfecha=Tfecha;
  	String verificar=Tfecha.getText();
        dia=Integer.parseInt(verificar.substring(8,10));
  	elementos[0]=verificar.substring(0,4);
   	Cmes.setSelectedIndex(Integer.parseInt(verificar.substring(5,7))-1);

    cambiarano=Integer.parseInt(elementos[0]);
  	calen.mostar(cambiarano,Cmes.getSelectedIndex());
  	borraTable();
  	buscarCalendario(calen.getDayOfWeek(),calen.getDays());
  }

}


class MyRenderer extends JLabel implements TableCellRenderer {

   public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus,int row, int column) {

       if (value.equals(""))
         setEnabled(false);
       else
         setEnabled(true);

       if (isSelected && !value.equals(""))
          setBorder(new LineBorder(Color.red));
       else
          setBorder(null);


        setHorizontalAlignment(SwingConstants.CENTER);

        setText((String)value);

        return this;
    }
}

