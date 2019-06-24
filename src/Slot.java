public class Slot {

    private Car car;
    private String contColor;
    private String contNo;

    Slot(){
        this.car = null;
        this.contColor = "NoCont";
        this.contNo = "NoCont";
    }

    public boolean contract(Car car){
        if(contNo == "NoCont"){
            contColor = car.getColor();
            contNo = car.getNo();
            return true;
        }

        return false;
    }

    public void cancel(){
        contColor = "NoCont";
        contNo = "NoCont";
    }

    public boolean carIn(Car car){
        if(this.car != null){
            return false;
        }

        this.car = car;
        return true;
    }

    public Car carOut(){
        Car car = this.car;
        this.car = null;
        return car;
    }

    public boolean check(){
        if(car == null){
            return true;
        }

        if(car.getColor() == contColor && car.getNo() == contNo){
            return true;
        }

        return false;
    }

    @Override
    public String toString(){
        String res = null;
        if(car != null){
            res = car.getNo() + "(" + car.getColor() + "): " + contNo + "(" + contColor + ")";
        }else{
            res = "no car: " + contNo + "(" + contColor + ")";
        }
        return res;
    }
}
