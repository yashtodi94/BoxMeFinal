package com.example.malicious.boxmefinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Base64InputStream;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;




public class NumActivity extends ActionBarActivity {


    private Button dialerButton, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0,b11,b12,b13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_num);
//
//
//        b1 = (Button) findViewById(R.id.buttonNum1);
//        b2 = (Button) findViewById(R.id.buttonNum2);
//        b3 = (Button) findViewById(R.id.buttonNum3);
//        b4 = (Button) findViewById(R.id.buttonNum4);
//        b5 = (Button) findViewById(R.id.buttonNum5);
//        b6 = (Button) findViewById(R.id.buttonNum6);
//        b7 = (Button) findViewById(R.id.buttonNum7);
//        b8 = (Button) findViewById(R.id.buttonNum8);
//        b9 = (Button) findViewById(R.id.buttonNum9);
//        b0 = (Button) findViewById(R.id.buttonNum0);
//

    }




    public void onClick(View view) throws Exception {

//        try {
        String decrypted = null;

        EditText NumText = (EditText) findViewById(R.id.NumText);

        String Ph = new String(NumText.getText().toString().trim());
        String decryptedNum = decryption(Ph);
        String FinalPh = new String("tel:" + decryptedNum);

        SharedPreferences prefs = getSharedPreferences("num_pref", MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("Number", decryptedNum);
        edit.commit();

        Intent contact_add = new Intent(this, AddContact.class);
        contact_add.putExtra("phoneNumber", decryptedNum);
        startActivity(contact_add);

        Intent Calling = new Intent(Intent.ACTION_CALL, Uri.parse(FinalPh));
        startActivity(Calling);

//        Intent callLog_delete = new Intent(this, DeleteCallLog.class);
//        callLog_delete.putExtra("phoneNumber", Ph);
//        startActivity(callLog_delete);

//        Intent contact_delete = new Intent(this, DeleteContact.class);
//        contact_delete.putExtra("phoneNumber", Ph);
//        startActivity(contact_delete);
//
//        Intent callLog_delete = new Intent(this, DeleteCallLog.class);
//        callLog_delete.putExtra("phoneNumber", Ph);
//        startActivity(callLog_delete);
//          startActivity(new Intent(this, DialerScreen.class));
//        }
//
//        catch (Exception ex) {
//            //TODO
//        }


    }





    public String decryption(String Ph) {

        long encrypt = Long.parseLong(Ph);
        long decrypt = (encrypt * 2);
        decrypt = decrypt * 2;
        decrypt = decrypt - 2;
        decrypt = decrypt / 2;
        return String.valueOf(decrypt+1);

    }






//    public static String decrypt(String encryptedData) throws Exception {
//        Key key = generateKey();
//        Cipher c = Cipher.getInstance(ALGO);
//        c.init(Cipher.DECRYPT_MODE, key);
////        byte[] result = Base64.decode(encryptedData, Base64.DEFAULT);
//  //     byte[] encodedBytes  = Base64.encode(encryptedData.getBytes(), Base64.DEFAULT);
//
//        InputStream inputStream = new InputStream() {
//            @Override
//            public int read() throws IOException {
//
//                return 0;
//            }
//        };
//        byte[] decodedString = new Bas;
//
//
////        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
//        byte[] decValue = c.doFinal(decodedString);
//        String decryptedValue = new String(decValue);
//        return decryptedValue;
//    }
//    private static Key generateKey() throws Exception {
//        Key key = new SecretKeySpec(keyValue, ALGO);
//        return key;
//    }
}
