package djm_lab5;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Draw extends JPanel { // КЛАСС РИСОВАНИЯ СВОЕЙ КАРТИНКИ

    Graphics2D canvas;   // Класс рисования
    BufferedImage buff;  // Буферное изображение
    int x = 400; // Константа размера полотна по х
    int y = 400; // Константа размера полотна по y

    Draw() {
        // Создаем буферное полотно для рисования размером x-y
        buff = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
        // Создаем двустороннюю связь между буферным изображением и классом рисования
        canvas = (Graphics2D) buff.getGraphics();

        canvas.setPaint(Color.GRAY); // Устанавливаем цвет рисования серым
        canvas.drawLine(70, 180, 128, 220); // Отрисовываем линию
        canvas.drawLine(70, 100, 128, 60); // Отрисовываем линию
        canvas.drawLine(70, 180, 70, 100); // Отрисовываем линию
        canvas.drawLine(70, 100, 88, 109); // Отрисовываем линию

        canvas.drawLine(128, 220, 185, 180); // Отрисовываем линию
        canvas.drawLine(185, 100, 128, 60); // Отрисовываем линию
        canvas.drawLine(185, 100, 185, 180); // Отрисовываем линию
        canvas.drawLine(185, 100, 168, 109); // Отрисовываем линию
//внутренний куб.
        canvas.drawLine(88, 174, 128, 200); // Отрисовываем линию
        canvas.drawLine(88, 109, 128, 84); // Отрисовываем линию
        canvas.drawLine(88, 174, 88, 109); // Отрисовываем линию
        canvas.drawLine(88, 174, 128, 150); // Отрисовываем линию
        canvas.drawLine(128, 149, 128, 84); // Отрисовываем линию

        canvas.drawLine(128, 200, 168, 174); // Отрисовываем линию
        canvas.drawLine(168, 109, 128, 84); // Отрисовываем линию
        canvas.drawLine(168, 109, 168, 174); // Отрисовываем линию
        canvas.drawLine(128, 200, 128, 218); // Отрисовываем линию
        canvas.drawLine(128, 150, 168, 174); // Отрисовываем линию
        //устанавливаем стиль и пишим текст
        canvas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        canvas.setColor(Color.PINK);
        canvas.drawString("Дюсембаева Ж.М. Вар-3", 50, 300);

        try {
            // При помощи созданной функции заливки закрашиваем две части главного овала
            // и два маленьких кружка
            fill(150, 180, Color.BLACK, Color.PINK);
            fill(150, 130, Color.BLACK, Color.PINK);
            fill(150, 200, Color.BLACK, Color.PINK);
            fill(170, 100, Color.BLACK, Color.PINK);
            fill(100, 120, Color.BLACK, Color.PINK);
            fill(100, 190, Color.BLACK, Color.PINK);
        } catch (Exception ex) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Отрисовываем панель и компоненты на ней
        g.drawImage(buff, 0, 0, this); // Отрисовываем буфер с нашим изображением на панель
    }

    private void fill(int x, int y, Color bgcolor, Color color) throws Exception {
        // Заливка фигур методом ромба, параметры: х,y- координаты начала заливки, 
        // bgcolor-цвет который надо закрашивать, color-цвет которым надо закрашивать 
        ArrayList<Point> point = new ArrayList<>(); // Создаем динамический массив точек
        point.add(new Point(x, y)); // Добавляем начальную точку в массив
        Color oldColor = canvas.getColor(); // Сохраняем старый цвет рисования
        canvas.setPaint(color); //ставим цвет закраски
        while (point.size() > 0) { // Пока в массиве имеются точки для закрашивания
            Point p = point.remove(0); // Считываем координаты первой точки, и удаляем ее из массива
            x = p.x;
            y = p.y;
            if (bgcolor.getRGB() == buff.getRGB(x, y)) { // Если ее надо нам закрасить
                canvas.drawLine(x, y, x, y); // Закрашиваем точку
                point.add(new Point(x + 1, y)); // Добавляем точку справа
                point.add(new Point(x - 1, y)); // Добавляем точку слева
                point.add(new Point(x, y + 1)); // Добавляем точку снизу
                point.add(new Point(x, y - 1)); // Добавляем точку сверху
            }
        }
        canvas.setPaint(oldColor); //ставим старый цвет рисования
        repaint();  // Перерисовываем изображение
    }
}
