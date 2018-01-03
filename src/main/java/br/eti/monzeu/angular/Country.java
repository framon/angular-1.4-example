package br.eti.monzeu.angular;

public class Country {

    /** ISO 3166-1 alpha-3 */
    private String geoCode;
    private String name;

    public Country(String geoCode, String name) {
        super();
        setGeoCode(geoCode);
        setName(name);
    }

    public String getGeoCode() {
        return geoCode;
    }

    private void setGeoCode(String geoCode) {
        geoCode = geoCode == null ? geoCode : geoCode.trim();

        if (geoCode == null || geoCode.isEmpty()) {
            throw new IllegalArgumentException("[geoCode] can not be null");
        }

        this.geoCode = geoCode.trim();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        name = name == null ? name : name.trim();

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("[name] can not be null");
        }

        this.name = name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((geoCode == null) ? 0 : geoCode.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Country other = (Country) obj;

        if (geoCode == null) {
            if (other.geoCode != null) {
                return false;
            }

        } else if (!geoCode.equals(other.geoCode)) {
            return false;
        }

        return true;
    }

}
