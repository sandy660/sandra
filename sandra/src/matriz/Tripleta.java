/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz;

public class Tripleta
{
  int f;
  int c;
  double v;
  
  public Tripleta(int f, int c, double v)
  {
    this.f = f;
    this.c = c;
    this.v = v;
  }
  
  public int getC()
  {
    return this.c;
  }
  
  public int getF()
  {
    return this.f;
  }
  
  public double getV()
  {
    return this.v;
  }
  
  public void setF(int f)
  {
    this.f = f;
  }
  
  public void setC(int c)
  {
    this.c = c;
  }
  
  public void setV(int v)
  {
    this.v = v;
  }
}