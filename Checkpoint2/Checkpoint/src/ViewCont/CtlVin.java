package ViewCont;

import Model.Edificio;
import View.VIn;
import View.VTipoVeh;
import View.VTipoUs;
import View.VPermEsp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlVin implements ActionListener {
    private VIn vin;
    private VTipoVeh vtv;
    private VTipoUs vtu;
    private VPermEsp vpesp;

    public CtlVin(VIn vin, VTipoVeh vtv, VTipoUs vtu, VPermEsp vpesp) {
        this.vin = vin;
        this.vtv = vtv;
        this.vtu = vtu;
        this.vpesp = vpesp;

        this.vin.ingBtn.addActionListener(this);
        this.vin.resetBtn.addActionListener(this);
        this.vin.selPeaton.addActionListener(this);
        this.vin.selVehi.addActionListener(this);
    }

    public void limpiar() {
        vin.selPeaton.setSelected(false);
        vin.selVehi.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vin.ingBtn)) {
            if(vin.selPeaton.isSelected()){
                vtu.setVisible(true);
                vin.dispose();
            }else if(vin.selVehi.isSelected()){
                vtv.setVisible(true);
                vin.dispose();
            }
            else vpesp.setVisible(true);
        }
        if (e.getSource().equals(vin.resetBtn))
            limpiar();

    }

}
