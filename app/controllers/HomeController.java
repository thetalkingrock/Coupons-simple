package controllers;

import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import models.Coupon;
import play.mvc.*;
import com.avaje.ebean.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import static play.libs.Json.toJson;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {


    @Inject
    private FormFactory formFactory;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result addCoupon()
    {
        Form<Coupon> userForm = formFactory.form(Coupon.class);
        Coupon coupon = userForm.bindFromRequest().get();
        coupon.save();
        //return ok("Coupon: " + coupon.name);
        return redirect(routes.HomeController.index());
    }


    public Result getCoupons() {
        Model.Finder<Integer, Coupon> finder = new Model.Finder<>(Coupon.class);
        List<Coupon> coupons = finder.all();
        return ok(toJson(coupons));
    }
}
