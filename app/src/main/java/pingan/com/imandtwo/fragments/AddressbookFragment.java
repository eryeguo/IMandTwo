package pingan.com.imandtwo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pingan.com.imandtwo.R;


/**
 * Created by xsj on 2018/2/1.
 * 这是通讯录
 */

public class AddressbookFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.addressbookfragment, container, false);
        return view;
    }
}
