# Adventure Game By: Nicholas Carsello, Kurt Diall, and Ethan Mohan
The final project group consists of Nicholas Carsello, Kurt Diall, and Ethan Mohan. The email of Nicholas Carsello is ncarsello@luc.edu. Outside class, we will make meetings Wednesday and Thursday nights weekly and through Google Docs and Slack as well.

In our adventure game, our user will come across obstacles while embarking on a journey. They will make choices and the end result will be decided on what they choose. Some of these obstacles will be choosing where to go, what to eat, what to do when encountering another person, et cetera. The user will come across some items along the way and store them, including food, weapons, and gifts possibly.

This game will be in Java. It will involve a queue list in regards to collecting the items. It will also involve linked lists, since there will be more than one possibility for the outcome.

Possible milestones would be working on completing individual scenarios, hopefully in two weeks time. Another milestone would be linking individual files together.
￼
The game will go something alone the lines of this.
 Photo from: http://vignette4.wikia.nocookie.net/mud/images/3/35/ADVENT_--_Will_Crowther%27s_original_version.png/revision/latest?cb=20090112223957

# Check Point
I am working with Ethan Mohan, and Nicholas Carsello. This is our check in as a group.

So at present, we are having some unforseen difficulties with both gradle and building in general. At time of writing the projects core code (handling user input, text parsing, and sending an appropriate response to the player) has been designed and written, but is non functional. We are having problems both with setting up junit testing, and with generally building the program. For example we currently cannot configure gradle to recognize our main function as it's main function, despite having cross-referenced both gradle's documentation, previous labs, and even searching for fixes from sources such as stack exchange.

To be frank, as these sorts of issues have not come up in previous projects we've done in similar environments, we didn't figure them into our timeline. As a result, the largest obstacle to this project's development is time. I have confidence that we will be able to deliver this project on time, but to do so might involve a degree of 'crunching' or the need to cut 'quality of life features'. In addition, having to work around more unexpected issues in future is now even worse for development. We are working against the clock, with all of the constraints that can put on development.

On a more positive note, we have managed to plot out and design this project well enough that I have confidence in what we're building. Though as we began development, we realized our initial milestones weren't accurate to the way development is going to have to go. It made more sense to construct the general framework for handling user input and the way the game responds to that input before building specific situations.

To that end, I can report the core behavior of an adventure game is present. We can handle player action, check it against developer written responses, and then use those responses to communicate the result of the player's actions. Though it remains untested at the moment, we are confident in it's basic functionality, and it's ability to support the game we're building.


CONT: I am working with Kurt Dail and Nick Carsello on an adventure game.

Nick and I started to come up with ideas about how to make the game before Kurt joined our team, soon after he joined, he offered a more efficient, fun, and simple way to build the adventure game. We, as a group, decided to go with his method. 

File structure, architecture, organization of classes 90%: We have the skeleton of our project laid out pretty well. There has been no major trouble in this portion of the lab. There are still things to sort out, but nothing that will hold up back from submitting. 

Use of Data Structures 95%: We have implemented about 4 different data structures talked about in class, they all serve meaningful purpose in the lab. There has been no major trouble in their implementation, and a test suite has been set up so this can be verified, however, testing is not complete. As a milestone, I would place the testing at 50% complete. 

Documentation 100%: All code has documentation so that collaborators have an easier time understanding, intimately, what is going on. Also, whenever some major change has been made, there are comments documenting the changes so that no group member is left in the dark. 

Game Functionality, responses to change to roomstate 45%: We have the structure built and are confident that it will support our game but due to issues we have been having with gradle, time spent on this has been minimal. This week, once build problems are solved, work on this will be priority. 

As mentioned in my partners posts, there has been major issues with finding the root project and recognizing the main class. The project would build at one point, after changing the main class in the build.gradle file and running ./gradlew clean and deleting .class files. However, after going back and attempting to run again, build issues persisted. I do not expect this to delay final submission of the project. But, it has been difficult, because these issues were not planned for, based on them not appearing in labs. As that may be, everything can not always be expected to work, in the future time for "unforeseen issues" will always be present in an initial timeline.  These issues will be rectified by using resources like slack exchange and perusing the gradle documentation. If we cannot solve the issue this way, I plan to start from scratch(on the gradle + cloud nine side), by creating a new workspace, possibly. 
