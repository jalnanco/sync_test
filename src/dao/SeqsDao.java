package dao;

import model.Seqs;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SeqsDao {
    private SqlSessionFactory sqlSessionFactory;

    public SeqsDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Seqs> selectAll() {
        List<Seqs> list = null;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            list = session.selectList("Seqs.selectAll");
        } finally {
            session.close();
        }
        return list;
    }
}
