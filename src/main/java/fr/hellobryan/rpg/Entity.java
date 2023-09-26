package fr.hellobryan.rpg;

import lombok.Data;

import java.awt.image.BufferedImage;
@Data
public class Entity {
    protected int x, y;
    protected int speed;
    protected String action = "idle";
    protected String direction;
    protected  int spriteCounter = 0;
    protected int spriteNum = 1;
}
