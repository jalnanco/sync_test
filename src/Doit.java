import dao.SeqsDao;
import model.Seqs;
import mybatis.MyBatisConnectionFactory;

import java.sql.Date;
import java.util.List;

public class Doit {
    public void run(String id) {
        System.out.println(id + " - 함수진입");
        synchronized(this) {
            System.out.println(id + " - 처리 시작");
            try {

                SeqsDao seqsDao = new SeqsDao(MyBatisConnectionFactory.getSqlSessionFactory());
                Seqs seqs = new Seqs();

//                List<Seqs> seqsList = seqsDao.selectAll();
//                for (Seqs seqInfo: seqsList) {
//                    System.out.println("SEQS:" + seqInfo.getSeqsNo() + " / " + seqInfo.getSeqsTp());
//                }

                seqs.setSeqsNo(2);
                seqs.setSeqsTp("B");
                seqs.setSeqsDt(Date.valueOf("2022-05-18"));

                String seqStr = seqsDao.insertSeqsInfo(seqs);

                Thread.sleep(0);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(id + " - 처리 끝");
        }
        System.out.println(id + " - 함수 탈출");
    }
}
