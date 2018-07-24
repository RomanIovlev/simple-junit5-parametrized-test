package com.adidas.fct.be.api;

import com.adidas.fct.be.api.base.APIService;
import net.thucydides.core.annotations.Step;

import static java.text.MessageFormat.format;

public class CostingService extends APIService {
    static final String COSTINGBASE = "/costing-service/fct/costingbase/";
    @Step
    public CostingService postEnrich(String id) {
        doPost(format(COSTINGBASE + "{0}/postEnrich", id));
        return this;
    }
    @Step
    public CostingService getCostingBase() {
        doGet(format(COSTINGBASE));
        return this;
    }
    @Step
    public CostingService getArticleBase(String id) {
        doGet(format(COSTINGBASE + "{0}/articlebase", id));
        return this;
    }
}
