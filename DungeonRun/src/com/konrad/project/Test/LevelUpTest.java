package com.konrad.project.Test;

import com.konrad.project.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



@DisplayName("Testing if Level Up")
public class LevelUpTest {

    Player player = new Player("",100,20,100,
            1,1,1,1);

    @Test
    public void levelUp(){

        assertEquals(2, player.levelUp());
    }
}




