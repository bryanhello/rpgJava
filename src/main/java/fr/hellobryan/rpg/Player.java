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

    }
    public void setDefaultValues(){
        x = 0;
        y = 0;
        speed = 4;
        direction = "down";
    }
    public BufferedImage LoadPlayerImage(){
        try{
            return ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/%s/%s%s.png".formatted(action, action, direction + spriteNum)));
        }catch (IOException e){
            return null;
        }
    }

    public void update(){

        if(KeyH.Pressed){
            action = "walking";
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

        }else{
            action = "idle";

        }
        if(spriteCounter == 10 + gp.getFPS()* 0.5){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else{
                spriteNum = 1;
            }
            spriteCounter = 0;
        }
        spriteCounter++;


    }
    public void draw(Graphics2D g2){

        g2.drawImage(LoadPlayerImage(), x, y, gp.getTileSize() * gp.getScale() , gp.getTileSize()* gp.getScale(), null);
    }

}
