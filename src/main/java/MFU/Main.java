package MFU;

    public class Main {
        public static void main(String[] args) {
            TaskWithStar.MFU mfu = new TaskWithStar.MFU();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scan("A", 4);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.print("A", 4);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.print("B", 7);
                }
            }).start();
        }
    }

}
