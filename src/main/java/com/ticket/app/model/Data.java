package com.ticket.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Data {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String text;
    private String status="Unresolved";
    private String comment;

    private String ticketDetails;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", status='" + status + '\'' +
                ", comment='" + comment + '\'' +
                ", ticketDetails='" + ticketDetails + '\'' +
                '}';
    }
    public void updateComment(String newComment){
        LocalDate date = LocalDate.now();
        comment = comment +'\n' + "New comment on :  "+ date.toString()+'\n'+newComment;
    }
}
