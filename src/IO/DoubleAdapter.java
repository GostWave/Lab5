package IO;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DoubleAdapter extends XmlAdapter<String, Double> {
    @Override
    public Double unmarshal(String v) {
        try {
            Double value = Double.parseDouble(v);
            if (Double.isNaN(value) || Double.isInfinite(value)) {
                return null;
            } else {
                return value;
            }
        } catch (NumberFormatException e) {
            return null; // Если число некорректное, вернём null
        }
    }

    @Override
    public String marshal(Double v) {
        if (v != null) {
            return v.toString();
        } else {
            return null;
        }
    }
}
