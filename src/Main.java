import Get.GetArea2;
import Get.GetPosition2;
import Model.Area;
import Model.Position;
import Write.Warning2;

import javax.management.MBeanServerDelegate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();

        BlockingQueue<Model.Position> positionQueue = new ArrayBlockingQueue<>(100);
        BlockingQueue<ArrayList> warning = new ArrayBlockingQueue<>(100);

        GetPosition2 getPositon2 =new GetPosition2(positionQueue);
        executorService.execute(getPositon2);

        GetArea2 gv = new GetArea2();
        ArrayList<Model.Area> v= gv.call();

        Warning2 wr = new Warning2(warning, positionQueue,v);

        executorService.execute(wr);

        executorService.shutdown();

    }
}
