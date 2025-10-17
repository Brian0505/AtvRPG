package rpgCombate;

public class Batalha {
    private Personagem p1;
    private Personagem p2;
    private int turno = 1;

    public Batalha(Personagem p1, Personagem p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void iniciarBatalha() {
        System.out.println("A BATALHA COMEÇA: " + p1.getNome() + " vs " + p2.getNome());
        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("\n----- TURNO " + turno + " -----");
            executarTurno(p1, p2);
            if (!p2.estaVivo()) break;
            
            System.out.println("---");
            
            executarTurno(p2, p1);
            turno++;
        }

        Personagem vencedor = p1.estaVivo() ? p1 : p2;
        System.out.println("\nTodos os Reinos Reunidos! O vencedor é " + vencedor.getNome() + "!");
    }

    private void executarTurno(Personagem atacante, Personagem alvo) {
        System.out.println("Vez de " + atacante.getNome() + " (Vida: " + atacante.getVida() + ", Mana: " + atacante.getMana() + ")");
        atacante.processarStatus();
        if (atacante.estaVivo()) {
            atacante.atacar(alvo);
        }
    }
}