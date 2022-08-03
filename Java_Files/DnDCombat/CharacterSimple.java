
/**
 * A simpler version of characters (just name and health)
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class CharacterSimple
{
    private String name;
    private int maxHealth;
    private int health;
    private int initiative;
    private boolean isDead;
    private boolean isUnconscious;
    private boolean isEnemy;
    
    public CharacterSimple(String name, int maxHealth, int health, boolean isEnemy)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.initiative = 0;
        this.isDead = false;
        this.isUnconscious = false;
        if (health == 0)
        {
            this.isUnconscious = true;
        }
        this.isEnemy = isEnemy;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getInitiative()
    {
        return initiative;
    }
    
    public boolean isEnemy()
    {
        return isEnemy;
    }
    
    public boolean isDead()
    {
        return isDead;
    }
    
    public boolean isUnconscious()
    {
        return isUnconscious;
    }
    
    public void heal(int amount)
    {
        if (health < 0)
        {
            health = 0;
            isUnconscious = false;
        }
        health += amount;
        if (health > maxHealth)
        {
            health = maxHealth;
        }
    }
    
    /**
     * Returns:
     * 0 - character is alive
     * 1 - character is unconscious
     * 2 - character is dead
     */
    public int damage(int amount)
    {
        health -= amount;
        if (health <= (-1 * maxHealth) || (health <= 0 && isEnemy))
        {
            isDead = true;
            isUnconscious = true;
            return 2;
        }
        if (health <= 0)
        {
            isUnconscious = true;
            return 1;
        }
        return 0;
    }
    
    public void setInitiative(int initiative)
    {
        this.initiative = initiative;
    }
    
    public String toString()
    {
        return name;
    }
}
