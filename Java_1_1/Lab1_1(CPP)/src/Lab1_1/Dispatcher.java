package Lab1_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Dispatcher {
    public static void main(String[] args) {
        try {
            File file = new File("path/toys.txt");
            Scanner scanner = new Scanner(file);

            List<Toy> toybox = new ArrayList<Toy>();

            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] details = line.split(",");
                String name = details[0].trim();
                double price = Double.parseDouble(details[1].trim());
                int age_from = Integer.parseInt(details[2].trim());
                Toy toy = new Toy(name, price, age_from);
                toybox.add(toy);
            }

            System.out.println("Toybox:");
            System.out.println("");

            for(Toy toy: toybox){
            	System.out.println(toy.toString());
            }

    		Scanner scan = new Scanner(System.in);
            System.out.println("");
            System.out.print("x : ");
            double x = scan.nextDouble();

            System.out.println("");
            System.out.println("-------------------------");
            System.out.println("");
            System.out.println("Toybox {Restrictions: Not a ball, Only for 3 year old, Price not bigger than x} :");
            System.out.println("");

            Collections.sort(toybox, Comparator.comparing(Toy::getPrice));

            for(Toy toy: toybox){
                if (!toy.getName().equals("Ball"))
                {
                    if (toy.getAgeFrom() == 3)
                    {
                        if (toy.getPrice() <= x)
                        {
                        	System.out.println(toy.toString());
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class Toy{

    private String name;
    private double price;
    private int age_from;

    public Toy(String name, double price, int age_from){
        this.setName(name);
        this.price = price;
        this.age_from = age_from;
    }

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public double getPrice() {
	    return price;
	}

	public void setPrice(double price) {
	    this.price = price;
	}

	public int getAgeFrom() {
	    return age_from;
	}

	public void setAgeFrom(int age_from) {
	    this.age_from = age_from;
	}

	public String toString(){
	    return "Name: " + this.name + "; Price: " + this.price + " UAH; Age Restrictions: " + this.age_from + "+ Years";
	}
}