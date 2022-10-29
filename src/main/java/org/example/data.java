package org.example;

public class data {
    private data parameter;
    private data lat;
    private data lon;
    private data date;
    private data value;



    public void setParameter(data parameter){

        this.parameter = parameter;
    }
    public data getParameter()
    {
        return this.parameter;
    }

    public void setLat(data lat){
        this.lat = lat;
    }

    public data getLat(){
        return this.lat;
    }

    public void setLon(data lon){
        this.lon = lon;
    }
    public data getLon(){
        return this.lon;
    }

    public void setDate(data date){
        this.date = date;
    }
    public data getDate(){
        return this.date;
    }

    public void setValue(data value){
        this.value = value;
    }
    public data getValue(){
        return this.value;
    }
}
