package com.example.first;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
            {"Doctor Name :Ajit Saste","Hospital Address:Pimpri","Exp:5+yrs","Mobile No:987654321","600"},
            {"Doctor Name :Priyanka Saste","Hospital Address:Nigdi","Exp:4+yrs","Mobile No:754419130","500"},
            {"Doctor Name :Swanil Kaushik","Hospital Address:Bandra","Exp:10+yrs","Mobile No:9741531313","1000"},
            {"Doctor Name :Deepak Deshmukh","Hospital Address:Juhu","Exp:9yrs","Mobile No:9215493464","900"},
            {"Doctor Name :Ashok Dande","Hospital Address:Katra","Exp:8+yrs","Mobile No:9948715533","800"},
    };
    private String[][] doctor_details2=
            {
                    {"Doctor Name:Dr. Neha Verma","Hospital Name:Wellness Diet Clinic,21 Park Lane,Delhi","Exp:6 years","Mobile No:+91-9876543211","400"},
                    {"Doctor Name:Dr. Amit Roy","Hospital Name:NutriFit Centre,55 Banjara Hills,Hyderabad","Exp:9 years","Mobile No:+91-9823127890","600"},
                    {"Doctor Name:Dr. Sneha Kapoor","Hospital Name:Health First Nutrition,100 Residency Road,Bangalore","Exp:4 years","Mobile No:+91-9012376458","350"},
                    {"Doctor Name:Dr. Rohit Singh","Hospital Name:FitLife Diet Hub,7 Carter Road,Mumbai","Exp:10 years","Mobile No:+91-9988772233","500"},
                    {"Doctor Name:Dr. Meenal Joshi","Hospital Name:Balanced Bites Clinic,45 Civil Lines,Jaipur","Exp:7 years","Mobile No:+91-9090909091","450"}

            };

    private String[][] doctor_details3=
            {
                    {"Doctor Name:Dr. Anjali Mehra","Hospital Name:Smile Dental Care,12 Green Avenue,Delhi","Exp:8 years","Mobile No:+91-9876543210","500"},
                    {"Doctor Name:Dr. Rakesh Nair","Hospital Name:BrightSmile Clinic,45 MG Road,Mumbai","Exp:12 years","Mobile No:+91-9823123456","700"},
                    {"Doctor Name:Dr. Priya Sharma","Hospital Name:Tooth & Gum Centre,87 Nehru Street,Pune","Exp:5 years","Mobile No:+91-9012345678","400"},
                    {"Doctor Name:Dr. Aman Khurana","Hospital Name:White Pearl Dental Studio,33 Jubilee Hills,Hyderabad","Exp:10 years","Mobile No:+91-9988776655","600"},
                    {"Doctor Name:Dr. Kavita Rao","Hspital Name:Happy Teeth Dental,78 Rajpath Nagar,Bangalore","Exp:7 years","Mobile No:+91-9090909090","550"},
            };
    private String[][] doctor_details4=
            {
                    {"Doctor Name:Dr. Arvind Sinha","Hospital Name:Apex Surgical Centre,34 MG Road,Delhi","Exp:15 years","Mobile No:+91-9876543222","1200"},
                    {"Doctor Name:Dr. Meera Deshmukh","Hospital Name:CityCare Hospital,22 FC Road,Pune","Exp:10 years","Mobile No:+91-9823121111","1000"},
                    {"Doctor Name:Dr. Rajeev Kumar","Hospital Name:Global Health Surgery,88 Ring Road,Lucknow","Exp:13 years","Mobile No:+91-9012371234","1100"},
                    {"Doctor Name:Dr. Shalini Reddy","Hospital Name:MedStar Surgical Unit,76 Jubilee Hills,Hyderabad","Exp:11 years","Mobile No:+91-9988774455","950"},
                    {"Doctor Name:Dr. Vikram Chauhan","Hospital Name:Premier Surgical Institute,59 Park Avenue,Bangalore","Exp:14 years","Mobile No:+91-9090901234","1050"}

            };
    private String[][] doctor_details5=
            {
                    {"Doctor Name:Dr. Neha Kapoor","Hospital Name:HeartCare Hospital,21 South Extension,Delhi","Exp:16 years","Mobile No:+91-9876512345","1500"},
                    {"Doctor Name:Dr. Rohit Bansal","Hospital Name:Pulse Cardiac Centre,50 Linking Road,Mumbai","Exp:12 years","Mobile No:+91-9823456789","1300"},
                    {"Doctor Name:Dr. Anuradha Mishra","Hospital Name:CardioLife Clinic,90 JM Road,Pune","Exp:10 years","Mobile No:+91-9012987654","1250"},
                    {"Doctor Name:Dr. Deepak Iyer","Hospital Name:Elite Heart Institute,66 Banjara Hills,Hyderabad","Exp:14 years","Mobile No:+91-9988123456","1400"},
                    {"Doctor Name:Dr. Swati Verma","Hospital Name:Advanced Cardiac Care,39 Residency Road,Bangalore","Exp:11 years","Mobile No:+91-9090876543","1350"}

            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doctor_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tv;
        Button btn;
        String[][] doctor_details={};
        HashMap<String,String> item;
        ArrayList list;
        SimpleAdapter sa;
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
            if(title.compareTo("Dietician")==0)
                doctor_details=doctor_details2;
            else
                if(title.compareTo("Dentist")==0)
                    doctor_details=doctor_details3;
                else
                    if (title.compareTo("Surgeon")==0)
                        doctor_details=doctor_details4;
                    else
                        doctor_details=doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list =new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fee:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details1[i][0]);
                it.putExtra("text3",doctor_details3[i][1]);
                it.putExtra("text4",doctor_details4[i][3]);
                it.putExtra("text5",doctor_details5[i][4]);
                startActivity(it);

            }
        });
    }
}