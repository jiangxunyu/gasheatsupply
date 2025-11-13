package com.chder.gasheatsupply.service;

import com.chder.gasheatsupply.model.HeatLoadEnergyConsume;
import com.chder.gasheatsupply.model.LoadOptimizeForecastParams;

import java.util.HashMap;

public interface HeatLoadService {
    HeatLoadEnergyConsume loadOptimizeAllotCalculate(LoadOptimizeForecastParams forecastParams);

    HashMap<String, Object> getHistoryForecastDataCache();

}
