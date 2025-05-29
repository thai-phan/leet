package dpattern.creational.c4abstractfactory;

public class UbuntuGraphicsFactory implements GraphicsFactory {
  @Override
  public Graphics newGraphics() {
    return new UbuntuGraphics();
  }
}
