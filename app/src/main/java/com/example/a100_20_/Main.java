package com.example.a100_20_;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;

public class Main extends AppCompatActivity {
    //이미지
    ImageView image1, image2, image3,image4;

    //위치,날씨정보
    TextView tv;
    Geocoder geocoder;
    double latitude, longitude;

    //현재위치~백석대
    TextView tv2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //관련 xml


        //액션바 설정
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();
        actionBar.setDisplayUseLogoEnabled(true);
        //액션바 아이콘
        actionBar.setIcon(R.drawable.logo);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);//상위 액티비티로 이동

        //1-1. 이미지
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image4 = (ImageView) findViewById(R.id.image4);
        //1-2. 현재위치~백석대 구하는 위젯
        tv2 = (TextView) findViewById(R.id.textView2);


        //2-1. 위치
        tv = findViewById(R.id.textView1);
        //2-2. 주소 변환
        geocoder = new Geocoder(this);

        //(1) 매니저 호출
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        //(2) 변화가 일어났을 때의 감지기
        LocationListener locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                List<Address> list = null;//주소 변환

                latitude = location.getLatitude(); //위도
                longitude = location.getLongitude(); //경도

                //주소 변환
                try {
                    list = geocoder.getFromLocation(latitude, longitude, 5); //List=위도와 경도 값
                }catch (IOException e){
                    e.printStackTrace();
                }//try-catch

                if (list != null){
                    if (list.size() == 0){
                        tv.setText("해당되는 주소 정보 없음");
                    }else{ //주소 변환했을 때 값이 나온다면
                        tv.setText(list.get(0).getAdminArea() + " " + list.get(0).getLocality() + " " + list.get(0).getThoroughfare());
                        //시, 구, 동
                        tv2.setText("백석대까지 " + distance(latitude,longitude,36.841173,127.181589) + "m");
                    }
                }//if
            }//onLocationChanged

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras){
            }
            @Override
            public void onProviderEnabled(String provider){
            }
            @Override
            public void onProviderDisabled(String provider){
            }
        };//LocationListener

        //(3)매니저와 감지기 연결
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);
        }catch (SecurityException e){
            e.printStackTrace();
        }//try-catch

        //현재위치~백석대 출력


    }//onCreate

    //거리 구하기 (현재위치~백석대)
    public double distance(double P1_latitude, double P1_longitude,
                           double P2_latitude, double P2_longitude) {
        if ((P1_latitude == P2_latitude) && (P1_longitude == P2_longitude)) {
            return 0;
        }
        double e10 = P1_latitude * Math.PI / 180;
        double e11 = P1_longitude * Math.PI / 180;
        double e12 = P2_latitude * Math.PI / 180;
        double e13 = P2_longitude * Math.PI / 180;
        /* 타원체 GRS80 */
        double c16 = 6356752.314140910;
        double c15 = 6378137.000000000;
        double c17 = 0.0033528107;
        double f15 = c17 + c17 * c17;
        double f16 = f15 / 2;
        double f17 = c17 * c17 / 2;
        double f18 = c17 * c17 / 8;
        double f19 = c17 * c17 / 16;
        double c18 = e13 - e11;
        double c20 = (1 - c17) * Math.tan(e10);
        double c21 = Math.atan(c20);
        double c22 = Math.sin(c21);
        double c23 = Math.cos(c21);
        double c24 = (1 - c17) * Math.tan(e12);
        double c25 = Math.atan(c24);
        double c26 = Math.sin(c25);
        double c27 = Math.cos(c25);
        double c29 = c18;
        double c31 = (c27 * Math.sin(c29) * c27 * Math.sin(c29))
                + (c23 * c26 - c22 * c27 * Math.cos(c29))
                * (c23 * c26 - c22 * c27 * Math.cos(c29));
        double c33 = (c22 * c26) + (c23 * c27 * Math.cos(c29));
        double c35 = Math.sqrt(c31) / c33;
        double c36 = Math.atan(c35);
        double c38 = 0;
        if (c31 == 0) {
            c38 = 0;
        } else {
            c38 = c23 * c27 * Math.sin(c29) / Math.sqrt(c31);
        }
        double c40 = 0;
        if ((Math.cos(Math.asin(c38)) * Math.cos(Math.asin(c38))) == 0) {
            c40 = 0;
        } else {
            c40 = c33 - 2 * c22 * c26
                    / (Math.cos(Math.asin(c38)) * Math.cos(Math.asin(c38)));
        }
        double c41 = Math.cos(Math.asin(c38)) * Math.cos(Math.asin(c38))
                * (c15 * c15 - c16 * c16) / (c16 * c16);
        double c43 = 1 + c41 / 16384
                * (4096 + c41 * (-768 + c41 * (320 - 175 * c41)));
        double c45 = c41 / 1024 * (256 + c41 * (-128 + c41 * (74 - 47 * c41)));
        double c47 = c45
                * Math.sqrt(c31)
                * (c40 + c45
                / 4
                * (c33 * (-1 + 2 * c40 * c40) - c45 / 6 * c40
                * (-3 + 4 * c31) * (-3 + 4 * c40 * c40)));
        double c50 = c17
                / 16
                * Math.cos(Math.asin(c38))
                * Math.cos(Math.asin(c38))
                * (4 + c17
                * (4 - 3 * Math.cos(Math.asin(c38))
                * Math.cos(Math.asin(c38))));
        double c52 = c18
                + (1 - c50)
                * c17
                * c38
                * (Math.acos(c33) + c50 * Math.sin(Math.acos(c33))
                * (c40 + c50 * c33 * (-1 + 2 * c40 * c40)));
        double c54 = c16 * c43 * (Math.atan(c35) - c47);
        // return distance in meter
        return c54;
    }
    //방위각 구하는 부분
    public short bearingP1toP2(double P1_latitude, double P1_longitude,
                               double P2_latitude, double P2_longitude) {
        // 현재 위치 : 위도나 경도는 지구 중심을 기반으로 하는 각도이기 때문에
        //라디안 각도로 변환한다.
        double Cur_Lat_radian = P1_latitude * (3.141592 / 180);
        double Cur_Lon_radian = P1_longitude * (3.141592 / 180);
        // 목표 위치 : 위도나 경도는 지구 중심을 기반으로 하는 각도이기 때문에
        // 라디안 각도로 변환한다.
        double Dest_Lat_radian = P2_latitude * (3.141592 / 180);
        double Dest_Lon_radian = P2_longitude * (3.141592 / 180);
        // radian distance
        double radian_distance = 0;
        radian_distance = Math.acos(Math.sin(Cur_Lat_radian)
                * Math.sin(Dest_Lat_radian) + Math.cos(Cur_Lat_radian)
                * Math.cos(Dest_Lat_radian)
                * Math.cos(Cur_Lon_radian - Dest_Lon_radian));
        // 목적지 이동 방향을 구한다.(현재 좌표에서 다음 좌표로 이동하기 위해서는
        //방향을 설정해야 한다. 라디안값이다.
        double radian_bearing = Math.acos((Math.sin(Dest_Lat_radian) - Math
                .sin(Cur_Lat_radian)
                * Math.cos(radian_distance))
                / (Math.cos(Cur_Lat_radian) * Math.sin(radian_distance)));
        // acos의 인수로 주어지는 x는 360분법의 각도가 아닌 radian(호도)값이다.
        double true_bearing = 0;
        if (Math.sin(Dest_Lon_radian - Cur_Lon_radian) < 0) {
            true_bearing = radian_bearing * (180 / 3.141592);
            true_bearing = 360 - true_bearing;
        } else {
            true_bearing = radian_bearing * (180 / 3.141592);
        }
        return (short) true_bearing;
    }//distance

