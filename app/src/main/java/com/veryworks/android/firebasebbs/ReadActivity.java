package com.veryworks.android.firebasebbs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.veryworks.android.firebasebbs.domain.Bbs;

public class ReadActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textTitle, textAuthor, textDate, textCount, textContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        imageView = (ImageView) findViewById(R.id.imageView);

        textTitle = (TextView) findViewById(R.id.textTitle);
        textAuthor = (TextView) findViewById(R.id.textAuthor);
        textDate = (TextView) findViewById(R.id.textDate);
        textCount = (TextView) findViewById(R.id.textCount);
        textContent = (TextView) findViewById(R.id.textContent);

        setData();
    }

    public void setData(){
        // 목록에서 넘어온 position 값을 이용해 상세보기 데이터를 결정
        Intent intent = getIntent();
        int position = intent.getIntExtra("LIST_POSITION", -1);

        if(position > -1){
            Bbs bbs = Data.list.get(position);
            // 이미지 세팅
            if(bbs.fileUriString != null && !"".equals(bbs.fileUriString)){
                Glide.with(this)
                        .load(bbs.fileUriString)
                        .into(imageView);
            }
            // 값 세팅
            textTitle.setText(bbs.title);
            textAuthor.setText(bbs.author);
            textDate.setText("Data:" + bbs.date);
            textCount.setText("Count:"+bbs.count);
            textContent.setText(bbs.content);
        }
    }


}
