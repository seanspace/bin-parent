package mybatis.generator.process;

import org.mybatis.generator.api.ProgressCallback;
import static java.lang.System.out;

/**
 * Created by Karian on 8/17/2015.
 */
public class Caller implements ProgressCallback {

    @Override
    public void introspectionStarted(int totalTasks) {
        out.println("introspectionStarted: " + totalTasks);
    }

    @Override
    public void generationStarted(int totalTasks) {
        out.println("generationStarted: " + totalTasks);
    }

    @Override
    public void saveStarted(int totalTasks) {
        out.println("saveStarted: " + totalTasks);
    }

    @Override
    public void startTask(String taskName) {
        out.println("startTask: " + taskName);
    }

    @Override
    public void done() {
        out.println("All generate tasks done!!!");
    }

    @Override
    public void checkCancel() throws InterruptedException {
        out.println("checkCancel");
    }
}