/*
    //거리구하기 (현재위치~백석대)
    public void dist() {

                double distance;
                String meter;

                Location locationA = new Location("point A");
                locationA.setLatitude(latitude);
                locationA.setLongitude(longitude);

                Location locationB = new Location("point B");
                locationB.setLatitude(36.841173);
                locationB.setLongitude(127.181589);

                distance = locationA.distanceTo(locationB);
                meter=Double.toString(distance);

                tv2 = (TextView) findViewById(R.id.textView2);
                tv2.setText("백석대까지 " + meter + "m");
    }
*/
    //homemenu.xml메뉴를 main.xml에 붙이기 (액션바)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater i1 = getMenuInflater();
        i1.inflate(R.menu.homemenu, menu);
        return super.onCreateOptionsMenu(menu);
    }//onCreateOptionsMenu

    //화면전환
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent i1;
        switch (item.getItemId()) {
            case R.id.foodMenu:
                //맛집 화면 열기
                i1 = new Intent(this, Choice1_Activity.class);
                startActivity(i1);
                return true;
            case R.id.cafeMenu:
                //카페 화면 열기
                i1 = new Intent(this, Choice2_Activity.class);
                startActivity(i1);
                return true;
            case R.id.funMenu:
                //놀거리 화면 열기
                i1 = new Intent(this, Choice3_Activity.class);
                startActivity(i1);
                return true;
            case R.id.comMenu:
                //커뮤니티 화면 열기
                i1 = new Intent(this, Choice4_Acitivity.class);
                startActivity(i1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }//switch
    } //onOptionsItemSelected

    //메인화면의 이미지 표시
    public void onImageClicked(View v) {
        int rnd = (int) (Math.random() * 4) + 1;

        switch (rnd) {
            case 1:
                image1.setVisibility(View.VISIBLE);
                image2.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.INVISIBLE);
                image4.setVisibility(View.INVISIBLE);
                break;
            case 2:
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.VISIBLE);
                image3.setVisibility(View.INVISIBLE);
                image4.setVisibility(View.INVISIBLE);
                break;
            case 3:
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.VISIBLE);
                image4.setVisibility(View.INVISIBLE);
                break;
            case 4:
                image1.setVisibility(View.INVISIBLE);
                image2.setVisibility(View.INVISIBLE);
                image3.setVisibility(View.INVISIBLE);
                image4.setVisibility(View.VISIBLE);
                break;
        }//switch
    }//onImageClicked

    //지도보기(현재위치)
    public void onClick1(View view){
        Uri uri = Uri.parse(String.format("geo:%f,%f?z=15",latitude,longitude));
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);

        startActivity(intent);
    }//onClick1

    //지도보기(백석대)
    public void onClick2(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://map.naver.com/v5/entry/place/11591638"));
        startActivity(intent);
    }//onClick2

}//class-MainActivity

