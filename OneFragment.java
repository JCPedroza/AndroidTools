import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OneFragment extends Fragment {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
    //Create your view references here. 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_layout_here, parent, false);
		return v;
	}

	// Used to instantiate this class using Fragment Arguments.
	public static OneFragment newInstance(Object object) {
		
	Bundle args = new Bundle();
	args.putSerializable(AN_ID, object);
		
	OneFragment fragment = new OneFragment();
	fragment.setArguments(args);
		
	return fragment;
	}

}
