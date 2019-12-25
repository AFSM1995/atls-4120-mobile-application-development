package com.example.lab_8;

import java.util.Random;

public class Data_structure {
    private String answer;
    private String horoscopeURL = "https://www.astrology.com/horoscope/daily.html";
    private String secretQuestion;
    private Integer color;
    private Integer number;

    private void fortune() {
        Random rand = new Random();
        int n = rand.nextInt(21);

        switch (n) {
            case 1: // Good
                answer = "It is certain";
                break;
            case 2:
                answer = "It is decidedly so";
                break;
            case 3:
                answer = "Without a doubt";
                break;
            case 4:
                answer = "Yes definitely";
                break;
            case 5:
                answer = "You may rely on it";
                break;
            case 6:
                answer = "As I see it, yes";
                break;
            case 7:
                answer = "Most likely";
                break;
            case 8:
                answer = "Outlook good";
                break;
            case 9:
                answer = "Yes";
                break;
            case 10:
                answer = "Signs point to yes";
                break;
            case 11: // Ok
                answer = "Reply hazy try again";
                break;
            case 12:
                answer = "Ask again later";
                break;
            case 13:
                answer = "Better not tell you now";
                break;
            case 14:
                answer = "Cannot predict now";
                break;
            case 15:
                answer = "Concentrate and ask again";
                break;
            case 16: // Bad
                answer = "Don't count on it";
                break;
            case 17:
                answer = "My reply is no";
                break;
            case 18:
                answer = "My sources say no";
                break;
            case 19:
                answer = "Outlook not so good";
                break;
            case 20:
                answer = "Very doubtful";
                break;
            default:
                answer = "Time will tell";
        }
    }

    public void setResult(Integer color, Integer number, String question){
        fortune();
        this.secretQuestion = question;
        this.color = color;
        this.number = number;
    }

    public String getAnswer(){
        return answer;
    }

    public String getHoroscopeURL(){
        return horoscopeURL;
    }

    public String getQuestion(){
        return secretQuestion;
    }

    public Integer getColor(){
        return color;
    }

    public Integer getNumber(){
        return number;
    }

}