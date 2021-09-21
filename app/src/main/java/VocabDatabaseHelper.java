import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class VocabDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "db_vocab"; // the name of our database
    private static final int DB_VERSION = 1; // the version of the database

    public VocabDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /*
     * INTEGER Any integer type
     * TEXT Any character type
     * REAL Any floating-point number
     * NUMERIC Booleans, dates, and date-times
     * BLOB Binary Large Object
     * */

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE TBL_VOCAB ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "vocab TEXT, "
                + "role TEXT, "
                + "phonemic TEXT, "
                + "similar TEXT, "
                + "meaning TEXT, "
                + "description TEXT);");

        ContentValues sampleVacab = new ContentValues();
        sampleVacab.put("vocab", "jeopardize");
        sampleVacab.put("role", "v");
        sampleVacab.put("phonemic", "/ˈdʒɛpədʌɪz/");
        sampleVacab.put("similar", "threaten, endanger");
        sampleVacab.put("meaning", "به خطر انداختن");
        sampleVacab.put("description", "a devaluation of the dollar would jeopardize New York's position as a financial centre\n" +
                "1.He would never do anything to jeopardize his career.");
        sqLiteDatabase.insert("TBL_VOCAB", null, sampleVacab);

        sampleVacab = new ContentValues();
        sampleVacab.put("vocab", "convey");
        sampleVacab.put("role", "v");
        sampleVacab.put("phonemic", "/kənˈveɪ/");
        sampleVacab.put("similar", "transport, carry, to show, project, exude");
        sampleVacab.put("meaning", "رساندن ، نقل کردن ، حمل کردن");
        sampleVacab.put("description", "pipes were laid to convey water to the house\n" +
                "the real virtues and diversity of America had never been conveyed in the movies");
        sqLiteDatabase.insert("TBL_VOCAB", null, sampleVacab);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
