package webshop.rate;

import org.springframework.stereotype.Service;
import webshop.CustomResponseStatus;
import webshop.Response;

@Service
public class RateService {
    private RateDao rateDao;

    public RateService(RateDao rateDao) {
        this.rateDao = rateDao;
    }

    private String deleteHTMLelements(String string){
        return string.replaceAll("\\<.*?>","");

    }

    public CustomResponseStatus addRate(Rate rate){
        rate.setMessage(deleteHTMLelements(rate.getMessage()));
        if (rateDao.orderedProductByUser(rate.getProduct(),rate.getUser())) {
            if (!rateDao.getRateForUserAndProduct(rate).isEmpty()) {
                int updateRows = rateDao.updateRate(rate);
                if (updateRows > 0) {
                    return new CustomResponseStatus(Response.SUCCESS, "Rate succesfully updated!");
                }
            }
            long addRows = rateDao.addNewRateAndGetId(rate);
            if (addRows >= 0) {
                return new CustomResponseStatus(Response.SUCCESS, "Rate successfully added!");
            }
            return new CustomResponseStatus(Response.FAILED, "Failed to rate!");
        } else {
            return new CustomResponseStatus(Response.FAILED, "Rate is only possible after the order was delivered.");
        }
    }
}
