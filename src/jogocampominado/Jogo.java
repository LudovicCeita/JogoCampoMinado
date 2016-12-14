/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogocampominado;

/**
 *
 * @author Notorius B.I.G
 */
public class Jogo {

    private Tabuleiro tabu;
    boolean terminar = false;
    boolean ganhou = false;
    int[] jogada;
    int rodada = 0;

    public Jogo() {
        tabu = new Tabuleiro();
        Jogar(tabu);
        jogada = new int[2];
    }

    public void Jogar(Tabuleiro tabu) {
        do {
            rodada++;
            System.out.println("Rodada " + rodada);
            tabu.exibe();
            terminar = tabu.setPosicao();

            if (!terminar) {
                tabu.abrirVizinhas();
                terminar = tabu.ganhou();
            }

        } while (!terminar);

        if (!tabu.ganhou()) {
            System.out.println("Havia uma mina ! Você perdeu!");
            tabu.exibeMinas();
        } else {
            System.out.println("Parabéns, você deixou os 8 campos de minas livres em " + rodada + " rodadas");
            tabu.exibeMinas();
        }
    }

}
