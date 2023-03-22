
package Imagenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Movimiento extends JFrame implements ActionListener, ChangeListener {
    private final JLabel imagen;
    private final JSlider slider;
    private final Timer timer;
    private int velocidad;
    private int indiceActual;
    private final ImageIcon[] imagenes;

    public Movimiento() {
        super("Animacion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        imagenes = new ImageIcon[11];   

        imagenes[0] = new ImageIcon("1.PNG");
        imagenes[1] = new ImageIcon("5.PNG");
        imagenes[2] = new ImageIcon("6.PNG");
        imagenes[3] = new ImageIcon("7.PNG");
        imagenes[4] = new ImageIcon("8.PNG");
        imagenes[5] = new ImageIcon("9.PNG");
        imagenes[6] = new ImageIcon("10.PNG");
        imagenes[7] = new ImageIcon("11.PNG");
        imagenes[8] = new ImageIcon("12.PNG");
        imagenes[9] = new ImageIcon("13.PNG");
        imagenes[10] = new ImageIcon("14.PNG");
                
        imagen = new JLabel(imagenes[0]);
        panel.add(imagen);

        slider = new JSlider(JSlider.HORIZONTAL, 1, 10, 5);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        panel.add(slider);

        velocidad = slider.getValue();
        indiceActual = 0;
        timer = new Timer(1000 / velocidad, this);

        setContentPane(panel);
        pack();
        setVisible(true);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualiza la etiqueta con la siguiente imagen de la secuencia
        indiceActual++;
        if (indiceActual >= imagenes.length) {
            indiceActual = 0;
        }
        imagen.setIcon(imagenes[indiceActual]);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // Actualiza la velocidad del temporizador 
        velocidad = slider.getValue();
        timer.setDelay(1000 / velocidad);
    }

    public static void main(String[] args) {
        new Movimiento();
    }
}
