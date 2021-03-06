package org.gnu.freecall.you;

import java.util.ArrayList;
import java.util.List;

import org.gnu.freecall.R;
import org.gnu.freecall.data.Cloud;
import org.gnu.freecall.data.CloudArrayAdapter;
import org.gnu.freecall.view.SearchFieldWatcher;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

/**
 * The "you" activity, which is kind-of like your profile.
 */
public class YouActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Set the content view.
        setContentView(R.layout.list);
        final List<Cloud> clouds = new ArrayList<Cloud>();
        final Cloud nameCloud = new Cloud("Names");
        nameCloud.addValue("Haakon Meland Eriksen");
        clouds.add(nameCloud);
        clouds.add(new Cloud("Address"));
        final Cloud interestCloud = new Cloud("Interests");
        interestCloud.addValue("Rock music");
        interestCloud.addValue("Free software");
        interestCloud.addValue("The darkside");
        clouds.add(interestCloud);
        clouds.add(new Cloud("Pictures"));
        final CloudArrayAdapter dataAdapter = new CloudArrayAdapter(this, R.layout.list_item, R.id.text, clouds);
        ((ListView) findViewById(R.id.list_view)).setAdapter(dataAdapter);
        new SearchFieldWatcher(((EditText) findViewById(R.id.search_field)));
	}
}
