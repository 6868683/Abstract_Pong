class Text extends Shape{
  Text(int HEIGHT, float x, float y, String input, int input2, color colour ) {
    super(x, y, 0, HEIGHT, colour, 0,0,0,0);  
    this.input = input;
    this.input2 = input2;
  }
  void Textdrawst() {
    textSize(HEIGHT);
    text(input, x, y, CENTER);
  }
  void draw(){}

  void Textdrawnum() {
    textSize(HEIGHT);
    text(input2, x, y, CENTER);
  }
}
