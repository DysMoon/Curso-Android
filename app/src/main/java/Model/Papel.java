package Model;

public class Papel extends  Juego{
    @Override
    public String comparar(Juego otra) {
        if (otra instanceof Piedra) {
            return "Ganaste";
        } else if (otra instanceof Papel) {
            return "Empate";
        } else {
            return "Perdiste";
        }
    }

}

