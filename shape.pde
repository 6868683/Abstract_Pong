abstract class Shape {
  int  input2, up, down, speedinc, incind;
  String input;
  float x, y, WIDTH, HEIGHT, speed, xSpeed, ySpeed, diameter;
  color colour;
  Shape(float x, float y, float WIDTH, float HEIGHT, color colour, float speed, int up, int down, float diameter){
    
    this.x = x;
    this.y = y;
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.colour = colour;
    this.speed = speed;
    this.up = up;
    this.down = down;
    this.diameter = diameter;
  }
  abstract void draw();
}
