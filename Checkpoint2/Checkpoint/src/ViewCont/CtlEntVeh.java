package ViewCont;

import Model.Edificio;
import View.VAccepted;

import View.VPlacaNoValid;
import View.VTipoVeh;
import View.VNoRolTipo;
import View.VPermEsp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlEntVeh implements ActionListener{
    private VTipoVeh vtv;
    private VPlacaNoValid vpnv;
    private VNoRolTipo vnrt;
    private VAccepted va;
    private VPermEsp vpesp;

    public CtlEntVeh(VTipoVeh vtv, VAccepted va, VPlacaNoValid vpnv, VNoRolTipo vnrt, VPermEsp vpesp) {
        this.vtv = vtv;
        this.va = va;
        this.vpnv = vpnv;
        this.vnrt = vnrt;
        this.vpesp = vpesp;
        
        this.vtv.ingBtn.addActionListener(this);
        this.vtv.resetBtn.addActionListener(this);
        this.vtv.regBtn.addActionListener(this);
    }
    
    public void limpiar() {
        vtv.idTxt.setText(null);
        vtv.rolUSlider.setSelectedItem("[Seleccione uno]");
        vtv.tipoVSlider.setSelectedItem("[Seleccione uno]");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String placa="";
        if(e.getSource().equals(vtv.regBtn)){
            limpiar();
            vtv.dispose();
        }else if(e.getSource().equals(vtv.resetBtn))
            limpiar();
        else if(e.getSource().equals(vtv.ingBtn)){
            if(vtv.idTxt.getText().isEmpty())
                vpnv.setVisible(true);
            else if(vtv.rolUSlider.getSelectedItem().equals("[Seleccione uno]")||vtv.tipoVSlider.getSelectedItem().equals("[Seleccione uno]"))
                vnrt.setVisible(true);
            else{
                if(!vtv.tipoVSlider.getSelectedItem().equals("Bicicleta")){
                    placa=vtv.placaTxt.getText();
                }
                    if(vtv.rolUSlider.getSelectedItem().equals("Administrativo"))
                        Edificio.ingVeh(vtv.idTxt.getText(), placa, "admon");
                    else if(vtv.rolUSlider.getSelectedItem().equals("Docente")||vtv.rolUSlider.getSelectedItem().equals("Estudiante")){
                        vtv.permEspTxt.setEnabled(true);
                        vtv.selNo.setEnabled(true);
                        vtv.selSi.setEnabled(true);
                        if(vtv.selSi.isSelected()){
                            if(vtv.rolUSlider.getSelectedItem().equals("Docente"))
                                Edificio.ingVeh(vtv.idTxt.getText(), placa, "espdoc");
                            else if(vtv.rolUSlider.getSelectedItem().equals("Estudiante"))
                                Edificio.ingVeh(vtv.idTxt.getText(), placa, "espest");
                        }else if(vtv.selNo.isSelected()){
                            if(vtv.rolUSlider.getSelectedItem().equals("Docente"))
                                Edificio.ingVeh(vtv.idTxt.getText(), placa, "normdoc");
                            else if(vtv.rolUSlider.getSelectedItem().equals("Estudiante"))
                                Edificio.ingVeh(vtv.idTxt.getText(), placa, "normest");
                        }else vpesp.setVisible(true);
                    }else if(vtv.rolUSlider.getSelectedItem().equals("Vigilante"))
                        Edificio.ingVeh(vtv.idTxt.getText(), placa, "segur");
                    else if(vtv.rolUSlider.getSelectedItem().equals("Visitante"))
                        Edificio.ingVeh(vtv.idTxt.getText(), placa, "visit");
                
            }
        }
    }
    
}
