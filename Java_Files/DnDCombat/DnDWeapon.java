
/**
 * Represents a weapon from Dungeons and Dragons
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class DnDWeapon
{
    private String weaponName;
    private String damage;
    boolean isEnchanted;
    
    public DnDWeapon(String weaponName, String damage, boolean isEnchanted)
    {
        this.weaponName = weaponName;
        this.damage = damage;
        this.isEnchanted = isEnchanted;
    }
    
    public DnDWeapon()
    {
        weaponName = "Dagger";
        damage = "1d4";
        isEnchanted = false;
    }
    
    public String getWeaponName()
    {
        return weaponName;
    }
    
    public String getDamage()
    {
        return damage;
    }
    
    public boolean isEnchanted()
    {
        return isEnchanted;
    }
    
    public String toString()
    {
        String result = "";
        if (isEnchanted)
        {
            result += "Enchanted ";
        }
        result += weaponName + " (" + damage + ")";
        return result;
    }
}
