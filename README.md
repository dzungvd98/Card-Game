# Card-Game
Create a deck with 52 cards and play game with rules 
# Deck
Deck has 52 cards and can deal for player
# Player
Player can receive card, hit card
Player has name and list cards
# TheePokerCardGame
All player has start with 3 card player biggest score is win
Three of kind is biggest with 2-A three of kind A (AAA) is max
Second is consecutive cards Like 1 2 3 and QKA is max
Third is three of face cards and all has three of face is draw
End is total score mod 10 and 9 is max equal score is draw
# BlackJackGame
Overview
The BlackJackGame is a simplified card game implemented in Java. It features a deck of 52 cards, players, and the standard rules of Blackjack. The game logic handles shuffling, dealing, and determining winners based on Blackjack rules.

Key Components

  - Deck: A class representing a deck with 52 standard cards (clubs, diamonds, hearts, spades). It includes functionality for shuffling and dealing cards.

  - Player: A class representing a player in the game. Each player has a name, a list of cards (hand), and actions like receiveCard() and hitCard().

  - BlackJackGame: The main class that handles the game flow, including:

      * Starting the game by dealing initial cards.
      * Implementing game logic like "hit" or "stand".
      * Determining winners based on Blackjack rules.

