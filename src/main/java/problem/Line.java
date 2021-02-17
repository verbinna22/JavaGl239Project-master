package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.Random;

public class Line {
    double x;

    double y;

    double x1;

    double y1;


    Line(double x, double y, double x1, double y1) {
        this.x = x;
        this.y = y;
        this.x1 =x1;
        this.y1=y1;
    }

    public void render(GL2 gl) {
        gl.glBegin(GL.GL_LINES);
        gl.glPointSize(1);
        gl.glColor3f(1, 1, 0);
        gl.glVertex2d(x1, y1);
        gl.glVertex2d(x, y);
        gl.glEnd();

    }

    /**
     * Получить строковое представление линии
     *
     * @return строковое представление точки
     */
    @Override
    public String toString() {
        return "Линия: " + (y-y1) + "x" + (x1-x)+"y"+ (x*y1-x1*y);
    }
}
