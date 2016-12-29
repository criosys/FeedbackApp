package com.example;

import org.springframework.context.annotation.Bean;

/**
 * Created by n0148661 on 11/9/16.
 */
public class SlackMessage {

    public SlackMessage(String text) {
        this.text = text;
    }

    private String text;



    public SlackMessage() {
    }

    public String getText() {


        return text;

    }

    public void setText(String text) {
        this.text = text;
    }
}



/*

    <input type="button" class="button" value="DELIGHTED" onclick="postTest('delighted')" /><br>
    <input type="button" class="button" value="HAPPY" onclick='postTest("happy")' /><br>
    <input type="button" class="button" value="INDIFFERENT" onclick='postTest("indifferent")' /><br>
    <input type="button" class="button" value="SAD" onclick='postTest("sad")' /><br>
    <input type="button" class="button" value="DISTRAUGHT" o
 */