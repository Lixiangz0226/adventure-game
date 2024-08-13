
import OutsideEntities.Player;

import OutsideEntities.Items.Life_Potion;
import OutsideEntities.Weapons.Flame_Crossbow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void use_item() {
        Player p = new Player("Yamato", 50);
        // use life potion once
        p.getInventory().addItem(new Life_Potion());
        p.use_item(0);
        Assertions.assertEquals(p.getHealth(), 70);
        // use life potion twice
        p.getInventory().addItem(new Life_Potion());
        p.use_item(0);
        Assertions.assertEquals(p.getHealth(), 90);
        // check the weapon
        Assertions.assertEquals(p.getWeaponName(), "Knife");
        // equip a weapon
        p.getInventory().addItem(new Flame_Crossbow());
        p.use_item(0);
        Assertions.assertEquals(p.getWeaponName(), "Flame Crossbow");
        // check if the knife is in the backpack
        Assertions.assertEquals(p.getInventory().getItem(0).getName(), "Knife");
    }
}