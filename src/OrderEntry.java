import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.collections.*;
import javafx.collections.transformation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OrderEntry extends Application{
	OrderEntry window,view;

	
	List <Orders>list = new ArrayList<>();
	static List <Stock> list1 = new ArrayList<>();
	static List <Orders>list2 = new ArrayList<>();
	
	private final Label lblName = new Label("Search by Name");
	private static ObservableList<Orders> ObservableOrders;

	private ObservableList<Orders> ObservableOrder;
	private static ObservableList<Stock> ObservableStock;
	
	
	//TableView<Orders> TableView = new TableView<>();
	TableView<Orders> TableView = new TableView<>();
	
	private final GridPane gridPane = new GridPane();

	public OrderEntry() {
	
	
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC driver loaded");
		} catch (Exception err) {
			System.err.println("Error loading JDBC driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		Connection databaseConnection = null;
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=SLottyMunsterCarSales;encrypt=true;trustServerCertificate=true;user=samuel.lotty@morrisonsislandcampus.com;password=07072000Ss?";
			System.out.println(connectionUrl);
			
			databaseConnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected to the database");
			
			String queryString = "select * from Dealership";
			System.out.println(queryString);
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(queryString);
			ResultSet rset = preparedStatement.executeQuery();
		}
			
			//Read in Orders table
			/*while (rset.next()) {
				//Orders o = new Orders();
	
				int OrdNumber = rset.getInt("DealershipNumber");
				int StockNumber = rset.getInt("DealershipLocation");
				int Quantity = rset.getInt("NumberOfCars");
				String Worker = rset.getString("NumberOfStaff");
			//	String DealershipLocation = rset.getString(DealershipLocation);
				
				o.setOrdID(rset.getInt("OrdID"));
				o.setStockID(rset.getInt("StockID"));
				o.setQuantOrd(rset.getInt("QuantOrd"));
				o.setWorkerName(rset.getString("WorkerName"));
				//o.setDealershipLocation(rset.getString(DealershipLocation));
				
				
				list.add(o);
				System.out.println("found one "  + o);
			}
		}*/
			
		 catch (Exception e) {
			e.printStackTrace();
		 //}
		 }
		
			//Read in Stock table
			try {

				BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
				
				String connectionUrl1 = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=SLOffice;encrypt=true;trustServerCertificate=true;user=samuel.lotty@morrisonsislandcampus.com;password=07072000Ss?";
				System.out.println(connectionUrl1);
				
				databaseConnection = DriverManager.getConnection(connectionUrl1);
				System.out.println("Connected to the database");
				
				String queryString1 = "select * from Dealership";
				System.out.println(queryString1);
				PreparedStatement preparedStatement1 = databaseConnection.prepareStatement(queryString1);
				ResultSet rset1 = preparedStatement1.executeQuery();
		
			while (rset1.next()) {
				Orders s = new Orders();
				
				int DealershipNumber = rset1.getInt("DealershipNumber");
				int CarsSold = rset1.getInt("CarsSold");
				int NumberOfStaff = rset1.getInt("NumberOfStaff");
				String Location = rset1.getString("DealershipLocation");
				
				s.setDealershipNumber(rset1.getInt("DealershipNumber"));
				s.setDealershipLocation(rset1.getString("DealershipLocation"));
				s.setNumberOfStaff(rset1.getInt("NumberOfStaff"));
				s.setCarsSold(rset1.getInt("CarsSold"));
				
				
				list.add(s);
				System.out.println("found one "+ s);
			}
			}
			catch (Exception w) {
				w.printStackTrace();
			}
			try {

				BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
				
				String connectionUrl1 = "jdbc:sqlserver://sql.coccork.ie:8080;databaseName=SLottyMunsterCarSales;encrypt=true;trustServerCertificate=true;user=samuel.lotty@morrisonsislandcampus.com;password=07072000Ss?";
				System.out.println(connectionUrl1);
				
				databaseConnection = DriverManager.getConnection(connectionUrl1);
				System.out.println("Connected to the database");
				
				String queryString1 = "select * from Dealership";
				System.out.println(queryString1);
				PreparedStatement preparedStatement1 = databaseConnection.prepareStatement(queryString1);
				ResultSet rset1 = preparedStatement1.executeQuery();
		
			while (rset1.next()) {
				Orders o = new Orders();
				
				String name = rset1.getString("DealershipLocation");
				int DealershipNumber = rset1.getInt("DealershipNumber");
				int CarsSold = rset1.getInt("CarsSold");
				int NumberOfStaff = rset1.getInt("NumberOfStaff");
				
				o.setDealershipNumber(rset1.getInt("DealershipNumber"));
				o.setDealershipLocation(rset1.getString("DealershipLocation"));
				o.setNumberOfStaff(rset1.getInt("NumberOfStaff"));
				o.setCarsSold(rset1.getInt("CarsSold"));
				
				list.add(o);
				System.out.println("found one "+ o);
			}
			}
			catch (Exception w) {
				w.printStackTrace();
			}
		lblName.setTextFill(Color.web("#0076a3"));
		ObservableOrders = FXCollections.observableArrayList(list);
		}
	
	

	
	@Override
	public void start(Stage stage) {
		//Create start menu
		stage.setTitle("Start Menu");
		Label label = new Label("Select Option!");
		
		Button Add = new Button("Add");
		Add.setOnAction(e->{
			AddInfo(window);
		});
		Button Delete = new Button("Delete");
		Delete.setOnAction(e->{
			DeleteInfo(stage);
		});
		Button Modify = new Button("Modify");
		Modify.setOnAction(e->{
			ModifyInfo(stage);
		});
		Button View = new Button("View Tables");
		View.setOnAction(e->{
			viewInfo(stage);
		});
		Button view1 = new Button("View one order");
		view1.setOnAction(e->{
			viewoneOrder(stage);
		});
		Button help = new Button("Help");
		help.setOnAction(e->{
			helpMenu();
		});
		
		GridPane grid = new GridPane();
		grid.add(Add, 1, 1);grid.add(Delete, 2, 1);
		grid.add(Modify, 1, 2);grid.add(View, 2, 2);
		grid.add(help, 4, 4);grid.add(view1, 1, 3);
		grid.setHgap(15);
		grid.setVgap(15);
		
		VBox vbox = new VBox(label,grid);
		
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}
	public void AddInfo(OrderEntry window) {
		//add order
		this.window= window;
		Stage Add = new Stage();
		Add.setTitle("Add");
		Label addordNo = new Label("New order number:");
		Label addstockNo = new Label("New stock item number:");
		Label addNumberOfStaff = new Label("New Quantity ordered:");
		Label addworkername = new Label ("New worker name:");
		
		TextField addordNo1 = new TextField();
		TextField addstockNo1 = new TextField();
		TextField addquant = new TextField();
		TextField addname = new TextField();
		
		Button help = new Button("Help");
		help.setOnAction(e->{
			helpMenu();
		});
		Button back = new Button("back");
		back.setOnAction(e->{
			Add.close();
			start(Add);
		});
		Button enter1 = new Button("Enter");
		enter1.setOnAction(e->{
			
			Connection dbconnect = OrderEntry.dbConnection();
			String insertSql = "INSERT INTO SLOrders "+ "VALUES (" +
			
			Integer.parseInt(addordNo1.getText())+ ",'"+
			Integer.parseInt(addstockNo1.getText())+"','"+
			Integer.parseInt(addquant.getText())+"', '"+
			addname.getText()+"')";
			
				System.out.println(insertSql);
				try {
					PreparedStatement preparedStatement = dbconnect.prepareStatement(insertSql);
					preparedStatement.executeUpdate();
					System.out.println("Record Inserted");
					AlertOrder alert = new AlertOrder("Done","The record has been entered into the table!");
				}catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println("Query executed");
		});
		
		GridPane grid4 = new GridPane();
		grid4.add(addordNo, 1, 1);grid4.add(addordNo1, 2, 1);
		grid4.add(addstockNo, 1, 2);grid4.add(addstockNo1, 2, 2);
		grid4.add(addNumberOfStaff, 1, 3);grid4.add(addquant, 2,3);
		grid4.add(addworkername, 1, 4);grid4.add(addname, 2, 4);
		grid4.add(back, 1, 5);grid4.add(help, 4, 5);grid4.add(enter1, 2, 5);
		Scene scene5 = new Scene(grid4);
		Add.setScene(scene5);
		Add.show();
	}
	public void DeleteInfo(Stage delete) {
		//Delete order
		
		delete.setTitle("Delete");
		Label delorderno = new Label("Enter order number for deletion:");
		TextField delord = new TextField();
		
		Button help = new Button("Help");
		help.setOnAction(e->{
			helpMenu();
		});
		Button back = new Button("back");
		back.setOnAction(e->{
			delete.close();
			start(delete);
		});
		Button enter1 = new Button("Enter");
		enter1.setOnAction(x->{
		AlertOrder alert = new AlertOrder("Confirm","Are you sure you want to delete?");
		alert.setYesAction(e->{
			Connection dbconnect = OrderEntry.dbConnection();
			int delorderno1 = Integer.parseInt(delord.getText());
				System.out.println(delorderno1);
			String removeSql = "Delete from SLOrders WHERE OrdID =";
			removeSql += delorderno1;
				System.out.println(removeSql);
			try {
				PreparedStatement preparedStatement = dbconnect.prepareStatement(removeSql);
				preparedStatement.executeUpdate();//Execute
				System.out.println("Record Deleted!");
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
			
		});
		alert.setNoAction(e->{
			alert.close();
		});
		alert.showAndWait();
		});
			
			GridPane grid6 = new GridPane();
			grid6.add(delorderno, 1, 1);grid6.add(delord, 2, 1);
			grid6.add(help, 3, 3);grid6.add(back, 1, 3);grid6.add(enter1, 2, 3);
			Scene scene6 = new Scene(grid6);
			delete.setScene(scene6);
			delete.show();
		
	}
	public void ModifyInfo(Stage modify) {
		//Modify an order from order menu
		modify.setTitle("Modify order details");
		
		Label orderno = new Label("Order Number:");
		TextField ordernoA = new TextField();
		Label Worker = new Label ("Office worker name:");
		TextField WorkerA = new TextField();
		
		Button back1 = new Button("Back");
		back1.setOnAction(e->{
		modify.close();
		start(modify);
		});
		Button modify1 = new Button("Modify");
		modify1.setOnAction(e->{
			//Modify create
			
			Connection dbconnect = OrderEntry.dbConnection();
			String mod = ordernoA.getText();
			int ordid = Integer.parseInt(mod);
			String select = " SELECT * FROM SLOrders WHERE OrdID = "+ ordid +";";
			ResultSet result = OrderEntry.runQuery(select);
			
			try {
			if (result.next()) {
				String modSql = "Update SLOrders SET ";
				Boolean comma = false;
				if (!WorkerA.getText().isEmpty()) {
					modSql +="WorkerName = '" + WorkerA.getText()+ "'";
					 comma = true;
				};
			String mod1 = modSql + " WHERE OrdID = "+ ordid + ";";
				System.out.println(mod1);
				System.out.println("Done the record has been updated");
				PreparedStatement preparedStatement = dbconnect.prepareStatement(mod1);
				preparedStatement.execute();
				modify.close();
				ModifyInfo(modify);
		}	else {
			System.out.println("There has been an error!");
			}
			}	catch (SQLException e1) {
				e1.printStackTrace();
			}
			
	});
		Button help = new Button("Help");
		help.setOnAction(e->{
			helpMenu();
		});
		
		GridPane grid2 = new GridPane();
		grid2.add(orderno,1,1);grid2.add(ordernoA, 2, 1);
		grid2.add(Worker, 1, 2);grid2.add(WorkerA, 2, 2);
		grid2.add(back1, 1, 3);grid2.add(modify1, 2, 3);
		grid2.add(help, 3, 4);
		
		grid2.setHgap(15);
		grid2.setVgap(15);
		
		Scene scene3 = new Scene(grid2);
		modify.setScene(scene3);
		modify.show();
		
	}
	public void viewInfo (Stage info) {
		//Select what table you want to view
		info.setTitle("View Tables");
		Label label1 = new Label("What table would you like to see!");
		Button stock = new Button("View Stock");
		stock.setOnAction(e->{
			viewStock(info);
		});
		Button order = new Button("View Orders");
		order.setOnAction(e->{
		//	viewOrders(info);
		});
		Button back = new Button("back");
		back.setOnAction(e->{
			info.close();
			start(info);
		});
		
		GridPane grid1 = new GridPane();
		grid1.add(label1, 1, 1);
		grid1.add(stock, 1, 2);grid1.add(order, 2, 2);
		grid1.add(back, 2, 3);
		grid1.setHgap(10);grid1.setVgap(10);
		VBox vbox1 = new VBox(grid1);
		
		Scene scene1 = new Scene(vbox1);
		info.setScene(scene1);
		info.show();
	}
	public static Alert helpMenu() {
		//Help menu across all menus
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeight(400);
		alert.setTitle("Help Menu");
		alert.setHeaderText("Information and help");
		alert.setContentText("Please select one of the buttons on the main menu!\n"
				+ "Add button allows you to add information into the tables!\n"
				+ "Delete button allows you to delete information from the tables!\n"
				+ "Modify button allows you to modify information within those tables!\n");
		alert.showAndWait();
		return alert;
	}
	public static Alert deletion() {
		//Deletion alert menu
		Alert alert1 = new Alert(AlertType.WARNING);
		alert1.setHeight(200);
		alert1.setTitle("Delete Warning!");
		alert1.setHeaderText("Warning you are deleting this order!");
		alert1.setContentText("Are you sure you want to delete this order!");
		alert1.getButtonTypes().addAll(ButtonType.NO);
		alert1.showAndWait();
		return alert1;
		
	}
	public void viewStock(Stage StockView) {
		//view Stock table
		StockView.setTitle("Stock view table");
		ObservableOrders = FXCollections.observableArrayList(list);
		TableView<Orders> Table = new TableView<>();
		
		TableColumn<Orders ,Integer> DealershipNumber = new TableColumn<>("DealershipNumber");
		DealershipNumber.setMaxWidth(100);
		Table.getColumns().add(DealershipNumber);
		DealershipNumber.setCellValueFactory(new PropertyValueFactory<>("DealershipNumber"));
		
		TableColumn<Orders ,Integer> CarsSold = new TableColumn<>("Cars Sold");
		CarsSold.setMaxWidth(100);
		Table.getColumns().add(CarsSold);
		CarsSold.setCellValueFactory(new PropertyValueFactory<>("CarsSold"));
		
		TableColumn<Orders ,Integer> NumberOfStaff = new TableColumn<>("Number of Staff");
		NumberOfStaff.setMaxWidth(100);
		Table.getColumns().add(NumberOfStaff);
		NumberOfStaff.setCellValueFactory(new PropertyValueFactory<>("NumberOfStaff"));
		
		TableColumn<Orders ,String> DealershipLocation = new TableColumn<>("Dealership Location");
		DealershipLocation.setMaxWidth(200);
		Table.getColumns().add(DealershipLocation);
		DealershipLocation.setCellValueFactory(new PropertyValueFactory<>("DealershipLocation"));
		
		Button back1 = new Button("Back");
		back1.setOnAction(e->{
			StockView.close();
			viewInfo(StockView);
		});
		
		Table.setItems(ObservableOrders);
		Table.setEditable(false);
		
		HBox hbox = new HBox(15);
		hbox.setPadding(new Insets(0,20,60,60));
		hbox.getChildren().addAll(back1);
		
		BorderPane borderpane = new BorderPane(Table);
		borderpane.setBottom(back1);
		Scene scene2 = new Scene(borderpane,800,300);
		StockView.setScene(scene2);
		StockView.show();
		
	}
	/*public void  viewOrders(Stage OrderView) {
		//View order table
		OrderView.setTitle("Orders View");
		ObservableOrders = FXCollections.observableArrayList(list);
		TableView<Orders> Table1 = new TableView<>();
		
		
		TableColumn<Orders ,Integer> OrdID = new TableColumn<>("Order Number");
		OrdID.setMaxWidth(100);
		Table1.getColumns().add(OrdID);
		OrdID.setCellValueFactory(new PropertyValueFactory<>("OrdID"));
		
		TableColumn<Orders ,String> DealershipLocation = new TableColumn<>("Item Name");
		DealershipLocation.setMaxWidth(200);
		Table1.getColumns().add(DealershipLocation);
		DealershipLocation.setCellValueFactory(new PropertyValueFactory<>("DealershipLocation"));
		
		TableColumn<Orders ,Integer> StockID = new TableColumn<>("Stock Number");
		StockID.setMaxWidth(100);
		Table1.getColumns().add(StockID);
		StockID.setCellValueFactory(new PropertyValueFactory<>("StockID"));
		
		TableColumn<Orders ,Integer> QuantOrd = new TableColumn<>("Order Quantity");
		QuantOrd.setMaxWidth(100);
		Table1.getColumns().add(QuantOrd);
		QuantOrd.setCellValueFactory(new PropertyValueFactory<>("QuantOrd"));
		
		TableColumn<Orders ,String> WorkerName = new TableColumn<>("Worker Name");
		WorkerName.setMaxWidth(200);
		Table1.getColumns().add(WorkerName);
		WorkerName.setCellValueFactory(new PropertyValueFactory<>("WorkerName"));
		
		Button back1 = new Button("Back");
		back1.setOnAction(e->{
			OrderView.close();
			viewInfo(OrderView);
		});
		
		Table1.setItems(ObservableOrders);
		Table1.setEditable(false);
		BorderPane borderpane1 = new BorderPane(Table1);
		borderpane1.setBottom(back1);
		Scene scene3 = new Scene(borderpane1,800,300);
		OrderView.setScene(scene3);
		OrderView.show();
		
	}*/
	public void viewoneOrder(Stage viewoneOrder) {
		//View one order specifically
		viewoneOrder.setTitle("View one order");
		Label question = new Label("Enter order number");
		TextField answer = new TextField();
		
		Button back1 = new Button("Back");
		back1.setOnAction(e->{
			viewoneOrder.close();
			viewInfo(viewoneOrder);
		});
		Button help = new Button("Help");
		help.setOnAction(e->{
			helpMenu();
		});
		Button enter = new Button("Search");
		enter.setOnAction(e->{		
			//Selecting what order you want to view
				int order1 = Integer.parseInt(answer.getText());
				ObservableOrders = FXCollections.observableArrayList(list);
				
				Connection dbconnect = OrderEntry.dbConnection();
				String queryString = "select * from Dealership WHERE DealershipNumber = "+order1+"" ;
				System.out.println(queryString);
				PreparedStatement preparedStatement;
				try {
					preparedStatement = dbconnect.prepareStatement(queryString);
					ResultSet rset = preparedStatement.executeQuery();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				TableView<Orders> Table1 = new TableView<>();
				TableColumn<Orders ,Integer> DealershipNumber = new TableColumn<>("Dealership Number");
				DealershipNumber.setMaxWidth(100);
				Table1.getColumns().add(DealershipNumber);
				DealershipNumber.setCellValueFactory(new PropertyValueFactory<>("DealershipNumber"));
				
				TableColumn<Orders ,String> DealershipLocation = new TableColumn<>("Dealership Location");
				DealershipLocation.setMaxWidth(200);
				Table1.getColumns().add(DealershipLocation);
				DealershipLocation.setCellValueFactory(new PropertyValueFactory<>("DealershipLocation"));
				
				TableColumn<Orders ,Integer> CarsSold = new TableColumn<>("Cars Sold");
				CarsSold.setMaxWidth(100);
				Table1.getColumns().add(CarsSold);
				CarsSold.setCellValueFactory(new PropertyValueFactory<>("CarsSold"));
				
				TableColumn<Orders ,Integer> NumberOfStaff = new TableColumn<>("Number of Staff");
				NumberOfStaff.setMaxWidth(100);
				Table1.getColumns().add(NumberOfStaff);
				NumberOfStaff.setCellValueFactory(new PropertyValueFactory<>("NumberOfStaff"));
				
				TableColumn<Orders ,Integer> NumberOfCars = new TableColumn<>("Number of Cars");
				NumberOfCars.setMaxWidth(200);
				Table1.getColumns().add(NumberOfCars);
				NumberOfCars.setCellValueFactory(new PropertyValueFactory<>("NumberOfCars"));
				
				Button back6 = new Button("Back");
				back1.setOnAction(p->{
					viewoneOrder.close();
					viewInfo(viewoneOrder);
				});
				
				Table1.setItems(ObservableOrders);
				Table1.setEditable(false);
				BorderPane borderpane1 = new BorderPane(Table1);
				borderpane1.setBottom(back1);
				Scene scene3 = new Scene(borderpane1,800,300);
				viewoneOrder.setScene(scene3);
				viewoneOrder.show();
			
		});
		GridPane grid3 = new GridPane();
		grid3.add(question, 1, 1);grid3.add(answer, 1, 2);
		grid3.add(help, 3, 3);grid3.add(back1, 1, 3);grid3.add(enter, 2, 3);
		
		Scene scene4 = new Scene(grid3);
		viewoneOrder.setScene(scene4);
		viewoneOrder.show();
		
	}
	public static Connection dbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC driver loaded");
		} catch (Exception err) {
			System.err.println("Error loading JDBC driver");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		Connection databaseConnection = null;
		try {

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String connectionUrl = "jdbc:sqlserver://sql.coccork.ie:8443;databaseName=SLOffice;encrypt=true;trustServerCertificate=true;user=samuel.lotty@morrisonsislandcampus.com;password=07072000Ss?";
			System.out.println(connectionUrl);
			
			databaseConnection = DriverManager.getConnection(connectionUrl);
			System.out.println("Connected to the database");
		
	}catch (Exception e) {
		e.printStackTrace();
	}
		return databaseConnection;
	}
	public static ResultSet runQuery(String query) {
		System.out.println(query);
		Connection databaseConnection = dbConnection();
		ResultSet rset = null;
		try {
			PreparedStatement preparedStatement = databaseConnection.prepareStatement(query);
		rset = preparedStatement.executeQuery();
		System.out.println("Query executed!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rset;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
