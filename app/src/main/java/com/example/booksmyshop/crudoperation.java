package com.example.booksmyshop;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class crudoperation extends AppCompatActivity {

    private EditText editTextBookName, editTextPrice, editTextId;
    private Button insertButton, updateButton, deleteButton, displayButton;
    private TextView displayTextView;
    private BookDatabaseHelper bookDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crudoperation);

        // Initialize views and database helper
        editTextId = findViewById(R.id.id);
        editTextBookName = findViewById(R.id.bookname);
        editTextPrice = findViewById(R.id.price);
        insertButton = findViewById(R.id.insert);
        updateButton = findViewById(R.id.update);
        deleteButton = findViewById(R.id.delete);
        displayButton = findViewById(R.id.display);
        displayTextView = findViewById(R.id.displayTextView);
        bookDatabaseHelper = new BookDatabaseHelper(this);

        // Set onClickListener for insertButton
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBook();
            }
        });

        // Set onClickListener for updateButton
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBook();
            }
        });

        // Set onClickListener for deleteButton
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBook();
            }
        });

        // Set onClickListener for displayButton
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayBooks();
            }
        });
    }

    // Method to insert a new book into the database
    private void insertBook() {
        String bookName = editTextBookName.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();

        long result = bookDatabaseHelper.addBook(bookName, price);

        if (result != -1) {
            Toast.makeText(this, "Book inserted successfully!", Toast.LENGTH_SHORT).show();
            // Clear EditText fields after insertion
            editTextBookName.setText("");
            editTextPrice.setText("");
        } else {
            Toast.makeText(this, "Failed to insert book. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to update an existing book in the database
    private void updateBook() {
        String bookName = editTextBookName.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String id = editTextId.getText().toString().trim();

        if (!id.isEmpty()) {
            int rowsAffected = bookDatabaseHelper.updateBook(id, bookName, price);
            if (rowsAffected > 0) {
                Toast.makeText(this, "Book updated successfully!", Toast.LENGTH_SHORT).show();
                // Refresh the display after update
                displayBooks();
            } else {
                Toast.makeText(this, "Failed to update book.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter the Book ID.", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to delete a book from the database
    private void deleteBook() {
        String id = editTextId.getText().toString().trim();

        if (!id.isEmpty()) {
            int rowsAffected = bookDatabaseHelper.deleteBook(id);
            if (rowsAffected > 0) {
                Toast.makeText(this, "Book deleted successfully!", Toast.LENGTH_SHORT).show();
                // Refresh the display after delete
                displayBooks();
            } else {
                Toast.makeText(this, "Failed to delete book.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter the Book ID.", Toast.LENGTH_SHORT).show();
        }
    }


    // Method to display all books from the database
    private void displayBooks() {
        Cursor cursor = bookDatabaseHelper.getAllBooks();

        if (cursor != null && cursor.getCount() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex(BookDatabaseHelper.COLUMN_NAME));
                String price = cursor.getString(cursor.getColumnIndex(BookDatabaseHelper.COLUMN_PRICE));
                stringBuilder.append("Name: ").append(name).append(", Price: ").append(price).append("\n");
            }
            displayTextView.setText(stringBuilder.toString());
        } else {
            displayTextView.setText("No books found.");
        }
    }
}
