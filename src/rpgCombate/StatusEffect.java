package rpgCombate;

// Classe para gerenciar os efeitos de status aplicados nos personagens.
public class StatusEffect {
    String nome;
    int duracao;
    int danoPorTurno;

    public StatusEffect(String nome, int duracao, int danoPorTurno) {
        this.nome = nome;
        this.duracao = duracao;
        this.danoPorTurno = danoPorTurno;
    }

    // Aplica o efeito do turno e decrementa a duração.
    public boolean aplicar(Personagem alvo) {
        if (duracao > 0) {
            System.out.println(alvo.getNome() + " sofre " + danoPorTurno + " de dano de " + nome + "!");
            alvo.receberDano(danoPorTurno);
            duracao--;
            return true;
        }
        return false;
    }
}