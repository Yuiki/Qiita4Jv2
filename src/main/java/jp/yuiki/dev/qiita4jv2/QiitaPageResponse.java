package jp.yuiki.dev.qiita4jv2;

public class QiitaPageResponse<E> {
    /**
     * The got entity
     */
    private final E entity;

    /**
     * The total entity count
     */
    private final long totalCount;

    /**
     * The qiita rate reset time(Epoch)
     */
    private final long rateResetEpochTime;

    /**
     * The qiita rate limit count
     */
    private final long rateLimitCount;

    /**
     * The qiita rate remaining count
     */
    private final long rateRemainingCount;

    public QiitaPageResponse(E entity, long totalCount, long rateResetEpochTime, long rateLimitCount, long rateRemainingCount) {
        this.entity = entity;
        this.totalCount = totalCount;
        this.rateResetEpochTime = rateResetEpochTime;
        this.rateLimitCount = rateLimitCount;
        this.rateRemainingCount = rateRemainingCount;
    }

    public E getEntity() {
        return entity;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getRateResetEpochTime() {
        return rateResetEpochTime;
    }

    public long getRateLimitCount() {
        return rateLimitCount;
    }

    public long getRateRemainingCount() {
        return rateRemainingCount;
    }
}
