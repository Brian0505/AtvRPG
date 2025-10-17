package rpgCombate;

public class RPG {
    public static void main(String[] args) {
        // Criar personagens
        Personagem guerreiro = new Guerreiro("Aragorn");
        Personagem mago = new Mago("Gandalf");

        // Criar armas
        Arma espada = new EspadaLonga();
        Arma cajado = new CajadoArcano();

        // Equipar armas
        guerreiro.equiparArma(espada);
        mago.equiparArma(cajado);

        // Iniciar a batalha
        Batalha batalha = new Batalha(guerreiro, mago);
        batalha.iniciarBatalha();
    }
}