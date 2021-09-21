package ir.shirazmetro.metrotown

import VocabDatabaseHelper
import android.database.Cursor
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        //Create a cursor
        var vocabDatabaseHelper: SQLiteOpenHelper = VocabDatabaseHelper(activity)
        try {
            var db = vocabDatabaseHelper.readableDatabase
            val cursor: Cursor = db.query(
                "TBL_VOCAB",
                arrayOf("_id"),
                null,
                null,
                null,
                null,
                null
            )

            var vocabArray = mutableListOf<Int>()
            if (cursor.moveToFirst()) {
                vocabArray.add(cursor.getInt(0)) // _id
                while (cursor.moveToNext()) {
                    vocabArray.add(cursor.getInt(0)) // _id
                }
            }

            cursor.close()
            db.close()


            val toast: Toast = Toast.makeText(
                activity, vocabArray.size.toString(), Toast.LENGTH_SHORT
            )
            toast.show()
            /*
                * Cursor cursor = db.query("DRINK",
                * arrayOf("_id", "vocab", "role", "phonemic", "similar", "meaning", "description"),
                * "_id = ?",new String[] {Integer.toString(1)}, //Convert the int 1 to a String value
                * null, null, null);
                * */

        } catch (ex: SQLiteException) {
            val toast: Toast = Toast.makeText(
                activity, "Database unavailable", Toast.LENGTH_SHORT
            )
            toast.show()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}