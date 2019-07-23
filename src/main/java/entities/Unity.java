package entities;

public enum Unity {
    POUND() {
        public double convertToPound(double quantity) {
            return quantity;
        }
    },
    OUNCE() {
        public double convertToPound(double quantity) {
            return quantity / 16;
        }
    };

    public abstract double convertToPound(double quantity);
    }
