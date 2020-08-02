package com.example.fci_community.Dr_Tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fci_community.Firebase.PostItems;
import com.example.fci_community.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class DoctorAddPostActivity extends AppCompatActivity {

    private EditText etWritPost;
    private ImageView imageViewPost;
    private Button buttonSharPost;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Uri picturUri;
    private final int PReqCode=1;
    private final int REQUESCODE=1;

    static String id= UUID.randomUUID().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_add_post);

        etWritPost=(EditText)findViewById(R.id.edittext_addPost);
        imageViewPost=(ImageView)findViewById(R.id.image_addPost);
        buttonSharPost=(Button)findViewById(R.id.btn_sharePost);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("Groups");

        setupPost();

        imageViewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGallery();
            }
        });
    }

    private void setupPost() {

        buttonSharPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etWritPost.getText().toString().isEmpty() || imageViewPost !=null)
                {
                    StorageReference storageReference = FirebaseStorage.getInstance().getReference("FCI_imagePost");
                    final StorageReference imagePath = storageReference.child(picturUri.getLastPathSegment());
                    imagePath.putFile(picturUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            imagePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {

                                    String imadeDownload=uri.toString();

                                    PostItems postItems=new PostItems(etWritPost.getText().toString(),imadeDownload);
                                    addPosttoDatabase(postItems);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    showMessage(e.getMessage());
                                }
                            });

                        }
                    });
                }
            }
        });
    }

    private void addPosttoDatabase(PostItems postItems) {

       // String key =databaseReference.getKey();
        postItems.setPostKey(id);

        databaseReference.child(dr_Lecture.Nahola).child("Subjects").
                child(ManageLectureActivity.Dr_itemName).child("post").child(id).setValue(postItems)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        showMessage("successful");
                    }
                });
    }

    private void showMessage(String message) {
        Toast.makeText(DoctorAddPostActivity.this,message,Toast.LENGTH_SHORT).show();
    }

    private void checkGallery() {

        if (ContextCompat.checkSelfPermission(DoctorAddPostActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(DoctorAddPostActivity.this,Manifest.permission.ACTIVITY_RECOGNITION))
            {
                Toast.makeText(DoctorAddPostActivity.this,"Please permission to access gallery",Toast.LENGTH_SHORT).show();
            }

            else
            {
                ActivityCompat.requestPermissions(DoctorAddPostActivity.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},PReqCode);
            }
        }

        else
        {
            openGallery();
        }


    }

    private void openGallery() {

        Intent galleryIntent=new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent,REQUESCODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode ==REQUESCODE && resultCode ==RESULT_OK && data != null)
        {
            picturUri=data.getData();
            imageViewPost.setImageURI(picturUri);
        }
    }


}
