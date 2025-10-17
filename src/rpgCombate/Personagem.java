package rpgCombate;

import java.util.ArrayList;
import java.util.List;

// A classe de Contexto que usa uma Strategy (Arma).
public abstract class Personagem {
    protected String nome;
    protected int forca, destreza, inteligencia;
    protected int vida, vidaMaxima;
    protected int mana, manaMaxima;
    protected Arma armaEquipada;
    protected List<StatusEffect> statusEffects = new ArrayList<>();

    public Personagem(String nome, int forca, int destreza, int inteligencia, int vida, int mana) {
        this.nome = nome;
        this.forca = forca;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.mana = mana;
        this.manaMaxima = mana;
    }

    // Delega a ação para a estratégia (arma) equipada.
    public void atacar(Personagem alvo) {
        if (armaEquipada != null) {
            System.out.println(this.nome + " ataca " + alvo.getNome() + " com " + armaEquipada.getNome() + "!");
            armaEquipada.usar(this, alvo);
        } else {
            System.out.println(this.nome + " está desarmado e não pode atacar!");
        }
    }

    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
        System.out.println(this.nome + " equipou " + arma.getNome() + ".");
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. Vida restante: " + this.vida);
    }

    public void aplicarStatus(StatusEffect efeito) {
        this.statusEffects.add(efeito);
    }
    
    public void processarStatus() {
        // Itera sobre uma cópia para evitar ConcurrentModificationException
        new ArrayList<>(statusEffects).forEach(effect -> {
            if (!effect.aplicar(this)) {
                statusEffects.remove(effect);
                System.out.println("O efeito " + effect.nome + " em " + this.nome + " acabou.");
            }
        });
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    // Getters
    public String getNome() { return nome; }
    public int getVida() { return vida; }
    public int getMana() { return mana; }
    public void gastarMana(int custo) { this.mana -= custo; }
}