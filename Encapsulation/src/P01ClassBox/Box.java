package P01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        validateSide(length);
        this.length = length;
    }

    private void setWidth(double width) {
        validateSide(width);
        this.width = width;
    }

    private void setHeight(double height) {
        validateSide(height);
        this.height = height;
    }
    private void validateSide(double side){
       if (side <= 0){
           throw new IllegalStateException("Width cannot be zero or negative.");
       }
    }
    public double calculateSurfaceArea (){
        return (2 * this.length * this.width) + (2 * this.length*this.height) + (2 * this.width * height);
    }
    public double calculateLateralSurfaceArea (){
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }
    public double calculateVolume (){
        return this.length * this.width * this.height;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume – %.2f",
                calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }
}
