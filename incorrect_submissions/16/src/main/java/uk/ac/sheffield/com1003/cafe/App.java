package uk.ac.sheffield.com1003.cafe;

import java.nio.file.FileAlreadyExistsException;

import java.util.Arrays;

import uk.ac.sheffield.com1003.cafe.exceptions.*;
import uk.ac.sheffield.com1003.cafe.ingredients.*;

public class App {

  public static void main(String[] args) {
    Cafe myCafe = new Cafe("My Cafe", 10, 100);
    Recipe Espresso = new Recipe("Espresso", 1.5, Recipe.Size.SMALL, 2);
    myCafe.addRecipe(Espresso);
    try {
      Espresso.addIngredient(new Water(30));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }

    try {
      Espresso.addIngredient(new Coffee(8));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }

    Recipe doubleEspresso = new Recipe("double Espresso", 2.2, Recipe.Size.REGULAR, 2);
    myCafe.addRecipe(doubleEspresso);
    try {
      doubleEspresso.addIngredient(new Water(50));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }
    try {
      doubleEspresso.addIngredient(new Coffee(15));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }

    Recipe LargeSoyLatte = new Recipe("LargeSoyLatte", 2.5, Recipe.Size.LARGE, 2);
    myCafe.addRecipe(LargeSoyLatte);
    try {
      LargeSoyLatte.addIngredient(new Water(30));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }
    Milk.Type type = Milk.Type.SOYA;
    try {
      LargeSoyLatte.addIngredient(new Milk(100, type));
    } catch (Exception e) {
      System.out.printf(e.getMessage());
    }
    
    //call printMenu method in Cafe.java
    myCafe.printMenu();
  }

}
