package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    public void setDateLabel(Label dateLabel) {
        this.dateLabel = dateLabel;
    }

    @FXML
    private Label dateLabel;
    private Date currentDate;
    String indicateSec = ":";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String indicateSec2 = ":";
        String indicateSec3 = " ";

        Thread dateChangeThread = new Thread(() -> {
            while (true) {
                currentDate = new Date();
                Platform.runLater(() -> {
                    dateLabel.setText(changeDateLabelFromDate(currentDate));
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (indicateSec.equals(indicateSec2)) {
                    indicateSec = indicateSec3;
                } else {
                    indicateSec = indicateSec2;
                }
            }
        });
        dateChangeThread.setDaemon(true);
        dateChangeThread.start();
    }

    private String changeDateLabelFromDate(Date date) {
        return String.format( "%1$td %1$tB %1$tY %1$tH%2$s%1$tM", date, indicateSec);
    }

    //метод для получения даты формата "1 января 2019"
    private static String getDateMyFormatRUS (int month){
        String rusMonth = "";
        switch (month){
            case 1:
                rusMonth = "января";
                break;
            case 2:
                rusMonth = "февраля";
                break;
            case 3:
                rusMonth = "марта";
                break;
            case 4:
                rusMonth = "апреля";
                break;
            case 5:
                rusMonth = "мая";
                break;
            case 6:
                rusMonth = "июня";
                break;
            case 7:
                rusMonth = "июля";
                break;
            case 8:
                rusMonth = "августа";
                break;
            case 9:
                rusMonth = "сентября";
                break;
            case 10:
                rusMonth = "октября";
                break;
            case 11:
                rusMonth = "ноября";
                break;
            case 12:
                rusMonth = "декабря";
                break;
        }
        return rusMonth;
    }
}


