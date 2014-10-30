import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity {
       
    /** Override this method to specify which fragment to use
     Example:
     @Override 
     protected Fragment createFragment() {
         return OneFragment.newInstance(<data>); }
    */
    protected abstract Fragment createFragment();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_fragment);
	FragmentManager fm = getSupportFragmentManager();
	Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
	
	if (fragment == null) {
	    fragment = createFragment();
	    fm.beginTransaction()
	    .add(R.id.fragmentContainer, fragment)
	    .commit();
	}
    }
}

// Notes: 

// Working with Fragment Arguments:
// This activity needs to send the intent extras to its fragment. 
// Retrieve them using <Type> data = (<Type>) getIntent().get<Type>Extra(<extra id>)
// Then pass it as the argument of the fragment's factory method:
//     OneFragment.newInstance(<data>)
