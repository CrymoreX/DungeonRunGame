package com.konrad.project.Test;

import com.konrad.project.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


// TODO --> @Test --> More Actions --> add Junit 5... 8.1 --> ENTER

public class DamageTest {

    Player player;

    @BeforeEach
    void setup() {
        player = new Player("",1,0,0,1,1,1,1);
    }

    // PLAYER FIGHT IS DAMAGE + STRENGTH = 2

    @DisplayName("Testing fight method")
    @Test
    void fight() {
        assertEquals(4, player.fight());

    }}