package ru.academits.levshakov.range.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (to <= from) {
            throw new IllegalArgumentException("Конец интревала должен быть больше начала");
        }

        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double enteredNumber) {
        return (enteredNumber >= from) && (enteredNumber <= to);
    }

    public static void print(Range range) {
        if (range == null) {
            System.out.print("null");
        } else {
            System.out.print("(" + range.from + ", " + range.to + ")");
        }
    }

    public static void print(Range[] ranges) {
        boolean printNull = true;

        for (Range element : ranges) {
            if (element != null) {
                Range.print(element);
                printNull = false;
            }
        }

        if (printNull) {
            System.out.print("Null");
        }
    }

    public Range getIntersection(Range range) {
        if ((range.to > this.from && range.to < this.to && range.from <= this.from) || (range.to == this.to && range.from < this.from)) {
            return new Range(this.from, range.to);
        } else if (range.from >= this.from && range.to <= this.to) {
            return new Range(range.from, range.to);
        } else if (range.from < this.from && range.to > this.to) {
            return new Range(this.from, this.to);
        } else if ((range.to >= this.to && range.from < this.to && range.from > this.from) || (range.from == this.from && range.to > this.to)) {
            return new Range(range.from, this.to);
        } else {
            return null;
        }
    }

    public Range[] getUnion(Range range) {
        Range[] intervalsUnion = new Range[2];

        if (range.from <= this.from && range.to >= this.from && range.to < this.to) {
            intervalsUnion[0] = new Range(range.from, this.to);
        } else if (range.from >= this.from && range.to <= this.to) {
            intervalsUnion[0] = new Range(this.from, this.to);
        } else if (range.from <= this.from && range.to >= this.to) {
            intervalsUnion[0] = new Range(range.from, range.to);
        } else if (range.from > this.from && range.from <= this.to && range.to >= this.to) {
            intervalsUnion[0] = new Range(this.from, range.to);
        } else {
            if (range.to < this.from) {
                intervalsUnion[0] = range;
                intervalsUnion[1] = this;
            } else {
                intervalsUnion[0] = this;
                intervalsUnion[1] = range;
            }
        }

        return intervalsUnion;
    }

    public Range[] getComplement(Range range) {
        Range[] intervalsComplement = new Range[2];

        if (range.to <= this.from || range.from >= this.to) {
            intervalsComplement[0] = new Range(this.from, this.to);
        } else if (range.to > this.from && range.to < this.to && range.from <= this.from) {
            intervalsComplement[0] = new Range(range.to, this.to);
        } else if (range.to < this.to && range.from > this.from) {
            intervalsComplement[0] = new Range(this.from, range.from);
            intervalsComplement[1] = new Range(range.to, this.to);
        } else if (range.to >= this.to && range.from < this.to && range.from > this.from) {
            intervalsComplement[0] = new Range(this.from, range.from);
        }
        return intervalsComplement;
    }
}

