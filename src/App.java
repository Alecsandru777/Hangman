import java.io.FileNotFoundException;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        GameService gameService = new GameService();

        gameService.start();

    }

}
