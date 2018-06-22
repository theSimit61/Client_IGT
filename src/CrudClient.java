import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CrudClient {

    private final static String BASE_URL = "http://localhost:8085/";

    private void printMenu() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  START MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Enter Customer Menu");
        System.out.println("2 : Enter District Menu");
        System.out.println("3 : Enter Item Menu");
        System.out.println("4 : Enter Orderline Menu");
        System.out.println("5 : Enter Stock Menu");
        System.out.println("6 : Enter Warehouse Menu");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  END MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    private void printMenuCustomer() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  CUSTOMER MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a Customer?");
        System.out.println("2 : Delete a Customer?");
        System.out.println("3 : Update a Customer?");
        System.out.println("4 : Get a Customer?");
        System.out.println("5 : Get all Customers?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  CUSTOMER MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    private void printMenuDistrict() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  District MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a District?");
        System.out.println("2 : Delete a District?");
        System.out.println("3 : Update a District?");
        System.out.println("4 : Get a District?");
        System.out.println("5 : Get all Districts?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  District MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    private void printMenuItem() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Item MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a Item?");
        System.out.println("2 : Delete a Item?");
        System.out.println("3 : Update a Item?");
        System.out.println("4 : Get a Item?");
        System.out.println("5 : Get all Item?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Item MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    private void printMenuOrderline() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Orderline MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a Orderline?");
        System.out.println("2 : Delete a Orderline?");
        System.out.println("3 : Update a Orderline?");
        System.out.println("4 : Get a Orderline?");
        System.out.println("5 : Get all Orderline?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Orderline MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    private void printMenuStock() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Stock MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a Stock?");
        System.out.println("2 : Delete a Stock?");
        System.out.println("3 : Update a Stock?");
        System.out.println("4 : Get a Stock?");
        System.out.println("5 : Get all Stock?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Stock MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
    private void printMenuWarehouse() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Warehouse MENU <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("What do you want to do? (Enter 'exit' to quit)");
        System.out.println("1 : Create a Warehouse?");
        System.out.println("2 : Delete a Warehouse?");
        System.out.println("3 : Update a Warehouse?");
        System.out.println("4 : Get a Warehouse?");
        System.out.println("5 : Add a Stock to Warehouse?");
        System.out.println("6 : Get all Warehouse?");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Warehouse MENU  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    private void sendHTTPRequest(URL url, String method) {
        try {
            System.out.println(url);
            System.out.println(method);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void createCustomer(String name, String district) {
        try {
                URL url = new URL(BASE_URL + String.format("customer/createCustomer?name=%s&district=%s",name, district));
                sendHTTPRequest(url, "GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("customer/deleteCustomerName?id=%s",id));
            sendHTTPRequest(url, "DELETE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateCustomerName(String id, String newName) {
        try {
            URL url = new URL(BASE_URL + String.format("customer/updateCustomerName?id=%s&newname=%s",id, newName));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
       private void getCustomer(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("customer/updateCustomerName?id=%s",id));
            sendHTTPRequest(url, "GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getAllCustomers() {
        try {
            URL url = new URL(BASE_URL + String.format("customer/getAllCustomer"));
            sendHTTPRequest(url, "GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createDistrict(String name, String city) {
        try {
            URL url = new URL(BASE_URL + String.format("district/createDistrict?name=%s&city=%s", name, city));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {

        }
    }
    private void deleteDistrict(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("district/deleteDistrict?id=%s", id));
            sendHTTPRequest(url, "DELETE");
        } catch (Exception e) {

        }
    }
    private void updateDistrict(String id,String name,String city) {
        try {
            URL url = new URL(BASE_URL + String.format("district/updateDistrict?id=%s&name=%s&city=%s", id, name, city));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {

        }
    }
    private void getDistrict(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("district/getDistrict?id=%s", id));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {

        }
    }
    private void getAllDistricts() {
        try {
            URL url = new URL(BASE_URL + String.format("district/getAllDistricts"));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {

        }
    }

    private void createItem(String itemName) {
        try {
                URL url = new URL(BASE_URL + String.format("item/createItem?name=%s", itemName));
                sendHTTPRequest(url, "GET");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteItem(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("item/deleteItem?id=%s",
                    id));
            sendHTTPRequest(url, "DELETE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateItem(String id, String newName) {
        try {
            URL url = new URL(BASE_URL + String.format("item/updateItem?id=%s&newName=%s",
                    id,newName));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getItem(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("item/getItem?id=%s",
                    id));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getAllItems() {
        try {
            URL url = new URL(BASE_URL + String.format("item/getAllItems"));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createOrderLine(String customer,String itemList) {
        try {
            URL url = new URL(BASE_URL + String.format("orderline/createOrderline?customer=%s&items=%s",
                    customer,itemList));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteOrderLine(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("orderline/deleteOrderline?id=%s",id));
            sendHTTPRequest(url, "DELETE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateOrderLine(String id,String newOrder) {
        try {
            URL url = new URL(BASE_URL + String.format("orderline/updateOrderLine?id=%s&newOrder=%s",id,newOrder));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getOrderLine(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("orderline/getOrderLine?id=%s",id));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getAllOrderLines() {
        try {
            URL url = new URL(BASE_URL + String.format("orderline/getAllOrderLines"));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void createStock(String customer,String itemId) {
        try {
            URL url = new URL(BASE_URL + String.format("stock/createStock?amount=%s&item=%s",
                    customer,itemId));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteStock(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("stock/deleteStock?id=%s",id));
            sendHTTPRequest(url, "DELETE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateStock(String id,String amount) {
        try {
            URL url = new URL(BASE_URL + String.format("stock/updateStock?id=%s&amount=%s",id,amount));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getStock(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("stock/getStock?id=%s",id));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getAllStocks() {
        try {
            URL url = new URL(BASE_URL + String.format("stock/getAllStocks"));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createWarehouse(String name,String city,String districtName,String stockId) {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/createWarehouse?name=%s&city=%s&district=%s&stock=%s",
                    name,city,districtName,stockId));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void deleteWarehouse(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/deleteWarehouse?id=%s",id));
            sendHTTPRequest(url, "DELETE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void updateWarehouse(String id,String name,String city) {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/updateWarehouse?id=%s&name=%s&city=%s",id,name,city));
            sendHTTPRequest(url, "PUT");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getWarehouse(String id) {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/getWarehouse?id=%s",id));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void getAllWarehouses() {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/getAllWarehouses"));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void addStock(String warehouseId, String itemId, String amount) {
        try {
            URL url = new URL(BASE_URL + String.format("warehouse/addStock?warehouse=%s&itemID=%s&amount=%s",warehouseId,itemId,amount));
            sendHTTPRequest(url, "GET");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        CrudClient crudClient = new CrudClient();
        Scanner sc = new Scanner(System.in);
        while (true) {
            crudClient.printMenu();
            String choice = sc.nextLine();
            switch (choice) {
                case "1": {
                    crudClient.printMenuCustomer();
                    //System.out.println("Enter the data for the district in the form Name,City:");
                    String choiceC=sc.nextLine();
                    switch (choiceC){
                        case "1":{
                            System.out.println("Enter the data to Create a Customer in the form Name, Name of District:");
                            String[] inputs = sc.nextLine().split(",");

                            crudClient.createCustomer(inputs[0], inputs[1]);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete a Customer in the form Id:");
                            String input = sc.nextLine();
                            crudClient.deleteCustomer(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update a Customer in the form Id, new Name:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateCustomerName(inputs[0], inputs[1]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get a Customer in the form Id:");
                            String input = sc.nextLine();
                            crudClient.getCustomer(input);
                            break;
                        }
                        case "5":{
                            crudClient.getAllCustomers();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "2": {
                    crudClient.printMenuDistrict();
                    String choiceD=sc.nextLine();
                    switch (choiceD){
                        case "1":{
                            System.out.println("Enter the data to Create a District in the form Name, City :");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.createDistrict(inputs[0], inputs[1]);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete a District in the form Id:");
                            String input = sc.nextLine();
                            crudClient.deleteDistrict(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update a District in the form Id, Name, City:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateDistrict(inputs[0], inputs[1], inputs[2]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get a District in the form Id:");
                            String input = sc.nextLine();
                            crudClient.getDistrict(input);
                            break;
                        }
                        case "5":{
                            crudClient.getAllDistricts();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "3": {
                    crudClient.printMenuItem();
                    String choiceI=sc.nextLine();
                    switch (choiceI){
                        case "1":{
                            System.out.println("Enter the data to Create an Item in the form Name:");
                            String input = sc.nextLine();
                            crudClient.createItem(input);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete an Item in the form Id:");
                            String input = sc.nextLine();
                            crudClient.deleteItem(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update an Item in the form Id, new Name:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateItem(inputs[0], inputs[1]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get an Item in the form Id:");
                            String input = sc.nextLine();
                            crudClient.getItem(input);
                            break;
                        }
                        case "5":{
                            crudClient.getAllItems();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "4": {
                    crudClient.printMenuOrderline();
                    String choiceO=sc.nextLine();
                    switch (choiceO){
                        case "1":{
                            String[] inputs = new String[2];
                            System.out.println("Enter the data to Create an Orderline in the form Customer ID, list of Items (split the items with ',':");

                            System.out.println("Enter the Customer ID");
                            inputs[0]=sc.nextLine();
                            System.out.println("list of Items (split the items with ','");
                            inputs[1]=sc.nextLine();
                            crudClient.createOrderLine(inputs[0], inputs[1]);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete an Orderline in the form Orderline Id:");
                            String input = sc.nextLine();
                            crudClient.deleteOrderLine(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update an Orderline in the form Orderline Id, 'true'/'false':");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateOrderLine(inputs[0], inputs[1]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get an Orderline in the form Orderline Id:");
                            String input = sc.nextLine();
                            crudClient.getOrderLine(input);
                            break;
                        }
                        case "5":{
                            crudClient.getAllOrderLines();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "5": {
                    crudClient.printMenuStock();
                    String choiceS=sc.nextLine();
                    switch (choiceS){
                        case "1":{
                            System.out.println("Enter the data to Create a Stock in the form amount, Item Id:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.createStock(inputs[0], inputs[1]);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete a Stock in the form Stock Id:");
                            String input = sc.nextLine();
                            crudClient.deleteStock(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update a Stock in the form Stock Id, new amount:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateStock(inputs[0], inputs[1]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get a Stock in the form Stock Id:");
                            String input = sc.nextLine();
                            crudClient.getStock(input);
                            break;
                        }
                        case "5":{
                            crudClient.getAllStocks();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "6": {
                    crudClient.printMenuWarehouse();
                    String choiceW=sc.nextLine();
                    switch (choiceW){
                        case "1":{
                            System.out.println("Enter the data to Create a Warehouse in the form Warehouse Name, City, District Name, Stock Id:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.createWarehouse(inputs[0], inputs[1],inputs[2], inputs[3]);
                            break;
                        }
                        case "2":{
                            System.out.println("Enter the data to Delete a Warehouse in the form Warehouse Id:");
                            String input = sc.nextLine();
                            crudClient.deleteWarehouse(input);
                            break;
                        }
                        case "3":{
                            System.out.println("Enter the data to Update a Warehouse in the form Warehouse Id, Name, City:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.updateWarehouse(inputs[0], inputs[1],inputs[2]);
                            break;
                        }
                        case "4":{
                            System.out.println("Enter the data to get a Warehouse in the form Warehouse Id:");
                            String input = sc.nextLine();
                            crudClient.getWarehouse(input);
                            break;
                        }
                        case "5":{
                            System.out.println("Enter the data to add a Stock to a Warehouse in the form Warehouse Id, Item Id, amount:");
                            String[] inputs = sc.nextLine().split(",");
                            crudClient.addStock(inputs[0],inputs[1],inputs[2]);
                            break;
                        }
                        case "6":{
                            crudClient.getAllWarehouses();
                            break;
                        }
                        case "exit":{
                            crudClient.printMenu();
                            break;
                        }
                    }
                    break;
                }
                case "exit": {
                    System.exit(0);
                    break;
                }
            }
        }
    }


}
