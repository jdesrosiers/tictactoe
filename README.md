Tic Tac Toe
===========
This is a console based game of Tic Tac Toe.

Development
-----------
This project uses the [activator](https://www.lightbend.com/activator/download) build tool.

### Play the Game
`activator run`

Principle Design Decisions
--------------------------
### Separation of Game State and Behavior
The AI component requires running through many game states.  Therefore, we want those game states to
have a small footprint and be fast to create.  The Board stores the current player and positions each
player has played.  The board should no make any assumptions about the structure of the board.  The
TicTacToe class will define the structure and rules of the game.
