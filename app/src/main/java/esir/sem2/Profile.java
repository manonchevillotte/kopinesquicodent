package esir.sem2;

/**
 * Class representing the User profile
 * Contains the main characteristics of the user
 * ex : name,height, mass,
 * Created by maxime on 24/03/2018.
 */

public class Profile {
    private static Profile instance;
    private String mPseudo;
    private int mAge,mHeight;
    private boolean mIsAthletic;
    private int mGender;

    private Profile() {
        this.mPseudo = "Pseudo";
        this.mAge = 18;
        this.mHeight = 180;
        this.mIsAthletic = true;
        this.mGender = 1;
    }

    /**
     *  Create an Unique Instance for the App
     * @return the instance ( Profile )
     */
    public static Profile  newInstance(){
        if (instance == null){
            instance = new Profile();
        }
        return instance;
    }

    public String getPseudo() {
        return mPseudo;
    }

    public void setPseudo(String mPseudo) {
        this.mPseudo = mPseudo;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int mHeight) {
        this.mHeight = mHeight;
    }

    public boolean isAthletic() {
        return mIsAthletic;
    }

    public void setAthletic(boolean mIsAthletic) {
        this.mIsAthletic = mIsAthletic;
    }

    public int getGender() {
        return mGender;
    }

    public void setGender(int mgender) {
        this.mGender = mgender;
    }
}
