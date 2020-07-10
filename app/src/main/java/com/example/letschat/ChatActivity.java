package com.example.letschat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.letschat.databinding.ActivityChatBinding;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.letschat.rest.RetrofitSingleton;
import com.example.letschat.rest.serializers.user.User;
import com.example.letschat.rest.service.UserService;
import com.google.gson.Gson;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

public class ChatActivity extends AppCompatActivity {
//    class msgroombag {
//        private String name="ssa";
//        private String message="ccdcd";
//        msgroombag(String name, String message) {
//            // no-args constructor
//            this.name=name;
//            this.message=message;
//        }
//    }
//    private Socket mSocket;
//    {//30602
//        try {
//            mSocket = IO.socket("https://mystoryblogs.herokuapp.com"); // Your server's URL
//        }
//        catch ( URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//    }
    ArrayList<String> messages=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gson gson=new Gson();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ActivityChatBinding binding=ActivityChatBinding.inflate(getLayoutInflater());
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.setAdapter(new ChatAdapter(messages,this));
        UserService service = RetrofitSingleton.getRetrofitInstance(ChatActivity.this).create(UserService.class);

        Call<User> callAsync = service.refreshToken();

        callAsync.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
//       binding.sendbutton.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//             String text=  binding.messagetext.getText().toString();
//             mSocket.emit("message",gson.toJson(new msgroombag(getSharedPreferences(CONSTANTS.SharedPreferenceName,0).getString("name","default"),text)));
//           }
//       });
//        mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError);
//        mSocket.on(Socket.EVENT_CONNECT_TIMEOUT, onConnectError);
//        mSocket.connect();
////        mSocket.emit("subscribe",new IDNameBag());
//
//
//        mSocket.emit("subscribe",getSharedPreferences(CONSTANTS.SharedPreferenceName,0).getString("name","default"));
//
//        mSocket.on("newuser", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        messages.add(""+args[0].toString()+":"+args[0].toString());
//                        binding.recyclerview.setAdapter(new ChatAdapter(messages,getApplicationContext()));
//                    }
//                });
//
//            }
//        });
//        mSocket.on("message", new Emitter.Listener() {
//            @Override
//            public void call(Object... args) {
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        messages.add(args[0].toString());
//                        binding.recyclerview.setAdapter(new ChatAdapter(messages,getApplicationContext()));
//                    }
//                });
//
//            }
//        });
//        binding.connect.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                try {
//                    Log.d("coming","hey");
//                    Log.d("coming","hey");
//                    //This address is the way you can connect to localhost with AVD(Android Virtual Device)
//                  mSocket = IO.socket("http://localhost:3000");
//                   Log.d("socket",""+mSocket);
////                    Log.d("success", mSocket.id());
//
//                } catch ( Exception e) {
//                    Log.e("onclick", "onClick: "+e );
//                    Log.d("fail", "Failed to connect");
//                }
//                mSocket.connect();
//                mSocket.emit("subscribe","hi");
//            }
//        });
        setContentView(binding.getRoot());
    }
    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), "Unable to connect to NodeJS server", Toast.LENGTH_LONG).show();
                }
            });
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mSocket.emit("disconnecting", getSharedPreferences(CONSTANTS.SharedPreferenceName, 0).getString("name", "default"));
    }
}
