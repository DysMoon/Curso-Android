package Model;

public class Piedra extends Juego {

    @Override
    public String comparar(Juego otra) {
        if (otra instanceof Piedra) {
            return "Empate";
        } else if (otra instanceof Papel) {
            return "Perdiste";
        } else {
            return "Ganaste";
        }

    }
}