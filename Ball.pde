final class Ball extends Circle {
  Ball(float x, float y, color colour, float diameter) {
    super(x, y, colour, diameter);
    this.ySpeed = height;
  }
  void draw() {
    super.draw();
    move();
    bounce();
  }
}
