import javax.swing.*;

public class Tools {

    public void IsNotEmpty(JTextField Campo) throws Exception{
        if(Campo.getText().trim().equals("")){

            throw new Exception("Se deben llenar todos los campos de texto");

        }
    }

    public void ValidarPalabra(JTextField Campo) throws Exception{

        char[] Palabra = Campo.getText().trim().toCharArray();

        for(int i = 0; i < Palabra.length; i++){
            if(!(Palabra[i] >= 'a' && Palabra[i] <= 'z')){
                if(!(Palabra[i] >= 'A' && Palabra[i] <= 'Z')){
                    if(!(Palabra[i] >= 160 && Palabra[i] <= 165)){
                        if(!(Palabra[i] == 130)){
                            Campo.setText("");
                            throw new Exception("No se aceptan numeros ni caracteres especiales en la casilla "
                                                +Campo.getName());
                        }
                    }

                }
            }
        }
    }

}
