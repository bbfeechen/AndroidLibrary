package bbfeechen.gmail.com.rxsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Pattern;
import rx.Observable;
import rx.android.widget.WidgetObservable;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override protected void onStart() {
        super.onStart();
        final Pattern emailPattern = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"); // ..... [1]

        EditText userNameEdit = (EditText) findViewById(R.id.edtUserName);
        EditText emailEdit = (EditText) findViewById(R.id.edtEmail);

        Observable<Boolean> userNameValid = WidgetObservable.text(userNameEdit) //  [2]
            .map(e -> e.text())
            .map(t -> t.length() > 4);

        Observable<Boolean> emailValid = WidgetObservable.text(emailEdit)
            .map(e -> e.text())
            .map(t -> emailPattern.matcher(t).matches());

        emailValid.distinctUntilChanged().doOnNext(
            b -> Log.d("[Rx]", "Email " + (b ? "Valid" : "Invalid")))
            .map(b -> b ? Color.BLACK : Color.RED)
            .subscribe(color -> emailEdit.setTextColor(color));

        userNameValid.distinctUntilChanged().doOnNext(
            b -> Log.d("[Rx]", "Uname " + (b ? "Valid" : "Invalid")))
            .map(b -> b ? Color.BLACK : Color.RED)
            .subscribe(color -> userNameEdit.setTextColor(color));

        Button registerButton = (Button) findViewById(R.id.buttonRegister);

        Observable<Boolean> registerEnabled =
            Observable.combineLatest(userNameValid, emailValid, (a, b) -> a && b);
        registerEnabled.distinctUntilChanged().doOnNext(b -> Log.d("[Rx]", "Button " + (b ? "Enabled" : "Disabled")))
            .subscribe(enabled -> registerButton.setEnabled(enabled));


    }
}
