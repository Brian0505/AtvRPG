package rpgCombate;

public class RPG {
    public static void main(String[] args) {
        
        Personagem guerreiro = new Guerreiro("Aragorn");
        Personagem mago = new Mago("Gandalf");

        Arma espada = new EspadaLonga();
        Arma cajado = new CajadoArcano();

        guerreiro.equiparArma(espada);
        mago.equiparArma(cajado);
        
        Batalha batalha = new Batalha(guerreiro, mago);
        batalha.iniciarBatalha();
    }
}