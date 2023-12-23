import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenida extends JFrame implements ActionListener {

    Tools Herramientas = new Tools();

    JButton Aceptar;
    JLabel Bienvenida, NombreDeUsuario, CorreoElectronico, NombreNegocio;
    JTextField Usuario, Correo;

    public Bienvenida(){
        setLayout(null);

        Bienvenida = new JLabel("Bienvenido");
        Bienvenida.setBounds(50,50,180,50);
        Bienvenida.setFont(new Font("Great Vibes",1,42));
        Bienvenida.setForeground(Color.black);
        add(Bienvenida);

        NombreNegocio = new JLabel("TragoExpress: venta de bebidas");
        NombreNegocio.setBounds(40,90,190,30);
        add(NombreNegocio);

        NombreDeUsuario = new JLabel("Usuario");
        NombreDeUsuario.setBounds(50,130,100,30);
        add(NombreDeUsuario);

        Usuario = new JTextField();
        Usuario.setBounds(50,160,170,30);
        Usuario.setName("Usuario");
        add(Usuario);

        CorreoElectronico = new JLabel("Correo Electronico");
        CorreoElectronico.setBounds(50,210,130,30);
        add(CorreoElectronico);

        Correo = new JTextField();
        Correo.setBounds(50,240,170,30);
        add(Correo);

        Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(this);
        Aceptar.setBounds(80,290,100,30);
        add(Aceptar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Aceptar){
            try{
                Herramientas.IsNotEmpty(Usuario);
                Herramientas.IsNotEmpty(Correo);
                Herramientas.ValidarPalabra(Usuario);

                Principal VentanaPrincipal = new Principal();
                VentanaPrincipal.setBounds(0,0,400,300);
                VentanaPrincipal.setLocationRelativeTo(null);
                VentanaPrincipal.setResizable(false);
                VentanaPrincipal.setVisible(true);

                this.dispose();

            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

    }

    public static void main(String args[]){

        Bienvenida Ventana = new Bienvenida();
        Ventana.setBounds(0,0,290,400);
        Ventana.setLocationRelativeTo(null);
        Ventana.setResizable(false);
        Ventana.setVisible(true);
        Ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
