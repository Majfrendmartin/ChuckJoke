package com.wildeastcoders.chuckjoke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wildeastcoders.chuckjoke.injectior.component.AppComponent;
import com.wildeastcoders.chuckjoke.injectior.component.DaggerJokeComponent;
import com.wildeastcoders.chuckjoke.injectior.module.JokeModule;
import com.wildeastcoders.chuckjoke.model.Joke;
import com.wildeastcoders.chuckjoke.presenter.JokePresenter;
import com.wildeastcoders.chuckjoke.view.JokeView;
import com.wildeastcoders.chuckjoke.view.View;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements JokeView {

    @Inject
    JokePresenter jokePresenter;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.et_name)
    EditText etName;

    @BindView(R.id.et_surname)
    EditText etSurname;

    @BindView(R.id.btn_generate)
    Button btnGenerate;

//    @OnClick(R.id.btn_generate)
    void handleGenerateButtonClicked() {
        jokePresenter.onGenerateJokeButtonClicked(
                etName.getText().toString(), etSurname.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AppComponent appComponent = ChuckJokeApplication.getInstance().getAppComponent();
        DaggerJokeComponent.builder().appComponent(appComponent).jokeModule(new JokeModule()).build().inject(this);

        btnGenerate.setOnClickListener(v -> handleGenerateButtonClicked());

        jokePresenter.attachView(this);
    }

    @Override
    public void showJoke(Joke joke) {
        tvContent.setText(joke.getJoke());
    }

    @Override
    public void showLoading() {
        Toast.makeText(this, "LOADING", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, "ERROR: " + message, Toast.LENGTH_SHORT).show();
    }
}
