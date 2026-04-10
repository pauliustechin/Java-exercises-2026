import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Pipe<T> {

    private Queue<T> pipe;

    public Pipe() {
        this.pipe = new ArrayDeque<>();
    }

    public void putIntoThePipe(T value) {
        pipe.add(value);
    }

    public T takeFromPipe() {
        return pipe.poll();
    }

    public boolean isInPipe() {
        if(pipe.isEmpty()) {
            return false;
        }
        return true;
    }
}
