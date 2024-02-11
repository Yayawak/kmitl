package src.Components;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Arrays;

import src.Assignment2_65050988_65050754;
import src.Components.Food.Food;
import src.Libs.CircleAlgorithms;
import src.helpers.Coordinator;
import src.helpers.TimeTime;
import src.interfaces.Animator;

public class Pacman extends Animator {
    private int size;
    private static Pacman ins;
    private int mouthAngle;
    private long startTime = System.currentTimeMillis();
    private long prevTime = startTime;
    private int startMouthAngle = 0;
    // * modifier is move mouth back or forth (smile big or smile small)
    int modifier = 1;
    
    public static Pacman Ins()
    {
        if (ins == null)
            ins = new Pacman();
        return ins;
    }
    
    private Pacman()
    {
        pos = new Point(100, 100);
        // pos = new Point(0, 0);
        vel = new Point(50, 0);
        // vel = new Point(0, 0);
        size = 100;
        mouthAngle = 0;

        color = Color.orange;
    }
    

    @Override
    public void update(double dt) {
        super.update(dt);


        
        // System.out.println(dt);
        // System.out.println(Math.ceil(6 * dt));

        // int modifier = mouthAngle > 45 ? -1 : 1;
        // int mouthSpeed = 6;
        // int mouthSpeed = 12;
        // int mouthSpeed = 360;
        // * speed per sec nah
        int mouthSpeed = 90;
        // int mouthSpeed = 180;
        // int mouthSpeed = 360;

        if (mouthAngle > 45)
        {
            modifier = -1;
        }
        else if (mouthAngle < 0)
        {
            modifier = 1;
        }
        // else if (modifier ==)



        mouthAngle = mouthAngle + 
            modifier * 
            (int)Math.ceil((mouthSpeed * dt));
        // System.out.println(mouthAngle);



        // double rad = Math.toRadians(mouthAngle);
        // Math.sin(rad);
        // System.out.println(pos);


        // * set vector velocity to target food
        Food nearestFood = findNearestFood();
        if (nearestFood == null) return;
        Point dirToFood = new Point(
            nearestFood.getPos().x - pos.x,
            nearestFood.getPos().y - pos.y
        );
        // System.out.println(dirToFood);
        int vecLen = (int)(Math.sqrt(dirToFood.x * dirToFood.x + dirToFood.y * dirToFood.y));
        // Point normDir = new Point(
        float[] normDir = {
            (float)dirToFood.x / vecLen,
            (float)dirToFood.y / vecLen
        };
        // System.out.println(Arrays.toString(normDir));
        float speedPerSec = 40;
        // float speedPerSec = 100;
        // float speedPerSec = 400;
        normDir[0] *= speedPerSec;
        normDir[1] *= speedPerSec;

        vel = new Point(
            Math.round(normDir[0]),
            Math.round(normDir[1])
        );


        double dist = nearestFood.getPos().distance(pos);
        // * unit rhs = px
        if (dist < 3)
        {
            // ! this make problem as concurrency interruption
            // MainAss2.anims.remove(nearestFood);
            // size *= 1.05f;
            size *= 1.2f;

            Assignment2_65050988_65050754.waitForRemoveAnimObject(nearestFood);
        }
        // * facing direction to nearest food
        // double rad = Math.atan2( (double)dirToFood.y, (double)dirToFood.x);
        // int deg = (int)Coordinator.getAngle(pos, nearestFood.getPos());
        int deg = (int)Coordinator.getAngle(nearestFood.getPos(), pos);
        // int deg = (int)Math.toDegrees(rad);
        startMouthAngle = deg;
    }

    @Override
    public void draw(Graphics2D gg) {

        // gg.scale(2, 2);

        gg.setColor(color);
        // gg.fillOval(pos.x, pos.y, size, size);
        // CircleAlgorithms.midpointDrawCirlcle(pos.x, pos.y, size);
        // CircleAlgorithms.midpointDrawCirlcle(
        //     // pos.x, pos.y, size
        //     pos.x + size,
        //     pos.y + size,
        //     size
        // );
        Point center = new Point(
            pos.x - size / 2,
            pos.y - size / 2
        );
        gg.fillOval(
            center.x,
            center.y,
            // pos.x,
            // pos.y,
            size,
            size
        );

        gg.setColor(Color.yellow);
        gg.fillArc(
            center.x,
            center.y,
            size,
            size,
            startMouthAngle,
            mouthAngle
            // startMouthAngle + mouthAngle
        );
        gg.fillArc(
            center.x,
            center.y,
            size,
            size,
            startMouthAngle,
            // startMouthAngle - mouthAngle
            -mouthAngle
        );
    } 

    private Food findNearestFood()
    {
        double minDist = Float.MAX_VALUE;
        Food minFood = null;
        for (var f : Assignment2_65050988_65050754.anims) {
            if (f instanceof Food)
            {
                double dist = f.getPos().distance(this.pos);
                if (dist < minDist)
                {
                    minDist = dist;
                    minFood = (Food)f;
                }
            }
        }
        return minFood;
    }
    
}
