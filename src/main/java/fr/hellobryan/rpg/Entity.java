package fr.hellobryan.rpg;

import lombok.Data;

import java.awt.image.BufferedImage;
@Data
public class Entity {
    protected int x, y;
    protected int speed;
    protected boolean moving = false;
    protected BufferedImage IdleUp1, IdleUp2, IdleDown1, IdleDown2, IdleLeft1, IdleLeft2, IdleRight1, IdleRight2;
    protected BufferedImage MovingUp1, MovingUp2, MovingDown1, MovingDown2, MovingLeft1, MovingLeft2, MovingRight1, MovingRight2;
    protected String direction;
    protected  int spriteCounter = 0;
    protected int spriteNum = 1;
}
