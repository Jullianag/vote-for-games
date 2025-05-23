package br;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Server extends UnicastRemoteObject implements VoteManager {

    private final List<Game> games = new ArrayList<>();

    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {

        try {
            Server server = new Server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("VoteManager", server);

            System.out.println("Iniciando servidor...");

            server.addGames("Astro Bot", 1);
            server.addGames("Grand Theft Auto V", 2);
            server.addGames("The Witcher 3", 3);
            server.addGames("Elden RIng", 4);
            server.addGames("Cyberpunk 2077", 5);
            server.addGames("Gran Turismo 7", 6);
            server.addGames("Alan Wake II", 7);
            server.addGames("Ghost of Tsushima", 8);
            server.addGames("Spider Man 2", 9);
            server.addGames("Assassin's Creed Shadows", 10);

            System.out.println("Votação Iniciada!");
            System.out.println("-------------------");

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {

                @Override
                public void run() {
                    server.showVotes();
                }
            }, 0, 10000);


        } catch (RemoteException e) {
            System.out.println("Erro no servidor RMI: ");
            e.printStackTrace();
            System.exit(1);
        }


    }

    @Override
    public void addVotes(int numberGame, int votes) throws RemoteException {
        for (Game game : games) {
            if(game.getNumber() == numberGame) {
                game.setVotes(game.getVotes() + votes);
                return;
            }
        }
        System.out.println("Game não encontrado!");
    }

    @Override
    public List<Game> getGames() throws RemoteException {
        return games;
    }

    @Override
    public void addGames(String name, int number) throws RemoteException {
        games.add(new Game(name, number));
    }

    public void showVotes() {
        System.out.println("\nApuração Atualizada: ");
        System.out.println("-----------------------------------");
        for (Game game : games) {
            System.out.printf("%-2d %-25s \t%-10s \t%d\n",
                    game.getNumber(),
                    game.getName(),
                    new String(new char[8]).replace('\0', '-'),
                    game.getVotes());
        }
    }
}
