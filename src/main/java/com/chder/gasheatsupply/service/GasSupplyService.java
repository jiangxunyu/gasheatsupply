package com.chder.gasheatsupply.service;

import com.chder.gasheatsupply.model.EnergyConsume;
import com.chder.gasheatsupply.model.GasCost;
import com.chder.gasheatsupply.model.PriceInfo;
import com.chder.gasheatsupply.dto.PriceInfoDto;

import java.util.List;
import java.util.Map;

public interface GasSupplyService{

    List<GasCost> getGasCost(String district,String date);

    Map<String,Object> queryPriceInfo(PriceInfoDto priceInfoDto);

    void addPriceInfo(PriceInfo priceInfo);

    void deletePriceInfo(List<String> ids);

    void addBatchPriceInfo(List<PriceInfo> priceInfos);

    PriceInfo getLatestPriceInfo();

    EnergyConsume expendEnergyData(String district);

    List<GasCost> getIntervalGasCost(String district, String startDate, String endDate);

    Map<String, Double> supplyHeatFigure();
}
