package Vista;

import javax.swing.JOptionPane;

public class InOut {

    //Este método se encarga de solicitar string.
    public String solicitarInfo(String mensaje) {
        String s = JOptionPane.showInputDialog(mensaje);
        return s;
    }

    //Este método se encarga de solicitar entero.
    public int solicitarEntero(String mensaje) {
        String s = JOptionPane.showInputDialog(mensaje);

        while (validarStringEntero(s) == false) {
            s = JOptionPane.showInputDialog("DATO NO VÁLIDO\n" + mensaje);
        }

        int n = Integer.parseInt(s);

        return n;
    }
    
    //Este método se encarga de solicitar entero.
    public int solicitarEnteroPositivo(String mensaje) {
        String s = JOptionPane.showInputDialog(mensaje);

        while (validarStringEnteroPositivo(s) == false) {
            s = JOptionPane.showInputDialog("DATO NO VÁLIDO\n" + mensaje);
        }

        int n = Integer.parseInt(s);

        return n;
    }

    //Este método se encarga de solicitar boolean.
    public boolean solicitarBoolean(String mensaje) {
        if (JOptionPane.showConfirmDialog(null, mensaje, mensaje,
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            return true;
        } else {
            return false;
        }
    }

    //Este método muestra en pantalla el resultado.
    public void mostrarInfo(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
        //Null=Ubicación de Mensaje.
    }

    public boolean validarStringEntero(String n) {
        if ((n).matches("[-]?[0-9]+")) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean validarStringEnteroPositivo(String n) {
        if ((n).matches("[0-9]+")) {
            if(Integer.parseInt(n)>0){
            return true;
        }else {
                return false;
                }
        } else {
            return false;
        }
    }

}