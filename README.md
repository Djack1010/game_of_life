# game_of_life

## Versione 1D

La scacchiera è in realtà un vettore, un array di una dimensione, che contiene solo 1 e 0.

Le regole di aggiornamento sono le seguenti, per ogni elemento `board[i]`, alla posizione `i` del turno successivo ci sarà:
- SE al turno attuale contiene 1:
  - SE i suoi vicini sono entrambi 0 [010]  -> diventerà 0 [000] (morte per sottopopolazione)
  - SE i suoi vicini sono entrambi 1 [111]  -> diventerà 0 [101] (morte per sovrappopolazione)
  - SE i suoi vicini sono uno 0 ed un 1 [110|011] -> resterà 1 [110|011] (sopravvivenza)
- SE al turno attuale contiene 0:
  - SE i suoi vicini sono entrambi 1 [101] -> diventerà 1 [111] (nascita)

Tutte le altre casistiche non incluse dalle regole, non varia il suo valore.

Il board va considerato CIRCOLARE (es: il vicino sx dell'elemento ad indice 0 è l'elemento ad indice board.length-1)
