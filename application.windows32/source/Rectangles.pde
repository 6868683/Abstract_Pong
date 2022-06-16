 class Rectangles extends Shape {
  Rectangles(float x, float y, float WIDTH, float HEIGHT, color colour, float speed, int up, int down ) {
    super(x, y, WIDTH, HEIGHT,  colour,  speed,  up,  down, 0 );
  }

  void draw() {
    stroke(colour);
    fill(colour);
    rect(x, y, WIDTH, HEIGHT);
    move();
    bounce();
  }
  void move() {
    if (keyPressed) {
      if (keyCode == up) {
        if (y+HEIGHT < height) {
          y = y+speed*time.deltaTime;
          speedinc = speedinc*1;
        }
      } else if (keyCode == down) {
        if (y > 0) {
          y = y-speed*time.deltaTime;
          speedinc = speedinc*-1;
        }
      }
    }
    if (speedinc != 0) {
      incind = incind + 1;
    }
    if (incind >= 100) {
      speedinc = 0; 
      incind = 0;
    }
    if (speedinc > 5) {
      speedinc=5;
    }
    if (speedinc < -5) {
      speedinc=-5;
    }
  }

  void bounce() {
  }
}
