package polinomiosf2;

import java.io.PrintStream;
import javax.swing.JOptionPane;

public class PolinomiosF2
{
  private Object[] V;
  
  PolinomiosF2(int n)
  {
    this.V = new Object[n + 1];
    this.V[0] = 0;
    for (int i = 1; i <= n; i++) {
      this.V[i] = null;
    }
  }
  
  int numeroDeTerminos()
  {
    return ((Integer)this.V[0]);
  }
  
  Termino terminoEnPosicion(int i)
  {
    return (Termino)this.V[i];
  }
  
  void asignaTermino(Termino t, int i)
  {
    if (this.V[i] == null)
    {
      this.V[i] = t;
      this.V[0] = ((Integer)this.V[0]) + 1;
    }
    else
    {
      this.V[i] = t;
    }
  }
  
  void aumentaVector()
  {
    Object[] aux = new Object[this.V.length + 1];
    aux[0] = this.V[0];
    for (int x = 1; x <= this.V.length - 1; x++) {
      aux[x] = this.V[x];
    }
    this.V = aux;
  }
  
  void mostrar()
  {
    int t = numeroDeTerminos();
    for (int i = 1; i <= t; i++)
    {
      Termino y = (Termino)this.V[i];
      JOptionPane.showMessageDialog(null,+ y.retornaCoeficiente() + "X^" + y.retornaExponente(), "el polinomio es:", JOptionPane.PLAIN_MESSAGE);
      if (i != t) {
        JOptionPane.showMessageDialog(null," + ");
      }
    }
    JOptionPane.showMessageDialog(null,"");
  }
  
  void insertaTermino(Termino t)
  {
    int j = ((Integer)this.V[0]);
    for (int x = 1; x <= j; x++)
    {
      Termino aux = (Termino)this.V[x];
      if (aux.retornaExponente() == t.retornaExponente())
      {
        if (aux.retornaCoeficiente() + t.retornaCoeficiente() != 0)
        {
          Termino aux1 = new Termino(0, 0);
          aux1.asignaCoeficiente(aux.retornaCoeficiente() + t.retornaCoeficiente());
          aux1.asignaExponente(t.retornaExponente());
          this.V[x] = aux1;
          return;
        }
        this.V[x] = null;
        for (int p = x; p <= ((Integer)this.V[0]); p++) {
          this.V[p] = this.V[(p + 1)];
        }
        this.V[0] = ((Integer)this.V[0]) - 1;
        return;
      }
    }
    aumentaVector();
    j = ((Integer)this.V[0]);
    for (int x = 1; x <= j; x++)
    {
      Termino aux = (Termino)this.V[x];
      if (t.retornaExponente() > aux.retornaExponente())
      {
        for (int i = ((Integer)this.V[0]) + 1; i > 2; i--) {
          this.V[i] = this.V[(i - 1)];
        }
        this.V[x] = t;
        this.V[0] = ((Integer)this.V[0]) + 1;
        return;
      }
    }
    this.V[0] = ((Integer)this.V[0]) + 1;
    this.V[((Integer)this.V[0])] = t;
  }
  
  void asignaNumeroTerminos(int t)
  {
    this.V[0] = t;
  }
  
  int grado()
  {
    Termino as = (Termino)this.V[1];
    return as.retornaExponente();
  }
  
  PolinomiosF2 suma(PolinomiosF2 b)
  {
    int m = numeroDeTerminos();
    int n = b.numeroDeTerminos();
    PolinomiosF2 c = new PolinomiosF2(m + n);
    int i = 1;
    int j = 1;
    int k = 0;
    while ((i <= m) && (j <= n))
    {
      Termino ti = terminoEnPosicion(i);
      Termino tj = b.terminoEnPosicion(j);
      int ei = ti.retornaExponente();
      int ej = tj.retornaExponente();
      k += 1;
      switch (Integer.compare(ei, ej))
      {
      case 1: 
        c.asignaTermino(ti, k);
        i += 1;
        break;
      case -1: 
        c.asignaTermino(tj, k);
        j += 1;
        break;
      case 0: 
        int ci = ti.retornaCoeficiente();
        int cj = tj.retornaCoeficiente();
        int ck = ci + cj;
        if (ck != 0)
        {
          Termino tk = new Termino(ck, ei);
          c.asignaTermino(tk, k);
        }
        else
        {
          k -= 1;
        }
        i += 1;
        j += 1;
      }
    }
    while (i <= m)
    {
      Termino ti = terminoEnPosicion(i);
      k += 1;
      c.asignaTermino(ti, k);
      i += 1;
    }
    while (j <= n)
    {
      Termino tj = b.terminoEnPosicion(j);
      k += 1;
      c.asignaTermino(tj, k);
      j += 1;
    }
    c.asignaNumeroTerminos(k);
    return c;
  }
  
  PolinomiosF2 smult(Termino t)
  {
    PolinomiosF2 c = new PolinomiosF2(numeroDeTerminos());
    for (int i = 1; i <= numeroDeTerminos(); i++)
    {
      Termino ti = terminoEnPosicion(i);
      int ci = ti.retornaCoeficiente();
      int ei = ti.retornaExponente();
      ti.asignaCoeficiente(t.retornaCoeficiente() * ci);
      ti.asignaExponente(t.retornaExponente() + ei);
      c.asignaTermino(ti, i);
    }
    c.asignaNumeroTerminos(numeroDeTerminos());
    return c;
  }
  
  PolinomiosF2 multiplica(PolinomiosF2 b)
  {
    PolinomiosF2 c = new PolinomiosF2(0);
    for (int i = 1; i <= numeroDeTerminos(); i++) {
      for (int x = 1; x <= b.numeroDeTerminos(); x++)
      {
        Termino ti = new Termino();
        int expA = b.terminoEnPosicion(x).retornaExponente();
        int expB = terminoEnPosicion(i).retornaExponente();
        int expC = expA + expB;
        int coeC = b.terminoEnPosicion(x).retornaCoeficiente() * terminoEnPosicion(i).retornaCoeficiente();
        ti.asignaCoeficiente(coeC);
        ti.asignaExponente(expC);
        c.insertaTermino(ti);
      }
    }
    return c;
  }
  
  PolinomiosF2 deriva()
  {
    PolinomiosF2 c = new PolinomiosF2(0);
    for (int i = 1; i <= numeroDeTerminos(); i++)
    {
      Termino ti = terminoEnPosicion(i);
      if (ti.retornaExponente() != 0)
      {
        int ex = ti.retornaExponente();
        int coe = ti.retornaCoeficiente();
        Termino t = new Termino();
        t.asignaCoeficiente(coe * ex);
        t.asignaExponente(ex - 1);
        c.insertaTermino(t);
      }
    }
    return c;
  }
}