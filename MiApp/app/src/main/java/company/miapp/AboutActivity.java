package company.miapp;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AboutActivity extends AppCompatActivity {

    private ImageView ivAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar()
                .setDisplayShowHomeEnabled(true);
        getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()
                .setHomeButtonEnabled(true);
        setContentView(R.layout.activity_about);

        ivAbout = (ImageView) findViewById(R.id.about_imageView);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        if (width < height) {
            ivAbout.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        } else {
            ivAbout.setLayoutParams(new LinearLayout.LayoutParams(width, width * 2));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                System.err.println("back");
                onBackPressed();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
