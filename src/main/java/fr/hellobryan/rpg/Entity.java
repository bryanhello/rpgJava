package fr.hellobryan.rpg;

import lombok.Data;


@Data
public class Entity {
    protected int x, y;
    protected int speed;
    protected String action = "idle";
    protected String direction = "Down";
    protected  int spriteCounter = 0;
    protected int spriteNum = 1;
}
