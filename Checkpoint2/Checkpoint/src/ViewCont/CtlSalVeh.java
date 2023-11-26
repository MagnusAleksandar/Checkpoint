package ViewCont;

import Model.Edificio;
import View.VOut;
import View.VTipoVehSal;
import View.VAlert_noIndiv;
import View.VIDNoValid;
import View.VPermEsp;
import View.VPlacaNoValid;
import View.VSalio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlSalVeh implements ActionListener{
    private VOut vout;
    private VTipoVehSal vtv;
    private VSalio vs;
    private VAlert_noIndiv vni;
    private VIDNoValid vinv;
    private VPlacaNoValid vpnv;
    private VPermEsp vpe;

    public CtlSalVeh(VOut vout, VTipoVehSal vtvs, VSalio vs, VAlert_noIndiv vni, VIDNoValid vinv, VPlacaNoValid vpnv, VPermEsp vpe) {
        this.vout = vout;
        this.vtv = vtvs;
        this.vs = vs;
        this.vni = vni;
        this.vinv = vinv;
        this.vpnv = vpnv;
        this.vpe = vpe;
        
        this.vtv.salBtn.addActionListener(this);
        this.vtv.regBtn.addActionListener(this);
        this.vtv.resetBtn.addActionListener(this);
    }
    
    private void limpiar(){
        vtv.idTxt.setText(null);
        vtv.placaTxt.setText(null);
        vtv.tipoEntrada.setSelectedItem("[Seleccione uno]");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vtv.resetBtn))
            limpiar();
        else if(e.getSource().equals(vtv.regBtn))
            vtv.dispose();
        else if(e.getSource().equals(vtv.salBtn)){
            String id=vtv.idTxt.getText(), placa=vtv.placaTxt.getText();
            if(id.isEmpty())
                vinv.setVisible(true);
            else if(placa.isEmpty())
                vpnv.setVisible(true);
            else if(vtv.tipoEntrada.getSelectedItem().equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else {
                Edificio.salVeh(id, placa, vtv.tipoEntrada.getSelectedItem().toString());
                limpiar();
                vtv.dispose();
            }
        }
    }
    
}
