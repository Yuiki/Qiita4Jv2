package jp.yuiki.dev.qiita4jv2;

import jp.yuiki.dev.qiita4jv2.resources.*;

public interface Qiita extends AuthorizeResources,
        SupportsOAuth,
        LikesResources,
        AccessTokensResources,
        CommentsResources,
        TaggingsResources,
        TagsResources,
        TeamsResources,
        TemplatesResources,
        ProjectsResources,
        UsersResources,
        ExpandedTemplatesResources,
        ItemsResources,
        ReactionsResources,
        AuthenticatedUserResources {
}