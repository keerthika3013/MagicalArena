package com.project.magicalarena.MagicalArena;



public class Arena {
    private Player player1;
    private Player player2;
    private Dice dice;

    public Arena(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.dice = new Dice();
    }

    public void startBattle() {
        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
            Player defender = (attacker == player1) ? player2 : player1;
            performAttack(attacker, defender);

            // Swap roles for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Battle Over!");
        System.out.println(player1.isAlive() ? "Player 1 Wins!" : "Player 2 Wins!");
    }

    private void performAttack(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defendRoll = dice.roll();

        int attackDamage = attackRoll * attacker.getAttack();
        int defendDamage = defendRoll * defender.getStrength();

        int damageDealt = Math.max(0, attackDamage - defendDamage);
        defender.setHealth(defender.getHealth() - damageDealt);

        System.out.println(String.format("Attacker rolls %d, Defender rolls %d, Damage dealt: %d",
                attackRoll, defendRoll, damageDealt));
    }
}
