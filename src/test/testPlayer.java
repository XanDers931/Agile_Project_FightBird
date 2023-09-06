package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.*;

import main.Player;

public class testPlayer {  
    Player p1;
    String un;


    @BeforeEach
	public void beforeATest() {
		p1 = new Player();
        un = "yo";
        //p1 = new Player(1,1,1,"yo",1,new Inventory());
	}


    @Test
    public void testEquals() {
        
        assertTrue(un.equals(un));
        
        /*
		assertTrue(p1.getHealth_point() == 100);
        p1.increaseHp(1);
        assertFalse(p1.getHealth_point() == 100);
        assertTrue(p1.getHealth_point() == 105);
        */
        /*
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));
		assertTrue(c1.equals(c4));
        */
	}
}
