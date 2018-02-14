package demo

class RunnableTask implements Runnable {
    private String message

    RunnableTask(String message){
        this.message = message
    }

    @Override
    void run() {
        println(new Date().toString() +" Runnable Task with " + message
                +" on thread " + Thread.currentThread().getName())
    }
}
