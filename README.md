HELLO!! This is the adventure game designed by Random1

This README will briefly explain the game, how it was coded, as well as some instructions on using the codes to play for yourself

_____________________________________________________________________________________________________________________________________________________________________

---IMPORTANT---How to use/play the game---
1. To use the code, clone this repository to your computer via the URL link.

2. Depending on which game you want to play (visual or text)

   For the Text game: Go to the source folder src, then click on the package "TextGame.entities", finally click on the class "Game" and run the code
   NOTE: You might encounter a bug when running for the first time, simply check the console and locate the error message (In Game class, line 197).
   Then following the auto action and set the "language level to 22".

   For the Visual game: Go to the second source folder src2, then click on the package "main", finally click on the class "Main" and run the code

_____________________________________________________________________________________________________________________________________________________________________

---Description of the game---
This is a retro pixel turn-based RPG where the YOU as the player will traverse through a 2D landscape filled with interactable objects, enemies, and npcs. 
Some basic play features include collecting keys to open up doors, talking to npc with various dialogues and events, fighting with enemies to gain
items, gold, and exp. The goal is to collect all the seven Super Keys and beat the final boss that awaits you in the boss chamber.

_____________________________________________________________________________________________________________________________________________________________________

---Some details regarding the game's code---
In the current development stage of the game, we have decided to split the game into the visual based, and text based games. Both are independently runnable
games on their own, and will be merged together as one in later stages of development. The visual based game gives the player an intuitive view of game functionality
such as map traversing, interacting with objects and npcs. The text game handles all types of events in the game, such as encountering and fighting an enemy, talking 
and shopping with npcs. The decision to split the game into two is for the sake of reducing coding complexity, easier testing, and lesser conflicts with working
in a large group. Our final vision is to have the visual portion of the game be the foundational play style of the game, and the text based portion will come in play
whenever an event is triggered. 




