package rpgCombate;

import java.util.Random;

public class EspadaLonga implements Arma {
    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int danoBase = 15;
        alvo.receberDano(danoBase);

        // Efeito Especial: 30% de chance de sangramento
        if (new Random().nextDouble() <= 0.30) {
            System.out.println("Corte Profundo! O alvo está sangrando.");
            alvo.aplicarStatus(new StatusEffect("Sangramento", 3, 5));
        }
    }
    @Override
    public String getNome() { return "Espada Longa"; }
}