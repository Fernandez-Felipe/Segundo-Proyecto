import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Quejas extends JPanel implements ActionListener, ItemListener{

    Opciones OP = new Opciones();

    JPanel PanelDeQuejas;
    JTextArea ArearDeTexto;
    JComboBox ComboDeQuejas;
    String Fallo;
    JButton Enviar, Salir;

    private String Queja[] = new String[2];

    public Quejas(){

        PanelDeQuejas = new JPanel();
        PanelDeQuejas.setLayout(null);
        PanelDeQuejas.setBounds(0,0,400,300);
        PanelDeQuejas.setBackground(new Color(45,87,30));

        ComboDeQuejas = new JComboBox();
        ComboDeQuejas.addItem("Error de traduccion");
        ComboDeQuejas.addItem("Fallos en la tasa de conversion");
        ComboDeQuejas.addItem("Fallos varios");
        ComboDeQuejas.setBounds(10,10,183,30);
        ComboDeQuejas.addItemListener(this);
        PanelDeQuejas.add(ComboDeQuejas);

        ArearDeTexto = new JTextArea();
        ArearDeTexto.setBounds(10,50,370,180);
        PanelDeQuejas.add(ArearDeTexto);

        Enviar = new JButton("Enviar");
        Enviar.setBounds(203,10,100,30);
        Enviar.addActionListener(this);
        PanelDeQuejas.add(Enviar);

        Salir = new JButton("<-");
        Salir.setBounds(313,10,70,30);
        Salir.addActionListener(this);
        PanelDeQuejas.add(Salir);

        PanelDeQuejas.setVisible(false);

        OP.Guardar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == Salir){
            PanelDeQuejas.setVisible(false);
        }

        if(e.getSource() == Enviar){

            if(ArearDeTexto.getText().equals("")){

                    switch (Enviar.getText()){
                        case "Enviar ":
                            JOptionPane.showMessageDialog(this,"Por favor, describa el error" +
                                                                                     " que desea reportar");
                            break;
                        case "Send":
                            JOptionPane.showMessageDialog(this,"Please describe the bug you" +
                                                                                     " want to report");
                            break;
                        case "Enviar":
                            JOptionPane.showMessageDialog(this,"Por favor, descreva o bug" +
                                                                                     " que você deseja relatar");
                            break;
                        case "Schicken":
                            JOptionPane.showMessageDialog(this,"Bitte beschreiben Sie den" +
                                                                                     " Fehler, den Sie melden möchten");
                            break;
                    }
            }else{
                    switch (Enviar.getText()){
                        case "Enviar ":
                            JOptionPane.showMessageDialog(this,"Su reporte ha sido enviado" +
                                                                                     " con exito");
                            break;
                        case "Send":
                            JOptionPane.showMessageDialog(this,"Your report has been sent" +
                                                                                     " successfully");
                            break;
                        case "Enviar":
                            JOptionPane.showMessageDialog(this,"Seu relatório foi enviado" +
                                                                                     " com sucesso");
                            break;
                        case "Schicken":
                            JOptionPane.showMessageDialog(this,"Ihr Bericht wurde erfolgreich" +
                                                                                     " gesendet");
                            break;
                    }
                    Queja[0] = Fallo;
                    Queja[1] = ArearDeTexto.getText();
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {


        try {
            if(e.getSource() == ComboDeQuejas){

                Fallo = ComboDeQuejas.getSelectedItem().toString();

            }
        }catch (Exception ex){

        }
    }
}
