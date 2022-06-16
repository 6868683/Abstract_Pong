void Playing() {
  background(0);
  
  scoreone = new Text(height/10, width/4, height/10, " ", score2, color(255, 255, 255));
  scoretwo = new Text(height/10, width*3/4, height/10, " ", score1, color(255, 255, 255));
 


  scoreone.Textdrawnum();
  scoretwo.Textdrawnum();
}
