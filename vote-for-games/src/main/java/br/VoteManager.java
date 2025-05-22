package br;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface VoteManager extends Remote {

    void addVotes(int numberGame, int votes) throws RemoteException;
    List<Game> getGames() throws RemoteException;
    void addGames(String name, int number) throws RemoteException;
}
