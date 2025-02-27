package Model;

public class Tijera extends  Juego {
    @Override
    public String comparar(Juego otra) {
        if (otra instanceof Piedra) {
            return "Perdiste";
        } else if (otra instanceof Papel) {
            return "Ganaste";
        } else {
            return "Empate";
        }
    }
}