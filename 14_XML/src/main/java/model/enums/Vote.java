package model.enums;

public enum Vote {
    YES(VoteType.REGISTER),
    NO(VoteType.ANON);

    private final VoteType voteType;

    Vote(VoteType voteType) {
        this.voteType = voteType;
    }

    public VoteType getVoteType() {
        return voteType;
    }
}
