package com.example.uesb_usr.cestabasicaapp.util;

import com.example.uesb_usr.cestabasicaapp.modelos.User;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UserDes implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement user = json.getAsJsonObject();
        if(json.getAsJsonObject().get("user")!= null){
            user = json.getAsJsonObject();
        }

        return (new Gson().fromJson(user, User.class));
    }
}
