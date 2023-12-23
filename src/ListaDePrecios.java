import javax.swing.*;
import java.awt.*;

public class ListaDePrecios extends JFrame{

    JTextArea Listado, ListadoPrecios, TipoMoneda;

    String[] ProductosEsp = {"Sixpack Vino","Sixpack Vino premiun","Sixpack Gaseosa","Sixpack Gaseosa premiun","Whiskey",
            "Whiskey premiun","Sixpack Sidra","Sixpack Sidra Premiun","Champagne","Champagne Premiun",
            "Vino Premiun","SixPack Fernet","Fernet","Sixpack cerveza","Sixpack cerveza artezanal",
            "Botellon agua 20L", "Botellon agua 10L","Sixpack Vodka"};

    String ProductosIng[] ={"Sixpack Wine","Sixpack Premium Wine","Sixpack Soda","Sixpack Premium Soda","Whiskey",
            "Premiun Whiskey","Sixpack Cider","Sixpack Premium Cider","Champagne","Premiun Champagne",
            "Premium Wine","SixPack Fernet","Fernet","Sixpack beer","Sixpack artezanal beer",
            "20L water bottle", "10L water bottles","Sixpack Vodka"};

    String ProductosPort[] ={"Vinho Sixpack","Vinho Premium Sixpack","Refrigerante Sixpack","Refrigerante Sixpack Premium"
            ,"Uísque", "Premiun Whiskey","Sixpack Cider","Sixpack Premium Cider","Champagne","Premiun Champagne",
            "Vinho Premium","SixPack Fernet","Fernet","Sixpack cerveja","Sixpack cerveja artezanal",
            "Garrafa de água 20L", "Garrafas de água 10L","Sixpack Vodka"};

    String ProductosAlm[] = {"Sixpack Wine", "Sixpack Premium Wine", "Sixpack Soda", "Sixpack Premium Soda", "Whisky",
            "Premiun Whiskey", "Sixpack Cider", "Sixpack Premium Cider", "Champagne", "Premiun Champagne",
            "Premiumwein", "SixPack Fernet", "Fernet", "Sixpack Bier", "Sixpack Artezanal Bier",
            "20L Wasserflasche", "10L Wasserflaschen", "Sixpack Vodka"};

    double Precios[] = {52.92,163.5,4.5,13.5,165,260,22.5,40.5,28.25,53.50,32.75,166.5,27.75,7.5,19.5,1.5,1,49.5};
    double PreciosAux[] = {52.92,163.5,4.5,13.5,165,260,22.5,40.5,28.25,53.50,32.75,166.5,27.75,7.5,19.5,1.5,1,49.5};

    String Moneda = "USD";

    public ListaDePrecios(){

       setLayout(null);
       getContentPane().setBackground(new Color(45,87,30));

       Listado = new JTextArea();
       Listado.setBounds(10,10,175,275);
       Listado.setEditable(false);
       Listado.setForeground(Color.black);
       add(Listado);

       for(int i = 0; i < ProductosEsp.length; i++){
           if(i == 0){
               Listado.setText(ProductosEsp[i]);
           }else{
               Listado.setText(Listado.getText()+"\n"+ProductosEsp[i]);
           }
       }

       ListadoPrecios = new JTextArea();
       ListadoPrecios.setBounds(185,10,70,275);
       ListadoPrecios.setEditable(false);
       ListadoPrecios.setForeground(Color.black);
       add(ListadoPrecios);

       for(int i = 0; i < Precios.length;i++){
           if(i == 0){
               ListadoPrecios.setText(String.valueOf(Precios[i]));
           }else{
               ListadoPrecios.setText(ListadoPrecios.getText()+"\n"+String.valueOf(Precios[i]));
           }
       }

       TipoMoneda = new JTextArea();
       TipoMoneda.setBounds(255,10,50,275);
       TipoMoneda.setEditable(false);
       TipoMoneda.setForeground(Color.black);
       add(TipoMoneda);

       for(int i = 0; i < Precios.length; i++){
           if(i == 0){
               TipoMoneda.setText(Moneda);
           }else{
               TipoMoneda.setText(TipoMoneda.getText()+"\n"+Moneda);
           }
       }
    }
}
