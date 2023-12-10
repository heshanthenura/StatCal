package com.heshanthenura.statcal.Services;

import com.heshanthenura.statcal.Controllers.MainController;
import com.heshanthenura.statcal.Entities.ClassData;
import javafx.scene.text.Text;

import java.util.logging.Logger;

public class Services {
    Logger logger = Logger.getLogger("info");
    public static ClassData classData(double ll, double ul, double f, double assumeMean, double cumulativeFrequency){
        double mean = (ul+ll)/2;
        double deviation = mean - assumeMean;
        double u = deviation/(ul-ll);
        double uu = Math.pow(u,2);
        return new ClassData(ll,ul,f,mean,deviation,cumulativeFrequency,u,uu,(f*u),(f*uu));
    }

    public static void mean(Text text, double assumeMean, double classWidth, double totalF, double totalFU){
        text.setText(String.valueOf(assumeMean+(classWidth*(totalFU/totalF))));
    }
    public static void median(Text text, double assumeMean, double classWidth, double totalF, double totalFU){
        text.setText(String.valueOf(assumeMean+(classWidth*(totalFU/totalF))));
    }

}
