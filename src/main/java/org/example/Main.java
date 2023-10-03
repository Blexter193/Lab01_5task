package org.example;

import java.util.Scanner;

import static java.lang.System.err;

public class Main {
    public static void main(String[] args) {
        final DeliveryDepartment lviv = new DeliveryDepartment("Lviv", true, true, true);
        final DeliveryDepartment kyiv = new DeliveryDepartment("Kyiv", true, true, true);
        final DeliveryDepartment rivne = new DeliveryDepartment("Rivne", false, false, true);
        final DeliveryDepartment dnipro = new DeliveryDepartment("Dnipro", true, false, false);
        final ReceivePoint[] receivePoints = {new ReceivePoint(kyiv), new ReceivePoint(dnipro)};
        final DeparturePoint[] departurePoints = {new DeparturePoint(lviv), new DeparturePoint(rivne), new DeparturePoint(kyiv)};

        final int MAX_SHIPMENTS = 10;
        boolean isContinue = true;
        Shipment[] shipments = new Shipment[MAX_SHIPMENTS];
        Scanner scanner = new Scanner(System.in);
        //==============================
        System.out.println("\n Task 5");
        do {
            System.out.println("Menu:\n1. View all shipments\n2. Add a shipment\n3. Delete a shipment\n0. Exit");
            String choice;
            choice = scanner.nextLine();
            int countOfShipments = 0;
            for (Shipment ship : shipments) {
                if (ship != null) {
                    countOfShipments++;
                }
            }
            switch (choice) {
                case "1": {
                    if (countOfShipments < 1)
                        System.out.println("No shipments available");
                    for (int i = 0; i < countOfShipments; i++) {
                        System.out.println("Shipment #" + (i + 1));
                        shipments[i].printShipment();
                    }
                    break;
                }
                case "2": {
                    if (countOfShipments >= 10) {
                        System.out.println("Too many shipments in the array");
                        break;
                    }
                    Shipment newShipment = new Shipment(receivePoints, departurePoints, scanner);
                    if (countOfShipments > 0)
                        shipments[countOfShipments - 1] = newShipment;
                    else
                        shipments[0] = newShipment;
                    break;
                }
                case "3": {
                    if (countOfShipments < 1) {
                        System.out.println("No shipments available");
                        break;
                    }
                    if (countOfShipments == 1)
                        shipments = new Shipment[MAX_SHIPMENTS];
                    System.out.println("Shipment number?");
                    int choiceOfDelete;
                    try {
                        String receiverName = scanner.nextLine();
                        choiceOfDelete = Integer.parseInt(receiverName);
                        if (choiceOfDelete > countOfShipments || choiceOfDelete < 0)
                            throw new IllegalArgumentException("Incorrect input");

                        shipments[choiceOfDelete - 1] = shipments[countOfShipments - 1];
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case "0": {
                    isContinue = false;
                    break;
                }
            }
        } while (isContinue);

        for (int i = 0; i < 5; i++) {
            Shipment shipmentLvivKyiv = new Shipment(receivePoints, departurePoints, scanner);
            shipmentLvivKyiv.printShipment();
            System.out.println("Hello1");
        }
        scanner.close();
    }
}