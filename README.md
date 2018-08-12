# multi-tic-tac-toe
multi-player/board classic tic-tac-toe game System.out based 

# Usage

type on the shell station the follow command:
    $ java TicTacToe.java --config \[config.properties]
    
if *config properties file* is not provided, the default values will be used.

## default values

playfield square size 3x3 <br/>
first, second and computer players' characters: O, X and R

# Configuration file content sample

\## determine the playfield size; valid options are: 3, 4, 5, 6, 7, 8, 9 and 10

playfield.size=3 

\## determine players characters; do not repeat the values!

playfield.players.first.char=O <br/>
playfield.players.second.char=X <br/>
playfield.players.computer.char=R <br/>

# Design

## core
This game has as its core the idea of path slice engine (divide to conquer), which means that, once the play field is created, all the
possible happy paths are mapped, so that the control is agnostic to the board itself, but checking the list of paths instead,
which turn the process pretty simple, dynamic and scalable.

## board
despite limited by convention, the board is ready to receive any quadratic size (not only squares).

## multi-players
despite limited by convention, the game is ready to receive any number of players (either human or robots); it´s also
possible to make two robots play each other!

## AI
There are three levels pre-configured: easy, normal and hard. They are programmatically configured to mix the best 
combination of rules according to its level. It also allows to create a decision chain, if necessary. Currently the
auto-selection implementations are designed to follow the chain strategy only (as-inserted on its knowledge base).

I liked Tic-Tac-Toe when I was a kid, despite I'm not a big fun of table games at all (prefer volley, soccer, paddle...), but honestly, I can´t beat my own robot playing on level HARD (and I'm not saying it´s perfect! Lol).

