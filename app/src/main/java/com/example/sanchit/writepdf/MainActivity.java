package com.example.sanchit.writepdf;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private static final int STORAGE_CODE = 1000 ;
    private EditText Name, dob, langKwn,Phno,Email,Address,Abstract,DegName,BranchName,ClgName,Fyp,Fypc,Syp,Sypc,Typ,Typc,DBranch,Dyear,DClgName,DPerc;
   private EditText SYear,SName,SPerc,TS1,TS2,TS3,TS4,C1Name,C1IName,C1Sdate,C1Edate,C2Name,C2IName,C2Sdate,C2Edate;
   private EditText p1,p2,p3,Exp,I1,I2,I3,place,lastUpdate;
    private Button mSaveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Name = (EditText)findViewById(R.id.EtName);
        Email = (EditText)findViewById(R.id.email);
        Phno = (EditText)findViewById(R.id.phno);
        dob = (EditText)findViewById(R.id.Et_Place);
        langKwn = (EditText)findViewById(R.id.Et_Place2);
        Address = (EditText) findViewById(R.id.address);
        Abstract = (EditText) findViewById(R.id.abstract_details);
        DegName = (EditText) findViewById(R.id.degree_name);
        BranchName = (EditText) findViewById(R.id.stream_name);
        ClgName = (EditText) findViewById(R.id.clg_name);
        Fyp = (EditText) findViewById(R.id.fy_year);
        Fypc = (EditText) findViewById(R.id.fy_perct);
        Syp = (EditText) findViewById(R.id.sy_year);
        Sypc = (EditText) findViewById(R.id.sy_perct);
        Typ = (EditText) findViewById(R.id.ty_year);
        Typc = (EditText) findViewById(R.id.ty_perct);
        DBranch = (EditText) findViewById(R.id.d_branch);
        Dyear = (EditText) findViewById(R.id.d_year);
        DClgName = (EditText) findViewById(R.id.d_clgName);
        DPerc = (EditText) findViewById(R.id.d_perct);
        SYear = (EditText) findViewById(R.id.s_year);
        SName = (EditText) findViewById(R.id.s_clgName);
        SPerc = (EditText) findViewById(R.id.s_perct);
        TS1 = (EditText) findViewById(R.id.ts1);
        TS2 = (EditText) findViewById(R.id.ts2);
        TS3 = (EditText) findViewById(R.id.ts3);
        TS4 = (EditText) findViewById(R.id.ts4);
        C1Name = (EditText) findViewById(R.id.c1_name);
        C1IName = (EditText) findViewById(R.id.c1_instName);
        C1Sdate = (EditText) findViewById(R.id.c1_startDate);
        C1Edate = (EditText) findViewById(R.id.c1_endDate);
        C2Name = (EditText) findViewById(R.id.c2_name);
        C2IName = (EditText) findViewById(R.id.c2_instName);
        C2Sdate = (EditText) findViewById(R.id.c2_startDate);
        C2Edate = (EditText) findViewById(R.id.c2_endDate);
        p1 = (EditText) findViewById(R.id.p1);
        p2 = (EditText) findViewById(R.id.p2);
        p3 = (EditText) findViewById(R.id.p3);
        Exp = (EditText) findViewById(R.id.pro_exp);
        I1 = (EditText) findViewById(R.id.I1);
        I2 = (EditText) findViewById(R.id.I2);
        I3 = (EditText) findViewById(R.id.I3);
        place = (EditText) findViewById(R.id.place);
        lastUpdate = (EditText) findViewById(R.id.last_update);

        mSaveBtn = (Button) findViewById(R.id.saveBtn);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M)
                {
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)==
                            PackageManager.PERMISSION_DENIED)
                    {
                        String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission,STORAGE_CODE);

                    }else
                    {
                        savePdf();

                    }
                }else
                {
                    savePdf();

                }

            }
        });







    }

    private void savePdf() {

        com.itextpdf.text.Document mDoc = new com.itextpdf.text.Document();
        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        String mFilePath = Environment.getExternalStorageDirectory() + "/" + mFileName + ".pdf";

        try {
            PdfWriter .getInstance(mDoc, new FileOutputStream(mFilePath));
            mDoc.open();


            String txtName = Name.getText().toString().trim();
            String txtemail = Email.getText().toString().trim();
            String txtphno = Phno.getText().toString().trim();
            String txtdob = dob.getText().toString().trim();
            String txtlangkwn = langKwn.getText().toString().trim();
            String txtaddress = Address.getText().toString().trim();
            String txtabstract = Abstract.getText().toString().trim();
            String txtDegName = DegName.getText().toString().trim();
            String txtBranchName = BranchName.getText().toString().trim();
            String txtClgName = ClgName.getText().toString().trim();
            String txtFyp = Fyp.getText().toString().trim();
            String txtFypc = Fypc.getText().toString().trim();
            String txtSyp = Syp.getText().toString().trim();
            String txtSypc = Sypc.getText().toString().trim();
            String txtTyp = Typ.getText().toString().trim();
            String txtTypc = Typc.getText().toString().trim();
            String txtDBranch = DBranch.getText().toString().trim();
            String txtDyear = Dyear.getText().toString().trim();
            String txtDClgName = DClgName.getText().toString().trim();
            String txtDPerc = DPerc.getText().toString().trim();
            String txtSYear = SYear.getText().toString().trim();
            String txtSName = SName.getText().toString().trim();
            String txtSPerc = SPerc.getText().toString().trim();
            String txtTS1 = TS1.getText().toString().trim();
            String txtTS2 = TS2.getText().toString().trim();
            String txtTS3 = TS3.getText().toString().trim();
            String txtTS4 = TS4.getText().toString().trim();
            String txtC1Name = C1Name.getText().toString().trim();
            String txtC1IName = C1IName.getText().toString().trim();
            String txtC1Sdate = C1Sdate.getText().toString().trim();
            String txtC1Edate = C1Edate.getText().toString().trim();
            String txtC2Name = C2Name.getText().toString().trim();
            String txtC2IName = C2IName.getText().toString().trim();
            String txtC2Sdate = C2Sdate.getText().toString().trim();
            String txtC2Edate = C2Edate.getText().toString().trim();
            String txtp1 = p1.getText().toString().trim();
            String txtp2 = p2.getText().toString().trim();
            String txtp3 = p3.getText().toString().trim();
            String txtExp = Exp.getText().toString().trim();
            String txtI1 = I1.getText().toString().trim();
            String txtI2 = I2.getText().toString().trim();
            String txtI3 = I3.getText().toString().trim();
            String txtplace = place.getText().toString().trim();
            String txtlastUpdate = lastUpdate.getText().toString().trim();

            if(txtName.isEmpty())
            {
                Name.setError("this cannot be Empty");
                Name.requestFocus();

            }else if(txtemail.isEmpty())
            {
                Email.setError("this cannot be Empty");
                Email.requestFocus();

            }else if(txtphno.isEmpty())
            {
                Phno.setError("this cannot be Empty");
                Phno.requestFocus();

            }else if(txtdob.isEmpty())
            {
                dob.setError("this cannot be Empty");
                dob.requestFocus();

            }else if(txtlangkwn.isEmpty())
            {
                langKwn.setError("this cannot be Empty");
                langKwn.requestFocus();

            }else if(txtaddress.isEmpty())
            {
                Address.setError("this cannot be Empty");
                Address.requestFocus();

            }else if(txtabstract.isEmpty())
            {
                Abstract.setError("this cannot be Empty");
                Abstract.requestFocus();

            }else if(txtDegName.isEmpty())
            {
                DegName.setError("this cannot be Empty");
                DegName.requestFocus();

            }else if(txtBranchName.isEmpty())
            {
                BranchName.setError("this cannot be Empty");
                BranchName.requestFocus();

            }else if(txtClgName.isEmpty())
            {
                ClgName.setError("this cannot be Empty");
                ClgName.requestFocus();

            }else if(txtFyp.isEmpty())
            {
                Fyp.setError("this cannot be Empty");
                Fyp.requestFocus();

            }else if(txtFypc.isEmpty())
            {
                Fypc.setError("this cannot be Empty");
                Fypc.requestFocus();

            }else if(txtSyp.isEmpty())
            {
                Syp.setError("this cannot be Empty");
                Syp.requestFocus();

            }else if(txtSypc.isEmpty())
            {
                Sypc.setError("this cannot be Empty");
                Sypc.requestFocus();

            }else if(txtTyp.isEmpty())
            {
                Typ.setError("this cannot be Empty");
                Typ.requestFocus();

            }else if(txtTypc.isEmpty())
            {
                Typc.setError("this cannot be Empty");
                Typc.requestFocus();

            }else if(txtDBranch.isEmpty())
            {
                DBranch.setError("this cannot be Empty");
                DBranch.requestFocus();

            }else if(txtDyear.isEmpty())
            {
                Dyear.setError("this cannot be Empty");
                Dyear.requestFocus();

            }else if(txtDClgName.isEmpty())
            {
                DClgName.setError("this cannot be Empty");
                DClgName.requestFocus();

            }else if(txtDPerc.isEmpty())
            {
                DPerc.setError("this cannot be Empty");
                DPerc.requestFocus();

            }else if(txtSName.isEmpty())
            {
                SName.setError("this cannot be Empty");
                SName.requestFocus();

            }else if(txtSPerc.isEmpty())
            {
                SPerc.setError("this cannot be Empty");
                SPerc.requestFocus();

            }else if(txtTS1.isEmpty())
            {
                TS1.setError("this cannot be Empty");
                TS1.requestFocus();

            }else if(txtTS2.isEmpty())
            {
                TS2.setError("this cannot be Empty");
                TS2.requestFocus();

            }else if(txtTS3.isEmpty())
            {
                TS3.setError("this cannot be Empty");
                TS3.requestFocus();

            }else if(txtTS4.isEmpty())
            {
                TS4.setError("this cannot be Empty");
                TS4.requestFocus();

            }else if(txtC1Name.isEmpty())
            {
                C1Name.setError("this cannot be Empty");
                C1Name.requestFocus();

            }else if(txtC1IName.isEmpty())
            {
                C1IName.setError("this cannot be Empty");
                C1IName.requestFocus();

            }else if(txtC1Sdate.isEmpty())
            {
                C1Sdate.setError("this cannot be Empty");
                Email.requestFocus();

            }else if(txtC1Edate.isEmpty())
            {
                C1Edate.setError("this cannot be Empty");
                C1Edate.requestFocus();

            }else if(txtC2Name.isEmpty())
            {
                C2Name.setError("this cannot be Empty");
                C2Name.requestFocus();

            }else if(txtC2IName.isEmpty())
            {
                C2IName.setError("this cannot be Empty");
                C2IName.requestFocus();

            }else if(txtC2Sdate.isEmpty())
            {
                C2Sdate.setError("this cannot be Empty");
                C2Sdate.requestFocus();

            }else if(txtC2Edate.isEmpty())
            {
                C2Edate.setError("this cannot be Empty");
                C2Edate.requestFocus();

            }else if(txtp1.isEmpty())
             {
            p1.setError("this cannot be Empty");
            p1.requestFocus();

             }else if(txtp2.isEmpty())
            {
                p2.setError("this cannot be Empty");
                p2.requestFocus();

            }else if(txtp3.isEmpty())
            {
                p3.setError("this cannot be Empty");
                p3.requestFocus();

            }else if(txtExp.isEmpty())
            {
                Exp.setError("this cannot be Empty");
                Exp.requestFocus();

            }else if(txtI1.isEmpty())
            {
                I1.setError("this cannot be Empty");
                I1.requestFocus();

            }else if(txtI2.isEmpty())
            {
                I2.setError("this cannot be Empty");
                I2.requestFocus();

            }else if(txtI3.isEmpty())
            {
                I3.setError("this cannot be Empty");
                I3.requestFocus();

            }else if(txtplace.isEmpty())
            {
                place.setError("this cannot be Empty");
                place.requestFocus();

            }else if(txtlastUpdate.isEmpty())
            {
                lastUpdate.setError("this cannot be Empty");
                lastUpdate.requestFocus();

            }else {


                mDoc.addAuthor("Sanchit Shinde");


                mDoc.add(new Paragraph("" + txtName));
                mDoc.add(new Paragraph("____________________________________________________________________"));
                mDoc.add(new Paragraph("Personal Information:-"));
                mDoc.add(new Paragraph("\uF0B7- Email-ID                     " + txtemail));
                mDoc.add(new Paragraph("\uF0B7- Contact                      " + txtphno));
                mDoc.add(new Paragraph("\uF0B7- Date of Birth                " + txtdob));
                mDoc.add(new Paragraph("\uF0B7- Languages known         " + txtlangkwn));
                mDoc.add(new Paragraph("\uF0B7- Address                 " + txtaddress));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtabstract));

                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Academic Qualification: -"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Currently pursuing " + txtDegName + ". " + txtBranchName + " from " + txtClgName));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Exam                Year of Passing     CGPA"));
                mDoc.add(new Paragraph("First Year              " + txtFyp + "                      " + txtFypc));
                mDoc.add(new Paragraph("Second Year            " + txtSyp + "                      " + txtSypc));
                mDoc.add(new Paragraph("Final Year              " + txtTyp + "                      " + txtTypc));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("DIPLOMA " + txtDBranch + "                       " + txtDyear));
                mDoc.add(new Paragraph(txtDClgName + "    Result –  " + txtDPerc));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("SSC                                                       " + txtSYear));
                mDoc.add(new Paragraph(txtSName + "                                        Result – " + txtSPerc));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Technical Skills: -"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtTS1));
                mDoc.add(new Paragraph(" " + txtTS2));
                mDoc.add(new Paragraph(" " + txtTS3));
                mDoc.add(new Paragraph(" " + txtTS4));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Certifications: -"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtC1Name));
                mDoc.add(new Paragraph("- " + txtC1IName + "(" + txtC1Sdate + "-" + txtC1Edate + ")"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtC2Name));
                mDoc.add(new Paragraph("- " + txtC2IName + "(" + txtC2Sdate + "-" + txtC2Edate + ")"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Projects: -"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtp1));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtp2));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtp3));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Professional Experience : -"));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" " + txtExp));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Interests: -"));
                mDoc.add(new Paragraph(" " + txtI1));
                mDoc.add(new Paragraph(" " + txtI2));
                mDoc.add(new Paragraph(" " + txtI3));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph(" "));
                mDoc.add(new Paragraph("Place: " + txtplace));
                mDoc.add(new Paragraph("Last updated on: " + txtlastUpdate));


                mDoc.close();

                Toast.makeText(this, mFileName + ".pdf\n is saved to \n" + mFilePath, Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case STORAGE_CODE: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    savePdf();

                }else{
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
