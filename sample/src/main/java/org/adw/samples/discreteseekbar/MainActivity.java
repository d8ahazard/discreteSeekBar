package org.adw.samples.discreteseekbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

public class MainActivity extends Activity implements DiscreteSeekBar.onSeekBarChangeListener {
    private DiscreteSeekBar hueBar1;
    private float hsv[] = new float[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DiscreteSeekBar discreteSeekBar1 = (DiscreteSeekBar) findViewById(R.id.discrete1);
        hueBar1 = (DiscreteSeekBar) findViewById(R.id.discretehue);
        hsv[0] = hueBar1.getProgress();
        hsv[1] = .8f;
        hsv[2] = .8f;
        hueBar1.setThumbColor(Color.HSVToColor(hsv));
        hueBar1.setIndicatorColor(Color.HSVToColor(hsv));
        discreteSeekBar1.setNumericTransformer(new DiscreteSeekBar.NumericTransformer() {
            @Override
            public int transform(int value) {
                return value * 100;
            }
        });
        hueBar1.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(DiscreteSeekBar seekBar, int progress, boolean fromUser) {
        hsv[0] = progress;
        hueBar1.setIndicatorColor(Color.HSVToColor(hsv));
        hueBar1.setThumbColor(Color.HSVToColor(hsv));

    }

    @Override
    public void onStartTrackingTouch(DiscreteSeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(DiscreteSeekBar seekBar) {

    }
}
