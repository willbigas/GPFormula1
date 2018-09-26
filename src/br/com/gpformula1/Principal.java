package br.com.gpformula1;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static List<Piloto> PILOTOS_VENCEDORES = new ArrayList<>();

    public static List<Piloto> PILOTOS = new ArrayList<>();
    public static List<Thread> THREADS = new ArrayList<>();
    public static List<Integer> VOLTAS = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ManterGPNegocio.lendoPilotosdoArquivo();
        VOLTAS.clear();
        ManterGPNegocio.gerandoTempoAleatorio();
        System.out.println("#######COMECO DA CORRIDA########");
        ManterGPNegocio.atribuindoThreads();
        ManterGPNegocio.atribuindoJoins();
        System.out.println("#######FIM DA CORRIDA########\r\n");
        System.out.println("||||LISTA DE COLOCACAO||||");
        ManterGPNegocio.imprimindoResultado();

    }

}
