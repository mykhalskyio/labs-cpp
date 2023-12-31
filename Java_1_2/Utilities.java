import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
public class Utilities {
    static int tableWidth = 200;
    public static List<PoliceCardIndex> sortBy(List<PoliceCardIndex> policeCardIndexList, int sortBy) {
        switch (sortBy) {
            case 1 -> {
                policeCardIndexList.sort(Comparator.comparing(PoliceCardIndex::getPIB));
                return new ArrayList<>(policeCardIndexList);
            }
            case 2 -> {
                policeCardIndexList.sort(Comparator.comparing(PoliceCardIndex::getBirthDay));
                return new ArrayList<>(policeCardIndexList);
            }
            case 3 -> {
                policeCardIndexList.sort(Comparator.comparing(PoliceCardIndex::getArrestTime));
                return new ArrayList<>(policeCardIndexList);
            }
            case 4 -> {
                policeCardIndexList.sort(Comparator.comparing(PoliceCardIndex::getGiveFreedomTime));
                return new ArrayList<>(policeCardIndexList);
            }
            default -> {
                return policeCardIndexList;
            }
        }
    }
    public static List<PoliceCardIndex> readFile(String filePath) {
        List<PoliceCardIndex> policeCardIndexList = new ArrayList<>();
        try(Scanner scan = new Scanner(new File(filePath))) {
            List<String> lines = new ArrayList<>();
            while (scan.hasNext()) {
                lines.add(scan.nextLine());
            }
            for (String line : lines) {
                String[] infoChunk = line.split(",");
                PoliceCardIndex newPoliceCardIndex = new PoliceCardIndex();
                newPoliceCardIndex.setPIB(infoChunk[0]);
                newPoliceCardIndex.setBirthDay(LocalDate.parse(infoChunk[1]));
                newPoliceCardIndex.setHeight(Float.parseFloat(infoChunk[2]));
                newPoliceCardIndex.setEyesColor(infoChunk[3]);
                newPoliceCardIndex.setSpecialDescription(infoChunk[4]);
                newPoliceCardIndex.setArrestTime(LocalDate.parse(infoChunk[5]));
                newPoliceCardIndex.setGiveFreedomTime(LocalDate.parse(infoChunk[6]));
                policeCardIndexList.add(newPoliceCardIndex);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return policeCardIndexList;
    }
    public static void printTable(List<PoliceCardIndex> policeCardIndexList) {
        Utilities.printLine();
        Utilities.printRow("PIB", "Birth Day", "Height", "Eyes Color", "Special Description", "Arrest Time", "Give Freedom Time");
        Utilities.printLine();
        for (PoliceCardIndex policeCard : policeCardIndexList) {
            // - 1900
            String birthDateFormated = new SimpleDateFormat("dd MM yyyy").format(new Date(policeCard.getBirthDay().getYear() - 1900,policeCard.getBirthDay().getMonth().getValue() - 1, policeCard.getBirthDay().getDayOfMonth()));
            String arrestDateFormated = new SimpleDateFormat("dd MM yyyy").format(new Date(policeCard.getArrestTime().getYear() - 1900,policeCard.getArrestTime().getMonth().getValue() - 1, policeCard.getArrestTime().getDayOfMonth()));
            String freedomDateFormated = new SimpleDateFormat("dd MM yyyy").format(new Date(policeCard.getGiveFreedomTime().getYear() - 1900,policeCard.getGiveFreedomTime().getMonth().getValue() - 1, policeCard.getGiveFreedomTime().getDayOfMonth()));
            String[] str = { policeCard.getPIB(), birthDateFormated, String.valueOf(policeCard.getHeight()), policeCard.getEyesColor(), policeCard.getSpecialDescription(), arrestDateFormated, freedomDateFormated };
            printRow(str);
            printLine();
        }
        System.out.println();
    }
    public static void printLine() {
        System.out.println("_".repeat(Math.max(0, tableWidth)));
    }
    public static void printRow(String... columns) {
        int width = (tableWidth - columns.length) / columns.length;
        StringBuilder row = new StringBuilder("|");
        for (String column : columns) {
            row.append(alignCenter(column, width)).append("|");
        }
        System.out.println(row);
    }
    public static String alignCenter(String text, int width) {
        text = text.length() > width ? text.substring(0, width - 3) + "..." : text;
        if (text.isEmpty()) {
            return " ".repeat(width);
        }
        else {
            text = Utilities.padRight(text, width - (width - text.length()) / 2);
            text = Utilities.padLeft(text, width);
            return text;
        }
    }
    public static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }
}
