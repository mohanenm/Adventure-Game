public class playerInput{
    //wrapper for combination of verbs and objects
    String verb;
    String objectA;
    String objectB;
    
    playerInput(String predicate){
        verb = predicate;
    }
    
    setObjectA(String thingA){
        objectA = thingA;
    }
    
    getObjectA(){
        return objectA;
    }
    
    setObjectB(String thingB){
        objectB = thingB;
    }
    
    getObjectB(){
        return objectB;
    }
    
    getVerb(){
        return verb;
    }
    
    @Override
    equals(playerInput other){
        if(other.verb == verb){
            if(other.objectA == objectA){
                if(other.objectB = objectB){
                    return true;
                }
            }
        }
        return false;
    }
}