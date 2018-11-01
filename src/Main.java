import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage primaryStage) {

        listeDimage.add(new Image("file:mario0.jpg"));listeDimage.add(new Image("file:mario1.jpg"));listeDimage.add(new Image("file:mario2.jpg"));listeDimage.add(new Image("file:mario3.jpg"));
        listeDimage.add(new Image("file:mario4.jpg"));listeDimage.add(new Image("file:mario5.jpg"));listeDimage.add(new Image("file:mario6.jpg"));listeDimage.add(new Image("file:mario7.jpg"));
        listeDimage.add(new Image("file:mario8.jpg"));
        GridPane gridPane = new GridPane();
        Scene root = new Scene(gridPane);
        reshuffle(gridPane);

        root.setOnKeyPressed(event -> {
            if (event.getCode()== KeyCode.M && event.isControlDown()){
                reshuffle(gridPane);
            }
        });

        primaryStage.setScene(root);
        primaryStage.setTitle("Puzzle");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    private void reshuffle  (GridPane gridPane){

        List<Image> listeDimage = new ArrayList<>();
        listeDimage.add(new Image("file:mario0.jpg"));listeDimage.add(new Image("file:mario1.jpg"));listeDimage.add(new Image("file:mario2.jpg"));listeDimage.add(new Image("file:mario3.jpg"));
        listeDimage.add(new Image("file:mario4.jpg"));listeDimage.add(new Image("file:mario5.jpg"));listeDimage.add(new Image("file:mario6.jpg"));listeDimage.add(new Image("file:mario7.jpg"));
        listeDimage.add(new Image("file:mario8.jpg"));

        Collections.shuffle(listeDimage);

        for (int i =0 ;i<listeDimage.size();i++)
            imageViews.add(i,new ImageView(listeDimage.get(i)));

        gridPane.add(imageViews.get(0),0,0);gridPane.add(imageViews.get(1),1,0);
        gridPane.add(imageViews.get(2),2,0);gridPane.add(imageViews.get(3),0,1);
        gridPane.add(imageViews.get(4),1,1);gridPane.add(imageViews.get(5),2,1);
        gridPane.add(imageViews.get(6),0,2);gridPane.add(imageViews.get(7),1,2);
        gridPane.add(imageViews.get(8),2,2);


        dragEtDrop(gridPane);
    }

    private void dragEtDrop (GridPane gridPane){
        for (ImageView imageView : imageViews) {


        imageView.setOnDragDetected(event -> {
            Dragboard dragboard = imageView.startDragAndDrop(TransferMode.ANY);
            ClipboardContent clipboardContent = new ClipboardContent();
            clipboardContent.putString("");
            dragboard.setContent(clipboardContent);
        });


        imageView.setOnDragDropped(event -> {

            ImageView source = (ImageView)event.getGestureSource();
            Image tempoSource =  imageView.getImage();
            imageView.setImage(source.getImage());
            source.setImage(tempoSource);
            event.setDropCompleted(true);


        });
        imageView.setOnDragDone(event -> {
         winnerWinnerChickenDinner(gridPane);
        });

        imageView.setOnDragOver(event -> event.acceptTransferModes(TransferMode.ANY));
    }}
    private void winnerWinnerChickenDinner(GridPane gridPane){
        System.out.println("test");
        boolean echec = true;
        solution.add(new ImageView("file:mario0.jpg"));solution.add(new ImageView("file:mario1.jpg"));solution.add(new ImageView("file:mario2.jpg"));solution.add(new ImageView("file:mario3.jpg"));
        solution.add(new ImageView("file:mario4.jpg"));solution.add(new ImageView("file:mario5.jpg"));solution.add(new ImageView("file:mario6.jpg"));solution.add(new ImageView("file:mario7.jpg"));
        solution.add(new ImageView("file:mario8.jpg"));

            if (solution.equals(gridPane.getChildren().contains(solution.get(0))))
                echec = false;

        if (echec == false){
            Alert alerte = new Alert(Alert.AlertType.INFORMATION);
            alerte.setTitle("Attention");
            alerte.setHeaderText("Bravo champignon");
            alerte.showAndWait();
        }
        if (echec){
        }
    }
    private List<ImageView> imageViews = new ArrayList<>();
    private List<Image> listeDimage = new ArrayList<>();
    private List<ImageView> solution = new ArrayList<>();


}
