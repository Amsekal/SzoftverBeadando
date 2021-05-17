# Szoftver Beadando

Ez a projekt a Szoftverfejlesztés tárgyhoz készült. A beadandóban egy játékot készítettem ahol 2 játékos felváltva tesz le egy érmét (piros/kék) egy 7x7-es táblára. Miután 1 érme lekerült a játékos választhat, hogy letesz egyet a saját érméi közül, vagy az egyik lent lévőt zöldre cseréli. A zöld érméket narancsra lehet cserélni hasonlóan az elöbbihez. A nyertes az lesz, akinek több saját szinű érméje lesz lent abban a pillanatban, amikor 4 narancssárga érme van a táblán.
A játék használ javafx-et, van grafikus felülete.
Az eredményeket egy adatbázisban tárolom, onnan kerülnek kiiratásra a toplistára.

Futtatás:
mvn package
java -jar ./target/ChairGame-1.0.jar

Java 16-ban készült
Készítette: Semendi Ádám István
