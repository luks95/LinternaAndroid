package py.edu.facitec.linterna;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Camera camera;
    Parameters parameters;
    private Button encenderButton;
    private boolean a;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        encenderButton = (Button) findViewById(R.id.buttonEncender);
        a= true;
        camera = android.hardware.Camera.open();
        encenderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (a == true) {
                        parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                        camera.setParameters(parameters);
                        encenderButton.setText("Apagar");
                        camera.startPreview();
                        a = false;
                    } else {
                        parameters = camera.getParameters();
                        parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                        camera.setParameters(parameters);
                        encenderButton.setText("Encender");
                        camera.stopPreview();
                        a = true;
                    }
                }catch (RuntimeException e){
                }
            }
        });
    }
}
