package exercicios.exe3_16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class HeartRates {
    private String firstName;
    private String secondName;
    private int month, day, year;

    public HeartRates(String firstName, String secondName, int month, int day, int year) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int yearsOld(int currentMonth, int currentDay, int currentYear) {
        LocalDate currentDate = LocalDate.of(currentYear, currentMonth, currentDay);
        LocalDate birthday = LocalDate.of(getYear(), getMonth(), getDay());
        //int output = (currentDate-birthday).getYear;
        return 0;

    }
}
