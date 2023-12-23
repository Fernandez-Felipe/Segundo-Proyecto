/*Este es el formulario principal en donde se pueden invocar a los formularios de bienvenida, de opciones y el
 de quejas */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Principal extends JFrame implements ActionListener, MouseListener, ItemListener {

    Quejas quejas = new Quejas();
    Opciones OP = new Opciones();

    DecimalFormat df = new DecimalFormat("#.00");

    ListaDePrecios LP = new ListaDePrecios();

    String ProductoSeleccionado, ModenaActual = "Dolar";

    int CantidadSeleccionada;

    JMenuBar Menubar;
    JMenu Opciones,Salir;

    JMenuItem Exit, CerrarSesion, Options,ReportarFallos, Listado;

    JScrollPane Scroll, Ticked;

    JComboBox Cantidad;

    JButton Agregar, Comprar, Borrar;

    JTextArea PrecioCompra, PrecioTotal;

    JPanel PanelPrincipal;

    JList ListaProductos;
    DefaultListModel Productos;

    ListaDePrecios Listadeprecios;

    private double Precio,PrecioProducto;

    private String TickedDeCompra;
    private Double PrecioFinal;
    public Principal(){
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        PanelPrincipal = new JPanel();
        PanelPrincipal.setLayout(null);
        PanelPrincipal.setBounds(0,0,400,300);

        PanelPrincipal.setBackground(new Color(45,87,30));

        Productos = new DefaultListModel<>();

        for(int i = 0; i < LP.ProductosEsp.length; i++){
            Productos.addElement(LP.ProductosEsp[i]);
        }

        ListaProductos = new JList<>(Productos);
        ListaProductos.addMouseListener(this);

        Scroll = new JScrollPane(ListaProductos);
        Scroll.setBounds(15,15,200,200);
        PanelPrincipal.add(Scroll);

        Cantidad = new JComboBox();
        Cantidad.setBounds(220,15,50,30);
        Cantidad.addItemListener(this);

        for(int i = 1; i <= 12; i++){
            Cantidad.addItem(i);
        }

        PanelPrincipal.add(Cantidad);

        PrecioCompra = new JTextArea("");
        PrecioCompra.setEditable(false);

        Ticked= new JScrollPane(PrecioCompra);
        Ticked.setBounds(220,55,160,80);
        PanelPrincipal.add(Ticked);

        PrecioTotal = new JTextArea("0");
        PrecioTotal.setEditable(false);
        PrecioTotal.setBounds(220,145,160,20);
        PanelPrincipal.add(PrecioTotal);

        Agregar = new JButton("Agregar");
        Agregar.setBounds(280,15,100,30);
        Agregar.addActionListener(this);
        PanelPrincipal.add(Agregar);

        Borrar = new JButton("Borrar");
        Borrar.setBounds(250,215,100,20);
        Borrar.addActionListener(this);
        PanelPrincipal.add(Borrar);

        Comprar = new JButton("Realizar compra");
        Comprar.setBounds(220,175,160,30);
        Comprar.addActionListener(this);
        PanelPrincipal.add(Comprar);

        Menubar = new JMenuBar();
        setJMenuBar(Menubar);

        Opciones = new JMenu("Opciones");
        Menubar.add(Opciones);

        Options = new JMenuItem("Opciones");
        Options.addActionListener(this);
        Opciones.add(Options);

        ReportarFallos = new JMenuItem("Enviar Queja");
        ReportarFallos.addActionListener(this);
        Opciones.add(ReportarFallos);


        Salir = new JMenu("Cerrar Secion");
        Menubar.add(Salir);

        Exit = new JMenuItem("Salir");
        Exit.addActionListener(this);
        Salir.add(Exit);

        CerrarSesion = new JMenuItem("Cerrar Sesion");
        CerrarSesion.addActionListener(this);
        Salir.add(CerrarSesion);

        Listado = new JMenuItem("Precios");
        Listado.addActionListener(this);
        Opciones.add(Listado);

        add(PanelPrincipal);
        add(quejas.PanelDeQuejas);
        add(OP.PanelDeOpciones);
        OP.Guardar.addActionListener(this);
        OP.Salir.addActionListener(this);

        quejas.Enviar.addActionListener(this);
        quejas.Salir.addActionListener(this);

        Listadeprecios = new ListaDePrecios();
        Listadeprecios.setBounds(0,0,330,340);
        Listadeprecios.setLocationRelativeTo(null);
        Listadeprecios.setResizable(false);
        Listadeprecios.setVisible(false);

    }



    @Override
    public void actionPerformed(ActionEvent e) {


        //Se agregan X productos a la compra
        if(e.getSource() == Agregar){

            try{
                for(int i = 0; i < CantidadSeleccionada; i++) {
                    if(i == 0){
                        PrecioCompra.setText(PrecioCompra.getText() + ProductoSeleccionado);
                    }else {
                        PrecioCompra.setText(PrecioCompra.getText() + "\n" + ProductoSeleccionado);
                    }
                }
                for(int i = 0; i < Listadeprecios.ProductosEsp.length; i++){
                    if(ProductoSeleccionado.equals(Listadeprecios.ProductosEsp[i])){
                        PrecioProducto = Listadeprecios.Precios[i];
                        break;
                    }else if(ProductoSeleccionado.equals(Listadeprecios.ProductosIng[i])){
                        PrecioProducto = Listadeprecios.Precios[i];
                        break;
                    }else if(ProductoSeleccionado.equals(Listadeprecios.ProductosPort[i])){
                        PrecioProducto = Listadeprecios.Precios[i];
                        break;
                    }else if(ProductoSeleccionado.equals(Listadeprecios.ProductosAlm[i])){
                        PrecioProducto = Listadeprecios.Precios[i];
                        break;
                    }
                }
            }catch (Exception ex){

            }
            Precio = Double.parseDouble(PrecioTotal.getText().toString()) + PrecioProducto;
            Precio *= CantidadSeleccionada;
            PrecioTotal.setText((String.valueOf(Precio)));
        }

        if(e.getSource() == Borrar){
            PrecioTotal.setText("0");
            PrecioCompra.setText("");
        }


        //Se confirma la compra
        if(e.getSource() == Comprar){
            TickedDeCompra = PrecioCompra.getText();
            PrecioFinal = Double.parseDouble(PrecioTotal.getText());

            PrecioTotal.setText("0");
            PrecioCompra.setText("");

            if(OP.Idioma.equals("Español")){
                JOptionPane.showMessageDialog(this,"Su pedido de compra ah sido enviado," +
                        " nos contactaremos con usted para por E-mail para confirmar la compra");
            }else if(OP.Idioma.equals("Ingles")){
                JOptionPane.showMessageDialog(this,"Your purchase order has been sent," +
                        " we will contact you by email to confirm the purchase");
            }else if(OP.Idioma.equals("Portugues")) {
                JOptionPane.showMessageDialog(this,"Seu pedido de compra foi enviado," +
                        " entraremos em contato por e-mail para confirmar a compra");
            }else if(OP.Idioma.equals("Aleman")){
                JOptionPane.showMessageDialog(this,"Ihre Bestellung wurde gesendet." +
                        " Wir werden Sie per E-Mail kontaktieren, um den Kauf zu bestätigen");
            }

        }

        if(e.getSource() == Listado){
            Listadeprecios.setVisible(true);
        }

        if(e.getSource() == OP.Salir){
            PanelPrincipal.setVisible(true);
        }

        if(e.getSource() == quejas.Salir){
            PanelPrincipal.setVisible(true);
        }

        if(e.getSource() == Exit){
            this.dispose();
        }
        if(e.getSource() == CerrarSesion){
            Bienvenida Ventana = new Bienvenida();
            Ventana.setBounds(0,0,290,400);
            Ventana.setLocationRelativeTo(null);
            Ventana.setResizable(false);
            Ventana.setVisible(true);
            Ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

            this.dispose();
        }
        if(e.getSource() == Options){
            OP.PanelDeOpciones.setVisible(true);
            quejas.PanelDeQuejas.setVisible(false);
            PanelPrincipal.setVisible(false);
        }

        if(e.getSource() == ReportarFallos){
            quejas.PanelDeQuejas.setVisible(true);
            OP.PanelDeOpciones.setVisible(false);
            PanelPrincipal.setVisible(false);
        }

        //Aqui se hacen los cambios de idiomas y de moneda
        if(e.getSource() == OP.Guardar){

            ModenaActual = OP.Moneda;
            PrecioTotal.setText("");
            PrecioCompra.setText("");

               quejas.ComboDeQuejas.removeAllItems();

                if (OP.Idioma.equals("Español")){
                    JOptionPane.showMessageDialog(this,"Se han aplicado los cambios seleccionados");

                    quejas.Enviar.setText("Enviar ");

                    //Menu de opciones
                    Opciones.setText("Opciones");
                    Options.setText("Opciones");
                    ReportarFallos.setText("Enviar Queja");

                    //Menu de Cerrar Sesion
                    Salir.setText("Cerrar Sesion");
                    CerrarSesion.setText("Cerrar Sesion");
                    Exit.setText("Salir");

                    //Botones Principales
                    Listado.setText("Precios");
                    Agregar.setText("Agregar");
                    Borrar.setText("Borrar");
                    Comprar.setText("Realizar Compra");

                    quejas.ComboDeQuejas.addItem("Error de traduccion");
                    quejas.ComboDeQuejas.addItem("Fallos en la tasa de conversion");
                    quejas.ComboDeQuejas.addItem("Fallos varios");

                    Listadeprecios.Listado.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosEsp.length; i++){
                        if(i == 0){
                            Listadeprecios.Listado.setText(Listadeprecios.ProductosEsp[i]);
                        }else{
                            Listadeprecios.Listado.setText(Listadeprecios.Listado.getText()+"\n"+Listadeprecios.ProductosEsp[i]);
                        }
                    }

                    Productos.removeAllElements();
                    for(int i = 0; i < LP.ProductosEsp.length; i++){
                        Productos.addElement(LP.ProductosEsp[i]);
                    }

                } else if (OP.Idioma.equals("Ingles")){
                    JOptionPane.showMessageDialog(this,"The selected changes have been applied");

                    quejas.Enviar.setText("Send");

                    //Menu de opciones
                    Opciones.setText("Options");
                    Options.setText("Options");
                    ReportarFallos.setText("Submit Complaint");

                    //Menu de Cerrar Sesion
                    Salir.setText("Sign off");
                    CerrarSesion.setText("Sign off");
                    Exit.setText("Exit");

                    //Botones Principales
                    Listado.setText("Prices");
                    Agregar.setText("Add");
                    Borrar.setText("Delete");
                    Comprar.setText("Make a purchase");

                    Listado.setText("Prices");

                    quejas.ComboDeQuejas.addItem("translation error");
                    quejas.ComboDeQuejas.addItem("Conversion rate errors");
                    quejas.ComboDeQuejas.addItem("Miscellaneous errors");

                    Listadeprecios.Listado.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosIng.length; i++){
                        if(i == 0){
                            Listadeprecios.Listado.setText(Listadeprecios.ProductosIng[i]);
                        }else{
                            Listadeprecios.Listado.setText(Listadeprecios.Listado.getText()+"\n"+Listadeprecios.ProductosIng[i]);
                        }
                    }

                    Productos.removeAllElements();
                    for(int i = 0; i < LP.ProductosIng.length; i++){
                        Productos.addElement(LP.ProductosIng[i]);
                    }

                } else if (OP.Idioma.equals("Portugues")){
                    JOptionPane.showMessageDialog(this,"As alterações selecionadas foram aplicadas");

                    quejas.Enviar.setText("Enviar");

                    //Menu de opciones
                    Opciones.setText("Opções");
                    Options.setText("Opções");
                    ReportarFallos.setText("Enviar reclamação");

                    //Menu de Cerrar Sesion
                    Salir.setText("Fechar Sessão");
                    CerrarSesion.setText("Fechar Sessão");
                    Exit.setText("Sair");

                    //Botones Principales
                    Listado.setText("Preços");
                    Agregar.setText("Adicionar");
                    Borrar.setText("Excluir");
                    Comprar.setText("Faça uma compra");

                    Listado.setText("Preços");

                    quejas.ComboDeQuejas.addItem("erro de tradução");
                    quejas.ComboDeQuejas.addItem("Erros de taxa de conversão");
                    quejas.ComboDeQuejas.addItem("Erros diversos");

                    Listadeprecios.Listado.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosPort.length; i++){
                        if(i == 0){
                            Listadeprecios.Listado.setText(Listadeprecios.ProductosPort[i]);
                        }else{
                            Listadeprecios.Listado.setText(Listadeprecios.Listado.getText()+"\n"+Listadeprecios.ProductosPort[i]);
                        }
                    }

                    Productos.removeAllElements();
                    for(int i = 0; i < LP.ProductosPort.length; i++){
                        Productos.addElement(LP.ProductosPort[i]);
                    }

                } else if (OP.Idioma.equals("Aleman")){
                    JOptionPane.showMessageDialog(this,"Die ausgewählten Änderungen wurden übernommen");

                    quejas.Enviar.setText("Schicken");

                    //Menu de opciones
                    Opciones.setText("Optionen");
                    Options.setText("Optionen");
                    ReportarFallos.setText("Beschwerde einreichen");

                    //Menu de Cerrar Sesion
                    Salir.setText("abmelden");
                    CerrarSesion.setText("abmelden");
                    Exit.setText("Hinausgehen");

                    //Botones Principales
                    Listado.setText("Preise");
                    Agregar.setText("Hinzufügen");
                    Borrar.setText("Löschen");
                    Comprar.setText("Einen Kauf tätigen");

                    Listado.setText("Preise");

                    quejas.ComboDeQuejas.addItem("Übersetzungsfehler");
                    quejas.ComboDeQuejas.addItem("Fehler bei der Conversion-Rate");
                    quejas.ComboDeQuejas.addItem("Verschiedene Fehler");

                    Listadeprecios.Listado.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosAlm.length; i++){
                        if(i == 0){
                            Listadeprecios.Listado.setText(Listadeprecios.ProductosAlm[i]);
                        }else{
                            Listadeprecios.Listado.setText(Listadeprecios.Listado.getText()+"\n"+Listadeprecios.ProductosAlm[i]);
                        }
                    }

                    Productos.removeAllElements();
                    for(int i = 0; i < LP.ProductosAlm.length; i++){
                        Productos.addElement(LP.ProductosAlm[i]);
                    }

                }

            System.out.println(OP.Moneda);

            switch (OP.Moneda){
                case "Dolar":

                    if (OP.Idioma.equals("Español")) {
                        OP.ValorDeLasMonedas.setText("  Los precios estaran en Dolares");
                    } else if (OP.Idioma.equals("Ingles")) {
                        OP.ValorDeLasMonedas.setText("  Prices will be in Dollars");
                    } else if (OP.Idioma.equals("Portugues")) {
                        OP.ValorDeLasMonedas.setText("  Os preços serão em dólares");
                    } else if (OP.Idioma.equals("Aleman")) {
                        OP.ValorDeLasMonedas.setText("Die Preise sind in Dollar angegeben");
                    }

                    Listadeprecios.TipoMoneda.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosAlm.length; i++){
                        if(i == 0){
                            Listadeprecios.TipoMoneda.setText("USD");
                        }else{
                            Listadeprecios.TipoMoneda.setText(Listadeprecios.TipoMoneda.getText()+"\n"+"USD");
                        }
                    }

                    Listadeprecios.ListadoPrecios.setText("");
                    Listadeprecios.Precios = Listadeprecios.PreciosAux;
                    for (int i = 0; i < Listadeprecios.Precios.length; i++){
                        if(i == 0){
                            Listadeprecios.ListadoPrecios.setText(String.valueOf(df.format(Listadeprecios.Precios[i])));
                        }else {
                            Listadeprecios.ListadoPrecios.setText(Listadeprecios.ListadoPrecios.getText()+"\n"
                                                                  +df.format(Listadeprecios.Precios[i]));
                        }
                    }

                    break;
                case "Real":
                    Listadeprecios.TipoMoneda.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosAlm.length; i++){
                        if(i == 0){
                            Listadeprecios.TipoMoneda.setText("  R$");
                        }else{
                            Listadeprecios.TipoMoneda.setText(Listadeprecios.TipoMoneda.getText()+"\n"+"  R$");
                        }
                    }

                    Listadeprecios.ListadoPrecios.setText("");
                    Listadeprecios.Precios = Listadeprecios.PreciosAux;
                    for (int i = 0; i < Listadeprecios.Precios.length; i++){
                        Listadeprecios.Precios[i] *= 4.93;
                        if(i == 0){
                            Listadeprecios.ListadoPrecios.setText(String.valueOf(df.format(Listadeprecios.Precios[i])));
                        }else {
                            Listadeprecios.ListadoPrecios.setText(Listadeprecios.ListadoPrecios.getText()+"\n"
                                                       +df.format(Listadeprecios.Precios[i]));
                        }
                    }
                    break;
                case "Euro":
                    Listadeprecios.TipoMoneda.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosAlm.length; i++){
                        if(i == 0){
                            Listadeprecios.TipoMoneda.setText("  €");
                        }else{
                            Listadeprecios.TipoMoneda.setText(Listadeprecios.TipoMoneda.getText()+"\n"+"  €");
                        }
                    }

                    Listadeprecios.ListadoPrecios.setText("");
                    Listadeprecios.Precios = Listadeprecios.PreciosAux;
                    for (int i = 0; i < Listadeprecios.Precios.length; i++){
                        Listadeprecios.Precios[i] *= 0.93;
                        if(i == 0){
                            Listadeprecios.ListadoPrecios.setText(String.valueOf(df.format(Listadeprecios.Precios[i])));
                        }else {
                            Listadeprecios.ListadoPrecios.setText(Listadeprecios.ListadoPrecios.getText()+"\n"
                                    +df.format(Listadeprecios.Precios[i]));
                        }
                    }
                    break;
                case "Libra Estarlina":

                    if (OP.Idioma.equals("Español")) {
                        OP.ValorDeLasMonedas.setText("  1 Dollar = 0.80 Libras Estarlinas");
                    }
                    if (OP.Idioma.equals("Ingles")) {
                        OP.ValorDeLasMonedas.setText("  1 Dollar = 0.80 British Pounds");
                    }
                    if (OP.Idioma.equals("Portugues")) {
                        OP.ValorDeLasMonedas.setText("  1 dólar = 0,80 libras esterlinas");
                    }
                    if (OP.Idioma.equals("Aleman")) {
                        OP.ValorDeLasMonedas.setText("  1 Dollar = 0,80 Britische Pfund");
                    }

                    Listadeprecios.TipoMoneda.setText("");
                    for(int i = 0; i < Listadeprecios.ProductosAlm.length; i++){
                        if(i == 0){
                            Listadeprecios.TipoMoneda.setText("  £");
                        }else{
                            Listadeprecios.TipoMoneda.setText(Listadeprecios.TipoMoneda.getText()+"\n"+"  £");
                        }
                    }

                    Listadeprecios.ListadoPrecios.setText("");
                    Listadeprecios.Precios = Listadeprecios.PreciosAux;
                    for (int i = 0; i < Listadeprecios.Precios.length; i++){
                        Listadeprecios.Precios[i] *= 0.80;
                        if(i == 0){
                            Listadeprecios.ListadoPrecios.setText(String.valueOf(df.format(Listadeprecios.Precios[i])));
                        }else {
                            Listadeprecios.ListadoPrecios.setText(Listadeprecios.ListadoPrecios.getText()+"\n"
                                    +df.format(Listadeprecios.Precios[i]));
                        }
                    }

                    break;
            }

        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getSource() == Cantidad){
            CantidadSeleccionada = Integer.parseInt(Cantidad.getSelectedItem().toString());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == ListaProductos){

            ProductoSeleccionado = ListaProductos.getSelectedValue().toString();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
