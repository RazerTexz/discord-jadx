package com.discord.widgets.nux;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.discord.R;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import kotlin.Metadata;

/* compiled from: GuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\n\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplate;", "", "", "drawableRes", "I", "getDrawableRes", "()I", "titleRes", "getTitleRes", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "templateType", "Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "getTemplateType", "()Lcom/discord/widgets/guilds/create/StockGuildTemplate;", "<init>", "(Ljava/lang/String;IIILcom/discord/widgets/guilds/create/StockGuildTemplate;)V", "CreateMyOwn", "Gaming", "SchoolClub", "StudyGroup", "Friends", "ArtistsAndCreators", "LocalCommunity", "HubStudyGroup", "HubSchoolClub", "Class", NotificationClient.NOTIF_CHANNEL_SOCIAL, "SubjectOrMajor", "Dorm", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplate, reason: use source file name */
/* loaded from: classes2.dex */
public enum GuildTemplates {
    CreateMyOwn(R.string.guild_template_header_create, R.drawable.drawable_guild_template_create, StockGuildTemplate.CREATE),
    Gaming(R.string.guild_template_header_gaming, R.drawable.drawable_guild_template_gaming, StockGuildTemplate.GAMING_GROUP),
    SchoolClub(R.string.guild_template_header_school_club, R.drawable.drawable_guild_template_club, StockGuildTemplate.CLUB),
    StudyGroup(R.string.guild_template_header_study, R.drawable.drawable_guild_template_study, StockGuildTemplate.STUDY_GROUP),
    Friends(R.string.guild_template_header_friend, R.drawable.drawable_guild_template_friend, StockGuildTemplate.FRIEND_GROUP),
    ArtistsAndCreators(R.string.guild_template_header_creator, R.drawable.drawable_guild_template_creator, StockGuildTemplate.CONTENT_CREATOR),
    LocalCommunity(R.string.guild_template_header_community, R.drawable.drawable_guild_template_community, StockGuildTemplate.LOCAL_COMMUNITY),
    HubStudyGroup(R.string.guild_template_header_study, R.drawable.drawable_guild_template_friend, StockGuildTemplate.HUB_STUDY_GROUP),
    HubSchoolClub(R.string.guild_template_header_school_club, R.drawable.drawable_guild_template_community, StockGuildTemplate.HUB_SCHOOL_CLUB),
    Class(R.string.guild_template_header_class, R.drawable.drawable_guild_template_study, StockGuildTemplate.CLASS),
    Social(R.string.guild_template_header_social, R.drawable.drawable_guild_template_gaming, StockGuildTemplate.SOCIAL),
    SubjectOrMajor(R.string.guild_template_header_major, R.drawable.drawable_guild_template_club, StockGuildTemplate.MAJOR),
    Dorm(R.string.guild_template_header_dorm, R.drawable.drawable_guild_template_creator, StockGuildTemplate.DORM);

    private final int drawableRes;
    private final StockGuildTemplate templateType;
    private final int titleRes;

    GuildTemplates(@StringRes int i, @DrawableRes int i2, StockGuildTemplate stockGuildTemplate) {
        this.titleRes = i;
        this.drawableRes = i2;
        this.templateType = stockGuildTemplate;
    }

    public final int getDrawableRes() {
        return this.drawableRes;
    }

    public final StockGuildTemplate getTemplateType() {
        return this.templateType;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }
}
