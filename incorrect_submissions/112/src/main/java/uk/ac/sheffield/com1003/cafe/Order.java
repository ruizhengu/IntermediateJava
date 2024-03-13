package uk.ac.sheffield.com1003.cafe;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    
    private Recipe recipeOrdered;
    private String customerName;
    private double amountPaid;
    private String specialRequest;
    private LocalDateTime orderPlaced;
    private LocalDateTime orderServed;

    public Order(Recipe recipe, String customerName, double amountPaid) {
        this(recipe, customerName, amountPaid, "none");
    }

    public Order(Recipe recipe, String customerName, double amountPaid, String specialRequest) {
        this.recipeOrdered = recipe;
        this.customerName = customerName;
        this.amountPaid = amountPaid;
        this.specialRequest = specialRequest;
        this.orderPlaced = LocalDateTime.now();
        this.orderServed = null;
    }


    public void printReceipt() {
        StringBuffer sb = new StringBuffer();
        String lineBreak = System.getProperty("line.separator");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        sb.append(orderPlaced.format(formatter));
        sb.append(lineBreak);
        sb.append(recipeOrdered.getName());
        sb.append(" for ");
        sb.append(customerName);
        sb.append(lineBreak);
        sb.append("Paid: " + amountPaid);
        sb.append(lineBreak);
        sb.append("Change due: ");
        sb.append(amountPaid-recipeOrdered.getPrice());
        sb.append("Note: " + specialRequest);
        sb.append(lineBreak);
        sb.append("Served: ");
        if (orderServed == null) 
            sb.append("Pending");
        else
            sb.append(orderServed.format(formatter));
        sb.append("Thank you!");
        System.out.println(sb);
    }

    public void serve() {
        this.orderServed = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Order: " + recipeOrdered.getName() + "; For: " + customerName + "; Paid: " + amountPaid;
    }
}