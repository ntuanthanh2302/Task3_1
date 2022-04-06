package Get;

import Model.Area;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;

public class GetArea2 implements Callable <ArrayList<Model.Area>> {
    ArrayList<Model.Area> area = new ArrayList<>();
    @Override
    public ArrayList<Model.Area> call() throws Exception {
        String line="";
        try {
            FileReader fr = new FileReader("C:\\Users\\Admin\\Desktop\\Task3\\area.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                if (line == null) {
                    break;
                }
                line = br.readLine();
               // AWrite(line);
               String[] bits = line.split("\\|");
                area.add(new Model.Area(bits[bits.length-5],Integer.parseInt(bits[bits.length-4]),Integer.parseInt(bits[bits.length-3]),Integer.parseInt(bits[bits.length-2]),Integer.parseInt(bits[bits.length-1])));
            }
        } catch (Exception e) {
        }
        return area;
    }

    /*
    private ArrayList<Area> AWrite(String line) throws InterruptedException {
        String[] bits = line.split("\\|");
        //Collections.sort(position2);
        area.add(new Model.Area(bits[bits.length-5],Integer.parseInt(bits[bits.length-4]),Integer.parseInt(bits[bits.length-3]),Integer.parseInt(bits[bits.length-2]),Integer.parseInt(bits[bits.length-1])));
        return area;
    }
    */

}

