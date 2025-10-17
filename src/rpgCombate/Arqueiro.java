package rpgCombate;

import java.util.Random;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 8, 15, 7, 90, 80);
    }

    // Habilidade Passiva: Esquiva
    @Override
    public void receberDano(int dano) {
        if (new Random().nextDouble() <= 0.25) { // 25% de chance de esquivar
            System.out.println(this.nome + " se esquivou do ataque!");
        } else {
            super.receberDano(dano);
        }
    }
}