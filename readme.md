# Assignment 2: WAR - Hao Tran and Daniel Tellez

WAR is a two-player (and three-player) card game where players play in rounds
dealing cards from their personal hand until they run out of cards.  A round is won
with the player who played the highest value card for that round.  If two players
play a card of the same value, a WAR occurs.  Players then play a face down card,
and play another card.  Player with the highest card wins all the cards of that round.

## Classes

* Card.java
      Purpose - Domain model that represents a single playing card.
      The Card class follows the **Single Responsibility Principle** as it simply represents a single playing card from a deck.  For a single Card, we store it's suit type, the         name of the card, and a rank value.
* Deck.java
* DeckCreator.java
* Player.java
* Dealer.java
* GameVariation.java
* WarVariationOne.java
* WarVariationTwo.java
* WarVariationThree.java
* GameSimulation.java

