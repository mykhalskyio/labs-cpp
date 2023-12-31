import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<PoliceCardIndex> policeCardIndexList = new ArrayList<>();
        String filePath = "path/file.txt";
        policeCardIndexList = Utilities.readFile(filePath);
        Utilities.printTable(policeCardIndexList);
        List<PoliceCardIndex> sortedList1 = new ArrayList<>();
        List<PoliceCardIndex> sortedList2 = new ArrayList<>();
        boolean exit = false;
        do  {
            int action = -1;
            System.out.println("Sort By:");
            System.out.println("[1] : Sort By [PIB]");
            System.out.println("[2] : Sort By [Birthday]");
            System.out.println("[3] : Sort By [Arrest Date]");
            System.out.println("[4] : Sort By [Freedom Date]");
            System.out.println("[0] : Exit");
            System.out.println("Your Choice: ");
            action = scan.nextInt();
            switch (action) {
                case 1 -> {
                    sortedList1 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("\n Sorted By [PIB] Ascending");
                    Utilities.printTable(sortedList1);
                    sortedList2 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("");
                    System.out.println("\n Sorted By [PIB] Descending");
                    Utilities.printTable(sortedList2);
                }
                case 2 -> {
                    sortedList1 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("\n Sorted By [Birthday] Ascending");
                    Utilities.printTable(sortedList1);
                    sortedList2 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("");
                    System.out.println("\n Sorted By [Birthday] Descending");
                    Utilities.printTable(sortedList2);
                }
                case 3 -> {
                    sortedList1 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("\n Sorted By [Arrest Date] Ascending");
                    Utilities.printTable(sortedList1);
                    sortedList2 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("");
                    System.out.println("\n Sorted By [Arrest Date] Descending");
                    Utilities.printTable(sortedList2);
                }
                case 4 -> {
                    sortedList1 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("\n Sorted By [Freedom Date] Ascending");
                    Utilities.printTable(sortedList1);
                    sortedList2 = Utilities.sortBy(policeCardIndexList, action);
                    System.out.println("");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("");
                    System.out.println("\n Sorted By [Freedom Date] Descending");
                    Utilities.printTable(sortedList2);
                }
                case 0 -> {
                    exit = true;
                }
                default -> {
                    System.out.println("\nWrong Input!!!");
                    Utilities.printTable(sortedList1);
                    System.out.println("");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("");
                    Utilities.printTable(sortedList2);
                }
            }
        } while (!exit);
    }}