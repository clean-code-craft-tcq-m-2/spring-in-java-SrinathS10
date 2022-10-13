package statisticker;

public class EmailAlert implements IAlerter {

    public boolean emailSent;

    @Override
    public void trigger() {
        this.emailSent = true;
    }

}
