package jp.yuiki.dev.qiita4jv2;

public class QiitaFactory {
    /**
     * Returns the new Qiita:Team instance.
     *
     * @param teamId the Qiita:Team identifier
     * @return the new Qiita:Team instance
     */
    static Qiita getInstance(String teamId) {
        return new QiitaImpl(teamId);
    }

    /**
     * Returns the new Qiita instance.
     *
     * @return the new Qiita instance
     */
    static Qiita getInstance() {
        return new QiitaImpl();
    }
}
