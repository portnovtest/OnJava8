package enums;

// Switching one enum on another
public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
