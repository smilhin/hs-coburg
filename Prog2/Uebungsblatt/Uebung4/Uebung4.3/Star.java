public class Star implements Mobile {

    double weight;
    public Star(double weight) throws IllegalArgumentException {
        if(weight < 1) throw new IllegalArgumentException();
        this.weight = weight;
    }
    @Override
    public double weight() {
        return this.weight;
    }

    @Override
    public void balance() {

    }
    @Override
    public String toString() {
        return "Star[" + this.weight + "]";
    }
}
