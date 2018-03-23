package esir.sem2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ViewSwitcher;

public class ProfileActivity extends AppCompatActivity {
    private boolean isEditing;
    private Button confirmBtn;
    private FloatingActionButton editFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        isEditing = false;

        editFab = (FloatingActionButton) findViewById(R.id.fab);
        editFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editProfileValues();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        confirmBtn = findViewById(R.id.ConfirmBtn_profile);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfileValues();
            }
        });

        Spinner athleticSpinner = (Spinner) findViewById(R.id.athletic_value_profile);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> athleticAdapter = ArrayAdapter.createFromResource(this,
                R.array.athletics_value_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        athleticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        athleticSpinner.setAdapter(athleticAdapter);

        Spinner genderSpinner = (Spinner) findViewById(R.id.gender_value_profile);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_value_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        genderSpinner.setAdapter(genderAdapter);
    }

    private void editProfileValues() {

        ViewSwitcher switcherPseudo = findViewById(R.id.pseudo_ViewSwitcher_profile);
        ViewSwitcher switcherHeight = findViewById(R.id.height_ViewSwitcher_profile);
        ViewSwitcher switcherAge =  findViewById(R.id.age_ViewSwitcher_profile);
        ViewSwitcher switcherGender = findViewById(R.id.gender_ViewSwitcher_profile);
        ViewSwitcher switcherAthletic =  findViewById(R.id.athletic_ViewSwitcher_profile);

        if(isEditing){
            editFab.setVisibility(View.VISIBLE);
            confirmBtn.setVisibility(View.GONE);
            switcherPseudo.showNext();
            switcherHeight.showNext();
            switcherAge.showNext();
            switcherGender.showNext();
            switcherAthletic.showNext();
            isEditing = !isEditing;

        } else {
            editFab.setVisibility(View.GONE);
            confirmBtn.setVisibility(View.VISIBLE);
            switcherPseudo.showPrevious();
            switcherHeight.showPrevious();
            switcherAge.showPrevious();
            switcherGender.showPrevious();
            switcherAthletic.showPrevious();
            isEditing = !isEditing;
        }

    }

}
