public class ABC {

    //для синхронизации нужен объект
    static String objectChar = "someObject";
    static volatile char thisChar = 'A';

    static class basicCharThenAnotherChar implements Runnable {
        private char basicChar;
        private char anotherChar;
        private int repeat;

        public basicCharThenAnotherChar(char currentLetter, char nextLetter, int repeat) {
            this.basicChar = currentLetter;
            this.anotherChar = nextLetter;
            this.repeat = repeat;
        }

        @Override
        public void run() {
            int i = 0;
            while (i < repeat) {
                synchronized (objectChar) {
                    try {
                        if(thisChar==basicChar) {
                            System.out.print(basicChar);
                            thisChar = anotherChar;
                            i++;
                            objectChar.notifyAll();
                            Thread.sleep(10);
                        }
                        else {
                            objectChar.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
