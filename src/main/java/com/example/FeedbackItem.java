package com.example;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by n0148661 on 10/28/16.
 */
public class FeedbackItem {

    private String description;
    private Date time;

    public FeedbackItem(String description) {
        this.description = description;
        Date now = new Date();
        this.time = now;
    }


    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Autowired
    public FeedbackItem(String description, Date time) {
        this.time = time;
        this.description = description;
    }

    public FeedbackItem() {
    }

    public String getDescription() {
        if (description.equalsIgnoreCase("delighted")) {
            description = description + " :grinning:";
        } else if (description.equalsIgnoreCase("happy")) {
            description = description + " :slightly_smiling_face:";
        } else if (description.equalsIgnoreCase("indifferent")) {
            description = description + " :neutral_face:";
        }else if (description.equalsIgnoreCase("sad")) {
            description = description + " :slightly_frowning_face:";
        }else if (description.equalsIgnoreCase("distraught")) {
            description = description + " :anguished:";
        }

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
