package problem;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2GL3;

public class Figures {
    public static void renderLine(GL2 gl, double x1, double y1, double x, double y, int width){
        gl.glColor3d(0,1,1);
        gl.glLineWidth(width);
        gl.glBegin(GL2.GL_LINES);
        gl.glVertex2d(x,y);
        gl.glVertex2d(x1,y1);
        gl.glEnd();
    }
    public static void renderPoint(GL2 gl, double x, double y, int size){
        gl.glColor3d(1,1,1);
        gl.glPointSize(size);
        gl.glBegin(GL2.GL_POINTS);
        gl.glVertex2d(x,y);
        gl.glEnd();
    }
    public static void renderTriangle(GL2 gl, double x, double y, double x1, double y1, double x2, double y2, boolean filled){
        gl.glColor3d(1,0,1);
        gl.glPointSize(5);
        if (filled){

            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex2d(x,y);
            gl.glVertex2d(x1,y1);
            gl.glVertex2d(x2,y2);
            gl.glEnd();}


        else{
            gl.glBegin(GL2.GL_LINE_STRIP);
                gl.glVertex2d(x,y);
                gl.glVertex2d(x1,y1);
                gl.glVertex2d(x2,y2);
                gl.glVertex2d(x,y);
            gl.glEnd();
        }
    }
    public static void renderQuads(GL2 gl, double x, double y, double x1, double y1, double x2, double y2, double x3, double y3,boolean filled){
        gl.glColor3d(0,0,1);
        gl.glPointSize(10);
        if (filled){

            gl.glBegin(GL2.GL_QUADS);
            gl.glVertex2d(x,y);
            gl.glVertex2d(x1,y1);
            gl.glVertex2d(x2,y2);
            gl.glVertex2d(x3,y3);
            gl.glEnd();}


        else{
            gl.glBegin(GL2.GL_LINE_STRIP);
            gl.glVertex2d(x,y);
            gl.glVertex2d(x1,y1);
            gl.glVertex2d(x2,y2);
            gl.glVertex2d(x3,y3);
            gl.glVertex2d(x,y);
            gl.glEnd();
        }
    }
    public static void renderCircle(GL2 gl, double x, double y, double x1, double y1, boolean filled){
        gl.glColor3d(0,0,1);
        gl.glPointSize(10);
        if (filled){

            gl.glBegin(GL2.GL_TRIANGLES);
            double uol=2*Math.PI/50;
            //double n=Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
            for (int i=1; i<50; i++){
                double xx=Math.cos(uol*i);
                double yy=Math.sin(uol*i);
                double xx1=Math.cos(uol*(i-1));
                double yy1=Math.sin(uol*(i-1));
                gl.glVertex2d(x,y);
                gl.glVertex2d(xx,yy);
                gl.glVertex2d(xx1,yy1);
            }
            double xx=Math.cos(uol*0);
            double yy=Math.sin(uol*0);
            double xx1=Math.cos(uol*(49));
            double yy1=Math.sin(uol*(49));
            gl.glVertex2d(x,y);
            gl.glVertex2d(xx,yy);
            gl.glVertex2d(xx1,yy1);
            gl.glEnd();}


        else{
            gl.glBegin(GL2.GL_LINE_STRIP);
            double uol=2*Math.PI/50;
            double n=Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
            for (int i=2; i<50; i++){
                double xx=Math.cos(uol*i)*n;
                double yy=Math.sin(uol*i)*n;
                double xx1=Math.cos(uol*(i-1))*n;
                double yy1=Math.sin(uol*(i-1))*n;
                gl.glVertex2d(xx,yy);
                gl.glVertex2d(xx1,yy1);

            }
            double xx=Math.cos(uol*2)*n;
            double yy=Math.sin(uol*2)*n;
            double xx1=Math.cos(uol*50)*n;
            double yy1=Math.sin(uol*50)*n;
            gl.glVertex2d(xx,yy);
            gl.glVertex2d(xx1,yy1);

            gl.glEnd();
        }
    }
}
