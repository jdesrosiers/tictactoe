Tic Tac Toe
===========
This is a console based game of Tic Tac Toe.

Development
-----------
This project uses the [activator](https://www.lightbend.com/activator/download) build tool.  This
project is developed using Test Driven Development (TDD) with the exception of the UI.  The goal is
to have a working product at every step.  I'm using the UI to help determine the next most important
thing to do.  When the UI requires another bit of functionality to advance, I TDD that bit and
incorporate it into the UI.

### Play the Game
To play classic Tic Tac Toe, run `activator "run-main Classic"`
To Paly 4x4 Tic Tac Toe, run `activator "run-main FourByFour"`

By default, X is played by the user and O is played by a minimax agent.  These defaults can be overridden
using command line arguments.

`activator "run-main Classic --X=minimax --O=human"`

You can also specify the depth limit of the minimax agent.

`activator "run-main Classic --O=minimax,2"`

### Tests
The test framework used is [ScalaTest](http://www.scalatest.org/)

Run the tests with `activator test`
To use the automatic test runner while developing, use `activator ~test`

Principle Design Decisions
--------------------------
### Separation of Game State and Behavior
The AI component requires running through many game states.  Therefore, we want those game states to
have a small footprint and be fast to create.  The Board stores the current player and positions each
player has played.  The board should no make any assumptions about the structure of the board.  The
TicTacToe class will define the structure and rules of the game.

### Generic Rules
The TicTacToe game logic does not make assumptions about the structure of the board.  This allows us
to easily construct Tic Toe Toe games with different board configurations than the classic 3x3 board.
A 3x3 and 4x4 board were constructed to demonstrate this ability.

### AI
The AI player uses a depth limited minimax algorithm with alpha beta prunning.  It's common for the
algorithm to give the same score to multiple children nodes.  If there are multiple "best" move
options, the algorithm will randomly choose between the options.  This makes games a little more
interesting especially when you have two AI players playing against each other.
