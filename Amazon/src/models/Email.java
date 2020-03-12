package models;

public class Email {
    private String _Email;
    private int _idEmail;

    public String get_Email() {
        return _Email;
    }
    public void set_Email(String _Email) {
        this._Email = _Email;
    }
    public int get_idEmail() {
        return _idEmail;
    }
    public void set_idEmail(int _idEmail) {
        this._idEmail = _idEmail;
    }

    public Email (){
        this("",0);
    }
    public Email(String email, int idEmail){
        this.set_Email(email);
        this.set_idEmail(idEmail);
    }
}
