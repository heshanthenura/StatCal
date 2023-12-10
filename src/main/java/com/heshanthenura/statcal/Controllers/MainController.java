package com.heshanthenura.statcal.Controllers;

import com.heshanthenura.statcal.Entities.ClassData;
import com.heshanthenura.statcal.Services.Services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML
    private Button addBtn;

    @FXML
    private Text amLbl;

    @FXML
    private Button calBtn;

    @FXML
    private Text cwLbl;

    @FXML
    private TableColumn<ClassData,Double> dCol;

    @FXML
    private TableColumn<ClassData,Double> fCol;

    @FXML
    private TextField fInp;

    @FXML
    private TableColumn<ClassData,Double> llCol;

    @FXML
    private TextField llInp;

    @FXML
    private TableColumn<ClassData,Double> mCol;

    @FXML
    private TableView<ClassData> table;

    @FXML
    private TableColumn<ClassData,Double> ulCol;

    @FXML
    private TableColumn<ClassData,Double> cfCol;

    @FXML
    private TextField ulInp;

    @FXML
    private TableColumn<ClassData,Double> uCol;

    @FXML
    private TableColumn<ClassData,Double> uuCol;

    @FXML
    private TableColumn<ClassData,Double> fuCol;

    @FXML
    private TableColumn<ClassData,Double> fuuCol;

    @FXML
    private Text tf;

    @FXML
    private Text tfu;

    @FXML
    private Text tfuu;

    @FXML
    private Text tCF;

    @FXML
    private Text mean;

    public static ObservableList<ClassData> classDataList = FXCollections.observableArrayList();

    Logger logger = Logger.getLogger("info");

    double assumeMean=0;

    double cumulativeFrequency=0;

    double highestFrequency=0;
    double classWidth=0;
    double totalF;
    double totalFU;
    double totalFUU;
    double totalCF;

    @FXML
    void addToTable(MouseEvent event) {
        double ll = Double.parseDouble(llInp.getText());
        double ul = Double.parseDouble(ulInp.getText());
        double f = Double.parseDouble(fInp.getText());
        cumulativeFrequency+=f;
        classWidth = Math.abs(ul-ll);
        cwLbl.setText(String.valueOf(classWidth));
        if(f>highestFrequency){
            assumeMean =  (ul+ll)/2;
            highestFrequency=f;
            amLbl.setText(String.valueOf(assumeMean));
            for (int i = 0; i < classDataList.size(); i++) {
                classDataList.set(i,Services.classData(classDataList.get(i).getLowerLimit(), classDataList.get(i).getUpperLimit(), classDataList.get(i).getFrequency(),assumeMean, classDataList.get(i).getCumulativeFrequency()));
            }
        }

        classDataList.add(Services.classData(ll,ul,f,assumeMean,cumulativeFrequency));
        llInp.clear();
        ulInp.clear();
        fInp.clear();
        llInp.requestFocus();
        table.setItems(classDataList);


    }


    @FXML
    void calculate(MouseEvent event) {

        Thread tfThread = new Thread(()->{
            totalF=0;
            for (int i = 0; i < classDataList.size(); i++) {
                totalF+=classDataList.get(i).getFrequency();
            }
            tf.setText(String.valueOf(totalF));
        });
        Thread tfuThread = new Thread(()->{
            totalFU=0;
            for (int i = 0; i < classDataList.size(); i++) {
                totalFU+=classDataList.get(i).getFu();
            }
            tfu.setText(String.valueOf(totalFU));
        });
        Thread tfuuThread = new Thread(()->{
            totalFUU=0;
            for (int i = 0; i < classDataList.size(); i++) {
                totalFUU+=classDataList.get(i).getFuu();
            }
            tfuu.setText(String.valueOf(totalFUU));
        });
        Thread FThread = new Thread(()->{
            totalCF=0;
            for (int i = 0; i < classDataList.size(); i++) {
                totalCF+=classDataList.get(i).getFuu();
            }
            tCF.setText(String.valueOf(totalCF));
        });
        tfThread.start();
        tfuThread.start();
        tfuuThread.start();
        FThread.start();


        try {
            tfThread.join();
            tfuThread.join();
            tfuuThread.join();
            FThread.join();
            Services.mean(mean, assumeMean, classWidth, totalF, totalFU);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        llCol.setCellValueFactory(new PropertyValueFactory<>("lowerLimit"));
        ulCol.setCellValueFactory(new PropertyValueFactory<>("upperLimit"));
        fCol.setCellValueFactory(new PropertyValueFactory<>("frequency"));
        mCol.setCellValueFactory(new PropertyValueFactory<>("mean"));
        dCol.setCellValueFactory(new PropertyValueFactory<>("deviation"));
        cfCol.setCellValueFactory(new PropertyValueFactory<>("cumulativeFrequency"));
        uCol.setCellValueFactory(new PropertyValueFactory<>("u"));
        uuCol.setCellValueFactory(new PropertyValueFactory<>("uu"));
        fuCol.setCellValueFactory(new PropertyValueFactory<>("fu"));
        fuuCol.setCellValueFactory(new PropertyValueFactory<>("fuu"));
        table.setItems(classDataList);
    }
}
