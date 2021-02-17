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
    public static void pointLine(GL2 gl, Line li1, Line li2){
        double a=li1.y-li1.y1;
        double b=li1.x1-li1.x;
        double c=li1.x*li1.y1-li1.x1*li1.y;
        double a1=li2.y-li2.y1;
        double b1=li2.x1-li2.x;
        double c1=li2.x*li2.y1-li2.x1*li2.y;
        if (!(b==0 && b1==0)) {
            double x=0;
            double y=0;
            if (b==0){
                x=-1*c/a;
                y=(a1*x+c1)/(-1*b1);
            }
            if (b1==0){
                x=-1*c1/a1;
                y=(a*x+c)/(-1*b);
            }
            if (b!=0 && b1!=0){
                y=-1*(a1*c-a*c1)/(a1*b-a*b1);
                x=(b*y+c)/(-1*a);
            }
            gl.glColor3d(1, 1, 1);
            gl.glPointSize(6);
            gl.glBegin(GL2.GL_POINTS);
            gl.glVertex2d(x, y);
            gl.glEnd();
        }
    }
    public static void linePoint(GL2 gl, Point p1, Point p2){
        p1.render(gl);
        p2.render(gl);
        Line li=new Line(p1.x, p1.y,p2.x,p2.y);
        li.render(gl);
    }
    public static void linePoint2(GL2 gl, Point p1, Point p2){
        double xx=p1.x-p2.x;
        double yy=p1.y-p2.y;
        p1.render(gl);
        p2.render(gl);
        Line li=new Line(p1.x-xx*10, p1.y-yy*10,p2.x+xx*10,p2.y+yy*10);
        li.render(gl);
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
            double n= Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
            for (int i=1; i<51; i++){
                double xx=Math.cos(uol*i)*n;
                double yy=Math.sin(uol*i)*n;
                double xx1=Math.cos(uol*(i-1))*n;
                double yy1=Math.sin(uol*(i-1))*n;
                gl.glVertex2d(x,y);
                gl.glVertex2d(xx,yy);
                gl.glVertex2d(xx1,yy1);
            }
            //double xx=Math.cos(uol*0);
            //double yy=Math.sin(uol*0);
            //double xx1=Math.cos(uol*(49));
            //double yy1=Math.sin(uol*(49));
            //gl.glVertex2d(x,y);
            //gl.glVertex2d(xx,yy);
            //gl.glVertex2d(xx1,yy1);
            gl.glEnd();}


        else{
            gl.glBegin(GL2.GL_LINE_STRIP);
            double uol=2*Math.PI/50;
            double n=Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
            for (int i=1; i<51; i++){
                double xx=Math.cos(uol*i)*n;
                double yy=Math.sin(uol*i)*n;
                double xx1=Math.cos(uol*(i-1))*n;
                double yy1=Math.sin(uol*(i-1))*n;
                gl.glVertex2d(xx,yy);
                gl.glVertex2d(xx1,yy1);

            }
            //double xx=Math.cos(uol*2)*n;
            //double yy=Math.sin(uol*2)*n;
            //double xx1=Math.cos(uol*50)*n;
            //double yy1=Math.sin(uol*50)*n;
            //gl.glVertex2d(xx,yy);
            //gl.glVertex2d(xx1,yy1);

            gl.glEnd();
        }
    }
    public static void renderCube(GL2 gl, double x, double y, double a, boolean filled, double b){
        gl.glColor3d(0,0,1);
        gl.glPointSize(10);
        b =Math.abs(b);
        if (!filled){

            gl.glBegin(GL2.GL_LINE_STRIP);

            gl.glVertex2d(x,y);
            gl.glVertex2d(x+a,y);
            gl.glVertex2d(x+a,y+a);
            gl.glVertex2d(x,y+a);
            gl.glVertex2d(x,y);
            gl.glVertex2d(x+a/b,y+a/b);
            gl.glVertex2d(x+a/b,y+a+a/b);
            gl.glVertex2d(x,y+a);
            gl.glVertex2d(x+a,y+a);
            gl.glVertex2d(x+a+a/b,y+a+a/b);
            gl.glVertex2d(x+a/b,y+a+a/b);
            gl.glVertex2d(x+a/b,y+a/b);
            gl.glVertex2d(x+a+a/b,y+a/b);
            gl.glVertex2d(x+a,y);
            gl.glVertex2d(x+a,y+a);
            gl.glVertex2d(x+a+a/b,y+a+a/b);
            gl.glVertex2d(x+a+a/b,y+a/b);
            //double xx=Math.cos(uol*0);
            //double yy=Math.sin(uol*0);
            //double xx1=Math.cos(uol*(49));
            //double yy1=Math.sin(uol*(49));
            //gl.glVertex2d(x,y);
            //gl.glVertex2d(xx,yy);
            //gl.glVertex2d(xx1,yy1);
            gl.glEnd();}


        else{
            gl.glBegin(GL2.GL_QUADS);

            gl.glVertex2d(x,y);
            gl.glVertex2d(x+a,y);
            gl.glVertex2d(x+a,y+a);
            gl.glVertex2d(x,y+a);

            gl.glColor3d(0,0,0.5);
            gl.glVertex2d(x,y+a);
            gl.glVertex2d(x+a/b,y+a+a/b);
            gl.glVertex2d(x+a+a/b,y+a+a/b);
            gl.glVertex2d(x+a,y+a);

            gl.glColor3d(0,0,0.2);
            gl.glVertex2d(x+a,y);
            gl.glVertex2d(x+a+a/b,y+a/b);
            gl.glVertex2d(x+a+a/b,y+a+a/b);
            gl.glVertex2d(x+a,y+a);
            gl.glEnd();
        }
    }
}
