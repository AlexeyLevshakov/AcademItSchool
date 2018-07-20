package ru.academits.levshakov.range.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        if (to < from) {
            this.from = to;
            this.to = from;
        } else {
            this.from = from;
            this.to = to;
        }
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

    public void print() {
        if (this == null) {
            System.out.println("null");
        } else {
            System.out.println("(" + this.from + ", " + this.to + ")");
        }
    }

    public Range getIntersection(Range range) {
        if (this.from <= range.from && this.to >= range.getTo()) {
            return new Range(range.getFrom(), range.getTo());
        } else if (this.from >= range.getFrom() && this.to <= range.getTo()) {
            return new Range(this.from, this.to);
        } else if (range.getFrom() <= this.from && range.getTo() <= this.to) {
            return new Range(this.from, range.getTo());
        } else if (range.getFrom() >= this.from && range.getTo() >= this.to) {
            return new Range(range.getFrom(), this.to);
        } else {
            return null;
        }
    }
}

