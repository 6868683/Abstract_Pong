import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Abstract_Pong extends PApplet {

Ball pongBall;
Rectangles paddle1;
Rectangles paddle2;
Text scoreone;
Text scoretwo;
int score1 = 0, score2 = 0;
boolean pause = false, fullscreen = false;
ArrayList<Shape> Main = new ArrayList<Shape>();
public void setup() {
  
  surface.setResizable(true);
  pongBall = new Ball(width/2, height/2, color(255, 255, 255), PApplet.parseInt(width*1/40));
  paddle1  = new Rectangles(width/50, height/10, width/50, height/5, color(255, 255, 255), height, DOWN, UP);
  paddle2  = new Rectangles(width*48/50, height/10, width/50, height/5, color(255, 255, 255), height, LEFT, RIGHT);
  Main.clear();

  Main.add(pongBall);
  Main.add(paddle1);
  Main.add(paddle2);
}

public void draw() {
  CirEvents();
    Playing();
    time.updateTime();
    print(" ", score1, " ", score2, " ");
    for ( Shape s : Main) {
      s.draw();
    }
    print(Main);
  
}
final class Ball extends Circle {
  Ball(float x, float y, int colour, float diameter) {
    super(x, y, colour, diameter);
    this.ySpeed = height;
  }
  public void draw() {
    super.draw();
    move();
    bounce();
  }
}
class Circle extends Shape {
  Circle(float x, float y, int colour, float diameter) {
    super(x, y, 0, 0, colour, 0, 0, 0, diameter);
    this.xSpeed = (PApplet.parseInt(random(-2, 2))*500);
  }//endconstructor
  public void draw() {
    stroke(colour);
    fill(colour);
    ellipse(x, y, diameter, diameter);
  }
  public void move() {

    x += xSpeed*time.deltaTime;
    y += ySpeed*time.deltaTime;
    if (xSpeed == 0) {
      xSpeed = (PApplet.parseInt(random(-2, 2))*500);
    }
    if (ySpeed < 0.5f && ySpeed>-0.5f) {
      ySpeed = height;
    }
  }//endmove
  public void bounce() {
    if ((y+(diameter/2) > height) || (y-(diameter/2) < 0) ) {
      ySpeed = ySpeed * -1;
    }  
    if (pause == false) {
      if (pongBall.x-(PApplet.parseInt(width*1/40)/2) <= 0.3f) {
        score1 = score1+1;
      }
      if (pongBall.x+(PApplet.parseInt(width*1/40)/2) >= (width-0.3f)) {
        score2 = score2+1;
      }
      if ((pongBall.x-(pongBall.diameter/2)) <= (paddle1.x+paddle1.WIDTH)) {
        if ((pongBall.y-(pongBall.diameter/2)) >= paddle1.y) {
          if ((pongBall.y+(pongBall.diameter/2)) <= paddle1.y+paddle1.HEIGHT) {
            pongBall.xSpeed = pongBall.xSpeed*-1.01f;
            pongBall.ySpeed = pongBall.ySpeed*(-(paddle1.speedinc/5)+0.1f);
          }
        }
      }
      if ((pongBall.x+(pongBall.diameter/2)) >= (paddle2.x))
        if ((pongBall.y-(pongBall.diameter/2)) >= paddle2.y) {
          if ((pongBall.y+(pongBall.diameter/2)) <= paddle2.y+paddle2.HEIGHT) {
            pongBall.xSpeed = pongBall.xSpeed*-1.01f;
            pongBall.ySpeed = pongBall.ySpeed*((paddle1.speedinc/5)+0.1f);
          }
        }
    }
    if ((x+(diameter/2) >= width) ||  (x-(diameter/2) <= 0) ) {
      x = width/2;
      y = height/2;
      xSpeed = (PApplet.parseInt(random(-2, 2))*500);
    }
  }
}
public void CirEvents() {
  if (height>width) {

    setup();
    surface.setLocation(0, 0);
    frame.setSize(displayWidth, displayWidth/2);
  }
  if (keyPressed) {
    if (key == 'P' || key == 'p') {
        time.gameSpeedScale = PApplet.parseInt(!PApplet.parseBoolean(PApplet.parseInt(time.gameSpeedScale)));
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
public void Playing() {
  background(0);
  
  scoreone = new Text(height/10, width/4, height/10, " ", score2, color(255, 255, 255));
  scoretwo = new Text(height/10, width*3/4, height/10, " ", score1, color(255, 255, 255));
 


  scoreone.Textdrawnum();
  scoretwo.Textdrawnum();
}
 class Rectangles extends Shape {
  Rectangles(float x, float y, float WIDTH, float HEIGHT, int colour, float speed, int up, int down ) {
    super(x, y, WIDTH, HEIGHT,  colour,  speed,  up,  down, 0 );
  }

  public void draw() {
    stroke(colour);
    fill(colour);
    rect(x, y, WIDTH, HEIGHT);
    move();
    bounce();
  }
  public void move() {
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

  public void bounce() {
  }
}
class Text extends Shape{
  Text(int HEIGHT, float x, float y, String input, int input2, int colour ) {
    super(x, y, 0, HEIGHT, colour, 0,0,0,0);  
    this.input = input;
    this.input2 = input2;
  }
  public void Textdrawst() {
    textSize(HEIGHT);
    text(input, x, y, CENTER);
  }
  public void draw(){}

  public void Textdrawnum() {
    textSize(HEIGHT);
    text(input2, x, y, CENTER);
  }
}
Time time = new Time();

class Time {
  float deltaTime = 1;
  float deltaPrevious = 0;
  float gameSpeedScale = 1;
  
  public void updateTime() { //updates the time it took the cpu to calculate the most recent frame
    float m = millis();
    deltaTime = (m - deltaPrevious)/1000;
    deltaPrevious = m;
    deltaTime = deltaTime*gameSpeedScale;
  }
}
InputManager input = new InputManager();

public void keyPressed() {input.keys[keyCode] = true;}
public void keyReleased() {input.keys[keyCode] = false;}

class InputManager {
    boolean mouseClicked = false;
    boolean previous = false;
    boolean[] keys = new boolean[256];
    
    public boolean updateMouse() {//ensures that the mouse only stays clicked for 1 frame
      if (mousePressed) {
        this.mouseClicked = !this.previous;
        this.previous = true;
      } else {
        this.mouseClicked = false;
        this.previous = false;
      }
      return mouseClicked;
    }
    
}
abstract class Shape {
  int  input2, up, down, speedinc, incind;
  String input;
  float x, y, WIDTH, HEIGHT, speed, xSpeed, ySpeed, diameter;
  int colour;
  Shape(float x, float y, float WIDTH, float HEIGHT, int colour, float speed, int up, int down, float diameter){
    
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
  public abstract void draw();
}
  public void settings() {  size(1000, 500); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Abstract_Pong" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
