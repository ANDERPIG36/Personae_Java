public class Abilita {
    String nome;

    boolean offensiva;//per targhettare alleati o nemici

    boolean passiva;
    /*
    tipi:
    0:fisico
    1:arma da fuoco
    2:fuoco
    3:ghiaccio
    4:elettricita
    5:vento
    6:psico
    7:nucleare
    8:sacro
    9:maledizione
    10:divino
    11:cura
    12:effetto
    */
    int tipo;

    int numeroColpi;
    int potereAbilita; // danno= sqrt(potereAbilita) * sqrt(statistica) (ricevuto è da ricalcolare)

    int[] AlterazioniStatistiche = new int[1]; //tipo +1 forza o -1 difesa
    int[] Effetti = new int[1]; //tipo fame sonno etc

    int possibilitaColpire;
    int possibilitaEffetti;
}
