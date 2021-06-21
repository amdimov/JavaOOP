package rpg_lab;

import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AxeTest {
    //AXE
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 6;

    //DUMMY
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeObjects(){
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        //this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);
        this.dummy = Mockito.mock(Dummy.class);
    }
    @Test
    public void getAttackPoints() {
        assertEquals(10, AXE_ATTACK);

    }

    @Test
    public void getDurabilityPoints() {
    }

    @Test
    public void attack() {
        this.axe.attack(this.dummy);
        assertEquals(EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }
}