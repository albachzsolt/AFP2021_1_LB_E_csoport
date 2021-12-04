package webshop.rate;

import org.springframework.stereotype.Service;

@Service
public class RateService {
    private RateDao rateDao;

    public RateService(RateDao rateDao) {
        this.rateDao = rateDao;
    }
}
