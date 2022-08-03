import java.util.ArrayList;
/**
 * Represents a Dungeons and Dragons character
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class DnDCharacter
{
    private String name;
    private String dClass;
    private String race;
    private int level;
    private int health;
    private int maxHealth;
    private int hitDice;
    private int maxHitDice;
    private boolean spellcaster;
    private boolean isUnconscious;
    private int numberOfTurns;
    private int deathSuccesses;
    private int deathFails;
    private ArrayList<DnDWeapon> weapons;
    
    public DnDCharacter(String name, String dClass, String race, int level, int maxHealth, boolean spellcaster, int numberOfTurns, ArrayList<DnDWeapon> weapons)
    {
        this.name = name;
        this.dClass = dClass;
        this.race = race;
        this.level = level;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxHitDice= level;
        this.hitDice = maxHitDice;
        this.spellcaster = spellcaster;
        this.isUnconscious = false;
        this.numberOfTurns = numberOfTurns;
        this.deathSuccesses = 0;
        this.deathFails = 0;
        this.weapons = weapons;
    }
    
    public DnDCharacter()
    {
        name = "Sample";
        dClass = "Barbarian";
        race = "Dwarf";
        level = 3;
        maxHealth = 24;
        health = maxHealth;
        maxHitDice = level;
        hitDice = maxHitDice;
        spellcaster = false;
        isUnconscious = false;
        numberOfTurns = 1;
        deathSuccesses = 0;
        deathFails = 0;
        weapons = new ArrayList<DnDWeapon>();
        DnDWeapon sampleWeapon = new DnDWeapon();
        weapons.add(sampleWeapon);
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDClass()
    {
        return dClass;
    }
    
    public String getRace()
    {
        return race;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
    
    public int getHitDice()
    {
        return hitDice;
    }
    
    public int getMaxHitDice()
    {
        return maxHitDice;
    }
    
    public boolean isSpellcaster()
    {
        return spellcaster;
    }
    
    public ArrayList<DnDWeapon> getWeapons()
    {
        return weapons;
    }
    
    public void levelUp(int newMaxHealth)
    {
        level++;
        maxHealth = newMaxHealth;
        maxHitDice = level;
    }
    
    public void damage(int amount)
    {
        health -= amount;
        if (health <= 0)
        {
            isUnconscious = true;
        }
    }
    
    public void heal(int amount)
    {
        health += amount;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
    }
    
    public void longRest()
    {
        health = maxHealth;
        hitDice += ((maxHitDice + 1) / 2);
        if (hitDice > maxHitDice)
        {
            hitDice = maxHitDice;
        }
        isUnconscious = false;
        deathSuccesses = 0;
        deathFails = 0;
    }
    
    public void deathSave(boolean success)
    {
        if (success)
        {
            deathSuccesses++;
        }
        else
        {
            deathFails++;
        }
    }
    
    public String toString()
    {
        String result = name + "\n";
        result += race + " " + dClass + "\n";
        result += "Health: ";
        if (health  >= 0)
        {
            result += health + "/" + maxHealth + "\n";
        }
        else
        {
            result += "0/" + maxHealth + "\n";
        }
        
        if (!isUnconscious && (health < ((maxHealth + 1) / 2)))
        {
            result += "Bleeding!";
        }
        else if (deathFails == 3 || health == (-1 * maxHealth))
        {
            result += "Dead!";
        }
        else if (isUnconscious)
        {
            result += "Unconscious! Successes: " + deathSuccesses + " Fails: " + deathFails;
        }
        return result;
    }
}
