package com.example.nhom10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.example.demoapp.model.User;
import com.google.gson.Gson;
public class RegisterActivity extends AppCompatActivity {
    private EditText edUserNameC;
    private EditText edPassWordC;
    private EditText edConfirmPasswordC;
    private EditText edEmailC;
    private EditText edPhoneNumberC;
    private RadioGroup rbSex;
    private Button btnRegister;
    private ImageButton imbBack;
    private SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    private final com.example.nhom10.Gson gson = new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Register");
//Khai báo Shared Preferences
        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP,  Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
//Ánh xạ các component từ giao diện vào các biến cục bộ
        AnhXaDuLieu();
//Đăng kí sự kiện cho 2 nút
        TaoSuKien();
    }
    void AnhXaDuLieu() {
        edUserNameC = findViewById(R.id.edUserNameRe);
        edPassWordC = findViewById(R.id.edPassWordRe);
        edConfirmPasswordC = findViewById(R.id.edConfirmPassRe);
        edEmailC = findViewById(R.id.edEmailRe);
        edPhoneNumberC = findViewById(R.id.edPhoneRe);
        rbSex = findViewById(R.id.rgGioiTinh);
        btnRegister = findViewById(R.id.btnRegisterRe);
        imbBack = findViewById(R.id.imbBack);
    }
    void TaoSuKien() {
        btnRegister.setOnClickListener(v -> SuKienRegister());
        imbBack.setOnClickListener(v -> finish());
    }
    void SuKienRegister() {
        String userName = edUserNameC.getText().toString().trim();
        String password = edPassWordC.getText().toString().trim();
        String confirmPassword =
                edConfirmPasswordC.getText().toString().trim();
        String email = edEmailC.getText().toString().trim();
        String phone = edPhoneNumberC.getText().toString().trim();
//Nếu sex = 1 là nam, ngược lại nữ
        int sex = 1;
        boolean isValid = CheckUserName(userName) && CheckPassword(password,
                confirmPassword);
        if(isValid) {
//Khi dữ liệu hợp lệ, tạo đối tượng User để lưu vào Shared
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setPassWord(password);
            newUser.setEmail(email);
            newUser.setPhoneNumber(phone);
//Lấy thông tin radiobutton đang được checked
            int sexSelected = rbSex.getCheckedRadioButtonId();
            if(sexSelected == R.id.rbNu) //Giới tính nữ
            {

                sex = 0;
            }
            newUser.setSex(sex);

            String StrUser = gson.toJson(newUser);
            editor.putString(Utils.KEY_USER, StrUser);
            editor.commit();
//Thông báo đăng kí thành công bằng Toast
            Toast.makeText(RegisterActivity.this, "Đăng kí tài khoản thành công", Toast.LENGTH_LONG).show();
//Hoàn thành
                    finish();
        }
    }
    boolean CheckUserName(String username)
    {
        if(username.isEmpty()) {
            edUserNameC.setError("Vui lòng nhập tên đăng nhập");
            return false;
        }
        return true;
    }
    boolean CheckPassword(String password, String confirmPassword)
    {
        if(password.isEmpty()) {
            edPassWordC.setError("Vui lòng nhập mật khẩu");
            return false;
        }
        if(!password.equals(confirmPassword)) {
            edConfirmPasswordC.setError("Xác nhận mật khẩu không khớp");
            return false;
        }
        return true;
    }
}