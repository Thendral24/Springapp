package net.javaguides.springbootbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "center_name")
    private String centername;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "address")
    private String address;
    @Column(name = "image_url")
    private String imageurl;
    @Column(name = "e_mail")
    private String email;

    public Center() {

    }
    
    public Center(String centername, String phonenumber, String address, String imageurl, String email,
            String description) {
        super();
        this.centername = centername;
        this.phonenumber = phonenumber;
        this.address = address;
        this.imageurl = imageurl;
        this.email = email;
        this.description = description;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCentername() {
        return centername;
    }
    public void setCentername(String centername) {
        this.centername = centername;
    }
    public String getPhonenumber() {
        return phonenumber;
    }
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getImageurl() {
        return imageurl;
    }
    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    private String description; 
}
