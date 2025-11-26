# Personae_Java

Progetto didattico avanzato in Java che replica le principali funzionalità del sistema delle Personae della serie *Persona*.
L’obiettivo è sviluppare un’applicazione strutturata, completa di modellazione OOP, gestione della logica di combattimento, fusione e sistema di archiviazione su file.

---

## Struttura generale

Il progetto è suddiviso in tre moduli principali:

* **model** — definizione delle entità fondamentali (Persona, Arcano, Statistiche, Mosse, Affinità).
* **battle** — gestione degli scontri, calcolo danni, critici, debolezze e dinamiche di acquisizione.
* **compendium** — archivio delle Personae, sistema di fusione e meccanismi di salvataggio/caricamento.

Tutti i moduli sono progettati per poter essere salvati e recuperati da file esterni.

---

## 1. Modulo *model*

### 1.1. `Persona`

Rappresenta una singola Persona con:

* nome
* arcano
* livello
* statistiche
* lista mosse
* affinità (debolezze, resistenze, assorbimenti, nulli, riflessi)

**Funzioni principali:**

* gestione del level-up
* crescita delle statistiche
* acquisizione mosse
* esportazione e importazione su file (un file dedicato per ogni Persona)

**Formato consigliato file Persona:**

* JSON (consigliato)
* oppure formato proprietario semplice (es. key=value)

Ogni Persona ha quindi un file dedicato, ad esempio:
`/data/personae/JackFrost.json`

---

### 1.2. `Arcano`

Enum degli arcani disponibili.
Viene usato sia nella definizione delle Personae che nelle regole di fusione del compendio.

---

### 1.3. `Statistiche`

Gestisce:

* forza
* magia
* resistenza
* agilità
* fortuna

Comprende metodi dedicati agli incrementi per livello e per eventuali bonus temporanei.

---

### 1.4. `Mossa`

Contiene:

* nome
* tipo
* potenza
* costo
* effetto opzionale

---

### 1.5. Sistema file

Tutte le classi del modulo **model** devono essere serializzabili.
Si prevede una classe dedicata, ad esempio `PersonaSerializer`, per la lettura e scrittura dei file.

---

## 2. Modulo *battle*

### Funzionalità richieste

* calcolo danno basato su:

  * potenza mossa
  * statistiche attaccante/difensore
  * affinità elementali
* gestione colpi critici
* calcolo turnazione (semplice o basata su agilità)
* possibilità di acquisire nuove Personae tramite condizioni di scontro

### Classi principali

* `BattleManager`
* `DamageCalculator`
* eventuale `BattleResult` per incapsulare gli esiti

---

## 3. Modulo *compendium*

### Obiettivi

Riprodurre il comportamento del Compendio del gioco:

* registrazione manuale o automatica delle Personae
* stato “scoperta / non scoperta”
* stato “registrata / non registrata”
* livello più alto registrato della Persona
* costo di evocazione (calcolato in base al livello)
* fusione tra due Personae (regole base o avanzate)

---

### File del Compendio

Un singolo file, ad esempio:

`/data/compendium.json`

che contiene:

* lista di tutte le Personae scoperte
* informazioni su quelle registrate
* statistiche aggiornate delle versioni archiviate
* parametri per la fusione

Ogni Persona registrata nel compendio richiama il proprio file dedicato.

---

### Funzionalità minime

* aggiunta, aggiornamento e rimozione di una Persona registrata
* lettura dello stato attuale del compendio
* caricamento in memoria delle Personae registrate
* esecuzione della fusione con generazione dinamica di una nuova Persona
* salvataggio automatico dopo modifiche

---

## Gestione file e directory

Struttura consigliata:

```
data/
 ├─ personae/
 │   ├─ Persona1.json
 │   ├─ Persona2.json
 │   └─ ...
 └─ compendium.json
```

Il sistema deve essere in grado di:

* creare automaticamente le directory se non esistono
* verificare la presenza dei file
* aggiornare i file senza perdere dati precedentemente salvati
* gestire la coerenza dei riferimenti tra compendio e Personae

---

## Requisiti di completamento

Il progetto può considerarsi completo quando include:

1. Modellazione completa delle entità e affinità.
2. Sistema di combattimento funzionante e testabile.
3. Archiviazione esterna delle Personae.
4. Compendio persistente su file con stato (scoperta/registrata).
5. Fusione funzionante con risultati coerenti.
6. Possibilità di ricostruire l’intero stato del gioco solo dai file nella cartella `data`.

---

## Avvio del progetto

1. Implementare le classi fondamentali del modulo `model`.
2. Integrare il sistema di serializzazione dei file.
3. Realizzare la logica del modulo `battle`.
4. Implementare il Compendio e le fusioni.
5. Collegare tutto tramite un’interfaccia testuale (`Main`) per test e debugging.
