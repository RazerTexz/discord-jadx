package com.discord.widgets.nux;

import d0.t.Collections2;
import java.util.List;
import kotlin.Metadata;

/* compiled from: GuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/discord/widgets/nux/GuildTemplateTypes;", "", "", "Lcom/discord/widgets/nux/GuildTemplate;", "NUX", "Ljava/util/List;", "getNUX", "()Ljava/util/List;", "HUB", "getHUB", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.GuildTemplateTypes, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildTemplates2 {
    public static final GuildTemplates2 INSTANCE = new GuildTemplates2();
    private static final List<GuildTemplates> NUX = Collections2.listOf((Object[]) new GuildTemplates[]{GuildTemplates.Gaming, GuildTemplates.SchoolClub, GuildTemplates.StudyGroup, GuildTemplates.Friends, GuildTemplates.ArtistsAndCreators, GuildTemplates.LocalCommunity});
    private static final List<GuildTemplates> HUB = Collections2.listOf((Object[]) new GuildTemplates[]{GuildTemplates.HubStudyGroup, GuildTemplates.HubSchoolClub, GuildTemplates.Class, GuildTemplates.Social, GuildTemplates.SubjectOrMajor, GuildTemplates.Dorm});

    private GuildTemplates2() {
    }

    public final List<GuildTemplates> getHUB() {
        return HUB;
    }

    public final List<GuildTemplates> getNUX() {
        return NUX;
    }
}
