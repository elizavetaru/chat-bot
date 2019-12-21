package by.bsu.samples.microservice.telegram.model;


public class Question  {
    Question(){}

    private Long id;



    private String text;

    public Question(Long id, String text){
        this.id = id;
        this.text = text;
    }
}
