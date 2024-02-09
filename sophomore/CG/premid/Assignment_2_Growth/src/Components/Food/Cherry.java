package src.Components.Food;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import src.Libs.BZ;
import src.Libs.CircleAlgorithms;
import src.Libs.Drawing;
import src.helpers.Arounder;

public class Cherry extends Food {

    public Cherry(Color color) {
        super(color);
    }

    public Cherry(Color color, Point pos)
    {
        super(color, pos);
    }


    @Override
    public void update(double dt) {
        super.update(dt);
    }

    @Override
    public void draw(Graphics2D gg) {
        float scale = 0.4f;
        // gg.scale(scale, scale);
        // gg.translate(-pos.x, -pos.y);



        Arounder.scaleAround(pos, scale, scale, gg);

        gg.setColor(color); 
        // Drawing.drawGeneralDot( 
        //     pos.x, 
        //     pos.y, 
        //     50 
        // );
        int cherrySize = 30;
        int strokeSize = 4;
        CircleAlgorithms.midpointDrawCirlcleWithStrokeSize(
             pos.x + 25, pos.y - 15, (int)(cherrySize * 0.75), strokeSize);
        CircleAlgorithms.midpointDrawCirlcleWithStrokeSize( pos.x - 20, pos.y + 10, (int)(cherrySize * 0.8), strokeSize);
        CircleAlgorithms.midpointDrawCirlcleWithStrokeSize( pos.x + 10, pos.y + 20, (int)(cherrySize * 0.6), strokeSize); 
        // * ก้าน 
        gg.setColor(Color.decode("#146B07"));
        BZ.bz( pos.x, pos.y, pos.x - 20, pos.y - 10, pos.x + 10, pos.y - 40, pos.x - 10, pos.y - 40, strokeSize );


    }

}
