package rpgCombate;

// Simplificação: no nosso caso, o ataque em área atinge apenas o alvo principal.
// Para atingir múltiplos inimigos, a classe Batalha precisaria passar uma lista de alvos.
public class ArcoElfico implements Arma {
     @Override
    public void usar(Personagem atacante, Personagem alvo) {
        int custoMana = 15;
        if (atacante.getMana() >= custoMana) {
            atacante.gastarMana(custoMana);
            int danoBase = 12;
            System.out.println("Chuva de Flechas atinge a área!");
            alvo.receberDano(danoBase);
        } else {
            System.out.println(atacante.getNome() + " não tem mana suficiente!");
        }
    }
    @Override
    public String getNome() { return "Arco Élfico"; }
}