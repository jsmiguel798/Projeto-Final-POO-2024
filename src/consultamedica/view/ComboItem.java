package consultamedica.view;

// classe que vai ser o item de uma combobox
public class ComboItem
{
    private String id;
    private String value;

    public ComboItem(String id, String value)
    {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return id;
    }

    public String getId()
    {
        return id;
    }

    public String getValue()
    {
        return value;
    }
}