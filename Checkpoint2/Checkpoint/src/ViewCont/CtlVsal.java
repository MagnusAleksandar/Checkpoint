package ViewCont;

import Model.Edificio;
import View.VSalio;
import View.VFinal;
import View.VOut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlVsal implements ActionListener {
    private VSalio vsl;
    private VFinal vfn;
    private VOut vo;

    public CtlVsal(VSalio vsl, VFinal vfn, VOut vo) {
        this.vsl = vsl;
        this.vfn = vfn;
        this.vo = vo;
        
        this.vfn.sal1Btn.addActionListener(this);
        this.vfn.sal2Btn.addActionListener(this);
        this.vfn.sal3Btn.addActionListener(this);
        this.vfn.sal4Btn.addActionListener(this);
        this.vfn.sal5Btn.addActionListener(this);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vfn.sal1Btn) || e.getSource().equals(vfn.sal2Btn)
                || e.getSource().equals(vfn.sal3Btn) || e.getSource().equals(vfn.sal4Btn)
                || e.getSource().equals(vfn.sal5Btn)){
            vsl.setVisible(true);
            Edificio.alrtSalida(vfn.sal1Btn.getName(), vo.idTxt.getText(), vo.placaTxt.getText());
        }
        vfn.dispose();
    }
    
    
}
