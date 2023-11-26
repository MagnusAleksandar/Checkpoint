package ViewCont;

import View.VOut;
import View.VTipoVeh;
import View.VPermEsp;
import View.VTipoUsSal;
import View.VTipoVehSal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlVOut implements ActionListener {
    private VOut vout;
    private VTipoVehSal vtvs;
    private VTipoUsSal vtus;
    private VPermEsp vpesp;

    public CtlVOut(VOut vout, VTipoVehSal vtvs, VTipoUsSal vtus, VPermEsp vpesp) {
        this.vout = vout;
        this.vtvs = vtvs;
        this.vtus = vtus;
        this.vpesp = vpesp;

        this.vout.ingBtn.addActionListener(this);
        this.vout.resetBtn.addActionListener(this);
        this.vout.selPeaton.addActionListener(this);
        this.vout.selVehi.addActionListener(this);
    }

    public void limpiar() {
        vout.selPeaton.setSelected(false);
        vout.selVehi.setSelected(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vout.ingBtn)) {
            if (vout.selPeaton.isSelected() && !vout.selVehi.isSelected()) {
                vtus.setVisible(true);
                vout.dispose();
            } else if (vout.selVehi.isSelected() && !vout.selPeaton.isSelected()) {
                vtvs.setVisible(true);
                vout.dispose();
            } else
                vpesp.setVisible(true);
            limpiar();
        }
        if (e.getSource().equals(vout.resetBtn))
            limpiar();
        
    }

}
