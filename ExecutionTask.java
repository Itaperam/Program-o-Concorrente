// Cria um Pool de Threads:
// A - Fixo
// B - Com Cache
// C - Dinâmico

import java.util.concurrent.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutionTask {

    public static void main(String[] args) {

        // A - Pool Fixo: Passa o tamanho do Pool
        // int nt = Integer.parseInt(args[0]);
        // Executor exec = Executors.newFixedThreadPool(nt);

        // B - Pool com Cache: Pool varia de tamanho
        //Executor exec = Executors.newCachedThreadPool();

        int nt = Integer.parseInt(args[0]);

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(nt);
        RunnableTask run = new RunnableTask(0);
        exec.scheduleAtFixedRate(run,5,5,TimeUnit.SECONDS);

        int r = 0;

        while(true){
            try {
                exec.execute(new RunnableTask(++r));

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
