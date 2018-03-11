package matrizenlistaligadaforma1;

import java.io.PrintStream;
import javax.swing.JOptionPane;
import matriz.Tripleta;

public class MatrizEnListaLigadaForma1
{
  NodoCabeza nc;
  
  MatrizEnListaLigadaForma1(int f, int c)
  {
    Tripleta t = new Tripleta(f, c, 0.0D);
    this.nc = new NodoCabeza(t);
    int max = f > c ? f : c;
    
    NodoCabeza ultimo = this.nc;
    for (int i = 1; i <= max; i++)
    {
      NodoCabeza nca = new NodoCabeza(new Tripleta(i, i, 0.0D));
      nca.setLigaC(nca);
      nca.setLigaF(nca);
      ultimo.setLiga(nca);
      ultimo = nca;
    }
    ultimo.setLiga(this.nc);
  }
  
  void insertar(Tripleta t)
  {
    NodoCabeza nca = this.nc.getLiga();
    Nodo nnuevo = new Nodo(t);
    while ((nca != this.nc) && (nca != null))
    {
      if (nca.getT().getF() == t.getF())
      {
        insertarEnFila(nca, nnuevo);
        break;
      }
      nca = nca.getLiga();
    }
    nca = this.nc.getLiga();
    while ((nca != this.nc) && (nca != null))
    {
      if (nca.getT().getC() == t.getC())
      {
        insertarEnColumna(nca, nnuevo);
        break;
      }
      nca = nca.getLiga();
    }
  }
  
  private void insertarEnFila(NodoCabeza nca, Nodo nnuevo)
  {
    Nodo s = nca.getLigaF();
    Nodo a = nca;
    while ((s != null) && (s != nca) && 
      (nnuevo.getT().getC() > s.getT().getC()))
    {
      a = s;
      s = s.getLigaF();
    }
    nnuevo.setLigaF(s);
    a.setLigaF(nnuevo);
  }
  
  private void insertarEnColumna(NodoCabeza nca, Nodo nnuevo)
  {
    Nodo s = nca.getLigaC();
    Nodo a = nca;
    while ((s != null) && (s != nca) && 
      (nnuevo.getT().getF() > s.getT().getF()))
    {
      a = s;
      s = s.getLigaC();
    }
    nnuevo.setLigaC(s);
    
    a.setLigaC(nnuevo);
  }
  
  void imprimir()
  {
    NodoCabeza p = this.nc;
    
    int f = p.getT().getF();
    p = p.getLiga();
    while ((p != this.nc) && (f != 0))
    {
      Nodo o = p.getLigaF();
      int i = 1;
      while (i <= this.nc.getT().getC()) {
        if (o.getT().getC() == i)
        {
          JOptionPane.showMessageDialog(null, o.getT().getV() + " ");
          o = o.getLigaF();
          i++;
        }
        else
        {
          JOptionPane.showMessageDialog(null,"0.0 ");
          i++;
        }
      }
      JOptionPane.showMessageDialog(null, "");
      
      p = p.getLiga();
      f--;
    }
  }
  
  public int multi(MatrizEnListaLigadaForma1 B)
  {
    if (this.nc.getT().getC() != B.nc.getT().getF()) {
      return 1;
    }
    NodoCabeza p = this.nc.getLiga();
    NodoCabeza b = B.nc.getLiga();
    
    Nodo o = p.getLigaF();
    Nodo l = b.getLigaC();
    double vA = 0.0D;
    double vB = 0.0D;
    int fA = this.nc.getT().getF();
    int cA = this.nc.getT().getC();
    int cB = B.nc.getT().getC();
    double v = 0.0D;
    
    MatrizEnListaLigadaForma1 aux = new MatrizEnListaLigadaForma1(fA, cB);
    for (int i = 1; i <= fA; i++)
    {
      for (int j = 1; j <= cB; j++)
      {
        for (int k = 1; k <= cA; k++)
        {
          if ((o.getT().getF() == i) && (o.getT().getV() != 0.0D) && (o.getT().getC() == k) && (o.getT().getV() != 0.0D))
          {
            vA = o.getT().getV();
            o = o.getLigaF();
          }
          else
          {
            vA = 0.0D;
          }
          if ((l.getT().getF() == k) && (l.getT().getV() != 0.0D) && (l.getT().getC() == j) && (l.getT().getV() != 0.0D))
          {
            vB = l.getT().getV();
            l = l.getLigaC();
          }
          else
          {
            vB = 0.0D;
          }
          v += vA * vB;
        }
        aux.insertar(new Tripleta(i, j, v));
        v = 0.0D;
        o = o.getLigaF();
        
        b = b.getLiga();
        l = b.getLigaC();
      }
      p = p.getLiga();
      o = p.getLigaF();
      
      b = B.nc.getLiga();
      l = b.getLigaC();
    }
    this.nc = aux.nc;
    return 0;
  }
  
