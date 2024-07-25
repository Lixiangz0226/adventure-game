package TextGame.entities;

import TextGame.Items.Item;
import TextGame.Monsters.Monster;
import TextGame.Skills.Skill;
import TextGame.Weapons.Knife;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {
    /**
    * Unit tests for Player.
    */

    private Player player;
    private Monster mockMonster;
    private Skill mockSkill;

    @BeforeEach
    void setUp() {
        player = new Player("TestPlayer", 100);
        mockMonster = mock(Monster.class);
        mockSkill = mock(Skill.class);
    }

    @Test
    void testPlayerInitialization() {
        assertEquals("TestPlayer", player.getName());
        assertEquals(100, player.getHealth());
        assertNotNull(player.getInventory());
        assertEquals(0, player.getMoney());
        assertEquals(0, player.get_key());
    }

    @Test
    void testHitMonster() {
        when(mockSkill.getName()).thenReturn("Basic_Attack");
        when(mockMonster.hit()).thenReturn(10);
        when(mockMonster.getHealth()).thenReturn(100);

        List<String> result = player.hit(mockMonster, mockSkill);

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(mockMonster, times(1)).hit();
        verify(mockMonster, times(1)).setHealth(anyInt());
    }

    @Test
    void testUseItem() {
        Item mockItem = mock(Knife.class);
        when(mockItem.get_name()).thenReturn("Life Potion");
        player.getInventory().addItem(mockItem);

        boolean result = player.use_item(0);

        assertFalse(result);
        assertEquals(120, player.getHealth()); // Assuming Life Potion adds 20 health
    }

    @Test
    void testAddAndUseWeapon() {
        Knife knife = new Knife();
        player.getInventory().addItem(knife);
        
        boolean equipped = player.use_item(0);
        
        assertTrue(equipped);
        assertEquals(knife, player.getInventory().getItems().get(0));
    }

    @Test
    void testMoneyTransaction() {
        player.setMoney(50);
        assertEquals(50, player.getMoney());

        player.setMoney(player.getMoney() + 100);
        assertEquals(150, player.getMoney());
    }

    @Test
    void testAddKey() {
        player.add_key();
        assertEquals(1, player.get_key());
    }
}
