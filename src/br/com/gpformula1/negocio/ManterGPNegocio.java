package br.com.gpformula1.negocio;

import br.com.gpformula1.entidade.Piloto;
import static br.com.gpformula1.Principal.PILOTOS;
import static br.com.gpformula1.Principal.PILOTOS_VENCEDORES;
import static br.com.gpformula1.Principal.THREADS;
import static br.com.gpformula1.Principal.VOLTAS;
import java.util.List;

public class ManterGPNegocio {

    public static void imprimindoResultado() {
        for (int i = 0; i < PILOTOS_VENCEDORES.size(); i++) {
            System.out.println((i + 1) + ") [" + PILOTOS_VENCEDORES.get(i).getNome() + " - " + PILOTOS_VENCEDORES.get(i).getEquipe()
                    + "] Menor Tempo [" + br.com.gpformula1.util.UtilFormat.mmss(PILOTOS_VENCEDORES.get(i).getMenorTempo()) + "]"
                    + " Tempo de Corrida - [" + br.com.gpformula1.util.UtilFormat.mmss(PILOTOS_VENCEDORES.get(i).getTempoTotal()) + "]");

        }
    }

    public static void atribuindoJoins() throws InterruptedException {
        for (int i = 0; i < PILOTOS.size(); i++) {
            THREADS.get(i).join();
        }
    }

    public static void atribuindoThreads() {
        for (int i = 0; i < PILOTOS.size(); i++) {
            THREADS.add(new Thread(PILOTOS.get(i)));
            THREADS.get(i).start();

        }
    }

    public static void gerandoTempoAleatorio() {
        for (int i = 0; i < PILOTOS.size(); i++) {
            VOLTAS = br.com.gpformula1.util.UtilList.numRandom(70000, 135000, 20);
            PILOTOS.get(i).setVoltas(VOLTAS);
        }
    }

    public static void lendoPilotosdoArquivo() throws Exception {
        List<String> LINHAS = br.com.gpformula1.util.UtilArquivo.lerArqArrayList("pilotos.txt");
        for (int i = 0; i < LINHAS.size(); i++) {
            String campos[] = LINHAS.get(i).split("[;]");
            PILOTOS.add(new Piloto());
            PILOTOS.get(i).setNome(campos[0]);
            PILOTOS.get(i).setEquipe(campos[1]);
        }
    }

}
