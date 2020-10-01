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
      The GameVariation class follows the **P**, **Polymorphism**, in GRAPH.  Since we have three different types of WAR games, by creating an abstract class, we are able to             extract similar behavior from each WAR game to create a superclass that they can extend.  Using different WAR variations subclasses each with its own playGame(),                 checkWinner(), etc. required by the GameVartation class. <br /><br />

* WarVariationOne.java
      Purpose - Represents the first WAR variation game. Simulates the steps/turns needed for two players to play until one runs out of cards.<br /><br />
      The WarVariationOne class follows the **Open-Closed Principle** as our class extends the GameVariation abstract class.  WarVariationOne adds its own requirements from the       abstract methods of GameVariation but doesn't change the GameVariation class; good use of polymorphism.<br /><br />
      
* WarVariationTwo.java
      Purpose - Represents the second WAR variation game. Simulates the steps/turns needed for two players to play.  Winner is player with the most cards at the end of the game.
      The WarVariationTwo class follows the **Open-Closed Principle** as our class extends the GameVariation abstract class.  WarVariationTwo adds its own requirements from the       abstract methods by adding its own *weird requirements* such as using a points pile in the methods to track player points.  Rather than having the game continue until a         player runs out of cards, such as found in WarVariationOne, WarVariatioTwo adds its own functionality.<br /><br />
      
* WarVariationThree.java
      Purpose - Represents the third WAR variation game.  Simulates the steps/turns needed for three players to play.  Winner is player with the most cards at the end of the           game.  <br /><br />
* GameSimulation.java

