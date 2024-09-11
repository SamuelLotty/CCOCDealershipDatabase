# CCOCDealershipDatabase
JavaFX
Created a menu that allowed users to add, modify, view orders, and delete orders within the program. 

//****************
// ALGORITHM
//***************

START
TRY 
Connect to database.
INPUT: Read “select * from SLOrders into ResultSet”
WHILE NOT at end of ResultSet
	Set order ID(“OrdID”)
	Set stock ID(“StockID”)
	Set Quantity Ordered(“QuantOrd”)
	Set Worker Name(“Worker Name”)
Add to Order List
END WHILE
CATCH 
	OUTPUT:ERROR
Add list to Orders Table 
Add Table to vbox
END
INPUT READ “Select * from SLStock into ResultSet”
WHILE NOT at end of ResultSet
	Set Item Number(“ItemNo”)
	Set Quantity Stock(“QuantStock”)
	Set Quantity Ordered(“QuantOrd”)
	Set Item Name(“ItemName”)
Add to Stock List 
END WHILE
CATCH 
	OUTPUT:ERROR
Add list to Orders Table 
Add Table to vbox

ADD ORDER
Create Stage
Add label for order number
Add label for stock item number
Add label for quantity ordered
Add label for worker name
Text field for each label
Add back button for menu
Add help button
Add enter menu
	Set on action 
	Insert “Insert INTO SLOrders “ +” values(“+
	INSERT Textfields for labels
try
Connect to Database 
Create preparedstatement and execute
Catch 
	OUTPUT:ERROR
Create gridpane and insert buttons labels and textfields 
Create scene and show
end

	DELETE ORDER
CREATE STAGE 
ADD label for order number
ADD textfield
ADD button for help
ADD button for back
ADD Enter button
	Set on action 
	Alert menu (“Confirm that you would like to delete this order number”)
INPUT (“Delete from SLOrders WHERE OrdID = + order number“)
TRY 
	Create prepared Statement and execute 
OUTPUT (“Record Deleted”)
CATCH 
	Alert set on action NO
		Close window
Alert Show and wait
Create grid pane 
Create scene and show
end

Modify Order 
Set Title
Add Label for Order Number
Add Textifield for order number
Add label for Office worker name
Add text field for worker name
Add back button for menus
Add help button 
Add modify button
	Set on action 
		Connect to database 
		Get text from order number text field
	INPUT (“SELECT * FROM SLOrders WHERE OrdID =” + ORDER NUMBER”)
Run Result Set
TRY
IF
	INPUT “Update SLOrders SET WHERE Workername = “ + WORKER NAME +”WHERE OrdID =” ORDER NUMBER
OUTPUT “THE RECORD HAS BEEN UPDATED”
CREATE PREPARED STATEMENT AND EXECUTE
CLOSE MENU
ELSE 
	There has been an error.
Catch 
Create grid pane 
Set scene and display
end

View info 
	Create label for tables
Create button for View stock
	Set on action 
		View stock table
Create button for view orders 
	Set on action 
		View orders table
Create back button 
Create help button
Create gridpane 
Create scene and show
end

Alert help menu
	Create information alert 
	Set height	
	Set Heading
	Set context to alert
Show and wait
Close

Alert for deletion
	Create warning alert
	Set height
	Set heading 
	Set context to alert
Show and wait 
Close
end

Stock Table
	Set title 
Set stock list into array from database
Create table columns 
Add variables to each table columns 
	Create back button
Display tables in HBox
Create scene and show
end


Orders Table
	Set title 
Set orders list into array from database
Create table columns 
Add variables to each table columns 
	Create back button
Display tables in HBox
Create scene and show

View one order
Connect to database 
INPUT : “SELECT * from SLOrders WHERE OrdID = “+ Order ID
TRY 
	Set Order ID from result 
	Set Stock ID from result 
	Set Quantity ordered from result
	Set worker name from the result 
Add to list 
Catch 
OUTPUT “ERROR”
Add list to table
Display table through VBOX

end

//*********************
// PLAN OVERVIEW 
//*********************
-Started project 
-Connect to the database from eclipse
-Create first start menu where selection of other menus are there through buttons 
- Create add menu to insert data into database
- Create delete menu to delete information out of the database
- Create modify button where modifications can be made to already existing information in database
- Creating back buttons for each of the windows to make more accessible
- Creating help buttons for each of the menus to make it more informative
- Testing the program and seeing if everything works properly
- Delivering the project on the 12/03/2023





