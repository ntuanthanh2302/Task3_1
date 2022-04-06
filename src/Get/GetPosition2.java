package Get;

import Model.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;

public class GetPosition2 implements Runnable {

    BlockingQueue<Model.Position> queue;

    public GetPosition2(BlockingQueue <Model.Position> queue) {
        this.queue = queue;
    }

    private ArrayList<Model.Position> position2 = new ArrayList<>();

    public ArrayList<Position> getPosition2() {
        return position2;
    }

    public void setPosition2(ArrayList<Position> position2) {
        this.position2 = position2;
    }

    @Override
    public void run() {
        String line="";
        try {
            FileReader fr = new FileReader("C:\\Users\\Admin\\Desktop\\Task3\\positions.txt");
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                if (line == null) {
                    break;
                }else {
                    line = br.readLine();
                     PWrite1(line);
                }
            }
        } catch (Exception e) {
        }
    }

    private ArrayList<Model.Position> PWrite(String line) throws InterruptedException {
        String[] bits = line.split("\\|");
        position2.add(new Model.Position(bits[bits.length-4],Integer.parseInt(bits[bits.length-3]),Integer.parseInt(bits[bits.length-2]),bits[bits.length-1]));
        Collections.sort(position2);
        return position2;
    }

    private BlockingQueue<Position> PWrite1(String line) throws InterruptedException {
        String[] bits = line.split("\\|");
        //Collections.sort(position2);
        queue.put(new Model.Position(bits[bits.length-4],Integer.parseInt(bits[bits.length-3]),Integer.parseInt(bits[bits.length-2]),bits[bits.length-1]));
        return queue;
    }


}
