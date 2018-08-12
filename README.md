# multi-tic-tac-toe
multi-player/board classic tic-tac-toe game System.out based 

# Usage

type on the shell station the follow command:
    $ java TicTacToe.java --config \[config.properties]
    
if *config properties file* is not provided, the default values will be used.

## default values

playfield square size 3x3
first, second and computer players' characters: O, X and R

# Configuration file content sample

\## determine the playfield size; valid options are: 3, 4, 5, 6, 7, 8, 9 and 10

playfield.size=3 

\## determine players characters; do not repeat the values!

playfield.players.first.char=O
playfield.players.second.char=X
playfield.players.computer.char=R
