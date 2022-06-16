Ball pongBall;
Rectangles paddle1;
Rectangles paddle2;
Text scoreone;
Text scoretwo;
int score1 = 0, score2 = 0;
boolean pause = false, fullscreen = false;
ArrayList<Shape> Main = new ArrayList<Shape>();
void setup() {
  size(1000, 500);
  surface.setResizable(true);
  pongBall = new Ball(width/2, height/2, color(255, 255, 255), int(width*1/40));
  paddle1  = new Rectangles(width/50, height/10, width/50, height/5, color(255, 255, 255), height, DOWN, UP);
  paddle2  = new Rectangles(width*48/50, height/10, width/50, height/5, color(255, 255, 255), height, LEFT, RIGHT);
  Main.clear();

  Main.add(pongBall);
  Main.add(paddle1);
  Main.add(paddle2);
}

void draw() {
  CirEvents();
    Playing();
    time.updateTime();
    print(" ", score1, " ", score2, " ");
    for ( Shape s : Main) {
      s.draw();
    }
    print(Main);
  
}
