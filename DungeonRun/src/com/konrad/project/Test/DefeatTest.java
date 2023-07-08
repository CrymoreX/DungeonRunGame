package com.konrad.project.Test;

import com.konrad.project.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DefeatTest {

    Player player;

    @BeforeEach
    void setup() {
        player = new Player("",0,1,0,
                1,1,1,1);
    }
    @DisplayName("Testing if defeated")
    @Test
    public void isAlive() {
        assertEquals(player.isAlive(),false);


    }


}
