package com.session;
import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean
public class zakatfitrah {  
    DecimalFormat a = new DecimalFormat("0.0");
    String hasil;
    public String perhitungan(double wajib) {
        return hasil  = a.format(wajib * 2.5);
    }
    
    public String perhitunganuang(double wajib, double harga) {
        return hasil  = a.format((wajib * harga));
    }
}
