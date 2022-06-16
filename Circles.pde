class Circle extends Shape {
  Circle(float x, float y, color colour, float diameter) {
    super(x, y, 0, 0, colour, 0, 0, 0, diameter);
    this.xSpeed = (int(random(-2, 2))*500);
  }//endconstructor
  void draw() {
    stroke(colour);
    fill(colour);
    ellipse(x, y, diameter, diameter);
  }
  void move() {

    x += xSpeed*time.deltaTime;
    y += ySpeed*time.deltaTime;
    if (xSpeed == 0) {
      xSpeed = (int(random(-2, 2))*500);
    }
    if (ySpeed < 0.5 && ySpeed>-0.5) {
      ySpeed = height;
    }
  }//endmove
  void bounce() {
    if ((y+(diameter/2) > height) || (y-(diameter/2) < 0) ) {
      ySpeed = ySpeed * -1;
    }  
    if (pause == false) {
      if (pongBall.x-(int(width*1/40)/2) <= 0.3) {
        score1 = score1+1;
      }
      if (pongBall.x+(int(width*1/40)/2) >= (width-0.3)) {
        score2 = score2+1;
      }
      if ((pongBall.x-(pongBall.diameter/2)) <= (paddle1.x+paddle1.WIDTH)) {
        if ((pongBall.y-(pongBall.diameter/2)) >= paddle1.y) {
          if ((pongBall.y+(pongBall.diameter/2)) <= paddle1.y+paddle1.HEIGHT) {
            pongBall.xSpeed = pongBall.xSpeed*-1.01;
            pongBall.ySpeed = pongBall.ySpeed*(-(paddle1.speedinc/5)+0.1);
          }
        }
      }
      if ((pongBall.x+(pongBall.diameter/2)) >= (paddle2.x))
        if ((pongBall.y-(pongBall.diameter/2)) >= paddle2.y) {
          if ((pongBall.y+(pongBall.diameter/2)) <= paddle2.y+paddle2.HEIGHT) {
            pongBall.xSpeed = pongBall.xSpeed*-1.01;
            pongBall.ySpeed = pongBall.ySpeed*((paddle1.speedinc/5)+0.1);
          }
        }
    }
    if ((x+(diameter/2) >= width) ||  (x-(diameter/2) <= 0) ) {
      x = width/2;
      y = height/2;
      xSpeed = (int(random(-2, 2))*500);
    }
  }
}
