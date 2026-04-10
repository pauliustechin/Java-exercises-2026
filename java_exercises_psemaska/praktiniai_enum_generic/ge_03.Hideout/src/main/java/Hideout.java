public class Hideout<T> {

    private boolean inHideout;
    private T hideoutValue;

    public Hideout() {
        inHideout = false;
        hideoutValue = null;
    }

    public void putIntoHideout(T toHide) {
        hideoutValue = toHide;
        inHideout = true;
    }

    public T takeFromHideout() {
        inHideout = false;
        return hideoutValue;
    }

    public boolean isInHideout() {
        return inHideout;
    }
}
