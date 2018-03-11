package matrizenlistaligadaforma1;

import matriz.Tripleta;

class NodoCabeza
  extends Nodo
{
  NodoCabeza liga;
  
  public NodoCabeza(Tripleta t)
  {
    super(t);
  }
  
  public NodoCabeza getLiga()
  {
    return this.liga;
  }
  
  public void setLiga(NodoCabeza liga)
  {
    this.liga = liga;
  }
}