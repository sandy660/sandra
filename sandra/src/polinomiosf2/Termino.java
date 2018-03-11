package polinomiosf2;

public class Termino
{
  private int coeficiente;
  private int exponente;
  
  public Termino() {}
  
  public Termino(int c, int e)
  {
    this.coeficiente = c;
    this.exponente = e;
  }
  
  void asignaCoeficiente(int c)
  {
    this.coeficiente = c;
  }
  
  void asignaExponente(int e)
  {
    this.exponente = e;
  }
  
  int retornaCoeficiente()
  {
    return this.coeficiente;
  }
  
  int retornaExponente()
  {
    return this.exponente;
  }
}