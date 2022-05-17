public class Doit {
    public void run(String id) {
        System.out.println(id + " - 함수진입");
        synchronized(this) {
            System.out.println(id + " - 처리 시작");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(id + " - 처리 끝");
        }
        System.out.println(id + " - 함수 탈출");
    }
}
