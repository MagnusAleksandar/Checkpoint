package ViewCont;

import Model.Edificio;
import View.VAccepted;
import View.VAlreadyU;
import View.VPermEsp;
import View.VTipoUs;
import View.VIDNoValid;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlTipoUs implements ActionListener {
    private VAccepted va;
    private VAlreadyU vu;
    private VPermEsp vpe;
    private VTipoUs vtu;
    private VIDNoValid vid;

    public CtlTipoUs(VAccepted va, VPermEsp vpe, VTipoUs vtu, VIDNoValid vid) {
        this.va = va;
        this.vu = vu;
        this.vpe = vpe;
        this.vtu = vtu;
        this.vid = vid;

        this.vtu.ingBtn.addActionListener(this);
        this.vtu.regBtn.addActionListener(this);
        this.vtu.resetBtn.addActionListener(this);
    }

    private void limpiar() {
        vtu.idTxt.setText(null);
        vtu.rolUSlider.setSelectedItem("[Seleccione uno]");
        vtu.tipoEntrada.setSelectedItem("[Seleccione uno]");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rol = vtu.rolUSlider.getSelectedItem().toString();
        if (e.getSource().equals(vtu.regBtn))
            vtu.dispose();
        else if (e.getSource().equals(vtu.resetBtn))
            limpiar();
        else if (e.getSource().equals(vtu.ingBtn)) {
            if (rol.equals("[Seleccione uno]")
                    || rol.equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else if (vtu.idTxt.getText().isEmpty())
                vid.setVisible(true);
            else {
                Edificio.alrtEntrda(vtu.tipoEntrada.getSelectedItem().toString(), vtu.idTxt.getText(), null, rol, null);
                Edificio.ingPeat(vtu.idTxt.getText(), rol);
                vtu.dispose();
            }
        }

    }

}
