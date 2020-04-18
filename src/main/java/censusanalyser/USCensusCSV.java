package censusanalyser;

import com.opencsv.bean.CsvBindByName;

public class USCensusCSV {
    @CsvBindByName(column = "State Id")
    private String stateID;

    @CsvBindByName(column = "State")
    private String state;

    @CsvBindByName(column = "Population Density")
    private int populationDensity;

    @CsvBindByName(column = "Population")
    private int population;

    @CsvBindByName(column = "Total area")
    private int area;

    @CsvBindByName(column = "Housing units")
    private String housingUnits;

    @CsvBindByName(column = "Water area")
    private String waterArea;

    @CsvBindByName(column = "Land Area")
    private String landArea;

    @CsvBindByName(column = "Housing Density")
    private String housingDensity;

    public USCensusCSV() {
    }

    public USCensusCSV(String stateID, String state, int population, int areaInSqKm, int densityPerSqKm) {
        this.stateID = stateID;
        this.state = state;
        this.population = population;
        this.area = areaInSqKm;
        this.populationDensity = densityPerSqKm;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(int populationDensity) {
        this.populationDensity = populationDensity;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getHousingUnits() {
        return housingUnits;
    }

    public void setHousingUnits(String housingUnits) {
        this.housingUnits = housingUnits;
    }

    public String getWaterArea() {
        return waterArea;
    }

    public void setWaterArea(String waterArea) {
        this.waterArea = waterArea;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public String getHousingDensity() {
        return housingDensity;
    }

    public void setHousingDensity(String housingDensity) {
        this.housingDensity = housingDensity;
    }
}
