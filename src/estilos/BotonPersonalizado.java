package estilos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class BotonPersonalizado extends JButton {

    private Color colorNormal = new Color(255, 255, 255);   // Fondo Blanco
    private Color colorHover = new Color(204, 204, 204);   // Presionar Gris
    private int radio = 25; // Bordes redondeados

    
    public BotonPersonalizado() {
        this("Botón");
    }

    
    public BotonPersonalizado(String texto) {
        super(texto);
        setBackground(colorNormal);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);

        // Efecto al pasar el mouse 
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radio, radio);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(0, 0, getWidth() - 0, getHeight() - 0, radio, radio);
        g2.dispose();
    }

    public void setColorNormal(Color color) {
        this.colorNormal = color;
        setBackground(color);
    }

    public void setColorHover(Color color) {
        this.colorHover = color;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
}