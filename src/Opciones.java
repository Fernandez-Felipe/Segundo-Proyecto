import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Opciones extends JPanel implements ActionListener, ItemListener, ChangeListener {

    JPanel PanelDeOpciones, Panel1, Panel2;
    JButton Guardar, Salir;

    JLabel idioma, Spanish, English, Portugues, Aleman, ValorDeLasMonedas;

    JComboBox Conversion;

    ButtonGroup idiomas;
    JRadioButton Español, ingles, portugues,aleman;

    public String Moneda = "Dolar" , Idioma = "Español";

    public Opciones(){


        PanelDeOpciones = new JPanel();
        PanelDeOpciones.setLayout(null);
        PanelDeOpciones.setBounds(0,0,400,300);
        PanelDeOpciones.setBackground(new Color(45,87,30));

        Panel1 = new JPanel();
        Panel1.setLayout(null);
        Panel1.setBounds(15,15,130,200);
        Panel1.setBackground(Color.WHITE);
        PanelDeOpciones.add(Panel1);

        Panel2 = new JPanel();
        Panel2.setLayout(null);
        Panel2.setBounds(165,15,210,150);
        Panel2.setBackground(Color.WHITE);
        PanelDeOpciones.add(Panel2);

        idioma = new JLabel("Idiomas Disponibles");
        idioma.setBounds(5,10,130,30);
        idioma.setFont(new Font("Arial", 1,12));
        Panel1.add(idioma);

        idiomas = new ButtonGroup();

        //Monedas
        Conversion = new JComboBox<>();
        Conversion.addItem("Dolar");
        Conversion.addItem("Real");
        Conversion.addItem("Euro");
        Conversion.addItem("Libra Estarlina");
        Conversion.setBounds(50,10,100,30);
        Conversion.addItemListener(this);
        Panel2.add(Conversion);

        //Tasa de conversion
        ValorDeLasMonedas = new JLabel("  Los precios estaran en Dolares");
        ValorDeLasMonedas.setBounds(0,110,210,30);
        ValorDeLasMonedas.setBackground(Color.WHITE);
        Panel2.add(ValorDeLasMonedas);

        //Español
        Spanish = new JLabel("Español");
        Spanish.setBounds(25,50,50,30);
        Panel1.add(Spanish);

        Español = new JRadioButton();
        Español.setBounds(85,50,20,30);
        Español.addChangeListener(this);
        Español.setBackground(Color.WHITE);
        Panel1.add(Español);
        idiomas.add(Español);

        //Ingles
        English  = new JLabel("English");
        English.setBounds(25,90,50,30);
        Panel1.add(English);

        ingles = new JRadioButton();
        ingles.setBounds(85,90,20,30);
        ingles.addChangeListener(this);
        ingles.setBackground(Color.WHITE);
        Panel1.add(ingles);
        idiomas.add(ingles);

        //Portugues
        Portugues = new JLabel("Português");
        Portugues.setBounds(25,130,100,30);
        Panel1.add(Portugues);

        portugues = new JRadioButton();
        portugues.setBounds(85,130,20,30);
        portugues.addChangeListener(this);
        portugues.setBackground(Color.WHITE);
        Panel1.add(portugues);
        idiomas.add(portugues);

        //Aleman
        Aleman = new JLabel("Deutsch");
        Aleman.setBounds(25,170,100,30);
        Panel1.add(Aleman);

        aleman = new JRadioButton();
        aleman.setBounds(85,170,20,30);
        aleman.addChangeListener(this);
        aleman.setBackground(Color.WHITE);
        Panel1.add(aleman);
        idiomas.add(aleman);

        Guardar = new JButton("Guardar");
        Guardar.addActionListener(this);
        Guardar.setBounds(285,190,90,30);
        PanelDeOpciones.add(Guardar);

        Salir = new JButton("Salir");
        Salir.addActionListener(this);
        Salir.setBounds(165,190,110,30);
        PanelDeOpciones.add(Salir);

        PanelDeOpciones.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Salir){
            PanelDeOpciones.setVisible(false);
        }

        if(e.getSource() == Guardar){

                switch (Idioma){
                    case "Español":
                        idioma.setText("Idiomas Disponibles");
                        Conversion.removeAllItems();
                        Conversion.addItem("Dolar");
                        Conversion.addItem("Real");
                        Conversion.addItem("Euro");
                        Conversion.addItem("Libra Estarlina");
                        Guardar.setText("Guardar");
                        Salir.setText("Salir");
                        break;
                    case "Ingles":
                        idioma.setText("Available languages");
                        Conversion.removeAllItems();
                        Conversion.addItem("Dollar");
                        Conversion.addItem("Real");
                        Conversion.addItem("Euro");
                        Conversion.addItem("British Pound");
                        Guardar.setText("Save");
                        Salir.setText("Exit");
                        break;
                    case "Portugues":
                        idioma.setText("Idiomas disponíveis");
                        Conversion.removeAllItems();
                        Conversion.addItem("Dolar");
                        Conversion.addItem("Real");
                        Conversion.addItem("Euro");
                        Conversion.addItem("libra esterlinas");
                        Guardar.setText("Manter");
                        Salir.setText("Sair");
                        break;
                    case "Aleman":
                        idioma.setText("Verfügbare Sprachen");
                        Conversion.removeAllItems();
                        Conversion.addItem("Dollar");
                        Conversion.addItem("Real");
                        Conversion.addItem("Euro");
                        Conversion.addItem("Britische Pfund");
                        Guardar.setText("Hüten");
                        Salir.setText("Hinausgehen");
                        break;
                }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent a) {

        if(a.getSource() == Conversion){

            try {
                if (Conversion.getSelectedItem().toString().equals("Real")) {
                    ValorDeLasMonedas.setText("  1 Dollar = 4.93 Reales");
                    Moneda = "Real";
                } else if (Conversion.getSelectedItem().toString().equals("Euro")) {
                    ValorDeLasMonedas.setText("  1 Dollar = 0.93 Euros");
                    Moneda = "Euro";
                } else if (Conversion.getSelectedItem().toString().equals("Libra Estarlina") ||
                           Conversion.getSelectedItem().toString().equals("libra esterlinas") ||
                           Conversion.getSelectedItem().toString().equals("Britische Pfund") ||
                           Conversion.getSelectedItem().toString().equals("British Pound") ){
                    Moneda = "Libra Estarlina";
                } else if (Conversion.getSelectedItem().toString().equals("Dolar") ||
                           Conversion.getSelectedItem().toString().equals("Dollar")) {
                    Moneda = "Dolar";
                }
            }catch (Exception ex){

            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {

            if (Español.isSelected()) {
                Idioma = "Español";
            }
            if (ingles.isSelected()) {
                Idioma = "Ingles";
            }
            if (portugues.isSelected()) {
                Idioma = "Portugues";
            }
            if (aleman.isSelected()) {
                Idioma = "Aleman";
            }
    }
}
