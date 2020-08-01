package MFU;

    public class Main {
        public static void main(String[] args) {
            TaskWithStar.MFU mfu = new TaskWithStar.MFU();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scan("toBeScanned11111", 2);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.print("toBePrinted11111", 6);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.print("toBePrinted22222", 2);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.copy("toBeCopied");
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mfu.scan("toBeScanned22222", 3);
                }
            }).start();
    }
}
