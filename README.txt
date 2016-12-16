# TEAM: IRON
# README Instructions
# Bradford Bonanno, Juan Luis Herrero Estrada, Harutyun Sadoyan, Christian Scillitoe, Nicolette Vere.

# Notes

1) Please do not overwrite the file named Level3.txt. The Player needs to use it for testing
2) For best results run the player and the builder in a Windows Machine. Linux/Unix is also acceptable, however in the player the board sometimes flashes because of the way it gets rendered (escapes the scope of this project).
3) Do NOT run either of the programs in a MAC because the rendering of the GUI elements is not too good. For example, in the builder when toggling a tile it changes between very light grey and white so its hard to tell the difference.
4) When running testing, particularly for the builder, we tested saving level and edit level. So the tester is prompted by a file finder to select a file. The file is already chosen, you would just have to click OK or OPEN whenever asked in the testing.
5) When creating a level to be later played in with the Player in the Builder you MUST save under the name "Level#.txt" where # should be a number 1 through 15. For example, if you create a file Level1.txt it will substitute the Level 1 in the Player.
6) In the player the levels go in the order of Puzzle, Lightning, and Theme. So level 4 for example is puzzle and level 15 is Theme. Remember that when saving the level you could overwrite a Puzzle level with say a theme level.
7) In the Builder when making a theme level: Once in the theme creation dialog box you will be prompted for the name of the theme, the words, and the letter order. For the words put 1 word per line. For the letters there should be 36 characters in total. You must use all of the letters of the words from your theme. For the extra letters use the symbol % to signal that a random letter is wished to be placed in that position. For the tiles that are unselected use the character " to signal it.

For example:

mogcat
oonkey
nonkey
kiraff
e"tte"
%%%%%%

# Running the Programs

1. The Player Main is in the package Player inside the Player folder. Run it as a java application.
2. The Builder Main is in the package Builder inside the Builder folder. Run it as a java application.
