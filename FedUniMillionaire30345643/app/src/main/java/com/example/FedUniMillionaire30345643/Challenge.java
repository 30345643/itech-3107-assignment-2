package com.example.FedUniMillionaire30345643;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FedUniMillionaire30345643.Models.Option;
import com.example.FedUniMillionaire30345643.Models.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Challenge extends AppCompatActivity {



    private TextView questionpart, C1, C2, C3, C4, textcount;
    private ProgressBar progressBar;
    private  int score = 0;
    private String name, difficulty = null;

    DBhelper db;

    public ArrayList<Question> questions = new ArrayList<Question>();
    public int savings;
    private Handler handler;

    int second=15 ;

    @Override
    protected void onResume() {
        super.onResume();
        if (second!=0)
            handler.postDelayed(runnable, 1000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge);

        db = new DBhelper(this);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        questionpart = (TextView) findViewById(R.id.questionpart);
        textcount = (TextView) findViewById(R.id.textcount);
        C1 = (TextView) findViewById(R.id.C1);
        C2 = (TextView) findViewById(R.id.C2);
        C3 = (TextView) findViewById(R.id.C3);
        C4 = (TextView) findViewById(R.id.C4);
        name = getIntent().getStringExtra("name");
        progressBar.setMax(15);


         // new handler
       // handler.postDelayed(runnable, 1000);

        playgame();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);

    }
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (second==0)
            {
                try {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();

                }catch (Exception e){

                }

                //handler.postDelayed(runnable,1000);
            }
            else
            {
                Log.d("second","second  "+second);
                second--;
                textcount.setText(" "+second);
                progressBar.setProgress(second);
                handler.postDelayed(this, 1000);
            }
        }
    };

    public void playgame() {
        handler = new Handler();
        second=15;
        progressBar.setProgress(second);

        loadData();
        int random = new Random().nextInt(30);
        questionpart.setText(questions.get(random).getQ());
        String a = questions.get(random).getOptions().get(0).getValue();
        String b = questions.get(random).getOptions().get(1).getValue();
        String c = questions.get(random).getOptions().get(2).getValue();
        String d = questions.get(random).getOptions().get(3).getValue();
        int rand = new Random().nextInt(4) + 1;
        if (rand == 1) {
            C1.setText(d);
            C2.setText(a);
            C3.setText(c);
            C4.setText(b);
            /*    *******************************  */
            C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (score == 0) {
                        score += 1000;
                    } else
                        score *= 2;
                    playgame();
                }
            });

            /*    *******************************  */
            C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });
            /*    *******************************   */
            C3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });
            /*    *******************************   */
            C4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();

                }
            });
        }
        else if (rand == 2) {
            C1.setText(a);
            C2.setText(d);
            C3.setText(c);
            C4.setText(b);
            /*    *******************************  */
            C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });

            /*    *******************************  */
            C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (score == 0) {
                        score += 1000;
                    } else
                        score *= 2;
                    playgame();
                }
            });
            /*    *******************************   */
            C3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });
            /*    *******************************   */
            C4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();

                }
            });
        }
        else if (rand == 3) {
            C1.setText(a);
            C2.setText(c);
            C3.setText(d);
            C4.setText(b);
            /*     *******************************    */
            C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });

            /*    *******************************  */
            C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();



                }
            });
            /*    *******************************   */
            C3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (score == 0) {
                        score += 1000;
                    } else
                        score *= 2;
                    playgame();

                }
            });
            /*    *******************************   */
            C4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();

                }
            });
        }
        else {
            C1.setText(a);
            C2.setText(c);
            C3.setText(b);
            C4.setText(d);
            /*     *******************************    */
            C1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", String.valueOf(score));
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();


                }
            });

            /*    *******************************  */
            C2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();



                }
            });
            /*    *******************************   */
            C3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH);

                    Intent intent = new Intent(Challenge.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("name", name);
                    Boolean check = db.InsertInDB(name, score, simpleDateFormat.format(date), difficulty);
                    if (check) {
                        Toast.makeText(Challenge.this, "insert in database", Toast.LENGTH_LONG).show();
                    } else
                        Toast.makeText(Challenge.this, " fail insert in database", Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();

                }
            });
            /*    *******************************   */
            C4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (score == 0) {
                        score += 1000;
                    } else
                        score *= 2;
                    playgame();
                }
            });
        }

    }


    public void loadData() {
        if (score < 32000) {
            difficulty = "easy";
            try {
                JSONObject jsonObject = new JSONObject(jsonData("easy.json"));
                JSONArray jsonArray = jsonObject.getJSONArray("questions");
                for (int i = 0; i < jsonArray.length(); i++) {
                    Question question1 = new Question();
                    ArrayList<Option> question1Options = new ArrayList<Option>();
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    question1.setQ(jsonObject1.getString("question"));
                    Log.d("verefy", "Q" + i + "==" + jsonObject1.getString("question") + "A==" + jsonObject1.getJSONArray("incorrect_answers").getString(0));
                    question1Options.add(new Option("A", jsonObject1.getJSONArray("incorrect_answers").getString(0)));
                    question1Options.add(new Option("B", jsonObject1.getJSONArray("incorrect_answers").getString(1)));
                    question1Options.add(new Option("C", jsonObject1.getJSONArray("incorrect_answers").getString(2)));
                    question1Options.add(new Option("D", jsonObject1.getString("correct_answer")));
                    Log.d("verefy", "Q" + i + "==" + jsonObject1.getString("question") + "D==" + jsonObject1.getString("correct_answer"));
                    question1.setOptions(question1Options);
                    questions.add(question1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else if ((score >= 32000) && (score < 500000)) {
            difficulty = "medium";
            try {
                JSONObject jsonObject = new JSONObject(jsonData("medium.json"));
                JSONArray jsonArray = jsonObject.getJSONArray("questions");
                for (int i = 0; i < jsonArray.length(); i++) {
                    Question question1 = new Question();
                    ArrayList<Option> question1Options = new ArrayList<Option>();
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    question1.setQ(jsonObject1.getString("question"));
                    Log.d("verefy", "Q" + i + "==" + jsonObject1.getString("question") + "A==" + jsonObject1.getJSONArray("incorrect_answers").getString(0));
                    question1Options.add(new Option("A", jsonObject1.getJSONArray("incorrect_answers").getString(0)));
                    question1Options.add(new Option("B", jsonObject1.getJSONArray("incorrect_answers").getString(1)));
                    question1Options.add(new Option("C", jsonObject1.getJSONArray("incorrect_answers").getString(2)));
                    question1Options.add(new Option("D", jsonObject1.getString("correct_answer")));
                    Log.d("verefy", "Q" + i + "==" + jsonObject1.getString("question") + "D==" + jsonObject1.getString("correct_answer"));
                    question1.setOptions(question1Options);
                    questions.add(question1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } else {
            difficulty = "hard";
            try {
                JSONObject jsonObject = new JSONObject(jsonData("hard.json"));
                JSONArray jsonArray = jsonObject.getJSONArray("questions");
                for (int i = 0; i < jsonArray.length(); i++) {
                    Question question1 = new Question();
                    ArrayList<Option> question1Options = new ArrayList<Option>();
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    question1.setQ(jsonObject1.getString("question"));
                    question1Options.add(new Option("A", jsonObject1.getJSONArray("incorrect_answers").getString(0)));
                    question1Options.add(new Option("B", jsonObject1.getJSONArray("incorrect_answers").getString(1)));
                    question1Options.add(new Option("C", jsonObject1.getJSONArray("incorrect_answers").getString(2)));
                    question1Options.add(new Option("D", jsonObject1.getString("correct_answer")));
                    question1.setOptions(question1Options);
                    questions.add(question1);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public String jsonData(String name) {
        String json = null;
        try {
            InputStream inputStream = getAssets().open(name);
            int size = inputStream.available();
            byte[] bufferdata = new byte[size];
            inputStream.read(bufferdata);
            inputStream.close();
            json = new String(bufferdata, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}