import java.util.*;

public character {
    String[] validVerbs = new String[15];
    String[] inventory = new String[5];
    String[] temp;
    roomState currentRoomState;
    room currentRoom;
    playerInput currentInput;
    Scanner pInput = new Scanner(System.in);
    public character(String[] verbs, String[] inv, room curRoom){
        validVerbs = verbs;
        inventory = inv;
        currentRoom = room;
        currentState = currentRoom.getStateStack();
    }
    public void parseText(String input){
        /*Go word-by-word, looking for anything that matches either A. an established Verb or B. an Object currently available (in the scene or in the inventory)
         *When it detects the first verb it creates an input object
         *And when it detects the first two objects, it assings them as objectA and objectB respectively
         *Once it either has iteratred through the whole string or filled the object B slot, it sends this input on to the current roomstate using prepOutput()
         */
        temp = input.split("\\s+");
        currentInput = null;
        //check through every word in our input string
        for(String word : temp){
            //Is this specific word a verb we have? If not, keep going
            if(currentInput == null){
                for(String verb : validVerbs){
                    if(input == verb){
                        currentInput = new playerInput(input);
                        break;
                    }
                }
            } else if (currentInput.getObjectA() == null){
            //Is this specific word in the players inventory? If not, keeping going.
                for(String object : inventory){
                    if(input == object){
                        currentInput = new playerInput(input);
                        break;
                   }
                }
                //Is this specific word in the roomStates objects? If not, keep going.
                for(String object : currentState.objectsInScene){
                   if(input == object){
                       currentInput = new playerInput(input);
                       break;
                    }
                }  
            }else if (currentInput.getObjectB){
                //Is this specific word in the players inventory? If not, keeping going.
                for(String object : inventory){
                    if(input == object){
                        currentInput = new playerInput(input);
                        break;
                   }
                }
                //Is this specific word in the roomStates objects? If not, keep going.
                for(String object : currentState.objectsInScene){
                   if(input == object){
                       currentInput = new playerInput(input);
                       break;
                    }
                }
            }
        }
        currentRoomState.prepOutput(currentInput);
    }
}
 