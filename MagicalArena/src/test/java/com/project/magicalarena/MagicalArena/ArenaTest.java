package com.project.magicalarena.MagicalArena;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ArenaTest {
    @Test
    public void testBattleOutcome() {
        Player player1 = new Player(50, 5, 10);
        Player player2 = new Player(100, 10, 5);
        Arena arena = new Arena(player1, player2);
        arena.startBattle();

        assertTrue(player1.isAlive() || player2.isAlive());
        assertFalse(player1.isAlive() && player2.isAlive());
    }
}
