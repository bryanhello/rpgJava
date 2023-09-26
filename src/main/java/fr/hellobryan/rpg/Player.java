package fr.hellobryan.rpg;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
public class Player extends Entity{

    private final GamePanel gp;
    private final KeyHandler KeyH;

    public Player(GamePanel gp, KeyHandler KeyH){
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 0;
        y = 0;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            IdleDown1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleUp1.png"));
            IdleDown2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleUp2.png"));
            IdleUp1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleDown1.png"));
            IdleUp2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleDown2.png"));
            IdleLeft1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleLeft1.png"));
            IdleLeft2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleLeft2.png"));
            IdleRight1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleRight1.png"));
            IdleRight2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/idle/idleRight2.png"));
        }catch (IOException e){
            log.error("",e);
        }
    }
    public void update(){
        if(KeyH.Pressed){
            moving = true;
            if(KeyH.upPressed){
                direction = "up";
                y -= speed;
            }
            if(KeyH.downPressed){
                direction = "down";
                y += speed;
            }
            if(KeyH.leftPressed){
                direction = "left";
                x -= speed;
            }
            if(KeyH.rightPressed){
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if(spriteCounter == 10 + gp.getFPS()* 0.5){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else{
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }else{
            moving = false;
            spriteNum = 1;
            spriteCounter = 0;
        }

    }
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        image = switch (spriteNum) {
            case 1 -> switch (direction) {
                case "up" -> IdleUp1;
                case "down" -> IdleDown1;
                case "left" -> IdleLeft1;
                case "right" -> IdleRight1;
                default -> image;
            };
            case 2 -> switch (direction) {
                case "up" -> IdleUp2;
                case "down" -> IdleDown2;
                case "left" -> IdleLeft2;
                case "right" -> IdleRight2;
                default -> image;
            };
            default -> null;
        };
        g2.drawImage(image, x, y, gp.getTileSize() * gp.getScale() , gp.getTileSize()* gp.getScale(), null);
    }

}
