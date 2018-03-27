package dk.easj.anbo.bookstorerest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BookActivity extends AppCompatActivity {
    private Book book;
    private EditText createdView, birdidView, commentView, latitudeView, longitudeView, placenameView, populationView, useridView, namedanishView, nameenglishView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Intent intent = getIntent();
        book = (Book) intent.getSerializableExtra("BOOK");

        TextView headingView = findViewById(R.id.book_heading_textview);
        headingView.setText(book.getUserid());
        //headingView.setText(String.valueOf(book.getUserid()));

        createdView = findViewById(R.id.book_created_edittext);
        createdView.setText(book.getCreated());

        birdidView = findViewById(R.id.book_birdid_edittext);
        birdidView.setText(book.getBirdid());

        commentView = findViewById(R.id.book_comment_edittext);
        commentView.setText(book.getComment());

        latitudeView = findViewById(R.id.book_latitude_edittext);
        latitudeView.setText(book.getLatitude() + " ");

        longitudeView = findViewById(R.id.book_longitude_edittext);
        longitudeView.setText(book.getLongitude() + " ");

        placenameView = findViewById(R.id.book_placename_edittext);
        placenameView.setText(book.getPlacename() + " ");

        populationView = findViewById(R.id.book_population_edittext);
        populationView.setText(book.getPopulation());

        useridView = findViewById(R.id.book_userid_edittext);
        useridView.setText(book.getId());

        namedanishView = findViewById(R.id.book_namedanish_edittext);
        namedanishView.setText(book.getNameDanish());

        nameenglishView = findViewById(R.id.book_nameenglish_edittext);
        nameenglishView.setText(book.getNameEnglish());
    }

    public void deleteBook(View view) {
        DeleteTask task = new DeleteTask();
        task.execute("http://birdobservationservice.azurewebsites.net/Service1.svc/observations/" + book.getUserid());
        finish();
    }

    public void updateBook(View view) {
        // code missing: Left as an exercise
    }


    public void back(View view) {
        finish();
    }

    private class DeleteTask extends AsyncTask<String, Void, CharSequence> {
        @Override
        protected CharSequence doInBackground(String... urls) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                int responseCode = connection.getResponseCode();
                if (responseCode % 100 != 2) {
                    throw new IOException("Response code: " + responseCode);
                }
                return "Nothing";
            } catch (MalformedURLException e) {
                return e.getMessage() + " " + urlString;
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onCancelled(CharSequence charSequence) {
            super.onCancelled(charSequence);
            TextView messageView = findViewById(R.id.book_message_textview);
            messageView.setText(charSequence);
        }
    }
}
