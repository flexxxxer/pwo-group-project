package pwo.group.app.filestats;

/**
 * @author Aleksandr Kovalyov
 */
public abstract class TypeNamedStatisticalProperty 
        implements IFileStatisticalProperty {

    @Override
    public String GetName() {
        return this.getClass().getSimpleName();
    }
}
