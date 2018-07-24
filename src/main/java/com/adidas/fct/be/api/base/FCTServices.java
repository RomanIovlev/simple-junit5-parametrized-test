package com.adidas.fct.be.api.base;

import com.adidas.fct.be.api.BolService;
import com.adidas.fct.be.api.CostingService;
import net.thucydides.core.annotations.Steps;

public class FCTServices {
    @Steps public static BolService bolService = new BolService();
    @Steps public static CostingService costingService = new CostingService();
}
