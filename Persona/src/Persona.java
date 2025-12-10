public class Persona {
    String nome;
    //arcano

    int exp;
    int livello;

    int forza;
    int magia;
    int resistenza;
    int agilita;
    int fortuna;

    /*
    debolezze:
    0:nessuna
    1:debole
    2:resiste
    3:assorbe
    4:blocca
    5:rifette
    */

    /*
    indice array = tipi:
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
    */
    int[] debolezze = new int[12];

    //8 slot abilita
    Abilita[] abilita = new Abilita[8];

}
