package adatb;

import lombok.extern.slf4j.Slf4j;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.List;

@Slf4j
public class Handler {
    /**
     *
     * @param winner a jatek gyoztese.
     * @param winColor a jatek gyoztesenek szine.
     * @param point mennyi ponttal nyert.
     */

    public static void insertResults(String winner, String winColor, int point) {
        Jdbi jdbi = Jdbi.create("jdbc:mysql://remotemysql.com:3306/7UFqoovlD1?useSSL=false","7UFqoovlD1","PIfkhoRaYA");
        jdbi.installPlugin(new SqlObjectPlugin());
        Result jatekVege = jdbi.withExtension(ResultDao.class, dao -> {
            try {
                dao.createTable();
            }
            catch (Exception e){
                //
            }
            Result gameResult = new Result(winner,winColor,point);
            dao.insertGameResult(gameResult);
            return gameResult;
        });

        log.info("Inserted into Database: " + jatekVege);
    }


    /**
     *
     * @return visszaadja a jatekok vegen kapott adatokat a toplistaba
     */
    public static List<Result> listResults() {
        Jdbi jdbi = Jdbi.create("jdbc:mysql://remotemysql.com:3306/7UFqoovlD1?useSSL=false","7UFqoovlD1","PIfkhoRaYA");
        jdbi.installPlugin(new SqlObjectPlugin());
        List<Result> jatekVege = jdbi.withExtension(ResultDao.class, dao -> {
            return dao.listGameResults();
        });
        return jatekVege;
}}
