package com.veryworks.android.firebasebbs;

import com.veryworks.android.firebasebbs.domain.Bbs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc on 7/4/2017.
 */

public class Data {
    // 공용으로 사용되는 데이터 저장소
    // 모든 Activity에서 접근할 수 있다.
    public static List<Bbs> list = new ArrayList<Bbs>();
}
