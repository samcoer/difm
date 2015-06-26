package info.doitforme.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import info.doitforme.R;

/**
 * Created by ptanwar on 06/06/15.
 */
public class MyTasks extends Fragment {

    public static String TAG = MyTasks.class.getName();

    private String[] options;

    private void initOptions() {
        options = new String[] {
                getResources().getString(R.string.parcel),
                getResources().getString(R.string.buy_grocery),
                getResources().getString(R.string.paperwork)
        };
    }

    public MyTasks() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mytasks, container, false);
        initViewListeners(rootView);
        return rootView;
    }


    private void showOptionsDialog() {
        initOptions();
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.select_new_task_type);
        dialog.setTitle(R.string.select_new_task_dialog_heading);

        final ListView listView = (ListView) dialog.findViewById(R.id.new_task_options_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String)listView.getItemAtPosition(position);
                dialog.dismiss();
                Fragment newTaskFragment = optionClicked(position);
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, newTaskFragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Log.d(TAG, "option " + itemValue + " clicked.");
            }
        });

        dialog.show();
    }


    private Fragment optionClicked(int position) {
        switch ( position ) {
            case 0:
                return new CreateBringNewParcelTask();

            case 1:
                break;

            case 2:
                break;
        }
        return null;
    }


    private void initViewListeners(final View rootView) {
        ImageView addNewTaskBtn = (ImageView) rootView.findViewById(R.id.addTaskBtn);
        addNewTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionsDialog();
            }
        });
    }
}
