package models;


import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon extends Model
{
    @Id
    private Integer id;

    public String name;

    private String description;

    private String promocode;

    private float discountRate;

    /**
     * Date serialized as string
     */
    private String expirationDate;

    /**
     * Email address of business
     */
    private String bemail;


    public Coupon(Integer id, String name, String description, String promoCode, float discountRate, String expirationDate, String bemail)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.promocode = promoCode;
        this.discountRate = discountRate;
        this.expirationDate = expirationDate;
        this.bemail = bemail;
    }
}
