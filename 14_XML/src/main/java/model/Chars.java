package model;

import model.enums.Vote;

import java.util.Objects;

public class Chars {
    private boolean mailPresence;
    private boolean newsPresence;
    private boolean archivePresence;
    private Vote vote;
    private boolean payment;

    public boolean isMailPresence() {
        return mailPresence;
    }

    public void setMailPresence(boolean mailPresence) {
        this.mailPresence = mailPresence;
    }

    public boolean isNewsPresence() {
        return newsPresence;
    }

    public void setNewsPresence(boolean newsPresence) {
        this.newsPresence = newsPresence;
    }

    public boolean isArchivePresence() {
        return archivePresence;
    }

    public void setArchivePresence(boolean archivePresence) {
        this.archivePresence = archivePresence;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public void setVote(String vote) {
        if (vote.toUpperCase().equals("YES")) {
            this.vote = Vote.YES;
        } else if (vote.toUpperCase().equals("NO")) {
            this.vote = Vote.NO;
        } else {
            throw new ClassCastException();
        }
    }

    public boolean isPayment() {
        return payment;
    }

    public void setPayment(boolean payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Chars{" +
                "mailPresence=" + mailPresence +
                ", newsPresence=" + newsPresence +
                ", archivePresence=" + archivePresence +
                ", vote=" + vote +
                ", payment=" + payment +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chars)) return false;
        Chars chars = (Chars) o;
        return isMailPresence() == chars.isMailPresence() &&
                isNewsPresence() == chars.isNewsPresence() &&
                isArchivePresence() == chars.isArchivePresence() &&
                isPayment() == chars.isPayment() &&
                getVote() == chars.getVote();
    }

    @Override
    public int hashCode() {
        return Objects.hash(isMailPresence(), isNewsPresence(), isArchivePresence(), getVote(), isPayment());
    }
}
