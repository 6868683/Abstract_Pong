void CirEvents() {
  if (height>width) {

    setup();
    surface.setLocation(0, 0);
    frame.setSize(displayWidth, displayWidth/2);
  }
  if (keyPressed) {
    if (key == 'P' || key == 'p') {
        time.gameSpeedScale = int(!boolean(int(time.gameSpeedScale)));
        delay(300);
    }
  }
  if (keyPressed) {
    if (key == 'f' || key == 'F') {
      if (fullscreen == false) {
        fullscreen = true;
        delay(300);
        setup();
        surface.setLocation(-11, 0);
        frame.setSize(displayWidth, displayWidth/2);
      } else{
        fullscreen= false;
        delay(300);
        frame.setSize(1000, 500);
      }
    }
  }

}
