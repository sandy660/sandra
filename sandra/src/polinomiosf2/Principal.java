 package polinomiosf2;

import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import matrizenlistaligadaforma1.MatrizEnListaLigadaForma1;
import matrizenlistaligadaforma1.OpcionesMatriz;

public class Principal{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Opciones o = new Opciones();
    OpcionesMatriz om = new OpcionesMatriz();
    
    PolinomiosF2 p1 = new PolinomiosF2(0);
    PolinomiosF2 p2;
      p2 = new PolinomiosF2(0);
    
    MatrizEnListaLigadaForma1 m1 = null;
    MatrizEnListaLigadaForma1 m2 = null;
    int op;
    

        do 
        {
            String menu;
        menu = JOptionPane.showInputDialog("POLINOMIOS FORMA 2 Y MATRICES DISPERSAS EN LISTA LIGADA FORMA 1"
                +"\n\nMENU"
                +"\n1.INGRESAR POLINOMIO A"
                +"\n2.INGRESAR POLINOMIO B"
                +"\n3.INGRESAR MATRIZ A"
                +"\n4.INGRESAR MATRIZ B"
                +"\n5.SUMAR POLINOMIOS A Y B"
                +"\n6.MULTIPLICAR POLINOMIOS A Y B"
                +"\n7.DERIVAR POLINOMIO A"
                +"\n8.DERIVAR POLINOMIO B"
                +"\n9.MULTIPLICAR MATRIZ A Y B"
                +"\n10.TRANSPUESTA DE LA MATRIZ A" 
                +"\n11.SALIR"+"\n\n");
            op = Integer.parseInt(menu);  
    
      try{
        op = Integer.parseInt(menu);

    }catch(NumberFormatException ex){
        JOptionPane.showMessageDialog(null,"***Hubo un Error***");
    }
      switch (op)
      {
      case 1: 

        p1 = o.ingresarPolinomio();
        p1.mostrar();
        break;
      case 2: 
        p2 = o.ingresarPolinomio();
        p2.mostrar();
        break;
      case 3: 
        m1 = om.ingresarMatriz();
        break;
      case 4: 
        m2 = om.ingresarMatriz();
        break;
      case 5:
        PolinomiosF2 ps = p1.suma(p2);
        ps.mostrar();
        System.out.println();
        break;
      case 6: 
        PolinomiosF2 pm = p1.multiplica(p2);
        pm.mostrar();
        System.out.println();
        break;
      case 7: 
        PolinomiosF2 pd = p1.deriva();
        pd.mostrar();
        System.out.println();
        break;
      case 8: 
        PolinomiosF2 pd1 = p2.deriva();
        p2.mostrar();
        System.out.println();
        break;
      case 9: 
        om.multiplica(m1, m2);
        break;
      case 10: 
        om.transpuesta(m1);
        break;
      case 11: 
      int salir = JOptionPane.showOptionDialog(null, 
      "¿Realmente desea salir?", 
      "Salir?", 
      JOptionPane.YES_NO_OPTION, 
      JOptionPane.QUESTION_MESSAGE, 
      null, null, null);
    if (salir == JOptionPane.YES_OPTION)
  {
    System.exit(0);
  }
    
      
//int seleccion = JOptionPane.showOptionDialog(btn_Option, "Realmente desea salir", "showOptionDialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Si", "No","Cancelar"}, "Si");
        break;
default:
JOptionPane.showMessageDialog(null, "Error no has selecionado una opción correcta");
       }
    } while (op != 11);
  }
}