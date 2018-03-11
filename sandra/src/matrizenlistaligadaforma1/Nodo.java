package matrizenlistaligadaforma1;

import matriz.Tripleta;

public class Nodo
{
  Tripleta t;
  Nodo ligaF;
  Nodo ligaC;
  
  public Nodo(Tripleta t)
  {
    this.t = t;
  }
  
  public Nodo getLigaC()
  {
    return this.ligaC;
  }
  
  public Tripleta getT()
  {
    return this.t;
  }
  
  public Nodo getLigaF()
  {
    return this.ligaF;
  }
  
  public void setLigaC(Nodo ligaC)
  {
    this.ligaC = ligaC;
  }
  
  public void setLigaF(Nodo ligaF)
  {
    this.ligaF = ligaF;
  }
}