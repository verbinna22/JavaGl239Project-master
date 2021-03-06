package problem;

import javax.media.opengl.GL2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс задачи
 */
public class Problem {
    /**
     * текст задачи
     */
    public static final String PROBLEM_TEXT = "ПОСТАНОВКА ЗАДАЧИ:\n" +
            "Заданы два множества точек в пространстве.\n" +
            "Требуется построить пересечения и разность этих множеств";

    /**
     * заголовок окна
     */
    public static final String PROBLEM_CAPTION = "Итоговый проект ученика 10-7 Вербина Никиты";

    /**
     * путь к файлу
     */
    private static final String FILE_NAME = "points.txt";

    /**
     * список точек
     */
    private ArrayList<Point> points;
    private ArrayList<Line> lines;

    /**
     * Конструктор класса задачи
     */
    public Problem() {
        points = new ArrayList<>();
        lines = new ArrayList<>();
    }

    /**
     * Добавить точку
     *
     * @param x      координата X точки
     * @param y      координата Y точки
     * @param setVal номер множества
     */
    public void addPoint(double x, double y, int setVal) {
        Point point = new Point(x, y, setVal);
        points.add(point);
    }
    public void addLine(double x, double y, double x1, double y1){
        Line line=new Line(x,y,x1,y1);
        lines.add(line);
    }

    /**
     * Решить задачу
     */
    public void solve() {
        // перебираем пары точек
        for (Point p : points) {
            for (Point p2 : points) {
                // если точки являются разными
                if (p != p2) {
                    // если координаты у них совпадают
                    if (Math.abs(p.x - p2.x) < 0.0001 && Math.abs(p.y - p2.y) < 0.0001) {
                        p.isSolution = true;
                        p2.isSolution = true;
                    }
                }
            }
        }
    }

    /**
     * Загрузить задачу из файла
     */
    public void loadFromFile() {
        points.clear();
        try {
            File file = new File(FILE_NAME);
            Scanner sc = new Scanner(file);
            // пока в файле есть непрочитанные строки
            while (sc.hasNextLine()) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                int setVal = sc.nextInt();
                sc.nextLine();
                Point point = new Point(x, y, setVal);
                points.add(point);
            }
        } catch (Exception ex) {
            System.out.println("Ошибка чтения из файла: " + ex);
        }
    }

    /**
     * Сохранить задачу в файл
     */
    public void saveToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME));
            for (Point point : points) {
                out.printf("%.2f %.2f %d\n", point.x, point.y, point.setNumber);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println("Ошибка записи в файл: " + ex);
        }
    }

    /**
     * Добавить заданное число случайных точек
     *
     * @param n кол-во точек
     */
    public void addRandomPoints(int n) {
        for (int i = 0; i < n; i++) {
            Point p = Point.getRandomPoint();
            points.add(p);
        }
    }
    public void addLines(int n) {
        for (int i = 0; i < n; i++) {
            Line p =new Line(0.1,0.9,0.3,0.4);
            Line p1 =new Line(0.5,0.8,0.3,0.4);
            lines.add(p);
            lines.add(p1);
        }
    }

    /**
     * Очистить задачу
     */
    public void clear() {
        points.clear();
        lines.clear();
    }

    /**
     * Нарисовать задачу
     *
     * @param gl переменная OpenGL для рисования
     */
    public void render(GL2 gl) {
//        for (Point point : points) {
//            point.render(gl);
//
//        }
//        for (Line line : lines) {
//            line.render(gl);
//        }

        //Figures.renderLine(gl, 1, -2, -5, 10, 10);
        //Figures.renderPoint(gl, 0.5, 0.2, 10);
        //Figures.renderTriangle(gl, 0.1,0.2, -0.5,-0.1,0.5,-0.1, true);
        //Figures.renderTriangle(gl, -0.1,0.2, -0.5,0.1,-0.5,-0.1, false);
        //Figures.renderQuads(gl, -0.1,0.2, -0.5,0.1,-0.5,-0.1, 0,-0.4,false);
        //Figures.renderQuads(gl, -0.7,0.3, -0.9,0.4,-0.2,-0.8, 0.6,0,true);
        //Figures.renderCircle(gl,0.1,-0.5,0,0, false);
        //Figures.renderCircle(gl,0.1,-0.5,0,0, true);
        //Figures.renderCube(gl, 0, 0, 0.2, true, 2);

        Line li1 = new Line(1,2, -1, -2);
        Line li2 = new Line(-0.7,0.1, 0, -0.4);
        li1.render(gl);
        li2.render(gl);

        Figures.pointLine(gl, li1, li2);

        //Point p1= new Point(0.1, 0.7, 3);
        //Point p2= new Point(0, -0.7, 4);
        //Figures.linePoint(gl, p1, p2);

        //Point p1= new Point(0.1, 0.7, 3);
        //Point p2= new Point(0, -0.7, 4);
        //Figures.linePoint2(gl, p1, p2);


    }

}
