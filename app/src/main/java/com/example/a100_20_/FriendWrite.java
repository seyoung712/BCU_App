package com.example.a100_20_;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FriendWrite extends AppCompatActivity {

    String FILENAME="MEMO.txt"; //파일명
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_write);
        text=(TextView) findViewById(R.id.text);//위젯
    }//onCreate


    //현재 시간을 표시하는 함수
    private String getTime() {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String getTime = dateFormat.format(date);

        return getTime;
    }//getTime

    //등록
    public void btn1Clicked(View view){
        try{
            FileOutputStream fos = openFileOutput(FILENAME,MODE_APPEND); //쓰기
            FileInputStream fis = openFileInput(FILENAME); //읽기

            //쓰기 (txt파일에)
            String str = getTime().toString() + " | " + text.getText().toString() + ";"; //현재시간+입력한글 저장
            fos.write(str.getBytes());

            //읽기 (txt파일로부터)
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            text.setText("");//중복되지않도록 초기화
            String[] count = (new String(buffer)).split(";"); //;로 구분

            for(int i=0; i<count.length; i++) {
                text.setText("\n" + count[i]);
            }

            fos.close();
            fis.close();

        } catch (IOException e){
            e.printStackTrace();
        }//try-catch
    }//btn1Clicked

    //삭제
    public void btn2Clicked(View view) {
        try{
            FileOutputStream fos = openFileOutput(FILENAME,MODE_PRIVATE);
            FileInputStream fis = openFileInput(FILENAME);

            fos.write("".getBytes());

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            text.setText(new String(buffer));

            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }//try-catch
    }//btn2Clicked
}//class


