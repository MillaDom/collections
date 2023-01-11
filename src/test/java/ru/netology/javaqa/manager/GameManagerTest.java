package ru.netology.javaqa.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.data.Player;
import ru.netology.javaqa.exception.NotRegisteredException;

public class GameManagerTest {

    GameManager manager = new GameManager();

    Player player1 = new Player(001, "John", 100);
    Player player2 = new Player(002, "Milla", 300);
    Player player3 = new Player(003, "Masha", 80);
    Player player4 = new Player(004, "Tanya", 150);
    Player player5 = new Player(005, "Tom", 100);

    @BeforeEach
    public void setup() {
        manager.register(player1);
        manager.register(player2);
        manager.register(player3);
        manager.register(player4);
        manager.register(player5);
    }

    @Test
    public void shouldFirstWin() {
        int expected = 1;
        int actual = manager.round("Milla", "Tom");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSecondWin() {
        int expected = 2;
        int actual = manager.round("Masha", "Tanya");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinWin() {
        int expected = 0;
        int actual = manager.round("John", "Tom");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldOneException() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Milla", "Katya");
        });
    }

    @Test
    public void shouldTwoException() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Olya", "Katya");
        });
    }
}