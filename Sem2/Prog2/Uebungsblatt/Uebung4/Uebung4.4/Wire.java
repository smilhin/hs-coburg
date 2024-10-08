public class Wire implements Mobile {

    double length, length1, length2, weight1, weight2;
    Mobile wire1, wire2;


    public Wire(Mobile wire1, Mobile wire2, double length) {
        this.wire1 = wire1;
        this.wire2 = wire2;
        this.length = length;
        this.length2 = length;
        this.weight1 = wire1.weight();
        this.weight2 = wire2.weight();
    }


    @Override
    public double weight() {
        return weight1 + weight2;
    }

    @Override
    public void balance() {
        wire1.balance();
        wire2.balance();
        length1 = weight2 * length / weight();
        length2 = length - length1;

    }


    @Override
    public String toString() {
        return "Mobile[%.1f:%s, %.1f:%s]".formatted(this.length1, wire1.toString(), this.length2, wire2.toString());
    }

}
