# Assignment 2: WAR - Hao Tran and Daniel Tellez

WAR is a two-player (and three-player) card game where players play in rounds
dealing cards from their personal hand until they run out of cards.  A round is won
with the player who played the highest value card for that round.  If two players
play a card of the same value, a WAR occurs.  Players then play a face down card,
and play another card.  Player with the highest card wins all the cards of that round.

## Classes

* Card.java
      Purpose - Domain model that represents a single playing card.<br /><br />
      The Card class follows the **Single Responsibility Principle** as it simply represents a single playing card from a deck.  For a single Card, we store it's suit type, the         name of the card, and a rank value.<br /><br />
      
* Deck.java
      Purose - Domain model that represents a playing deck that contains cards. <br /><br />
      The Deck class follows the **Single Responsiblity Principle** as it represents a deck of cards.  As expected, a deck can add a card to it, remove the top card, and other           simple functions related to a deck. <br /><br />

* DeckCreator.java
* Player.java
* Dealer.java
* GameVariation.java
      Purpose - Abstract class defining the necessary methods that each WAR variation must implement in order to play a game of WAR.<br /><br />
      The GameVariation class follows the **P**, **Polymorphism**, in GRAPH.  Since we have three different types of WAR games, by creating an abstract class, we are able to             extract similar behavior from each WAR game to ...
* WarVariationOne.java
* WarVariationTwo.java
* WarVariationThree.java
* GameSimulation.java

