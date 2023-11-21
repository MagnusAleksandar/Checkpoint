package ViewCont;

import View.VInicial;
import View.VIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtlVinc implements ActionListener {
    private VIn vin;
    private VInicial vinc;

    public CtlVinc(VIn vin, VInicial vinc) {
        this.vin = vin;
        this.vinc = vinc;

        this.vinc.ent1Btn.addActionListener(this);
        this.vinc.ent2Btn.addActionListener(this);
        this.vinc.ent3Btn.addActionListener(this);
        this.vinc.ent4Btn.addActionListener(this);
        this.vinc.ent5Btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vinc.ent1Btn) || e.getSource().equals(vinc.ent2Btn)
                || e.getSource().equals(vinc.ent3Btn) || e.getSource().equals(vinc.ent4Btn)
                || e.getSource().equals(vinc.ent5Btn))
            vin.setVisible(true);
        vinc.dispose();
    }

}
