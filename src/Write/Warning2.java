package Write;

import Model.Alert;
import Model.Area;
import Model.Position;

import javax.management.modelmbean.ModelMBean;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Warning2 implements Runnable{
    ArrayList<Model.Position> Vt;
    BlockingQueue<Model.Position> Psqueue;
    ArrayList<Model.Area>V;
    BlockingQueue<ArrayList> queue;
    ArrayList<Model.Alert> alerts = new ArrayList<>();
    BlockingQueue<Alert> alertQueue = new ArrayBlockingQueue<>(100);



    public Warning2(BlockingQueue<ArrayList> queue,BlockingQueue<Model.Position> psqueue, ArrayList<Area> v) {
        this.queue = queue;
        Psqueue = psqueue;
        V = v;
    }

    public BlockingQueue<Position> getPsqueue() {
        return Psqueue;
    }

    public void setPsqueue(BlockingQueue<Position> psqueue) {
        Psqueue = psqueue;
    }

    public ArrayList<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(ArrayList<Alert> alerts) {
        this.alerts = alerts;
    }

    public BlockingQueue<Alert> getAlertQueue() {
        return alertQueue;
    }

    public void setAlertQueue(BlockingQueue<Alert> alertQueue) {
        this.alertQueue = alertQueue;
    }


    @Override
    public void run() {
        try {
            while (Psqueue.size()!=0){
                Position ps= Psqueue.take();
                for (Model.Area v:V) {
                        if ((v.getLongitude_left() <= ps.getLongitude() && ps.getLongitude() <= v.getLongitude_right()) &&(v.getLatitude_bottom()<=ps.getLatitude() && ps.getLatitude()<= v.getLatitude_top())){
                            alerts.add(new Model.Alert(ps.getMmsi(),"Canh bao xam nhap vung",v.getName(),ps.getLongitude(),ps.getLatitude(),ps.getTime()));
                        }else {
                            alerts.add(new Model.Alert(ps.getMmsi(),"Canh bao di ra khoi vung",v.getName(),ps.getLongitude(),ps.getLatitude(),ps.getTime()));
                        }
                        Collections.sort(alerts);
                }
            }
            for (Model.Alert a:alerts) {
                alertQueue.put(a);
            }
            Awrite(alertQueue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void Awrite(BlockingQueue<Alert> alertQueue) throws InterruptedException, IOException {
        while (alertQueue.size()!=0){
            Model.Alert a = alertQueue.take();
            FileWriter fw = new FileWriter("alert.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(a.getMmsi()+"|"+a.getAlert()+"|"+a.getName()+"|"+a.getLongitude()+"|"+a.getLatitude()+"|"+a.getTime());
            bw.close();
        }
    }
}
