package esir.sem2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
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
