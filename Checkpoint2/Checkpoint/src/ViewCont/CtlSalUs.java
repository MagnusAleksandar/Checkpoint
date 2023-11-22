package ViewCont;

import Model.Edificio;
import View.VOut;
import View.VTipoUsSal;
import View.VAlert_noIndiv;
import View.VIDNoValid;
import View.VPermEsp;
import View.VSalio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlSalUs implements ActionListener{
    private VOut vout;
    private VTipoUsSal vtus;
    private VSalio vs;
    private VAlert_noIndiv vni;
    private VIDNoValid vinv;
    private VPermEsp vpe;

    public CtlSalUs(VOut vout, VTipoUsSal vtus, VSalio vs, VAlert_noIndiv vni, VIDNoValid vinv, VPermEsp vpe) {
        this.vout = vout;
        this.vtus = vtus;
        this.vs = vs;
        this.vni = vni;
        this.vinv = vinv;
        this.vpe = vpe;
        
        this.vtus.salBtn.addActionListener(this);
        this.vtus.regBtn.addActionListener(this);
        this.vtus.resetBtn.addActionListener(this);
    }
    
    private void limpiar(){
        vtus.idTxt.setText(null);
        vtus.tipoEntrada.setSelectedItem("[Seleccione uno]");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vtus.resetBtn))
            limpiar();
        else if(e.getSource().equals(vtus.regBtn))
            vtus.dispose();
        else if(e.getSource().equals(vtus.salBtn)){
            String id=vtus.idTxt.getText();
            if(id.isEmpty())
                vinv.setVisible(true);
            else if(vtus.tipoEntrada.getSelectedItem().equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else{
                Edificio.salPeat(id, vtus.tipoEntrada.getSelectedItem().toString());
                limpiar();
                vtus.dispose();
            }
        }
    }
    
}
