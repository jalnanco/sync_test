import dao.SeqsDao;
import model.Seqs;
import mybatis.MyBatisConnectionFactory;

import java.sql.Date;
import java.util.List;

public class Doit {
    public void run(String id) {
        System.out.println(id + " - 함수진입");
        try {

            SeqsDao seqsDao = new SeqsDao(MyBatisConnectionFactory.getSqlSessionFactory());
            Seqs seqs = new Seqs();

//                List<Seqs> seqsList = seqsDao.selectAll();
//                for (Seqs seqInfo: seqsList) {
//                    System.out.println("SEQS:" + seqInfo.getSeqsNo() + " / " + seqInfo.getSeqsTp());
//                }

            seqs.setSeqsTp("B" + id);
            seqs.setSeqsDt(Date.valueOf("2022-05-18"));

            synchronized (this) {
                System.out.println(id + " - 쿼리 시작");
                seqsDao.insertSeqsInfo(seqs);

                if (seqs.getSeqsNo() <= 0) {
                    throw new FoolException();
                }

                System.out.println(id + " - 쿼리 끝 " + seqs.getSeqsNo());

                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(id + " - 함수 탈출");
    }
}

class FoolException extends RuntimeException {
}
