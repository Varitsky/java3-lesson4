package MFU;

public class TaskWithStar {
    static class MFU {
        Object lock1 = new Object();
        Object lock2 = new Object();
        public void print(String doc, int n){
            synchronized (lock1){
                System.out.println("Начинается печать документа: "+doc+"\n--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Страница "+i+" документа "+doc+" печатается...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }System.out.println("Печать документа "+doc+" завершена.\n================================");
        }
        public void scan(String doc, int n){
            synchronized (lock2){
                System.out.println("Начинается сканирование документа: "+doc+"\n--------------------------");
                for (int i = 0; i < n; i++) {
                    System.out.println("Страница "+i+" документа "+doc+" сканируется...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Сканирование документа "+doc+" завершено.\n================================");
        }
    }

}
