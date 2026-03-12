public class Clock {

    public static void main(String[] args) {

        int sec = 0;
        int min = 0;
        while(true){
            try{
                if(sec < 10 && min < 10){
                    System.out.println("0" + min + ":0" + sec);
                    sec++;
                } else if(sec >= 10 && min < 10){
                    System.out.println("0" + min + ":" + sec);
                    sec++;
                } else {
                    if(sec < 10){
                        System.out.println(min + ":0" + sec);
                        sec++;
                    } else {
                        System.out.println(min + ":" + sec);
                        sec++;
                    }
                }

                if(sec == 60){
                    sec = 0;
                    min++;
                }
                if(min == 60){
                    min = 0;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}
