# Abstract_Pong
 Feature Log(Finished)
 
 *Algorithm to prevent Ball stagnation; ie, X and Y movements prevent getting stuck at zero.
 
 *Delta time to maintain a constant movement/animation speed.
 
 *Press 'p' to pause and unpause the game while playing.
 
 *Class hierarchy for the circles branch. 
 
 *Vertical movement increment for increasing the ball's up and down movement. 
 
 ______________________________________________________________________________________
 
 Feature Log(In progress)
 
 *Fullscreen function that dynamically resizes screen(text scales while objects do not).
 
 *automatic window resizing if an invalid dimension is reached.
 
 *Class hierarchy for the rectangle branch, should include a final paddle class, as well as a final text class with a double constructor to allow for differention between numbers and text.
 
 *input manager to allow the sketch to read two simultaneous key presses.
 
 *Functioning pause menu with extra options for paddle speed and game difficulty.
  ______________________________________________________________________________________

 Design Choices.
 1. I put all of the variables within the shape class to then be inherited to any of the lower classes, narrowing the available variables that can be called as the classes dropped down, mainly in order to keep the constructors simpler and cleaner.
 2. I pass down functions from the broad classes to the specific classes to keep them organized and easier to find and edit.
 3. I went with a basic monotone aesthetic for simplicity to reflect the game itself.
 4. Shape has a void draw in it so that the array list can call a draw program for the called upon objects without hitting an error.
 5. I used delta time as it calls animations and movements based off the internal computer clock and not just per frame as processing has a tendency to drop frames which causes certain timing reliant features to crash.
 
 
 
