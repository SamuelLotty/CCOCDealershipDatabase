import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class AlertOrder extends Stage {
	
	private boolean cancel = false;
    private EventHandler<ActionEvent> yesAction = null;
    private EventHandler<ActionEvent> noAction = null;
    public AlertOrder (String title, String message) {
    	
    	initModality(Modality.APPLICATION_MODAL);
    	setTitle(title);
    	setHeight(200);
    	setWidth(300);
    	
    	VBox root = new VBox();
    	root.setPadding(new Insets(0,5,5,10));
    	Label warning = new Label(message);
    	Label space = new Label("");
    	HBox buttonLay = new HBox();
    	Button yesButton = new Button("Yes");
    	Button noButton = new Button("No");
    	
    	yesButton.setOnAction(e->{
    		cancel = false;
    		yesAction.handle(new ActionEvent());
    	});
    	noButton.setOnAction(e->{
    		cancel = true;
    		noAction.handle(new ActionEvent());
    	});
    	buttonLay.getChildren().addAll(yesButton,noButton);
    	
    	root.getChildren().addAll(warning,space,buttonLay);
    	root.setAlignment(Pos.CENTER);
    	
    	Scene scene = new Scene(root);
    	setScene(scene);
    	
    }
    	 public void setYesAction(EventHandler<ActionEvent> yesAction){
    	        this.yesAction = yesAction;
    	    }
    	    public void setNoAction(EventHandler<ActionEvent> noAction){
    	        this.noAction = noAction;
    	    }

    	    public boolean isCanceled(){
    	        return cancel;
    	    }
    	
    	
    }

