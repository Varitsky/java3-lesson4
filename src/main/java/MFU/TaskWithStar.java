package MFU;

public class TaskWithStar {

//    static volatile boolean isLock;

    static class MFU {
        Object forNowIAmPrinter = new Object();
        Object forNowIAmScanner = new Object();

        public void print(String doc, int n){
            synchronized (forNowIAmPrinter){
                System.out.println("[STARTPRINT] " + doc + ": ");
                for (int i = 1; i < (n+1); i++) {
                    System.out.println("[printed " + i + "/" + n + " " + doc + "]");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("[ENDPRINT] "+doc+".");
            }
        }

        public void scan(String doc, int n){
            synchronized (forNowIAmScanner){
                System.out.println("            [STARTSCAN] " + doc + ": ");
                for (int i = 1; i < (n+1); i++) {
                    System.out.println("            [scanned " + i + "/" + n + " " + doc + "]");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("            [ENDSCAN] "+doc+".");
            }
        }

        public void copy(String doc){
            synchronized (forNowIAmScanner){ //синхронизируемся со сканнером, ждём пока он закончит сканирование.
                System.out.println("                        [STARTCOPY] " + doc + ". Если запущена печать другого документа, то копия будет после него.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (forNowIAmPrinter){ //синхронизируемся с принтером, ждём пока закончится печать, если она есть.
                System.out.println("                        [ENDCOPY] " + doc + ", не забудьте забрать оригинал документа.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


//public class Task3 {
//    static class MFU {
//        Object lock1 = new Object();
//        Object lock2 = new Object();
//        public void print(String doc, int n){
//            synchronized (lock1){
//                System.out.println("Начинается печать документа: "+doc+"\n--------------------------");
//                for (int i = 0; i < n; i++) {
//                    System.out.println("Страница "+i+" документа "+doc+" печатается...");
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }System.out.println("Печать документа "+doc+" завершена.\n================================");
//        }
//        public void scan(String doc, int n){
//            synchronized (lock2){
//                System.out.println("Начинается сканирование документа: "+doc+"\n--------------------------");
//                for (int i = 0; i < n; i++) {
//                    System.out.println("Страница "+i+" документа "+doc+" сканируется...");
//                    try {
//                        Thread.sleep(50);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//            System.out.println("Сканирование документа "+doc+" завершено.\n================================");
//        }
//    }
//    public static void main(String[] args) {
//        MFU mfu = new MFU();
//        new Thread(() -> mfu.scan("A", 4)).start();
//        new Thread(() -> mfu.print("A", 4)).start();
//        new Thread(() -> mfu.print("B", 7)).start();
//    }
//}
