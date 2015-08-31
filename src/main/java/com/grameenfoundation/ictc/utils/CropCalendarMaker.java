/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grameenfoundation.ictc.utils;

import com.grameenfoundation.ictc.models.CropCalendarModel;
import com.grameenfoundation.ictc.models.CropCalendarSettingModel;
import com.grameenfoundation.ictc.wrapper.CropCalendarSettingWrapper;
import com.grameenfoundation.ictc.wrapper.CropCalendarWrapper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * y
 *
 * @author skwakwa
 */
public class CropCalendarMaker {

    public List<CropCalendarWrapper> generateCropCalendar(String farmerId, String crop, Date referenceDate) {
        List<CropCalendarWrapper> myCropCalendar = new ArrayList<>();
        List<CropCalendarSettingWrapper> cropCal = new CropCalendarSettingModel().getSettingByCrop(crop);
        int cnt = 0;
        for (CropCalendarSettingWrapper cropCal1 : cropCal) {
            Calendar today = Calendar.getInstance();
            List<Date> dates = getSundayInWeek(referenceDate, cropCal1.getStartWeek(), cropCal1.getEndWeek());
            CropCalendarWrapper cal = new CropCalendarWrapper();
            cal.setActivity(cropCal1.getActivity());
            cal.setActivityIndex(cnt);
            cal.setComment("");
            cal.setEarliestDate(dates.get(0));
            cal.setLatestDate(dates.get(1));
            cal.setWeeksFromPlanting(cropCal1.getStartWeek());
            cal.setSeason("".concat(today.get(Calendar.YEAR) + "").concat("01"));
            cal.setFarmerId(farmerId);
            myCropCalendar.add(cal);
        }
        return myCropCalendar;

    }

    public List<CropCalendarWrapper> generateCropCalendarAndSave(String farmerId, String crop, Date referenceDate) {

        CropCalendarModel cropCalendarModel = new CropCalendarModel();
        List<CropCalendarWrapper> myCal = generateCropCalendar(farmerId, crop, referenceDate);

        for (CropCalendarWrapper myCal1 : myCal) {
            cropCalendarModel.create(myCal1);
        }
        return myCal;
    }

    public List<Date> getSundayInWeek(Date reference, int weeksBack, int endWeek) {
        List<Date> dates = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(reference);
        int daysToSunday = (cal.get(Calendar.DAY_OF_WEEK)) - 1;
        cal.add(Calendar.DATE, (weeksBack * 7) + daysToSunday);
        dates.add(cal.getTime());//Sunday earliest start date
        cal.add(Calendar.DATE, 6 + (weeksBack - endWeek));
        dates.add(cal.getTime());//Saturday
        return dates;
    }
}
