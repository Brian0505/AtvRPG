package rpgCombate;

public class CajadoArcano implements Arma {
    @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int custoMana = 25;
        if (atacante.getMana() >= custoMana) {
            atacante.gastarMana(custoMana);
            int danoBase = 8;
            alvo.receberDano(danoBase);
            // Efeito Especial: Queimadura
            System.out.println("Bola de Fogo! O alvo está em chamas.");
            alvo.aplicarStatus(new StatusEffect("Queimadura", 2, 10));
        } else {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
        }
    }
    @Override
    public String getNome() { return "Cajado Arcano"; }
}