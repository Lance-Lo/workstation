package company.miapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;

    private String[] TEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_listview);

        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomAdapter(ListViewActivity.this));
    }

    public class CustomAdapter extends BaseAdapter {
        /***********
         * Declare Used Variables
         *********/
        private LayoutInflater inflater = null;
        private Activity activity;
        private int[] IMAGE = {R.drawable.photo_1, R.drawable.photo_2,
                R.drawable.photo_3, R.drawable.photo_4, R.drawable.photo_5,
                R.drawable.photo_6, R.drawable.photo_7, R.drawable.photo_8,
                R.drawable.photo_9, R.drawable.photo_10, R.drawable.photo_11,
                R.drawable.photo_12, R.drawable.photo_13, R.drawable.photo_14,
                R.drawable.photo_15, R.drawable.photo_16, R.drawable.photo_17,
                R.drawable.photo_18, R.drawable.photo_19};

        /*************
         * CustomAdapter Constructor
         *****************/
        public CustomAdapter(Activity a) {
            /********** Take passed values **********/
            activity = a;
            /*********** Layout inflator to call external xml layout () ***********/
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        /********
         * What is the size of Passed Arraylist Size
         ************/
        public int getCount() {
            if (IMAGE.length <= 0)
                return 1;
            return IMAGE.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        /*********
         * Create a holder Class to contain inflated xml file elements
         *********/
        public class ViewHolder {
            public TextView message;
            public ImageView imageView;
        }

        /******
         * Depends upon data size called for each row , Create each ListView row
         *****/
        @SuppressLint("InflateParams")
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, null);
            }
            ViewHolder holder;

            /****** View Holder Object to contain tabitem.xml file elements ******/
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);

            int width = parent.getWidth();
            int height = parent.getHeight();

            if (width < height) {
                LinearLayout listLayout = (LinearLayout) convertView.findViewById(R.id.list_linear);
                listLayout.setLayoutParams(new AbsListView.LayoutParams(width, height));
            } else {
                LinearLayout listLayout = (LinearLayout) convertView.findViewById(R.id.list_linear);
                listLayout.setLayoutParams(new AbsListView.LayoutParams(width, width * 2));
            }

            if (IMAGE.length <= 0) {
                holder.message.setText("No Data");
            } else {
                holder.imageView.setImageResource(IMAGE[position]);
            }
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        menu.add(0, 0, 0, "Home");
        menu.add(0, 1, 0, "About Us");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        switch (id) {
            case 0:

                break;
            case 1:
                Intent intent = new Intent(ListViewActivity.this, AboutActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
