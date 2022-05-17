import dao.SeqsDao;
import model.Seqs;
import mybatis.MyBatisConnectionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        Doit doit = new Doit();
        Thread[] threads = new Thread[1];

        for(int i=0; i<threads.length; i++) {
            int a = i;
            threads[i] = new Thread(() -> {
                doit.run("T" + a);
            });
        }

        for(int i=0; i< threads.length; i++) {
            threads[i].start();
        }
    }
}
