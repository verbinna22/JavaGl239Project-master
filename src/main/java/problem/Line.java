package problem;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import java.util.Random;

public class Line {
    double x;
    /**
     * y - координата точки
     */
    double y;
    public static final int SET_1 = 0;
    public static final int SET_2 = 1;
    boolean isSolution = false;

    double x1;

    double y1;
    int setNumber;

    /**
     * Конструктор точки
     *
     * @param x         координата
     * @param y         координата y
     * @param setNumber номер множества, к которому принадлежит точка
     */
    Line(double x, double y, double x1, double y1, int setNumber) {
        this.x = x;
        this.y = y;
        this.x1 =x1;
        this.y1=y1;
        this.setNumber = setNumber;
    }

    /**
     * Рисование точки
     *
     * @param gl переменная OpenGl для рисования
     */
    void render(GL2 gl) {
        if (isSolution)
            gl.glColor3d(1.0, 0.0, 0.0);
        else
            switch (setNumber) {
                case Line.SET_1:
                    gl.glColor3d(0.0, 1.0, 0.0);
                    break;
                case Line.SET_2:
                    gl.glColor3d(0.0, 0.0, 1.0);
                    break;
            }
        //gl.glPointSize(3);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(x, y);
        gl.glEnd();
        //gl.glPointSize(1);
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
