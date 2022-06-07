package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.cometchat.pro.constants.CometChatConstants;
import com.cometchat.pro.core.CometChat;
import com.cometchat.pro.core.MessagesRequest;
import com.cometchat.pro.exceptions.CometChatException;
import com.cometchat.pro.models.BaseMessage;
import com.cometchat.pro.models.CustomMessage;
import com.cometchat.pro.models.MediaMessage;
import com.cometchat.pro.models.TextMessage;
import com.example.myapplication.models.MessageWrapper;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    private String groupId;
    private MessagesListAdapter<IMessage> adapter;

    public static void start(Context context, String groupId) {
        Intent starter = new Intent(context, ChatActivity.class);
        starter.putExtra(Constants.GROUP_ID, groupId);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        if (intent != null) {
            groupId = intent.getStringExtra(Constants.GROUP_ID);
        }

        initViews();
        addListener();

        fetchPreviousMessages();

    }

    private void fetchPreviousMessages() {
        MessagesRequest messagesRequest = new MessagesRequest.MessagesRequestBuilder().setGUID(groupId).build();
        messagesRequest.fetchPrevious(new CometChat.CallbackListener<List<BaseMessage>>() {
            @Override
            public void onSuccess(List<BaseMessage> baseMessages) {
                addMessages(baseMessages);
            }

            @Override
            public void onError(CometChatException e) {

            }
        });
    }

    private void addMessages(List<BaseMessage> baseMessages) {
        List<IMessage> list = new ArrayList<>();
        for (BaseMessage message : baseMessages) {
            if (message instanceof TextMessage) {
                list.add(new MessageWrapper((TextMessage) message));
            }
        }

        adapter.addToEnd(list, true);
    }

    private void addListener() {
        String listenerID = "listener 1";
        CometChat.addMessageListener(listenerID, new CometChat.MessageListener() {
            @Override
            public void onTextMessageReceived(TextMessage textMessage) {
                addMessage(textMessage);
            }
            @Override
            public void onMediaMessageReceived(MediaMessage mediaMessage) {

            }
            @Override
            public void onCustomMessageReceived(CustomMessage customMessage) {
            }
        });
    }
}

    private void initViews() {

        MessageInput inputView = findViewById(R.id.input);
        MessagesList messagesList = findViewById(R.id.messagesList);
        inputView.setInputListener(input -> {
            sendMessage(input.toString());
            return true;
        });
        String senderId = CometChat.getLoggedInUser().getUid();
        ImageLoader imageLoader = (imageView, url, payload) -> Picasso.get().load(url).into(imageView);
         adapter = new MessagesListAdapter<>(senderId, imageLoader);
        messagesList.setAdapter(adapter);
    }

    private void sendMessage(String message) {
        TextMessage textMessage = new TextMessage(groupId, message, CometChatConstants.MESSAGE_TYPE_TEXT, CometChatConstants.RECEIVER_TYPE_GROUP);

        CometChat.sendMessage(textMessage, new CometChat.CallbackListener<TextMessage>() {
            @Override
            public void onSuccess(TextMessage textMessage) {
                addMessage(textMessage);
            }

            @Override
            public void onError(CometChatException e) {

            }
        });
    }

    private void addMessage(TextMessage textMessage) {

        adapter.addToStart(new MessageWrapper(textMessage), true);
    }
}