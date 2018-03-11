package matrizenlistaligadaforma1;

import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
import matriz.Tripleta;

public class OpcionesMatriz
{
  private static Scanner sc;
  
  public MatrizEnListaLigadaForma1 ingresarMatriz()
  {
    sc = new Scanner(System.in);
    String fila = JOptionPane.showInputDialog( "Ingrese las filas:");
// Convertimos el dato ingresado en un int
    int f = Integer.parseInt( fila );
    String columna = JOptionPane.showInputDialog("Ingrese las columnas:");
    int c = Integer.parseInt( columna );
    
    MatrizEnListaLigadaForma1 matriz = new MatrizEnListaLigadaForma1(f, c);
    Tripleta t;
    while ((t = ingresarTripleta()) != null) {
      matriz.insertar(t);
    }
    JOptionPane.showMessageDialog(null,"La matriz ingresada fue: ");
    mostrarMatriz(matriz);
    return matriz;
  }
  
  private static Tripleta ingresarTripleta()
  {
    JOptionPane.showMessageDialog(null,"Ingrese solamente los terminos diferentes de 0");
      String num1;
         num1 = JOptionPane.showInputDialog("Ingrese la tripleta separada por (coma ,) [ Ejemplo: 2,3,5] :  (Ingrese un 0, en cualquier posición para finalizar el llenado)");
        String[] datos = num1.split(",");
    // String[] datos = sc.next().split(",");
    Tripleta t = null;
    int f = Integer.parseInt(datos[0]);
    int c = Integer.parseInt(datos[1]);
    int v = Integer.parseInt(datos[2]);
    if ((f != 0) && (c != 0) && (v != 0)) {
      t = new Tripleta(f, c, v);
    }
    return t;
  }
  
  private static void mostrarMatriz(MatrizEnListaLigadaForma1 matriz)
  {
    matriz.imprimir();
  }
  
  public void multiplica(MatrizEnListaLigadaForma1 a, MatrizEnListaLigadaForma1 b)
  {
    int e = a.multi(b);
    if (e == 1)
    {
      JOptionPane.showMessageDialog(null,"Las matrices no se pueden Multiplicar");
    }
    else
    {
      JOptionPane.showMessageDialog(null,"la matriz resultante es ");
      a.imprimir();
    }
  }
  
  public void transpuesta(MatrizEnListaLigadaForma1 a)
  {
    MatrizEnListaLigadaForma1 r = a.transpuesta();
    
    JOptionPane.showMessageDialog(null,"la matriz inversa es: ");
    r.imprimir();
  }
  
  public void determiante(MatrizEnListaLigadaForma1 a)
  {
    double det = a.determinante(a);
    
    JOptionPane.showMessageDialog(null,"El determiante de la matriz es: " + det);
  }
  
  public void inversa(MatrizEnListaLigadaForma1 t)
  {
    MatrizEnListaLigadaForma1 r = t.inversa(t, t.nc.getT().getC());
    
    JOptionPane.showMessageDialog(null,"la inversa de la matriz A  es: ");
    r.imprimir();
  }
}