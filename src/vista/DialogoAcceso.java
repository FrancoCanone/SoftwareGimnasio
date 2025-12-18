
package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class DialogoAcceso extends JDialog {

    private final JLabel mensaje;

    public DialogoAcceso(Frame parent) {
        super(parent, true); // modal
        setSize(350, 180);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        mensaje = new JLabel("", SwingConstants.CENTER);
        mensaje.setFont(new Font("Arial", Font.BOLD, 20));
        add(mensaje, BorderLayout.CENTER);

        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    }

    public void mostrar(String texto, boolean permitido) {
        mensaje.setText(texto);

        if (permitido) {
            getContentPane().setBackground(new Color(0, 170, 0));
        } else {
            getContentPane().setBackground(new Color(200, 0, 0));
        }

        // Cerrar solo después de 5 segundos
        Timer t = new Timer(5000, e -> dispose());
        t.setRepeats(false);
        t.start();

        setVisible(true);
    }

    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
