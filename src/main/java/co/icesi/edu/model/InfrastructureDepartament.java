package co.icesi.edu.model;

import co.icesi.edu.ui.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfrastructureDepartament {

    public static final String BILLBOARD_FILE_NAME = "BillboardDataExported.csv";
    ArrayList<Billboard> billboards;

    public InfrastructureDepartament() throws Exception {
        billboards = new ArrayList<>();
        loadBillboard();

        System.out.println("\n The average of the Width is:" + averageW());
        System.out.println("The average of the Height is:" + averageH());
        System.out.println("The average of the Areas is:" + averageA());
        System.out.println("List of brand's quantity: \n" + counterBillXBrand() + "\n");
    }

    public void addBillboard(double w, double h, boolean iu, String b) {
        // Implementación pendiente
    }

    private void saveBillboard() {
        // Implementación pendiente
    }

    public void loadBillboard()throws Exception{
        String resource = Main.class.getClassLoader().getResource(BILLBOARD_FILE_NAME).getFile();
        File file = new File(resource);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        line = br.readLine();

        while (line!=null){
            importData(line);
            line = br.readLine();
        }

        br.close();
        fr.close();
    }

    public double averageW(){
        double totalW = 0;

        for (int i = 0; i < billboards.size(); i++){
            totalW += billboards.get(i).getWidth();
        }
        return totalW / billboards.size();
    }

    public double averageH(){
        double totalH = 0;

        for (int i = 0; i < billboards.size(); i++){
            totalH += billboards.get(i).getHeight();
        }
        return totalH / billboards.size();
    }

    public double averageA(){
        double totalA = 0;

        for (int i = 0; i < billboards.size(); i++){
            totalA += billboards.get(i).calculateArea();
        }

        return totalA / billboards.size();
    }

    public int quantityActives(){
        int totalA = 0;

        for (int i = 0; i < billboards.size(); i++){
            if (billboards.get(i).isInUse()){
                totalA++;
            }
        }
        return totalA;
    }

    public String counterBillXBrand(){

        StringBuilder biilXbrand = new StringBuilder();
        List<String> brandsList = new ArrayList<>();

        String brand = "";
        for (int i = 0; i < billboards.size(); i++){
            brand = String.valueOf(billboards.get(i).getBrand());

            if (!brandsList.contains(billboards.get(i).getBrand())){
                brandsList.add(brand);
            }
        }

        for (int i = 0; i < brandsList.size(); i++){
            int counter = 0;
            String brand1 = String.valueOf(brandsList.get(i));

            for (int k = 0; k < billboards.size(); k++){
                if (brand1.equals(billboards.get(k).getBrand())){
                    counter++;
                }
            }
            biilXbrand.append(" * ").append(brand1).append(": ").append(counter).append("\n");
        }

        return biilXbrand.toString();
    }

    public void exportDangerousBillboardReport(String in) {
        // Implementación pendiente
    }

    public void importData(String fn){

        try {
            String[] columns = fn.split("\\|");
            System.out.println(Arrays.toString(columns));
            Billboard billboard = new Billboard(Double.parseDouble(columns[0]), Double.parseDouble(columns[1]), Boolean.parseBoolean(columns[2]), columns[3]);
            billboards.add(billboard);
        } catch (NumberFormatException e){
            System.out.println("\n error en el formato de numero \n");
        }
    }

    public void printFileContent() throws IOException {

    }

    public void addContentToFile() throws IOException {
    }

    public void searchAndPrintByBrand() throws IOException {
    }

    public void exportToJson(){
        Gson encoder = new GsonBuilder().create();
        String e = encoder.toJson(billboards);
    }
}