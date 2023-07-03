package Game;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class MyPillar {
    private int x;
    private int y;
    private int width;
    private int height;
    private int speed;

    private int screenWidth; // 屏幕宽度，用于计算重置柱子的位置

    private Image pillarImage;
    
    public MyPillar(int x, int y, int width, int height, int speed, int screenWidth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.screenWidth = screenWidth;
        
        ImageIcon icon = new ImageIcon("picture/pillar.png");
        pillarImage = icon.getImage();
    }

    public void move() {
        x -= speed; // 向左移动

        if (x + width < 0) {
            reset(); // 柱子离开屏幕，重置柱子位置
        }
    }

    public void reset() {
        // 将柱子放置到屏幕的右侧，以实现循环移动
        x = screenWidth; // 设置柱子的起始X坐标

        // 使用Random类生成随机数
        Random random = new Random();
        int minHeight = 100; // 最小高度
        int maxHeight = 400; // 最大高度
        int gap = 150; // 柱子之间的间隔
        int range = maxHeight - minHeight - gap;
        y = minHeight + random.nextInt(range);

        // 设置其他柱子的属性，例如宽度、高度等
        // ...
    }

    public void draw(Graphics g) {
    	
    	g.drawImage(pillarImage, x, y, width, height, null);
    }
}