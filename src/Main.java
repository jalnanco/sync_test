import dao.SeqsDao;
import model.Seqs;
import mybatis.MyBatisConnectionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SeqsDao seqsDao = new SeqsDao(MyBatisConnectionFactory.getSqlSessionFactory());
        Seqs seqs = new Seqs();

        List<Seqs> seqsList = seqsDao.selectAll();
        for (Seqs seqInfo: seqsList) {
            System.out.println("SEQS:" + seqInfo.getSeqsNo());
        }
//
//        Doit doit = new Doit();
//
//        Thread thread1 = new Thread( () -> { doit.run("T1");});
//        Thread thread2 = new Thread( () -> { doit.run("T2");});
//        Thread thread3 = new Thread( () -> { doit.run("T3");});
//        Thread thread4 = new Thread( () -> { doit.run("T4");});
//        Thread thread5 = new Thread( () -> { doit.run("T5");});
//        Thread thread6 = new Thread( () -> { doit.run("T6");});
//        Thread thread7 = new Thread( () -> { doit.run("T7");});
//        Thread thread8 = new Thread( () -> { doit.run("T8");});
//
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        thread4.start();
//        thread5.start();
//        thread6.start();
//        thread7.start();
//        thread8.start();
    }
}
