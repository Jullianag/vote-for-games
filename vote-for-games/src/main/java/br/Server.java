package br;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements VoteManager {

    private final List<Game> games = new ArrayList<>();

    protected Server() throws RemoteException {
        super();
    }

    public static void main(String[] args) {

        

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
}
