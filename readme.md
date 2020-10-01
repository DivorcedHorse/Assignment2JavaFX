# Assignment 2: WAR - Hao Tran and Daniel Tellez

WAR is a two-player (and three-player) card game where players play in rounds
dealing cards from their personal hand until they run out of cards.  A round is won
with the player who played the highest value card for that round.  If two players
play a card of the same value, a WAR occurs.  Players then play a face down card,
and play another card.  Player with the highest card wins all the cards of that round.

## Classes

* **Card.java**<br /><br />
      Purpose - **Domain model** that represents a single playing card.<br /><br />
      The Card class follows the **Single Responsibility Principle** as it simply represents a single playing card from a deck.  For a single Card, we store it's suit type, the         name of the card, and a rank value.<br /><br />
      
* **Deck.java**<br /><br />
      Purpose - **Domain model** that represents a playing deck that contains cards. <br /><br />
      The Deck class follows the **Single Responsiblity Principle** as it represents a deck of cards.  As expected, a deck can add a card to it, remove the top card, and other           simple functions related to a deck. <br /><br />

* **DeckCreator.java**<br /><br />
      Purpose - Builder class that creates and initializes standard playing deck.<br /><br />
      The DeckCreator class follows the **Pure Fabrication** as it implements the methods of actually creating a deck of cards.  Rather than having the Deck class do the work,           DeckCreator takes responbility allows the Deck class to be cleaner and simpler.  <br /><br />
      
* **Player.java**<br /><br />
      Purpose - **Domain model** that represents a person playing the WAR variations.  Player will keep track of their own hands and points pile.<br /><br />
      
* **Dealer.java**<br /><br />
      Purpose - **Domain model** that represents a dealer.  Responsible for dealing the cards to number of players and shuffling deck.<br /><br />

* **GameVariation.java**<br /><br />
      Purpose - Abstract class defining the necessary methods that each WAR variation must implement in order to play a game of WAR.<br /><br />
      The GameVariation class follows the **P**, **Polymorphism**, in GRAPH.  Since we have three different types of WAR games, by creating an abstract class, we are able to             extract similar behavior from each WAR game to create a superclass that they can extend.  Using different WAR variations subclasses each with its own playGame(),                 checkWinner(), etc. required by the GameVartation class. <br /><br />

* **WarVariationOne.java**<br /><br />
      Purpose - Represents the first WAR variation game. Simulates the steps/turns needed for two players to play until one runs out of cards.<br /><br />
      The WarVariationOne class follows the **Open-Closed Principle** as our class extends the GameVariation abstract class.  WarVariationOne adds its own requirements from the       abstract methods of GameVariation but doesn't change the GameVariation class; good use of polymorphism.<br /><br />
      WarVariationOne also follows the **Liskov Substitution Principle** as it uses every method of the abstract class.  WarVariationOne Is-a GameVariation.<br /><br />
      
      
* **WarVariationTwo.java**<br /><br />
      Purpose - Represents the second WAR variation game. Simulates the steps/turns needed for two players to play.  Winner is player with the most cards at the end of the game.         <br /><br />
      The WarVariationTwo class follows the **Open-Closed Principle** as our class extends the GameVariation abstract class.  WarVariationTwo adds its own requirements from the       abstract methods by adding its own *weird requirements* such as using a points pile in the methods to track player points.  Rather than having the game continue until a         player runs out of cards, such as found in WarVariationOne, WarVariatioTwo adds its own functionality.<br /><br />
      WarVariationTwo also follows the **Liskov Substitution Principle** as it uses every method of the abstract class.  WarVariationTwo Is-a GameVariation.<br /><br />

      
* **WarVariationThree.java**<br /><br />
      Purpose - Represents the third WAR variation game.  Simulates the steps/turns needed for three players to play.  Winner is player with the most cards at the end of the           game.  <br /><br />
      The WarVariationThree class follows the **Open-Closed Principle** and **Protected Variations** as our class extends the GameVariation abstract class.  WarVariationThree         implements its own unique functions without modifying the abstract-superclass.  We add the variations in th subclass to accommodate a variation in behavior that is not           found in the other extensions of GameVariation.<br /><br />
      WarVariationThree also follows the **Liskov Substitution Principle** as it uses every method of the abstract class.  WarVariationThree Is-a GameVariation.<br /><br />

      
* **GameSimulation.java**<br /><br />
      Purpose - Simulates the three WAR variations.  Calls and runs the necessary methods needed to play a WAR game.<br /><br />

* **GameController.java**<br /><br />
      Purpose - The C in MVC.  Accepts input and coverts it to commands for the model or view.  <br /><br />
      The GameController class follows the **Controller** pattern of GRASP.  It is responsible of taking in the user actions of clicking the WAR buttons and notifying the Model       what methods and classes need to be called to display it back to the View.<br /><br />
      
* **Main.java** <br /><br />
      Purpose - Implements the whole WAR simulation.

