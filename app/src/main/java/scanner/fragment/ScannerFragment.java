package scanner.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerFragment extends Fragment implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    private ViewGroup container;
    private View defaultView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        defaultView = inflater.inflate(R.layout.fragment_scanner, container, false);
        scannerView = new ZXingScannerView(getActivity());

        return scannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    public void startCamera() {
        container = (ViewGroup) scannerView.getParent();
        container.removeView(scannerView);
        container.addView(scannerView);
        scannerView.resumeCameraPreview(this);
        scannerView.startCamera();
    }

    public void stopCamera() {
        scannerView.removeAllViews();
        scannerView.stopCamera();

        replaceView(defaultView);
    }

    private void replaceView(View view) {
        container = (ViewGroup) getView();
        container.removeAllViews();
        container.addView(view);
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(getContext(), result.getText(), Toast.LENGTH_LONG).show();
    }
}
