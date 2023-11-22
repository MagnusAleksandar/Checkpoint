package ViewCont;

import Model.Edificio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.VAccepted;
import View.VAlreadyU;
import View.VIDNoValid;
import View.VPermEsp;
import View.VPlacaNoValid;
import View.VTipoVeh;

public class CtlTipoVeh implements ActionListener {
    private VAccepted va;
    private VAlreadyU vu;
    private VPermEsp vpe;
    private VPlacaNoValid vpnv;
    private VTipoVeh vtv;
    private VIDNoValid vid;

    public CtlTipoVeh(VAccepted va, VAlreadyU vu, VPermEsp vpe, VPlacaNoValid vpnv, VTipoVeh vtv, VIDNoValid vid) {
        this.va = va;
        this.vu = vu;
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
        if (e.getSource().equals(vtv.resetBtn))
            limpiar();
        else if (e.getSource().equals(vtv.regBtn))
            vtv.dispose();
        else if (e.getSource().equals(vtv.ingBtn)) {
            if (vtv.rolUSlider.getSelectedItem().equals("[Seleccione uno]")
                    || vtv.tipoVSlider.getSelectedItem().equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else if (vtv.idTxt.getText().equals(null))
                vid.setVisible(true);
            else if (vtv.placaTxt.getText().equals(null))
                vpnv.setVisible(true);
            else {
                String rol = "";
                if (vtv.rolUSlider.getSelectedItem().equals("Docente")
                        || vtv.rolUSlider.getSelectedItem().equals("Estudiante")) {
                    vtv.permEspTxt.setEnabled(true);
                    vtv.selSi.setEnabled(true);
                    vtv.selNo.setEnabled(true);
                    if (vtv.selNo.isSelected())
                        rol = "noPerm";
                    else if (vtv.selSi.isSelected())
                        rol = "perm";
                    else
                        vpe.setVisible(true);
                } else
                    rol = vtv.rolUSlider.getSelectedItem().toString();
                Edificio.alrtEntrda(rol, vtv.idTxt.getText(), vtv.placaTxt.getText());
                Edificio.ingVeh(vtv.idTxt.getText(), vtv.placaTxt.getText(), rol);
                va.setVisible(true);
            }
        }
    }

}
