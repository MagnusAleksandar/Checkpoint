package ViewCont;

import Model.Edificio;
import Model.Indiv;
import View.VOut;
import View.VAlert_noVehi;
import View.VIDNoValid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlVout implements ActionListener {
    private VOut vout;
    private VAlert_noVehi vnveh;
    private VIDNoValid vnv;

    public CtlVout(VOut vout, VAlert_noVehi vnveh, VIDNoValid vnv) {
        this.vout = vout;
        this.vnveh = vnveh;
        this.vnv = vnv;

        this.vout.salBtn.addActionListener(this);
        this.vout.resetBtn.addActionListener(this);
    }

    public void limpiar() {
        vout.idTxt.setText(null);
        vout.placaTxt.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vout.salBtn)) {
            String id = vout.idTxt.getText(), placa = vout.placaTxt.getText();
            boolean fnd = Edificio.buscar(id, placa);
            if (!id.isEmpty()) {
                if (placa.isEmpty())
                    if (fnd)
                        vnveh.setVisible(true);
                    else {
                        if (Edificio.indF(id))
                            Edificio.salPeat(id);
                    }
                else {
                    if (fnd)
                        Edificio.salVeh(id, placa);
                    else
                        vnveh.setVisible(true);
                }
                vout.dispose();
            } else
                vnv.setVisible(true);
        }
        if (e.getSource().equals(vout.resetBtn))
            limpiar();
    }

}
