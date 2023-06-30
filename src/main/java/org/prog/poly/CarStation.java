package org.prog.poly;

import org.prog.poly.BMW;
import org.prog.poly.Bolid;
import org.prog.poly.ICarControl;
import org.prog.poly.Tesla;

public class CarStation {
  public void carRace() {
    Tesla tesla = new Tesla();
    BMW bmw = new BMW();
    Bolid bolid = new Bolid();

    race(tesla);
    race(bmw);
    race(bolid);
  }

  private void race(ICarControl car) {
    car.accelerate();
    car.turnRight();
    car.turnLeft();
    car.brake();
  }
}
