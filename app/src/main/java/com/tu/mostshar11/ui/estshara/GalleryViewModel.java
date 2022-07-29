package com.tu.mostshar11.ui.estshara;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GalleryViewModel extends ViewModel {

    private MutableLiveData<String> mText;
String name;
String content;
    public GalleryViewModel(String name,String content) {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
        this.name=name;
        this.content=content;

    }

    public GalleryViewModel() {
    }

    public LiveData<String> getText() {
        return mText;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }
}