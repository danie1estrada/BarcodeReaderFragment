package scanner.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ScannerFragment scannerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scannerFragment = (ScannerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_scanner);
    }

    public void startCamera(View view) {
        scannerFragment.startCamera();
    }

    public void stopCamera(View view) {
        scannerFragment.stopCamera();
    }
}
