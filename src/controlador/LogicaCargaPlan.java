
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.JDialogCargaPlan;


public class LogicaCargaPlan implements ActionListener{
 
    private JDialogCargaPlan vistaPLC;
    private LogicaPlan logicaPlan;
    
    public LogicaCargaPlan(JDialogCargaPlan vistaPLC,LogicaPlan logicaPlan){
        
        this.vistaPLC = vistaPLC;
        this.logicaPlan = logicaPlan;
        
        
        
        this.vistaPLC.getBotonCarga().addActionListener(this);
        this.vistaPLC.getBotonVolver().addActionListener(this);
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        Object source = ae.getSource();
         
        if (source == vistaPLC.getBotonCarga() ){
           logicaPlan.guardarPlan();
           vistaPLC.dispose();
        }
        
        if(source == vistaPLC.getBotonVolver()){
            vistaPLC.dispose();
        }

    }
    
}
