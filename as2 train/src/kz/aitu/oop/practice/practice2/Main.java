package kz.aitu.oop.practice.practice2;
import kz.aitu.oop.practice.practice2.trains.Train;
import kz.aitu.oop.practice.practice2.wagons.Luxury;
import kz.aitu.oop.practice.practice2.wagons.Couchette;
import kz.aitu.oop.practice.practice2.wagons.Coupe;
import kz.aitu.oop.practice.practice2.wagons.Wagon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Train train1 = new Train("Talgo","Almaty -- Astana",1200,30,120);
        Train train2 = new Train("Puffer","Astana -- Qaraghandy",213,20,90);
        Train train3 = new Train("ElectroLocomotive","Oral -- Almaty",2565,40,110);
        for (int i = 1; i <= 5; i++) {
            Luxury luxury = new Luxury("Lux" + i, 10);
            train1.addWagon(luxury);
            Coupe coupe = new Coupe("Cou" + i, 20);
            train1.addWagon(coupe);
            Couchette couchette = new Couchette("Couch" + i, 50);
            train1.addWagon(couchette);
        }

        for (int i = 1; i <= 5; i++) {
            Luxury luxury = new Luxury("Lux" + i, 10);
            train2.addWagon(luxury);
            Coupe coupe = new Coupe("Cou" + i, 20);
            train2.addWagon(coupe);
            Couchette couchette = new Couchette("Couch" + i, 50);
            train2.addWagon(couchette);
        }

        for (int i = 1; i <= 5; i++) {
            Luxury luxury = new Luxury("Lux" + i, 10);
            train3.addWagon(luxury);
            Coupe coupe = new Coupe("Cou" + i, 20);
            train3.addWagon(coupe);
            Couchette couchette = new Couchette("Couch" + i, 50);
            train3.addWagon(couchette);
        }
        while (true) {
            System.out.println("---- Operations Management ----");
            System.out.println("1. Add Wagon.");
            System.out.println("2. Remove Wagon.");
            System.out.println("3. Check Train Information.");
            System.out.println("4. Exit.");
            System.out.println("5. Check capacities of each type of Wagons.");
            System.out.println("6. Check the Traction of the Locomotive.");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if( choice == 4){
                break;
            }

            System.out.println("Select Train (1 or 2 or 3): ");
            int trainChoice = scanner.nextInt();
            scanner.nextLine();

            Train selectedTrain;
            if (trainChoice == 1) {
                selectedTrain = train1;
            } else if (trainChoice == 2){
                selectedTrain = train2;
            }
            else{
                selectedTrain = train3;
            }

            if (choice == 1) {
                System.out.print("Enter Wagon Type (Luxury - 1, Coupe - 2, Couchette - 3): ");
                String type = scanner.nextLine();
                System.out.print("Enter Wagon ID: ");
                String id = scanner.nextLine();
                switch (type) {
                    case "1":
                        Luxury luxury = new Luxury(id, 10);
                        selectedTrain.addWagon(luxury);
                        break;
                    case "2":
                        Coupe coupe = new Coupe(id, 20);
                        selectedTrain.addWagon(coupe);
                        break;
                    case "3":
                        Couchette couchette = new Couchette(id, 50);
                        selectedTrain.addWagon(couchette);
                        break;
                }
            } else if (choice == 2) {
                System.out.print("Enter Wagon ID: ");
                String id = scanner.nextLine();
                for (Wagon wagon : selectedTrain.getWagons()) {
                    if (wagon.getId().equals(id)) {
                        selectedTrain.removeWagon(wagon);
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Total Train Capacity: " + selectedTrain.getTotalCapacity());
                System.out.println("Train Speed: " + selectedTrain.getSpeed() + "km/h");
                int distance = selectedTrain.getDistance();
                System.out.println(selectedTrain.getName());
                System.out.println("Travel Time: " + selectedTrain.getTravelTime(distance) + " hours");
                System.out.println("Wagon Types and Counts:");
                System.out.println("Luxury: " + selectedTrain.getWagonCount("Luxury"));
                System.out.println("Coupe: " + selectedTrain.getWagonCount("Coupe"));
                System.out.println("Couchette: " + selectedTrain.getWagonCount("Couchette"));
            } else if (choice == 5){
                System.out.println("Luxury - 10");
                System.out.println("Coupe - 20.");
                System.out.println("Couchette - 50.");
            } else if (choice == 6){
                System.out.println("Traction of the locomotive of the train "+selectedTrain.getName()+" is "+selectedTrain.getCarryingCapacity());
            }
             else {
                System.out.println("Invalid Choice");
            }
        }
    }
}