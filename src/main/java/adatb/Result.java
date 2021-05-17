package adatb;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private Long id;
    private String winner;
    private String winColor;
    private int point;

    /**
     * Konstruktor.
     * @param winner Nyertes jatekos neve.
     * @param winColor Nyertes szin.
     * @param point Mennyivel tobb nyertes szin van mint vesztes.
     */
    public Result(String winner, String winColor, int point) {

        this(null, winner,winColor,point);
    }
}
