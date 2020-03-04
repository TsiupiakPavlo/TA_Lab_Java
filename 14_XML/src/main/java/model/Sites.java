package model;

import model.enums.SiteType;

import java.util.List;
import java.util.Objects;

public class Sites {
    private String title;
    private SiteType siteType;
    private List<Chars> chars;
    private boolean authAccess;

    public Sites() {
    }

    public Sites(String title, SiteType siteType, List<Chars> chars, boolean authAccess) {
        this.title = title;
        this.siteType = siteType;
        this.chars = chars;
        this.authAccess = authAccess;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SiteType getSiteType() {
        return siteType;
    }

    public void setSiteType(SiteType siteType) {
        this.siteType = siteType;
    }

    public void setSiteType(String siteType) {
        if (siteType.toUpperCase().equals("ADVERTISING")) {
            this.siteType = SiteType.ADVERTISING;
        } else if (siteType.toUpperCase().equals("NEWS")) {
            this.siteType = SiteType.NEWS;
        } else if (siteType.toUpperCase().equals("PORTAL")) {
            this.siteType = SiteType.PORTAL;
        } else if (siteType.toUpperCase().equals("MIRROR")) {
            this.siteType = SiteType.MIRROR;
        } else {
            throw new ClassCastException();
        }
    }

    public List<Chars> getChars() {
        return chars;
    }

    public void setChars(List<Chars> chars) {
        this.chars = chars;
    }

    public boolean isAuthAccess() {
        return authAccess;
    }

    public void setAuthAccess(boolean authAccess) {
        this.authAccess = authAccess;
    }

    @Override
    public String toString() {
        return "Sites{" +
                "title='" + title + '\'' +
                ", siteType=" + siteType +
                ", chars=" + chars +
                ", authAccess=" + authAccess +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sites)) return false;
        Sites sites = (Sites) o;
        return isAuthAccess() == sites.isAuthAccess() &&
                getTitle().equals(sites.getTitle()) &&
                getSiteType() == sites.getSiteType() &&
                getChars().equals(sites.getChars());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getSiteType(), getChars(), isAuthAccess());
    }
}
