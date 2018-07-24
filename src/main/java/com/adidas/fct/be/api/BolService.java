package com.adidas.fct.be.api;

import com.adidas.fct.be.api.base.APIService;
import net.thucydides.core.annotations.Step;

import static java.text.MessageFormat.format;

public class BolService extends APIService {
    static final String BOLBASE = "/bol-service/fct/costingbase";
    @Step
    public BolService getCostingFramework(String id) {
        doGet(format(BOLBASE + "{0}/bol/costingFramework", id));
        return this;
    }
    @Step
    public BolService getCriteriaValues(String data) {
        doGet(format(BOLBASE + "bol/criteriavalues/1/CUT-TO-BOX/{0}", data));
        return this;
    }
    @Step
    public BolService getCuttobox(String id) {
        doGet(format(BOLBASE + "{0}/bol/cuttobox", id));
        return this;
    }
}
