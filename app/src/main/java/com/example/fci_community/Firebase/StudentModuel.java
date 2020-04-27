package com.example.fci_community.Firebase;

public class StudentModuel {
  private String name;
  private String mail;
  private String passwoard;
  private String  id;

    public StudentModuel() {
    }

    public StudentModuel(String name, String mail,  String passwoard,String id) {
        this.name = name;
        this.mail = mail;

        this.passwoard = passwoard;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    public String getPasswoard() {
        return passwoard;
    }

    public void setPasswoard(String passwoard) {
        this.passwoard = passwoard;
    }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

