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

    public CtlTipoUs(VAccepted va, VAlreadyU vu, VPermEsp vpe, VTipoUs vtu, VIDNoValid vid) {
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
        String rol = "";
        if (e.getSource().equals(vtu.regBtn))
            vtu.dispose();
        else if (e.getSource().equals(vtu.resetBtn))
            limpiar();
        else if (e.getSource().equals(vtu.ingBtn)) {
            if (vtu.rolUSlider.getSelectedItem().equals("[Seleccione uno]")
                    || vtu.tipoEntrada.getSelectedItem().equals("[Seleccione uno]"))
                vpe.setVisible(true);
            else if (vtu.idTxt.getText().isEmpty())
                vid.setVisible(true);
            else if (!vtu.rolUSlider.getSelectedItem().equals("Docente")
                    || !vtu.rolUSlider.getSelectedItem().equals("Estudiante"))
                rol = vtu.rolUSlider.getSelectedItem().toString();
        } else if (vtu.rolUSlider.getSelectedItem().equals("Docente")
                || vtu.rolUSlider.getSelectedItem().equals("Estudiante")) {
            vtu.permEspTxt.setEnabled(true);
            vtu.selSi.setEnabled(true);
            vtu.selNo.setEnabled(true);
            if (vtu.selNo.isSelected())
                rol = "noPerm";
            else if (vtu.selSi.isSelected())
                rol = "perm";
            else
                vpe.setVisible(true);
        }
        Edificio.alrtEntrda(rol, vtu.idTxt.getText(), null);
        Edificio.ingPeat(vtu.idTxt.getText(), rol);
        vtu.dispose();

    }

}
