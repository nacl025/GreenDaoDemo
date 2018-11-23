package com.example.edmund.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edmund.greendaodemo.db.StudentDaoOpe;
import com.example.edmund.greendaodemo.model.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.btn_query_all)
    Button btnQueryAll;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //mAdapter = new ArrayAdapter<Student>(this,R.id.tv_content, studentList);
        initData();
    }

    private List<Student> studentList = new ArrayList<>();

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 100; i++) {
            Student student = new Student((long) i, "huang" + i, 25, "666" + i, "0", 2, 3);
            studentList.add(student);
        }
    }

    int page;


    void deal() {
        File destDir = new File("/data/data/com.example.edmund.greendaodemo/databases/test.db");
        Process p;
        int status;
        try {
            p = Runtime.getRuntime().exec("chmod 666 " + destDir);
            status = p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.btn_query_all, R.id.button5, R.id.button6})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                StudentDaoOpe.insertData(this, studentList);
                break;
            case R.id.button2:
                Student student = new Student((long) 5, "haung" + 5, 25, "123456", "0", 2, 3);
                /**
                 * 根据特定的对象删除
                 *//*
                StudentDaoOpe.deleteData(this, student);
                /**
             * 根据主键删除
             */
                StudentDaoOpe.deleteByKeyData(this, 7);
                StudentDaoOpe.deleteAllData(this);
                break;
            case R.id.button3:
                student = new Student((long) 2, "caojin", 1314, "888888", "1", 2, 3);
                StudentDaoOpe.updateData(this, student);
                break;
            case R.id.button4:
                List<Student> students = StudentDaoOpe.queryAll(this);
                tvContent.setText(students.toString());
                for (int i = 0; i < students.size(); i++) {
                    Log.i("Log", students.toString());
                }
                break;
            case R.id.button5:
                StudentDaoOpe.deleteAllData(this);
                break;
            case R.id.btn_query_all:
                List<Student> students2 = StudentDaoOpe.queryPaging(page, 20, this);

                if (students2.size() == 0) {
                    Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                }
                for (Student st : students2) {
                    Log.e("TAG", "onViewClicked: ==" + st);
                    Log.e("TAG", "onViewClicked: == num = " + st.getNum());
                }
                page++;
                tvContent.setText(students2.toString());
                break;
            case R.id.button6:
                deal();
                break;
        }
    }
}
