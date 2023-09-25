package main;

import java.awt.*;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler KeyH;

    public Player(GamePanel gp, KeyHandler KeyH){
        this.gp = gp;
        this.KeyH = KeyH;
        setDefaultValues();
    }
    public void setDefaultValues(){
        x = 0;
        y = 0;
        speed = 4;
    }
    public void update(){
        if(KeyH.upPressed){
            this.y -= this.speed;
        }
        if(KeyH.downPressed){
            this.y += this.speed;
        }
        if(KeyH.leftPressed){
            this.x -= this.speed;
        }
        if(KeyH.rightPressed){
            this.x += this.speed;
        }
    }
    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }

}
