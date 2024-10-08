public class GlitterStar extends Star{

    double weightIncrement = 0.0;
    double newWeight, oldWeight;
    public GlitterStar(double weight) throws IllegalArgumentException {
        super(weight);
        this.newWeight = weight;
        this.oldWeight = weight;
    }
    public void decorate() {
        newWeight++;
        weightIncrement++;
    }

    @Override
    public double weight() {
        return this.newWeight;
    }

    public String toString() {
        return "GlitterStar[" + oldWeight + "+" + weightIncrement + "]";
    }
}
