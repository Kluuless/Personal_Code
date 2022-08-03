
/**
 * Compares weights and hungriness of all ownable animals
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public interface Ownable
{
    ///// ALL OWNABLE ANIMALS CAN: /////

    /** ~~~~~~~~~~ ACCESSOR METHODS ~~~~~~~~~~ */
    ///// HAVE AN OWNER /////
    Human getOwner();

    ///// BE HUNGRY /////
    boolean isHungry();

    ///// NOT BE FED /////
    int daysSinceFed();

    /** ~~~~~~~~~~ MUTATOR METHODS ~~~~~~~~~~ */
    ///// BE FED /////
    void feed();

    ///// CHANGE OWNERS /////
    void setOwner(Human theOwner);
    
    ///// GET OLDER FROM DAY TO DAY /////
    void nextDay();
}
