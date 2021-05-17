package adatb;


import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;
@RegisterBeanMapper(Result.class)
public interface ResultDao {


    /**
     * Adatbazisban a tablat letrehozo fuggveny.
     */
    @SqlUpdate("""
        CREATE TABLE toplista (
            id integer not null AUTO_INCREMENT,
            winner varchar(255),
            winColor varchar(255),
            point integer not null,
            primary key(id)
        )
        """
    )
    void createTable();

    /**
     * Droppolja a toplista tablat.
     */
    @SqlUpdate("""
            drop table toplista
            """)
    void deleteContents();

    /**
     * Berak az adatbazisba egy rekordot a megadott ertekettel.
     * @param jatekVege - a jatek eredmenye.
     * @return .
     */
    @SqlUpdate("INSERT INTO toplista (winner,winColor,point) VALUES (:winner,:winColor,:point)")
    int insertGameResult(@BindBean Result jatekVege);

    /**
     * Lekerdezes eredmenyet adja vissza, melyben a rekordok a steps-s alapjan vannak rendezve, melyben a winner nem null.
     * @return Az elso tiz ilyen talalatot adja vissza.
     */
    @SqlQuery("SELECT * FROM toplista WHERE winner is not null ORDER BY point LIMIT 10")
    List<Result> listGameResults();
}
