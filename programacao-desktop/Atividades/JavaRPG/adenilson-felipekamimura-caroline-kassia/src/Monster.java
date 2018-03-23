public class Monster extends Creature {

    public Monster(String name, String race, int level, int life, int magic,
            int strenght, int agility, int skill, int intelligence, int charisma) {
        super(name, race, level, life, magic, strenght, agility, skill, intelligence, charisma);
    }
   

    @Override
    public float rest() {
        return ((this.getLife() + this.getLevel()) / 2) * this.generateConstRand();
    }
}
