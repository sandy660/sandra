/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polinomiosf2;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author Sandra
 */
public class Opciones {

    public PolinomiosF2 ingresarPolinomio()
  {
     Scanner sc = new Scanner(System.in); 
   String num = JOptionPane.showInputDialog(null,"ingrese el # de terminos del polinomio diferentes de 0");
    int nTer = Integer.parseInt(num);
    PolinomiosF2 p1 = new PolinomiosF2(nTer);
    for (int i = 1; i <= nTer; i++)
    {
      JOptionPane.showMessageDialog(null,"ingrese los terminos del Polinomio de menor a mayor; ");
    String num1;
         num1 = JOptionPane.showInputDialog("ingrese el " + i + " termino de el coeficiente y luego el exponente del termino separados por coma(,)");
    String[] datos = num1.split(",");
             
      int c = Integer.parseInt(datos[0]);
      int e = Integer.parseInt(datos[1]);
      Termino t = new Termino(c, e);
      
      p1.insertaTermino(t);
    }
    return p1;
  }
}