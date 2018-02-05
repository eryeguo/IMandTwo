package pingan.com.imandtwo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pingan.com.imandtwo.R;
import pingan.com.imandtwo.activity.MyActivity;

/**
 * Created by xsj on 2018/2/1.
 * 这是我的
 */

public class MineFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.mine)
    RelativeLayout mine;
    @BindView(R.id.banben)
    RelativeLayout banben;
    @BindView(R.id.shezhi)
    LinearLayout shezhi;
    @BindView(R.id.myqunzu)
    LinearLayout myqunzu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minefragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mine, R.id.banben, R.id.shezhi, R.id.myqunzu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //个人属性
            case R.id.mine:
                Intent intent = new Intent(getActivity(), MyActivity.class);
                startActivity(intent);
                break;
            case R.id.banben:
                Toast.makeText(getActivity(),"版本更新",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shezhi:
                Toast.makeText(getActivity(),"设置",Toast.LENGTH_SHORT).show();
                break;
            case R.id.myqunzu:
                Toast.makeText(getActivity(),"我的群组",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
