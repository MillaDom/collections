package ru.netology.javaqa.manager;

import ru.netology.javaqa.data.Player;
import ru.netology.javaqa.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player1 not found!");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player2 not found!");
        }
        if (player1.getStrenght() > player2.getStrenght()) {
            return 1;
        }
        if (player2.getStrenght() > player1.getStrenght()) {
            return 2;
        } else {
            return 0;
        }
    }
}
