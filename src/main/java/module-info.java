module com.heshanthenura.statcal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.heshanthenura.statcal to javafx.fxml;
    exports com.heshanthenura.statcal;
    exports com.heshanthenura.statcal.Controllers;
    opens com.heshanthenura.statcal.Controllers to javafx.fxml;
    opens com.heshanthenura.statcal.Entities;
}