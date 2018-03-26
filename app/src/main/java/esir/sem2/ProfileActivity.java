package esir.sem2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class ProfileActivity extends AppCompatActivity {
    private boolean isEditing;
    private Button confirmBtn;
    private FloatingActionButton editFab;
    private Profile profileInstance;

    private TextView mPseudo,mHeight,mAge,mGender,mAthletic;
    private Spinner genderSpinner;
    private Spinner athleticSpinner;
    private EditText mPseudoValue;
    private EditText mAgeValue;
    private EditText mHeightValue;

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

        // Configure the athletic Spinner
        athleticSpinner = (Spinner) findViewById(R.id.athletic_value_profile);
        ArrayAdapter<CharSequence> athleticAdapter = ArrayAdapter.createFromResource(this,
                R.array.athletics_value_array, android.R.layout.simple_spinner_item);
        athleticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        athleticSpinner.setAdapter(athleticAdapter);


        // Configure the gender Spinner

        genderSpinner = (Spinner) findViewById(R.id.gender_value_profile);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this,
                R.array.gender_value_array, android.R.layout.simple_spinner_item);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        mPseudo = findViewById(R.id.pseudo_TxtView_profile);
        mAge = findViewById(R.id.age_TxtView_profile);
        mHeight = findViewById(R.id.height_TxtView_profile);
        mGender = findViewById(R.id.gender_TxtView_profile);
        mAthletic = findViewById(R.id.athletic_TxtView_profile);

        mPseudoValue = findViewById(R.id.pseudo_value_profile);
        mAgeValue = findViewById(R.id.age_value_profile);
        mHeightValue = findViewById(R.id.height_value_profile);

        profileInstance = Profile.newInstance();
        initData();
    }

    private void initData() {

        mPseudo.setText(profileInstance.getPseudo());
        mAge.setText(String.valueOf(profileInstance.getAge()));
        mHeight.setText(String.valueOf(profileInstance.getHeight()));
        mGender.setText(genderSpinner.getItemAtPosition(profileInstance.getGender()).toString());
        mAthletic.setText(athleticSpinner.getItemAtPosition(profileInstance.getAthletic()).toString());

        mPseudoValue.setText(profileInstance.getPseudo());
        mAgeValue.setText(String.valueOf(profileInstance.getAge()));
        mHeightValue.setText(String.valueOf(profileInstance.getHeight()));

        genderSpinner.setSelection(profileInstance.getGender());
        athleticSpinner.setSelection(profileInstance.getAthletic());



    }

    private void updateData() {
        mPseudo.setText(mPseudoValue.getText());
        mAge.setText(mAgeValue.getText().toString());
        mHeight.setText(mHeightValue.getText().toString());
        mGender.setText(genderSpinner.getSelectedItem().toString());
        mAthletic.setText(athleticSpinner.getSelectedItem().toString());
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
            updateData();
            saveProfile();

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

    private void saveProfile() {

        profileInstance.setAge(Integer.parseInt(mAgeValue.getText().toString()));
        profileInstance.setPseudo(mPseudoValue.getText().toString());
        profileInstance.setHeight(Integer.parseInt(mHeightValue.getText().toString()));
        profileInstance.setGender(genderSpinner.getSelectedItemPosition());
        profileInstance.setAthletic(athleticSpinner.getSelectedItemPosition());

    }

}
