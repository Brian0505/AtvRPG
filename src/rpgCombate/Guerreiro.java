package rpgCombate;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 15, 8, 5, 120, 50);
    }
    
    // Habilidade Passiva: Pele Dura
    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * 0.80); // Reduz 20% do dano
        System.out.println(this.nome + " ativa Pele Dura!");
        super.receberDano(danoReduzido);
    }
}