  public MatrizEnListaLigadaForma1 transpuesta()
  {
    int ca = this.nc.getT().getF();
    int fa = this.nc.getT().getC();
    MatrizEnListaLigadaForma1 a = new MatrizEnListaLigadaForma1(fa, ca);
    NodoCabeza p = this.nc.getLiga();
    Nodo b = p.getLigaF();
    while (p != this.nc)
    {
      while (b != p)
      {
        double v = b.getT().getV();
        
        int c = b.getT().getF();
        int f = b.getT().getC();
        Tripleta t = new Tripleta(f, c, v);
        a.insertar(t);
        b = b.getLigaF();
      }
      p = p.getLiga();
      b = p.getLigaF();
    }
    return a;
  }
  
  public double determinante(MatrizEnListaLigadaForma1 a)
  {
    double det = 0.0D;
    if (a.nc.getT().getF() == 2)
    {
      double p11 = enPosicion(a, 1, 1).getV();
      double p12 = enPosicion(a, 1, 2).getV();
      double p22 = enPosicion(a, 2, 2).getV();
      double p21 = enPosicion(a, 2, 1).getV();
      
      det = p11 * p22 - p21 * p12;
      return det;
    }
    double suma = 0.0D;
    for (int i = 1; i <= a.nc.getT().getC(); i++)
    {
      MatrizEnListaLigadaForma1 nm = new MatrizEnListaLigadaForma1(a.nc.getT().getC() - 1, a.nc.getT().getC() - 1);
      for (int j = 1; j <= a.nc.getT().getC(); j++) {
        if (j != i) {
          for (int k = 2; k <= a.nc.getT().getC(); k++)
          {
            int indice = -1;
            if (j < i) {
              indice = j;
            } else if (j > i) {
              indice = j - 1;
            }
            nm.insertar(new Tripleta(indice, k - 1, a.enPosicion(a, j, k).getV()));
          }
        }
      }
      if (i % 2 == 0) {
        suma += a.enPosicion(a, i, 1).getV() * determinante(nm);
      } else {
        suma -= a.enPosicion(a, i, 1).getV() * determinante(nm);
      }
    }
    return suma * -1.0D;
  }
  
  public Tripleta enPosicion(MatrizEnListaLigadaForma1 a, int f, int c)
  {
    NodoCabeza p = a.nc;
    p = p.getLiga();
    Nodo b = p.getLigaF();
    while (p != a.nc)
    {
      while (b != p)
      {
        if ((b.getT().getF() == f) && (b.getT().getC() == c)) {
          return b.getT();
        }
        b = b.getLigaF();
      }
      p = p.getLiga();
      b = p.getLigaF();
    }
    return new Tripleta(0, 0, 0.0D);
  }
  
  public MatrizEnListaLigadaForma1 inversa(MatrizEnListaLigadaForma1 a, int f)
  {
    MatrizEnListaLigadaForma1 b = new MatrizEnListaLigadaForma1(2, 2);
    MatrizEnListaLigadaForma1 c = new MatrizEnListaLigadaForma1(2, 2);
    try
    {
      b = new MatrizEnListaLigadaForma1(f, f);
      c = new MatrizEnListaLigadaForma1(f, f);
      for (int i = 1; i <= f; i++) {
        b.insertar(new Tripleta(i, i, 1.0D));
      }
      for (int k = 1; k <= f - 1; k++) {
        for (int i = k + 1; i <= f; i++)
        {
          for (int s = 1; s <= f; s++) {
            b.insertar(new Tripleta(i, s, b.enPosicion(b, i, s).getV() - a.enPosicion(a, i, k).getV() * b.enPosicion(b, k, s).getV() / a.enPosicion(a, k, k).getV()));
          }
          for (int j = k + 1; j <= f; j++) {
            a.insertar(new Tripleta(i, j, a.enPosicion(a, i, j).getV() - a.enPosicion(a, i, k).getV() * a.enPosicion(a, k, j).getV() / a.enPosicion(a, k, k).getV()));
          }
        }
      }
      for (int s = 1; s <= f; s++)
      {
        c.insertar(new Tripleta(f - 1, s, b.enPosicion(b, f - 1, s).getV() / a.enPosicion(a, f - 1, f - 1).getV()));
        for (int i = f - 1; i > 0; i--)
        {
          c.insertar(new Tripleta(i, s, b.enPosicion(b, i, s).getV() / a.enPosicion(a, i, i).getV()));
          for (int k = f - 1; k > i; k--) {
            c.insertar(new Tripleta(i, s, c.enPosicion(c, i, s).getV() - a.enPosicion(a, i, k).getV() * c.enPosicion(c, k, s).getV() / a.enPosicion(a, i, i).getV()));
          }
        }
      }
    }
    catch (NegativeArraySizeException e)
    {
      JOptionPane.showMessageDialog(null,"\tERROR: TAMAÑO DE LA MATRIZ NEGATIVO");
    }
    return c;
  }
}