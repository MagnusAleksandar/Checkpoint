package ViewCont;

import Model.Edificio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.VAccepted;
import View.VIDNoValid;
import View.VPermEsp;
import View.VPlacaNoValid;
import View.VTipoVeh;

public class CtlTipoVeh implements ActionListener {
    private VAccepted va;
    private VPermEsp vpe;
    private VPlacaNoValid vpnv;
    private VTipoVeh vtv;
    private VIDNoValid vid;

    public CtlTipoVeh(VPermEsp vpe, VPlacaNoValid vpnv, VTipoVeh vtv, VIDNoValid vid) {
        this.va = va;
        this.vpe = vpe;
        this.vpnv = vpnv;
        this.vtv = vtv;
        this.vid = vid;

        this.vtv.ingBtn.addActionListener(this);
        this.vtv.resetBtn.addActionListener(this);
        this.vtv.regBtn.addActionListener(this);
    }

    private void limpiar() {
        vtv.idTxt.setText(null);
        vtv.placaTxt.setText(null);
        vtv.rolUSlider.setSelectedItem("[Seleccione uno]");
        vtv.tipoVSlider.setSelectedItem("[Seleccione uno]");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rol = vtv.rolUSlider.getSelectedItem().toString();
        if (e.getSource().equals(vtv.resetBtn))
            limpiar();
        else if (e.getSource().equals(vtv.regBtn))
            vtv.dispose();
        else if (e.getSource().equals(vtv.ingBtn)) {
            if (rol.equals("[Seleccione uno]")
                    || vtv.tipoVSlider.getSelectedItem().equals("[Seleccione uno]")
                    || vtv.tipoEntrada.getSelectedItem().equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else if (vtv.idTxt.getText().isEmpty())
                vid.setVisible(true);
            else if (vtv.placaTxt.getText().isEmpty())
                vpnv.setVisible(true);
            else {
                Edificio.alrtEntrda(vtv.tipoEntrada.getSelectedItem().toString(), vtv.idTxt.getText(),
                        vtv.placaTxt.getText(), rol, vtv.tipoVSlider.getSelectedItem().toString());
                Edificio.ingVeh(vtv.idTxt.getText(), vtv.placaTxt.getText(), rol);
                limpiar();
                vtv.dispose();
            }
        }
    }

}
