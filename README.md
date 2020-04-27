# WisemanTalker

This is a word game using JAVA SWING and API to bring you a immersed enviroment.

Class specification:

WisemanModel is an abstract class where initiate the common private field of wiseman like age and status.
Wiseman is a class where it has bi-directional association with its field mottoarray: that is, each motto has one matched wiseman.
Wiseman2 is a class useing save and load functionality to presist and retrieve data from external file.
Mottos and DreamDealer show two way of how to handle arraylist for a big class, decrease the coupling.
Wiseman3 uses weather API to predict the weather worldwide with ReadWebPage class
Exception Hirachy
Additionally, I added observer pattern as Naive Kid class observe Wiseman
