package br.com.gpformula1;

import java.util.List;

/**
 *
 * @author Alunos
 */
public class Piloto implements Runnable {

    private String nome;
    private String equipe;
    private List<Integer> Voltas;
    private Integer menorTempo;
    private Integer tempoTotal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public List<Integer> getVoltas() {
        return Voltas;
    }

    public void setVoltas(List<Integer> Voltas) {
        this.Voltas = Voltas;
    }

    public Integer getMenorTempo() {
        Integer menor = Voltas.get(0);
        for (Integer Volta : Voltas) {
            menor = Math.min(menor, Volta);
        }
        this.menorTempo = menor;
        return this.menorTempo;
    }

    public Integer getTempoTotal() {
        this.tempoTotal = 0;
        for (int i = 0; i < Voltas.size(); i++) {
            this.tempoTotal += Voltas.get(i);

        }
        return this.tempoTotal;

    }

    @Override
    public void run() {

        for (int j = 0; j < Voltas.size(); j++) {

            System.out.println("O Piloto: " + this.getNome() + " - " + this.getEquipe() + "- fez na volta " + j
                    + " " + utilpacket.UtilFormat.mmss(this.getVoltas().get(j)) + " Segundos");
            Double teste1 = (1.5 * this.getVoltas().get(j)) / 100;
            Long resultado = Math.round(teste1);
            try {
                Thread.sleep(resultado);
            } catch (InterruptedException ex) {
                System.out.println("Erro ao Dormir!");
            }

        }

        System.out.println("Piloto " + this.getNome() + " Terminou sua Corrida!");
        Principal.PILOTOS_VENCEDORES.add(this);
    }

    @Override
    public String toString() {
        return "Piloto{" + "nome=" + nome + ", equipe=" + equipe + ", Voltas=" + Voltas + '}';
    }

}
