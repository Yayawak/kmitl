package src.Components.Ghost;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Arc2D;

import src.Libs.BZ;
import src.Libs.CircleAlgorithms;
import src.Libs.Drawing;
import src.helpers.Arounder;
import src.helpers.TimeTime;
import src.interfaces.Animator;

public class Ghost extends Animator {
    long baseFloorTimeSec = 2000;

    public Ghost(Color color)
    {
        this.color = color;
    }

    public Ghost(Color color, Point pos)
    {
        this.color = color;
        this.pos = pos;

        // this.vel = new Point(0, 30);
        // this.vel = new Point(30, 0);

        int base = 10;
        this.vel = new Point(
            base + (int)(Math.random() * 30),
            base + (int)(Math.random() * 30)
        );
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        // System.out.println(dt);
        // System.out.println(this.pos);

        long test = TimeTime.getCurrentTime() - prevTime;
        // if (test > 3000)
        long interval = (long)(Math.random() * baseFloorTimeSec + 2000) + baseFloorTimeSec;
        // System.out.println(interval);
        if (test > interval)
        {
            // System.out.println(test);
            prevTime = TimeTime.getCurrentTime();

            int xmodifier = Math.random() > 0.5 ? 1 : -1;
            int ymodifier = Math.random() > 0.5 ? 1 : -1;
            vel = new Point(
                // vel.x + (int)(),
                // vel.y + (int)(),
                vel.x * xmodifier,
                vel.y * ymodifier
            );
        }
        // System.out.println(vel);
    }

    @Override
    public void draw(Graphics2D gg) {
        gg.setColor(color);

        
        float scale = 0.3f;
        Arounder.scaleAround(pos, scale, scale, gg);
        // // Drawing.drawGeneralDot(
        // //     pos.x,
        // //     pos.y,
        // //     50
        // // );
        // // gg.translate(0, 400);
        // int cherrySize = 30;
        // CircleAlgorithms.midpointDrawCirlcle( pos.x + 25, pos.y - 15, (int)(cherrySize * 0.75));
        // CircleAlgorithms.midpointDrawCirlcle( pos.x - 20, pos.y + 10, (int)(cherrySize * 0.8));
        // CircleAlgorithms.midpointDrawCirlcle( pos.x + 10, pos.y + 20, (int)(cherrySize * 0.6));

        // * head section
        int headSize = 100;
        int halfhead = headSize / 2;
        var semi = new Arc2D.Float(
            // (float)pos.x,
            // (float)pos.y,
            (float)pos.x + 0,
            (float)pos.y - halfhead,
            (float)headSize,
            (float)headSize,
            (float)00,
            (float)180,
            Arc2D.OPEN
        );
        // gg.fillOval(pos.x, pos.y, headSize, headSize);
        gg.fill(semi);
        // for (int i = 0; i < )


        // * middle body -> rectangle
        gg.fillRect(pos.x, pos.y, headSize, halfhead);

        // * lower ผ้าคลุม
        // BZ.bz(
        // )

        final int n = 5;
        final int widthX = headSize / n;
        final int subHeight = 30;

        final int baseStartY = pos.y + halfhead;
        for (int i = 0; i < n; i++)
        {
            // 0 -> 5 sections            
            int startX = (int)(pos.x + headSize * ((float)i / (float)n));
            int end = startX + widthX;

            Polygon trig = new Polygon();
            trig.addPoint(startX, baseStartY);
            trig.addPoint(end, baseStartY);
            trig.addPoint((startX + end) / 2, baseStartY + subHeight);
                        // int start = (int)(halfhead * ((float)i / (float)n));
            gg.fill(trig);
        }

        // * eyes

        // halfhead
        // int yeye = pos.y - halfhead / 2;
        // Point leftEye = new Point(pos.x + halfhead / 2, yeye);
        // Point rightEye = new Point(pos.x + halfhead / 2, yeye);
        // Point leftEye = new Point(pos.x - halfhead / 2, yeye);
        // Point rightEye = new Point(pos.x + halfhead / 2, yeye);

        gg.setColor(Color.black);
        int eyeRadius = halfhead / 2;
        // gg.fillOval(leftEye.x, leftEye.y, eyeRadius, eyeRadius);
        // gg.fillOval(rightEye.x, rightEye.y, eyeRadius, eyeRadius);

        // gg.fillOval(pos.x, pos.y, eyeRadius, eyeRadius);
        // gg.fillOval(pos.x + headSize, pos.y, eyeRadius, eyeRadius);

        // * ตานอก
        gg.fillOval(pos.x + (int)(headSize * 0.2f), pos.y, eyeRadius, eyeRadius);
        gg.fillOval(pos.x + (int)(headSize * 0.6f), pos.y, eyeRadius, eyeRadius);

        int innerEyeRadius = eyeRadius / 2;
        gg.setColor(Color.white);
        // * ตาใน
        gg.fillOval(pos.x + (int)(headSize * 0.2f), pos.y, innerEyeRadius, innerEyeRadius);
        gg.fillOval(pos.x + (int)(headSize * 0.6f), pos.y, innerEyeRadius, innerEyeRadius);
    }
    
}
